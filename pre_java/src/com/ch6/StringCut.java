package com.ch6;

public class StringCut {

	public static void main(String[] args) {
		String input ="123";
		int temp=0;
		temp=Integer.parseInt(input);
		int inputs[]=new int[3];
		inputs[0]=temp/100; //1.23;
		inputs[1]=(temp%100)/10;//2
		inputs[2]=temp%10; //3
		System.out.println(inputs[0]+" "+inputs[1]+" "+inputs[2]);
		System.out.println(input.substring(0,1));
		System.out.println(input.substring(1,2));
		System.out.println(input.substring(2,3));
	}

}
