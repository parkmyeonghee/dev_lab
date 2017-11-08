package com.ch7;

public class Tiger  extends Mammal {
	public Tiger(){//디폴트 생성자
		super();
		System.out.println("Tiger 디폴트 생성자 호출 성공");
	}
	public Tiger(int eyes,int legs){//파라미터를 갖는 생성자
		System.out.println("eyes,legs를 갖는 생성자 호출 성공");
		this.eyes=eyes;
		this.legs=legs;
		
	}
	@Override
	public void display(){
		System.out.println("나는 호랑이");
	}
	@Override
	public void show(){
		System.out.println("나는 100m 거리까지 볼 수 있다.");
	}
	@Override
	public void go(){
		System.out.println("나는 1시간안에 1km를 걸을 수 있다.");
	}

}
