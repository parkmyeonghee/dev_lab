package com.ch05;

import java.io.IOException;
/************************************************************************************************
 * ��ü�� �����ϴ� ����� �� �� �ִ�.
 * ������ ����: servlet - Servlet
 * ��)�Խ��� �����ϱ�(SELECT-UPDATE-SELECT) Ȥ�� �Խ��� �� ���(INSERT-SELECT)�ϱ�
 * �Է�|����|����|��ȸ
 * �������� �� 4���� ������ ��� �б�����?
 * 
 * ���� ������ �ٸ� �޼ҵ带 ���� �� �� �ֳ�?
 * ===> �� �� �ִ�.
 * ���� ������ �����ڰ� ������ �޼ҵ带 ȣ���� �� �ֳ�?
 * =====>�����ڰ� �޼ҵ带 ȣ�� �� �� ����.
 * ===>������? 
 * ������ ���� �ν��Ͻ�ȭ: �ߴ�|�ƴϴ�
 * ������ ���� ��ü ������ Was���� ����Ѵ�.
 * :������ ������ ����Ŭ -Was
 * 
 * 
 *************************************************************************************/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class ScopeServlet extends HttpServlet {
	Logger logger =Logger.getLogger(ScopeServlet.class);
	public void doGet(HttpServletRequest req
							, HttpServletResponse res)
	throws ServletException,IOException
	{
		logger.info("doget ȣ�� ����");
		//INS|UPD|DEL|SELECT
		String command =req.getParameter("command");
		if("INS".equals(command)){//����̴�?
			logger.info("����̴�?");
			//0�̸� ��� ����
			//1�̸� ��� ����
			int result =1;
			//result = boardInsert();
			if(result==0){//��� ����
				res.sendRedirect("./boardInsertFail.jsp");
			}
			else if(result==1){//��� ����
				res.sendRedirect("./boardInsertOK.jsp");
			}
		}
		else if("UPD".equals(command)){//�����̴�?
			logger.info("�����̴�?");
		}
		else if("DEL".equals(command)){//������?
			logger.info("������?");
		}
		else if("SEL".equals(command)){//����ȸ��?
			logger.info("��ü��ȸ��?");
			//�ڷ� ������ ���׸� ����
			//�ּҹ����� �� �� �����ؾ� ���� ��� ����
			List<HashMap<String,Object>> list 
			=new ArrayList<HashMap<String,Object>>();
			HashMap<String,Object> pMap
			= new HashMap<String,Object>();
			pMap.put("mem_id","test");
			pMap.put("mem_pw","123");
			pMap.put("mem_name", "�ÿ���");
			req.setAttribute("list",list);
			RequestDispatcher view =
					req.getRequestDispatcher("list.jsp");
			view.forward(req, res);
			
		}
/*		String mem_id = req.getParameter("mem_id");
		String mem_pw = req.getParameter("mem_pw");
		req.setAttribute("mem_id", mem_id);
		req.setAttribute("mem_pw", mem_pw);
		RequestDispatcher view =
				req.getRequestDispatcher("end2.jsp");
		view.forward(req, res);*/
	}
}
