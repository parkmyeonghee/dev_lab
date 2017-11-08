package com.cookie;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.vo.EmpVO;
import com.vo.ExamPaperVO;
import com.vo.ExamineeVO;
import com.vo.RightAnswerVO;
import com.vo.TakeVO;

public class OnLineTestDao {
	Logger logger = Logger.getLogger(OnLineTestDao.class);
	//SqlSessionFactory �� MapperConfig.xml�� ��ϵ� DB���� ������ �о Ŀ�ؼ���
	//�δµ� ����մϴ�.
	SqlSessionFactory sqlMapper=null;
	//SqlSession�� ������ ������ SqlSessionFactory��ü�� Ȱ���Ͽ� ��ü �����ϰ�
	//Ŀ�ؼ��� ���� �ݴϴ�.
	SqlSession sqlSes =null;
	//���ν��� ȣ�� �׽�Ʈ �ϱ�
	public String proc_salupdate(int p_empno){
		String msg =null;
		try {
			String resource ="com/myBatis/MapperConfig.xml";
			Reader reader = null;
			reader = Resources.getResourceAsReader(resource);
			sqlMapper=
					new SqlSessionFactoryBuilder().build(reader);
			sqlSes=sqlMapper.openSession();
			reader.close();
			EmpVO eVO = new EmpVO();
			eVO.setEmpno(p_empno);
			//���ν��� ���� �Ķ���� ���� OUT�Ӽ����� �̿��� �� �ִ�.
			//OUT�Ӽ��� ��� ���ν������� ó���� ����� �޽����� ����Ŭ�� �ƴ� �ܺη� ������ ��
			//����ϴ� �Ӽ��̴�.
			//OUT�Ӽ��� ��쿡�� SELECT�� ó�� �� ó�� resultType�� ������� �ʰ�
			//perametetType�� ��ӵ� ������ ����Ŭ�� ���� ���ش�.
			sqlSes.selectOne("proc_salupdate",eVO);
			msg=eVO.getMsg();
			logger.info("msg(OUT):"+eVO.getMsg());
	}catch (IOException ie) {
		logger.info("IOException:"+ie.getMessage());
	}
		return msg;
	}

	public int takeInsert(TakeVO ptVO) {
		logger.info("takeInsert ȣ�� ����");
		int tiResult =0;
		try {
			String resource ="com/myBatis/MapperConfig.xml";
			Reader reader = null;
			reader = Resources.getResourceAsReader(resource);
			sqlMapper=
					new SqlSessionFactoryBuilder().build(reader);
			sqlSes=sqlMapper.openSession();
			reader.close();
			tiResult = sqlSes.insert("takeInsert",ptVO);
			logger.info("tiResult"+tiResult);
			/*
			 * Ʈ����� ó�� - INSERT|UPDATE|DELETE
			 * JDBC API | ORM �ַ��
			 * con.setAutoCommit(false);
			 * commit or rollback
			 * iBatis -����Ʈ ����Ŀ��(true)
			 * myBatis - ����Ŀ�� -false
			 * sqlSes.openSession(true);
			 * sqlSes.openSession(false); ����Ʈ ��
			 * sqlSes.commit();
			 * sqlSes.rollback();
			 */
			if(tiResult==1){
				sqlSes.commit(); // �������� ���̺� �ݿ��ϱ�
			}
	}catch (IOException ie) {
		ie.printStackTrace();
	}
		return tiResult;
}
	
	public RightAnswerVO getRightAnswer(String exam_cd) {
		RightAnswerVO rraVO = null;
		try {
			String resource ="com/myBatis/MapperConfig.xml";
			Reader reader = null;
			reader = Resources.getResourceAsReader(resource);
			sqlMapper=
					new SqlSessionFactoryBuilder().build(reader);
			sqlSes=sqlMapper.openSession();
			reader.close();
			rraVO = sqlSes.selectOne("getRightAnswer",exam_cd);
			logger.info("rraVO"+rraVO);
	}catch (IOException ie) {
		ie.printStackTrace();
	}
		return rraVO;
	}
	
	public TakeVO getTake(TakeVO ptVO) {
		
		return null;
	}
	/******************************************************************************************************
	 * 
	 * @param peVO test_no(���� ��ȣ),decision(�������),score(������),take_yn(���� ����)
	 * @return euResult :1�̸� update���� 0�̸� ����
	 ****************************************************************************************************/
	public int examineeUpdate(ExamineeVO peVO) {
		int euResult =0;
		try {
			String resource ="com/myBatis/MapperConfig.xml";
			Reader reader = null;
			reader = Resources.getResourceAsReader(resource);
			sqlMapper=
					new SqlSessionFactoryBuilder().build(reader);
			sqlSes=sqlMapper.openSession();
			reader.close();
			euResult= sqlSes.update("examineeUpdate",peVO);
			logger.info("euResult"+euResult);
			if(euResult==1){
				sqlSes.commit();//�������� ���̺� �ݿ��ϱ�
			}
	}catch (IOException ie) {
		ie.printStackTrace();
	}
		return euResult;
	}
	public ExamineeVO examineeDetail(String test_no) {
		
		return null;
	}

	public ExamineeVO testLogin(ExamineeVO peVO) {
		logger.info("testLogin ȣ�� ����");
		ExamineeVO reVO =null;
		try {
			String resource ="com/myBatis/MapperConfig.xml";
			Reader reader = null;
			reader = Resources.getResourceAsReader(resource);
			sqlMapper=
					new SqlSessionFactoryBuilder().build(reader);
			sqlSes=sqlMapper.openSession();
			reader.close();
			reVO = sqlSes.selectOne("testLogin",peVO);
			logger.info("�̸�"+reVO.getT_name());
	}catch (IOException ie) {
		logger.info("IOException:"+ie.getMessage());
		ie.printStackTrace();
	}
		return reVO;
	}


}
