package com.ch4;

public class FizzBuzzGame {

	public static void main(String[] args) {
		int i=1;
		//1부터 100까지 센다.
		//주사위를 다섯번 던져서 
		for(i=1;i<=100;i++){
			//i=1; 무한루프를 돈다.
		if((i%5==0)&&(i%7==0))//fizzbuzz출력
		{
			System.out.println("fizzbuzz");
		}
		else if(i%5==0)//fizz출력
		{
			
			System.out.println("fizz");
		}
		else if(i%7==0)///buzz출력
		{
			
			System.out.println("buzz");
		}else//숫자출력
		{
			System.out.println("i");
	}	
		


}
}
}
