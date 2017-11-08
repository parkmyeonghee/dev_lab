package com.ajax.book;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.vo.BookVO;


public class BookDao {
	Logger logger = Logger.getLogger(BookDao.class);
	SqlSessionFactory sqlMapper = null;
	SqlSession sqlSes = null;
	String resource = "com/mybatis/MapperConfig.xml";
	//��ü ���ڵ� ���� �������� - 13
	public int totalRecord() {
		logger.info("totalRecordȣ�� ����");
		int result = 0;
		try {
			Reader reader = null;
			reader = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			sqlSes = sqlMapper.openSession();//����Ŭ������ Ŀ�ؼ� ��������
			reader.close();
			result = sqlSes.selectOne("totalRecord");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public List<BookVO> getBookList(Map<String, Object> pMap)
	{
		logger.info("getBookList ȣ�� ����");
		List<BookVO> bookList = null;
		try {
			Reader reader = null;
			reader = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			sqlSes = sqlMapper.openSession();//����Ŭ������ Ŀ�ؼ� ��������
			reader.close();
			bookList = sqlSes.selectList("getBookList",pMap);
			System.out.println("size : "+bookList.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookList;
	}
/*	public List<HashMap<String,Object>> getBookList()
	{
		List<HashMap<String,Object>> bookList = null;
		try {
			Reader reader = null;
			//MapperConfig.xml������ �о���� ������ ������
			//Reader��ü�� �����մϴ�.
			reader = Resources.getResourceAsReader(resource);
			//������ ������ Reader��ü�� Ȱ���Ͽ� SqlSessionFactory
			//��ü�� �ν��Ͻ�ȭ �մϴ�.
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			//�� ���� ������ SqlSessionFactory��ü���� �����ϴ�
			//openSession�޼ҵ带 ȣ���Ͽ� SqlSession��ü�� ������.
			sqlSes = sqlMapper.openSession();//����Ŭ������ Ŀ�ؼ� ��������
			//�ʿ��� SqlSession��ü�� ������Ƿ� Reader��ü�� �ݾ���.
			reader.close();
			//������ SqlSession��ü���� �����ϴ�
			//selectList�޼ҵ� ȣ�� �����մϴ�.
			//��ȸ�� ����� List�� ��� �ݴϴ�.
			//�ش� id�� �������� ó�� ��û�ϴ� �޼ҵ�
			
			bookList = sqlSes.selectList("getBookList");
			//Object(BookVO) obj = sqlSes.selectOne("getBookDetail");
			//Map map = sqlSes.selectMap("ab_title", HashMap|VO|int)
			HashMap<String,Object> pMap 
					= new HashMap<String,Object>();
			pMap.put("ab_no", 1);
			sqlSes.delete("bookDelete", pMap);
			System.out.println("size : "+bookList.size());
			for(HashMap pMap:bookList){
				System.out.println(pMap.get("AB_TITLE"));
				System.out.println(pMap.get("AB_PRICE"));
			}
		} catch (Exception e) {
			//stack������ ��ϵ� �α� ���� ����� �ݴϴ�.
			e.printStackTrace();
		}
		return bookList;
	}*/	
	public int bookInsert(Map<String, Object> pMap) {
		logger.info("bookInsert ȣ�� ����");
		int biResult = 0;
		try {
			Reader reader = null;
			reader = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			sqlSes = sqlMapper.openSession();//����Ŭ������ Ŀ�ؼ� ��������
			reader.close();
		/*
		 * myBatis���� DML���� ó�� ��û�� �� ����ϴ� �޼ҵ�
		 * insert�϶�: sqlSes.insert("������ id",bookVO):int;
		 * update�� ��: sqlSes.update("������ id",bookVO):int;
		 * delete�϶�: sqlSes.delete("������ id",bookVO):int;	
		 * ��ȸ�϶�:
		 * 1)sqlSes.selectOne("������ id",bookVO):Object;�� 1�� �̴ϱ�
		 * 2)sqlSes.selectList("������ id",bookVO):List;
		 * 3)sqlSes.selectMap("������ id", bookVO):Map;
		 * ���ν����� ���� �����?
		 * 
		 */
			biResult = sqlSes.insert("bookInsert",pMap);
			//Ŀ��ó��
			sqlSes.commit();
			logger.info("�߰� ���� ���� : "+biResult);
		} catch (Exception e) {
			//stack������ ��ϵ� �α� ���� ����� �ݴϴ�.
			e.printStackTrace();
		}
		return biResult;  
	}
}
