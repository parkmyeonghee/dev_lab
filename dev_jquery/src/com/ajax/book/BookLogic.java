package com.ajax.book;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.vo.BookVO;
//XXXLogic.java������ �Ǵ�, ����, ����, å��, Ʈ����� ó��
//XXXLogic.java������ ���� DB�����κ��� ó������ �ʽ��ϴ�.
//���� ó���ϳ���? -> XXXDao.java
public class BookLogic {
	Logger logger = Logger.getLogger(BookLogic.class);
	public int bookInsert(BookVO pbVO) {
		logger.info("bookInsert ȣ�� ����");
		return 0;
	}
	public int bookInsert(Map<String, Object> pMap) {
		logger.info("bookInsert ȣ�� ����");
		BookDao bDao = new BookDao();
		int biResult = 0;
		biResult = bDao.bookInsert(pMap);
		return biResult;
	}
	public List<BookVO> getBookList(Map<String, Object> pMap,HttpServletRequest req) {
		logger.info("getBookList ȣ�� ����");
		List<BookVO> bookList = null;
		BookDao bDao = new BookDao();
		//����¡ ó�� ���� �߰� - start�� end������ �߰�
		int total =0;//��ü ���ڵ� ����
		total = bDao.totalRecord();
		logger.info("�ѷ��ڵ尹��:"+total);
		//total���� json���Ͽ� ������ datagrid�� �߰��˴ϴ�.
		//total���� datagrid�� �߰��� ���� �ƴϹǷ� ������ ����Ͽ� ����ϴ�.
		if(req!=null){
			HttpSession session = req.getSession();
			session.setAttribute("total", total);
		}
		//ȭ��(currentPage:pMap)���� �޾ƿ��� ��
		int page = 0;//���� ����ڰ� �ٶ󺸴� ������ ��ȣ(1,2,....)
		//�� �������� ó���Ǵ� �ο� ��(ȭ��:pMap)\
		int pageSize = 0;
		if(pMap.get("page")!=null) 
			page = Integer.parseInt(pMap.get("page").toString());
		if(pMap.get("pageSize")!=null) 
			pageSize = Integer.parseInt(pMap.get("pageSize").toString());		
		int start = 0;//�������� ���� ��ȣ
		int end = 0;//�������� �� ��ȣ
		if(page > 0){
			start = ((page-1)*pageSize)+1;
			end = page*pageSize;
			pMap.put("start", start);
			//total�� end���� ������ end��� total���� ��� �ּ���.
			//�׷��� ������ end�� ��� �ּ���.
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










