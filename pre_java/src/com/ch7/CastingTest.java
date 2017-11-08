package com.ch7;
/*
 * 서로 다른 타입을 맞추어 사용할 수 있다.
 * -캐스팅 연산자,형전환 메소드
 * Wrapper 클래스
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
		i=it;//autoboxing :자동으로 형전환해주는것
		int j=it.intValue(); //리턴값을 원래 int로 받아주어야한다.
		System.out.println("i:"+i);
		double d=3.14;
		i=(int)d;
		double d1=1.5;
		d1=i;
		Object obj ="이성계";
		String name="이순신";
		name=(String)obj;
		obj=name; //참조형 타입일 때 도 casting연산자 사용가능.
		JButton jbtn_exit=new JButton("종료");
		Object obj1=jbtn_exit;
		if(jbtn_exit instanceof JButton){//너 버튼타입이야.
			System.out.println("버튼 타입이 맞다");
			
		}else{
			System.out.println("버튼 타입이 아니당");
	}
		System.out.println(jbtn_exit.getClass());
		Object myboj =new Object();
	}
}

