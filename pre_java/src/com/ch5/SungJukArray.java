package com.ch5;
//쌤 소스.
public class SungJukArray {

	public static void main(String[] args) {
		int score[][] = {
				 {100,90,80}
				,{85,90,80}
				,{70,70,80}
				,{90,60,65}
				,{65,80,70}
		};
		int imsi[][] = new int[5][2];//총점과 석차를 담을 2차 배열
		double avg[] = new double[5];//평균은 실수 타입이므로 별도의 1차 배열 선언
		for(int i=0;i<score.length;i++)
		{
			int tot = score[i][0]+score[i][1]+score[i][2];
			imsi[i][0] = tot;
			avg[i] = Math.round(tot/3.0);
			imsi[i][1] = 1;//석차를 1로 설정하고
		}
		//석차를 매겨보자.
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				if(imsi[i][0] < imsi[j][0]){
					imsi[i][1]++;
				}
			}
		}
		//평균 출력하기
		for(int j=0;j<score.length;j++){
			System.out.print(avg[j]+" ");
		}
		System.out.println();
		//총점 출력하기
		for(int j=0;j<score.length;j++){
			System.out.print(imsi[j][0]+" ");
		}
		System.out.println();
		//석차 출력하기
		for(int j=0;j<score.length;j++){
			System.out.print(imsi[j][1]+" ");
		}
	}

}
