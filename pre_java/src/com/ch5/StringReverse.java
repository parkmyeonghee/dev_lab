package com.ch5;

import java.util.Scanner;

public class StringReverse {
void reverse(String str){
	char ch[]=str.toCharArray();
		for(int i=ch.length-1;i>=0;i--){
			System.out.println(ch[i]+"");
	
}
		System.out.println();
	}
void reverse(String[] str){//6번과 차이점은 같은 이름의메소드를 가질 수 있다. 그러려면 파라미터의 타입과 갯수가 다르면 된다.
		//메소드 오버로딩: 메소드 이름은 같을 때 같은 조건안에서 파라미터 갯수나 타입이 다를때 다른 메소드로 인식한다. 
	for(int i=str.length-1;i>=0;i--){
		for(int j=str[i].length()-1;j>=0;j--){
			System.out.println(str[i].charAt(j));
		}
		System.out.println(" ");
	}
	
}
	//25-26-27-28-return을 만나면 해당 메소드 탈출
	//25(메인메소드)-31-32-33(메소드 호출)-14(args주소번지)-15-16-17-18-19-20-21(메소드실행끝 우중괄호닫힘)-34
	public static void main(String[] args) {
		if(args.length==0){//배열의 원소의 갯수
			System.out.println("문자열을 입력하시오");
			return; //직접 값을 입력해서 뽑아준다.
		}
		else{
			StringReverse sr= new StringReverse();
			sr.reverse(args);
		}
		System.out.println("거꾸로 출력할 문자열을 입력하시오.\n");
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		StringReverse sr=new StringReverse();
	/*	String words[]=new String[4];
		words[0]="have";
		words[1]="a";
		words[2]="good";
		words[3]="time!";
		System.out.println("원소의 갯수:"+words.length);//4
		System.out.println("원소의 갯수:"+words[2].length());//4
		System.out.println("원소의 갯수:"+words[1].length());//1
		System.out.println("m출력하기"+words[3].charAt(2));//m
		System.out.println(words[0]+""+words[1]+""+words[2]+""+words[3]);
		System.out.println();//줄바꿈
		System.out.println(words[3]+""+words[2]+""+words[1]+""+words[0]);
		for(int i=words.length-1;i>=0;i--){
			System.out.println(words[i]+" ");
		}
		System.out.println("================================");
		for(int i=words.length-1;i>=0;i--){
			for(int j=words[i].length()-1;j>=0;j--){
				System.out.println(words[i].charAt(j));
			}
			System.out.println(" ");
		}
		System.out.println();
		System.out.println("have a good time!"); */
	}//end of main
}
