package com.ch5;

import java.util.Scanner;

public class StringReverse {
void reverse(String str){
	char ch[]=str.toCharArray();
		for(int i=ch.length-1;i>=0;i--){
			System.out.println(ch[i]+"");
	
}
		System.out.println();
	}
void reverse(String[] str){//6���� �������� ���� �̸��Ǹ޼ҵ带 ���� �� �ִ�. �׷����� �Ķ������ Ÿ�԰� ������ �ٸ��� �ȴ�.
		//�޼ҵ� �����ε�: �޼ҵ� �̸��� ���� �� ���� ���Ǿȿ��� �Ķ���� ������ Ÿ���� �ٸ��� �ٸ� �޼ҵ�� �ν��Ѵ�. 
	for(int i=str.length-1;i>=0;i--){
		for(int j=str[i].length()-1;j>=0;j--){
			System.out.println(str[i].charAt(j));
		}
		System.out.println(" ");
	}
	
}
	//25-26-27-28-return�� ������ �ش� �޼ҵ� Ż��
	//25(���θ޼ҵ�)-31-32-33(�޼ҵ� ȣ��)-14(args�ּҹ���)-15-16-17-18-19-20-21(�޼ҵ���ೡ ���߰�ȣ����)-34
	public static void main(String[] args) {
		if(args.length==0){//�迭�� ������ ����
			System.out.println("���ڿ��� �Է��Ͻÿ�");
			return; //���� ���� �Է��ؼ� �̾��ش�.
		}
		else{
			StringReverse sr= new StringReverse();
			sr.reverse(args);
		}
		System.out.println("�Ųٷ� ����� ���ڿ��� �Է��Ͻÿ�.\n");
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		StringReverse sr=new StringReverse();
	/*	String words[]=new String[4];
		words[0]="have";
		words[1]="a";
		words[2]="good";
		words[3]="time!";
		System.out.println("������ ����:"+words.length);//4
		System.out.println("������ ����:"+words[2].length());//4
		System.out.println("������ ����:"+words[1].length());//1
		System.out.println("m����ϱ�"+words[3].charAt(2));//m
		System.out.println(words[0]+""+words[1]+""+words[2]+""+words[3]);
		System.out.println();//�ٹٲ�
		System.out.println(words[3]+""+words[2]+""+words[1]+""+words[0]);
		for(int i=words.length-1;i>=0;i--){
			System.out.println(words[i]+" ");
		}
		System.out.println("================================");
		for(int i=words.length-1;i>=0;i--){
			for(int j=words[i].length()-1;j>=0;j--){
				System.out.println(words[i].charAt(j));
			}
			System.out.println(" ");
		}
		System.out.println();
		System.out.println("have a good time!"); */
	}//end of main
}
