package com.ch5;

public class ArraryTest3 {

	public static void main(String[] args) {
		ArraryTest2 at2=new ArraryTest2();
		at2.methodB();//주석처리하면 0으로 출력이 된다.
		//is배열에 대한 초기화
		at2.methodBprint();
		//is배열을 새로 초기화 하시오.
		at2.is[0]=13;
		at2.is[1]=14;
		at2.is[2]=15;
		at2.is[3]=16;
		at2.is[4]=17;
	
		//is배열의 값들을 출력 하시오.
	at2.methodBprint();
	System.out.println("=================================");
	ArraryTest2 at3=new ArraryTest2();
	at3.methodBprint();
	}

}
