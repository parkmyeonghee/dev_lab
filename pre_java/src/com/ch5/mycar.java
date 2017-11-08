package com.ch5;

public class mycar {

	public static void main(String[] args) {
		Sonata myCar=new Sonata();
		Sonata herCar=null;//아직 heap영역이 할당이 안되었다.
		herCar=myCar;
		System.out.println(herCar);
		System.out.println(myCar);//myCar.toString이렇게 되어있다.

	}

}
