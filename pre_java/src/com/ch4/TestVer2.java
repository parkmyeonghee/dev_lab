package com.ch4;

public class TestVer2 {

	public static void main(String[] args) {
		
		int i=0;
		int hap=0;
		for(i=1;i<=5;i=i+1){//1 2 3 4 5
		//for(i=1;i<=5;i=i+2){
			System.out.println("i:"+i);
			hap=hap+i;
			System.out.println("inner for hap:"+hap);//1 3 6 10 15
		}
		System.out.println("outter for hap:"+hap);//15 최종값만 기억을 한다.
		System.out.println("=========================");
		for(i=1;i<=100;i++)
		{
			if(i%2==0);{
				hap=hap+i;
			}if(i%2!=0){
			i=i+1;
		}
	
	}
		System.out.println(hap);
		System.out.println("================");
	
		
	}
	
}


