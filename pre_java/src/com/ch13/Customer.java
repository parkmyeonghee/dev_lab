package com.ch13;

public class Customer extends Thread {
	BakerStack bs = null;
	int num=0;
	static int counter =1;
	public Customer(BakerStack bs){
		this.bs=bs;
		num=counter++;
	}
	public void run(){
		System.out.println("���� �������̸�:"+this.currentThread().getName());
		String bread=null;
		String cbread[]={"��ũ����","ġ������ũ","�Ļ�","���ڻ�","���ڼҶ�"};
		Thread.yield();//���� ����� �����忡�� �纸�Ѵ�.
		for(int i =0;i<4;i++){
			System.out.println("�մ�:"+cbread[i]+"�ּ���");
			bread=bs.pop(cbread[i]);
			try {
				sleep(1000);
			} catch (InterruptedException ie) {
				System.out.println("�� ���� �������");
			}
			}
		}
}
