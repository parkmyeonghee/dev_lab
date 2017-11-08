package com.ch6;

class hp{
	String color;
	boolean power;
	int number;
	
	void power(){power =! power;}
	
}
public class hpTest {

	
	public static void main(String[] args) {
		hp h;
		h=new hp();
		h.power();
		System.out.println(h.power);

	}

}
