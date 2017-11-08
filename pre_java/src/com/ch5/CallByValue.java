package com.ch5;
class Sonata{
	int speed;
}
public class CallByValue {
	Sonata himCar = new Sonata();
	void methodA(Sonata myCar){
		System.out.println(myCar.speed);
		//System.out.println(this.speed);컴파일 에러
		System.out.println(himCar.speed);
		}
	void methodB(){
		//my car,her car사용 ㄴㄴ 지역변수
		//himcar은 지역변수라서ㅇㅇ
		System.out.println(himCar.speed);//0
	}
	//12->13(callbyvalue)-14(sonata)-15(전역변수 speed 0->100)-16(메소드호출-파라미터로 주소번지)
	public static void main(String[] args) {
		CallByValue cv = new CallByValue();
		Sonata herCar= new Sonata();
		herCar.speed=100;
		cv.methodA(herCar);

	}

}
