package com.ch4;

public class While {

	public static void main(String[] args) {

		int i=2;
		
		while(i<10){//while(i++)�̷��� �ָ� �̹� ���ؼ� �������� 2�������� �� �ִ�.
		
			int j=1;//2���� ������ ���ƾ��ϱ⶧����
			while(j<10){
				
				System.out.println(i+"*"+j+"="+i*j);
				j++;
			}
			i++;
		}
		System.out.println("=====================");
		int j=2;
		while(j<10){
			i=2;//���� i�� �ܼ��̴�
			while(i<10){
				System.out.println(i+"*"+j+"="+i*j+" ");
				i++;
			}
			System.out.println();
			++j;
		}
		
	}

}