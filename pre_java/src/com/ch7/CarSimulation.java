package com.ch7;

public class CarSimulation {

	public static void main(String[] args) {
		Car myCar = new Sonata();//�������
		//�ܵ����δ� �ν��Ͻ�ȭ �� �� ����.
		//�߻�Ŭ������ �ݵ�� ����ü Ŭ������ ������ �Ѵ�.
		//Car himCar = new Car(); ������ ���� �ʴ´�,
		//Sonata herCar =new Sonata();
		myCar.stop();
		//herCar.stop();
		System.out.println(myCar.speed);//�θ�Ŭ��������ȣ��
		System.out.println(myCar.wheelNum);//�θ�Ŭ��������ȣ��
		//System.out.println(myCar.carColor); �θ��� �ؼ� �ڽ��� ���� �� �� �� ����.
		//System.out.println(herCar.carColor);
		//System.out.println(myCar.meCar.carColor);���� �÷ο찡 �Ͼ��.
		
		

	}

}
