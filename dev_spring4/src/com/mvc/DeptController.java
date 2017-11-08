package com.mvc;

import java.io.IOException;
import java.util.HashMap;
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

import com.vo.DeptVO;

@Controller
@RequestMapping(value="/dept")
public class DeptController {
	Logger logger = Logger.getLogger(DeptController.class);
	@Autowired
	public DeptLogic deptLogic = null; //����Ҷ����� ��ü�� ����
	@RequestMapping(value="trTest.kosmo")
	public String trTest(){
		logger.info("trTestȣ�� ����");
		deptLogic.trTest();
		return "redirect:testResult.jsp";
	}
	@RequestMapping(value="testResult.kosmo")
		public String test(){
		logger.info("testȣ�� ����");
		return "redirect:testResult.jsp";
	}
	@RequestMapping(value="testResult2.kosmo")
	public void test(HttpServletResponse res)throws ServletException,IOException{
		logger.info("testȣ�� ����");
		res.sendRedirect("testResult.jsp");
	}
	
	@RequestMapping(value="getDeptList.kosmo")
	public String getDeptList(@ModelAttribute DeptVO dvo ,ModelMap rMap, @RequestParam Map<String,Object>pMap,HttpServletRequest req){
		logger.info("getDeptList ȣ�� ����");
		logger.info("deptno(Map):"+pMap.get("deptno"));
		logger.info("deptno(DeptVO):"+dvo.getDeptno());
		List<HashMap>deptList =null;
		deptList=deptLogic.getDeptList(pMap,req);
		rMap.addAttribute("deptList",deptList);
		return "forward:./jSonDeptList.jsp";//����������
	}
	/************************************************************************************
	 * UI�ַ���� �ڹٽ�ũ��Ʈ ����� ����ϰ� �ִ�.
	 * ���� �ڹ� �ڵ�� �ڹٽ�ũ��Ʈ ���̿��� JSON�� ��ȯ�� �ʿ��ϴ�.
	 * getDeptList.kosmo�� ���׸�Ÿ���� Map���� ���� ����̰�
	 * �Ʒ������� ���׸�Ÿ���� VO�� ó���� ����.
	 ************************************************************************************/
	@RequestMapping(value="getDeptList2.kosmo")
	public String getDeptList2(@ModelAttribute DeptVO dvo ,ModelMap rMap, @RequestParam Map<String,Object>pMap,HttpServletRequest req){
		logger.info("getDeptList2 ȣ�� ����");
		logger.info("deptno(Map):"+pMap.get("deptno"));
		logger.info("deptno(DeptVO):"+dvo.getDeptno());
		List<DeptVO>deptList =null;
		deptList=deptLogic.getDeptList2(pMap,req);
		rMap.addAttribute("deptList",deptList);
		return "forward:./jSonDeptList2.jsp";//����������
	}
	
	/*********************************************************************************************************************
	 * �μ� ��� ��ȸ����-1�� ��ȸ
	 * �Ȱ��� ��ȸ ������ ������� ������������ ���� �ٸ� �����
	 * ���� Ŭ������ DaoŬ������ �ϳ��� ����ϴ��� ��Ʈ�� Ŭ������ ������ ��������
	 * @param rMap
	 * @param pMap
	 * @return
	******************************************************************************************************************* */
	@RequestMapping(value="getDeptRead.kosmo")
	public String getDeptRead(ModelMap rMap, @RequestParam Map<String,Object>pMap){
		logger.info("getDeptRead ȣ�� ����");
		List<HashMap>deptList =null;
		deptList=deptLogic.getDeptList(pMap,null);
		rMap.addAttribute("deptList",deptList);
		return "forward:./deptUpdForm.jsp";//����������
	}
	
	@RequestMapping(value="getDeptnoList.kosmo")
	public String getDeptnoList(ModelMap rMap, @RequestParam Map<String,Object>pMap){
		logger.info("getDeptnoList ȣ�� ����");
		List<HashMap>deptList =null;
		deptList=deptLogic.getDeptnoList(pMap);
		rMap.addAttribute("deptList",deptList);
		return "forward:./jSonDeptnoList.jsp";//����������
	}
	/************************************************************************************************************
	 * �μ� ���� �����ϱ�
	 * �Ķ���� Ÿ���� dVOŸ������ ��ȯ�Ͽ� ó���� ���ô�.
	 * @param pMap ȭ�鿡�� ����ڰ� ������ �ο쿡 �μ� ��ȣ ��������
	 * @return
	 ***********************************************************************************************************/
	@RequestMapping(value="deptDelete.kosmo")
	public String deptDelelte(@RequestParam Map<String,Object>pMap){
		logger.info("deptDelete ȣ�� ����");
		int result=0;
		result=deptLogic.deptDelete(pMap);
		logger.info("result"+result);
		return"redirect:getDeptList.jsp?result="+result;
	}
	@RequestMapping(value="deptUpdate.kosmo")
	public String deptUpdate(@RequestParam Map<String,Object>pMap){
		logger.info("deptUpdate ȣ�� ����");
		int result=0;
		result=deptLogic.deptUpdate(pMap);
		logger.info("result"+result);
		return "redirect:deptInsertSuccess.jsp";//����������
	}
	
	@RequestMapping(value="deptInsert.kosmo")
	public String deptInsert(@RequestParam Map<String,Object>pMap){
		logger.info("deptInsert ȣ�� ����");
		int result=0;
		result=deptLogic.deptInsert(pMap);
		logger.info("result"+result);
		return "redirect:getDeptList.jsp?result="+result;//����������
	}
}
