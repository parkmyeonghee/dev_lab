package com.ch6;

public class Duck {
	static Duck herDuck=null;
	Duck getInstance(){
		Duck herDuck=null;
		if(herDuck==null) herDuck = new Duck();
		herDuck.swimming();
		return herDuck;
	}
public void swimming(){
	System.out.println("���� ��Ǫ��Ǫ������");
}
public void eat(){
	System.out.println("�������");
}
public void fly(){
	System.out.println("��������");
}
	public static void main(String[] args) {
		Duck myDuck = new Duck();
		Duck himDuck=myDuck.getInstance();
		System.out.println(myDuck+","+himDuck);
		myDuck.eat();
		himDuck.swimming();
		himDuck.fly();
		herDuck.swimming();
		himDuck.swimming();

	}

}
