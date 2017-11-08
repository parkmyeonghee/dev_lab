package ChattingProject;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



public class ClientWait extends JPanel implements ActionListener {
	//선언부
		Socket socket = null;
		//대화명 담을 변수
		String nickName = null; 
		String state = null; 
		ChattingClient cc= null;
		CClientThread cct = null;
		//화면배치 시작//
		JPanel jp_first = new JPanel();
		//JTextArea jta_display = new JTextArea();
		//JScrollPane jsp_display = new JScrollPane(jta_display
		//													  ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
		//													  ,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		JPanel jp_first_south = new JPanel();
		JTextField jtf_msg = new JTextField();
		
		JPanel jp_second = new JPanel();
		String userCols[]={"대화명","남긴말"};
		String userData[][]= new String[0][2];
		DefaultTableModel dtm_userList = new DefaultTableModel(userData,userCols);
		JTable jt_userList = new JTable(dtm_userList);
		JScrollPane jsp_userList = new JScrollPane(jt_userList
				,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
				,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		String roomCols[]={"방 리스트"};
		String roomData[][]= new String[0][1];
		DefaultTableModel dtm_room = new DefaultTableModel(roomData,roomCols);
		JTable jt_room = new JTable(dtm_room);
		JScrollPane jsp_room = new JScrollPane(jt_room
				,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
				,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		JPanel jp_second_south = new JPanel();
		JButton jbtn_whisper = new JButton("쪽지보내기");
		JButton jbtn_change = new JButton("대화명변경");
		JButton jbtn_makeRoom = new JButton("방 만들기");
		JButton jbtn_roomIN = new JButton("방 참여하기");
		JButton jbtn_stateChange = new JButton("남긴말 설정");
		JButton jbtn_close = new JButton("종료");
		
		//화면배치 끝//
		
		//생성자
		//1)화면처리
		//2)서버소켓 생성
		//3)클라이언트 소켓정보를 받아온다
		//4)스레드 생성하고 start() 호출
		public ClientWait(){}
		public ClientWait(ChattingClient cc, String nickName){
			   this.cc=cc;
			   this.nickName=nickName;
			   
				jbtn_change.addActionListener(this);
				jbtn_whisper.addActionListener(this);
				jbtn_close.addActionListener(this);
				jbtn_makeRoom.addActionListener(this);
				jbtn_roomIN.addActionListener(this);
				jbtn_stateChange.addActionListener(this);
				//jtf_msg.addActionListener(this); //이벤트 감지(JVM) -  콜백함수인 actionPerformed 호출
				//jbtn_makeRoom.setEnabled(false);
				
				this.setLayout(new GridLayout(1, 2));
				jp_first.setLayout(new BorderLayout());  //동서남북 배치 위해서, 디폴트는 플로우레이아웃임
				
				jp_first_south.setLayout(new BorderLayout());
				//jp_first_south.add("Center", jtf_msg);
				
				//jp_first.add("Center",jsp_display);
				jp_first.add("Center",jsp_room);
				jp_first.add("South",jp_first_south);
				
				jp_second_south.setLayout(new GridLayout(3, 2));
				jp_second_south.add(jbtn_stateChange);
				jp_second_south.add(jbtn_change);
				jp_second_south.add(jbtn_makeRoom);
				jp_second_south.add(jbtn_roomIN);
				jp_second_south.add(jbtn_whisper);
				jp_second_south.add(jbtn_close);
				
				jp_second.setLayout(new BorderLayout());
				jp_second.add("Center", jsp_userList);
				jp_second.add("South", jp_second_south);
				
				this.add(jp_first);
				this.add(jp_second);
		}
		public void exitChat(){
			try{
				cc.oos.writeObject(Protocol.CLOSE+"|"+this.nickName);
			}catch(Exception e){
				
			}
		}
		
	

		
		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource(); //이벤트 감지된 컴포넌트 주소번지
			String msg = jtf_msg.getText();
			
			//대화명 변경버튼 클릭했을 때
			if(obj==jbtn_change){
				//변경할 대화명 입력받기
				String afterName=JOptionPane.showInputDialog("변경할 대화명 입력해주세요!");
				//대화명이 널이거나 문자열의 길이가 1보자 작으면 처음부터 다시
				if(afterName==null||afterName.trim().length()<1){
					JOptionPane.showMessageDialog(this
							, "빈칸 안돼요~"
							,"INFO"
							,JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				//메시지 전송
				try {
					//300|하하|나신입| 하하가 나신입으로 바꼈습니다. 를 서버로 전송
					cc.oos.writeObject(Protocol.CHANGE+"|"+nickName+"|"+afterName+"|"+nickName+"의 대화명이"
							+afterName+"로 변경\n");
//					nickName=afterName;
					
				} catch (Exception e2) {
				}
			}else if(obj==jbtn_stateChange){
				//변경할 대화명 입력받기
				String afterState=JOptionPane.showInputDialog("변경할 대화명 입력해주세요!");
				//대화명이 널이거나 문자열의 길이가 1보자 작으면 처음부터 다시
				if(afterState==null||afterState.trim().length()<1){
					JOptionPane.showMessageDialog(this
							, "빈칸 안돼요~"
							,"INFO"
							,JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				//메시지 전송
				try {
					cc.oos.writeObject(Protocol.STATE_CHANGE+"|"+nickName+"|"+afterState);
				} catch (Exception e2) {
				}
			}
			else if(obj==jbtn_whisper){
				//귓속말할 사람 가져오기
				int row=jt_userList.getSelectedRow();
			
				if(row == -1){
					JOptionPane.showMessageDialog(this, "귓속말 상대를 선택하세요",
							"INFO",JOptionPane.INFORMATION_MESSAGE);
					return;
				}else{
					String wisperName=(String)jt_userList.getValueAt(jt_userList.getSelectedRow(), 0);
					if(wisperName.equals(nickName)){
						JOptionPane.showMessageDialog(this, "나말고 다른사람",
								"INFO",JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					msg= JOptionPane.showInputDialog("할말 쓰기");
					try {
						cc.oos.writeObject(Protocol.WHISPER+"|"+nickName+"|"+wisperName+"|"+msg);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				
				//대화명이 널이거나 문자열의 길이가 1보자 작으면 처음부터 다시

				//메시지 전송
			
			} //귓속말 끝
			else if(obj==jbtn_roomIN){
				int row=jt_room.getSelectedRow();
				String roomName = null;
				roomName = (String)jt_room.getValueAt(jt_room.getSelectedRow(), 0);
				if(row == -1||row>1){
					JOptionPane.showMessageDialog(this, "참가할 방 선택해주세요(1개)",
							"INFO",JOptionPane.INFORMATION_MESSAGE);
					return;
				}else{
					try {
						cc.oos.writeObject(Protocol.ROOM_IN+"|"+nickName+"|"+roomName);
						cc.jp.setSelectedIndex(1);
						jbtn_makeRoom.setEnabled(false);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				
			}//방만들기 끝
			else if(obj==jbtn_makeRoom){
				String roomName = JOptionPane.showInputDialog("방 이름을 입력하세요");
				if(jt_room.getRowCount()>0){
					for(int i=0; i<jt_room.getRowCount(); i++){
						if(roomName.equals((String)jt_room.getValueAt(i, 0))){
							JOptionPane.showMessageDialog(this, "방제목이 존재 합니다");
						}
					}
					return;
				}else if(roomName==null||roomName.equals("")){
					JOptionPane.showMessageDialog(this, "방 제목을 입력하세요");
					return;
				}else{
					try {
						System.out.println("방제목전송");
						cc.oos.writeObject(Protocol.ROOM_MAKE+"|"+nickName+"|"+roomName);
						cc.jp.setSelectedIndex(1);
						jbtn_makeRoom.setEnabled(false);
					} catch (IOException e1) {
						e1.printStackTrace();
					}	
				}
			}//방만들기 끝
			else if(obj==jbtn_close){
				exitChat();
				System.exit(0);
			}//종료 끝
		}


}
