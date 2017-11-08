package com.ajax.memo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.util.Action;
import com.util.ActionForward;
import com.vo.MemoVO;

public class MemoUpdateAction implements Action {
	Logger logger = Logger.getLogger(MemoDeleteAction.class);
	@Override
	/*******************************************************************************************
	 * 쪽지 관리(보낸 수정하기 구현)
	 * @param request,response
	 * @return ActionForward
	 * 응답페이지: getSendMemoList.mem
	 *******************************************************************************************/
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("execute호출 성공");
		MemoLogic moLogic = new MemoLogic();
		int muResult=0;
		MemoVO moVO = new MemoVO();
		muResult=moLogic.memoUpdate(moVO);
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		//요청에 대한 응답이 나가는 페이지 이름 혹은 XXX.mem이름
		if(muResult==1)forward.setPath("./memoUpdateSuccess.jsp");
		else forward.setPath("./memoUpdateFail");
		return forward;
	}

}
