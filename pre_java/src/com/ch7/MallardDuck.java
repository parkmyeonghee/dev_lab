package com.ch7;

public class MallardDuck extends Duck {
	public MallardDuck(){
		
	}
	public MallardDuck(int eye,int leg){
		this.eye=eye;
		this.leg=leg;
	}
	@Override
	public void display() {
		System.out.println("���� û�տ��� �Դϴ�.");
	}

}
