package com.ch5;

class Father{
	Father(){
		
	}
	void go(){
		System.out.println("CBX노래 좋다ㅇㅅㅇ");
	}
}
class Sun{
	Sun(Father fa){
		fa.go();
	}
}
public class Test {
	public Test(){
		new Test(this);
		Father fa =new Father();
		Sun su= new Sun(fa);
	}
	public Test(Test t){
		System.out.println("test(test t)호출 성공");
	}
//메인메소드-테스트-퍼블릭테스트-생성자-아빠생성자-보이드-또 생성자
	public static void main(String[] args) {
		new Test();

	}

}
