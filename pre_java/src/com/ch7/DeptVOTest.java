package com.ch7;

import com.vo.DeptVo;

public class DeptVOTest {

	public static void main(String[] args) {
		DeptVo dvo=new DeptVo();
		dvo.setDeptno(10);
		dvo.setDname("����");
		dvo.setLoc("�λ�");
		DeptVo dvo2=new DeptVo(20,"�ѹ�","����");
		System.out.println(dvo.getDeptno()+","+dvo.getDname()+","+dvo.getLoc());//�޼ҵ� �̿�
		System.out.println(dvo2.getDeptno()+","+dvo2.getDname()+","+dvo2.getLoc());//������ �̿�

	}

}
