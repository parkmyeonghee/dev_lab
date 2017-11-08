package com.book;

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
import com.vo.BookVO;

public class BookSelectAction2 implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		Logger logger = Logger.getLogger(BookInsertAction2.class);
			BookLogic2 bkLogic = new BookLogic2();
			Map<String,Object>pMap = new HashMap<String,Object>();
			HashMapBinder hmb = new HashMapBinder(req);
			hmb.binder(pMap);
			logger.info("page1:"+pMap.get("page"));//1 2 3
			logger.info("pageSize1:"+pMap.get("pageSize"));//10 20 30
			logger.info("page2:"+pMap.get("page"));//1 2 3
			logger.info("pageSize2:"+pMap.get("pageSize"));//10 20 30
			logger.info("ab_title:"+pMap.get("ab_title")+", choMode:"+pMap.get("choMode"));
			List<BookVO> bookList=bkLogic.getBookList(pMap,req);
			req.setAttribute("bookList",bookList);
			//페이지 이동 - 응답페이지 호출
			ActionForward forward = new ActionForward();
			forward.setRedirect(false);//true:sendRedirect(유지안된다.),false:forward(유지)
			//도서 일반 조회일 때
			if(!pMap.containsKey("chpMode")){
			forward.setPath("./jSonBookList.jsp");
			}
			//자동완성기능일때
			else{
			forward.setPath("./searchBookResult.jsp");
			}
			return forward;
		}

}
