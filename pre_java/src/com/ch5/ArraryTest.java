package com.ch5;

public class ArraryTest {
	//�����-�������� ����
	//���: ����ο��� ����� �ʱ�ȭ�� ������ �ڵ��� �� ����.
	//����� �ʱ�ȭ�� �ѹ��� �ؾ��Ѵ�.
	int i=10;
	int is[]=new int[5];
	double ds[]={1.5,1.3,1.8};
	/*
	 * int i;
	 * i=10;
	 * int is[]=null;
	 * is=new int[7]; ����
	 */
	int[] methodA(){//b�� �����ֱ� ���ؼ��� return�� ������
		int x;
		x=10;
		int is[]=null;
		is=new int[7];
		return is;
	}
	int[] methodB(int is[]){//���� �ޱ����ؼ��� parameter�� �޴´�
		//a�� ����� �迭 is�� �ʱ�ȭ �Ͻÿ�
		//�ʱⰪ�� �������
		is[0]=3;
		is[1]=4;
		is[2]=5;
		is[3]=6;
		is[4]=7;
		is[5]=8;
		is[6]=9;
		return is;
		
	}
void methodBprint(int is[]){
	for(int x=0;x<is.length;x++){
		System.out.println("is["+x+"]"+is[x]);
	}
}

	public static void main(String[] args) {
		//�������� i�� ����Ͻÿ�
		ArraryTest at =new ArraryTest();
		System.out.println(at.i);//10
		//����ο� �ִ� is�迭�� ������ ����Ͻÿ�.
		int is[]=at.methodA();
		is=at.methodB(is);
		at.methodBprint(is);
		System.out.println(at.is[0]);//0		
		System.out.println(at.is[1]);//0	
		System.out.println(at.is[2]);//0	
		System.out.println(at.is[3]);//0	
		System.out.println(at.is[4]);//�ݺ��Ǵ� �ڵ�� �ݺ����� �������.
		for(int x=0;x<at.is.length;x++){
			System.out.println(at.is[x]);//0~4
		}
		at.methodA();
	}

}
