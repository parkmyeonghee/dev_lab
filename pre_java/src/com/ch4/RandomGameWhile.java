package com.ch4;

import java.util.*;
public class RandomGameWhile {

	
	public static void main(String[] args) {
		Random r = new Random();
		int input = r.nextInt(10);
		Scanner sc = new Scanner(System.in);
		int j=0;
		int count=0;
		while(j<10){
			j++;
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

