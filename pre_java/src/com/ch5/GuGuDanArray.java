package com.ch5;

public class GuGuDanArray {
	int dans[][]=new int[8][9];//72개의 방이 생김
	void methodA(int row,int cols,int val){
		dans[row][cols]=val;
	}
	void dansPrint()
	{
		for(int row=0;row<dans.length;row++){
			for(int cols=0;cols<dans[row].length;cols++){
				System.out.println("dans["+row+"]["+cols+"]="+dans[row][cols]);
			}
		}
	}
	//18-19-20-21-22-23-25(72번 호출 일어남)-5-6-7-26-27-28
	//
	public static void main(String[] args) {
		GuGuDanArray gg =new GuGuDanArray();
		int row=0;
		int cols=0;
		for(int i=2;i<10;i++,row++){
			cols=0;
			for(int j=1;j<10;j++,cols++){
				System.out.println(i+"*"+j+"="+(i*j));
				gg.methodA(row,cols,(i*j));
			}
		}
		gg.dansPrint();
	}

}
