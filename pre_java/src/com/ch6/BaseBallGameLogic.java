package com.ch6;

import javax.swing.JOptionPane;

public class BaseBallGameLogic {
	int com[] = new int[3];//컴터가 채번한 숫자 담기
	int my[] = new int[3];//사용자가 입력한 값 담기
	BaseBallGameView bgView = null;//멤버
	public BaseBallGameLogic(BaseBallGameView bgView){
	//bgView(지역) - 	
		this.bgView = bgView;
	}
	/*********************************************************************************/
	//세자리 숫자 체번하는 메소드 구현
	/**********************************************************************************/
	//숫자 3개 랜덤생성
	public void nanSu()
	{
		com[0] = (int)(Math.random()*10);
		do{
			com[1] = (int)(Math.random()*10);
		}while(com[0]==com[1]);
		do{
			com[2] = (int)(Math.random()*10);
		}while(com[0]==com[2] || com[1]==com[2]);
	}///////////////////// end of nanSu /////////////////////
	//사용자가 입력한 숫자를 받아서 배열에 담기 구현
	/*********************************************************************************/
	//유저숫자 입력
	void userInput(String input){
		if(input.length()!=3){
			JOptionPane.showMessageDialog(bgView.jf_game, "세자리 숫자만 입력하세요."
					                    , "INFO", JOptionPane.INFORMATION_MESSAGE);
			return;//userInput메소드 탈출
		}		
		int temp = 0;
		temp = Integer.parseInt(input);
		my[0] = temp/100;//1
		my[1] = (temp%100)/10;//2
		my[2] = temp%10;//3		
	}//////////////// end of userInput /////////////////	
	//볼 판정 하기
	String Ya9Run()
	{
		int ball=0;
		int strike=0;	
		//////////// 볼 판정 시작 ////////////////
		for(int i=0; i<com.length; i++)
		{
			for(int j=0; j<my.length; j++)
			{
				//숫자가 존재하니? - true:볼 확보
				if(com[i]==my[j]){
				//자리도 일치하니? - true:스트라이크 확보
					if(i==j){
						strike++;
					}
					else{
						ball++;
					}
				}
			}///////////out of end inner for
		}///////////////out of end outter for
		//////////// 볼 판정 끝 /////////////////
	   if(strike==3)
	   {
		   return "정답입니다.";
	   }
	   return strike+"스"+ball+"볼 아직 멀었네요";
	}/////////////// end of ya9Run /////////////////	
}
