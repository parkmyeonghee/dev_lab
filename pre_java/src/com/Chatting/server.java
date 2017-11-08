package com.Chatting;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class server extends JFrame implements ActionListener{
	//��Ʈ�� ����Ʈ o �ڵ� ����Ʈ
	private JPanel contentPane;
	private JTextField port_tf; //��Ʈ �ؽ�Ʈ�ʵ�
	
	private JLabel   lb_portNum = new JLabel("��Ʈ ��ȣ");
	private JButton btn_serverStart = new JButton("���� ����");
	private JButton btn_serverStop = new JButton("���� ����");
	
	private JTextArea textArea = new JTextArea();
	
	//Network �κ�
	private ServerSocket server_socket;
	private Socket socket; //Ŭ���̾�Ʈ ���� ���� �κ�
	private int port;
	
/*	private InputStream is;
	private OutputStream os;
	private DataInputStream dis;
	private DataOutputStream dos;*/
	
	private Vector vc_user = new Vector();
	private Vector vc_room = new Vector();
	
	private StringTokenizer st;
	
	
	//������
	public server(){
		init(); //ȭ����� �޼ҵ�
		start(); // ��ư ������ ����
	}
	
	private void start(){
		btn_serverStart.addActionListener(this);
		btn_serverStop.addActionListener(this);
	}
	
	//ȭ�鱸��
	private void init()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 328, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		lb_portNum.setBounds(12, 277, 57, 15);
		contentPane.add(lb_portNum);
		
		port_tf = new JTextField();
		port_tf.setBounds(68, 274, 128, 21);
		contentPane.add(port_tf);
		port_tf.setColumns(10);
		
		
		btn_serverStart.setBounds(48, 315, 97, 23);
		contentPane.add(btn_serverStart);
		
		
		btn_serverStop.setBounds(174, 315, 97, 23);
		contentPane.add(btn_serverStop);
		btn_serverStop.setEnabled(false);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 288, 255);
		contentPane.add(scrollPane);
		
		
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);  //ȭ����� �Ұ���
		
		this.setVisible(true);
	}
	
	private void server_Start(){
		try {
			server_socket = new ServerSocket(port);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "�̹� ������� ��Ʈ�Դϴ�","�˸�",JOptionPane.ERROR_MESSAGE);
		} //12345��Ʈ ���
		
		if(server_socket!=null) //���������� ������ ���
		{
			Connection();
		}
	}
	
	private void Connection(){
				
		Thread th = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// �����忡�� ó���� �κ�
				System.out.println("������ŸƮ");
				
				while(true){
				try { //����� �����Ҷ����� ���� ���
					textArea.append("����� ���� �����\n");
					socket = server_socket.accept();
					textArea.append("����� ������\n");
					
					userInfo user = new userInfo(socket);
					user.start(); //��ü�� ������ ����. ���� ������ ��ӹ޾Ƽ� ���� ������ ���
					
				/*	try { ������Ÿ� ��
						is = socket.getInputStream();
						dis = new DataInputStream(is);
						
						os = socket.getOutputStream();
						dos = new DataOutputStream(os);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					String msg ="";
					msg = dis.readUTF(); //����ڷκ��� ������ �޼���
					
					textArea.append(msg);*/
					
				} catch (IOException e) {
					//JOptionPane.showMessageDialog(null, "accept ���� �߻�","�˸�",JOptionPane.ERROR_MESSAGE);
					break;
					}
		     }// while�� ��
			}
		});
		
		th.start(); //������ ����
		
	
	}
	public static void main(String[] args) {
		
		new server();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//�̺�Ʈ���� �����ϱ�, ��ư�̸����� �ϱ�
		if(e.getSource()==btn_serverStart){
			port = Integer.parseInt(port_tf.getText().trim());
			server_Start();
			btn_serverStart.setEnabled(false); //��ư����
			port_tf.setEditable(false);
			btn_serverStop.setEnabled(true);
		}
		else if(e.getSource()==btn_serverStop){
			
			try { //���� �ʱ�ȭ ���ѹ�����
				textArea.append("��������!\n");
				btn_serverStop.setEnabled(false);
				btn_serverStart.setEnabled(true); //��ư����
				port_tf.setEditable(true);
				server_socket.close();
				vc_user.removeAllElements();
				vc_room.removeAllElements();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}
	} //�׼� �̺�Ʈ ��
	
	class userInfo extends Thread{
		private InputStream is;
		private OutputStream os;
		private DataInputStream dis;
		private DataOutputStream dos;
		
		private Socket user_socket;
		private String NickName = "";
		
		private boolean RoomCheck = true; // �⺻���� Ʈ�� -> �游��� ���ɻ���
		
		public userInfo(Socket socket){ //�����ںκ�
			this.user_socket = socket;
			userNetwork();
		}
		
		public void run(){//������ ó���� ���� ���
			while(true){
				try {
					String msg=dis.readUTF(); 
					//����ڷκ��� ���� �޼��� ó���κ�
					textArea.append(NickName+" : "+msg+"\n");
					InMsg(msg);
				} catch (IOException e) {
					//JOptionPane.showMessageDialog(null, "����� ���� ������","�˸�",JOptionPane.ERROR_MESSAGE);
					textArea.append(NickName+" : ����� ���� ����");
					try {
						dos.close();
						dis.close();
						user_socket.close();
						vc_user.remove(this);
						broadCast("User_out/"+NickName);
						broadCast("user_list_update/ ");
					} catch (IOException e1) {}
                      break;
				} 
			}
		}
		
		private void InMsg(String str)// ����ڷκ��� ������ �޼��� ó�� �޼ҵ�
		{
			st = new StringTokenizer(str, "/"); //(���ڿ�, ������ ��ȣ)
			String protocol = st.nextToken();
			String msg = st.nextToken();
			
			System.out.println("�������� : "+protocol);
			System.out.println("�޽��� : "+msg);
			
			if(protocol.equals("Note")){
				//protocol=Note, msg=�޴³���~
				

				String note = st.nextToken();
				
				System.out.println("�޴� ���: "+msg);
				System.out.println("���� ����: "+note);
				
				//���Ϳ��� �ش� ����� ã�Ƽ� ���� �����ϱ�  ���߿���
				for(int i =0; i<vc_user.size();i++)
				{
					System.out.println("��������!");
					userInfo u = (userInfo)vc_user.elementAt(i);
					System.out.println(u.NickName);
					if(u.NickName.equals(msg)){
						System.out.println("Note/"+NickName+"@"+note);
						u.send_Msg("Note/"+NickName+"/"+note);
						//����(Note)/�г���@�Ҹ�~~~~~~~ Ŭ���̾�Ʈ�� ����
					}
				}
			} //end if "Note"
			else if(protocol.equals("CreateRoom"))
			{
				//���� ���� �ִ��� Ȯ���Ѵ�
				for(int i = 0; i<vc_room.size();i++)
				{
					RoomInfo r = (RoomInfo)vc_room.elementAt(i);
					if(r.Room_Name.equals(msg))//���̸��� �ߺ��϶�
					{
						send_Msg("���� �������� �־��/ok");
						RoomCheck=false;
						break;
					}
				} //end for
				if(RoomCheck){
					RoomInfo new_room = new RoomInfo(msg,this);
					vc_room.add(new_room); //��ü �� ���Ϳ� 1���� �� �߰�
					
					send_Msg("�� ����� ����!/"+msg);
									
					broadCast("New_Room/"+msg);	
				}
				RoomCheck=true;
			} //else if "CreateRoom"
			else if(protocol.equals("Chatting"))
			{
				//msg:�� �̸� , msg2:���� �޼���
				String msg2 = st.nextToken();
				for(int i=0; i<vc_room.size(); i++)
				{
					RoomInfo r = (RoomInfo)vc_room.elementAt(i);
					System.out.println("�����"+r.Room_Name);
					System.out.println("msg2"+msg2);
					if(r.Room_Name.equals(msg)) //�� ã������
					{	
						r.broadCast_room("Chatting/"+NickName+"/"+msg2);
					}
				}
			}//else if "Chatting"
			else if(protocol.equals("JoinRoom"))
			{
				for(int i=0; i<vc_room.size(); i++)
				{
					RoomInfo r = (RoomInfo)vc_room.elementAt(i);
					if(r.Room_Name.equals(msg)){
						//���ο� ����� �˸���
						r.broadCast_room("Chatting/�˸�/****"+NickName+"���� �����Ͽ����ϴ�. ****");
						
						//����� �߰��ϱ�
						r.add_User(this);
						send_Msg("JoinRoom/"+msg); //�����ϴ� ���̸� ����
					}
				}
			}//else if "JoinRoom"
		}
		
		
		//��ε� ĳ��Ʈ �κ�, ��ü ����ڿ��� �޼��� ������ �κ�
		private void broadCast(String str){
			//��ε� ĳ��Ʈ �κ�
			for(int i=0; i<vc_user.size(); i++){ //���� ���ӵ� ����ڿ��� ���ο� ����� �˸�
				userInfo u = (userInfo)vc_user.elementAt(i); //�ش���Ϳ��� ����ڰ� �߰�������. 
				
				u.send_Msg(str); //���ο� ����� �˸���
				
			}
		}
		
		private void send_Msg(String str){ //���ڿ��� �޾Ƽ� �����ϱ�
			try {
				dos.writeUTF(str);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		private void userNetwork(){
			try {
				is = user_socket.getInputStream();
				dis = new DataInputStream(is);
				os = user_socket.getOutputStream();
				dos = new DataOutputStream(os);
				
				NickName = dis.readUTF(); //����� �г��� �ޱ�
				textArea.append(NickName+" ���� �����ϼ̽��ϴ�.");
				
			
				
				broadCast("NewUser/"+NickName);
				
				//�������� ����� ����Ʈ �޾ƿ��� �κ�
				for(int i=0; i<vc_user.size(); i++){
					userInfo u = (userInfo)vc_user.elementAt(i);
					send_Msg("OldUser/"+u.NickName);
				}
			
				//�����Ǿ��ִ� �� ����Ʈ �޾ƿ��� �κ�
				for(int i=0; i<vc_room.size(); i++){
					RoomInfo r = (RoomInfo)vc_room.elementAt(i);
					send_Msg("OldRoom/"+r.Room_Name);
				}
				
				send_Msg("room_list_update/ ");
				
				//����ڿ��� �˸��� vector�� �ڱ��ڽ� �����ϱ�
				vc_user.add(this); 
				
				broadCast("user_list_update/ ");
				
				
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Stream���� ����","�˸�",JOptionPane.ERROR_MESSAGE);
			}
	
		}
		
		
	} // userInfo Ŭ���� ��
	
	class RoomInfo{
		private String Room_Name;
		private Vector vc_Room_User = new Vector();
		
		RoomInfo(String RoomName, userInfo u)
		{
			this.Room_Name=RoomName;
			this.vc_Room_User.add(u);
		}
		
		public void add_User(userInfo u)
		{
			this.vc_Room_User.add(u);
		}
		
		public void broadCast_room(String str)//���� �� ��������� �˸���
		{
			for(int i = 0; i<vc_Room_User.size(); i++)
			{
				userInfo u = (userInfo)vc_Room_User.elementAt(i);
				
				u.send_Msg(str);
			}
		}
		
	}
}
