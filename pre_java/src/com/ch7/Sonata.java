package com.ch7;
/*******************************************************************************************
 * �ڹٿ����� ���� �̸��� �޼ҵ带 �ߺ����� �� �� �ִ�.
 * 1)�޼ҵ� �����ε�
 * :�ݵ�� ���� �̸� �϶�
 * 2)�޼ҵ� �������̵�
 * :�ݵ�� ���� �̸��̰� �׸��� ���� ��Ӱ��迡 �־�� �Ѵ�.
 *
 *******************************************************************************************/
public class Sonata extends Car implements Volume{//object�� ������ �����ϴ�. �׻� ��� �ִ¾���.
String carColor=null;
public int speed =10;
public Sonata(){
	//this();
	//super();�����ڸ� �̿��ؼ� ������ ȣ���� �� �ڵ� ���� �տ� �;��Ѵ�.
	//this(5);�� �����ϴ�.
	super(15);
	System.out.println("Sonata:"+speed);//sonata�� ���ǵ� ���
	System.out.println("Car:"+super.speed);//car�� ���ǵ� ���
}
public Sonata(int speed){
	this.speed=speed;//���: ���������� �Ѿ�� ���� ���������� ġȯ�ϱ�.
}
@Override
public String toString(){
	return "���� �ҳ�Ÿ �Դϴ�";
}
	@Override
	//protected void come(){}�� ���� ���������ڴ� �Ұ�
	public void come(){}
	public void come(int i){
		
	}
	@Override
	public void stop() {
		speed = 0;
	}
	@Override
	public void  volumeUp(){
		
	}
@Override
public void volumeDown()throws NullPointerException,Exception{
	
}
}
