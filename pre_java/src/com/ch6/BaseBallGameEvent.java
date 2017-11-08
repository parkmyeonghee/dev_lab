package com.ch6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BaseBallGameEvent implements ActionListener{
	//선언부
	int cnt = 0;//전역변수
	BaseBallGameView bgView = null;
	BaseBallGameLogic bgLogic = null;
	public BaseBallGameEvent(BaseBallGameView bgView) {
		this.bgView = bgView;
	}
	public BaseBallGameEvent(BaseBallGameView bgView
			               , BaseBallGameLogic bgLogic) {
		this.bgView = bgView;
		this.bgLogic = bgLogic;
	}	
	@Override
	public void actionPerformed(ActionEvent ae) {
		//이벤트가 발생한 컴포넌트에 주소번지 가져오기 - 어떤 버튼을 눌렀니?
		Object obj = ae.getSource();//지우기버튼의 주소번지 가져오기
		//System.out.println(jbt_clear+" , "+ae.getSource());
		//지우기 버튼을 클릭했을 때 호출
		if(obj==bgView.jbt_clear){
			bgView.jta_display.setText("");
		}
		//새게임버튼을 클릭했니?
		else if(obj == bgView.jbt_new){
			cnt = 0;
			bgLogic.nanSu();
			bgView.jta_display.setText("");
			bgView.jtf_input.setText("");
			bgView.jtf_input.requestFocus();
		}
		//정답버튼을 클릭했니?
		//이벤트소스의 주소번지와 정답버튼의 주소번지가 같니?
		else if(obj==bgView.jbt_dap){
			System.out.println("==========정답버튼 클릭 테스트==========");
			bgView.jta_display.append("정답은 "+bgLogic.com[0]
					                    +bgLogic.com[1]
					                    +bgLogic.com[2]+"\n");
		}
		//사용자가 값을 입력하고 엔터 쳤을 때 호출
		else if(obj==bgView.jtf_input){
			String user = bgView.jtf_input.getText();//사용자가 입력한 세자리 숫자 저장된다.
			bgLogic.userInput(user);	
			bgView.jta_display.append(++cnt+"."+user+" : "+bgLogic.Ya9Run()+"\n");
			bgView.jtf_input.setText("");
		}
		//종료 버튼을 클릭했을 때 호출
		else if(obj==bgView.jbt_exit){
			System.exit(0);//자바가상머신과 연결고리가 끊긴다.
		}
	}///////////////////// end of actionPerformed ///////////////////////
}
