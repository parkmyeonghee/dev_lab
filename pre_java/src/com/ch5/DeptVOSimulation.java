package com.ch5;

import com.vo.DeptVo;
/*
 * DeptVo������ ���� �� ���ο츸 ���� �� �ִ�.
 * �ذ���:
 * ��ü�迭�� ����ϸ� �������� �ο쵵 ���� �� �ִ�.
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
