package com.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.vo.DeptVO;
/*
 * ������̼� ������(������2.5)�� ���� �� (3.0)
 * ������ 2.0���� ������̼��� �����Ǳ� �����ߴ�.
 * �׷��� ���� �������� �κп��� ����.
 * ������ 3.0���� ���� �߽��� ������ ��ũ���� Ż���ϴµ� ū �ǹ̸� �ο��Ͽ���.
 */
@Controller
@SessionAttributes(value={"nameList2"})
@RequestMapping("/hello") //������ ���� ���� �̸�
public class HelloController {
	Logger logger = Logger.getLogger(HelloController.class);
	@RequestMapping(value="hello5.kosmo") //���� ȣ���� �޼ҵ� �̸����� �ۼ�
	public String hello5(Model mod,ModelMap map){
		logger.info("hello5ȣ�⼺��");
		List<String>nameList = new ArrayList<String>();
		nameList.add("ȫ�浿");
		nameList.add("�̼���");
		nameList.add("�̼���");
		map.addAttribute("nameList1", nameList);//scope:request
		mod.addAttribute("nameList2", nameList);//scope:session(�ð�)-web.xml
	/*
	 * ���������� �����ϴ� 
	 * Controller Ŭ������ ����Ÿ�� �������� ����� �� �ִ�.
	 *String,void,ModelAndView
	 *return"hello/hello5"  =>WEB-INF/jsp/hello/hello5.jsp
	 *return"redirect:./hello5.jsp" =>webContent/hello/hello5.jsp
	 *return"forward:./hello5.jsp" =>�� 
	 */
		return "redirect: ./hello5.jsp";//���ǻ���:ViewResolver������� ����.
	}
	@RequestMapping(value="hello4.kosmo")
	public String hello4(@RequestParam("dVO") DeptVO pdVO
			,@RequestParam("age") int age
			,@RequestParam Map<String,Object>pMap){
		logger.info("�μ���ȣ(dVO):"+pdVO.getDeptno());
		logger.info("����:"+age);
		logger.info("�μ���ȣ"+pMap.get("detno"));
		logger.info("�μ���"+pMap.get("dname"));
		logger.info("����"+pMap.get("loc"));
		return "hello/hello4";
	}
	@RequestMapping("hello.kosmo")
	public String hello(ModelMap mMap)
	throws ServletException,IOException{
/*	public String hello(HttpServletRequest req)
	throws ServletException,IOException{*/
		logger.info("hello ȣ�� ����");
		List<String>nameList = new ArrayList<String>();
		nameList.add("ȫ�浿");
		nameList.add("�̼���");
		nameList.add("�̼���");
		//req.setAttribute("nameList",nameList);
		mMap.addAttribute("nameList", nameList);
		return "hello/hello";
	}
	/********************************************************************************************
	 * Controller Ŭ������ ������ ����Ÿ���� �����մϴ�
	 * 1)String - ����Ÿ�� ���ڿ��� ������ �̸����� ã�´�.
	 * 2)void - �޼ҵ� �̸����� ������ �̸��� ã�´�.
	 * 3)ModelAndView - �����ڳ� setViewName�޼ҵ��� �Ķ���ͷ� ã�´�.
	 * ������ : �� �� ��� �� �⺻ scpoe�Ӽ��� request�̴�.
	 * ���� ����
	 * 1������
	 * ���� ����
	 * �׷��� ȭ�鿡 �ּҹ����� �����ϰ� ���� �� �����?
	 * request�� ����
	 * -ModelAndView�� ������� �ʴ´�
	 * ��:ModelMap
	******************************************************************************************** */
	@RequestMapping(value="hello2.kosmo",method=RequestMethod.GET)
	public void hello2(){
		logger.info("hello2 ȣ�� ����");
	}
	@RequestMapping(value="hello3.kosmo")
	public ModelAndView hello3(){
		logger.info("hello3 ȣ�⼺��");
		List<String>nameList = new ArrayList<String>();
		nameList.add("�ÿ���");
		nameList.add("ȫ��");
		nameList.add("����");
		DeptVO dVO = new DeptVO();
		dVO.setDeptno(10);
		dVO.setDname("�ѹ���");
		dVO.setLoc("�λ�");
		ModelAndView mav = new ModelAndView("hello/hello3");
		mav.addObject("nameList",nameList);
		mav.addObject("dVO",dVO); //�������� ���� �� �ִ�.
		/*
		 * class ModelAndView{
		 * String viewName="";
		 * public void setViewName(String pageName){
		 * 			this.viewName=pageName;
		 *		 }
		 * }
		 */
		mav.setViewName("hello/hello3");
		return mav;
	}
}
