package com.ch2;
/*
 * �ڹ� API�䳻����
 * 
 */
public class CarApp {
	
	static void test(){
		int i =Integer.parseInt("5");//�ȿ��� String�� ���;��Ѵ�.double�ᵵ �ȵȴ�.
		System.out.println("���� i:"+i);//���� �Ǿ����� �����°� �ƴ϶� ȣ���� �������.
		int a=Integer.parseInt("500");
		System.out.println("����a:"+a);
		int g=Integer.parseInt("-100");
		System.out.println("����g:"+g);
		/*int f=Integer.parseInt("����");
		System.out.println("����f:"+f);*/ //����->���ܰ� �Ͼ ��Ÿ�ӿ����� �Ͼ��.
		//���θ޼ҵ忡�� ȣ���� �� ���� static�� ���̴��� �ƴϸ� dd d=new dd�̷������� ������Ѵ�.
	}

	public static void main(String[] args) {
/*
 * ����(CarApp)�� �����Ǿ� �ִ� �ϴ���
 * non-static�޼ҵ�� static����(main)���� ����ȣ���� �Ұ��ϴ�.
 * �ذ���
 * ��ü�� ���� �� �� �ּҹ����� �̿��ϸ� ȣ������
 */
		Sonata myCar= new Sonata();//���� �̸����� �θ�
		double d=Double.parseDouble("10");//Ŭ���� Ÿ������ �ҷ���
		Sonata.speedDown();//static�� ���������� ���������
		System.out.println(d+20);//30.0 
		myCar.speedUp();//�ٸ�Ŭ������ �ִ°��� ȣ���ϴ� ����.
		test();
	
		
	}

}
