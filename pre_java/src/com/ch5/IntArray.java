package com.ch5;

public class IntArray {

	public static void main(String[] args) {
		int x[];
		x= new int[3];
		System.out.println(0);
		System.out.println(1);
		System.out.println(2);
		int i=0;
		for(i=0;i<3;i++){
			System.out.println(x[i]);
			
		}
		i=0;
		while(i<3){
			System.out.println(x[i]);
			++i;
		}
		i=0;
		do{
			System.out.println(x[i]);
			++i;
		}while(i<3);
		System.out.println("=========================");
		//개선된 for문
		//for(배열안에 담긴 타입의 변수 선언:배열이름){}
		for(int j:x){
			System.out.println(j);
		}
		System.out.println("=================");
		x[0]=10;
		x[1]=20;
		x[2]=30;
		for(int v:x){
			System.out.println(v);
		}
		
	}
}
