package com.mvc;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisTest {

	public static void main(String[] args) {
		SqlSessionFactory sqlMapper=null;
		SqlSession sqlSes =null;
		try {
			String resource ="com/myBatis/MapperConfig.xml";
			Reader reader = null;
			reader = Resources.getResourceAsReader(resource);
			sqlMapper=
					new SqlSessionFactoryBuilder().build(reader);
			sqlSes=sqlMapper.openSession();
			reader.close();
			String currentTime=sqlSes.selectOne("currentTime");
			System.out.println("DB서버의 현재 날짜:"+currentTime);
		} catch (IOException ie) {
		}
	}

}
