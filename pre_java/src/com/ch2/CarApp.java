package com.ch2;
/*
 * 자바 API흉내내기
 * 
 */
public class CarApp {
	
	static void test(){
		int i =Integer.parseInt("5");//안에는 String이 나와야한다.double써도 안된다.
		System.out.println("변수 i:"+i);//선언만 되었을때 나오는게 아니라 호출을 해줘야함.
		int a=Integer.parseInt("500");
		System.out.println("변수a:"+a);
		int g=Integer.parseInt("-100");
		System.out.println("변수g:"+g);
		/*int f=Integer.parseInt("ㅎㅎ");
		System.out.println("변수f:"+f);*/ //에러->예외가 일어남 런타임오류가 일어난다.
		//메인메소드에서 호출을 할 때는 static을 붙이던가 아니면 dd d=new dd이런식으로 해줘야한다.
	}

	public static void main(String[] args) {
/*
 * 내안(CarApp)에 구현되어 있다 하더라도
 * non-static메소드는 static영역(main)에서 직접호출은 불가하다.
 * 해결방법
 * 객체를 생성 한 후 주소번지를 이용하면 호츌가능
 */
		Sonata myCar= new Sonata();//변수 이름으로 부름
		double d=Double.parseDouble("10");//클래스 타입으로 불러줌
		Sonata.speedDown();//static을 써줬을때의 권장사항임
		System.out.println(d+20);//30.0 
		myCar.speedUp();//다른클래스에 있는것을 호출하는 것임.
		test();
	
		
	}

}
