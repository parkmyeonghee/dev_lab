package com.ch5;
/*
 *���뼺�� �̽ļ��� ���̴� �ڵ��� �����Ѵ�.
 *���뼺�� ���̴� ù��° �ܰ谡 �޼ҵ� �߽��� �ڵ��� �����ϴ� ���̴�.
 *1)����Ÿ���� Ȱ���� �� �ִ�.
 *2)�Ķ���͸� �� Ȱ���� �� �ִ�.
 *�Ķ���Ϳ� ���ؼ�
 *1)passByValue���
 *2)callByValue���
 */
public class PassByValue {
	int a;//0
	int b;//0
	//���� a�� ����b�� ���������̴�.
	void methodA(int a,int b){//passByValue-���� ���� ȣ��-�����ȴ�.
		System.out.println(a+","+b);//10,20
		
		  this.a=a;
		  this.b=b;
		methodB(a,b);
	}
	int[]methodA2(int a,int b){//passbyvalue-���� ����ȣ��-�����ȴ�.
		int is[]=new int[2];
		is[0]=a;
		is[1]=b;
		return is;
	}
	void methodB(){
		System.out.println(a+","+b);
	}
	void methodB(int a,int b){
		System.out.println("methodB(int a,int b):"+a+","+b);
	}
	//methodA�� �Ķ������ ���� a���� ���� b�� ���� methodB������ ����ϰ�ʹ�.
	//1)�������� ����� ����?
	//2)�Ķ���͸� �̿��غ���?
	public static void main(String[] args) {
		PassByValue pv=new PassByValue();
		pv.methodA(10, 20);
		pv.methodB();
		int is[]=pv.methodA2(10, 20);
		for(int i=0;i<is.length;i++)
		{
			System.out.println("is["+i+"]="+is[i]);
		}
	}

}
