package com.ch4;
import java.util.*;
public class dap {

	public static void main(String[] args) {
		Random r=new Random();
		//����ڰ� �Է��� ���� Ÿ���� String�̹Ƿ�
		//��(int)�� ���ϱ����ؼ��� ����ȯ�� �ʿ�
		int temp=0;//nansu
		//�����ϰ� ä���� ���� ���� ���� ����
		int dap=0;//user int
		dap=r.nextInt(10); //�����Լ��� ¦��
		int count=1;
		for(int i=1;;i++){
			Scanner sc = new Scanner(System.in);
			String input=sc.nextLine();
			temp=Integer.parseInt(input);
			System.out.println(input);
			if(count<3){
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
			}else{
				System.out.println("�ٺ���û��^^");//�ٺ��϶�
		}
		
		}//////end of outter if
	}///end of for

	}///end of main

/////end of Randomgame
