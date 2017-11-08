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
	//��ü ���ڵ� ���� ��������
	public int totalRecord() {
		logger.info("totalRecord ȣ�⼺��");
		int result=0;
		result=sqlSessionTemplate.selectOne("totalRecord");
		return result;
	}
	public List<HashMap> getDeptList(Map<String, Object> pMap) {
		logger.info("getDeptList ȣ�⼺��");
		List<HashMap>deptList=null;
		deptList=sqlSessionTemplate.selectList("getDeptList",pMap);
		return deptList;
	}
	//JSON�ڵ� ��ȯ �ǽ�
	public List<DeptVO> getDeptList2(Map<String, Object> pMap) {
		logger.info("getDeptList2 ȣ�⼺��");
		List<DeptVO>deptList=null;
		deptList=sqlSessionTemplate.selectList("getDeptList",pMap);
		return deptList;
	}
	//Ŀ�Ը��
	/*******************************************************************************
	 * �Է�,����,������ ��� commit or rollback�� ����̴�.
	 * myBatis������ �⺻ Ŀ�Ը��� AOTOCOMMIT
	 * AUTOCOMIT�̶� ������ commit�� �ڵ����� �Ͼ��.
	 * openSession�޼ҵ忡�� ����Ŀ�� ��带 ������ �� �ִ�.
	 * (true:�ڵ�Ŀ�� /  false:�ڵ�Ŀ�Ը�� ����)
	 * SqlSessionŬ���������� openSession�޼ҵ带 �����ϰ� ������ 
	 * SqlSessionTemplate ������ �������� �ʰ� �ִ�.
	 * �����ϴ� �޼ҵ�
	 * 1.commit()
	 * 2.commit(boolean)
	 *3. rollback()
	 * 4.rollback(boolean) 
	 * Ȯ���غ� ����:SqlSessionTemplate�� ����ϴ� ������ API�� �����ǰ� �ִ°�?
	 * 			�ٸ� Ŭ������ �����ؼ�(��ȸ�ؼ�) ó���ϴ� ����� ����?
	 * @param pMap
	 * @return
	 * @throws DataAccessException
	 *******************************************************************************/
	public int getDeptInsert(Map<String, Object> pMap)throws DataAccessException {
		logger.info("getDeptInsert ȣ�⼺��");
		int result=0;
		result=sqlSessionTemplate.insert("deptInsert",pMap);
		return result;
	}
	/***********************************************************************************************************
	 * ���̹�Ƽ���� typealias Ȱ���� ����
	 * @param pMap
	 * @return
	********************************************************************************************************* */
	public int getDeptDelete(Map<String, Object> pMap) {
		logger.info("getDeptDelete ȣ�⼺��");
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
		logger.info("getDeptnoList ȣ�⼺��");
		List<HashMap>deptList=null;
		deptList=sqlSessionTemplate.selectList("getDeptnoList",pMap);
		return deptList;
	}
	public int DeptUpdate(Map<String, Object> pMap) {
		logger.info("DeptUpdateȣ�⼺��");
		int result=0;
		result=sqlSessionTemplate.update("DeptUpdate",pMap);
		return result;
	}

}
