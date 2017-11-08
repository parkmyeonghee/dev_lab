package com.ch7;
//MethodTest는 상속관계에 잇는 클래스가 없으므로
//메소드 오버라이딩은 따지지 않는다.
public class MethodTest {
	//접근제한자가 없는 경우는 friendly상태이다.
	//같은 패키지에 있는 클래스만 접근가능하다.
void go(){}
	void go(int i){}//메소드 오버로딩 만족
	//public go(){} 메소드 오버로딩 불만족
	private void go(String s){}//메소드 오버로딩 만족
/*	double go(){ return과 상관은 없당. 메소드 오버로딩 불만족
		return 0.0;
	}*/
/*void go() throws NullPointerException{
	
}*/
void go(boolean isok) throws NullPointerException{
	
}
	public static void main(String[] args) {
		System.out.println("go".length());//2
		String str = null;
		System.out.println(str.length());

	}

}
