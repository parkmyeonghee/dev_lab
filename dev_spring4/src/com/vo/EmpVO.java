package com.vo;
  
public class EmpVO {
	private int 	empno    =0; 
	private String 	ename    =null; 
	private String 	job      =null; 
	private int 	mgr      =0; 
	private String 	hiredate =null; 
	private double 	sal      =0.0; 
	private double 	comm     =0.0; 
	private int 	deptno   =0;
	private String dname=null;
	private String  command = null;
	private String  msg = null;
	//emp테이블에는 존재하지 않지만 사용자가 선택한 사원번호정보를 담을 변수선언
	private String empnos =null;
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public double getComm() {
		return comm;
	}
	public void setComm(double comm) {
		this.comm = comm;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getEmpnos() {
		return empnos;
	}
	public void setEmpnos(String empnos) {
		this.empnos = empnos;
	} 
}
