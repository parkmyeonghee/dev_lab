package com.ch17;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ch7.Duck;
import com.ch7.MallardDuck;
import com.ch7.Sonata;
import com.mvc.address.AddressBook;
import com.vo.DeptVO;
import com.vo.DeptVO;

public class TestSendServlet extends HttpServlet {
	Logger logger = Logger.getLogger(TestSendServlet.class);
	
	
/*	@Override
	public void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
	logger.info("ȣ�⼺��");
	}*/
	
	//����� ���Ǹ޼ҵ�
	public void doService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		logger.info("doService ȣ�� ����");
		//ȭ�鿡�� �Է¹��� ���̵� ��������
		String mem_id=req.getParameter("mem_id"); //��Ʈ��Ÿ�� �������� ����
		logger.info("���̵�: "+mem_id);
		//res.setContentType("text/html;charset=euc-kr");
		//PrintWriter out = res.getWriter();
		/*
		 * ������ �̵�ó��
		 * doGet(HttpServletRequest req,HttpServletResponse res),doPost()
		 * 1)res.sendRedirect(url):�������� ó���� ��
		 * response.sendRedirect(url): jsp���� ó���� ��
		 * ->URL�� �ٲ��.
		 * 
		 * 2)��������  forwardó�� �Ѵ�.
		 * forward(req,res);
		 * ->URL�� �ٲ��� �ʴ´�.(������ ������ �ٲ��)
		 */
		Sonata myCar= new Sonata();
		req.setAttribute("myCar", myCar);
		req.setAttribute("r_name", "�̼���");
		MallardDuck myDuck= new MallardDuck();//������
		//�ڷᱸ��(List)
		List<DeptVO> deptList = new ArrayList<DeptVO>();
		DeptVO dvo= new DeptVO();
		dvo.setDeptno(10);
		dvo.setDname("����");
		dvo.setLoc("�λ�");
		deptList.add(dvo);
		
		dvo= new DeptVO();
		dvo.setDeptno(20);
		dvo.setDname("�ѹ�");
		dvo.setLoc("��õ");
		deptList.add(dvo);
		
		dvo= new DeptVO();
		dvo.setDeptno(30);
		dvo.setDname("�λ�");
		dvo.setLoc("����");
		deptList.add(dvo);
		req.setAttribute("deptList", deptList);
		
		AddressBook abook  = new AddressBook();
		req.setAttribute("abook", abook);
		RequestDispatcher view = req.getRequestDispatcher("./getSendResult.jsp");
		view.forward(req,res);
		//res.sendRedirect("./getSendResult.jsp?mem_id="+mem_id);
		
/*		out.print("<html>");// �̷��Ծ��ϱ� ���� jsp�� ȭ��ó���� �� ����.
		out.print("<head>");
		out.print("<title>���� TestSendServlet</title>");
		out.print("</head>");
		out.print("<body>"+mem_id+"</body>");
		out.print("</html>");*/
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		logger.info("doGet ȣ�� ����");
		doService(req,res);
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		logger.info("doPost ȣ�� ����");
		doService(req,res);
	}
}
