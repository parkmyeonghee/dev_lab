package com.ch5;

class Father{
	Father(){
		
	}
	void go(){
		System.out.println("CBX�뷡 ���٤�����");
	}
}
class Sun{
	Sun(Father fa){
		fa.go();
	}
}
public class Test {
	public Test(){
		new Test(this);
		Father fa =new Father();
		Sun su= new Sun(fa);
	}
	public Test(Test t){
		System.out.println("test(test t)ȣ�� ����");
	}
//���θ޼ҵ�-�׽�Ʈ-�ۺ��׽�Ʈ-������-�ƺ�������-���̵�-�� ������
	public static void main(String[] args) {
		new Test();

	}

}
