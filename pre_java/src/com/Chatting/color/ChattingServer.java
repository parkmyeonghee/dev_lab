package com.Chatting.color;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ChattingServer extends JFrame implements Runnable {
	//선언부
	//클라이언트 소켓의 접속을 받아주는
	//소켓 선언하기
	ServerSocket server = null;
	//실제 메시지를 주고 받을 때 사용할 소켓
	Socket Client =null;
	//서버소켓에 접속해 오는 클라이언트 즉
	//사용자들에 대한 정보를 담아 둘 자료구조
	//Vector 사용
	List<ChattingServerThread> chatList=null;
	ChattingServerThread csThread =null;
	JTextArea jta_display= new JTextArea();
	JScrollPane jsp_display=
			new JScrollPane(jta_display
					,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
					,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	//생성자
	//1)화면처리
	//2)서버소켓생성
	//3)클라이언트 소켓정보를 받아온다.
	//2)스레드 생성하고 start() 호출
	public ChattingServer(){
		initDisplay();
	}
	//화면 처리부
	public void initDisplay(){
		this.add("Center",jsp_display);
		this.setTitle("로그 출력창-서버측");
		this.setSize(500, 500);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		ChattingServer cs=
				new ChattingServer();
		new Thread(cs).start();
	}
	@Override
	public void run(){
	chatList=
			new Vector<ChattingServerThread>();
	boolean isStop= false;
	try {
		server = new ServerSocket(3000);
		while(!isStop){
			Client=server.accept();
			jta_display.append(Client.toString()+"\n");
			csThread=
					new ChattingServerThread(this);
			csThread.start();
		}
	} catch (Exception e) {
	}
}
}
