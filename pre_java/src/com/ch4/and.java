package com.ch4;

public class and {

	public static void main(String[] args) {
		int i=1;
		int j=2;
		if((++i>j--)&(i>=j++));
		System.out.println("&������:"+i);
		System.out.println("&������:"+j);//&&�̸� �տ� �����϶� ������ �ʴ´�.
		//�ڿ� �ִ� �����ڴ� ó�� ���� �ʴ´�. 
		
		
		int a=1;
		int b=2;
		if((++a>b--)&&(a>=b++));
		System.out.println("&&������:"+a);
		System.out.println("&&������:"+b);
		
		
		int c=1;
		int d=2;
		if((c--<++d)|(++c>--d));
		System.out.println("|������2:"+c);
		System.out.println("|������2:"+d);
		
		int x=1;
		int z=2;
		if((x--<++z)||(++x>--z));
		System.out.println("||������2:"+x);
		System.out.println("||������2:"+z);
		
		
		

	}

}
