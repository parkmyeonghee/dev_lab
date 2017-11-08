package com.ajax.news;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.vo.NewsVO;

public class NewsDao {
	Logger logger =Logger.getLogger(NewsDao.class);
	SqlSessionFactory sqlMapper=null;
	SqlSession sqlSes =null;

	public List<NewsVO> getNewsList()
	{	
		
		logger.info("겟뉴스리스트");
		List<NewsVO> newsList=new ArrayList<NewsVO>();
		try {
			String resource ="com/mybatis/MapperConfig.xml";
			Reader reader = null;
			reader = Resources.getResourceAsReader(resource);
			sqlMapper=
					new SqlSessionFactoryBuilder().build(reader);
			sqlSes=sqlMapper.openSession();
			reader.close();
			newsList=sqlSes.selectList("getNewsList");
			logger.info("size:"+newsList.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newsList;
	}
}
