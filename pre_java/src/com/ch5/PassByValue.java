package com.ch5;
/*
 *재사용성과 이식성을 높이는 코딩을 전개한다.
 *재사용성을 높이는 첫번째 단계가 메소드 중심의 코딩을 전개하는 것이다.
 *1)리턴타입을 활용할 수 있다.
 *2)파라미터를 잘 활용할 수 있다.
 *파라미터에 대해서
 *1)passByValue방식
 *2)callByValue방식
 */
public class PassByValue {
	int a;//0
	int b;//0
	//변수 a와 변수b는 지역변수이다.
	void methodA(int a,int b){//passByValue-값에 의한 호출-복제된다.
		System.out.println(a+","+b);//10,20
		
		  this.a=a;
		  this.b=b;
		methodB(a,b);
	}
	int[]methodA2(int a,int b){//passbyvalue-값에 의한호출-복제된다.
		int is[]=new int[2];
		is[0]=a;
		is[1]=b;
		return is;
	}
	void methodB(){
		System.out.println(a+","+b);
	}
	void methodB(int a,int b){
		System.out.println("methodB(int a,int b):"+a+","+b);
	}
	//methodA에 파라미터인 변수 a값과 변수 b의 값을 methodB에서도 사용하고싶다.
	//1)전역변수 사용해 볼까?
	//2)파라미터를 이용해볼까?
	public static void main(String[] args) {
		PassByValue pv=new PassByValue();
		pv.methodA(10, 20);
		pv.methodB();
		int is[]=pv.methodA2(10, 20);
		for(int i=0;i<is.length;i++)
		{
			System.out.println("is["+i+"]="+is[i]);
		}
	}

}
