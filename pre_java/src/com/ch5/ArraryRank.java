package com.ch5;

public class ArraryRank {

	public static void main(String[] args) {
		int[][] score={
				{100,100,100}
				,{90,100,80}
				,{0,0,0}
				,{10,50,60}
				,{50,80,90}
		};
		int korTotal=0;
		int engTotal=0;
		int mathTotal=0;
		System.out.println("번호 국어 영어 수학 총점 평균 석차ㅗ");
		System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★");
		for(int i=0;i<score.length;i++){
			int sum=0;
			double avg=0.0;
			korTotal +=score[i][0];
			engTotal +=score[i][1];
			mathTotal +=score[i][2];
			System.out.printf("%3d",i+1);
			for(int j=0;j<score[i].length;j++){
				sum +=score[i][j];
				System.out.printf("%5d",score[i][j]);
			}
			avg=sum/score[i].length;
			System.out.printf("%5d %5.0%n",sum,avg);
			
		}
		
		System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★");
		System.out.printf("총점:%3d %4d %4d %n",korTotal,engTotal,mathTotal);
	}
	

}
