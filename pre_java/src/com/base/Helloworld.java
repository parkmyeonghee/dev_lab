package com.base;
/*
변수의 선언방법을 알 수 있다.
-타입 변수명=(대입 연산자:==)값;
변수명은 예약어를 사용할 수 없다. ex) int class=10; , int int=100; 사용 불가능
변수명은 숫자로 시작할 수 없다.
특수문자는 _와$만 사용가능하다.
변수의 사용 방법
-타입을 사용할 필요는 없다.
-직접 값을 사용하지 않는다.(변수명을 사용한다.)
변수를 사용하는 이유
-재사용 할 수 있다.
-주소번지보다 기억하기 쉽다.
-일괄처리 할 수 있다.(하나만 변경하더라도 전체를 다 변경 할 수 있다.)
-변수가 갖는 장애:
1.한 번에 하나만 담을 수 있다.
2.동시에 두 가지값 유지가 불가능하다.
->해결 방법: 배열
3.같은 타입만 가질 수 있다. ex)int,double동시에 담을 수 없다.
*/

public class Helloworld {
	static int x=10;// 정수 타입을 담을 수 있는 공간을 할당.공간은 메모리 공간(주소 번지)
	static int y=20; /*class안에 변수 선언을 할 때 타입을 적는다. 메인메소드 안에 static이 있기때문에
	여기는 class뿐이라서 붙여준당.
	*/

	/*
	선언부
	
	생성자
	
	사용자 정의 추가 메소드 구현
	
	메인 메소드 선언 및 구현 -exe파일로 만들 수 있다.= 실행할 수 있다.
	 */
	void go(){
		System.out.println("go메소드 호출 성공");
	}

	
	public static void main(String[] args) {
		System.out.println("Hello world!!!!");
		System.out.println(10);//상수 취급을 받는다.
		x=30;//두번째 값을 주는것이 된다.
		/*int x=30;동시에 값을 주면 나중에 준 값이 나온다.
		int값을 주면 선언을 한번 더 한것이라서 다른 값이 되버린다.다른 인수가 되는것과 같은것임 뿌잉*/
		System.out.println(x); //10->30
		System.out.println(y);//println은 줄바꿈,print를 쓰면 옆에 붙음
		System.out.println(x+y);//30->50
		System.out.println(y/x);//상수값 변수값에 따라서 달라짐 
		System.out.println(x/y);
		System.out.println(x*y);
		
	
	}
	}


