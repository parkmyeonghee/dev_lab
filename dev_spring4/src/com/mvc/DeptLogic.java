package com.mvc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vo.DeptVO;
import com.vo.EmpVO;

@Service
public class DeptLogic {
	Logger logger = Logger.getLogger(DeptLogic.class);
	@Autowired
	public SqlMapDeptDao sqlMapDeptDao = null;
	
	@Autowired
	public SqlMapEmpDao sqlMapEmpDao = null;
/******************************************************************************
 * Ʈ����� ó�� �׽�Ʈ ó���ϱ�
 * 1)�μ� ���̺� ���ο� �μ� ���� ����ϱ�
 * deptno=80,dname="�ڵ���",loc="����"
 * 2)��� ���̺� �������� ����ϱ�
 * empno=8001,ename=������,deptno=80
 * �׽�Ʈ �ó�����
 * 1���� ���������� ó���ǵ��� �ϰ�
 * 2�������� �÷����� �߸� �ۼ��Ͽ� �������� �ĺ��� ������ �߻��ϵ��� ó��
 * 1����2�� ��ΰ� ���������� ó���Ǿ��� �� Ŀ���ϰ�
 * �� �� �ϳ��� �����Ͽ��� ���� rollbackó��
 * ���� ����
 * �μ������� ��������� ���� LogicŬ������ ���� �ٸ��Ƿ� SqlMapEmDao��
 * ��ü ������ ���� �� �ֵ��� �ڵ带 �߰�
 * ����ڷ� ���� �Է¹��� ���� ����� �߰��Ͽ� �׽�Ʈ
 * @param pMap
 * @param req
 * @return
 *******************************************************************************/
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={DataAccessException.class})
	@Pointcut(value="exrcution(*com.mvc.*Logic.*(..))")
	public void trTest(){
		int dResult=0;
		int eResult=0;
		Map<String,Object>pMap= new HashMap<String,Object>();
		pMap.put("deptno",80);
		pMap.put("dname", "�ڵ���");
		pMap.put("loc", "����");
		pMap.put("empno", 8001);
		pMap.put("ename", "������");
		EmpVO peVO = new EmpVO();
		peVO.setEmpno(8001);
		peVO.setEname("������");
		peVO.setDeptno(80);
		//�Ʒ� �ڵ忡�� SQLException�� �߻��� �� �����Ƿ� ����ó���� Ȱ���Ͽ�
		//Ŀ�԰� �ѹ��� ������ ���ô�.
		//���ܰ� �߻��ϸ� rollback()�޼ҵ带 ȣ���ϰ� ������ ���� �� commit()��/
		try {
		dResult =sqlMapDeptDao.getDeptInsert(pMap);
		eResult=sqlMapEmpDao.empInsert(peVO);
		} catch (DataAccessException de) {
			throw de;
		}
	}
	public List<HashMap> getDeptList(Map<String, Object> pMap,HttpServletRequest req) {
		logger.info("getDeptList ȣ�⼺��");
		List<HashMap>deptList=null;
		//����¡ ó�� ���� �߰� -start �� end ������ �߰�
		int total=0; //��ü ���ڵ� ����
		total=sqlMapDeptDao.totalRecord();
		//total���� json���Ͽ� ������ datagrid�� �߰�
		//total���� datagrid�� �߰��� ���� �ƴϹǷ� ������ ����Ͽ� ����ϴ�.
		if(req !=null){
		HttpSession session = req.getSession();
		session.setAttribute("total", total);
		}
		//ȭ��(currentPage:pMap)���� �޾ƿ��� ��
		int page=0;//���� ����ڰ� �ٶ󺸴� ������ ��ȣ(1,2,...)
		//�� �������� ó�� �Ǵ� �ο�(ȭ��:pMap)
		int pageSize=0;
		if(pMap.get("page")!=null)
			page=Integer.parseInt(pMap.get("page").toString());
		if(pMap.get("pageSize")!=null)
			pageSize=Integer.parseInt(pMap.get("pageSize").toString());
		int start=0;//�������� ���۹�ȣ
		int end=0;//�������� �� ��ȣ
		if(page<0){
			start=((page-1)*pageSize)+1;
			end=page*pageSize;
			pMap.put("start", start);
			//total�� end���� ������ end��� total���� ��� �ּ���
			//�׷��� ������ end�� ��� �ּ��� 
			pMap.put("end", end);
		if(total<end){
			pMap.put("end", total);
		}
		else{
			pMap.put("end", end);
		}
		}
		logger.info("start:"+start+"end"+end);
		deptList=sqlMapDeptDao.getDeptList(pMap);
		return deptList;
	}//////////////////////////////end of getDeptList
	//JSON�ڵ� ��ȯ ���� �ǽ�
	public List<DeptVO> getDeptList2(Map<String, Object> pMap,HttpServletRequest req) {
		logger.info("getDeptList2 ȣ�⼺��");
		List<DeptVO>deptList=null;
		//����¡ ó�� ���� �߰� -start �� end ������ �߰�
		int total=0; //��ü ���ڵ� ����
		total=sqlMapDeptDao.totalRecord();
		//total���� json���Ͽ� ������ datagrid�� �߰�
		//total���� datagrid�� �߰��� ���� �ƴϹǷ� ������ ����Ͽ� ����ϴ�.
		if(req !=null){
		HttpSession session = req.getSession();
		session.setAttribute("total", total);
		}
		//ȭ��(currentPage:pMap)���� �޾ƿ��� ��
		int page=0;//���� ����ڰ� �ٶ󺸴� ������ ��ȣ(1,2,...)
		//�� �������� ó�� �Ǵ� �ο�(ȭ��:pMap)
		int pageSize=0;
		if(pMap.get("page")!=null)
			page=Integer.parseInt(pMap.get("page").toString());
		if(pMap.get("pageSize")!=null)
			pageSize=Integer.parseInt(pMap.get("pageSize").toString());
		int start=0;//�������� ���۹�ȣ
		int end=0;//�������� �� ��ȣ
		if(page<0){
			start=((page-1)*pageSize)+1;
			end=page*pageSize;
			pMap.put("start", start);
			//total�� end���� ������ end��� total���� ��� �ּ���
			//�׷��� ������ end�� ��� �ּ��� 
			pMap.put("end", end);
		if(total<end){
			pMap.put("total", total);
		}
		else{
			pMap.put("end", end);
		}
		}
		logger.info("start:"+start+"end"+end);
		deptList=sqlMapDeptDao.getDeptList2(pMap);
		return deptList;
	}
	
	public int deptInsert(Map<String, Object> pMap) {
		logger.info("getDeptInsert ȣ�⼺��");
		int result=0;
		result=sqlMapDeptDao.getDeptInsert(pMap);
		return result;
	}

	public int deptDelete(Map<String, Object> pMap) {
		logger.info("getDeptDelete ȣ�⼺��");
		int result=0;
		result=sqlMapDeptDao.getDeptDelete(pMap);
		return result;
	}

	public List<HashMap> getDeptnoList(Map<String, Object> pMap) {
		logger.info("getDeptnoList ȣ�⼺��");
		List<HashMap>deptList=null;
		deptList=sqlMapDeptDao.getDeptnoList(pMap);
		return deptList;
	}

	public int deptUpdate(Map<String, Object> pMap) {
		logger.info("DeptUpdate ȣ�⼺��");
		int result=0;
		result=sqlMapDeptDao.DeptUpdate(pMap);
		return result;
	}

}
