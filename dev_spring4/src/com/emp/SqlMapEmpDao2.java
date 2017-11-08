package com.emp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vo.DeptVO;
import com.vo.EmpVO;

public class SqlMapEmpDao2 {
	Logger logger = Logger.getLogger(SqlMapEmpDao2.class);
	public SqlSessionTemplate sqlSessionTemplate =null;//쿼리문 호출
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	/*******************************************************************************
	 * 업무명: 사원목록 조회 구현
	 * @param: Map<String,Object>
	 * @return: List<Map<String,Object>>
	 *******************************************************************************/
	public List<EmpVO> getEmpList(Map<String, Object> pMap) {
		logger.info("getEmpList 호출 성공");
		List<EmpVO> empList=null;//DB
		empList=sqlSessionTemplate.selectList("getEmpList",pMap);
		return empList;
	}
	public List<EmpVO> getEmpList2(String pempno) {
		logger.info("getEmpList2 호출 성공");
		List<EmpVO> empList=null;//DB
		StringTokenizer st = new StringTokenizer(pempno,",");
		String empnos[] = new String[st.countTokens()];
		for(int i=0;i<empnos.length;i++){
			empnos[i]=st.nextToken();
		}
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<empnos.length;i++){
			list.add(Integer.parseInt(empnos[i]));
		}
		empList=sqlSessionTemplate.selectList("getEmpList2",list);
	//	empList=sqlSessionTemplate.selectList("getEmpList2",empnos);
		return empList;
	}
/*	public int empDelete(Map<String, Object> pMap) {
		logger.info("empUpdate호출성공");
		EmpVO eVO = new EmpVO();
		String sempno=pMap.get("empno").toString();
		int empno=0;
		if(sempno !=null) empno=Integer.parseInt(sempno);
		eVO.setEmpno(empno);
		int result=0;
		result=sqlSessionTemplate.delete("empDelete",eVO);
		return result;	
	}*/
	public int empDelete(String[] deptnos) {
		logger.info("empDelete호출 성공");
		int result =0;
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<deptnos.length;i++){
			list.add(Integer.parseInt(deptnos[i]));
		}
		result=sqlSessionTemplate.delete("empDeleteALL",list);
		return result;
	}

}
