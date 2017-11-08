package com.ch7;
class Outter{
	int i;
	class Inner{
		int j;
		void print(){
			System.out.println("Inner print 호출성공");
		}
	}
	void go(){
		System.out.println("Outter go 호출성공");
	}
}
public class OuterInnerTest {

	public static void main(String[] args) {
		Outter outt = new Outter();
		Outter.Inner inn=
				new Outter().new Inner();
		Outter.Inner inn2=outt.new Inner(); //외부클래스를 통해서만 내부클래스에 올 수 있다
		inn.print();
		inn2.print();
		outt.go();
	}

}
