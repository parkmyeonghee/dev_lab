package com.ch4;

public class TestVer3 {

	public static void main(String[] args) {
		int i=0;
		int hap=0;
		for(i=1;i<=100;i++){
			
		 if(((i%5==0)&&(i%7==0))){ //(i%35==0)�̰͵� �����ϴ�.
				//fizz=fizz+i;
				//buzz=buzz+i;
				System.out.println("fizz"+"buzz");}//���� ���ؾ��� ���� ������ �߻�����
				else if(i%5==0)//fizz���
			{
				//fizz=fizz+i;
				System.out.println("fizz");
			}else if(i%7==0){//buzz���
				//buzz=buzz+i;
				System.out.println("buzz");
			}else //���ڸ� ����� �ּ���.
		 hap=hap+i;
			System.out.println(i);
			System.out.println("================");
			
			int j=0;
			int sum=0;
			boolean sw =false;//�������� �˷��ִ� ����.
			for(j=1;j<=100;j++){
				if(sw){
					System.out.println
					("¦���� ��� skip");
					sum=sum+j;
					System.out.println(j+","+sum);
					sw=false;
				}
				else{
					sw=true;
				}
			}
   
			}
				
}
}
