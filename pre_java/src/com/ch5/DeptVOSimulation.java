package com.ch5;

import com.vo.DeptVo;
/*
 * DeptVo패턴은 오직 한 개로우만 담을 수 있다.
 * 해결방법:
 * 객체배열을 사용하면 여러개의 로우도 담을 수 있다.
 * DeptVo[]
 */

public class DeptVOSimulation {

	public static void main(String[] args) {
		DeptVo dvo=new DeptVo();
		dvo.setDeptno(10);
		System.out.println(dvo.getDeptno());//10
		dvo.setDeptno(20);
		System.out.println(dvo.getDeptno());//10
		DeptVo dvo2 =null;
		System.out.println(dvo);
		DeptVo dvos[]=new DeptVo[3];
		for(int i=0;i<dvos.length;i++){
			System.out.println(dvos[i]);
		}
	dvos[0]=dvo;

	}

}
