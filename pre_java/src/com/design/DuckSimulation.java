package com.design;

public class DuckSimulation {

	public static void main(String[] args) {
		System.out.println("û�տ���:");
		MallardDuck MD = new MallardDuck();//�������� ���� �� ����.
		Duck mdDuck=new MallardDuck();
		//�������-���յ��� �������� �ڵ� ���� �� �ִ�,
		MD.performFly();
		MD.performQuack();
		System.out.println("��������:");
		WoodDuck WD = new WoodDuck();
		WD.performFly();
		WD.performQuack();
		System.out.println("������:");
		RubberDuck RD= new RubberDuck();
		RD.performFly();
		RD.performQuack();
	}

}
