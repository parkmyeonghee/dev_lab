package com.ch13;
/*
 * 100#ss#���� �ϼ̽��ϴ�.
 * 100:��ȭ������
 * 200:�Ϲݴ�ȭ
 * 300:�ӼӸ�
 * 400:����
 * 500:����
 * �б�->����
 * Ŭ���̾�Ʈ�� run�޼ҵ忡����?
 * �б�(���)
 * ����� ���?
 * �̺�Ʈ ó���� ��
 * �޽����� �Է��� �� ���� ���� �� 
 * Ȥ�� ���۹�ư�� Ŭ������ �� 
 */

public class ThreadExam extends Thread {
	//�ڹٰ� ȣ���Ѵ�.
	//����? -start()ȣ�� �Ǹ� �� �� ȣ�� �ȴ�.
	public void run(){
		System.out.println("run�޼ҵ� ȣ��");
	}
	//main������ �̴�.
	public static void main(String[] args) {
		System.out.println("main�޼ҵ� ȣ��");
		ThreadExam te = new ThreadExam();
		Thread th1 = new Thread(te);
		th1.start();
		}

}
