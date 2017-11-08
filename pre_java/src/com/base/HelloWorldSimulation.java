package com.base;
/*
 *꼭 자바여야 하는가? 
 *재사용성과 이식성
 *확인할 내용
 *참조형 타입의 경우 원시형 타입과 달리 호출 했을 때 주소번지를 출력하게 된다.
 *도전과제:
 *HelloWorld.java에서 선언한 변수 x사용하기
 *-> 출력결과 : x=10;
 */

public class HelloWorldSimulation {

	public static void main(String[] args) {
		
		int x=100;
		System.out.println("x="+x);//문자열 두개를 붙여줄때
		System.out.println(10+""+20);//연결을 해준다.
		Helloworld hw =new Helloworld();//Helloworld hw=null; hw=new Helloworld();
		/*괄호가 생길때 생성자,메소드 이 두가지 경우일때
		 * 변수 hw는 Helloworld클래스 타입이다.
		 *클래스 타입변수 hw는 호출하면 주소번지를 출력.
		 * 변수 x는 int타입이다.
		 * 원시타입 변수 x는 호출하면 값을 출력*/
		System.out.println("주소번지:참조형변수"+hw);//@1db9742 주소번지를 불러줌.
		System.out.println("hw.x변수="+hw.x);//10
		hw.go();//다트 연산자라고 한다
	}

}
