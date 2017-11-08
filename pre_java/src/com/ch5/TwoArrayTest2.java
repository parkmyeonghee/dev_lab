package com.ch5;

public class TwoArrayTest2 {

	public static void main(String[] args) {
		int is[][]= new int[4][3];
		is[0]=new int[3];
		is[1]=new int[3];
		is[2]=new int[3];
		is[3]=new int[3];
		System.out.println("is.length:"+is.length);
		System.out.println("is[0].length:"+is[0].length);
		System.out.println("is[1].length:"+is[1].length);
		System.out.println("is[2].length:"+is[2].length);
		System.out.println("is[3].length:"+is[3].length);
		System.out.println("=============================");
		int is2[][]=new int[4][3];
		is2[0]=new int[]{1,2,3};
		is2[1]=new int[]{11,22,32};
		is2[2]=new int[]{111,222,333};
		is2[3]=new int[]{1111,2222,3333};
		for(int i=0;i<is2.length;i++){
			for(int j=0;j<is2[i].length;j++){
			
			System.out.println("is2["+i+"]["+j+"]="+is2[i][j]);
		}
	}

}
}
