package com.design;
/*
 * 추상클래스 = new 구현클래스
 * 인터페이스 = new 구현클래스
 * 결합도를 낮출 수 있다.
 * 단위테스트 할 수 있다.
 * 유지보수에 용이하다
 * 코드 수정을 최소화 할 수 있다.
 */
public class WoodDuck extends Duck {
	public WoodDuck(){
		flyBehavior = new FlyNoWay();
		quackBehavior= new Mute(); 
	}
	@Override
	public void display() {
		System.out.println("나는 나무 오리");
	}

}
