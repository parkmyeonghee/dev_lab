package com.cookie;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.util.Action;
import com.util.ActionForward;
import com.vo.ExamineeVO;
import com.vo.TakeVO;

public class OnLineTestAction implements Action {
	Logger logger = Logger.getLogger(OnLineTestAction.class);
	/************************************************************************************
	 * ���� ���� ��� ����
	 * ����
	 * ����� �ۼ��� ��ģ �� ���� ��ư�� Ŭ���ϸ� /take.test�� ȣ���Ѵ�.
	 * ->OnLineTestActionŬ������ execute�޼ҵ� ȣ��
	 * ->OnLineTestLogic Ŭ������ marking�޼ҵ� ȣ��
	 * ->OnLineTestDaoŬ������ takeInsert�޼ҵ� ȣ��-INSERT
	 * ->1)OnLineTestDaoŬ������ getRightAnswer�޼ҵ� ȣ�� -SELECT
	 * ->2)OnLineTestDaoŬ������ getTake�޼ҵ� ȣ��-SELEC
	 * ->��1,2�� �� �� - ä���ϰ� �� ���� ����
	 * ->OnLineTestDaoŬ������ examineeUpdate�޼ҵ� ȣ��-UPDATE
	 * ->OnLineTestDaoŬ������ getExamineeDetail�޼ҵ� ȣ��=SELECT
	 * 
	 ************************************************************************************/
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		logger.info("execute �޼ҵ� ȣ�� ����");//OnLineTestFrontController
		//->OnLineTestAction
		//->OnLineTestLogic
		//->OnLineTestDao
		Cookie cTest[] = req.getCookies();
		ExamineeVO peVO = new ExamineeVO();
		TakeVO ptVO = new TakeVO();
		for(int i=0;i<cTest.length;i++){
			if("test1".equals(cTest[i].getName())){
				logger.info("1�����"+cTest[i].getValue());
				ptVO.setTake1(Integer.parseInt(cTest[i].getValue()));
			}
			else if("test2".equals(cTest[i].getName())){
				logger.info("2�����"+cTest[i].getValue());
				ptVO.setTake2(Integer.parseInt(cTest[i].getValue()));
			}
			else if("test3".equals(cTest[i].getName())){
				logger.info("3�����"+cTest[i].getValue());
				ptVO.setTake3(Integer.parseInt(cTest[i].getValue()));
			}
			else if("test4".equals(cTest[i].getName())){
				logger.info("4�����"+cTest[i].getValue());
				ptVO.setTake4(Integer.parseInt(cTest[i].getValue()));
			}
			/*******************************************[����,������]**************************************************/
			else if("cname".equals(cTest[i].getName())){
				logger.info("�̸�"+
								URLDecoder.decode(cTest[i].getValue(),"utf-8"));
				peVO.setT_name(URLDecoder.decode(cTest[i].getValue(),"utf-8"));
			}
			else if("ctestno".equals(cTest[i].getName())){
				logger.info("�����ȣ"+
								cTest[i].getValue());
				//��Ű�� ����ִ� �����ȣ�� TakeVO�� ExamineeVO�� ���
				//TakeVO�� ��� ���� ����� ���̺� insert�� �� ����� ��
				ptVO.setTest_no(cTest[i].getValue());
				//ExamineeVO�� ��� ���� ����� ���̺� update�� �� ����� ��
				peVO.setTest_no(cTest[i].getValue());
			}
			else if("cexamcd".equals(cTest[i].getName())){
				logger.info("�����ڵ�"+
								cTest[i].getValue());
				ptVO.setExam_cd(cTest[i].getValue());
			}
			/***********************************************************************************************/
			//5�� ���׿� ���� ������� ��Ű�� ��� ���� �ʽ��ϴ�.
			//���� test5�̸��� �������� ����
		/*	else if("test5".equals(cTest[i].getName())){
				logger.info("5�����"+cTest[i].getValue());
			}*/
		}
		String test5 =req.getParameter("hn_test5");
		ptVO.setTake5(Integer.parseInt(test5));
		logger.info("5�����:"+test5);
		//�������� �� ���� ����ڰ� �Է��� ����� ������ TakeVO�� ��ƾ� �մϴ�
		//�ۼ��� ����� ���� ����� ���� ����
		logger.info("take1:"+ptVO.getTake1());
		logger.info("take2:"+ptVO.getTake2());
		logger.info("take3:"+ptVO.getTake3());
		logger.info("take4:"+ptVO.getTake4());
		logger.info("take5:"+ptVO.getTake5());
		//���� ���������� ó���� �ȵǾ� �־� �����ȣ�� ���(��Ű��) ���� �ʽ��ϴ�.
		//�ۼ��� ����� ���� ����� ���� ��
		ActionForward forward = new ActionForward();
		OnLineTestLogic testLogic = new OnLineTestLogic();
		/*
		 * @param peVO(��Ű�� ��� �ִ� �̸�)
		 * @param ptVO(��Ű�� ��� �ִ� ���� ��ȣ,�����ڵ�,�ۼ��� �����)
		 */
		ExamineeVO reVO=testLogic.marking(peVO,ptVO);
		Cookie c1 = new Cookie("cexamcd",ptVO.getExam_cd());
		Cookie c2 = new Cookie("ctestno",reVO.getTest_no());
		Cookie c3 = new Cookie("ctname",URLEncoder.encode(reVO.getT_name(),"utf-8"));
		Cookie c4 = new Cookie("cscore",String.valueOf(reVO.getScore()));
		Cookie c5 = new Cookie("cdecision",URLEncoder.encode(reVO.getDecision(),"utf-8"));
		c1.setMaxAge(60*20);
		c2.setMaxAge(60*20);
		c3.setMaxAge(60*20);
		c4.setMaxAge(60*20);
		c5.setMaxAge(60*20);
		res.addCookie(c1);
		res.addCookie(c2);
		res.addCookie(c3);
		res.addCookie(c4);
		res.addCookie(c5);
		forward.setRedirect(false);
		forward.setPath("./testResult.jsp");
		return forward;
	}

}
