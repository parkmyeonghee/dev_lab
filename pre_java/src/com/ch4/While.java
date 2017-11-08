package com.ch4;

public class While {

	public static void main(String[] args) {

		int i=2;
		
		while(i<10){//while(i++)이렇게 주면 이미 더해서 내려가서 2부터찍을 수 있다.
		
			int j=1;//2단이 끝나고 돌아야하기때문에
			while(j<10){
				
				System.out.println(i+"*"+j+"="+i*j);
				j++;
			}
			i++;
		}
		System.out.println("=====================");
		int j=2;
		while(j<10){
			i=2;//변수 i는 단수이다
			while(i<10){
				System.out.println(i+"*"+j+"="+i*j+" ");
				i++;
			}
			System.out.println();
			++j;
		}
		
	}

}