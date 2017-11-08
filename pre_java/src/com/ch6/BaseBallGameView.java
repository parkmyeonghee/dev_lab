package com.ch6;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BaseBallGameView {
	//객체에 주입관계 해결하기
	BaseBallGameLogic bgLogic = new BaseBallGameLogic(this);
	BaseBallGameEvent bgEvent = new BaseBallGameEvent(this, bgLogic);
	//메뉴바 추가하기
	JMenuBar 	jmb 	= new JMenuBar();
	JMenu 		jm_file = new JMenu("파일");
	JMenuItem	jmi_new = new JMenuItem("새게임");
	JMenuItem	jmi_dap = new JMenuItem("정답");
	JMenuItem	jmi_exit = new JMenuItem("종료");
	//JFrame은 자바에서 제공하는 클래스 입니다.
//	javax.swing.JFrame jf_game = new javax.swing.JFrame();
	JFrame jf_game = new JFrame();
	//JFrame에 붙일 속지 두 개 선언하고 생성하기
	JPanel jp_center = new JPanel();
	//배치-jp_center속지에 중앙에 배치하자
	JTextArea jta_display = new JTextArea();
	//JTextArea에 스크롤 바 추가하기
	JScrollPane jsp_display = new JScrollPane(jta_display);
	//배치-jp_center속지에 남쪽에 배치하자
	JTextField jtf_input = new JTextField();
	JPanel jp_east = new JPanel();
	//새게임버튼, 정답버튼, 지우기버튼, 종료버튼-> jp_east속지에 배치해 보자.
	JButton jbt_new = new JButton("새게임");
	JButton jbt_dap = new JButton("정답");
	JButton jbt_clear = new JButton("지우기");
	JButton jbt_exit = new JButton("종료");
	Font f = new Font("Thoma",Font.BOLD,14);	
	//화면처리 하기
	public void initDisplay(){
		java.lang.System.out.println("initDisplay 호출 성공");
		//메뉴아이템, 메뉴, 메뉴바 추가하기
		jm_file.add(jmi_new);
		jm_file.add(jmi_dap);
		jm_file.add(jmi_exit);
		jmb.add(jm_file);
		jf_game.setJMenuBar(jmb);
		//이벤트 소스와 이벤트 처리를 담당하는 핸들러 클래스의 연결
		jbt_new.addActionListener(bgEvent);
		jbt_dap.addActionListener(bgEvent);
		jbt_clear.addActionListener(bgEvent);//bgEvent=>BaseBallGame=>actionPerformed메소드가 내안에 있을 때
		jtf_input.addActionListener(bgEvent);
		jbt_exit.addActionListener(bgEvent);
		jp_center.setLayout(new BorderLayout(0,20));
		jp_east.setLayout(new GridLayout(4,1,2,2));
		//jp_center.setBackground(Color.BLUE);
		//jp_east.setBackground(Color.GREEN);
		//jp_center속지에 jta_display를 중앙에 배치하고
		//jp_center속지에 jtf_input을 배치하자.
		jp_center.add("Center",jsp_display);
		jp_center.add("South",jtf_input);
		//버튼에 폰트 지정하기
		jbt_new.setFont(f);
		jbt_dap.setFont(f);
		jbt_clear.setFont(f);
		jbt_exit.setFont(f);
		//버튼에 색깔 입히기
		jbt_new.setBackground(new Color(158,9,9));
		jbt_new.setForeground(new Color(212,212,212));
		jbt_dap.setBackground(new Color(19,99,57));
		jbt_dap.setForeground(new Color(212,212,212));
		jbt_clear.setBackground(new Color(7,84,170));
		jbt_clear.setForeground(new Color(212,212,212));
		jbt_exit.setBackground(new Color(54,54,54));
		jbt_exit.setForeground(new Color(212,212,212));
		//jp_east속지에 버튼 4개 붙이기
		jp_east.add(jbt_new);
		jp_east.add(jbt_dap);
		jp_east.add(jbt_clear);
		jp_east.add(jbt_exit);
		jf_game.setBackground(new Color(214,211,206));
		//속지 두 장을 JFrame에 붙이기
		jf_game.add("Center",jp_center);
		jf_game.add("East",jp_east);
		String title = "야구숫자게임";
		jf_game.setTitle(title);
		jf_game.setSize(300,350);
		jf_game.setVisible(true);
	}///////////// end of initDisplay() ///////////////
	public static void main(String[] args) {
		BaseBallGameView bgView = new BaseBallGameView();
		bgView.initDisplay();
	}

}
