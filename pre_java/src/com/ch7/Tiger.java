package com.ch7;

public class Tiger  extends Mammal {
	public Tiger(){//����Ʈ ������
		super();
		System.out.println("Tiger ����Ʈ ������ ȣ�� ����");
	}
	public Tiger(int eyes,int legs){//�Ķ���͸� ���� ������
		System.out.println("eyes,legs�� ���� ������ ȣ�� ����");
		this.eyes=eyes;
		this.legs=legs;
		
	}
	@Override
	public void display(){
		System.out.println("���� ȣ����");
	}
	@Override
	public void show(){
		System.out.println("���� 100m �Ÿ����� �� �� �ִ�.");
	}
	@Override
	public void go(){
		System.out.println("���� 1�ð��ȿ� 1km�� ���� �� �ִ�.");
	}

}
