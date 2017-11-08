package com.ajax.book;

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

public class BookInsertAction implements Action {
	Logger logger = Logger.getLogger(BookInsertAction.class);
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) 
	throws ServletException, IOException {
		logger.info("��������:"+req.getParameter("ab_title"));//null
		logger.info("����:"+req.getParameter("ab_author"));//null
		Map<String,Object> pMap = new HashMap<String,Object>();
		HashMapBinder hmb = new HashMapBinder(req);
		hmb.multiBind(pMap); 
		logger.info("��������:"+pMap.get("ab_title"));//Java����
		logger.info("����:"+pMap.get("ab_author"));//���ü�
		logger.info("�̹�����:"+pMap.get("ab_img"));//���ϸ�
		logger.info("�̹��� ����ũ��:"+pMap.get("ab_size"));//����ũ��
		logger.info("������:"+pMap.get("ab_pubdate"));//������ 01/26/2017
		StringTokenizer st = new StringTokenizer(pMap.get("ab_pubdate").toString(),"/");
		//-> 01/26/2017
		String mm = st.nextToken();
		String day = st.nextToken();
		String year = st.nextToken();
		logger.info(year+"-"+mm+"-"+day);
		pMap.put("ab_pubdate", year+"-"+mm+"-"+day);
		BookVO pbVO = new BookVO();
		BookLogic bkLogic = new BookLogic();
		//biResult==1 ? 1:�Է¼��� 0:�Է½���
		int biResult = 0;
		biResult = bkLogic.bookInsert(pMap);
		//������ �̵� - ���������� ȣ��
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("./getBookList.bk");
		return forward;
	}

}
