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
		logger.info("��������"+req.getParameter("ab_title"));
		logger.info("����"+req.getParameter("ab_author"));
		Map<String,Object>pMap = new HashMap<String,Object>();
		//�ڷ� ������ ���� �����ؼ� �Ѱ���
		HashMapBinder hmb =new HashMapBinder(req);
		hmb.multiBind(pMap);
		logger.info("��������"+pMap.get("ab_title")); //���� �Է��� ��������
		logger.info("����"+pMap.get("ab_author")); //����
		logger.info("�̹�����"+pMap.get("ab_img")); //���ϸ�
		logger.info("�̹��� ����ũ��"+pMap.get("ab_size")); //����ũ�� byte�� ����
		StringTokenizer st = new StringTokenizer(pMap.get("ab_pubdate").toString(),"/");
		String mm =st.nextToken();
		String day =st.nextToken();
		String year = st.nextToken();
		logger.info(year+"-"+mm+"-"+day);
		pMap.put("ab_pubdate",year+"-"+mm+"-"+day);
		BookVO pbVO = new BookVO();
		BookLogic2 bkLogic = new BookLogic2();
		//biResult==1? 1:�Է¼��� 0:�Է½���
		int biResult=0;
		biResult = bkLogic.bookInsert(pMap);
		//������ �̵� - ���������� ȣ��
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("./getBookList.bk");
		return forward;
	}

}
