package com.ch5;

public class TwoArray {

	public static void main(String[] args) {
		int jumsu[][]=new int [3][4];
		for(int i=0;i<jumsu.length;i++){
			for(int j=0;j<jumsu[i].length;j++){
				System.out.println("jumsu["+i+"]["+j+"]="+jumsu[i][j]);
			}
		}
		//�������� ��갪�� ���� �迭�� �����Ͻÿ�
		int gugu[][]=new int[8][9];
		for(int i=2;i<10;i++){
			System.out.println("=================��=========");
			for(int j=1;j<10;j++){
				System.out.println(i+"x"+j+"="+i*j);
			}
		}

	}

}
