package com.ch7;

public class WoodDuck extends Duck {
	public WoodDuck(){
		
	}
	public WoodDuck(int eye,int leg){
		this.eye=eye;
		this.leg=leg;
	}

	@Override
	public void display() {
		System.out.println("���� �������� �Դϴ�.");

	}

}
