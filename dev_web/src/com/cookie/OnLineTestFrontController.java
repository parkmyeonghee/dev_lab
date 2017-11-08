package com.cookie;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.util.Action;
import com.util.ActionForward;

import sun.awt.datatransfer.DataTransferer.ReencodingInputStream;

public class OnLineTestFrontController extends HttpServlet {
	Logger logger = Logger.getLogger(OnLineTestFrontController.class);
	public void doService(HttpServletRequest req
			,HttpServletResponse res)
throws ServletException, IOException{
		String requestURI = req.getRequestURI(); //-->dev_web/XXX.test
		String contextPath = req.getContextPath();//-->dev_web
		String command = requestURI.substring(contextPath.length());
		ActionForward forward =null;
		Action action=null;
		/********************************************************************************
		 * ����� �ۼ� �Ϸ� �� ���� ��ư�� Ŭ������ ��
		 * ����� ���� ��� �����ϱ�
		 * DB����
		 * :INSERT INTO take(exam_cd,test_no
		 * 							,take1,take2,take3
		 * 							,take4,take5)
		 * 						VALUES(?,?,?,?,?)
		******************************************************************************* */
		logger.info(command);
		if("/onLineTest2/marking.test".equals(command)){
			action = new OnLineTestAction();
			forward = action.execute(req, res);
			logger.info("");
		}
		/*******************************************************************************
		 * ������ �����ϱ� ����
		******************************************************************************* */
		else if("/onLineTest2/testLogin.test".equals(command)){
			action = new OnLineTestLoginAction();
			forward = action.execute(req, res);
		}
		/****************************************************************************
		 * ���ν��� ȣ�� �׽�Ʈ
		 ****************************************************************************/
		else if("/onLineTest2/proc_salupdate.test".equals(command)){
			OnLineTestDao otDao = new OnLineTestDao();
			otDao.proc_salupdate(7566);
			forward= new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./testIndex.jsp");
		}
		if(forward.isRedirect()){//���� �� sendRedirect
			res.sendRedirect(forward.getPath());//URL -������ �̸�: ��� ����
		} else{//������ �� forward
			RequestDispatcher view =
				req.getRequestDispatcher(forward.getPath());
			view.forward(req, res);
		}
	}
	//�ݹ�޼ҵ�
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


