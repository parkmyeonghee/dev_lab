package com.pic;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.vo.PictureVO;
import com.vo.WordVO;

public class AjaxDao {
	Logger logger = Logger.getLogger(AjaxDao.class);
	SqlSessionFactory sqlMapper = null;
	SqlSession sqlSes = null;
	String resource = "com/mybatis/MapperConfig.xml";
	public List<WordVO> getWordList(String pwword) {
		List<WordVO> wordList = null;
		try {
			Reader reader = null;
			reader = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			sqlSes = sqlMapper.openSession();//오라클서버와 커넥션 맺은상태
			reader.close();
			wordList = sqlSes.selectList("getWordList",pwword);
			System.out.println("size : "+wordList.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return wordList;
	}
	public List<PictureVO> getPictureList(String pnum) {
		List<PictureVO> picList = null;
		try {
			Reader reader = null;
			reader = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			sqlSes = sqlMapper.openSession();//오라클서버와 커넥션 맺은상태
			reader.close();
			int ipnum = 0;
			if(pnum !=null){
				ipnum = Integer.parseInt(pnum);
			}
			picList = sqlSes.selectList("getPictureList",ipnum);
			System.out.println("size : "+picList.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return picList;
	}

}
