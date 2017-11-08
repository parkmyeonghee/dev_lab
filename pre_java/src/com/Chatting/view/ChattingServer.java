package com.Chatting.view;

import java.awt.Panel;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ChattingServer extends JFrame{
		//선언부
		//클라이언트 소켓의 접속을 받아주는 소켓 선언하기
		ServerSocket server = null;
		//실제 메세지를 주고 받을 때 사용할 소켓
		Socket client = null;
		//서버소켓에 접속해 오는 클라이언트 즉 사용자들에 대한 정보를 담아둘 자료구조 선언
		//Vector 사용
		List<ChattingServerThread> chatList = null;
		ChattingServerThread csThread = null;
		JTextArea jta_display = new JTextArea();
		JScrollPane jsp_display = new JScrollPane(jta_display
				,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
				,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		//생성자
		//1)화면처리
		//2)서버소켓 생성
		//3)클라이언트 소켓정보를 받아온다
		//4)스레드 생성하고 start() 호출
		public ChattingServer(){
			initDisplay();
			chatList = new Vector<ChattingServerThread>();
			boolean isStop = false;
			try {
				server = new ServerSocket(3000);
				while(!isStop){
					client = server.accept();
					jta_display.append(client.toString()+"\n");
					csThread= new ChattingServerThread(this);
					csThread.start();
				}
			} catch (Exception e) {
			
			}
		}
		//화면처리부
		public void initDisplay(){
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setTitle("로그 출력창 - 서버측");
			this.setSize(500,500);
			this.add("Center",jsp_display);
			setVisible(true);
		}
	
	/*
	//선언부
	JFrame jf_ch_server = new JFrame();
	JPanel jp_first = new JPanel();
	JPanel jp_second = new JPanel();
	
	JTextArea jta_display = new JTextArea();
	JTextField jtf_msg = new JTextField();
	
	JTable jt_room;
	
	
	//화면 처리부
	public void Initdisplay(){
		
		
	jf_ch_server.setSize(300, 300);
	jf_ch_server.setVisible(true);
		
	}
*/
	public static void main(String[] args) {
		ChattingServer cs = new ChattingServer();
		cs.initDisplay();
	}

}
