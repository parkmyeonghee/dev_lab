package com.procedure;

import com.mvc.SqlMapEmpDao;
import com.vo.EmpVO;

public class ProcedureSimulation {
	public void proc_salupdate(int empno,EmpVO eVO){
		SqlMapEmpDao eDao = new SqlMapEmpDao();
		String msg = eDao.proc_salupdate(eVO);
		System.out.println(msg); //���ν������� ������� ��������
	}

	public static void main(String[] args) {
		ProcedureSimulation ps = new ProcedureSimulation();
	}

}
