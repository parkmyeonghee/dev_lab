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
		logger.info("���ν������� out�Ӽ��� ���� ��:"+msg);
		mMap.addAttribute("msg",msg);
		return "forward:proc_salupdateReport.jsp";
	}
	/*************************************************************************************
	 * ��� ���� �����ϱ� ����
	 * @param EmpVO
	 * @return String : jSonEmpList.jsp
	 * �̵������� �̸� : getEmpList.jsp
	 * @ModelAttribute VO�� ����� �� - request.getParameter()��� ����Ѵ�.
	 * @RequestParam Map�� ����� �� - Map<String,Object>
	 * @RequestParam ���� ÷���� ��
	 ************************************************************************************/
	@RequestMapping(value="empUpdate.kosmo")
	public String empUpdate(@ModelAttribute EmpVO eVO){
	// /WEB-INF/jsp/getEmpList.kosmo.jsp	
		logger.info("empno:"+eVO.getEmpno());
		logger.info("deptno:"+eVO.getDeptno());
		int result = 0;
		result = empLogic.empUpdate(eVO);//result:1 �Է� ����, 0�̸� �Է� ����
		return "redirect:getEmpList.jsp";
	}
	/*************************************************************************************
	 * ��� ���� ����ϱ� ����
	 * @param EmpVO
	 * @return String : jSonEmpList.jsp
	 * �̵������� �̸� : getEmpList.jsp
	 * @ModelAttribute VO�� ����� �� - request.getParameter()��� ����Ѵ�.
	 * @RequestParam Map�� ����� �� - Map<String,Object>
	 * @RequestParam ���� ÷���� ��
	 ************************************************************************************/
	@RequestMapping(value="empInsert.kosmo")
	public String empInsert(@ModelAttribute EmpVO eVO){
	// /WEB-INF/jsp/getEmpList.kosmo.jsp	
		logger.info("empno:"+eVO.getEmpno());
		logger.info("ename:"+eVO.getEname());
		logger.info("deptno:"+eVO.getDeptno());
		int result = 0;
		result = empLogic.empInsert(eVO);//result:1 �Է� ����, 0�̸� �Է� ����
		return "redirect:getEmpList.jsp";
	}
	/*************************************************************************************
	 * ��� ���� �����ϱ� ����
	 * @param EmpVO
	 * @return int
	 * �ۼ��� : ����
	 * ���� ���� : �ڸ�Ʈ - 2017�� 2�� 14 �������濡 ���� ����
	 *************************************************************************************/
	@RequestMapping(value="empDelete.kosmo")
	public String empDelete(@ModelAttribute EmpVO eVO){
		int result = 0;
		String pempno = eVO.getEmpnos();
		result = empLogic.empDelete(pempno);
		return "redirect:./getEmpList.jsp";
	}
	/*************************************************************************************
	 * ������API�� �̿��ؼ� ÷�� ���� ó�� �׽�Ʈ ����
	 * @param pMap
	 * @param imgFile
	 * @return
	 ************************************************************************************/
	@RequestMapping(value="uploadFile.kosmo")
	public String uploadFile(ModelMap pMap,@RequestParam("imgFile") MultipartFile imgFile){
		logger.info("uploadFile ȣ�� ����");
		String fileName = HangulConversion.toKor
							(imgFile.getOriginalFilename());
		logger.info("fileName:"+fileName);
		String path = "E:\\dev_lab\\dev_spring4\\WebContent\\pds\\";
//		÷������ �ߺ�ó���ϱ� - ���� history����
//      test.zip -> test_20170210161910.zip	
		//1)�����̸��� �����(test)
		String onlyFileName = 
				fileName.substring(0, fileName.indexOf("."));
		logger.info("onlyFileName : "+onlyFileName);
		//2)Ȯ���ڸ� �����(.zip)
		String extension = fileName.substring(fileName.indexOf("."));
		//3)�����̸� �������ϱ�
		String rename = onlyFileName+"_"+DayTime.getCurrentDayTime()+extension;
		pMap.addAttribute("rename", rename);
		if(imgFile !=null){//÷������ �߰��ߴ�?
			//���� �����ϴ� �����̸��� ��ü�� �������ִ� Ŭ����
			//���Ͽ� ����ִ� ������� �����Ǵ� ���� �ƴϴ�.
			File file = new File(path+rename);
			try {
				byte[] bytes = imgFile.getBytes();//123
				BufferedOutputStream bos
				=new BufferedOutputStream(
					new FileOutputStream(file));
				bos.write(bytes);//123���
				bos.close();
			} catch (Exception e) {
				logger.info(e.toString());
			}
		}
		return "forward:fileDownload.jsp";
	}
	/*************************************************************************************
	 * ������ : ������ ��ȸ ����
	 * @param  : Map<String,Object> 
	 * @return : redirect:getEmpList.jsp
	 *************************************************************************************/
	@RequestMapping(value="getEmpList.kosmo")
	public String getEmpList(ModelMap rMap, @RequestParam Map<String,Object> pMap)
	{
		logger.info("getEmpList ȣ�� ����");
	//EmpLogicŬ������ ���� �ʱ�ȭ�� null�� �Ǿ� ������ NullPointerException�� �߻�����
	//����.
	//�ֳ��ϸ� �ʿ��� ������ �����������̳ʿ��� xml������ ��ϵ� ��ü�� �����ϰ� �ִٰ�
	//�޸𸮿� �÷��ֱ� �����̴�.
		List<EmpVO> empList = null;
		empList = empLogic.getEmpList(pMap);
		logger.info("size:"+empList.size());
		rMap.addAttribute("empList", empList);
		return "forward:jSonEmpList.jsp";
	}
	/*************************************************************************************
	 * ������ : ������ ��ȸ ���� - ���������� ��ȸ�ϱ� �����ǽ�(myBatis���� �����ϴ� API����)
	 * @param  : Map<String,Object> 
	 * @return : redirect:getEmpList.jsp
	 *************************************************************************************/
	@RequestMapping(value="getEmpList2.kosmo")
	public String getEmpList2(ModelMap rMap, @RequestParam Map<String,Object> pMap)
	{
		logger.info("getEmpList2 ȣ�� ����");
	//EmpLogicŬ������ ���� �ʱ�ȭ�� null�� �Ǿ� ������ NullPointerException�� �߻�����
	//����.
	//�ֳ��ϸ� �ʿ��� ������ �����������̳ʿ��� xml������ ��ϵ� ��ü�� �����ϰ� �ִٰ�
	//�޸𸮿� �÷��ֱ� �����̴�.
		List<EmpVO> empList = null;
		//���� : pMap���� � ������ ��� �������? - 10,30,40
		//key:deptno, value:10,30,40
		empList = empLogic.getEmpList(pMap);
		logger.info("size:"+empList.size());
		rMap.addAttribute("empList", empList);
		return "forward:jSonEmpList.jsp";
	}	
}





