package com.ajax.memo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.util.Action;
import com.util.ActionForward;
import com.util.HangulConversion;
import com.vo.MemoVO;

public class MemoInsertAction implements Action {
	Logger logger = Logger.getLogger(MemoInsertAction.class);
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("execute호출 성공");
		MemoLogic moLogic = new MemoLogic();
		int miResult=0;
		//<input class="easyui-textbox" name="mem_content">
		/*
		 * easyui-textbox 속성을 사용할 때 주의 사항
		 * data-options속성을 사용하면 서버쪽에 값이 전달되지 않음
		 */
		logger.info("to_id"+req.getParameter("to_id"));
		logger.info("from_id"+req.getParameter("from_id"));
		logger.info("memo_content"+req.getParameter("memo_content"));
		logger.info("password"+req.getParameter("password"));
		MemoVO moVO = new MemoVO();
		moVO.setTo_id(req.getParameter("to_id"));
		moVO.setFrom_id(req.getParameter("from_id"));
		moVO.setMemo_content(HangulConversion.toKor(req.getParameter("memo_content")));
		moVO.setPassword(req.getParameter("password"));
		miResult=moLogic.memoInsert(moVO);
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		//요청에 대한 응답이 나가는 페이지 이름 혹은 XXX.mem이름
		if(miResult==1)forward.setPath("./memoInsertSuccess.jsp");
		else forward.setPath("./memoInsertFail");
		return forward;
	}

}
