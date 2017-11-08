package com.ajax.book;

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

public class BookSelectAction implements Action {
	Logger logger = Logger.getLogger(BookSelectAction.class);
	@Override    
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) 
	throws ServletException, IOException {
		BookLogic bkLogic = new BookLogic();
		Map<String,Object> pMap = new HashMap<String,Object>();
		logger.info("page2:"+req.getParameter("page"));//1 2 3
		logger.info("pageSize2:"+req.getParameter("pageSize"));//10 20
		logger.info("ab_tile:"+req.getParameter("ab_title")
		         +", choMode:"+req.getParameter("choMode"));//10 20
		pMap.put("page", req.getParameter("page"));
		pMap.put("pageSize", req.getParameter("pageSize"));
		pMap.put("ab_title", req.getParameter("ab_title"));
		pMap.put("choMode", req.getParameter("choMode"));
		List<BookVO> bookList = bkLogic.getBookList(pMap,req);
		logger.info("size : "+bookList.size());   
		//insert here
		req.setAttribute("bookList",bookList);
		//������ �̵� - ���������� ȣ��
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);//true:sendRedirect(�����ȵȴ�), false:forward(����)
		//�����Ϲ���ȸ �϶�
		if(pMap.get("choMode")!=null){
			forward.setPath("./searchBookTitle.jsp");
		}
		else if(pMap.containsKey("ab_no")){
			logger.info("��");
			forward.setPath("./searchBookDetail.jsp");
		}
		//�ڵ��ϼ���� �϶�
		else{
			forward.setPath("./jSonBookList.jsp");
		}
		return forward;
	}
}















