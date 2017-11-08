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
//로그인창 서브 프레임
//채팅창이 메인프레임
public class client extends JFrame implements ActionListener, KeyListener{
	
	//로그인 GUI 변수
	private JFrame login_GUI = new JFrame();
	private JPanel pn_login;
	private JTextField tf_ip;
	private JTextField tf_port;
	private JTextField tf_id;
	private JButton btn_login = new JButton("접속하기");
	
	//메인 GUI 변수
	private JPanel pn_main;
	private JTextField tf_send;
	JLabel lb_loginUser = new JLabel("전 체 접 속 자");
	JLabel lb_roomList = new JLabel("채 팅 방 목 록");
	JButton btn_sendMsg = new JButton("쪽지보내기");
	JButton btn_join = new JButton("채팅방참여");
	JButton btn_createRoom = new JButton("방 만들기");
	JButton btn_sendChat = new JButton("전송");
	
	JTextArea area_chat = new JTextArea();
	
	JList list_user = new JList(); //접속자 리스트
	JList list_room = new JList(); //전체 방 리스트
	
	//네트워크 변수
	private Socket socket;
	private String ip=""; //자기자신(로컬호스트)
	private int port; //서버 포트번호
	private InputStream is;
	private OutputStream os;
	private DataInputStream dis;
	private DataOutputStream dos;
	private String id ="";
	
	//그외 변수

	Vector vc_userList = new Vector();
	Vector vc_roomList = new Vector();
	
	StringTokenizer st; //자바컬렉션에 토큰아이저 설명 나옴
	
	private String my_Room; //내가 현재 있는 방이름
	
	
	public client(){
		login_init();  //로그인창 화면 호출
		main_init();  //메인창 화면 호출
	}
	
	//메인창 화면 구성 메소드
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
	
	// 로그인화면창 구성 메소드
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
	
	//네트워크 메소드
	private void network(){
		try {
			socket = new Socket(ip, port);
			if(socket!=null){
				Connection();
			}
			
		} catch (UnknownHostException e) { //호스트 못찾앗을때
			JOptionPane.showMessageDialog(null, "호스트 찾기 실패","알림",JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (IOException e) { //스트림에서 에러 발생했을때
			JOptionPane.showMessageDialog(null, "연결실패","알림",JOptionPane.ERROR_MESSAGE);
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
		} //에러날 수 있어서 예외처리 해줘야됨
				
		/*send_msg("클라이언트 접속함!\n"); 단일통신부분
		
		String msg="";
		try {
			msg = dis.readUTF(); //서버로부터 들어온 메세지 저장, 무한정 대기, 답안오면 멈춰버림
			System.out.println(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		this.setVisible(true);
		login_GUI.setVisible(false);
		
		//처음 접속시에 ID 전송
		send_msg(id);
		
		//user 리스트에 사용자 추가
		vc_userList.add(id);
		list_user.setListData(vc_userList);
		
		Thread th = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					try {
						String msg = dis.readUTF();  //서버로 부터 메세지 수신
						
						inMsg(msg);
						
					} catch (IOException e) {
						
						try {
							os.close();
							is.close();
							dos.close();
							dis.close();
							socket.close();
							JOptionPane.showMessageDialog(null, "서버와 접속 끊어짐","알림",JOptionPane.ERROR_MESSAGE);
						}
						catch (IOException e1) {}
						break;
					} 
					
				}
			}
		}) ;
		th.start();
	}
	
	private void inMsg(String str) //서버로부터 들어오는 모든 메세지
	{
		//토큰을 통해 문자열을 구분한다.
		st = new StringTokenizer(str, "/");  //(어떤문자열 사용, 어떤토큰으로 자를까)
		String protocol = st.nextToken(); //현재 넘어온 프로토콜
		String msg = st.nextToken();      // 내용이 무엇인지
		
		System.out.println(protocol);
		System.out.println(msg);
		
		//새로운 접속자 왔을때
		if(protocol.equals("NewUser")){
			vc_userList.add(msg);
			//list_user.setListData(vc_userList);  //유저리스트셋업
		}
		else if(protocol.equals("OldUser"))
		{
			vc_userList.add(msg); //올드유저 아이디 추가
			//list_user.setListData(vc_userList); //유저리스트에 갱신
		}
		else if(protocol.equals("Note"))
		{
			String note=st.nextToken();
			System.out.println(msg+"의 메세지 : "+note);
			
			JOptionPane.showMessageDialog(null, note,msg+"님으로부터 오는",JOptionPane.CLOSED_OPTION);
		}
		else if(protocol.equals("user_list_update")){
			list_user.setListData(vc_userList);
		}
		else if(protocol.equals("방 만들기 성공!")){
			my_Room = msg;
			tf_send.setEnabled(true);
			btn_sendChat.setEnabled(true);
			btn_join.setEnabled(false);
			btn_createRoom.setEnabled(false);
		}
		else if(protocol.equals("같은 방제목이 있어요")){
			JOptionPane.showMessageDialog(null, "같은 방제목이 있어요","알림",JOptionPane.ERROR_MESSAGE);
		}
		else if(protocol.equals("New_Room")){
			vc_roomList.add(msg);
			list_room.setListData(vc_roomList);
		}
		else if(protocol.equals("Chatting"))
		{
			String msg2= st.nextToken();
			System.out.println("채팅구역 ");
			area_chat.append(msg+" : "+msg2+"\n");	
		}
		else if(protocol.equals("OldRoom"))
		{
			vc_roomList.add(msg); //방이름 벡터에 등록
		}
		else if(protocol.equals("room_list_update"))
		{
			list_room.setListData(vc_roomList);//방이름 벡터에 등록
		}
		else if(protocol.equals("JoinRoom"))
		{
			my_Room = msg;  //참여하는 방이름 저장
			tf_send.setEnabled(true);
			btn_sendChat.setEnabled(true);
			btn_join.setEnabled(false);
			btn_createRoom.setEnabled(false);
			JOptionPane.showMessageDialog(null, "채팅방에 입장했습니다.","알림",JOptionPane.INFORMATION_MESSAGE);
		}
		else if(protocol.equals("User_out")){
			vc_userList.remove(msg);
			
		}
			
	}
	private void send_msg(String str){ //서버에게 메세지 보내는 메소드
		// 클라이언트에서 나가는 것이 메세지를 보내는 것이므로 output 사용
		
		try {
			dos.writeUTF(str); //문자열 보내므로 utf방식으로 서버는 인풋으로 받으면 됨
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
			System.out.println("로그인버튼클릭");
			if(tf_ip.getText().length()==0)
			{
				tf_ip.setText("ip를 입력해주세요");
				tf_ip.requestFocus(); //커서 띄워주기
			}else if(tf_port.getText().length()==0)
			{
				tf_port.setText("port번호를 입력해주세요");
				tf_port.requestFocus(); //커서 띄워주기
			}
			else if(tf_id.getText().length()==0){
				tf_id.setText("ID를 입력해주세요");
				tf_id.requestFocus(); //커서 띄워주기
			}else{
				ip = tf_ip.getText().trim(); // trim은 공백있을때 공백없애고 글자 붙임 
				port = Integer.parseInt(tf_port.getText().trim()); //포트 땡겨오기 , 스트링으로 가져오므로 int형으로 형전환
				id = tf_id.getText().trim();
				
				network();
			}

		}
		else if(e.getSource()==btn_createRoom) //방만들기
		{
			String roomName= JOptionPane.showInputDialog("방 이름");
			if(roomName != null){
				send_msg("CreateRoom/"+roomName);
			}
		}
		else if(e.getSource()==btn_join) //채탕방 참여
		{
			
			String JoinRoom = (String)list_room.getSelectedValue();
			send_msg("JoinRoom/"+JoinRoom);
		}
		else if(e.getSource()==btn_sendChat) //채팅하기
		{
			send_msg("Chatting/"+my_Room+"/"+tf_send.getText().trim());
			//프로토콜은 채팅 + 방이름 + 내용
			tf_send.setText("");
			tf_send.requestFocus();
		}
		else if(e.getSource()==btn_sendMsg) //쪽지보내기
		{
			String user=(String)list_user.getSelectedValue();
			String note= JOptionPane.showInputDialog("보낼메시지");
			
			if(note!=null){
				send_msg("Note/"+user+"/"+note);
				//Note/유저네임/할말
			}
				System.out.println("받는사람 : "+user+"| 보낼내용 " +note);
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
