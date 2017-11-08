package com.design;

public class DuckSimulation {

	public static void main(String[] args) {
		System.out.println("청둥오리:");
		MallardDuck MD = new MallardDuck();//다형성을 누릴 수 없다.
		Duck mdDuck=new MallardDuck();
		//권장사항-결합도가 낮아지는 코드 만들 수 있다,
		MD.performFly();
		MD.performQuack();
		System.out.println("나무오리:");
		WoodDuck WD = new WoodDuck();
		WD.performFly();
		WD.performQuack();
		System.out.println("고무오리:");
		RubberDuck RD= new RubberDuck();
		RD.performFly();
		RD.performQuack();
	}

}
