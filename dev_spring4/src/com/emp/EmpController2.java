package com.emp;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.util.DayTime;
import com.util.HangulConversion;
import com.vo.EmpVO;

@Controller
@RequestMapping(value="/emp")
public class EmpController2 {
	Logger logger = Logger.getLogger(EmpController2.class);
	@Autowired
	public EmpLogic2 empLogic=null; //스프링 컨테이너로 부터 주입받아서
	//nullpionter안일어남
	/******************************************************************************
	 * 스프링 API를 이용해서 첨부 파일 처리 테스트 샘플
	 * @param pMap
	 * @param imgFile
	 * @return
	***************************************************************************** */
	@RequestMapping(value="uploadFile.kosmo")
	public String uploadFile(ModelMap pMap,@RequestParam("imgFile") MultipartFile imgFile){
		logger.info("uploadFile호출 성공");
		String fileName =
				HangulConversion.toKor(imgFile.getOriginalFilename());
		
		logger.info("fileName"+fileName);
		String path="C:\\Users\\azaza\\Desktop\\dev_lab\\dev_spring4\\WebContent\\pds\\";
		//첨부파일 중복처리하기 -파일 history관리
		//test.zip ->test_20170210161910.zip
		//1)파일 이름만 떼어내기(test)
		String onlyFileName = fileName.substring(0,fileName.indexOf("."));
		logger.info("onlyFileName:"+onlyFileName);
		//2)확장자만 떼어내기(.zip)
		String extension = fileName.substring(fileName.indexOf("."));
		//3)파일이름 재정의하기
		String rename = onlyFileName+"_"+DayTime.getCurrentDayTime()+extension;
		pMap.addAttribute("rename",rename);
		if(imgFile !=null){//첨부파일 추가했니?
			//실제로 존재하는 파일 이름을 객체로 생성해주는 클래스
			File file =new File(path+fileName);
			try {
				byte[] bytes =imgFile.getBytes(); //123
				BufferedOutputStream bos
				=new BufferedOutputStream(
						new FileOutputStream(file));
				bos.write(bytes);//123출력
				bos.close();
			} catch (Exception e) {
				logger.info(e.toString());
			}
		}
		return "forward:fileDownload.jsp?imgFile="+fileName;
	}
	/*******************************************************************************
	 * 업무명: 사원목록 조회 구현
	 * @param: Map<String,Object>
	 * @return: redirect:getEmpList.jsp
	 *******************************************************************************/
	@RequestMapping(value="getEmpList.kosmo")
	public String getEmpList(ModelMap rMap,@RequestParam Map<String,Object>pMap)
	{
		logger.info("getEmpList 호출 성공");
		//empLogic클래스에 대한 초기화가 null로 되어 있으나 NullPointerException은
		//발생하지 않는다
		//필요한 시점에 스프링컨테이너 에서 xml문서에 등록된 객체를 관리하고 있다가
		//메모리에 올려주기 때문이다.
		List<EmpVO>empList=null;
		empList=empLogic.getEmpList(pMap);
		rMap.addAttribute("empList",empList);
		return "forward:jSomEmpList.jsp";
	}
	/*******************************************************************************
	 * 업무명: 사원목록 조회 구현-점 조건으로 조회하기 구현 실습(MyBatis에서
	 * 제공하는 API적용)
	 * @param: Map<String,Object>
	 * @return: redirect:getEmpList.jsp
	 *******************************************************************************/
	@RequestMapping(value="getEmpList2.kosmo")
	public String getEmpList2(ModelMap rMap,@RequestParam Map<String,Object>pMap)
	{
		logger.info("getEmpList2 호출 성공");
		List<EmpVO>empList=null;
		//pMap에는 어떤 정보가 담겨 있는가?
		//key:deptno,value:10,30,40
		empList=empLogic.getEmpList2(pMap);
		rMap.addAttribute("empList",empList);
		return "forward:jSomEmpList.jsp";
	}
	/*********************************************************************************
	 * 사원정보 삭제하기 구현
	 * @param pMap
	 * @return
	******************************************************************************** */
/*	@RequestMapping(value="empDelete.kosmo")
	public String empDelelte(@RequestParam Map<String,Object>pMap){
		logger.info("empDelete 호출 성공");
		int result=0;
		result=empLogic.emptDelete(pMap);
		logger.info("result"+result);
		return"redirect:getEmpList.jsp?result="+result;
}*/
	/******************************************************************************
	 * 사원정보 삭제하기 구현2
	 * @param EmpVO
	 * @return int
	 ******************************************************************************/
	@RequestMapping(value="empDelete.kosmo")
	public String empDelete(@ModelAttribute EmpVO eVO){
		logger.info("empDelete호출 성공");
		int result =0;
		String pempno = eVO.getEmpnos();
		result=empLogic.empDelete(pempno);
		return "redirect:getEmpList.jsp";
	}
}
