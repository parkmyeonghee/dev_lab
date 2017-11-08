package com.ch5;

import java.util.*;


public class Ya9 {
	//숫자 3개 랜덤생성
	int[][] nanSu(int[][] x)
	{
	      int quiz[][] = x;
	      
	      
	      Random r = new Random();
	      for(int i=1; i<3; i++)
	      {quiz[0][i] = r.nextInt(10);}
	      
	      for(;;)
		   {  if(quiz[0][0]==quiz[0][1])
		      		{
		      			quiz[0][1] = r.nextInt(10);
		      		}
		      else if(quiz[0][0]==quiz[0][2]||quiz[0][1]==quiz[0][2])
		      		{
	    				quiz[0][2] = r.nextInt(10);
		      		}
		      else{break;}
	      }
//	      for(int i=1; i<3; i++)
//	      {
//	    	quiz[i] = r.nextInt(9);
//	    		if(quiz[i-1]==quiz[i])
//	      		{
//	      			quiz[i] = r.nextInt(9);
//	      		}
//	    		else if(quiz[i-1])
//	    	
//	      }
	 x = quiz;
	 return x;	          	      
    }

	    
	//유저숫자 입력
	int[][] userInput(int[][] x){
		int[][] y = x;
		System.out.print(y[0][0]+" ");
		System.out.print(y[0][1]+" ");
		System.out.println(y[0][2]);
		for(int i=0; i<3; i++){
		  Scanner sc = new Scanner(System.in);
	      System.out.println("숫자를 입력하시오");
	      String num= sc.nextLine();
	      y[1][i] = Integer.parseInt(num);
	      }
// 입력값 확인
		
//		System.out.print(y[1][0]+" ");
//		System.out.print(y[1][1]+" ");
//		System.out.println(y[1][2]);
	      return y;
	   }
	//게임 진행
	void Ya9Run()
	{
		int ballCount=0;
		int stCount=0;
//난수받기				
		int[][] game = new int[3][3];
		
		//game=nanSu(game);
// 난수값 확인
		
		game=nanSu(game);
//사용자값 받기		
		for(;;)
		{
		game=userInput(game);
		
// 입력값 확인
		
		System.out.print(game[1][0]+" ");
		System.out.print(game[1][1]+" ");
		System.out.println(game[1][2]);
		
//		
//		if(game[0][0]==game[1][1]||game[0][0]==game[1][2])
//			{ballCount=ballCount+1;}
//		if(game[0][1]==game[1][0]||game[0][1]==game[1][2])
//			{ballCount=ballCount+1;}
//		if(game[0][2]==game[1][0]||game[0][2]==game[1][1])
//			{ballCount=ballCount+1;}
//		
//		for(int i=0; i<3; i++)
//		{
//			if(game[0][i]==game[1][i])
//			 {
//			  stCount=stCount+1;
//			  }
//		}
		
		
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<3; j++)
			 {
			   if(game[0][i]==game[1][j])
			   	{
				  ballCount=ballCount+1;
				  
				  if(game[0][i]==game[1][i])
					 {
					  stCount=stCount+1;
					  ballCount=ballCount-1;
					 }
				  
			   	}
			   				
			}
		 }
		
	   if(stCount==3)
		{System.out.println("아웃!!!!!");
		ballCount=0;
		stCount=0;
		return;}
	   else
	   {System.out.println(stCount+"스트라이크!!!"+ballCount+"볼!!!!! 아직 멀었네요");
	   ballCount=0;
		stCount=0;}
		}
	}
	
	public static void main(String[] args) {
		Ya9 ya = new Ya9();
		ya.Ya9Run();
		
			}

}
