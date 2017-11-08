package com.Chatting;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
//�α���â ���� ������
//ä��â�� ����������
public class client extends JFrame implements ActionListener, KeyListener{
	
	//�α��� GUI ����
	private JFrame login_GUI = new JFrame();
	private JPanel pn_login;
	private JTextField tf_ip;
	private JTextField tf_port;
	private JTextField tf_id;
	private JButton btn_login = new JButton("�����ϱ�");
	
	//���� GUI ����
	private JPanel pn_main;
	private JTextField tf_send;
	JLabel lb_loginUser = new JLabel("�� ü �� �� ��");
	JLabel lb_roomList = new JLabel("ä �� �� �� ��");
	JButton btn_sendMsg = new JButton("����������");
	JButton btn_join = new JButton("ä�ù�����");
	JButton btn_createRoom = new JButton("�� �����");
	JButton btn_sendChat = new JButton("����");
	
	JTextArea area_chat = new JTextArea();
	
	JList list_user = new JList(); //������ ����Ʈ
	JList list_room = new JList(); //��ü �� ����Ʈ
	
	//��Ʈ��ũ ����
	private Socket socket;
	private String ip=""; //�ڱ��ڽ�(����ȣ��Ʈ)
	private int port; //���� ��Ʈ��ȣ
	private InputStream is;
	private OutputStream os;
	private DataInputStream dis;
	private DataOutputStream dos;
	private String id ="";
	
	//�׿� ����

	Vector vc_userList = new Vector();
	Vector vc_roomList = new Vector();
	
	StringTokenizer st; //�ڹ��÷��ǿ� ��ū������ ���� ����
	
	private String my_Room; //���� ���� �ִ� ���̸�
	
	
	public client(){
		login_init();  //�α���â ȭ�� ȣ��
		main_init();  //����â ȭ�� ȣ��
	}
	
	//����â ȭ�� ���� �޼ҵ�
	private void main_init(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 524, 470);
		pn_main = new JPanel();
		pn_main.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pn_main);
		pn_main.setLayout(null);
		
		
		lb_loginUser.setBounds(12, 10, 105, 15);
		pn_main.add(lb_loginUser);
		
		
		list_user.setBounds(12, 33, 105, 156);
		pn_main.add(list_user);
		list_user.setListData(vc_userList);
		
		lb_roomList.setBounds(12, 227, 105, 15); 
		pn_main.add(lb_roomList);
		
		
		list_room.setBounds(12, 252, 105, 108);
		pn_main.add(list_room);
		list_room.setListData(vc_roomList);
		
		btn_join.setBounds(12, 370, 105, 23);
		pn_main.add(btn_join);
		
		
		btn_createRoom.setBounds(12, 398, 105, 23);
		pn_main.add(btn_createRoom);
		
		tf_send = new JTextField();
		tf_send.setBounds(125, 399, 301, 22);
		pn_main.add(tf_send);
		tf_send.setColumns(10);
		tf_send.setEnabled(false);
		
		btn_sendChat.setBounds(427, 398, 69, 23);
		pn_main.add(btn_sendChat);
		btn_sendChat.setEnabled(false);
		
		
		btn_sendMsg.setBounds(12, 199, 105, 23);
		pn_main.add(btn_sendMsg);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(124, 30, 372, 363);
		pn_main.add(scrollPane);
		
		
		scrollPane.setViewportView(area_chat);
		area_chat.setEditable(false);
		
		btn_createRoom.addActionListener(this);
		btn_join.addActionListener(this);
		btn_sendChat.addActionListener(this);
		btn_sendMsg.addActionListener(this);
		tf_send.addKeyListener(this);
		
		this.setVisible(false);
	}
	
	// �α���ȭ��â ���� �޼ҵ�
	private void login_init(){
		login_GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login_GUI.setBounds(100, 100, 278, 398);
		pn_login = new JPanel();
		pn_login.setBorder(new EmptyBorder(5, 5, 5, 5));
		login_GUI.setContentPane(pn_login);
		pn_login.setLayout(null);
		
		JLabel lb_serverIp = new JLabel("Server IP");
		lb_serverIp.setBounds(32, 204, 57, 15);
		pn_login.add(lb_serverIp);
		
		JLabel lb_serverPort = new JLabel("Server Port");
		lb_serverPort.setBounds(32, 240, 70, 15);
		pn_login.add(lb_serverPort);
		
		JLabel lb_id = new JLabel("I D");
		lb_id.setBounds(32, 278, 57, 15);
		pn_login.add(lb_id);
		
		tf_ip = new JTextField();
		tf_ip.setBounds(134, 201, 116, 21);
		pn_login.add(tf_ip);
		tf_ip.setColumns(10);
		
		tf_port = new JTextField();
		tf_port.setBounds(134, 237, 116, 21);
		pn_login.add(tf_port);
		tf_port.setColumns(10);
		
		tf_id = new JTextField();
		tf_id.setBounds(134, 275, 116, 21);
		pn_login.add(tf_id);
		tf_id.setColumns(10);
		
		
		btn_login.setBounds(90, 316, 97, 23);
		pn_login.add(btn_login);
		
		btn_login.addActionListener(this);
		login_GUI.setVisible(true);
	}
	
	//��Ʈ��ũ �޼ҵ�
	private void network(){
		try {
			socket = new Socket(ip, port);
			if(socket!=null){
				Connection();
			}
			
		} catch (UnknownHostException e) { //ȣ��Ʈ ��ã������
			JOptionPane.showMessageDialog(null, "ȣ��Ʈ ã�� ����","�˸�",JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (IOException e) { //��Ʈ������ ���� �߻�������
			JOptionPane.showMessageDialog(null, "�������","�˸�",JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
	}
	
	private void Connection(){
		try {
			is = socket.getInputStream();
			dis = new DataInputStream(is);
			
			os =socket.getOutputStream();
			dos = new DataOutputStream(os);
		} catch (IOException e) {
			
			e.printStackTrace();
		} //������ �� �־ ����ó�� ����ߵ�
				
		/*send_msg("Ŭ���̾�Ʈ ������!\n"); ������źκ�
		
		String msg="";
		try {
			msg = dis.readUTF(); //�����κ��� ���� �޼��� ����, ������ ���, ��ȿ��� �������
			System.out.println(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		this.setVisible(true);
		login_GUI.setVisible(false);
		
		//ó�� ���ӽÿ� ID ����
		send_msg(id);
		
		//user ����Ʈ�� ����� �߰�
		vc_userList.add(id);
		list_user.setListData(vc_userList);
		
		Thread th = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					try {
						String msg = dis.readUTF();  //������ ���� �޼��� ����
						
						inMsg(msg);
						
					} catch (IOException e) {
						
						try {
							os.close();
							is.close();
							dos.close();
							dis.close();
							socket.close();
							JOptionPane.showMessageDialog(null, "������ ���� ������","�˸�",JOptionPane.ERROR_MESSAGE);
						}
						catch (IOException e1) {}
						break;
					} 
					
				}
			}
		}) ;
		th.start();
	}
	
	private void inMsg(String str) //�����κ��� ������ ��� �޼���
	{
		//��ū�� ���� ���ڿ��� �����Ѵ�.
		st = new StringTokenizer(str, "/");  //(����ڿ� ���, ���ū���� �ڸ���)
		String protocol = st.nextToken(); //���� �Ѿ�� ��������
		String msg = st.nextToken();      // ������ ��������
		
		System.out.println(protocol);
		System.out.println(msg);
		
		//���ο� ������ ������
		if(protocol.equals("NewUser")){
			vc_userList.add(msg);
			//list_user.setListData(vc_userList);  //��������Ʈ�¾�
		}
		else if(protocol.equals("OldUser"))
		{
			vc_userList.add(msg); //�õ����� ���̵� �߰�
			//list_user.setListData(vc_userList); //��������Ʈ�� ����
		}
		else if(protocol.equals("Note"))
		{
			String note=st.nextToken();
			System.out.println(msg+"�� �޼��� : "+note);
			
			JOptionPane.showMessageDialog(null, note,msg+"�����κ��� ����",JOptionPane.CLOSED_OPTION);
		}
		else if(protocol.equals("user_list_update")){
			list_user.setListData(vc_userList);
		}
		else if(protocol.equals("�� ����� ����!")){
			my_Room = msg;
			tf_send.setEnabled(true);
			btn_sendChat.setEnabled(true);
			btn_join.setEnabled(false);
			btn_createRoom.setEnabled(false);
		}
		else if(protocol.equals("���� �������� �־��")){
			JOptionPane.showMessageDialog(null, "���� �������� �־��","�˸�",JOptionPane.ERROR_MESSAGE);
		}
		else if(protocol.equals("New_Room")){
			vc_roomList.add(msg);
			list_room.setListData(vc_roomList);
		}
		else if(protocol.equals("Chatting"))
		{
			String msg2= st.nextToken();
			System.out.println("ä�ñ��� ");
			area_chat.append(msg+" : "+msg2+"\n");	
		}
		else if(protocol.equals("OldRoom"))
		{
			vc_roomList.add(msg); //���̸� ���Ϳ� ���
		}
		else if(protocol.equals("room_list_update"))
		{
			list_room.setListData(vc_roomList);//���̸� ���Ϳ� ���
		}
		else if(protocol.equals("JoinRoom"))
		{
			my_Room = msg;  //�����ϴ� ���̸� ����
			tf_send.setEnabled(true);
			btn_sendChat.setEnabled(true);
			btn_join.setEnabled(false);
			btn_createRoom.setEnabled(false);
			JOptionPane.showMessageDialog(null, "ä�ù濡 �����߽��ϴ�.","�˸�",JOptionPane.INFORMATION_MESSAGE);
		}
		else if(protocol.equals("User_out")){
			vc_userList.remove(msg);
			
		}
			
	}
	private void send_msg(String str){ //�������� �޼��� ������ �޼ҵ�
		// Ŭ���̾�Ʈ���� ������ ���� �޼����� ������ ���̹Ƿ� output ���
		
		try {
			dos.writeUTF(str); //���ڿ� �����Ƿ� utf������� ������ ��ǲ���� ������ ��
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	public static void main(String[] args) {
		
		new client();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn_login){
			System.out.println("�α��ι�ưŬ��");
			if(tf_ip.getText().length()==0)
			{
				tf_ip.setText("ip�� �Է����ּ���");
				tf_ip.requestFocus(); //Ŀ�� ����ֱ�
			}else if(tf_port.getText().length()==0)
			{
				tf_port.setText("port��ȣ�� �Է����ּ���");
				tf_port.requestFocus(); //Ŀ�� ����ֱ�
			}
			else if(tf_id.getText().length()==0){
				tf_id.setText("ID�� �Է����ּ���");
				tf_id.requestFocus(); //Ŀ�� ����ֱ�
			}else{
				ip = tf_ip.getText().trim(); // trim�� ���������� ������ְ� ���� ���� 
				port = Integer.parseInt(tf_port.getText().trim()); //��Ʈ ���ܿ��� , ��Ʈ������ �������Ƿ� int������ ����ȯ
				id = tf_id.getText().trim();
				
				network();
			}

		}
		else if(e.getSource()==btn_createRoom) //�游���
		{
			String roomName= JOptionPane.showInputDialog("�� �̸�");
			if(roomName != null){
				send_msg("CreateRoom/"+roomName);
			}
		}
		else if(e.getSource()==btn_join) //ä���� ����
		{
			
			String JoinRoom = (String)list_room.getSelectedValue();
			send_msg("JoinRoom/"+JoinRoom);
		}
		else if(e.getSource()==btn_sendChat) //ä���ϱ�
		{
			send_msg("Chatting/"+my_Room+"/"+tf_send.getText().trim());
			//���������� ä�� + ���̸� + ����
			tf_send.setText("");
			tf_send.requestFocus();
		}
		else if(e.getSource()==btn_sendMsg) //����������
		{
			String user=(String)list_user.getSelectedValue();
			String note= JOptionPane.showInputDialog("�����޽���");
			
			if(note!=null){
				send_msg("Note/"+user+"/"+note);
				//Note/��������/�Ҹ�
			}
				System.out.println("�޴»�� : "+user+"| �������� " +note);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==10)
		{
			send_msg("Chatting/"+my_Room+"/"+tf_send.getText().trim());
			tf_send.setText("");
			tf_send.requestFocus();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
