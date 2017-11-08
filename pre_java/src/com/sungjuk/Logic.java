package com.sungjuk;

public class Logic {
	int inwonn;
	String contents[][]= new String[inwonn][8];
	View sView =null;
	public Logic(View sView){
		this.sView=sView;
	}
	public void doProcess(){
		int i =0;
		int rank[] = new int[sView.inwonn];
		int tot [] = new int [sView.inwonn];	
		
	for(i=0;i<sView.inwonn;i++){
		//총점
		sView.contents[i][4]=String.valueOf(Integer.parseInt(sView.db_contents[i][1]) 
				+Integer.parseInt(sView.db_contents[i][2])
				+Integer.parseInt(sView.db_contents[i][3]));
		//평균
		sView.contents[i][5]=String.valueOf(
						Integer.parseInt(sView.contents[i][4])/3);	
		//학점
		if(Integer.parseInt(sView.contents[i][4])/3 >=90){
			sView.contents[i][6] = "A";
		}else if(Integer.parseInt(sView.contents[i][4])/3 >=80 &
				 Integer.parseInt(sView.contents[i][4])/3< 90){
			sView.contents[i][6] = "B";
		}else if(Integer.parseInt(sView.contents[i][4])/3 >=70 &
				 Integer.parseInt(sView.contents[i][4])/3< 80){
			sView.contents[i][6] = "C";
		}else if(Integer.parseInt(sView.contents[i][4])/3 >=60 &
				 Integer.parseInt(sView.contents[i][4])/3 < 70){
			sView.contents[i][6] = "D";
		}else{
			sView.contents[i][6] = "F";
		}
		
		sView.jt_sungjuk.setValueAt(sView.contents[i][4],i,4);
		 sView.jt_sungjuk.setValueAt(sView.contents[i][5],i,5);
		sView.jt_sungjuk.setValueAt(sView.contents[i][6],i,6);
	}//총점, 평균, 학점 포문 끝 

	//석차
	 for(i=0;i<sView.inwonn;i++){   
	   rank[i] = 1;// 일단 모든 랭크 값을 1로 초기화  
	   tot[i] = Integer.parseInt(sView.contents[i][4]);
	 }
	 for(i=0;i<sView.inwonn;i++){
	   for (int j = 0; j < sView.inwonn; j++) {
	    	 if(tot[i]<tot[j]) {
	            	rank[i]++;    
	            }
	   } 
	 
	   sView.contents[i][7] = String.valueOf(rank[i]); 
	 
	 sView.jt_sungjuk.setValueAt(sView.contents[i][7],i,7);
	} //석차 for문 끝
	}//doProcess 메소드 끝

}
