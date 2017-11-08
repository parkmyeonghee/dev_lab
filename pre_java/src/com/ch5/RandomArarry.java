package com.ch5;
import java.util.*;
public class RandomArarry {

	public static void main(String[] args) {
		//사용자가 입력한 점수를 받을 배열을 선언하고 생성
		int jumsu[]=new int[5];
		//5개의 임의의 점수를 입력받아 하므로 반복문 사용하기
		for(int i=0;i<5;i++){
			Random r=new Random();
			jumsu[i]=r.nextInt(101);
			System.out.println(jumsu[i]);
		}
		//총점구하기-변수선언
		int tot=0;
		for(int j=0;j<5;j++){
			tot=tot+jumsu[j];
					
				}
		
		System.out.println("총점:"+tot);
		//평균구하기 -변수선언
		double avg =0.0;
		avg=tot/5.0;
		System.out.println("평균:"+avg);
	
	}
	}

