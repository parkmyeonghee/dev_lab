package com.design;

public class FlyNoWay implements FlyBehavior { //interface의 구현클래스

	
	@Override
	public void fly() {
		System.out.println("나는 못 날아요.무겁기 때문이죠");

	}

}
