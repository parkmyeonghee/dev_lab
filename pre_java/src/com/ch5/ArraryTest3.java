package com.ch5;

public class ArraryTest3 {

	public static void main(String[] args) {
		ArraryTest2 at2=new ArraryTest2();
		at2.methodB();//�ּ�ó���ϸ� 0���� ����� �ȴ�.
		//is�迭�� ���� �ʱ�ȭ
		at2.methodBprint();
		//is�迭�� ���� �ʱ�ȭ �Ͻÿ�.
		at2.is[0]=13;
		at2.is[1]=14;
		at2.is[2]=15;
		at2.is[3]=16;
		at2.is[4]=17;
	
		//is�迭�� ������ ��� �Ͻÿ�.
	at2.methodBprint();
	System.out.println("=================================");
	ArraryTest2 at3=new ArraryTest2();
	at3.methodBprint();
	}

}
