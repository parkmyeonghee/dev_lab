package com.ajax.member;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.vo.MemberVO;


//DB연동하기
public class MemberDao {
	Logger logger = Logger.getLogger(MemberDao.class);
	SqlSessionFactory sqlMapper = null;
	SqlSession sqlSes = null;	
	public MemberVO login(MemberVO mvo)
	{
		logger.info("login 호출 성공");
		
		logger.info(mvo.getMem_id());
		String name = null;
		MemberVO rmVO =null;
		try {
			String resource = "com/myBatis/MapperConfig.xml";
			Reader reader = null;
			reader = Resources.getResourceAsReader(resource);
			sqlMapper = 
			new SqlSessionFactoryBuilder().build(reader);
			sqlSes = sqlMapper.openSession();
			reader.close();
			rmVO = sqlSes.selectOne("login",mvo);
			logger.info("쿠키에 담을 name:"+rmVO.getMem_name());
		} catch (IOException ie) {
			logger.info("IOException:"+ie.getMessage());
			ie.printStackTrace();
		}		
		return rmVO ;
	}
	public List<MemberVO> getMemberList() {
		logger.info("login 호출 성공");
		List<MemberVO> memList = null;
		try {
			String resource = "com/myBatis/MapperConfig.xml";
			Reader reader = null;
			reader = Resources.getResourceAsReader(resource);
			sqlMapper = 
			new SqlSessionFactoryBuilder().build(reader);
			sqlSes = sqlMapper.openSession();
			reader.close();
			memList = sqlSes.selectList("getMemberList");
			logger.info("memList.size():"+memList.size());
		} catch (IOException ie) {
			logger.info("IOException:"+ie.getMessage());
			ie.printStackTrace();
		}		 
		return memList;
	}

}
