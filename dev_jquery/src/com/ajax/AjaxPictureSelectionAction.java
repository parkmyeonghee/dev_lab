package com.ajax;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.util.Action;
import com.util.ActionForward;
import com.vo.PictureVO;

public class AjaxPictureSelectionAction implements Action {

	@Override
	public ActionForward execute
	(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		Logger logger = Logger.getLogger( AjaxPictureSelectionAction.class);
		logger.info("picList»£√‚");
		AjaxLogic ajLogic = new AjaxLogic();
		String pnum = req.getParameter("num");
		List<PictureVO> picList=ajLogic.getPictureList(pnum);
		req.setAttribute("picList", picList);
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./pictureContentView.jsp");
		return forward;
	}

}
