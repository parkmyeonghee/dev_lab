package com.ch4;

import java.util.Random;
import java.util.Scanner;

public class RandomGameVer2 {
	/*
	 * 0���� 9������ ���� ä���ϱ�
	 * @return int
	 */
int nanSu(){
	int dap;
	Random r = new Random();
	dap=r.nextInt(10);
	return 0;
}
/*
 * ��ǻ�Ͱ� ä���� ���� ����ڰ� �Է��� �� ���ϱ�
 */
void gameRun(){
	int temp=userInput();
	int dap=nanSu();
	int count=0;
	for(;count<3;){
		System.out.println("���� �Է��ϼ���");
		//if(count<3){
			if(dap<temp){
				count++;
				System.out.println("���߶��");
				//ȸ�� ������Ű��
			}
			else if(dap>temp){
				count++;
				System.out.println("���߶��");
			}
			else if(dap==temp){
				System.out.println("���̶��");
				break;
			}////end of inner if 
		}//�ٺ��϶�
	
	
if(count==3){
	System.out.println("�ٺ���û��^^");
	return; //if���ȿ����� return�� ���ش�.
	}
}

/*
 * ����ڰ� ȭ�鿡 �Է��� �� �޾ƿ��� ����
 */
int userInput(){
	int temp;
	System.out.println("���� �Է��ϼ���");
	Scanner sc = new Scanner(System.in);
	String input=sc.nextLine();
	temp=Integer.parseInt(input);
	return temp;
}
	public static void main(String[] args) {
		{
			RandomGameVer2 rv=new RandomGameVer2();
			rv.gameRun();
			
			
			
		}
	}

}
