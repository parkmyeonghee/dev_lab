package com.book;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.util.Action;
import com.util.ActionForward;

//프론트 컨트롤러 클래스는 응답페이지에 대한 요청을 담당합니다.
public class BookFrontController2 extends HttpServlet{
	Logger logger = Logger.getLogger(BookFrontController2.class);
	
	public void doService(HttpServletRequest req
	        , HttpServletResponse res)
throws ServletException, IOException
{
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = requestURI.substring(contextPath.length());
		ActionForward forward = new ActionForward();
		Action action = null;
		if("/book/bookInsert.bk".equals(command)){
			action=new BookInsertAction2();
			forward=action.execute(req, res);
		}
		else if("/book/getBookList.bk".equals(command)){
			action = new BookSelectAction2();
			forward=action.execute(req, res);
		}
		if(forward.isRedirect()){ //nullpointer맞는걸 피하고자 forward를 인스턴스화 해줌
			res.sendRedirect(forward.getPath());
		}else{
			RequestDispatcher view = req.getRequestDispatcher(forward.getPath());
			view.forward(req, res);
		}	
}
	@Override
	public void doGet(HttpServletRequest req
	        , HttpServletResponse res)
	throws ServletException, IOException
	{
		doService(req,res);
	}
	//콜백메소드
	@Override
	public void doPost(HttpServletRequest req
	        , HttpServletResponse res)
	throws ServletException, IOException
	{
		doService(req,res);
	}
}
