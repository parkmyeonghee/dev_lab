package com.ch6;

public class MethodOveroading {
	void go(){}
	//void go(){}
	//����:int go(){return 0;}
	void go(int i){}//�� �����ε��̾�-����
	//����:void go(int x){} ������ �̸��� �������� ����
	void go(int i, int x){}

	public static void main(String[] args) {
		System.out.println(10.5);
		System.out.println(5);
		System.out.println(true);
		System.out.println(new Galaxy());
	}

}
