package com.ch4;

public class GuGuDan {

	public static void main(String[] args) {
		int i,j;
		for(i=2;i<=9;i++){
			for(j=1;j<=9;j++){
				System.out.println(i+"*"+j+"="+(i*j));
			}
		}
		System.out.println("======================");
		//구구단 오른쪽으로 출력하기
		for(j=1;j<=9;j++){
			for(i=2;i<=9;i++){
				System.out.println(i+"*"+j+"="+(i*j)+" ");	
	}
	System.out.println();
}
}
}