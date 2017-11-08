package com.ch7;

public class Lion  extends  Mammal{
	public Lion(){//디폴트 생성자
		super(2,4);
		System.out.println("Lion 디폴트 생성자 호출 성공");
	}
	public Lion(int eyes,int legs){//파라미터를 갖는 생성자
		System.out.println("Lion eyes,legs를 갖는 생성자 호출 성공");
		this.eyes=eyes;
		this.legs=legs;
		
	}
	@Override
	public void display(){
		System.out.println("나는 사자");
	}
	@Override
	public void show(){
		System.out.println("나는 120m 거리까지 볼 수 있다.");
	}
	@Override
	public void go(){
		System.out.println("나는 1시간안에 2km를 걸을 수 있다.");
	}

}
