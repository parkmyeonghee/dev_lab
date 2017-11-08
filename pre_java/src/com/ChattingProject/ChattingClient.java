package com.ChattingProject;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;


public class ChattingClient extends JFrame {
	String path1 ="src\\com\\ChattingProject\\";
	JTabbedPane jp = new JTabbedPane();
	
	ClientWait cw = null;
	ClientRoom cr = null;
	CClientThread cct = null;
	
	String nickName = null;
	String state =" ";
	
	Socket socket = null;
	public ObjectOutputStream oos = null;
	public ObjectInputStream ois =null;
	String path = this.getClass().getResource("").getPath();

	CC_Login ccl = null;
	public ChattingClient(CC_Login ccl, Socket socket,ObjectOutputStream oos, ObjectInputStream ois){
		this.ccl=ccl;
		this.socket = socket;
		this.oos = oos;
		this.ois = ois;
		nickName=JOptionPane.showInputDialog("�г��� �Է��ϼ���");
		cw = new ClientWait(this, nickName);
		cr = new ClientRoom(this);
		jp.addTab("����",new ImageIcon(path1+"wait.png"),cw);
		jp.addTab("��ȭ��",new ImageIcon(path1+"chat.png"),cr);
		jp.setSelectedIndex(0);
		this.add("Center",jp);
		this.setSize(600, 500);
		this.setVisible(true);
		try {

			
			//������ �޽��� �����ϱ�
			oos.writeObject(Protocol.WAITROOM_IN+"|"+nickName+"|"+state);
			/*CClientThread cct = new CClientThread(this);
			cct.start();*/
		} catch (Exception e) {
		}
		
		
	}
	public ChattingClient()	{}
}
