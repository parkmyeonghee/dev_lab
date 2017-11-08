package com.ch4;
import java.util.*;
public class dap {

	public static void main(String[] args) {
		Random r=new Random();
		//사용자가 입력한 값의 타입이 String이므로
		//답(int)로 비교하기위해서는 형변환이 필요
		int temp=0;//nansu
		//랜덤하게 채번된 값을 담을 변수 선언
		int dap=0;//user int
		dap=r.nextInt(10); //랜덤함수랑 짝궁
		int count=1;
		for(int i=1;;i++){
			Scanner sc = new Scanner(System.in);
			String input=sc.nextLine();
			temp=Integer.parseInt(input);
			System.out.println(input);
			if(count<3){
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
			}else{
				System.out.println("바보멍청이^^");//바보일때
		}
		
		}//////end of outter if
	}///end of for

	}///end of main

/////end of Randomgame
