package com.ch4;
/*
 * for문 안에서 선언된 변수는 for문 내에서만 접근할 수 있다.
 * 
 */

public class A {

	public static void main(String[] args) {
		int i;
		int j;//초기화 안되었는데 사용하면 오류남ㅠㅠ
		
		for(i=1;i<5;i++){
			System.out.println(i);//1 2 3 4
		}
		System.out.println(i);//5
		j=0;
		if(j<5){//if는 참거짓만 올 수 있다. boolean은 못온다 선언해야 해서.
			
		}
	}

}
