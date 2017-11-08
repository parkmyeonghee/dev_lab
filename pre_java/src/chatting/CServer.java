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
		jf_cs.setTitle("�α� ���â - ������");
		jf_cs.setSize(500,500);
		jf_cs.setVisible(true);
	}//initDisplay��

////////////////////////////run() - ������ ���, ���ϱ�
 public void run(){
	 chatList = new Vector<CS_DBThread>();
		boolean isStop = false;
		try{
			serversoc = new ServerSocket(3002);//��Ʈ��ȣ - run()�� �̵�. exception �������� �ʰ� �Ϸ���.
			while(!isStop){
				communsoc = serversoc.accept(); //���������� ��ż��Ͽ� ���� �ѱ�� �޼ҵ�
				jta_display.append(communsoc.toString()+"\n");

				//cst������ ȣ��.
				CS_DBThread cst = new CS_DBThread(this);
				cst.start();
				System.out.println("�������� ������ start");
			}
		}catch(IOException e){
			e.printStackTrace();
		}
 }
	
///////////////////���θ޼ҵ�
	public static void main(String[] args) {
		CServer cs = new CServer();
		cs.initDisplay();
		new Thread(cs).start();
	}
}
