package com.ch6;
class Sonata
{
	int speed;
	SonataSimulation simu=null;
	//SonataSimulation simu= new SonataSimulation(); �̷��� ���� ���Ӱ� ���ܼ� �ΰ��� ���ܼ� �ȵȴ�.������뤤��
	
	Sonata(){
		System.out.println("����Ʈ ������ ȣ�� ����");
	}
	Sonata(int speed){
		System.out.println("sonata(10)ȣ�� ����");
		this.speed=speed;
	}
	Sonata(SonataSimulation simu){
		System.out.println("�ÿ������");
		this.simu=simu;
	}
	void speedUp(){
		speed=speed+1;
		System.out.println("simu.a==>"+simu.a);//�������� ���� �Ǿ��ְ� �ν���Ʈ�� �ȵ��ִ�.
		
	}
}

public class SonataSimulation {
	int a=10;
	SonataSimulation gSimu=null;//gSimu���� �ּҹ��� �Ҵ� ���� ���ѻ���
	//Sonata meCar=null;
	public SonataSimulation(){
		//gSimu= new SonataSimulation();//��ü ����,gSim�� ���ؼ� ������ �޼ҵ� ȣ�Ⱑ��
		new Sonata(this);//��ü����,������ �����Ƿ� ������ ��ü ���� �Ұ�
		new Sonata(gSimu);//��ü����,������ �����Ƿ� ������ ��ü ���� �Ұ�
		//Sonata meCar=new Sonata();
		
	}
	/*
	 * new Sonata().speedUp();�̰͵� ���� �ٵ� ��� myCar.speedUp();���޸� ������ ��� ������ �Ұ�.
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
