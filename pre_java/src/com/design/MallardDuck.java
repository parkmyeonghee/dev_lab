package com.design;

public class MallardDuck extends Duck {
	public MallardDuck(){ //�����ڸ� �� ���� �ʱ�ȭ�� ���ְ� �ض�
		//������ �ʱ�ȭ �� ���ΰ�? �Ǵ� ������ ������ ���ΰ�?
			flyBehavior = new FlyWithWings();
			quackBehavior = new Quack(); 
			//�갡 ������ �� �ϴ� ���̶� �������̽��� ��� ����� �˷������
			//�׷��� Duck�� �� �� �ֱ� ������ ������ ���ָ� �ȵȴ�
			//���ָ� ���纻�� ���ܼ� ������ ���� ����
			
		}
	@Override
	public void display() {
		System.out.println("���� û�տ�����_��");
	}

}
