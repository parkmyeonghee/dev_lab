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
		//�����
		//Ŭ���̾�Ʈ ������ ������ �޾��ִ� ���� �����ϱ�
		ServerSocket server = null;
		//���� �޼����� �ְ� ���� �� ����� ����
		Socket client = null;
		//�������Ͽ� ������ ���� Ŭ���̾�Ʈ �� ����ڵ鿡 ���� ������ ��Ƶ� �ڷᱸ�� ����
		//Vector ���
		List<ChattingServerThread> chatList = null;
		ChattingServerThread csThread = null;
		JTextArea jta_display = new JTextArea();
		JScrollPane jsp_display = new JScrollPane(jta_display
				,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
				,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		//������
		//1)ȭ��ó��
		//2)�������� ����
		//3)Ŭ���̾�Ʈ ���������� �޾ƿ´�
		//4)������ �����ϰ� start() ȣ��
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
		//ȭ��ó����
		public void initDisplay(){
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setTitle("�α� ���â - ������");
			this.setSize(500,500);
			this.add("Center",jsp_display);
			setVisible(true);
		}
	
	/*
	//�����
	JFrame jf_ch_server = new JFrame();
	JPanel jp_first = new JPanel();
	JPanel jp_second = new JPanel();
	
	JTextArea jta_display = new JTextArea();
	JTextField jtf_msg = new JTextField();
	
	JTable jt_room;
	
	
	//ȭ�� ó����
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
