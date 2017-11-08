package com.cookie;

import java.io.IOException;
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

public class OnLineTestLoginAction implements Action {
	Logger logger = Logger.getLogger(OnLineTestLoginAction.class);
	/*****************************************************************************************
	 * ������ �����ϱ� ����
	 * @param test_no,exam_cd ���� �ڵ�� ���� ��ȣ
	 * @return ActionForward(���������� URL,forward ����)
	 ****************************************************************************************/
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("execute ȣ�� ����"+req.getParameter("test_no")
		+", ���� �ڵ�:"+req.getParameter("exam_cd"));
		ActionForward forward = new ActionForward();
		OnLineTestLogic testLogic = new OnLineTestLogic();
		ExamineeVO peVO = new ExamineeVO();
		TakeVO tVO = new TakeVO();
		tVO.setExam_cd(req.getParameter("exam_cd")); //name�ڸ���
		peVO.setTest_no(req.getParameter("test_no")); //name�ڸ���
		peVO.settVO(tVO);
		logger.info(peVO.getTest_no()+" , "+peVO.gettVO().getExam_cd());
		ExamineeVO reVO=testLogic.testLogin(peVO);
		//��Ű�� ����,�����ȣ,�����ڵ� ��� �ּ���.
		if(reVO !=null){//������ ���� ���� ��
			Cookie cookie1 = new Cookie("cname",URLEncoder.encode(reVO.getT_name(),"utf-8"));
			Cookie cookie2 = new Cookie("ctestno",URLEncoder.encode(reVO.getTest_no(),"utf-8"));
			Cookie cookie3 = new Cookie("cexamcd",URLEncoder.encode(tVO.getExam_cd(),"utf-8"));
			cookie1.setMaxAge(60*60);
			cookie2.setMaxAge(60*60);
			cookie3.setMaxAge(60*60);
			res.addCookie(cookie1);
			res.addCookie(cookie2);
			res.addCookie(cookie3);
			forward.setRedirect(true);
			forward.setPath("./testForm1.jsp");
		}
		else{ //������ ������?
			forward.setRedirect(true);
			forward.setPath("./test.jsp");
		}
		/*peVO.settVO(tVO);
		//logger.info(peVO);
		forward.setRedirect(true);
		forward.setPath("./testForm1.jsp");*/
		return forward;
	}


}
