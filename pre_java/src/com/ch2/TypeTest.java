package com.ch2;
/*
 * 1.형전환
 * -자동형전환:int를 기준으로 작은 타입은 자동형전환
 * -강제형전환:casing 연산자를 사용한다.
 * 2.
 * 	-int*float=float
 *  -int/double=double
 *  -float-double=double
 *  -String+int=String
 *  -String+double=String
 */
public class TypeTest {

	public static void main(String[] args) {
		
		int i=10;
		long l =10L;
		float f=3.14f;
		double d=1.5;
		l=i;//10
		System.out.println(l);//10
		f=(float)d;//강제형전환.3.14
		System.out.println(f);//1.5
		d=f;//3.14
		System.out.println(d);//10.0
		d=i;//10
		System.out.println(d);//10.0
		d=l;//10
		System.out.println(d);//10.0
		
		
		
		
		
		
	}

}
