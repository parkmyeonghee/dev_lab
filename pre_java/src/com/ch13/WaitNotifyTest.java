package com.ch13;

public class WaitNotifyTest {

	public static void main(String[] args) {
		//6���� �����带 �����δ�.
		//start�޼ҵ��� ȣ������� �����̾���.
		//���� ���� �����ϴ��Ŀ� ���� ���� ������ �Ź� �޶��� ���� �ִ�.
		//������ ���� ������ ����ġ�� ���� �ʾ����Ƿ� ��� 5�̸�
		//���� ������ �����尡 6�� �����ȴ�.
		//����� ���� ������ �簡�� ���� �̸��� ������ �ʾҴ�.
		//�����Ͽ� �ҽ��� �м��� ���� �簡�� ���� �̸��� ���ؼ�
		//�簡�� �����ϵ��� ��
		//�����忡 ���ؼ� ����ġ�� �� �� �ִ�.
		//����Ʈ 5�̴�.(thread.yield():���� ����� �����忡�Ը� �纸)
		/*
		 * �����߿� �ڽſ��� �־��� ���ʸ� �ٸ� �����忡�� �纸�ϰ� �ڽ��� 
		 * ������ ���·� ����.
		 * 
		 */
		
		BakerStack bs = new BakerStack();
		Baker b1 = new Baker(bs);
		b1.start();
		Baker b2 = new Baker(bs);
		b2.start();
		Baker b3 = new Baker(bs);
		b3.start();
		Customer c1 = new Customer(bs);
		c1.setPriority(10);
		c1.start();
		Customer c2 = new Customer(bs);
		c2.start();
		Customer c3 = new Customer(bs);
		c3.start();

	}

}
