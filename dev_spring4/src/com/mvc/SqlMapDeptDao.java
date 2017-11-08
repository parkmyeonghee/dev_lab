package com.mvc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.dao.DataAccessException;

import com.vo.DeptVO;

public class SqlMapDeptDao {
	Logger logger = Logger.getLogger(SqlMapDeptDao.class);
	public SqlSessionTemplate sqlSessionTemplate=null;
	public void setSqlSessionTemplate(SqlSessionTemplate  sqlSessionTemplate){
		this.sqlSessionTemplate=sqlSessionTemplate;
	}
	//전체 레코드 갯수 가져오기
	public int totalRecord() {
		logger.info("totalRecord 호출성공");
		int result=0;
		result=sqlSessionTemplate.selectOne("totalRecord");
		return result;
	}
	public List<HashMap> getDeptList(Map<String, Object> pMap) {
		logger.info("getDeptList 호출성공");
		List<HashMap>deptList=null;
		deptList=sqlSessionTemplate.selectList("getDeptList",pMap);
		return deptList;
	}
	//JSON코드 변환 실습
	public List<DeptVO> getDeptList2(Map<String, Object> pMap) {
		logger.info("getDeptList2 호출성공");
		List<DeptVO>deptList=null;
		deptList=sqlSessionTemplate.selectList("getDeptList",pMap);
		return deptList;
	}
	//커밋모드
	/*******************************************************************************
	 * 입력,수정,삭제는 모두 commit or rollback의 대상이다.
	 * myBatis에서도 기본 커밋모드는 AOTOCOMMIT
	 * AUTOCOMIT이란 조건이 commit이 자동으로 일어난다.
	 * openSession메소드에서 오토커밋 모드를 변경할 수 있다.
	 * (true:자동커밋 /  false:자동커밋모드 해제)
	 * SqlSession클래스에서는 openSession메소드를 지원하고 있지만 
	 * SqlSessionTemplate 에서는 지원하지 않고 있다.
	 * 지원하는 메소드
	 * 1.commit()
	 * 2.commit(boolean)
	 *3. rollback()
	 * 4.rollback(boolean) 
	 * 확인해볼 내용:SqlSessionTemplate를 대신하는 별도의 API가 제공되고 있는가?
	 * 			다른 클래스와 연계해서(우회해서) 처리하는 방법이 존재?
	 * @param pMap
	 * @return
	 * @throws DataAccessException
	 *******************************************************************************/
	public int getDeptInsert(Map<String, Object> pMap)throws DataAccessException {
		logger.info("getDeptInsert 호출성공");
		int result=0;
		result=sqlSessionTemplate.insert("deptInsert",pMap);
		return result;
	}
	/***********************************************************************************************************
	 * 마이바티스에 typealias 활용해 보기
	 * @param pMap
	 * @return
	********************************************************************************************************* */
	public int getDeptDelete(Map<String, Object> pMap) {
		logger.info("getDeptDelete 호출성공");
		DeptVO dVO = new DeptVO();
		String sdeptno=pMap.get("deptno").toString();
		int deptno=0;
		if(sdeptno !=null) deptno=Integer.parseInt(sdeptno);
		dVO.setDeptno(deptno);
		int result=0;
		result=sqlSessionTemplate.insert("deptInsert",dVO);
		return result;
	}
	public List<HashMap> getDeptnoList(Map<String, Object> pMap) {
		logger.info("getDeptnoList 호출성공");
		List<HashMap>deptList=null;
		deptList=sqlSessionTemplate.selectList("getDeptnoList",pMap);
		return deptList;
	}
	public int DeptUpdate(Map<String, Object> pMap) {
		logger.info("DeptUpdate호출성공");
		int result=0;
		result=sqlSessionTemplate.update("DeptUpdate",pMap);
		return result;
	}

}
