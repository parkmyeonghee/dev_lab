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
		logger.info("memoListȣ�� ����");
		int miResult=0;
			try {
				String resource = "com/myBatis/MapperConfig.xml";
				Reader reader = null;
				reader = Resources.getResourceAsReader(resource);
				sqlMapper = 
				new SqlSessionFactoryBuilder().build(reader);
				//booleanŸ���� �⺻ ��-false
				//openSession():�ڵ� Ŀ���� �Ͼ�� �ʴ´�.
				//�� �������� ���̺� �߰��� ������ �ݿ��ǵ��ΰ� �Ϸ��� ���� sqlSes.commit()ȣ���ؾ� �ݿ�
				//opneSession(boolean isFalg)
				//isFlag�� true�� ����Ŀ��
				//isFlag�� false�̸� ����Ŀ�� ��尡 �����ִ�.
				sqlSes = sqlMapper.openSession();
				reader.close();
				miResult = sqlSes.insert("memoInsert",moVO);
				if(miResult==1){//�Է¼���
					sqlSes.commit();
				}
			} catch (IOException ie) {
				logger.info("IOException:"+ie.getMessage());
				ie.printStackTrace();
			}		
		return miResult;
	}
	public List<MemoVO> getReceiveMemoList(MemoVO pmoVO) {
		logger.info("getReceiveMemoListȣ�� ����");
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
		logger.info("SendMemoListȣ�� ����");
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
		logger.info("memoDeleteȣ�� ����");
		return 0;
	}
	public int memoUpdate(MemoVO moVO) {
		logger.info("memoUpdateȣ�� ����");
		return 0;
	}

}
