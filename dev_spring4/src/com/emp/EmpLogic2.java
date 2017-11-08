package com.emp;

import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vo.EmpVO;

@Service
public class EmpLogic2 {
	Logger logger = Logger.getLogger(EmpLogic2.class);
	@Autowired
	public SqlMapEmpDao2 slqMapEmpDao=null;
	/*******************************************************************************
	 * 업무명: 사원목록 조회 구현
	 * @param: Map<String,Object>
	 * @return: List<EmpVO>
	 *******************************************************************************/
	@RequestMapping(value="getEmpList.kosmo")
	public List<EmpVO> getEmpList(Map<String,Object>pMap)
	{
		logger.info("getEmpList 호출 성공");
		List<EmpVO> empList=null;//DB
		empList=slqMapEmpDao.getEmpList(pMap);
		return empList;
	}
	//점 조건 조회 하기
	public List<EmpVO> getEmpList2(Map<String,Object>pMap)
	{
		logger.info("getEmpList2 호출 성공");
		List<EmpVO> empList=null;//DB
		String pempno=pMap.get("deptno").toString();
		//pempno =>10,30,40
		empList=slqMapEmpDao.getEmpList2(pempno);
		return empList;
	}
/*	public int emptDelete(Map<String, Object> pMap) {
		logger.info("empDelete 호출성공");
		int result=0;
		result=slqMapEmpDao.empDelete(pMap);
		return result;
	}*/
	public int empDelete(String pempno) {
		logger.info("empDelete 호출성공");
		int result=0;
		StringTokenizer st = new StringTokenizer(pempno,",");
		String empnos[] = new String[st.countTokens()];
		for(int i=0;i<empnos.length;i++){
			empnos[i]=st.nextToken();
		}
		result=slqMapEmpDao.empDelete(empnos);
		return result;
	}

}
