package com.ajax.news;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.util.Action;
import com.util.ActionForward;
import com.vo.NewsVO;

public class NewsSelectAction implements Action {
	Logger logger = Logger.getLogger(NewsSelectAction.class);

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("execute 메소드 호출 성공");
		NewsDao nDao= new NewsDao();
		List<NewsVO> newsList = nDao.getNewsList();
		req.setAttribute("newsList", newsList);
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./getNewsList.jsp");
		return forward;
	}

}
