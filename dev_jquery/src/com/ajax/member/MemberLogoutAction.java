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
		logger.info("execute 호출 성공");
		//세션에 있는 값 제거하기
		HttpSession session =req.getSession();
		session.invalidate();
		//insert here - 쿠키 삭제하기(로그아웃 기능 구현)
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
