package com.ch7;
/*********************************************************************************************
 * �ڹٿ����� ���� �̸��� �޼ҵ带 �ߺ� ���� �� �� �ֽ��ϴ�.
 * ��Ģ
 * �������: �ݵ�� �޼ҵ��� �̸��� ���ƾ� �մϴ�.
 * �߰�����: ���� ��Ӱ��迡 ���� ��(�������̵��� ���)
 *�޼ҵ� �������̵�
 * �ݵ�� ����ΰ� ��ġ�ؾ� �Ѵ�.
 * :����Ÿ���̳� �Ķ���͸� ������ �� ����.
 * :���������ڴ� �� ����?
 * 
 * �޼ҵ� �����ε�
 * �ݵ�� �Ķ������ ������ �ٸ��ų�
 * �Ǵ� �Ķ������ Ÿ���� �޶�� �մϴ�.
 * :����Ÿ���� �ְ� ����� ������ ����.
 * :���������ڰ� �ְ� ����� ������ ����.
 * :���ܸ� ������ ������ �ʰ�� ������ ����.
 * this-�ڱ��ڽ�&super-�θ�Ŭ����
 * this()&super()
 **********************************************************************************************/
class Father{
	//�����ڴ� �����ε� ��Ģ�� �ؼ��մϴ�.
	String name=null;
	int age=0;
	Father(){
		System.out.println("Father ȣ�� ����");
	}
	Father(String name){
		
	}
	Father(String name,int age){
		
	}
	public void go(){
		System.out.println("Father go ȣ�� ����");
	}
	public void come(){
		System.out.println("Father come ȣ�� ����");
		
	}
	/*
	 * �޼ҵ� ����ο� final�� ���̸�
	 * �ڽ� Ŭ�������� �������̵� �Ұ�.
	 */
	public final void stop(){
		System.out.println("Father stop ȣ�� ����");//final�� ���̸� �������̵��� �� �� ����.
		
	}
}
class Son extends Father{
	String blood = null;
	Son(){
	System.out.println("Son ȣ�� ����");
}
	/*public int go{�����߻�: �޼ҵ� �����ε� ��Ģ ���
		return 0;		
	}*/
	Son(String name){
		
	}
	Son(String name,int age){
		
	}
	Son(String name,int age,String blood){
		
	}
	@Override
	public void go(){
		System.out.println("Son go ȣ�⼺��");
	}
	public int go(int x){//�޼ҵ� �����ε� ����
		return 0;
	}
	public int go(int x,int y){//�޼ҵ� �����ε� ����
		return 0;
	}
}
public class SuperTest {
	/*
	 * �θ�� �ڽİ��� �������̵� ���迡 �ִ� �޼ҵ� ������ ������� Ÿ�Կ�
	 * ��� ���� ������ Ÿ���� �ڽ� Ÿ���� ��
	 * �θ� Ŭ������ ���ǵ� �޼ҵ�� ������ �޼ҵ尡 �˴ϴ�.
	 */

	public static void main(String[] args) {
		Father my = new Son();
		my.go();//Son go ���
		//father go ����ϱ�
		Father him = new Father();
		him.go();//Father go ���
		Son me = new Son();
		me.go();//Son go ȣ��
		my.come();//father come ȣ��
		me.come();//father come ȣ��
	}

}
