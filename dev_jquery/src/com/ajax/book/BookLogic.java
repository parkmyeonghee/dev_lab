package com.ajax.book;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.vo.BookVO;
//XXXLogic.java에서는 판단, 결정, 선택, 책임, 트랜잭션 처리
//XXXLogic.java에서는 직접 DB연동부분은 처리하지 않습니다.
//누가 처리하나요? -> XXXDao.java
public class BookLogic {
	Logger logger = Logger.getLogger(BookLogic.class);
	public int bookInsert(BookVO pbVO) {
		logger.info("bookInsert 호출 성공");
		return 0;
	}
	public int bookInsert(Map<String, Object> pMap) {
		logger.info("bookInsert 호출 성공");
		BookDao bDao = new BookDao();
		int biResult = 0;
		biResult = bDao.bookInsert(pMap);
		return biResult;
	}
	public List<BookVO> getBookList(Map<String, Object> pMap,HttpServletRequest req) {
		logger.info("getBookList 호출 성공");
		List<BookVO> bookList = null;
		BookDao bDao = new BookDao();
		//페이징 처리 로직 추가 - start와 end변수를 추가
		int total =0;//전체 레코드 갯수
		total = bDao.totalRecord();
		logger.info("총레코드갯수:"+total);
		//total값을 json파일에 담으면 datagrid에 추가됩니다.
		//total값은 datagrid에 추가될 값이 아니므로 세션을 사용하여 담습니다.
		if(req!=null){
			HttpSession session = req.getSession();
			session.setAttribute("total", total);
		}
		//화면(currentPage:pMap)에서 받아오는 값
		int page = 0;//현재 사용자가 바라보는 페이지 번호(1,2,....)
		//한 페이지에 처리되는 로우 수(화면:pMap)\
		int pageSize = 0;
		if(pMap.get("page")!=null) 
			page = Integer.parseInt(pMap.get("page").toString());
		if(pMap.get("pageSize")!=null) 
			pageSize = Integer.parseInt(pMap.get("pageSize").toString());		
		int start = 0;//페이지의 시작 번호
		int end = 0;//페이지의 끝 번호
		if(page > 0){
			start = ((page-1)*pageSize)+1;
			end = page*pageSize;
			pMap.put("start", start);
			//total이 end보다 작으면 end대신 total값을 담아 주세요.
			//그렇지 않으면 end를 담아 주세요.
			if(end > total){
				pMap.put("end", total);
			}else{
				pMap.put("end", end);
			}
		}/////////////////end of page>0
		logger.info("start:"+pMap.get("start"));//1 11 21
		logger.info("end:"+pMap.get("end"));//10 20 30 33 
		bookList = bDao.getBookList(pMap);		
		return bookList;
	}

}










