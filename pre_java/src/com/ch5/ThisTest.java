package com.ch5;

public class ThisTest {
	int a;
	void methodA(){
		this.a=200;
		System.out.println(a);//0->100->200	
	}
	public static void main(String[] args) {
		//수정자 this는 자기자신을 가리키는 예약어 입니다.
		ThisTest tt= new ThisTest();
		tt.a=100;
//		this.a=100; 인스턴트화를 시켜줘야함.
		tt.methodA();

	}

}
