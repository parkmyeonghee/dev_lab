package com.ch6;
/*
 * ���� ȣ���ϴ� ���
 * 1)call by value(����Ÿ��)-���纻
 * 2)pass by value(����Ÿ��)-����
 * �����ڸ� ȣ���ϴ� ���
 * new Galaxy();
 * new Galaxy(true,false,"���");
 */
public class Galaxy {
	boolean power;//false
	boolean wifi;
	String color;//null
	//�����ڵ� non-static�����̹Ƿ� ���ȿ� �ִ� ���� Ȥ��
	//�޼ҵ带 ��ü�������� ���� ȣ���� �� �ִ�.
	public Galaxy(){//����Ʈ �����ڿ��� ���������� ���� �ʱ�ȭ
		//������ ȣ��
		System.out.println("������ ȣ�� ����������");
		power=false;
		wifi=false;
		color="���";
		isOnOff();
	}
	public Galaxy(boolean power){
		power=true; //�� �ȿ����� ����� �� �ִ�. �װ��� ����
		//this.power=power;
		
	}
	public Galaxy(boolean power,boolean wifi){
		
	}
	public Galaxy(boolean power,boolean wifi,String color){
		
	}
public boolean isOnOff(){
	System.out.println("isOnOff ȣ�⼺��");
	if(power)power=false;
	else power=true;
	return power;
}
public boolean isWifi(){
	if(wifi) wifi =false;
	else wifi =true;
	return wifi;
}
public String toString(){
	String name="���� ������ �Դϴ�";
			return name;
}

}
