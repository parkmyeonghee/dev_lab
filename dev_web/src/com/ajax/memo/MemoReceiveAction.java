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

public class MemoReceiveAction implements Action {
	Logger logger = Logger.getLogger(MemoReceiveAction.class);
	@Override
	/*******************************************************************************************
	 * ���� ����(���� ������ ��� ����)
	 * @param request,response
	 * @return ActionForward
	 * ����������: getReceuveMemoList.jsp(���ΰ�ħ)
	 *******************************************************************************************/
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("executeȣ�� ����");
		MemoLogic moLogic = new MemoLogic();
		MemoVO moVO = new MemoVO();
		moVO.setTo_id(req.getParameter("to_id"));
		moVO.setTo_id(req.getParameter("haha"));
		List<MemoVO> memoList=moLogic.getReceiveMemoList(moVO);
		req.setAttribute("memoList", memoList);
		ActionForward forward = new ActionForward();
		//��������:getReceiveMemoList.mem���� ��û���� �� �ٽ� ������ ��û�� �Ͼ�Ƿ�
		//���ѷ����� ������
		forward.setRedirect(false);
		//��û�� ���� ������ ������ ������ �̸� Ȥ�� XXX.mem�̸�
		forward.setPath("./getReceiveMemoList.mem");
		return forward;
	}


}
