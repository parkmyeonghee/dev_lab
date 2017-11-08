package com.ajax.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cookie.OnLineTestLoginAction;
import com.sun.media.jfxmedia.logging.Logger;
import com.util.Action;
import com.util.ActionForward;
import com.vo.MemberVO;

public class MemberSelectAction implements Action {
	//Logger logger = Logger.getLogger(MemberSelectAction .class);
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		//logger.info("execute호출 성공");
		List<MemberVO>memList = null;
		MemberLogic memLogic = new MemberLogic();
		memList=memLogic.getMemberList();
		req.setAttribute("memList", memList);
		ActionForward forward = new ActionForward();
		forward.setRedirect(false); //false:forward처리
		forward.setPath("./index.jsp?menu=getMemberList");
		return forward;
	}

}
