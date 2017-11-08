package com.ch6;

public class TwoArrayTest {
	int [][] test(int pArr[][]){
		//int oArr[][]=null;//아직 주소번지가 없당.
		//int oArr[][]=pArr;
		int oArr[][]=null;
		pArr[0][0]=1;
		pArr[0][1]=2;
		pArr[0][2]=3;
		//return oArr;
		return pArr;
	}

	public static void main(String[] args) {
		int pArr[][]= new int[2][3];
		TwoArrayTest tat=new TwoArrayTest();
		int oArr[][]= tat.test(pArr);
		System.out.println("====================[oArr]================");
		for(int i=0;i<oArr.length;i++){
			for(int j=0;j<oArr[i].length;j++){
				System.out.println("oArr["+i+"]["+j+"]="+oArr[i][j]);
			}
		}
		System.out.println("===============[oArr end]==============");
		System.out.println("===============[pArr start]==============");
		for(int i=0;i<pArr.length;i++){
			for(int j=0;j<pArr[i].length;j++){
				System.out.println("pArr["+i+"]["+j+"]="+pArr[i][j]);

	}

}
	}
}
