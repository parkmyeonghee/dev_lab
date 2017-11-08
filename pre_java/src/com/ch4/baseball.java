package com.ch4;
import java.util.*;
public class baseball {

	int is []=new int[3];
	void test(){
		for(int i=0;i<10;i++){
			is[0]=(int)(Math.random()*10);
			do{
				is[1]=(int)(Math.random()*10);
				
			}while(is[0]==is[1]);
			do{
				is[2]=(int)(Math.random()*10);
			}while(is[0]==is[2]||is[1]==is[2]);
		}
			System.out.println("채번한 세자리 숫자능?===>"+is[0]+is[1]+is[2 ]);
	}
	public static void main(String[] args) {

		int fir=0;
		int sec=0;
		int thir=0;
		fir =(int)(Math.random()*10);
		do{
			sec=(int)(Math.random()*10);
			
		}while(fir==sec);
		do{
			thir=(int)(Math.random()*10);
		}while(fir==thir||sec==thir);
		System.out.println("채번한 세자리 숫자능?===>"+fir+sec+thir);
		System.out.println("===================================");
		baseball bs =new baseball();
		bs.test();
	}

}
