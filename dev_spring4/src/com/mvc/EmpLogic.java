package com.mvc;

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
public class EmpLogic {
	Logger logger = Logger.getLogger(EmpController.class);
	@Autowired
	public SqlMapEmpDao sqlMapEmpDao = null;
	/*************************************************************************************
	 * 업무명 : 사원목록 조회 구현
	 * @param  : Map<String,Object> 
	 * @return : List<EmpVO>
	 *************************************************************************************/
	public List<EmpVO> getEmpList(Map<String,Object> pMap)
	{
		logger.info("getEmpList 호출 성공");
		List<EmpVO> empList = null;//DB
		empList = sqlMapEmpDao.getEmpList(pMap);
		return empList;
	}
	//점조건 조회하기
	public List<EmpVO> getEmpList2(Map<String,Object> pMap)
	{
		logger.info("getEmpList2 호출 성공");
		List<EmpVO> empList = null;//DB
		String pempno = pMap.get("deptno").toString();
		//pempno=> 10,30,40
		empList = sqlMapEmpDao.getEmpList2(pempno);
		return empList;
	}
	public int empDelete(String pempno) {
		logger.info("empDelete 호출 성공");
		int result = 0;
		StringTokenizer st = new StringTokenizer(pempno,",");
		String empnos[] = new String[st.countTokens()];
		for(int i=0;i<empnos.length;i++){
			empnos[i] = st.nextToken();
		}		
		result = sqlMapEmpDao.empDelete(empnos);
		return result;
	}
	public int empInsert(EmpVO eVO) {
		logger.info("empInsert 호출 성공");
		int result = 0;
		result = sqlMapEmpDao.empInsert(eVO);
		return result;
	}
	public int empUpdate(EmpVO eVO) {
		logger.info("empUpdate 호출 성공");
		int result = 0;
		result = sqlMapEmpDao.empUpdate(eVO);
		return result;
	}
	public String proc_salupdate(EmpVO eVO) {
		logger.info("뀨");
		String msg =sqlMapEmpDao.proc_salupdate(eVO);
		return msg;
	}
}





