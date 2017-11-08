package com.design;
/*
 * 11/17 이 소스만 분석을 확실히 하면된다.
 * 아까 그려준 그림과 같이 생각을 해 본다.
 * 
 */
public abstract class Duck {
	FlyBehavior flyBehavior = null;
	QuackBehavior quackBehavior =null;
	public abstract void display();
	public void performFly(){
		flyBehavior.fly();
	}
	public void performQuack(){
		quackBehavior.quack();
	}
	public void swimming(){
		System.out.println("모든 오리는 물에 뜹니다. 가짜 오리도 물에 뜨죠");
	}

}
