package com.book;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.util.Action;
import com.util.ActionForward;
import com.util.HashMapBinder;
import com.vo.BookVO;

public class BookInsertAction2 implements Action {
	Logger logger = Logger.getLogger(BookInsertAction2.class);
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		logger.info("도서제목"+req.getParameter("ab_title"));
		logger.info("저자"+req.getParameter("ab_author"));
		Map<String,Object>pMap = new HashMap<String,Object>();
		//자료 구조를 직접 생생해서 넘겨줌
		HashMapBinder hmb =new HashMapBinder(req);
		hmb.multiBind(pMap);
		logger.info("도서제목"+pMap.get("ab_title")); //내가 입력한 도서제목
		logger.info("저자"+pMap.get("ab_author")); //저자
		logger.info("이미지명"+pMap.get("ab_img")); //파일명
		logger.info("이미지 파일크기"+pMap.get("ab_size")); //파일크기 byte로 나옴
		StringTokenizer st = new StringTokenizer(pMap.get("ab_pubdate").toString(),"/");
		String mm =st.nextToken();
		String day =st.nextToken();
		String year = st.nextToken();
		logger.info(year+"-"+mm+"-"+day);
		pMap.put("ab_pubdate",year+"-"+mm+"-"+day);
		BookVO pbVO = new BookVO();
		BookLogic2 bkLogic = new BookLogic2();
		//biResult==1? 1:입력성공 0:입력실패
		int biResult=0;
		biResult = bkLogic.bookInsert(pMap);
		//페이지 이동 - 응답페이지 호출
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("./getBookList.bk");
		return forward;
	}

}
