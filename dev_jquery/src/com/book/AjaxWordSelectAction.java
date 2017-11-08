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
		AjaxLogic ajLogic = new AjaxLogic();//���յ��� ����, �����׽�Ʈ ��ƴ�, ��������  ����
		String pwword = req.getParameter("w_word");//a or ab or abc
		List<WordVO> wordList = ajLogic.getWordList(pwword);
		req.setAttribute("wordList", wordList);
		//������ �̵� - ���������� ȣ��
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);//true:sendRedirect(�����ȵȴ�), false:forward(����)
		forward.setPath("./searchWordResult.jsp");
		return forward;
	}

}
