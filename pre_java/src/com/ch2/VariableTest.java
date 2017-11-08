package com.ch2;

public class VariableTest {

	public static void main(String[] args) {
		//변수 두 개 선언하기
		int a=1;
		int b=2;
		//두 수의 합을 담을 변수 선언하기
		int result=0;
		//두 수의 합 결과를 result변수에 담기
		result=a+b;//3
		System.out.println("합"+result);
		result=a-b;//-1
		System.out.println("차"+result);
		//첫번째에서 두번째 변수의 값을 뺀 후에 결과값을 result변수에 담아보기
		//result=0;을 주석으로 처리하면 result값이 -1로 초기화 되어있어서 합이 14가된다.
		//주석처리를 안하면 초기화가 0으로 되어 아래 계산결과에 영향을 미치지 않는다.
		result=0;//초기화를 안해주면 위의값인 -1부터 시작을 한다.
		for(int i=1;i<=5;i++){
			result=result+i;
			
		}
		System.out.println("1부터 5까지의 합은"+result);//15
	}

}
