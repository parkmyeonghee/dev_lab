package com.ch5;

public class ThisTest {
	int a;
	void methodA(){
		this.a=200;
		System.out.println(a);//0->100->200	
	}
	public static void main(String[] args) {
		//������ this�� �ڱ��ڽ��� ����Ű�� ����� �Դϴ�.
		ThisTest tt= new ThisTest();
		tt.a=100;
//		this.a=100; �ν���Ʈȭ�� ���������.
		tt.methodA();

	}

}
