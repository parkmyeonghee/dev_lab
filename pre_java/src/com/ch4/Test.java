package com.ch4;
/*
 *1.������ �����ϰ� �ʱ�ȭ �� �� �ִ�.
 *2.������ �̿��Ͽ� ������ �� �ִ�.
 *3.�ʿ��� ������ ������ �� ���ϱ�?
 *4.3������ �ʿ��� ������ Ÿ���� ������ �� �ִ�.
 *5.���� �ۼ��� �ڵ�� �ո����ΰ�? 
 */
public class Test {
	
	static void methodA(){
		int i =1;//1���� 5������ ī��Ʈ���� ��������
		int hap=0;//1���� 5������ ���� ���� ����
		hap=hap+i;//1
		i=i+1;//hap=1,i=1
		hap=hap+i;//hap=3,i=2
		i=i+1;//hap=3,i=3
		hap=hap+i;//hap=6,i=3
		i=i+1;//hap=6,i=4
		hap=hap+i;//hap=10,i=4
		i=i+1;//hap=10,i=5
		hap=hap+i;//hap=15,i=5
		System.out.println("1����5���������� "+hap);
		
		
	}
	

	public static void main(String[] args) {
		
		int a=1;
		int b=2;
		int c=3;
		int d=4;
		int e=5;
		int hap=a+b+c+d+e;
		System.out.println(a+b+c+d+e);
		System.out.println("����:"+hap);
		methodA();
		//�ν��Ͻ�ȭ A a=new A(); �޸𸮿� �ش簴ü�� �÷��ִ°�
		
		
		
		
	}

}
