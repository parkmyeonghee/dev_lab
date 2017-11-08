package com.mvc;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.vo.MemberVO;

//DB연동하기
public class MemberDao {
	Logger logger = Logger.getLogger(MemberDao.class);
	SqlSessionFactory sqlMapper=null;
	SqlSession sqlSes =null;

	public String login(MemberVO mvo)
	{
		String name =null;
		try {
			String resource ="com/myBatis/MapperConfig.xml";
			Reader reader = null;
			reader = Resources.getResourceAsReader(resource);
			sqlMapper=
					new SqlSessionFactoryBuilder().build(reader);
			sqlSes=sqlMapper.openSession();
			reader.close();
			name =sqlSes.selectOne("login",mvo);
			logger.info("쿠기에 담을 name"+name);
			System.out.println(name);
		} catch (IOException ie) {
			logger.info("IOException:"+ie.getMessage());
			ie.printStackTrace();
		}
		return name;
	}

}

