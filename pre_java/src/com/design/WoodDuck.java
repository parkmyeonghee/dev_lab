package com.design;
/*
 * �߻�Ŭ���� = new ����Ŭ����
 * �������̽� = new ����Ŭ����
 * ���յ��� ���� �� �ִ�.
 * �����׽�Ʈ �� �� �ִ�.
 * ���������� �����ϴ�
 * �ڵ� ������ �ּ�ȭ �� �� �ִ�.
 */
public class WoodDuck extends Duck {
	public WoodDuck(){
		flyBehavior = new FlyNoWay();
		quackBehavior= new Mute(); 
	}
	@Override
	public void display() {
		System.out.println("���� ���� ����");
	}

}
