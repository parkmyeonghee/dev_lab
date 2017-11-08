package com.ch17;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
 * ������̼��� ����ϸ� ��� ������ ���� �� �� �ִ�.
 * ��ü ���Թ��� ����� ��쿡 ����Ѵ�.
 */

@WebServlet(urlPatterns ="/ch17/pizza")
public class HelloServlet2 extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = res.getWriter();
		out.println("<html>");
		out.println("<head><title>�λ�</title></head>");
		out.println("<body>");
		out.println("�ȳ��ϼ��� ");
		out.println(req.getParameter("name"));
		out.println("��");
		out.println("</body></html>");
		
	}
}
