package com.mvc;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.util.DayTime;
import com.util.HangulConversion;
import com.vo.EmpVO;
@Controller
@RequestMapping(value="/emp")
public class EmpController{
	Logger logger = Logger.getLogger(EmpController.class);
	@Autowired   
	public EmpLogic empLogic = null;
	@RequestMapping(value="proc_salupdate.kosmo")
	public String proc_salupdate(ModelMap mMap,EmpVO eVO){
		String msg =empLogic.proc_salupdate(eVO);
		logger.info("프로시저에서 out속성에 담은 값:"+msg);
		mMap.addAttribute("msg",msg);
		return "forward:proc_salupdateReport.jsp";
	}
	/*************************************************************************************
	 * 사원 정보 수정하기 구현
	 * @param EmpVO
	 * @return String : jSonEmpList.jsp
	 * 이동페이지 이름 : getEmpList.jsp
	 * @ModelAttribute VO를 사용할 때 - request.getParameter()대신 사용한다.
	 * @RequestParam Map를 사용할 때 - Map<String,Object>
	 * @RequestParam 파일 첨부할 때
	 ************************************************************************************/
	@RequestMapping(value="empUpdate.kosmo")
	public String empUpdate(@ModelAttribute EmpVO eVO){
	// /WEB-INF/jsp/getEmpList.kosmo.jsp	
		logger.info("empno:"+eVO.getEmpno());
		logger.info("deptno:"+eVO.getDeptno());
		int result = 0;
		result = empLogic.empUpdate(eVO);//result:1 입력 성공, 0이면 입력 실패
		return "redirect:getEmpList.jsp";
	}
	/*************************************************************************************
	 * 사원 정보 등록하기 구현
	 * @param EmpVO
	 * @return String : jSonEmpList.jsp
	 * 이동페이지 이름 : getEmpList.jsp
	 * @ModelAttribute VO를 사용할 때 - request.getParameter()대신 사용한다.
	 * @RequestParam Map를 사용할 때 - Map<String,Object>
	 * @RequestParam 파일 첨부할 때
	 ************************************************************************************/
	@RequestMapping(value="empInsert.kosmo")
	public String empInsert(@ModelAttribute EmpVO eVO){
	// /WEB-INF/jsp/getEmpList.kosmo.jsp	
		logger.info("empno:"+eVO.getEmpno());
		logger.info("ename:"+eVO.getEname());
		logger.info("deptno:"+eVO.getDeptno());
		int result = 0;
		result = empLogic.empInsert(eVO);//result:1 입력 성공, 0이면 입력 실패
		return "redirect:getEmpList.jsp";
	}
	/*************************************************************************************
	 * 사원 정보 삭제하기 구현
	 * @param EmpVO
	 * @return int
	 * 작성자 : 김용관
	 * 수정 내용 : 코멘트 - 2017년 2월 14 업무변경에 따른 수정
	 *************************************************************************************/
	@RequestMapping(value="empDelete.kosmo")
	public String empDelete(@ModelAttribute EmpVO eVO){
		int result = 0;
		String pempno = eVO.getEmpnos();
		result = empLogic.empDelete(pempno);
		return "redirect:./getEmpList.jsp";
	}
	/*************************************************************************************
	 * 스프링API를 이용해서 첨부 파일 처리 테스트 샘플
	 * @param pMap
	 * @param imgFile
	 * @return
	 ************************************************************************************/
	@RequestMapping(value="uploadFile.kosmo")
	public String uploadFile(ModelMap pMap,@RequestParam("imgFile") MultipartFile imgFile){
		logger.info("uploadFile 호출 성공");
		String fileName = HangulConversion.toKor
							(imgFile.getOriginalFilename());
		logger.info("fileName:"+fileName);
		String path = "E:\\dev_lab\\dev_spring4\\WebContent\\pds\\";
//		첨부파일 중복처리하기 - 파일 history관리
//      test.zip -> test_20170210161910.zip	
		//1)파일이름만 떼어내기(test)
		String onlyFileName = 
				fileName.substring(0, fileName.indexOf("."));
		logger.info("onlyFileName : "+onlyFileName);
		//2)확장자만 떼어내기(.zip)
		String extension = fileName.substring(fileName.indexOf("."));
		//3)파일이름 재정의하기
		String rename = onlyFileName+"_"+DayTime.getCurrentDayTime()+extension;
		pMap.addAttribute("rename", rename);
		if(imgFile !=null){//첨부파일 추가했니?
			//실제 존재하는 파일이름을 객체로 생성해주는 클래스
			//파일에 들어있는 내용까지 생성되는 것은 아니다.
			File file = new File(path+rename);
			try {
				byte[] bytes = imgFile.getBytes();//123
				BufferedOutputStream bos
				=new BufferedOutputStream(
					new FileOutputStream(file));
				bos.write(bytes);//123출력
				bos.close();
			} catch (Exception e) {
				logger.info(e.toString());
			}
		}
		return "forward:fileDownload.jsp";
	}
	/*************************************************************************************
	 * 업무명 : 사원목록 조회 구현
	 * @param  : Map<String,Object> 
	 * @return : redirect:getEmpList.jsp
	 *************************************************************************************/
	@RequestMapping(value="getEmpList.kosmo")
	public String getEmpList(ModelMap rMap, @RequestParam Map<String,Object> pMap)
	{
		logger.info("getEmpList 호출 성공");
	//EmpLogic클래스에 대한 초기화가 null로 되어 있으나 NullPointerException은 발생하지
	//않음.
	//왜냐하면 필요한 시점에 스프링컨테이너에서 xml문서에 등록된 객체를 관리하고 있다가
	//메모리에 올려주기 때문이다.
		List<EmpVO> empList = null;
		empList = empLogic.getEmpList(pMap);
		logger.info("size:"+empList.size());
		rMap.addAttribute("empList", empList);
		return "forward:jSonEmpList.jsp";
	}
	/*************************************************************************************
	 * 업무명 : 사원목록 조회 구현 - 점조건으로 조회하기 구현실습(myBatis에서 제공하는 API적용)
	 * @param  : Map<String,Object> 
	 * @return : redirect:getEmpList.jsp
	 *************************************************************************************/
	@RequestMapping(value="getEmpList2.kosmo")
	public String getEmpList2(ModelMap rMap, @RequestParam Map<String,Object> pMap)
	{
		logger.info("getEmpList2 호출 성공");
	//EmpLogic클래스에 대한 초기화가 null로 되어 있으나 NullPointerException은 발생하지
	//않음.
	//왜냐하면 필요한 시점에 스프링컨테이너에서 xml문서에 등록된 객체를 관리하고 있다가
	//메모리에 올려주기 때문이다.
		List<EmpVO> empList = null;
		//질문 : pMap에는 어떤 정보가 담겨 있을까요? - 10,30,40
		//key:deptno, value:10,30,40
		empList = empLogic.getEmpList(pMap);
		logger.info("size:"+empList.size());
		rMap.addAttribute("empList", empList);
		return "forward:jSonEmpList.jsp";
	}	
}





