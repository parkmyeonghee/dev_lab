package com.ch7;

import com.vo.DeptVo;

public class DeptVOTest {

	public static void main(String[] args) {
		DeptVo dvo=new DeptVo();
		dvo.setDeptno(10);
		dvo.setDname("영업");
		dvo.setLoc("부산");
		DeptVo dvo2=new DeptVo(20,"총무","포항");
		System.out.println(dvo.getDeptno()+","+dvo.getDname()+","+dvo.getLoc());//메소드 이용
		System.out.println(dvo2.getDeptno()+","+dvo2.getDname()+","+dvo2.getLoc());//생성자 이용

	}

}
