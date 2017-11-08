package com.ch4;

import java.util.Random;
import java.util.Scanner;

public class RandomGameVer2 {
	/*
	 * 0부터 9사이의 난수 채번하기
	 * @return int
	 */
int nanSu(){
	int dap;
	Random r = new Random();
	dap=r.nextInt(10);
	return 0;
}
/*
 * 컴퓨터가 채번한 값과 사용자가 입력한 값 비교하기
 */
void gameRun(){
	int temp=userInput();
	int dap=nanSu();
	int count=0;
	for(;count<3;){
		System.out.println("값을 입력하세요");
		//if(count<3){
			if(dap<temp){
				count++;
				System.out.println("낮추라능");
				//회차 증가시키기
			}
			else if(dap>temp){
				count++;
				System.out.println("낮추라능");
			}
			else if(dap==temp){
				System.out.println("답이라능");
				break;
			}////end of inner if 
		}//바보일때
	
	
if(count==3){
	System.out.println("바보멍청이^^");
	return; //if문안에서는 return을 써준다.
	}
}

/*
 * 사용자가 화면에 입력한 값 받아오기 구현
 */
int userInput(){
	int temp;
	System.out.println("값을 입력하세요");
	Scanner sc = new Scanner(System.in);
	String input=sc.nextLine();
	temp=Integer.parseInt(input);
	return temp;
}
	public static void main(String[] args) {
		{
			RandomGameVer2 rv=new RandomGameVer2();
			rv.gameRun();
			
			
			
		}
	}

}
