package com.ajax;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.util.Action;
import com.util.ActionForward;
import com.util.HashMapBinder;
import com.vo.WordVO;

public class AjaxWordSelectAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Logger logger = Logger.getLogger(AjaxWordSelectAction.class);
		logger.info("³ª¿À·Å");
		AjaxLogic ajLogic = new AjaxLogic();
		Map<String,Object>pMap = new HashMap<String,Object>();
		HashMapBinder hmb = new HashMapBinder(req);
		hmb.binder(pMap);
		logger.info(req.getParameter("w_word"));
		List<WordVO> wordList=ajLogic.getWordList(pMap,req);
		req.setAttribute("wordList",wordList);
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./searchWordResult.jsp");
		return forward;
	}

}
