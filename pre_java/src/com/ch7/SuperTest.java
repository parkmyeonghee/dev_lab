package com.ch7;
/*********************************************************************************************
 * 자바에서는 같은 이름의 메소드를 중복 정의 할 수 있습니다.
 * 규칙
 * 공통사항: 반드시 메소드의 이름은 같아야 합니다.
 * 추가사항: 서로 상속관계에 있을 때(오버라이딩인 경우)
 *메소드 오버라이딩
 * 반드시 선언부가 일치해야 한다.
 * :리턴타입이나 파라미터를 변경할 수 없다.
 * :접근제한자는 더 넓은?
 * 
 * 메소드 오버로딩
 * 반드시 파라미터의 갯수가 다르거나
 * 또는 파라미터의 타입이 달라야 합니다.
 * :리턴타입이 있고 없고는 영향이 없다.
 * :접근제한자가 있고 없고는 영향이 없다.
 * :예외를 던지고 던지지 않고는 영향이 없다.
 * this-자기자신&super-부모클래스
 * this()&super()
 **********************************************************************************************/
class Father{
	//생성자는 오버로딩 규칙을 준수합니다.
	String name=null;
	int age=0;
	Father(){
		System.out.println("Father 호출 성공");
	}
	Father(String name){
		
	}
	Father(String name,int age){
		
	}
	public void go(){
		System.out.println("Father go 호출 성공");
	}
	public void come(){
		System.out.println("Father come 호출 성공");
		
	}
	/*
	 * 메소드 선언부에 final을 붙이면
	 * 자식 클래스에서 오버라이딩 불가.
	 */
	public final void stop(){
		System.out.println("Father stop 호출 성공");//final을 붙이면 오버라이딩을 할 수 없다.
		
	}
}
class Son extends Father{
	String blood = null;
	Son(){
	System.out.println("Son 호출 성공");
}
	/*public int go{에러발생: 메소드 오버로딩 규칙 어김
		return 0;		
	}*/
	Son(String name){
		
	}
	Son(String name,int age){
		
	}
	Son(String name,int age,String blood){
		
	}
	@Override
	public void go(){
		System.out.println("Son go 호출성공");
	}
	public int go(int x){//메소드 오버로딩 만족
		return 0;
	}
	public int go(int x,int y){//메소드 오버로딩 만족
		return 0;
	}
}
public class SuperTest {
	/*
	 * 부모와 자식간에 오버라이딩 관계에 있는 메소드 에서는 선언부의 타입에
	 * 상관 없이 생성부 타입이 자식 타입일 때
	 * 부모 클래스에 정의된 메소드는 쉐도우 메소드가 됩니다.
	 */

	public static void main(String[] args) {
		Father my = new Son();
		my.go();//Son go 출력
		//father go 출력하기
		Father him = new Father();
		him.go();//Father go 출력
		Son me = new Son();
		me.go();//Son go 호출
		my.come();//father come 호출
		me.come();//father come 호출
	}

}
