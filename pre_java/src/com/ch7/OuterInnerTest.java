package com.ch7;
class Outter{
	int i;
	class Inner{
		int j;
		void print(){
			System.out.println("Inner print ȣ�⼺��");
		}
	}
	void go(){
		System.out.println("Outter go ȣ�⼺��");
	}
}
public class OuterInnerTest {

	public static void main(String[] args) {
		Outter outt = new Outter();
		Outter.Inner inn=
				new Outter().new Inner();
		Outter.Inner inn2=outt.new Inner(); //�ܺ�Ŭ������ ���ؼ��� ����Ŭ������ �� �� �ִ�
		inn.print();
		inn2.print();
		outt.go();
	}

}
