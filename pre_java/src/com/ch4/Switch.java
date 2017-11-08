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

		//System.out.println(i);디폴트 값이 출력된다.
		}
		System.out.println(i); 
	}

}
//break가 없으면 계속 넘어간다.