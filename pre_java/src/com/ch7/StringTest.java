package com.ch7;
/*
 * sql코드를 String에 담으면 비효율적인 이유.
 */
public class StringTest {

	public static void main(String[] args) {
		String str ="hello";
		System.out.println(str.replace('l', 'L'));
		System.out.println(str);
		//char타입의 l을 대문자L로 바꾸어 주세요
		str=str.replace('l', 'L');
		System.out.println(str);
		//대입연산자로 한 번 받아줘야 바뀐다.
		String tmp ="java";//1
		System.out.println("1:"+tmp);
		tmp +=" hello";//3 tmp= tmp+" hello"
		System.out.println("2:"+tmp);
		tmp +=" world!!";//3
		System.out.println("3:"+tmp);
		System.out.println("==================================");
		StringBuilder sb = new StringBuilder("hello");//원본이 바뀜
		sb.append(" java");
		System.out.println(sb);
		}

}
