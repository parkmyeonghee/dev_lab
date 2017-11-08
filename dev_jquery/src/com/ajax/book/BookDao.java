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
	//전체 레코드 갯수 가져오기 - 13
	public int totalRecord() {
		logger.info("totalRecord호출 성공");
		int result = 0;
		try {
			Reader reader = null;
			reader = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			sqlSes = sqlMapper.openSession();//오라클서버와 커넥션 맺은상태
			reader.close();
			result = sqlSes.selectOne("totalRecord");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public List<BookVO> getBookList(Map<String, Object> pMap)
	{
		logger.info("getBookList 호출 성공");
		List<BookVO> bookList = null;
		try {
			Reader reader = null;
			reader = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			sqlSes = sqlMapper.openSession();//오라클서버와 커넥션 맺은상태
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
			//MapperConfig.xml문서를 읽어들인 정보를 가지고
			//Reader객체를 생성합니다.
			reader = Resources.getResourceAsReader(resource);
			//위에서 생성된 Reader객체를 활용하여 SqlSessionFactory
			//객체를 인스턴스화 합니다.
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			//위 에서 생성된 SqlSessionFactory객체에서 제공하는
			//openSession메소드를 호출하여 SqlSession객체를 생성함.
			sqlSes = sqlMapper.openSession();//오라클서버와 커넥션 맺은상태
			//필요한 SqlSession객체를 얻었으므로 Reader객체는 닫아줌.
			reader.close();
			//생성된 SqlSession객체에서 제공하는
			//selectList메소드 호출 가능합니다.
			//조회된 결과를 List에 담아 줍니다.
			//해당 id에 쿼리문을 처리 요청하는 메소드
			
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
			//stack영역에 등록된 로그 정보 출력해 줍니다.
			e.printStackTrace();
		}
		return bookList;
	}*/	
	public int bookInsert(Map<String, Object> pMap) {
		logger.info("bookInsert 호출 성공");
		int biResult = 0;
		try {
			Reader reader = null;
			reader = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			sqlSes = sqlMapper.openSession();//오라클서버와 커넥션 맺은상태
			reader.close();
		/*
		 * myBatis에서 DML구문 처리 요청할 때 사용하는 메소드
		 * insert일때: sqlSes.insert("쿼리문 id",bookVO):int;
		 * update일 때: sqlSes.update("쿼리문 id",bookVO):int;
		 * delete일때: sqlSes.delete("쿼리문 id",bookVO):int;	
		 * 조회일때:
		 * 1)sqlSes.selectOne("쿼리문 id",bookVO):Object;왜 1건 이니까
		 * 2)sqlSes.selectList("쿼리문 id",bookVO):List;
		 * 3)sqlSes.selectMap("쿼리문 id", bookVO):Map;
		 * 프로시저일 때는 어떡하지?
		 * 
		 */
			biResult = sqlSes.insert("bookInsert",pMap);
			//커밋처리
			sqlSes.commit();
			logger.info("추가 성공 여부 : "+biResult);
		} catch (Exception e) {
			//stack영역에 등록된 로그 정보 출력해 줍니다.
			e.printStackTrace();
		}
		return biResult;  
	}
}
