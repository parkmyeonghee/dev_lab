package com.ch5;

public class Ya9Simulation {
	public static void main(String[] args) {
		Ya9 y = new Ya9();
		int p[][]=new int[2][3];//2�� �迭�̶� �ν��Ͻ�ȭ�� ��
		int count =0;
		int usr[][]=y.userInput(p);//�޾� �� ���� ��´�?
		for(int i=0;i<usr[0].length;i++){
			System.out.println(usr[1][i]);
		}
/*******************************************************************
 * ���ڸ� ���� ä���ϱ� ���� �׽�Ʈ �غ���
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
