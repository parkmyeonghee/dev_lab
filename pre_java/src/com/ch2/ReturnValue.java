package com.ch2;
/*
 * ����������(static) ����Ÿ�� �޼ҵ��̸�(�Ķ����){}
 * �޼ҵ� ������ ����Ÿ���� �����ؾ� �Ѵ�.
 * 1)Void
 * 2)����Ÿ�� Ȥ�� ������ Ÿ���� �� �� �ִ�.
 * 
 */
public class ReturnValue {
	static void go(){
		
		
	}
	static int come(){
		int x =100;
		return x;
		//return 10; ����Ÿ���� ������ Ÿ�Կ� ���缭 ����Ÿ���� ���� ���� ���ڷ� �ش�.
		
	}
	public static void main(String[] args) {
		System.out.print(1);
		System.out.print(2);
		System.out.println(10);
		System.out.println(20);
		System.out.println("==========");
		//�޼ҵ� ȣ���ϱ�
		
		int x=5;
		go();
		//����Ÿ���� void�� ��쿡�� ȣ������ �Ѱ� ���� ���� ����. �Ѱ� ���� ���ϸ� ���� ����.
		//x=go();
		//���:����Ÿ���� void�� ��쿡�� ������ �޼ҵ��� ó�� ��� ���� ���� �� ����.
		x=come();
		System.out.println(x);//100
		//���:����Ÿ���� int�� ��쿡�� ������ �޼ҵ� ó�� ������� ���� �� �ִ�.
	}

}
