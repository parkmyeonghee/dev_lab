package com.ch5;
//�� �ҽ�.
public class SungJukArray {

	public static void main(String[] args) {
		int score[][] = {
				 {100,90,80}
				,{85,90,80}
				,{70,70,80}
				,{90,60,65}
				,{65,80,70}
		};
		int imsi[][] = new int[5][2];//������ ������ ���� 2�� �迭
		double avg[] = new double[5];//����� �Ǽ� Ÿ���̹Ƿ� ������ 1�� �迭 ����
		for(int i=0;i<score.length;i++)
		{
			int tot = score[i][0]+score[i][1]+score[i][2];
			imsi[i][0] = tot;
			avg[i] = Math.round(tot/3.0);
			imsi[i][1] = 1;//������ 1�� �����ϰ�
		}
		//������ �Űܺ���.
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				if(imsi[i][0] < imsi[j][0]){
					imsi[i][1]++;
				}
			}
		}
		//��� ����ϱ�
		for(int j=0;j<score.length;j++){
			System.out.print(avg[j]+" ");
		}
		System.out.println();
		//���� ����ϱ�
		for(int j=0;j<score.length;j++){
			System.out.print(imsi[j][0]+" ");
		}
		System.out.println();
		//���� ����ϱ�
		for(int j=0;j<score.length;j++){
			System.out.print(imsi[j][1]+" ");
		}
	}

}
