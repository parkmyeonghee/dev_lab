package com.ChattingProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



public class ClientRoom extends JPanel implements ActionListener{
			//선언부
			//대화명 담을 변수
			String nickName = null; 
			String roomName = null;
			ChattingClient cc= null;
			
			
			//화면배치 시작//
			public JPanel jp_first=new JPanel();
			String path = this.getClass().getResource("").getPath();
            ImageIcon room = new ImageIcon(getClass().getResource("chattingroom.png"));
             public JTextArea jta_display = new JTextArea();/*{
              public void paintComponent(Graphics g) {
                 g.drawImage(room.getImage(), 0, 0, null);
                 setOpaque(false);
                  super.paintComponents(g);
                 }
              };*/
      
			//JTextArea jta_display = new JTextArea();
			JScrollPane jsp_display = new JScrollPane(jta_display
																  ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
																  ,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			
			JPanel jp_first_south = new JPanel();
			JTextField jtf_msg = new JTextField();
			
			JPanel jp_second = new JPanel();
			String userCols[]={"대화명"};
			String userData[][]= new String[0][1];
			DefaultTableModel dtm_userList = new DefaultTableModel(userData,userCols);
			JTable jt_userList = new JTable(dtm_userList);
			JScrollPane jsp_userList = new JScrollPane(jt_userList
					,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
					,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			
			JPanel jp_second_south = new JPanel();
			
			JButton jbtn_whisper = new JButton("쪽지보내기",new ImageIcon(path+"message.png"));
			JButton jbtn_change = new JButton("대화명변경",new ImageIcon(path+"change.png"));
			JButton  jbtn_send = new JButton(new ImageIcon(path+"send.png"));
			JButton jbtn_roomout = new JButton("방 나가기",new ImageIcon(path+"exit.png"));
			JButton jbtn_close = new JButton("종료",new ImageIcon(path+"exit.png"));
			
			//화면배치 끝//
			
			//생성자
			//1)화면처리
			//2)서버소켓 생성
			//3)클라이언트 소켓정보를 받아온다
			//4)스레드 생성하고 start() 호출
			public ClientRoom(){}
			public ClientRoom(ChattingClient cc){
				   	//방만들기할때 방이름가져오기
					this.cc=cc;
					this.nickName=cc.nickName;
					//nickName= JOptionPane.showInputDialog("대화명을 입력하세요");
					
					//jta_display.setLineWrap(true); //자동줄바꿈?
					jbtn_change.setBorderPainted(false);
					jbtn_change.setContentAreaFilled(false);
					jbtn_change.setBackground(Color.white);
					jbtn_change.addActionListener(this);
					
					jbtn_whisper.setBorderPainted(false);
					jbtn_whisper.setContentAreaFilled(false);
					jbtn_whisper.setBackground(Color.white);
					jbtn_whisper.addActionListener(this);
					
					jbtn_send.setBorderPainted(false);
					jbtn_send.setContentAreaFilled(false);
					jbtn_send.setBackground(Color.white);
					jbtn_send.addActionListener(this);
					
					jbtn_roomout.addActionListener(this);
					jbtn_roomout.setBorderPainted(false);
					jbtn_roomout.setContentAreaFilled(false);
					jbtn_roomout.setBackground(Color.white);
					
			
					jbtn_close.addActionListener(this);
					jbtn_close.setBorderPainted(false);
					jbtn_close.setContentAreaFilled(false);
					jbtn_close.setBackground(Color.white);
					
	
					
					jtf_msg.addActionListener(this); //이벤트 감지(JVM) -  콜백함수인 actionPerformed 호출
					
					this.setLayout(new GridLayout(1, 2));
					jp_first.setLayout(new BorderLayout());  //동서남북 배치 위해서, 디폴트는 플로우레이아웃임
					
					jp_first_south.setLayout(new BorderLayout());
					jp_first_south.add("Center", jtf_msg);
					jp_first_south.add("East", jbtn_send);
					
					jp_first.add("Center",jsp_display);
					jp_first.add("South",jp_first_south);
					
					
					
					jp_second_south.setLayout(new GridLayout(2, 2));
					jp_second_south.add(jbtn_whisper);
					jp_second_south.add(jbtn_change);
					jp_second_south.add(jbtn_roomout);
					jp_second_south.add(jbtn_close);
					
					jp_second.setLayout(new BorderLayout());
					jp_second.add("Center", jsp_userList);
					jp_second.add("South", jp_second_south);
					
					jp_first.setBackground(new Color(122,238,184)); //panel 색상
					jp_first_south.setBackground(Color.white);
					jp_second.setBackground(new Color(122,238,184));
					jp_second_south.setBackground(Color.white);
					
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
				if(obj==jtf_msg || obj==jbtn_send){
					try {
						cc.oos.writeObject(Protocol.MESSAGE+"|"+nickName+"|"+msg);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					jtf_msg.setText("");
				}//end 메세지 전송
				//대화명 변경버튼 클릭했을 때
				else if(obj==jbtn_change){
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
						
						this.nickName=afterName;
//						nickName=afterName;
						
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
				else if(obj==jbtn_roomout){
					try {
						cc.oos.writeObject(Protocol.ROOM_OUT+"|"+nickName+"|"+roomName);
						roomName=null;
						cc.cw.jbtn_makeRoom.setEnabled(true);
						cc.jp.setSelectedIndex(0);
						this.jta_display.setText("");
					} catch (Exception e2) {
					}
				} //방나가기 끝
				else if(obj==jbtn_close){
					exitChat();
					System.exit(0);
				}
			}


}
