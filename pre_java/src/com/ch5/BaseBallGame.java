package com.ch5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BaseBallGame implements ActionListener{
	//선언부
	//메뉴추가하기
	JMenuBar jmb=new JMenuBar();
	JMenu jm_file=new JMenu("파일");
	JMenuItem jmi_new=new JMenuItem ("새게임");
	JMenuItem jmi_dap=new JMenuItem ("정답");
	JMenuItem jmi_exit=new JMenuItem ("종료");
	//Jframe은 자바에서 제공하는 클래스 입니다.
	 JFrame jf_game=new JFrame();
	//javax.swing.Jframe jf_game=new javax.swing.Jframe();
	 JPanel jp_center = new JPanel();
	 //배치-jp_center 속지에 중앙에 배치
	 JTextArea jta_display=new JTextArea();
	 //jtextarea에 스크롤 바 추가하기
	 JScrollPane jsp_display = new JScrollPane(jta_display);
	 //배치-jp_center속지에 남쪽에 배치
	 JTextField jtf_input=new JTextField();
	 JPanel jp_east = new JPanel();
	 //새게임버튼,정답버튼,지우기버튼,종료버튼 ->jp_east속지에 배치해 보자.
	 JButton jbt_new=new JButton("새게임");
	 JButton jbt_dap=new JButton("정답");
	 JButton jbt_clear=new JButton("지우기");
	 JButton jbt_exit=new JButton("종료");
	 Font f =new Font("HY견고딕",Font.BOLD,14); //폰트 이름 굵기 크기
	 int cnt=0;//전역변수
	 int com[]=new int[3];//컴터가 채번한 숫자 담기
	 int my[]=new int[3];//사용자가 입력한 값 담기
	 public BaseBallGame(){
		 nanSu();
	 }
	 
	 //사용자가 입력한 숫자를 받아서 배열에 담기 구현

void userInput(String input){
	int temp=0;
	if(input.length()!=3){
		JOptionPane.showMessageDialog(jf_game,"세자리 숫자만 입력하세요"
				,"INFO",JOptionPane.INFORMATION_MESSAGE);
		return;//userinput메소드 탈출
	}
	temp=Integer.parseInt(input);
	my[0]=temp/100;
	my[1]=(temp%100)/10;
	my[2]=temp%10;
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
	//화면처리하기
	public void initDisplay(){
		System.out.println("initDisplay 호출성공");
		//메뉴아이템,메뉴,메뉴바 추가하기
		jm_file.add(jmi_new);
		jm_file.add(jmi_dap);
		jm_file.add(jmi_exit);
		jmb.add(jm_file);
		jf_game.setJMenuBar(jmb);
		//이벤트 소스와 이벤트 처리를 담당하는 핸들러 클래스의 연결
		jbt_clear.addActionListener(this);//this=>baseballgame=>actionperformed메소드가 내안에 있을때
		jbt_new.addActionListener(this);
		jbt_dap.addActionListener(this);
		jtf_input.addActionListener(this);
		jbt_exit.addActionListener(this);
		jp_center.setLayout(new BorderLayout(0,20));
		jp_east.setLayout(new GridLayout(5,1,10,10));
		//jp_center.setBackground(Color.pink);
		//jp_east.setBackground(Color.red);
		//jp_center속지에 jta_display를 중앙에 배치하고
		//jp_center속지에 jtf-input을 배치하자
		jp_center.add("Center",jsp_display);
		jp_center.add("South",jtf_input);
		//jp_east속지에 버튼 4개 붙이기
		//버튼에 폰트 지정하기
		jbt_new.setFont(f);
		jbt_dap.setFont(f);
		jbt_clear.setFont(f);
		jbt_exit.setFont(f);
		//버튼색깔 입히기
		jbt_new.setBackground(new Color(144,225,225));//버튼색변경
		jbt_new.setForeground(new Color(3,0,102));//글자색 변경
		jbt_dap.setBackground(new Color(255,167,167));
		jbt_dap.setForeground(new Color(3,0,102));
		jbt_clear.setBackground(new Color(219,165,229));
		jbt_clear.setForeground(new Color(3,0,102));
		jbt_exit.setBackground(new Color(88,229,92));
		jbt_exit.setForeground(new Color(3,0,102));
		
		
		jp_east.add(jbt_new);
		jp_east.add(jbt_dap);
		jp_east.add(jbt_clear);
		jp_east.add(jbt_exit);
		jf_game.setBackground(new Color(140,140,140));
		//속지 두장을 JFrame에 붙이기
		//jp_east.setLayout(new GridLayout(4,1,2,2));
		jf_game.add("Center",jp_center);
		jf_game.add("East",jp_east);
		String title="야구 숫자 게임";
		jf_game.setTitle(title);//변수를 선언해서 해준다.
		jf_game.setSize(500,550);//width,height
		jf_game.setVisible(true);
		
		
	}
	//볼 판정 하기
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

	//이벤트 처리하기
	//메인메소드
	public static void main(String[] args) {
		BaseBallGame bGame= new BaseBallGame();
		bGame.initDisplay();

	}
	//actionperformed메소드는 콜백 메소드
	@Override
	public void actionPerformed(ActionEvent ae) {
		//액션이벤트 뒤에 있는건 변수라서 바꿀 수 있다.
		//이벤트가 발생한 컴포넌트에 주소번지 가져오기- 어떤 버튼을 눌렀니?
		Object obj=ae.getSource();//지우기 버튼의 주소번지 가져오기
		//object는 모든 클래스의 아버지
		System.out.println(jbt_clear+","+ae.getSource());
		//지우기 버튼을 클릭했을 때 호출
		if(obj==jbt_clear){
			jta_display.setText("");
		}
		//새게임버튼을 클릭했니?
		else if(obj==jbt_new){
			cnt=0;
			nanSu();
			jta_display.setText("");
			jtf_input.setText("");
			jtf_input.requestFocus();
			
		}
		//이벤트소스의 주소번지와 정답버튼의 주소번지가 같니?
		else if(obj==jbt_dap){
			System.out.println("======정답버튼 클릭=======");
			jta_display.append("정답:"+com[0]
									 +com[1]
									 +com[2]+"\n");			
		}//사용자가 값을 입력하고 엔터 쳤을 때 호출
		else if(obj==jtf_input){
			String user=jtf_input.getText();//사용자가 입력한 세자리 숫자 저장
			userInput(user);
			jta_display.append(++cnt+"."+user+":"+Ya9Run()+"\n");
			jtf_input.setText("");
				}
		

	/*	else if(obj==jtf_input){
			String user=jtf_input.getText();//string 타입으로 되어 있다.
			jta_display.append(++count+"."+user+":"+"0스0볼"+"\n");
			jtf_input.setText("");//문자열을 다 쓰고 지워준다.
		}//종료 버튼을 클릭했을 때 호출*/

		else if(obj==jbt_exit){
			System.exit(0);//자바가상머신과 연결고리가 끊어진다.
		}
	}
	
}

