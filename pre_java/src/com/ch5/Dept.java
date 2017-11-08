package com.ch5;

public class Dept {
	

	public static void main(String[] args) {
		int deptno []={10,20,30,40};
		//String dname[]=new String[4];
		String dname[]={"ACCOUNTING","RESEARCH","SALES","OPERATIONS"};
		String loc[]={"NEWYORK","DALLAS","CHICAGO","BOSTON"};
		for(int i=0;i<deptno.length;i++){
			System.out.println(deptno[i]+"=="+dname[i]+"=="+loc[i]);
		}

	}

}
	
	
	
	