package com.ch4;

public class BuzzFizz {

	public static void main(String[] args) {
		int i=1;
		int hap=0;
		for(i=1;i<=100;i++){
			switch(i%35){
			//35�� ������ �������� ���
			case 0:
				//5�� ������ �������°��
				System.out.println("fizzbuzz");
			case 5: case 10: case 15: case 20:
			case 25: case 30:	
				System.out.println("fizz");
			case 7: case 14: case 28:
				//7�� ������ �������� ���
				System.out.println("buzz");
				default:
					//���ڸ� �״�� ����ϱ�
					System.out.println(i);
					
				
			}
		}
	}

}
