package com.ch5;

public class mycar {

	public static void main(String[] args) {
		Sonata myCar=new Sonata();
		Sonata herCar=null;//���� heap������ �Ҵ��� �ȵǾ���.
		herCar=myCar;
		System.out.println(herCar);
		System.out.println(myCar);//myCar.toString�̷��� �Ǿ��ִ�.

	}

}
