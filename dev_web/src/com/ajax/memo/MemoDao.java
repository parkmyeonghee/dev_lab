package com.ajax.memo;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.vo.MemberVO;
import com.vo.MemoVO;

public class MemoDao {
	Logger logger = Logger.getLogger(MemoDao.class);
	SqlSessionFactory sqlMapper = null;
	SqlSession sqlSes = null;	
	public int memoInsert(MemoVO moVO) {
		logger.info("memoList호출 성공");
		int miResult=0;
			try {
				String resource = "com/myBatis/MapperConfig.xml";
				Reader reader = null;
				reader = Resources.getResourceAsReader(resource);
				sqlMapper = 
				new SqlSessionFactoryBuilder().build(reader);
				//boolean타입의 기본 값-false
				//openSession():자동 커밋이 일어나지 않는다.
				//즉 물리적인 테이블에 추가한 정보가 반영되도로고 하려면 따로 sqlSes.commit()호출해야 반영
				//opneSession(boolean isFalg)
				//isFlag가 true면 오토커밋
				//isFlag가 false이면 오토커밋 모드가 꺼져있다.
				sqlSes = sqlMapper.openSession();
				reader.close();
				miResult = sqlSes.insert("memoInsert",moVO);
				if(miResult==1){//입력성공
					sqlSes.commit();
				}
			} catch (IOException ie) {
				logger.info("IOException:"+ie.getMessage());
				ie.printStackTrace();
			}		
		return miResult;
	}
	public List<MemoVO> getReceiveMemoList(MemoVO pmoVO) {
		logger.info("getReceiveMemoList호출 성공");
		List<MemoVO>memoList=null;
		try {
			String resource = "com/myBatis/MapperConfig.xml";
			Reader reader = null;
			reader = Resources.getResourceAsReader(resource);
			sqlMapper = 
			new SqlSessionFactoryBuilder().build(reader);
			sqlSes = sqlMapper.openSession();
			reader.close();
			memoList = sqlSes.selectList("getReceiveMemoList",pmoVO);
			logger.info("memoList.size():"+memoList.size());
		} catch (IOException ie) {
			logger.info("IOException:"+ie.getMessage());
			ie.printStackTrace();
		}		
		return memoList;
	}
	
	public List<MemoVO> SendMemoList(MemoVO pmoVO) {
		logger.info("SendMemoList호출 성공");
		List<MemoVO>memoList=null;
		try {
			String resource = "com/myBatis/MapperConfig.xml";
			Reader reader = null;
			reader = Resources.getResourceAsReader(resource);
			sqlMapper = 
			new SqlSessionFactoryBuilder().build(reader);
			sqlSes = sqlMapper.openSession();
			reader.close();
			memoList = sqlSes.selectList("getReceiveMemoList",pmoVO);
			logger.info("memoList.size():"+memoList.size());
		} catch (IOException ie) {
			logger.info("IOException:"+ie.getMessage());
			ie.printStackTrace();
		}		
		return memoList;
	}
	public int memoDelete(MemoVO moVO) {
		logger.info("memoDelete호출 성공");
		return 0;
	}
	public int memoUpdate(MemoVO moVO) {
		logger.info("memoUpdate호출 성공");
		return 0;
	}

}
