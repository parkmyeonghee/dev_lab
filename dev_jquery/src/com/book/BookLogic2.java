package com.book;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.vo.BookVO;
//XXX.Logic.java������ �Ǵ�,����,����,å��,Ʈ����� ó��
//XXX.Logic.java������ ���� DB�����κκ��� ó������ �ʽ��ϴ�.
//���� ó��?-->XXXDao.java
public class BookLogic2 {
	Logger logger = Logger.getLogger(BookLogic2.class);
	public int bookInsert(BookVO pbVO) {
		logger.info("bookInsert ȣ�� ����");
		return 0;
	}
	public int bookInsert(Map<String, Object> pMap) {
		logger.info("bookInsert ȣ�� ����");
		BookDao2 bDao = new BookDao2();
		int biResult=0;
		biResult=bDao.bookInsert(pMap);
		return biResult;
	}
	public List<BookVO> getBookList(Map<String, Object> pMap,HttpServletRequest req) {
		logger.info("getBookListȣ�⼺��");
		List<BookVO> bookList=null;
		BookDao2 bDao = new BookDao2();
		//����¡ ó�� ���� �߰� -start �� end ������ �߰�
		int total=0; //��ü ���ڵ� ����
		total=bDao.totalRecord();
		logger.info("�ѷ��ڵ� ����:"+total);
		//total���� json���Ͽ� ������ datagrid�� �߰�
		//total���� datagrid�� �߰��� ���� �ƴϹǷ� ������ ����Ͽ� ����ϴ�.
		if(req !=null){
			HttpSession session = req.getSession();
			session.setAttribute("total", total);
			}
		//ȭ��(currentPage:pMap)���� �޾ƿ��� ��
		int page=0;//���� ����ڰ� �ٶ󺸴� ������ ��ȣ(1,2,...)
		//�� �������� ó�� �Ǵ� �ο�(ȭ��:pMap)
		int pageSize=0;
		if(pMap.get("page")!=null)
			page=Integer.parseInt(pMap.get("page").toString());
		if(pMap.get("pageSize")!=null)
			pageSize=Integer.parseInt(pMap.get("pageSize").toString());
		int start=0;//�������� ���۹�ȣ
		int end=0;//�������� �� ��ȣ
		if(page<0){
			start=((page-1)*pageSize)+1;
			end=page*pageSize;
			pMap.put("start", start);
			//total�� end���� ������ end��� total���� ��� �ּ���
			//�׷��� ������ end�� ��� �ּ��� 
			pMap.put("end", end);
		if(total<end){
			pMap.put("total", total);
		}
		else{
			pMap.put("end", end);
		}
		}///////////////////////////end of page>0
		logger.info("start:"+pMap.get("start")); //1 11 21
		logger.info("end:"+pMap.get("end")); //10 20 30 33
		bookList=bDao.getBookList(pMap);
		return bookList;
	}
	
	
}
