package com.mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.util.Action;
import com.util.ActionForward;

public class MemberFrontController extends HttpServlet {
	Logger logger =
			Logger.getLogger(
					MemberFrontController.class);
	//사용자 정의 메소드
	///doGet혹은 doPost이든 개발자 모두
	//업무처리 해야하므로 메소드를 통합관리 하는것이 좋겠습니다.
	public void doService(HttpServletRequest req
						,HttpServletResponse res)
	throws ServletException, IOException{
		String requestURI = req.getRequestURI(); // ==> dev_jquery/test.do
		String contextPath = req.getContextPath();//==>/dev_jquery
		String command = requestURI.substring(contextPath.length());// ==>test.do
		ActionForward forward =null;
		Action action=null;
		// ->member
		if("/member/login.mfc".equals(command)){//로그인 버튼을 클릭했을 때
			logger.info("로그인 버튼을 눌럿습니다.");
			action = new MemberLoginAction();
			forward=action.execute(req, res);
		}
		else if("/member/logout.mfc".equals(command)){//로그인 버튼을 클릭했을 때
			logger.info("로그아웃 버튼을 눌럿습니다.");
			action = new MemberLogoutAction();
			forward=action.execute(req, res);
		}
		//FrontController 클래스의 역할
		//하나. 응답페이지 호출 - sendRedirect(page|session|cookie),forward(request)
		//둘.업무담당자와 시스템 사이에서 인터페이스 역할
		//예)사용자가 입력한 값 전달하기
		//  ,Dao계층에서 처리된 결과 받아서 화면단에 전달하기 등
		if(forward.isRedirect()){//참일 때 sendRedirect
			res.sendRedirect(forward.getPath());//url-패이지 이름:경로포함
		}else{//거짓일 때 forward
			RequestDispatcher view=
					req.getRequestDispatcher(forward.getPath());
			view.forward(req, res);
		}
	}
	//콜백메소드
	@Override
	public void doGet(HttpServletRequest req
			,HttpServletResponse res)
throws ServletException, IOException{
		doService(req,res);
			}
	@Override
	public void doPost(HttpServletRequest req
			,HttpServletResponse res)
throws ServletException, IOException{
		doService(req,res);
			}
}
