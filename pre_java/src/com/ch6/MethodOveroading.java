package com.ch6;

public class MethodOveroading {
	void go(){}
	//void go(){}
	//에러:int go(){return 0;}
	void go(int i){}//넌 오버로딩이야-인정
	//에러:void go(int x){} 변수의 이름은 고려대상이 ㄴㄴ
	void go(int i, int x){}

	public static void main(String[] args) {
		System.out.println(10.5);
		System.out.println(5);
		System.out.println(true);
		System.out.println(new Galaxy());
	}

}
