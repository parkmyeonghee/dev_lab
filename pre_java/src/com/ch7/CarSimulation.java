package com.ch7;

public class CarSimulation {

	public static void main(String[] args) {
		Car myCar = new Sonata();//권장사항
		//단독으로는 인스턴스화 할 수 없다.
		//추상클래스는 반드시 구현체 클래스를 가져야 한다.
		//Car himCar = new Car(); 실행이 되지 않는다,
		//Sonata herCar =new Sonata();
		myCar.stop();
		//herCar.stop();
		System.out.println(myCar.speed);//부모클래스변수호출
		System.out.println(myCar.wheelNum);//부모클래스변수호출
		//System.out.println(myCar.carColor); 부모라고 해서 자식의 것을 다 쓸 수 없다.
		//System.out.println(herCar.carColor);
		//System.out.println(myCar.meCar.carColor);오버 플로우가 일어난다.
		
		

	}

}
