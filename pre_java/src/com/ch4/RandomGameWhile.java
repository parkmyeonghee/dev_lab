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
			System.out.println("���ڸ� �Է�����33");
			String num = sc.nextLine();
			
			if (Integer.parseInt(num) == input) {
				System.out.println("�����̿��� �ȶ��ؿ�");
				break;
			}

			else if (Integer.parseInt(num) < input) {
				System.out.println("�� ŭ��");
				if(count==3)
				{System.out.println("�ٺ����");}
				//System.out.println("����Ƚ��"+count); ������ ���̳ʽ�������.
			} else //if(Integer.parseInt(num) >input)//{
				System.out.println("�� ������");
			if(count==3)
			{System.out.println("�ٺ����");}
				//System.out.println("����Ƚ��:"+count);
		

	
	}

	}
			


	}

