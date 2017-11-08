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
		System.out.println("현재 스레드이름:"+this.currentThread().getName());
		String bread=null;
		String cbread[]={"생크림빵","치즈케이크","식빵","피자빵","초코소라빵"};
		Thread.yield();//같은 등급의 스레드에게 양보한다.
		for(int i =0;i<4;i++){
			System.out.println("손님:"+cbread[i]+"주세요");
			bread=bs.pop(cbread[i]);
			try {
				sleep(1000);
			} catch (InterruptedException ie) {
				System.out.println("내 빵이 사라졌다");
			}
			}
		}
}
