package com.ch7;

public class Lion  extends  Mammal{
	public Lion(){//����Ʈ ������
		super(2,4);
		System.out.println("Lion ����Ʈ ������ ȣ�� ����");
	}
	public Lion(int eyes,int legs){//�Ķ���͸� ���� ������
		System.out.println("Lion eyes,legs�� ���� ������ ȣ�� ����");
		this.eyes=eyes;
		this.legs=legs;
		
	}
	@Override
	public void display(){
		System.out.println("���� ����");
	}
	@Override
	public void show(){
		System.out.println("���� 120m �Ÿ����� �� �� �ִ�.");
	}
	@Override
	public void go(){
		System.out.println("���� 1�ð��ȿ� 2km�� ���� �� �ִ�.");
	}

}
