package com.ch5;

public class ArraryTest2 {
	int[] is =new int[5];
	//methodA()�� ������ �����ϴ�.
	void methodA(){
		
	}
	void methodB(){//�迭�� �ʱ�ȭ
		is[0]=3;
		is[1]=4;
		is[2]=5;
		is[3]=6;
		is[4]=7;
	}
	void methodBprint(){
		for(int x=0;x<is.length;x++){
			System.out.println("is["+x+"]"+is[x]);
}

}

	public static void main(String[] args) {
		
		ArraryTest2 at2=new ArraryTest2();
		at2.methodB();
		at2.methodBprint();
	}
}
