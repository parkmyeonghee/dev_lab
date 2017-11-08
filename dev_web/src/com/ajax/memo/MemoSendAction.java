package com.ajax.memo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.util.Action;
import com.util.ActionForward;
import com.vo.MemoVO;

public class MemoSendAction implements Action {
	Logger logger = Logger.getLogger(MemoSendAction.class);
	@Override
	/*******************************************************************************************
	 * ���� ����(���� ������ ��� ����)
	 * @param request,response
	 * @return ActionForward
	 * ����������: getSendMemoList.jsp
	 *******************************************************************************************/
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("executeȣ�� ����");
		MemoLogic moLogic = new MemoLogic();
		MemoVO moVO = new MemoVO();
		List<MemoVO>memoList=moLogic.getSendMemoList(moVO);
		req.setAttribute("memoList", memoList);
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		//��û�� ���� ������ ������ ������ �̸� Ȥ�� XXX.mem�̸�
		forward.setPath("./getSendMemoList.jsp");
		return forward;
	}

}
