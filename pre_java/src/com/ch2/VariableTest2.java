package com.ch2;
/*
 * ������ ������ �� �ִ�. ���?
 * ���θ޼ҵ�� entry point�̴�. ���ξ������� ���� �� �ִ�.
 * ���θ޼ҵ�� �ݵ��
 * public:����������.
 * static:�����̴�,�����ȴ� 
 * ->�����տ� �� �� �ִ�.
 * ->�޼ҵ�տ� �� �� �ִ�.
 * ->��ü ����(helloworld hw=new helloworld();)���� ����� �� �ִ�.
 * void:���ϰ��� ����. ��ȯ���� ����.
 * �޼ҵ� �̸��� main�̴�.
 * �޼ҵ��� ����-����� ���� �޼ҵ�, �����Ǵ� �޼ҵ�
 * String[] args-�迭
 * �迭�� ������ �����̴�.- ȣ���ϸ� �ּҹ����� ��µȴ�.(16����)
 */
public class VariableTest2 {
	
	static void go(int x){
		System.out.println(x);
	}
	static void go(double x){
		System.out.println(x);
	}
	//�޼ҵ� �̸��� ���Ƶ� �Ķ���� Ÿ���� �ٸ��� �ٸ������� �����Ѵ�.

	public static void main(String[] args) {
		int x=1;//1
		int y=x;//1
		int z;//�������� (�ݵ�� �ʱ�ȭ�� �ؾ��Ѵ�)
		z=5;
		y=y+z;
		VariableTest2.go(2);
		System.out.println(z);
		System.out.println(args);//�ּҹ��� ���
		System.out.println("��1"+args[0]);
		System.out.println("��2"+args[1]);
		go(10);
		go(10.5);
		go(Integer.parseInt(args[0]));//����ȯ���ִ°�.parseint�� static�� ��������
		
	}

}
