package com.ch6;
/****************************************************************
 * 1.�����ڸ� ������ �� �ֳ���?
 * 2.������ �����ڸ� ������ �� �ֳ���?
 * ����
 * ����Ʈ �����ڴ� JVM���� �����ȴ�.
 * �Ķ���Ͱ� �ִ� �����ڴ� �������� �� ����.
 * �Ķ���͸� ���� �����ڰ� �� ���� �����ϸ� ����Ʈ �����ڴ� �������� �ʽ��ϴ�.
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
		Sonata2017 herCar = new Sonata2017(1,4,"����");
		Sonata2017 myCar = new Sonata2017(1,4,"�Ķ�");
		Sonata2017 himCar = new Sonata2017(1,4,"����");
		Sonata2017.door=4; //������ �� �ִ�. �ϳ���.(static)
		
		System.out.println(herCar.color+","+herCar.speed+","+herCar.wheelnum);
		System.out.println(myCar.color+","+myCar.speed+","+myCar.wheelnum);
		System.out.println(himCar.color+","+himCar.speed+","+himCar.wheelnum);
		System.out.println(myCar.door);

		/*Sonata2017 deCar = new Sonata2017(); //����Ʈ ��������, �Ķ���� �����ڰ� ����� �̰��� �����ȴ�.
		System.out.println(deCar.speed);*/
	}
}
