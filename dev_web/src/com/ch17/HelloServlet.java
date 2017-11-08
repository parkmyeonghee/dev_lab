package com.ch17;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	/*
	 * HttpServletRequest : ����ڰ� �Է��� �� �޾� �ö�
	 * HttpServletResponse : ����� ��û�� ���� ������������ ȣ���� ��
	 */
	
	//�������� ��û�ϴ°��� get����̴�
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		//mime Ÿ���� �����Ѵ� - �������� html ������ ������.
		res.setContentType("text/html;charset=euc-kr");  //���� Ÿ�� text, ����Ÿ���� html �̶� ��, ���ڵ�Ÿ���� euc-kr
		
		//�������� html �ڵ�, css�ڵ�, js�ڵ带 �ۼ�
		//javascript ���� html �ڵ� �ۼ��Ҷ�, document.write("<b>�ڹٽ�ũ��Ʈ</b>");
		
		PrintWriter out = res.getWriter();
		out.print("<b>hello servlet!!!</b>");
	}
	
}
