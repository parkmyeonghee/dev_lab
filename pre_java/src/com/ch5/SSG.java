package com.ch5;
import java.util.*;

public class SSG {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int[] score=new int[5];
		//int max=0;
		//int min=0;
		int max=score[0];
		int min=score[0];
		int hap=0;
		double avg=0.0;
		
		System.out.println("숫자입력ㅇㅇ");
		for(int i=0;i<5;i++){
			score[i]=scanner.nextInt();
			hap=hap+score[i];
			avg=hap/5.0;
			if(i==1){
				min=score[0];
			}
			if(score[i]>max){
				max=score[i];
			}
			if(score[i]<min){
				min=score[i];
			}
		}
		
		
		System.out.println("최대:"+max);
		System.out.println("최소:"+min);
		System.out.println("총점:"+hap);
		System.out.println("평균:"+avg);
	}

}
