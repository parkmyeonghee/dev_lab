package BaseBall;

import javax.swing.JOptionPane;

public class BaseBallGameLogic {
	 int com[]=new int[3];//컴터가 채번한 숫자 담기
	 int my[]=new int[3];//사용자가 입력한 값 담기
	 BaseBallGameView bgView =null;//멤버변수
	 public BaseBallGameLogic(BaseBallGameView bgView){
		//bgView(지역) 
		 this.bgView=bgView;
	 }
	public void nanSu(){
		com[0]=(int)(Math.random()*10);
		do{
			com[1]=(int)(Math.random()*10);
		}while(com[0]==com[1]);
		  do {
			  com[2]=(int)(Math.random()*10);
		}while(com[0]==com[2]||com[1]==com[2]);
	}
	 
	 //사용자가 입력한 숫자를 받아서 배열에 담기 구현

void userInput(String input){
	int temp=0;
	if(input.length()!=3){
		JOptionPane.showMessageDialog(bgView.jf_game,"세자리 숫자만 입력하세요"
				,"INFO",JOptionPane.INFORMATION_MESSAGE);
		return;//userinput메소드 탈출
	}
	temp=Integer.parseInt(input);
	my[0]=temp/100;
	my[1]=(temp%100)/10;
	my[2]=temp%10;
}

	String Ya9Run()
	{
		int ball=0;
		int strike=0;
		//볼판정 시작
		for(int i=0; i<com.length; i++)
		{
			for(int j=0; j<my.length; j++)
			 {
				//숫자가 존재하니? -ㅇㅇ:볼 확보
				if(com[i]==my[j]){
				//자리도 일치하니? -ㅇㅇ:스트라이크 확보
					if(i==j){
						strike++;
					}else
					{
						ball++;
					}
					 }
				  
			   	}//////out of end inner for
			   				
			}/////out of end outter for
	//////////////////////////////////판정끝///////////////////////
		  if(strike==3)
			{
			return "정답입니다";
			}
		   else
		   {return strike+"스"+ball+"볼 아직 멀었네요";
		   }
			}

}
