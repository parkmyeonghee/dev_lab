package com.ch4;

public class FizzBuzzGame {

	public static void main(String[] args) {
		int i=1;
		//1���� 100���� ����.
		//�ֻ����� �ټ��� ������ 
		for(i=1;i<=100;i++){
			//i=1; ���ѷ����� ����.
		if((i%5==0)&&(i%7==0))//fizzbuzz���
		{
			System.out.println("fizzbuzz");
		}
		else if(i%5==0)//fizz���
		{
			
			System.out.println("fizz");
		}
		else if(i%7==0)///buzz���
		{
			
			System.out.println("buzz");
		}else//�������
		{
			System.out.println("i");
	}	
		


}
}
}
