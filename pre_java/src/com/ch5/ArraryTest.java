package com.ch5;

public class ArraryTest {
	//선언부-전역변수 성격
	//결론: 선언부에는 선언과 초기화를 나누어 코딩할 수 없다.
	//선언과 초기화를 한번에 해야한다.
	int i=10;
	int is[]=new int[5];
	double ds[]={1.5,1.3,1.8};
	/*
	 * int i;
	 * i=10;
	 * int is[]=null;
	 * is=new int[7]; 에러
	 */
	int[] methodA(){//b로 던져주기 위해서는 return을 던지고
		int x;
		x=10;
		int is[]=null;
		is=new int[7];
		return is;
	}
	int[] methodB(int is[]){//값을 받기위해서는 parameter로 받는다
		//a에 선언된 배열 is를 초기화 하시오
		//초기값은 마음대로
		is[0]=3;
		is[1]=4;
		is[2]=5;
		is[3]=6;
		is[4]=7;
		is[5]=8;
		is[6]=9;
		return is;
		
	}
void methodBprint(int is[]){
	for(int x=0;x<is.length;x++){
		System.out.println("is["+x+"]"+is[x]);
	}
}

	public static void main(String[] args) {
		//전역변수 i를 출력하시오
		ArraryTest at =new ArraryTest();
		System.out.println(at.i);//10
		//선언부에 있는 is배열의 값들을 출력하시오.
		int is[]=at.methodA();
		is=at.methodB(is);
		at.methodBprint(is);
		System.out.println(at.is[0]);//0		
		System.out.println(at.is[1]);//0	
		System.out.println(at.is[2]);//0	
		System.out.println(at.is[3]);//0	
		System.out.println(at.is[4]);//반복되는 코드는 반복문을 사용하자.
		for(int x=0;x<at.is.length;x++){
			System.out.println(at.is[x]);//0~4
		}
		at.methodA();
	}

}
