package com.ch7;

public class MammalTest {

	public static void main(String[] args) {
		//Mammal myMam = new Mammal();�߻�Ŭ������ �ν��Ͻ�ȭ����
		//heap�޸� ������ �ε�(�ʵ峪 �޼ҵ� ���� �� �ִ�.)
		//������ ȣ�� �ȴ�.(�����ھȿ����� �ν��Ͻ�ȭ ���� ȣ�Ⱑ��)
		
		Mammal myMam1 = new Tiger();
		Mammal myMam2= new Lion();
		myMam1.show();
		myMam2.show();
		System.out.println("======================[������ Ȯ�� ��]==============");
		System.out.println("myMam1.eyes:"+myMam1.eyes);//0
		System.out.println("myMam1.speed:"+myMam1.speed);//0
		myMam2.speed=10;
		myMam2.stop();
		System.out.println("myMam2.speed"+myMam2.speed);//0
	}

}
