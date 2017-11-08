package com.ch6;
/******************************************************
 * String
 * 1)원시타입과 같은 방법으로 초기화 할 수 있다. String s ="야구게임";
 * :기존에 같은 문자열을 갖는 String이 존재하면 새로 생성되지 않고 기존에
 * 문자열을 같이 참조한다.
 * :두 개의 다른 변수는 같은 주소번지를 갖는다.
 * 2)인스턴스화를 통해서도 초기화할 수 있다.
 * String s= new String("야구게임");
 * :같은 문자열이라도 매번 새로 객체가 로딩된다.
 * 생성자를 호출할 때 마다 타입은 같지만 새로운 객체가 만들어 지는 것이다.
 * 
 ******************************************************/

public class StringTest {

	public static void main(String[] args) {
		int i =10;//원시형 타입
		String s ="야구게임";//참조형 타입,생성자 호출 없다.
		String str= new String("야구게임");//생성자 호출
		String str1= new String("전자계산기");//생성자 호출
		String str2="야구게임";//생성자 호출
		System.out.println(i==10);//boolean타입도 ㅇㅇ true가 나옴
		System.out.println(s==str);//false
		System.out.println(s==str2);//false
		//주소 번지가 같아?
		System.out.println(s.equals(str));//true
		//주소 번지가 참조하는 문자열이 같아?
		System.out.println(s.equals(str1));
		System.out.println(str.length());
		System.out.println(str.length());//4
		new String("야구게임");
		System.out.println(new String("야구게임").length());//4
		System.out.println(new String("야구게임").length());

}

}