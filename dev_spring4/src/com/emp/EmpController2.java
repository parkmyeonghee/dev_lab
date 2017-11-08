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
	public EmpLogic2 empLogic=null; //������ �����̳ʷ� ���� ���Թ޾Ƽ�
	//nullpionter���Ͼ
	/******************************************************************************
	 * ������ API�� �̿��ؼ� ÷�� ���� ó�� �׽�Ʈ ����
	 * @param pMap
	 * @param imgFile
	 * @return
	***************************************************************************** */
	@RequestMapping(value="uploadFile.kosmo")
	public String uploadFile(ModelMap pMap,@RequestParam("imgFile") MultipartFile imgFile){
		logger.info("uploadFileȣ�� ����");
		String fileName =
				HangulConversion.toKor(imgFile.getOriginalFilename());
		
		logger.info("fileName"+fileName);
		String path="C:\\Users\\azaza\\Desktop\\dev_lab\\dev_spring4\\WebContent\\pds\\";
		//÷������ �ߺ�ó���ϱ� -���� history����
		//test.zip ->test_20170210161910.zip
		//1)���� �̸��� �����(test)
		String onlyFileName = fileName.substring(0,fileName.indexOf("."));
		logger.info("onlyFileName:"+onlyFileName);
		//2)Ȯ���ڸ� �����(.zip)
		String extension = fileName.substring(fileName.indexOf("."));
		//3)�����̸� �������ϱ�
		String rename = onlyFileName+"_"+DayTime.getCurrentDayTime()+extension;
		pMap.addAttribute("rename",rename);
		if(imgFile !=null){//÷������ �߰��ߴ�?
			//������ �����ϴ� ���� �̸��� ��ü�� �������ִ� Ŭ����
			File file =new File(path+fileName);
			try {
				byte[] bytes =imgFile.getBytes(); //123
				BufferedOutputStream bos
				=new BufferedOutputStream(
						new FileOutputStream(file));
				bos.write(bytes);//123���
				bos.close();
			} catch (Exception e) {
				logger.info(e.toString());
			}
		}
		return "forward:fileDownload.jsp?imgFile="+fileName;
	}
	/*******************************************************************************
	 * ������: ������ ��ȸ ����
	 * @param: Map<String,Object>
	 * @return: redirect:getEmpList.jsp
	 *******************************************************************************/
	@RequestMapping(value="getEmpList.kosmo")
	public String getEmpList(ModelMap rMap,@RequestParam Map<String,Object>pMap)
	{
		logger.info("getEmpList ȣ�� ����");
		//empLogicŬ������ ���� �ʱ�ȭ�� null�� �Ǿ� ������ NullPointerException��
		//�߻����� �ʴ´�
		//�ʿ��� ������ �����������̳� ���� xml������ ��ϵ� ��ü�� �����ϰ� �ִٰ�
		//�޸𸮿� �÷��ֱ� �����̴�.
		List<EmpVO>empList=null;
		empList=empLogic.getEmpList(pMap);
		rMap.addAttribute("empList",empList);
		return "forward:jSomEmpList.jsp";
	}
	/*******************************************************************************
	 * ������: ������ ��ȸ ����-�� �������� ��ȸ�ϱ� ���� �ǽ�(MyBatis����
	 * �����ϴ� API����)
	 * @param: Map<String,Object>
	 * @return: redirect:getEmpList.jsp
	 *******************************************************************************/
	@RequestMapping(value="getEmpList2.kosmo")
	public String getEmpList2(ModelMap rMap,@RequestParam Map<String,Object>pMap)
	{
		logger.info("getEmpList2 ȣ�� ����");
		List<EmpVO>empList=null;
		//pMap���� � ������ ��� �ִ°�?
		//key:deptno,value:10,30,40
		empList=empLogic.getEmpList2(pMap);
		rMap.addAttribute("empList",empList);
		return "forward:jSomEmpList.jsp";
	}
	/*********************************************************************************
	 * ������� �����ϱ� ����
	 * @param pMap
	 * @return
	******************************************************************************** */
/*	@RequestMapping(value="empDelete.kosmo")
	public String empDelelte(@RequestParam Map<String,Object>pMap){
		logger.info("empDelete ȣ�� ����");
		int result=0;
		result=empLogic.emptDelete(pMap);
		logger.info("result"+result);
		return"redirect:getEmpList.jsp?result="+result;
}*/
	/******************************************************************************
	 * ������� �����ϱ� ����2
	 * @param EmpVO
	 * @return int
	 ******************************************************************************/
	@RequestMapping(value="empDelete.kosmo")
	public String empDelete(@ModelAttribute EmpVO eVO){
		logger.info("empDeleteȣ�� ����");
		int result =0;
		String pempno = eVO.getEmpnos();
		result=empLogic.empDelete(pempno);
		return "redirect:getEmpList.jsp";
	}
}
