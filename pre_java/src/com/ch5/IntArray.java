package com.ch5;

public class IntArray {

	public static void main(String[] args) {
		int x[];
		x= new int[3];
		System.out.println(0);
		System.out.println(1);
		System.out.println(2);
		int i=0;
		for(i=0;i<3;i++){
			System.out.println(x[i]);
			
		}
		i=0;
		while(i<3){
			System.out.println(x[i]);
			++i;
		}
		i=0;
		do{
			System.out.println(x[i]);
			++i;
		}while(i<3);
		System.out.println("=========================");
		//������ for��
		//for(�迭�ȿ� ��� Ÿ���� ���� ����:�迭�̸�){}
		for(int j:x){
			System.out.println(j);
		}
		System.out.println("=================");
		x[0]=10;
		x[1]=20;
		x[2]=30;
		for(int v:x){
			System.out.println(v);
		}
		
	}
}
