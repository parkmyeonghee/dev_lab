package com.ch5;
import java.util.*;
public class RandomArarry {

	public static void main(String[] args) {
		//����ڰ� �Է��� ������ ���� �迭�� �����ϰ� ����
		int jumsu[]=new int[5];
		//5���� ������ ������ �Է¹޾� �ϹǷ� �ݺ��� ����ϱ�
		for(int i=0;i<5;i++){
			Random r=new Random();
			jumsu[i]=r.nextInt(101);
			System.out.println(jumsu[i]);
		}
		//�������ϱ�-��������
		int tot=0;
		for(int j=0;j<5;j++){
			tot=tot+jumsu[j];
					
				}
		
		System.out.println("����:"+tot);
		//��ձ��ϱ� -��������
		double avg =0.0;
		avg=tot/5.0;
		System.out.println("���:"+avg);
	
	}
	}

