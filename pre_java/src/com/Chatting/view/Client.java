package com.Chatting.view;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class Client extends JFrame {
	JTabbedPane jp = new JTabbedPane();
	waitRoom wr = new waitRoom();
	MessageRoom mr = new MessageRoom();
	public Client()
	{
		jp.addTab("����", wr);
		jp.addTab("��ȭ��", mr);
		jp.setSelectedIndex(1);
		this.add("Center",jp);
		this.setSize(600, 500);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new Client();
	}

}
