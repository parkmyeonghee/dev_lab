package com.ch4;

public class and {

	public static void main(String[] args) {
		int i=1;
		int j=2;
		if((++i>j--)&(i>=j++));
		System.out.println("&연산자:"+i);
		System.out.println("&연산자:"+j);//&&이면 앞에 거짓일때 따지지 않는다.
		//뒤에 있는 연산자는 처리 되지 않는다. 
		
		
		int a=1;
		int b=2;
		if((++a>b--)&&(a>=b++));
		System.out.println("&&연산자:"+a);
		System.out.println("&&연산자:"+b);
		
		
		int c=1;
		int d=2;
		if((c--<++d)|(++c>--d));
		System.out.println("|연산자2:"+c);
		System.out.println("|연산자2:"+d);
		
		int x=1;
		int z=2;
		if((x--<++z)||(++x>--z));
		System.out.println("||연산자2:"+x);
		System.out.println("||연산자2:"+z);
		
		
		

	}

}
