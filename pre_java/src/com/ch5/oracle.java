package com.ch5;

public class oracle {
	public void test(){
		int hap=0;
		double avg=0.0;
		int oracle[] =new int[5];
		for(int x=0 ;x<5;x++){
			hap +=oracle[x];
			
			
		}
		avg=hap/5.0;
		
		System.out.println("������:"+hap);
		System.out.println("�����:"+avg);
		/*System.out.println("�ִ�:"+max);
		System.out.println("�ּڰ�:"+min);*/
		}
	

	public static void main(String[] args) {
		int a1=70;
		int a2=85;
		int a3=90;
		int a4=70;
		int a5=65;
		int tot=0;
		double avg=0.0;
		tot=a1+a2+a3+a4+a5;
		avg=tot/5.0;
System.out.println("������:"+tot);
System.out.println("�����:"+avg);
oracle o =new oracle();
o.test();

	}

}
