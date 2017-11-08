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
	//컨트롤 쉬프트 o 자동 임포트
	private JPanel contentPane;
	private JTextField port_tf; //포트 텍스트필드
	
	private JLabel   lb_portNum = new JLabel("포트 번호");
	private JButton btn_serverStart = new JButton("서버 실행");
	private JButton btn_serverStop = new JButton("서버 중지");
	
	private JTextArea textArea = new JTextArea();
	
	//Network 부분
	private ServerSocket server_socket;
	private Socket socket; //클라이언트 소켓 받을 부분
	private int port;
	
/*	private InputStream is;
	private OutputStream os;
	private DataInputStream dis;
	private DataOutputStream dos;*/
	
	private Vector vc_user = new Vector();
	private Vector vc_room = new Vector();
	
	private StringTokenizer st;
	
	
	//생성자
	public server(){
		init(); //화면생성 메소드
		start(); // 버튼 리스너 설정
	}
	
	private void start(){
		btn_serverStart.addActionListener(this);
		btn_serverStop.addActionListener(this);
	}
	
	//화면구성
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
		textArea.setEditable(false);  //화면수정 불가능
		
		this.setVisible(true);
	}
	
	private void server_Start(){
		try {
			server_socket = new ServerSocket(port);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "이미 사용중인 포트입니다","알림",JOptionPane.ERROR_MESSAGE);
		} //12345포트 사용
		
		if(server_socket!=null) //정상적으로 열렸을 경우
		{
			Connection();
		}
	}
	
	private void Connection(){
				
		Thread th = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// 스레드에서 처리할 부분
				System.out.println("서버스타트");
				
				while(true){
				try { //사용자 접속할때까지 무한 대기
					textArea.append("사용자 접속 대기중\n");
					socket = server_socket.accept();
					textArea.append("사용자 접속함\n");
					
					userInfo user = new userInfo(socket);
					user.start(); //객체의 스레드 실행. 각각 스레드 상속받아서 개별 스레드 사용
					
				/*	try { 단일통신만 됨
						is = socket.getInputStream();
						dis = new DataInputStream(is);
						
						os = socket.getOutputStream();
						dos = new DataOutputStream(os);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					String msg ="";
					msg = dis.readUTF(); //사용자로부터 들어오는 메세지
					
					textArea.append(msg);*/
					
				} catch (IOException e) {
					//JOptionPane.showMessageDialog(null, "accept 에러 발생","알림",JOptionPane.ERROR_MESSAGE);
					break;
					}
		     }// while문 끝
			}
		});
		
		th.start(); //스레드 실행
		
	
	}
	public static void main(String[] args) {
		
		new server();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//이벤트구별 직접하기, 버튼이름으로 하기
		if(e.getSource()==btn_serverStart){
			port = Integer.parseInt(port_tf.getText().trim());
			server_Start();
			btn_serverStart.setEnabled(false); //버튼막기
			port_tf.setEditable(false);
			btn_serverStop.setEnabled(true);
		}
		else if(e.getSource()==btn_serverStop){
			
			try { //서버 초기화 시켜버리기
				textArea.append("서버중지!\n");
				btn_serverStop.setEnabled(false);
				btn_serverStart.setEnabled(true); //버튼막기
				port_tf.setEditable(true);
				server_socket.close();
				vc_user.removeAllElements();
				vc_room.removeAllElements();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}
	} //액션 이벤트 끝
	
	class userInfo extends Thread{
		private InputStream is;
		private OutputStream os;
		private DataInputStream dis;
		private DataOutputStream dos;
		
		private Socket user_socket;
		private String NickName = "";
		
		private boolean RoomCheck = true; // 기본상태 트루 -> 방만들기 가능상태
		
		public userInfo(Socket socket){ //생성자부분
			this.user_socket = socket;
			userNetwork();
		}
		
		public void run(){//쓰레드 처리할 내용 담기
			while(true){
				try {
					String msg=dis.readUTF(); 
					//사용자로부터 들어온 메세지 처리부분
					textArea.append(NickName+" : "+msg+"\n");
					InMsg(msg);
				} catch (IOException e) {
					//JOptionPane.showMessageDialog(null, "사용자 접속 끊어짐","알림",JOptionPane.ERROR_MESSAGE);
					textArea.append(NickName+" : 사용자 연결 종료");
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
		
		private void InMsg(String str)// 사용자로부터 들어오는 메세지 처리 메소드
		{
			st = new StringTokenizer(str, "/"); //(문자열, 구분할 기호)
			String protocol = st.nextToken();
			String msg = st.nextToken();
			
			System.out.println("프로토콜 : "+protocol);
			System.out.println("메시지 : "+msg);
			
			if(protocol.equals("Note")){
				//protocol=Note, msg=받는내용~
				

				String note = st.nextToken();
				
				System.out.println("받는 사람: "+msg);
				System.out.println("보낼 내용: "+note);
				
				//벡터에서 해당 사용자 찾아서 쪽지 전송하기  ★중요함
				for(int i =0; i<vc_user.size();i++)
				{
					System.out.println("쪽지간다!");
					userInfo u = (userInfo)vc_user.elementAt(i);
					System.out.println(u.NickName);
					if(u.NickName.equals(msg)){
						System.out.println("Note/"+NickName+"@"+note);
						u.send_Msg("Note/"+NickName+"/"+note);
						//쪽지(Note)/닉네임@할말~~~~~~~ 클라이언트로 보냄
					}
				}
			} //end if "Note"
			else if(protocol.equals("CreateRoom"))
			{
				//같은 방이 있는지 확인한다
				for(int i = 0; i<vc_room.size();i++)
				{
					RoomInfo r = (RoomInfo)vc_room.elementAt(i);
					if(r.Room_Name.equals(msg))//방이름이 중복일때
					{
						send_Msg("같은 방제목이 있어요/ok");
						RoomCheck=false;
						break;
					}
				} //end for
				if(RoomCheck){
					RoomInfo new_room = new RoomInfo(msg,this);
					vc_room.add(new_room); //전체 방 벡터에 1개의 방 추가
					
					send_Msg("방 만들기 성공!/"+msg);
									
					broadCast("New_Room/"+msg);	
				}
				RoomCheck=true;
			} //else if "CreateRoom"
			else if(protocol.equals("Chatting"))
			{
				//msg:방 이름 , msg2:보낼 메세지
				String msg2 = st.nextToken();
				for(int i=0; i<vc_room.size(); i++)
				{
					RoomInfo r = (RoomInfo)vc_room.elementAt(i);
					System.out.println("룸네임"+r.Room_Name);
					System.out.println("msg2"+msg2);
					if(r.Room_Name.equals(msg)) //방 찾앗을때
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
						//새로운 사용자 알리기
						r.broadCast_room("Chatting/알림/****"+NickName+"님이 입장하였습니다. ****");
						
						//사용자 추가하기
						r.add_User(this);
						send_Msg("JoinRoom/"+msg); //접속하는 방이름 전달
					}
				}
			}//else if "JoinRoom"
		}
		
		
		//브로드 캐스트 부분, 전체 사용자에게 메세지 보내는 부분
		private void broadCast(String str){
			//브로드 캐스트 부분
			for(int i=0; i<vc_user.size(); i++){ //현재 접속된 사용자에게 새로운 사용자 알림
				userInfo u = (userInfo)vc_user.elementAt(i); //해당백터에는 사용자가 추가되있음. 
				
				u.send_Msg(str); //새로운 사용자 알리기
				
			}
		}
		
		private void send_Msg(String str){ //문자열을 받아서 전송하기
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
				
				NickName = dis.readUTF(); //사용자 닉네임 받기
				textArea.append(NickName+" 님이 접속하셨습니다.");
				
			
				
				broadCast("NewUser/"+NickName);
				
				//접속중인 사용자 리스트 받아오는 부분
				for(int i=0; i<vc_user.size(); i++){
					userInfo u = (userInfo)vc_user.elementAt(i);
					send_Msg("OldUser/"+u.NickName);
				}
			
				//생성되어있는 방 리스트 받아오는 부분
				for(int i=0; i<vc_room.size(); i++){
					RoomInfo r = (RoomInfo)vc_room.elementAt(i);
					send_Msg("OldRoom/"+r.Room_Name);
				}
				
				send_Msg("room_list_update/ ");
				
				//사용자에게 알린후 vector에 자기자신 저장하기
				vc_user.add(this); 
				
				broadCast("user_list_update/ ");
				
				
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Stream설정 에러","알림",JOptionPane.ERROR_MESSAGE);
			}
	
		}
		
		
	} // userInfo 클래스 끝
	
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
		
		public void broadCast_room(String str)//현재 방 모든사람에게 알린다
		{
			for(int i = 0; i<vc_Room_User.size(); i++)
			{
				userInfo u = (userInfo)vc_Room_User.elementAt(i);
				
				u.send_Msg(str);
			}
		}
		
	}
}
