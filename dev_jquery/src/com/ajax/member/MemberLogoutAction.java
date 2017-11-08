package com.ajax.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.util.Action;
import com.util.ActionForward;

public class MemberLogoutAction implements Action {
	Logger logger = Logger.getLogger(MemberLogoutAction.class);
	@Override
	public ActionForward execute(HttpServletRequest req
			                   , HttpServletResponse res) 
    throws ServletException, IOException {
		logger.info("execute ȣ�� ����");
		//���ǿ� �ִ� �� �����ϱ�
		HttpSession session =req.getSession();
		session.invalidate();
		//insert here - ��Ű �����ϱ�(�α׾ƿ� ��� ����)
		Cookie cookie = new Cookie("cname","");
		cookie.setMaxAge(0);
		cookie.setPath("/member");
		res.addCookie(cookie);
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("./login.jsp");
		return forward;
	}

}
