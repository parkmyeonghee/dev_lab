package com.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.dao.DataAccessException;

import com.vo.EmpVO;

public class SqlMapEmpDao {
	Logger logger = Logger.getLogger(SqlMapEmpDao.class);
	public SqlSessionTemplate sqlSessionTemplate = null;//������ ȣ��
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	public String proc_salupdate(EmpVO eVO){
		logger.info("sql proc");
		String msg =null;
		sqlSessionTemplate.selectList("proc_salupdate",eVO);
		msg=eVO.getMsg();
		return msg;
	}
	/*************************************************************************************
	 * ������ : ������ ��ȸ ����
	 * @param  : Map<String,Object> 
	 * @return : List<Map<String,Object>>
	 *************************************************************************************/
	public List<EmpVO> getEmpList(Map<String,Object> pMap)
	{
		logger.info("getEmpList ȣ�� ����");
		List<EmpVO> empList = null;//DB
		empList = sqlSessionTemplate.selectList("getEmpList",pMap);
		return empList;
	}
	/*************************************************************************************
	 * ������ : ������ ��ȸ ����
	 * @param  : Map<String,Object> 
	 * @return : List<Map<String,Object>>
	 *************************************************************************************/
	public List<EmpVO> getEmpList2(String pempno)
	{  
		logger.info("getEmpList ȣ�� ����");
		List<EmpVO> empList = null;//DB
		//insert here  
		StringTokenizer st = new StringTokenizer(pempno, ",");
		String empnos[] = new String[st.countTokens()];
		for(int i=0;i<empnos.length;i++){
			empnos[i] = st.nextToken();
		}
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<empnos.length;i++){
			list.add(Integer.parseInt(empnos[i]));
		}	
		logger.info("list:"+list.get(0)+", "+list.get(1));
		empList = sqlSessionTemplate.selectList("getEmpList2",list);
		//empList = sqlSessionTemplate.selectList("getEmpList2",empnos);
		return empList;
	}	
	public int empDelete(String[] deptnos) {
		logger.info("empDelete ȣ�� ����");
		int result =0;
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<deptnos.length;i++){
			list.add(Integer.parseInt(deptnos[i]));
		}
		result = sqlSessionTemplate.delete("empDeleteALL",list);
		return result;
	}
	public int empInsert (EmpVO eVO) throws DataAccessException {
		int result = 0;
		result = sqlSessionTemplate.insert("empInsert",eVO);
		return result;
	}
	public int empUpdate(EmpVO eVO) {
		int result = 0;
		result = sqlSessionTemplate.update("empUpdate",eVO);
		return result;
	}
}











