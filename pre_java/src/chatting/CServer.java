package ChattingProject;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CServer extends Thread {
 	
	ServerSocket serversoc = null;
	Socket communsoc = null;
//	List<ChattingServerThread> chatList = null;
	JFrame jf_cs = new JFrame();
	JTextArea jta_display = new JTextArea();
	List<CS_DBThread> chatList = null;
	CS_DBThread cst = null;
	JScrollPane jsp_display = new JScrollPane(jta_display
								, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
								, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

////////////////////////////initDisplay()	
public void initDisplay(){
		
		jf_cs.add("Center", jsp_display);
		jf_cs.setTitle("로그 출력창 - 서버측");
		jf_cs.setSize(500,500);
		jf_cs.setVisible(true);
	}//initDisplay끝

////////////////////////////run() - 서버의 듣기, 말하기
 public void run(){
	 chatList = new Vector<CS_DBThread>();
		boolean isStop = false;
		try{
			serversoc = new ServerSocket(3002);//포트번호 - run()로 이동. exception 떨어지지 않게 하려고.
			while(!isStop){
				communsoc = serversoc.accept(); //서버소켓이 통신소켓에 정보 넘기는 메소드
				jta_display.append(communsoc.toString()+"\n");

				//cst생성자 호출.
				CS_DBThread cst = new CS_DBThread(this);
				cst.start();
				System.out.println("서버에서 쓰레드 start");
			}
		}catch(IOException e){
			e.printStackTrace();
		}
 }
	
///////////////////메인메소드
	public static void main(String[] args) {
		CServer cs = new CServer();
		cs.initDisplay();
		new Thread(cs).start();
	}
}
