package com.ch7;
/*
 * ���� �ٸ� Ÿ���� ���߾� ����� �� �ִ�.
 * -ĳ���� ������,����ȯ �޼ҵ�
 * Wrapper Ŭ����
 * int-integer
 * double- Double
 * float -Float
 * boolean-Boolean
 * long-Long
 * 
 */

import javax.swing.JButton;

public class CastingTest {
	void go(Object obj){
		if(obj instanceof String){
			
		}
		else if(obj instanceof JButton){
			
		}
		else if(obj instanceof Integer){
			
		}
	}

	public static void main(String[] args) {
		Integer it = new Integer(10);
		System.out.println("Integer it:"+it);
		int i =10;
		i=it;//autoboxing :�ڵ����� ����ȯ���ִ°�
		int j=it.intValue(); //���ϰ��� ���� int�� �޾��־���Ѵ�.
		System.out.println("i:"+i);
		double d=3.14;
		i=(int)d;
		double d1=1.5;
		d1=i;
		Object obj ="�̼���";
		String name="�̼���";
		name=(String)obj;
		obj=name; //������ Ÿ���� �� �� casting������ ��밡��.
		JButton jbtn_exit=new JButton("����");
		Object obj1=jbtn_exit;
		if(jbtn_exit instanceof JButton){//�� ��ưŸ���̾�.
			System.out.println("��ư Ÿ���� �´�");
			
		}else{
			System.out.println("��ư Ÿ���� �ƴϴ�");
	}
		System.out.println(jbtn_exit.getClass());
		Object myboj =new Object();
	}
}

