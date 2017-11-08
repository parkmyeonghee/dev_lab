package com.pic;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.Action;
import com.util.ActionForward;
import com.vo.PictureVO;

public class AjaxPictureDetailAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		AjaxLogic ajLogic = new AjaxLogic();//결합도가 높다, 단위테스트 어렵다, 의존성이  높다
		String pnum = req.getParameter("num");//a or ab or abc
		List<PictureVO> picList = ajLogic.getPictureList(pnum);
		req.setAttribute("picList", picList);
		//페이지 이동 - 응답페이지 호출
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);//true:sendRedirect(유지안된다), false:forward(유지)
		forward.setPath("./pictureContentDetail.jsp");
		return forward;
	}

}
