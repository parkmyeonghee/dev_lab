package com.ch6;
/*
 * 1.디폴트 생성자는 생략할 수 있다.
 * 디폴트 생성자가 생략되었을 경우에는 JVM(자바가상머신-API)이 제공한다.
 * 생성자를 선언하는 방법
 * 클래스 이름과 반드시 일치해야한다.(대소문자 구분)
 * 리턴타입은 존재할 수 없다.(만일 생성자 앞에 리턴타입을 표시하면 메소드로 취급)
 * 2.인스턴스화를 하면 생성자 호출이 된다.
 * 3.생성자는 전역변수에 대한 초기화(원시타입:값,참조타입:null)를 담당한다.
 * 4.생성자는 여러개 존재(중복정의)할 수 있다.
 *: 메소드 오버로딩의 규칙을 준수한다.
 *->메소드를 구현할 수 있다.
 *->메소드를 호출할 수 있다.
 *->메소드를 중복정의할 수 있다.(같은 이름이 여러개 올 수 있다.)
 *1)메소드오버로딩
 *-반드시 파라미터의 갯수가 달라야 한다.
 *-민일 파라미터의 갯수는 같은데 타입이 다르다.
 *-혹은 파라미터의 타입이 달라야 한다.
 *-리턴타입(void,int,sonata)이 있고 없고는 영향이 없다.(중복선언)
 *-접근제한자(public,protected,private)있고 없고는 영향이 없다.
 *2)메소드오버라이딩
 * 
 */

public class GalaxySimulation {

	public static void main(String[] args) {
		//1.galaxy객체 접근할 수 있는 변수를 갖게 된다.-주소번지 할당
		//2.heap메모리 영역에 객체가 로딩된다.
		//3.전역변수에 대한 초기화
		Galaxy g = new Galaxy();//디폴트 생성자 호출
		System.out.println("g===>"+g);
		System.out.println("g===>"+g.toString());
		GalaxySimulation gs=new GalaxySimulation();
		System.out.println("gs===>"+gs);
		System.out.println("gs===>"+gs.toString());
		new Galaxy(true);//재사용이 불가능 가르키는 주소번지가 없다. 생성자 호출
		Galaxy g1= new Galaxy();
		new Galaxy(true,false);
		//g=new Galaxy(true);
		System.out.println("g1.power==>"+g1.power);//false
		//위에 라인에서 호출한 변수 power는 전역변수가 호출된 것이다.-->네
		//갤럭시 g1라인에서 호출한 생성자의 파라미터 값인 true가 
		

	}

}
