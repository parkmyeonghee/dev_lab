package com.ch4;

public class TestVer3 {

	public static void main(String[] args) {
		int i=0;
		int hap=0;
		for(i=1;i<=100;i++){
			
		 if(((i%5==0)&&(i%7==0))){ //(i%35==0)이것도 가능하다.
				//fizz=fizz+i;
				//buzz=buzz+i;
				System.out.println("fizz"+"buzz");}//먼저 비교해야지 논리의 오류가 발생안함
				else if(i%5==0)//fizz출력
			{
				//fizz=fizz+i;
				System.out.println("fizz");
			}else if(i%7==0){//buzz출력
				//buzz=buzz+i;
				System.out.println("buzz");
			}else //숫자를 출력해 주세요.
		 hap=hap+i;
			System.out.println(i);
			System.out.println("================");
			
			int j=0;
			int sum=0;
			boolean sw =false;//참거짓을 알려주는 아이.
			for(j=1;j<=100;j++){
				if(sw){
					System.out.println
					("짝수일 경우 skip");
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
