package com.ch4;
/*
 * 메소드 구현해보기 - 재사용성을 위해서
 * 메소드를 선언할 수 있다.
 * 리턴타입을 선택할 수 있다.
 * 파라미터를 선택할 수 있다.
 * 1.세게임 시작시 새로운 숫자를 채번하는 메소드 구현하기
 * int nanSu(){}
 * Random
 * r.nextInt(10);
 * 2.게임실행시 판정하는 메소드 구하기
 * count
 * void gameRun(){}
 * 3.사용자가 입력한 값을 받아오는 메소드 구현하기
 * Scanner
 * int userInput()
 */
import java.util.*;

public class RandomGame {


	public static void main(String[] args) {

		
		Random r = new Random();
		int input = r.nextInt(10);
		int count=0;
		

		Scanner sc = new Scanner(System.in);
		//System.out.println(input);답안지를 보여주는아이
		for (int j =1; j<4; j++) {
			
			count=j;	
			System.out.println("숫자를 입력해주33");
			String num = sc.nextLine();
			
			if (Integer.parseInt(num) == input) {
				System.out.println("정답이에용 똑똑해용");
				break;
			}

			else if (Integer.parseInt(num) < input) {
				System.out.println("더 큼ㅋ");
				if(count==3)
				{System.out.println("바보쟈냐");}
				//System.out.println("남은횟수"+count); 범위가 마이너스까지감.
			} else //if(Integer.parseInt(num) >input)//{
				System.out.println("더 작음ㅋ");
			if(count==3)
			{System.out.println("바보쟈냐");}
				//System.out.println("남은횟수:"+count);
		
		

	
	}
	

	}
}

