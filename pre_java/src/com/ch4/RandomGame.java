package com.ch4;
/*
 * �޼ҵ� �����غ��� - ���뼺�� ���ؼ�
 * �޼ҵ带 ������ �� �ִ�.
 * ����Ÿ���� ������ �� �ִ�.
 * �Ķ���͸� ������ �� �ִ�.
 * 1.������ ���۽� ���ο� ���ڸ� ä���ϴ� �޼ҵ� �����ϱ�
 * int nanSu(){}
 * Random
 * r.nextInt(10);
 * 2.���ӽ���� �����ϴ� �޼ҵ� ���ϱ�
 * count
 * void gameRun(){}
 * 3.����ڰ� �Է��� ���� �޾ƿ��� �޼ҵ� �����ϱ�
 * Scanner
 * int userInput()
 */
import java.util.*;

public class RandomGame {


	public static void main(String[] args) {

		
		Random r = new Random();
		int input = r.nextInt(10);
		int count=0;
		

		Scanner sc = new Scanner(System.in);
		//System.out.println(input);������� �����ִ¾���
		for (int j =1; j<4; j++) {
			
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

