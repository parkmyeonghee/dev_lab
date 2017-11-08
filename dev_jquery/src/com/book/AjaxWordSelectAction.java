package com.book;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.util.Action;
import com.util.ActionForward;
import com.vo.WordVO;

public class AjaxWordSelectAction implements Action {
	Logger logger = Logger.getLogger(AjaxWordSelectAction.class);
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		AjaxLogic ajLogic = new AjaxLogic();//결합도가 높다, 단위테스트 어렵다, 의존성이  높다
		String pwword = req.getParameter("w_word");//a or ab or abc
		List<WordVO> wordList = ajLogic.getWordList(pwword);
		req.setAttribute("wordList", wordList);
		//페이지 이동 - 응답페이지 호출
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);//true:sendRedirect(유지안된다), false:forward(유지)
		forward.setPath("./searchWordResult.jsp");
		return forward;
	}

}
