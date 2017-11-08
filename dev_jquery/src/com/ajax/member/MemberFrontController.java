package com.ajax.member;

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
	//����� ���� �޼ҵ�
	//doGet Ȥ�� doPost�̵� �����ڴ� ���
	//����ó�� �ؾ��ϹǷ� �޼ҵ带 ���� ����
	//�ϴ°��� ���ڽ��ϴ�.
	public void doService(HttpServletRequest req
			        , HttpServletResponse res)
	throws ServletException, IOException
	{
		String requestURI = req.getRequestURI();// -> /dev_jquery/test.do
		String contextPath = req.getContextPath();//-> /dev_jquery
		String command = requestURI.substring(contextPath.length());//-> /test.do
		ActionForward forward = null;
		Action action = null;
		//-> member
		logger.info("command:"+command);
		if("/intro/login.mem".equals(command)){//�α��� ��ư�� Ŭ������ ��
			logger.info("�α��� ��ư�� �������ϴ�.");
			action = new MemberLoginAction();
			forward = action.execute(req, res);
		}
		else if("/intro/logout.mem".equals(command)){//�α��� ��ư�� Ŭ������ ��
			logger.info("�α׾ƿ� ��ư�� �������ϴ�.");
			action = new MemberLogoutAction();
			forward = action.execute(req, res);
		}
		
	//FrontControllerŬ������ ����
	//�ϳ�. ���������� ȣ���ϱ� - sendRedirect(page|session|cookie), forward(request)
	//��. ��������ڿ� �ý��ۻ��̿��� �������̽� ����
	//��)����ڰ� �Է��� �� �����ϱ�
	//  ,Dao�������� ó���� ��� �޾Ƽ� ȭ��ܿ� �����ϱ� ��.	
		if(forward.isRedirect()){//���� �� sendRedirect
			res.sendRedirect(forward.getPath());//url-�������̸�:�������
		}
		else{//������ �� forword
			RequestDispatcher view = 
					req.getRequestDispatcher
							(forward.getPath());
			view.forward(req, res);
		}
	}
	//�ݹ�޼ҵ�
	@Override
	public void doGet(HttpServletRequest req
	        , HttpServletResponse res)
	throws ServletException, IOException
	{
		doService(req,res);
	}
	//�ݹ�޼ҵ�
	@Override
	public void doPost(HttpServletRequest req
	        , HttpServletResponse res)
	throws ServletException, IOException
	{
		doService(req,res);
	}
}
