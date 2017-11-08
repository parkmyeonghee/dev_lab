package com.ch2;

public class Sonata {
	
	static int speed =0;
	void speedUp(){
		speed= speed+1;
		System.out.println("speedUp호출 성공"+speed);
	}
	static void speedDown(){
		speed= speed-1;
		System.out.println("speedDown호출 성공");
	}
	

}
