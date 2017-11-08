package com.ch13;

public class Baker extends Thread {
	BakerStack bs = null;
	int num=0;
	static int counter =1;
	public Baker(BakerStack bs){
		this.bs=bs;
		num=counter++;
	}
	public void run(){
		System.out.println("현재 스레드이름:"+this.currentThread().getName());
		String bread=null;
		for(int i =0;i<3;i++){
			bread=getBread();
			bs.push(bread);
			System.out.println("빵주인:"+bread);
			try {
				sleep(1000);
			} catch (InterruptedException ie) {
			}
		}
	}
	//빵을 제공하는 메소드
	public String getBread(){
		String bread = null;
		switch((int)(Math.random()*5)){
		case 0:
			bread="생크림빵";
			break;
		case 1:
			bread="치즈케이크";
			break;
		case 2:
			bread="식빵";
			break;
		case 3:
			bread="초코소라빵";
			break;
		case 4:
			bread="피자빵";
			break;
		}
		return bread;

	}
}
