package com.ch5;

public class ArrayParameter {
	void methodA(int fir,int sec,int thir){
		System.out.println(fir);
		System.out.println(sec);
		System.out.println(thir);
	}
	void methodB(int[] is){
		for(int i=0;i<is.length;i++){
			System.out.println(is[i]);
		}
	}

	public static void main(String[] args) {
		ArrayParameter a =new ArrayParameter();
		a.methodA(10,100,10000);
		int is[]=new int[3];
		is[0]=5;
		is[1]=15;
		is[2]=25;
		a.methodB(is);
		

	}

}
