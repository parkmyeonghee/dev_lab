package com.ch7;

//추상 클래스-구체적이지 않다. 
//결정되지 않았다.
//어떤 모양인지 알 수 없다, 확실하지 않다
//막연하다 
//실체가 없다.
//단독으로 사용할 수 없다.(인스턴스화 할 수 없다.)
public abstract class Car {
		int wheelNum=0;
		int speed=0;
		/*
		 * 자식의 생성자를 호출할 때 부모 생성자도 호출
		 * 디폴트 생성자(파라미터가 없는 생성자)는 JVM이 제공한다.
		 * 파라미터를 갖는 생성자(디폴트 생성자가 아닌)는 제공 받을 수 없다.
		 * 파라미터를 갖는 생성자가 한 개 라도 존재하면 디폴트 생성자는 제공되지 않는다.
		 */
		public Car(){}
		public Car(int speed){
			this.speed=speed;
		}
		//Sonata meCar= new Sonata();
		//추상 메소드라고 한다.
		public abstract void stop();
}
