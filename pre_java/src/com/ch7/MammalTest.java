package com.ch7;

public class MammalTest {

	public static void main(String[] args) {
		//Mammal myMam = new Mammal();추상클래스는 인스턴스화ㄴㄴ
		//heap메모리 영역에 로딩(필드나 메소드 누릴 수 있다.)
		//생성자 호출 된다.(생성자안에서는 인스턴스화 없이 호출가능)
		
		Mammal myMam1 = new Tiger();
		Mammal myMam2= new Lion();
		myMam1.show();
		myMam2.show();
		System.out.println("======================[다형성 확인 끝]==============");
		System.out.println("myMam1.eyes:"+myMam1.eyes);//0
		System.out.println("myMam1.speed:"+myMam1.speed);//0
		myMam2.speed=10;
		myMam2.stop();
		System.out.println("myMam2.speed"+myMam2.speed);//0
	}

}
