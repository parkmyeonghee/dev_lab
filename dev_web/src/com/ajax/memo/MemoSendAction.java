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
	 * 쪽지 관리(보낸 쪽지함 목록 구현)
	 * @param request,response
	 * @return ActionForward
	 * 응답페이지: getSendMemoList.jsp
	 *******************************************************************************************/
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("execute호출 성공");
		MemoLogic moLogic = new MemoLogic();
		MemoVO moVO = new MemoVO();
		List<MemoVO>memoList=moLogic.getSendMemoList(moVO);
		req.setAttribute("memoList", memoList);
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		//요청에 대한 응답이 나가는 페이지 이름 혹은 XXX.mem이름
		forward.setPath("./getSendMemoList.jsp");
		return forward;
	}

}
