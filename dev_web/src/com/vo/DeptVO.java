package com.vo;


public class DeptVO {
	private	int deptno =0; 
	public String dname="";   
	public	String loc  =""; 
	public DeptVO(){
		
	}
public DeptVO(int deptno,String dname,String loc){
	this.deptno=deptno;
	this.dname=dname;
	this.loc=loc;
}
	//getter메소드- 읽기
	public int getDeptno() {
		return deptno;
	}
	//setter메소드 - 쓰기,저장
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}

	}
