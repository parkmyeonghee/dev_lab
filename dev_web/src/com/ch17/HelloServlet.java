package com.ch17;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	/*
	 * HttpServletRequest : 사용자가 입력한 값 받아 올때
	 * HttpServletResponse : 사용자 요청에 대한 응답페이지를 호출할 때
	 */
	
	//브라우저에 요청하는것은 get방식이다
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		//mime 타입을 설정한다 - 브라우저가 html 문서로 인지함.
		res.setContentType("text/html;charset=euc-kr");  //메인 타입 text, 서브타입은 html 이란 뜻, 인코딩타입은 euc-kr
		
		//브라우저에 html 코드, css코드, js코드를 작성
		//javascript 에서 html 코드 작성할때, document.write("<b>자바스크립트</b>");
		
		PrintWriter out = res.getWriter();
		out.print("<b>hello servlet!!!</b>");
	}
	
}
