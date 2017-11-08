package com.design;
/*
 * 11/17 �� �ҽ��� �м��� Ȯ���� �ϸ�ȴ�.
 * �Ʊ� �׷��� �׸��� ���� ������ �� ����.
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
		System.out.println("��� ������ ���� ��ϴ�. ��¥ ������ ���� ����");
	}

}
