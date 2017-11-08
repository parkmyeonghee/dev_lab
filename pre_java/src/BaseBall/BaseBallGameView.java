package BaseBall;

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

import com.ch5.BaseBallGame;

public class BaseBallGameView {
	//객체에 주입관계 해결하기
	BaseBallGameLogic bgLogic = new BaseBallGameLogic(this);
	BaseBallGameEvent bgEvent = new BaseBallGameEvent(this,bgLogic);
	
	JMenuBar jmb=new JMenuBar();
	JMenu jm_file=new JMenu("파일");
	JMenuItem jmi_new=new JMenuItem ("새게임");
	JMenuItem jmi_clear=new JMenuItem ("지우기");
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
	 public BaseBallGameView(){
		 bgLogic.nanSu();
	 }
	
	
	

		public void initDisplay(){
			System.out.println("initDisplay 호출성공");
			//메뉴아이템,메뉴,메뉴바 추가하기
			jmi_new.addActionListener(bgEvent);
			jmi_dap.addActionListener(bgEvent);
			jmi_clear.addActionListener(bgEvent);
			jmi_exit.addActionListener(bgEvent);
			jm_file.add(jmi_new);
			jm_file.add(jmi_dap);
			jm_file.add(jmi_clear);
			jm_file.add(jmi_exit);
			jmb.add(jm_file);
			jf_game.setJMenuBar(jmb);
			//이벤트 소스와 이벤트 처리를 담당하는 핸들러 클래스의 연결
			jbt_clear.addActionListener(bgEvent);//this=>baseballgame=>actionperformed메소드가 내안에 있을때
			jbt_new.addActionListener(bgEvent);
			jbt_dap.addActionListener(bgEvent);
			jtf_input.addActionListener(bgEvent);
			jbt_exit.addActionListener(bgEvent);
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

	public static void main(String[] args) {
		BaseBallGameView bgView= new BaseBallGameView();
		bgView.initDisplay();
	}

}
