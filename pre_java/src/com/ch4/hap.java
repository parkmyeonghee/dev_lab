package com.ch4;



public class hap {
	public static void main(String[] args) {
		int i;
		int hap=0;
		for(i=1;i<=100;i++){
			hap+=i;//if�� �տ� ���� �� 50���� ������ ������ �� �ִ�.
			if(i==50){
				//break���� ������ �Ǹ� �ݺ����� Ż��.
				 break;//15������ ����ȴ�.
				}//if����
			//hap=hap+i;50�� ��� ������ �ȵȴ�.
			System.out.println("break���� �����ԵǸ� ������� �ʽ��ϴ�.");
		}//for����
  
		System.out.println("�극��ũ¹��"+hap);
	
	}
	
	
	
}


