package com.ch7;
//MethodTest�� ��Ӱ��迡 �մ� Ŭ������ �����Ƿ�
//�޼ҵ� �������̵��� ������ �ʴ´�.
public class MethodTest {
	//���������ڰ� ���� ���� friendly�����̴�.
	//���� ��Ű���� �ִ� Ŭ������ ���ٰ����ϴ�.
void go(){}
	void go(int i){}//�޼ҵ� �����ε� ����
	//public go(){} �޼ҵ� �����ε� �Ҹ���
	private void go(String s){}//�޼ҵ� �����ε� ����
/*	double go(){ return�� ����� ����. �޼ҵ� �����ε� �Ҹ���
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
