package com.base;
/*
 *�� �ڹٿ��� �ϴ°�? 
 *���뼺�� �̽ļ�
 *Ȯ���� ����
 *������ Ÿ���� ��� ������ Ÿ�԰� �޸� ȣ�� ���� �� �ּҹ����� ����ϰ� �ȴ�.
 *��������:
 *HelloWorld.java���� ������ ���� x����ϱ�
 *-> ��°�� : x=10;
 */

public class HelloWorldSimulation {

	public static void main(String[] args) {
		
		int x=100;
		System.out.println("x="+x);//���ڿ� �ΰ��� �ٿ��ٶ�
		System.out.println(10+""+20);//������ ���ش�.
		Helloworld hw =new Helloworld();//Helloworld hw=null; hw=new Helloworld();
		/*��ȣ�� ���涧 ������,�޼ҵ� �� �ΰ��� ����϶�
		 * ���� hw�� HelloworldŬ���� Ÿ���̴�.
		 *Ŭ���� Ÿ�Ժ��� hw�� ȣ���ϸ� �ּҹ����� ���.
		 * ���� x�� intŸ���̴�.
		 * ����Ÿ�� ���� x�� ȣ���ϸ� ���� ���*/
		System.out.println("�ּҹ���:����������"+hw);//@1db9742 �ּҹ����� �ҷ���.
		System.out.println("hw.x����="+hw.x);//10
		hw.go();//��Ʈ �����ڶ�� �Ѵ�
	}

}
