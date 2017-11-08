package com.ch6;
class Sonata
{
	int speed;
	SonataSimulation simu=null;
	//SonataSimulation simu= new SonataSimulation(); 이렇게 쓰면 새롭게 생겨서 두개가 생겨서 안된다.원본사용ㄴㄴ
	
	Sonata(){
		System.out.println("디폴트 생성자 호출 성공");
	}
	Sonata(int speed){
		System.out.println("sonata(10)호출 성공");
		this.speed=speed;
	}
	Sonata(SonataSimulation simu){
		System.out.println("시우민존잘");
		this.simu=simu;
	}
	void speedUp(){
		speed=speed+1;
		System.out.println("simu.a==>"+simu.a);//전역변수 선언만 되어있고 인스턴트가 안되있다.
		
	}
}

public class SonataSimulation {
	int a=10;
	SonataSimulation gSimu=null;//gSimu아직 주소번지 할당 받지 못한상태
	//Sonata meCar=null;
	public SonataSimulation(){
		//gSimu= new SonataSimulation();//객체 생성,gSim를 통해서 변수와 메소드 호출가능
		new Sonata(this);//객체생성,변수가 없으므로 생성된 객체 접근 불가
		new Sonata(gSimu);//객체생성,변수가 없으므로 생성된 객체 접근 불가
		//Sonata meCar=new Sonata();
		
	}
	/*
	 * new Sonata().speedUp();이것도 가능 근데 얘는 myCar.speedUp();과달리 변수가 없어서 재사용이 불가.
	 */
	public static void main(String[] args) {
		Sonata myCar = new Sonata();
		Sonata herCar= new Sonata(10);
		SonataSimulation simu= new SonataSimulation();
		Sonata himCar= new Sonata(simu);
		System.out.println(myCar.speed);
		System.out.println(herCar.speed);
		//myCar.speedUp();
		//herCar.speedUp();
		himCar.speedUp();
	}

}
