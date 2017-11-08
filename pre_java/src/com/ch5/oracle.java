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
		
		System.out.println("ÃÑÁ¡Àº:"+hap);
		System.out.println("Æò±ÕÀº:"+avg);
		/*System.out.println("ÃÖ´ñ°ª:"+max);
		System.out.println("ÃÖ¼Ú°ª:"+min);*/
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
System.out.println("ÃÑÁ¡Àº:"+tot);
System.out.println("Æò±ÕÀº:"+avg);
oracle o =new oracle();
o.test();

	}

}
