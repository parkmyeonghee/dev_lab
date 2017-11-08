package com.ajax;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.util.Action;
import com.util.ActionForward;
import com.vo.PictureVO;

public class AjaxPictureDetailAction implements Action {

	@Override
	public ActionForward execute
	(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		Logger logger = Logger.getLogger(AjaxPictureDetailAction.class);
		logger.info("picList»£√‚");
		AjaxLogic ajLogic = new AjaxLogic();
		String pnum = req.getParameter("num");
		List<PictureVO> picDetail=ajLogic.getPictureList(pnum);
		req.setAttribute("picDetail", picDetail);
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./pictureContentDetail.jsp");
		return forward;
	}

}
