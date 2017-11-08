package com.ch4;



public class hap {
	public static void main(String[] args) {
		int i;
		int hap=0;
		for(i=1;i<=100;i++){
			hap+=i;//if문 앞에 있을 때 50까지 연산을 수행할 수 있다.
			if(i==50){
				//break문을 만나게 되면 반복문을 탈출.
				 break;//15라인이 실행된다.
				}//if문끗
			//hap=hap+i;50인 경우 연산이 안된다.
			System.out.println("break문을 만나게되면 출력하지 않습니다.");
		}//for문끗
  
		System.out.println("브레이크쨔응"+hap);
	
	}
	
	
	
}


