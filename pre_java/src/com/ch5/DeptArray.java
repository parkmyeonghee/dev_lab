package com.ch5;

import com.vo.DeptVo;

public class DeptArray {
	int deptno =0; 
	String dname="accounting";   
	String loc  ="newyork"; 
	void getDeptList(DeptVo dvos[]){
		for(int i=0;i<dvos.length;i++){
			DeptVo dvo = dvos[i];
			System.out.println(dvo.getDeptno()+","+dvo.dname+","+dvo.loc);
		}
		
	}
	void getDeptList(int deptnos[],String dnames[],String locs[]){
		for(int i=0;i<deptnos.length;i++){
			System.out.println(deptnos[i]+","+dnames[i]+","+locs[i]);
		}
	}

	public static void main(String[] args) {
		/*int deptnos []={10,20,30,40};
		String dnames[]={"ACCOUNTING","RESEARCH","SALES","OPERATIONS"};
		String locs[]={"NEWYORK","DALLAS","CHICAGO","BOSTON"};
		for(int i=0;i<deptnos.length;i++){
			System.out.println(deptnos[i]+","+dnames[i]+","+locs[i]);
			

	*/
	DeptVo dvos[]=new DeptVo[4];
	DeptVo dvo=new DeptVo();
	dvo.setDeptno(10);
	dvo.dname="ACCOUNTING";
	dvo.loc="NEW YORK";
	dvos[0]=dvo;
	dvo=new DeptVo();
	dvo.setDeptno(20);
	dvo.dname="RESEARCH";
	dvo.loc="DALLAS";
	dvos[1]=dvo;
	dvo=new DeptVo();
	dvo.setDeptno(30);
	dvo.dname="SALES";
	dvo.loc="CHICAGO";
	dvos[2]=dvo;
	dvo=new DeptVo();
	dvo.setDeptno(40);
	dvo.dname="OPERATIONS";
	dvo.loc="BOSTON";
	dvos[3]=dvo;
	DeptArray da = new DeptArray();
	da.getDeptList(dvos);
	
		}

}

