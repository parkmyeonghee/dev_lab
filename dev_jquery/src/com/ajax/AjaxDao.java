package com.ajax;

import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.ibatis.common.resources.Resources;
import com.vo.PictureVO;
import com.vo.WordVO;

public class AjaxDao {
	Logger logger = Logger.getLogger(AjaxDao.class);
	SqlSessionFactory sqlMapper = null;
	SqlSession sqlSes = null;
	String resource= "com/mybatis/MapperConfig.xml";
	public List<WordVO> getWordList(Map<String, Object> pMap) {
		logger.info("getWordList ȣ�� ����"+pMap.get("w_word"));
		List<WordVO>wordList =null;
		try {
			Reader reader = null;
			reader =Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			sqlSes= sqlMapper.openSession();//����Ŭ ������ Ŀ�ؼ� ���� ����
			reader.close();		
			wordList = sqlSes.selectList("getWordList",pMap);
			System.out.println("size:"+wordList.size());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return wordList;
	}
	public List<PictureVO>getPictureList(String pnum) {
		logger.info("getPictureList ȣ�� ����");
		List<PictureVO>picList =null;
		try {
			Reader reader = null;
			reader =Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			sqlSes= sqlMapper.openSession();//����Ŭ ������ Ŀ�ؼ� ���� ����
			reader.close();
			int ipnum=0;
			if(pnum !=null){
				ipnum=Integer.parseInt(pnum);
			}
			picList = sqlSes.selectList("getPictureList",ipnum);
			System.out.println("size:"+picList.size());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return picList;
	}
	public List<PictureVO> getPictureDetail(String pnum) {
		logger.info("getPictureDetailȣ�� ����");
		List<PictureVO>picDetail=null;
		try {
			Reader reader = null;
			reader =Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			sqlSes= sqlMapper.openSession();//����Ŭ ������ Ŀ�ؼ� ���� ����
			reader.close();
			int ipnum=0;
			if(pnum !=null){
				ipnum=Integer.parseInt(pnum);
			}
			picDetail = sqlSes.selectList("getPictureList",ipnum);
			System.out.println("size:"+picDetail.size());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return picDetail;
	}

}
