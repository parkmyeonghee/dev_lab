package com.ch8;

import com.ch7.Sonata;
/*
 * try..catch블록은 예외가 발생할 가능성이 있는 코드를 실행문으로 넣는다.
 * 만일 예외상황이 발생하지 않으면 없는 것과 같다.
 * try catch블록을 사용하면 문제가 발생하더라도 무조건 실행 되어야 할 코드가 잇거나
 * 정상적인 종료로 유도할 수 있다.
 * 멀티 블록을 사용할 경우에는 하위클래스 먼저 상위클래스 나증 작성 한다.
 */
public class ExceptionExam1 {
	public ExceptionExam1(){
		try {
			showNumberFormatException("귀여운와타시");	
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
	}
	void showNumberFormatException(String input){//"0","100","문자열",null

			int in =0;
			 in = Integer.parseInt(input);
		System.out.println("사용자가 입력한 값:"+in);
	}
	public static void main(String[] args) {
		
		new ExceptionExam1(); //ui솔루션 매핑할때 많이씅미
		Sonata myCar=null; //아직 객체가 메모리에 활성화ㄴㄴ
		//null인 상태에서는 아직 주소번지가 할당 되지 않았다.
		try {
			System.out.println(myCar.speed);
			myCar.come();
			//클래스 하나의 상속관계 생각해주라
	/*	} catch (NullPointerException ne) {
			System.out.println(ne.toString());*/
		}catch(Exception e){ //nullpoint보다 그냥 exception이 더 상위 클래스이다.
		System.out.println(e.toString());
	}
		System.out.println("여기");

}
}
