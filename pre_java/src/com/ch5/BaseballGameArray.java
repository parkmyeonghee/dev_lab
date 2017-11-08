package com.ch5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BaseballGameArray implements ActionListener {

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
		JButton jbtns[]=new JButton[4];
		String btn_label[]={"새게임","정답","지우기","종료"};
	 Font f =new Font("HY견고딕",Font.BOLD,14); //폰트 이름 굵기 크기
	 int count=0;//전역변수
	 
	//화면처리하기
	public void initDisplay(){
		System.out.println("initDisplay 호출성공");
		//메뉴아이템,메뉴,메뉴바 추가하기
		jm_file.add(jmi_new);
		jm_file.add(jmi_dap);
		jm_file.add(jmi_exit);
		jmb.add(jm_file);
		jf_game.setJMenuBar(jmb);
		for(int i=0;i<jbtns.length;i++){
			jbtns[i]=new JButton(btn_label[i]);
			jbtns[i].setFont(f);//폰트지정하기 배열을 4개쓸 필요 없이 for문에 넣어주자
			jp_east.add(jbtns[i]);
		}
		//이벤트 소스와 이벤트 처리를 담당하는 핸들러 클래스의 연결
		jbtns[2].addActionListener(this);
		jtf_input.addActionListener(this);
		jbtns[3].addActionListener(this);
		jp_center.setLayout(new BorderLayout(0,20));
		jp_east.setLayout(new GridLayout(5,1,10,10));//원본을 참조해서 동일하게 적용이 된다.
		//jp_center.setBackground(Color.pink);
		//jp_east.setBackground(Color.red);
		//jp_center속지에 jta_display를 중앙에 배치하고
		//jp_center속지에 jtf-input을 배치하자
		jp_center.add("Center",jsp_display);
		jp_center.add("South",jtf_input);
		//jp_east속지에 버튼 4개 붙이기
		
		//버튼색깔 입히기
		jbtns[0].setBackground(new Color(144,225,225));//버튼색변경
		jbtns[0].setForeground(new Color(3,0,102));//글자색 변경
		jbtns[1].setBackground(new Color(255,167,167));
		jbtns[1].setForeground(new Color(3,0,102));
		jbtns[2].setBackground(new Color(219,165,229));
		jbtns[2].setForeground(new Color(3,0,102));
		jbtns[3].setBackground(new Color(88,229,92));
		jbtns[3].setForeground(new Color(3,0,102));
		
		
		
		jf_game.setBackground(new Color(140,140,140));
		//속지 두장을 JFrame에 붙이기
		//jp_east.setLayout(new GridLayout(4,1,2,2));
		jf_game.add("Center",jp_center);
		jf_game.add("East",jp_east);
		String title="야구 숫자 게임-배열";
		jf_game.setTitle(title);//변수를 선언해서 해준다.
		jf_game.setSize(500,550);//width,height
		jf_game.setVisible(true);
		
		
	}
	//볼 판정 하기
	//이벤트 처리하기
	//메인메소드
	public static void main(String[] args) {
		BaseballGameArray bGame= new BaseballGameArray();
		bGame.initDisplay();

	}
	//actionperformed메소드는 콜백 메소드
	@Override
	public void actionPerformed(ActionEvent ae) {
		//액션이벤트 뒤에 있는건 변수라서 바꿀 수 있다.
		//이벤트가 발생한 컴포넌트에 주소번지 가져오기- 어떤 버튼을 눌렀니?
		Object obj=ae.getSource();//지우기 버튼의 주소번지 가져오기
		//object는 모든 클래스의 아버지
		System.out.println(jbtns[2]+","+ae.getSource());
		//지우기 버튼을 클릭했을 때 호출
		if(obj==jbtns[2]){
			jta_display.setText("");
		}//사용자가 값을 입력하고 엔터 쳤을 때 호출
		else if(obj==jtf_input){
			String user=jtf_input.getText();//string 타입으로 되어 있다.
			jta_display.append(++count+"."+user+":"+"0스0볼"+"\n");
			jtf_input.setText("");//문자열을 다 쓰고 지워준다.
		}//종료 버튼을 클릭했을 때 호출
		else if(obj==jbtns[3]){
			System.exit(0);//자바가상머신과 연결고리가 끊어진다.
		}
	}


}
