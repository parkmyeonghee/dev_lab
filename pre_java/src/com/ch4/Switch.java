package com.ch4;

public class Switch {

	public static void main(String[] args) {
		int i =1;
		switch(i){
		case 0:
			i++;
			break;
		case 1:
			i++;//2
			break;
		case 2:
			i++;//3
			break;
			
			default:
				i++;//4

		//System.out.println(i);����Ʈ ���� ��µȴ�.
		}
		System.out.println(i); 
	}

}
//break�� ������ ��� �Ѿ��.