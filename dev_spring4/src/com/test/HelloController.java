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
 * 어노테이션 적용전(스프링2.5)과 적용 후 (3.0)
 * 스프링 2.0부터 어노테이션이 지원되기 시작했다.
 * 그러나 극히 제한적인 부분에서 였다.
 * 스프링 3.0부터 서블릿 중심의 프레임 워크에서 탈출하는데 큰 의미를 부여하였다.
 */
@Controller
@SessionAttributes(value={"nameList2"})
@RequestMapping("/hello") //업무에 대한 폴더 이름
public class HelloController {
	Logger logger = Logger.getLogger(HelloController.class);
	@RequestMapping(value="hello5.kosmo") //실제 호출할 메소드 이름위에 작성
	public String hello5(Model mod,ModelMap map){
		logger.info("hello5호출성공");
		List<String>nameList = new ArrayList<String>();
		nameList.add("홍길동");
		nameList.add("이성계");
		nameList.add("이순신");
		map.addAttribute("nameList1", nameList);//scope:request
		mod.addAttribute("nameList2", nameList);//scope:session(시간)-web.xml
	/*
	 * 스프링에서 제공하는 
	 * Controller 클래스는 리턴타입 세가지를 사용할 수 있다.
	 *String,void,ModelAndView
	 *return"hello/hello5"  =>WEB-INF/jsp/hello/hello5.jsp
	 *return"redirect:./hello5.jsp" =>webContent/hello/hello5.jsp
	 *return"forward:./hello5.jsp" =>상동 
	 */
		return "redirect: ./hello5.jsp";//주의사항:ViewResolver사용하지 않음.
	}
	@RequestMapping(value="hello4.kosmo")
	public String hello4(@RequestParam("dVO") DeptVO pdVO
			,@RequestParam("age") int age
			,@RequestParam Map<String,Object>pMap){
		logger.info("부서번호(dVO):"+pdVO.getDeptno());
		logger.info("나이:"+age);
		logger.info("부서번호"+pMap.get("detno"));
		logger.info("부서명"+pMap.get("dname"));
		logger.info("지역"+pMap.get("loc"));
		return "hello/hello4";
	}
	@RequestMapping("hello.kosmo")
	public String hello(ModelMap mMap)
	throws ServletException,IOException{
/*	public String hello(HttpServletRequest req)
	throws ServletException,IOException{*/
		logger.info("hello 호출 성공");
		List<String>nameList = new ArrayList<String>();
		nameList.add("홍길동");
		nameList.add("이성계");
		nameList.add("이순신");
		//req.setAttribute("nameList",nameList);
		mMap.addAttribute("nameList", nameList);
		return "hello/hello";
	}
	/********************************************************************************************
	 * Controller 클래스는 세가지 리턴타입을 제공합니다
	 * 1)String - 리턴타입 문자열에 지정한 이름으로 찾는다.
	 * 2)void - 메소드 이름으로 페이지 이름을 찾는다.
	 * 3)ModelAndView - 생성자나 setViewName메소드의 파라미터로 찾는다.
	 * 공통점 : 위 셋 모두 다 기본 scpoe속성이 request이다.
	 * 권장 사항
	 * 1번으로
	 * 문제 제기
	 * 그러면 화면에 주소번지를 전달하고 싶을 땐 어떻하지?
	 * request가 없다
	 * -ModelAndView를 사용하지 않는다
	 * 답:ModelMap
	******************************************************************************************** */
	@RequestMapping(value="hello2.kosmo",method=RequestMethod.GET)
	public void hello2(){
		logger.info("hello2 호출 성공");
	}
	@RequestMapping(value="hello3.kosmo")
	public ModelAndView hello3(){
		logger.info("hello3 호출성공");
		List<String>nameList = new ArrayList<String>();
		nameList.add("시오밍");
		nameList.add("홍빈");
		nameList.add("은우");
		DeptVO dVO = new DeptVO();
		dVO.setDeptno(10);
		dVO.setDname("총무부");
		dVO.setLoc("부산");
		ModelAndView mav = new ModelAndView("hello/hello3");
		mav.addObject("nameList",nameList);
		mav.addObject("dVO",dVO); //여러개를 담을 수 있다.
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
