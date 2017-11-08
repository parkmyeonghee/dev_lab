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
		logger.info("executeȣ�� ����");
		MemoLogic moLogic = new MemoLogic();
		int miResult=0;
		//<input class="easyui-textbox" name="mem_content">
		/*
		 * easyui-textbox �Ӽ��� ����� �� ���� ����
		 * data-options�Ӽ��� ����ϸ� �����ʿ� ���� ���޵��� ����
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
		//��û�� ���� ������ ������ ������ �̸� Ȥ�� XXX.mem�̸�
		if(miResult==1)forward.setPath("./memoInsertSuccess.jsp");
		else forward.setPath("./memoInsertFail");
		return forward;
	}

}
