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
			//������ �̵� - ���������� ȣ��
			ActionForward forward = new ActionForward();
			forward.setRedirect(false);//true:sendRedirect(�����ȵȴ�.),false:forward(����)
			//���� �Ϲ� ��ȸ�� ��
			if(!pMap.containsKey("chpMode")){
			forward.setPath("./jSonBookList.jsp");
			}
			//�ڵ��ϼ�����϶�
			else{
			forward.setPath("./searchBookResult.jsp");
			}
			return forward;
		}

}
