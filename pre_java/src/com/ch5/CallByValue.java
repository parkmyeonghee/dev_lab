package com.ch5;
class Sonata{
	int speed;
}
public class CallByValue {
	Sonata himCar = new Sonata();
	void methodA(Sonata myCar){
		System.out.println(myCar.speed);
		//System.out.println(this.speed);������ ����
		System.out.println(himCar.speed);
		}
	void methodB(){
		//my car,her car��� ���� ��������
		//himcar�� ���������󼭤���
		System.out.println(himCar.speed);//0
	}
	//12->13(callbyvalue)-14(sonata)-15(�������� speed 0->100)-16(�޼ҵ�ȣ��-�Ķ���ͷ� �ּҹ���)
	public static void main(String[] args) {
		CallByValue cv = new CallByValue();
		Sonata herCar= new Sonata();
		herCar.speed=100;
		cv.methodA(herCar);

	}

}
