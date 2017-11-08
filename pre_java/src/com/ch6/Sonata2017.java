package com.ch6;
/****************************************************************
 * 1.생성자를 구현할 수 있나요?
 * 2.적당한 생성자를 선택할 수 있나요?
 * 정리
 * 디폴트 생성자는 JVM에서 제공된다.
 * 파라미터가 있는 생성자는 제공받을 수 없다.
 * 파라미터를 갖는 생성자가 한 개라도 존재하면 디폴트 생성자는 제공되지 않습니다.
 ****************************************************************/
public class Sonata2017{
	int speed=0;
	int wheelnum=0;
	String color=null;
	static int door=0;
	public Sonata2017(){
		door=4;
	}

	
	Sonata2017(int speed,int wheelnum,String color){
	this.speed=speed;
	this.wheelnum=wheelnum;
	this.color=color;
}


	
public static void main(String[] args) {
		Sonata2017 herCar = new Sonata2017(1,4,"빨강");
		Sonata2017 myCar = new Sonata2017(1,4,"파랑");
		Sonata2017 himCar = new Sonata2017(1,4,"검정");
		Sonata2017.door=4; //공유할 수 있다. 하나다.(static)
		
		System.out.println(herCar.color+","+herCar.speed+","+herCar.wheelnum);
		System.out.println(myCar.color+","+myCar.speed+","+myCar.wheelnum);
		System.out.println(himCar.color+","+himCar.speed+","+himCar.wheelnum);
		System.out.println(myCar.door);

		/*Sonata2017 deCar = new Sonata2017(); //디폴트 생성자임, 파라미터 생성자가 없어야 이것이 구현된다.
		System.out.println(deCar.speed);*/
	}
}
