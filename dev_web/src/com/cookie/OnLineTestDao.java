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
	//SqlSessionFactory 는 MapperConfig.xml에 등록된 DB서버 정보를 읽어서 커넥션을
	//맺는데 사용합니다.
	SqlSessionFactory sqlMapper=null;
	//SqlSession은 위에서 생성된 SqlSessionFactory객체를 활용하여 객체 생성하고
	//커넥션을 열어 줍니다.
	SqlSession sqlSes =null;
	//프로시저 호출 테스트 하기
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
			//프로시저 사용시 파라미터 모드로 OUT속성으로 이용할 수 있다.
			//OUT속성의 경우 프로시저에서 처리된 결과나 메시지를 오라클이 아닌 외부로 내보낼 떄
			//사용하는 속성이다.
			//OUT속성의 경우에는 SELECT문 처리 때 처럼 resultType를 사용하지 않고
			//perametetType의 약속된 변수에 오라클이 값을 담준다.
			sqlSes.selectOne("proc_salupdate",eVO);
			msg=eVO.getMsg();
			logger.info("msg(OUT):"+eVO.getMsg());
	}catch (IOException ie) {
		logger.info("IOException:"+ie.getMessage());
	}
		return msg;
	}

	public int takeInsert(TakeVO ptVO) {
		logger.info("takeInsert 호출 성공");
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
			 * 트랜잭션 처리 - INSERT|UPDATE|DELETE
			 * JDBC API | ORM 솔루션
			 * con.setAutoCommit(false);
			 * commit or rollback
			 * iBatis -디폴트 오토커밋(true)
			 * myBatis - 오토커밋 -false
			 * sqlSes.openSession(true);
			 * sqlSes.openSession(false); 디폴트 값
			 * sqlSes.commit();
			 * sqlSes.rollback();
			 */
			if(tiResult==1){
				sqlSes.commit(); // 물리적인 테이블 반영하기
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
	 * @param peVO test_no(수험 번호),decision(판정결과),score(평가점수),take_yn(응시 여부)
	 * @return euResult :1이면 update성공 0이면 실패
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
				sqlSes.commit();//물리적인 테이블 반영하기
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
		logger.info("testLogin 호출 성공");
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
			logger.info("이름"+reVO.getT_name());
	}catch (IOException ie) {
		logger.info("IOException:"+ie.getMessage());
		ie.printStackTrace();
	}
		return reVO;
	}


}
