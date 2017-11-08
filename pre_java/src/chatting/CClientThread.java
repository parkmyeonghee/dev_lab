package ChattingProject;

import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;



public class CClientThread extends Thread{

//CC_Chatting 받는 생성자	
	ChattingClient cc = null;
	CC_Login ccl=null;
	int oisState=0;    //0은 CC, 1은 CCL 
	
	public CClientThread(ChattingClient cc){
		this.cc=cc;
		oisState=0;
	}
	
	public CClientThread(CC_Login ccl){
		this.ccl=ccl;
		oisState=1;
	}
//cct의 run() - client의 듣기만 처리 
public void run(){
	String note = null;
	boolean isStop = false;
	while(!isStop){
		try {
			if(oisState==0){
			note = (String)cc.ois.readObject();	
			System.out.println("cc 스레드");
			}else{
			note = (String)ccl.ois.readObject();
			System.out.println("ccl 스레드");
			}
			StringTokenizer st=null;
			int protocol =0;
			
			if(note !=null){
				st= new StringTokenizer(note,"|");
				protocol=Integer.parseInt(st.nextToken());
				//ccl.jta_test.append("cct에 넘어온 note: "+note);
			} 
				switch (protocol) {
				case Protocol.LOG_IN_ROOMCHECK: {
					// 대화명 가져오기
					String roomName = st.nextToken();
					if (!"null".equals(roomName)) {
						Vector<String> v_room = new Vector<String>();
						v_room.add(roomName);
						ccl.cc.cw.dtm_room.addRow(v_room);
					}
					ccl.cc.cw.jsp_room.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
						@Override
						public void adjustmentValueChanged(AdjustmentEvent e) {
							JScrollBar src = (JScrollBar) e.getSource();
							src.setValue(src.getMaximum());
						}

					});

				}
					break;
				case Protocol.WAITROOM_IN: {
					// 대화명 가져오기
					System.out.println("로그인 프로토콜 받기");
					String nickName = st.nextToken();
					String state = st.nextToken();

					Vector<String> v_name = new Vector<String>();
					v_name.add(nickName);
					v_name.add(state);
					ccl.cc.cw.dtm_userList.addRow(v_name);
					ccl.cc.cw.jsp_userList.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {

						@Override
						public void adjustmentValueChanged(AdjustmentEvent e) {
							JScrollBar src = (JScrollBar) e.getSource();
							src.setValue(src.getMaximum());
						}
					});

				}
					break;
				case Protocol.ROOM_MAKE: {
					// 대화명 가져오기
					System.out.println("방만들기:클라이언트");
					String nickName = st.nextToken();
					String roomName = st.nextToken();
					// String state = st.nextToken();
					// nickName="test";
					Vector<String> v_name = new Vector<String>();
					Vector<String> v_room = new Vector<String>();
					v_name.add(nickName);
					v_room.add(roomName);
					// 채팅방 유저리스트
					// this.cr=cw.cc.cr;
					ccl.cc.cr.dtm_userList.addRow(v_name);
					// 대기실에 방추가
					ccl.cc.cw.dtm_room.addRow(v_room);
					ccl.cc.cw.jsp_room.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {

						@Override
						public void adjustmentValueChanged(AdjustmentEvent e) {
							JScrollBar src = (JScrollBar) e.getSource();
							src.setValue(src.getMaximum());
						}
					});
					// 채팅방 유저리스트
					ccl.cc.cr.jsp_userList.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {

						@Override
						public void adjustmentValueChanged(AdjustmentEvent e) {
							JScrollBar src = (JScrollBar) e.getSource();
							src.setValue(src.getMaximum());
						}
					});
				}
					break;
				case Protocol.ROOM_IN: {
					// 대화명 가져오기

					String nickName = st.nextToken();
					Vector<String> v_name = new Vector<String>();
					v_name.add(nickName);
					ccl.cc.cr.dtm_userList.addRow(v_name);
					ccl.cc.cr.jsp_userList.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {

						@Override
						public void adjustmentValueChanged(AdjustmentEvent e) {
							JScrollBar src = (JScrollBar) e.getSource();
							src.setValue(src.getMaximum());
						}
					});
					// 화면에 하하님이 입장하였습니다. 출력하기
					ccl.cc.cr.jta_display.append("******" + nickName + "님이 입장 하셨습니다." + "******\n");
				}
					break;
				case Protocol.MESSAGE: {// 일반대화
					String nickName = st.nextToken();
					String msg = st.nextToken();
					ccl.cc.cr.jta_display.append("[" + nickName + "] " + msg + "\n");
					ccl.cc.cr.jta_display.setCaretPosition(ccl.cc.cr.jta_display.getDocument().getLength());
				}
					break;
				case Protocol.WHISPER: {// 귓말
					String nickName = st.nextToken();
					String whisperName = st.nextToken();
					String msg = st.nextToken();
					// cc.cr.jta_display.append("[귓속말] "+"["+nickName+"]
					// "+msg+"\n");
					JOptionPane.showMessageDialog(cc, msg, nickName + "으로 부터 온 메세지", JOptionPane.INFORMATION_MESSAGE);
					ccl.cc.cr.jta_display.setCaretPosition(ccl.cc.cr.jta_display.getDocument().getLength());
				}
					break;
				case Protocol.CHANGE: {// 대화명변경
					// 이전 대화명 가져오기
					String beforeName = st.nextToken(); // nickName
					// 변경 대화명 가져오기
					String afterName = st.nextToken(); // afterName
					// 테이블에 대화명 변경하기
					for (int i = 0; i < ccl.cc.cw.jt_userList.getRowCount(); i++) {
						/*
						 * if(beforeName.equals(cc.jt_room.getValueAt(i, 0))){
						 * cc.jt_room.setValueAt(AfterName, i, 0); }
						 */
						String cname = (String) ccl.cc.cw.dtm_userList.getValueAt(i, 0);
						if (beforeName.equals(cname)) {
							ccl.cc.cw.jt_userList.setValueAt(afterName, i, 0);
						}
					}
					for (int i = 0; i < ccl.cc.cr.jt_userList.getRowCount(); i++) {
						String cname = (String) ccl.cc.cr.dtm_userList.getValueAt(i, 0);
						if (beforeName.equals(cname)) {
							ccl.cc.cr.jt_userList.setValueAt(afterName, i, 0);
						}
					}
					// 메시지 출력하기
					ccl.cc.cr.jta_display.append(st.nextToken());
					// 채팅 팝업창 타이틀도 대화명 변경
					if (beforeName.equals(ccl.cc.cw.nickName)) {
						/// cw.setTitle(afterName+"님의 대화창");
						ccl.cc.cw.nickName = afterName;

					}
				}
					break;
				case Protocol.STATE_CHANGE: {// 대화명변경
					String nickName = st.nextToken();
					String afterState = st.nextToken(); // afterName
					// 테이블에 대화명 변경하기
					for (int i = 0; i < ccl.cc.cw.jt_userList.getRowCount(); i++) {
						String cstate = (String) ccl.cc.cw.dtm_userList.getValueAt(i, 0);
						if (nickName.equals(cstate)) {
							ccl.cc.cw.jt_userList.setValueAt(afterState, i, 1);
						}
					}
					for (int i = 0; i < ccl.cc.cr.jt_userList.getRowCount(); i++) {
						String cstate = (String) ccl.cc.cr.dtm_userList.getValueAt(i, 0);
						if (nickName.equals(cstate)) {
							ccl.cc.cr.jt_userList.setValueAt(afterState, i, 1);
						}
					}
					// 메시지 출력하기
					ccl.cc.cr.jta_display.append(st.nextToken());
					// 채팅 팝업창 타이틀도 대화명 변경
				}
					break;
				case Protocol.CLOSE: {// 종료
					String nickName = st.nextToken();
					String msg = st.nextToken();
					ccl.cc.cr.jta_display.append("[" + nickName + "] " + msg + "\n");
					ccl.cc.cr.jta_display.setCaretPosition(ccl.cc.cr.jta_display.getDocument().getLength());
					// 테이블에서 퇴장한 사용자 이름을 삭제해준다.
					for (int i = 0; i < ccl.cc.cw.jt_room.getRowCount(); i++) {
						String delName = (String) ccl.cc.cw.dtm_room.getValueAt(i, 0);
						if (delName.equals(nickName)) {
							ccl.cc.cw.dtm_room.removeRow(i);
						}
					}

				}
					break;
				// 중복검사 듣기
				case Protocol.DUP: {
					String tf = st.nextToken();
					// 중복ID 없는 경우
					if (tf.equals("false")) {
						ccl.ccm.jf_duplication.dispose();
						JOptionPane.showMessageDialog(ccl.ccm, "사용 가능한 ID입니다.", "INFO",
								JOptionPane.INFORMATION_MESSAGE);
						ccl.ccm.jtf_signup_id.setText(ccl.ccm.dup_id);
					}
					// 중복ID가 이미 존재하는 경우
					else if (tf.equals("true")) {
						JOptionPane.showMessageDialog(ccl.ccm, "같은 ID가 이미 존재합니다.", "INFO",
								JOptionPane.INFORMATION_MESSAGE);
					}
				} // 중복검사 듣기 끝

				// 회원가입 듣기
				case Protocol.JOIN: {
					String success = null;
					success = st.nextToken();
					if (success.equals("success")) {
						ccl.ccm.dispose();
						JOptionPane.showMessageDialog(ccl.ccm, "회원가입 성공! 환영합니다!", "INFO",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}

				// 로그인 듣기
				case Protocol.LOGIN: {
					String tf = st.nextToken();
					if (tf.equals("false")) {
						ccl.l_fail();
					} else if (tf.equals("true")) {
						ccl.l_success();
					}
				} // 로그인 듣기 끝
				}// switch문 끝
			} catch (Exception e) {
			}
		}
	}
}
