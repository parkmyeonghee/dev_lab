package com.ch5;

public class Ya9Simulation {
	public static void main(String[] args) {
		Ya9 y = new Ya9();
		int p[][]=new int[2][3];//2차 배열이라서 인스턴스화를 함
		int count =0;
		int usr[][]=y.userInput(p);//받아 온 값을 담는다?
		for(int i=0;i<usr[0].length;i++){
			System.out.println(usr[1][i]);
		}
/*******************************************************************
 * 세자리 숫자 채번하기 단위 테스트 해보기
		for(;;){
		int nanSu[][]=y.nanSu(p);
		for(int i=0;i<nanSu.length;i++){
			for(int j=0;j<nanSu[i].length;j++){
				System.out.println("nanSu["+i+"]["+j+"]");
			}
		}
		
		
	if(count==9) break;
	count++;
	
		
			}
*********************************************************************/

}
}
