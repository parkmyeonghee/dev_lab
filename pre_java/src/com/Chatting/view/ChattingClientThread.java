package com.Chatting.view;

import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JScrollBar;

import com.ChattingProject.ChattingClient;
import com.ChattingProject.Protocol;

public class ChattingClientThread extends Thread{
		
		ChattingClient cc = null;
		public ChattingClientThread(ChattingClient cc){
			this.cc=cc;
		}
		/*public void ChattingRoomIn(ClientRoom cr){
			this.cr=cr;
		}*/
		//run메소드는 서버에서 말하는것을 듣는다.
		//클라이언트의 말하기는 이벤트(ChattingClient)에서 처리
		public void run(){
		String message = "";
		boolean isStop = false;
		while(!isStop){
			try{
				message = (String)cc.ois.readObject();
				StringTokenizer st = null;
				int protocol = 0;
				if(message != null){
					
					st = new StringTokenizer(message, "|");
					protocol = Integer.parseInt(st.nextToken()); //100
				}
				switch(protocol){
				case Protocol.LOG_IN :{
					//대화명 가져오기
					System.out.println("로그인 프로토콜 받기");
					String nickName = st.nextToken();
					String state = st.nextToken();
					
					Vector<String> v_name=new Vector<String>();
					v_name.add(nickName);
					v_name.add(state);
					cc.cw.dtm_userList.addRow(v_name);
					cc.cw.jsp_userList.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
						
						@Override
						public void adjustmentValueChanged(AdjustmentEvent e) {
							JScrollBar src = (JScrollBar) e.getSource();
							src.setValue(src.getMaximum());
						}
					});
					
				}break;
				case Protocol.LOG_IN_ROOMCHECK :{
					//대화명 가져오기
					String roomName = st.nextToken();
					if(!"null".equals(roomName)){
						Vector<String> v_room=new Vector<String>();
						v_room.add(roomName);
						cc.cw.dtm_room.addRow(v_room);
					}
					cc.cw.jsp_room.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
						@Override
						public void adjustmentValueChanged(AdjustmentEvent e) {
							JScrollBar src = (JScrollBar) e.getSource();
							src.setValue(src.getMaximum());
						}
					
					});
					
				}break;
				case Protocol.ROOM_MAKE :{
					//대화명 가져오기
					System.out.println("방만들기:클라이언트");
					String nickName = st.nextToken();
					String roomName = st.nextToken();
					//String state = st.nextToken();
					//nickName="test";
					Vector<String> v_name=new Vector<String>();
					Vector<String> v_room=new Vector<String>();
					v_name.add(nickName);
					v_room.add(roomName);
					//채팅방 유저리스트
					//this.cr=cw.cc.cr;
					cc.cr.dtm_userList.addRow(v_name);
					//대기실에 방추가
					cc.cw.dtm_room.addRow(v_room);
					cc.cw.jsp_room.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
						
						@Override
						public void adjustmentValueChanged(AdjustmentEvent e) {
							JScrollBar src = (JScrollBar) e.getSource();
							src.setValue(src.getMaximum());
						}
					});
					//채팅방 유저리스트
					cc.cr.jsp_userList.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
						
						@Override
						public void adjustmentValueChanged(AdjustmentEvent e) {
							JScrollBar src = (JScrollBar) e.getSource();
							src.setValue(src.getMaximum());
						}
					});
					
				}break;
				case Protocol.ROOM_IN :{
					//대화명 가져오기
					
					String nickName = st.nextToken();
					Vector<String> v_name=new Vector<String>();
					v_name.add(nickName);
					cc.cr.dtm_userList.addRow(v_name);
					cc.cr.jsp_userList.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
						
						@Override
						public void adjustmentValueChanged(AdjustmentEvent e) {
							JScrollBar src = (JScrollBar) e.getSource();
							src.setValue(src.getMaximum());
						}
					});
					//화면에 하하님이 입장하였습니다. 출력하기
					cc.cr.jta_display.append("******"+nickName+"님이 입장 하셨습니다."+"******\n");
				}break;
				case Protocol.MESSAGE:{//일반대화
					String nickName = st.nextToken();
					String msg = st.nextToken();
					cc.cr.jta_display.append("["+nickName+"] "+msg+"\n");
					cc.cr.jta_display.setCaretPosition(cc.cr.jta_display.getDocument().getLength());
				}break;
				case Protocol.WHISPER:{//귓말
					String nickName = st.nextToken();
					String whisperName = st.nextToken();
					String msg = st.nextToken();
					//cc.cr.jta_display.append("[귓속말] "+"["+nickName+"] "+msg+"\n");
					JOptionPane.showMessageDialog(cc, msg, nickName+"으로 부터 온 메세지", JOptionPane.INFORMATION_MESSAGE);
					cc.cr.jta_display.setCaretPosition(cc.cr.jta_display.getDocument().getLength());
				}break;
				case Protocol.CHANGE:{//대화명변경
					//이전 대화명 가져오기
					String beforeName = st.nextToken();  //nickName
					//변경 대화명 가져오기
					String afterName = st.nextToken();    //afterName
					//테이블에 대화명 변경하기
					for(int i=0; i<cc.cw.jt_userList.getRowCount();i++)
					{
					/*	if(beforeName.equals(cc.jt_room.getValueAt(i, 0))){
							cc.jt_room.setValueAt(AfterName, i, 0);
						}*/
						String cname=(String)cc.cw.dtm_userList.getValueAt(i, 0);
						if(beforeName.equals(cname)){
							cc.cw.jt_userList.setValueAt(afterName, i, 0);
						}
					}
					for(int i=0; i<cc.cr.jt_userList.getRowCount();i++)
					{
						String cname=(String)cc.cr.dtm_userList.getValueAt(i, 0);
						if(beforeName.equals(cname)){
							cc.cr.jt_userList.setValueAt(afterName, i, 0);
						}
					}
					//메시지 출력하기
					cc.cr.jta_display.append(st.nextToken());
					//채팅 팝업창 타이틀도 대화명 변경
					if(beforeName.equals(cc.cw.nickName)){
						///cw.setTitle(afterName+"님의 대화창");
						cc.cw.nickName=afterName;
						
					}
				}break;
				case Protocol.STATE_CHANGE:{//대화명변경
					String nickName = st.nextToken();
					String afterState = st.nextToken();    //afterName
					//테이블에 대화명 변경하기
					for(int i=0; i<cc.cw.jt_userList.getRowCount();i++)
					{
						String cstate=(String)cc.cw.dtm_userList.getValueAt(i, 0);
						if(nickName.equals(cstate)){
							cc.cw.jt_userList.setValueAt(afterState, i, 1);
						}
					}
					for(int i=0; i<cc.cr.jt_userList.getRowCount();i++)
					{
						String cstate=(String)cc.cr.dtm_userList.getValueAt(i, 0);
						if(nickName.equals(cstate)){
							cc.cr.jt_userList.setValueAt(afterState, i, 1);
						}
					}
					//메시지 출력하기
					cc.cr.jta_display.append(st.nextToken());
					//채팅 팝업창 타이틀도 대화명 변경
					}break;
				case Protocol.CLOSE:{//종료
					String nickName = st.nextToken();
					String msg = st.nextToken();
					cc.cr.jta_display.append("["+nickName+"] "+msg+"\n");
					cc.cr.jta_display.setCaretPosition(cc.cr.jta_display.getDocument().getLength());
					//테이블에서 퇴장한 사용자 이름을 삭제해준다.
					for(int i=0; i<cc.cw.jt_room.getRowCount();i++){
						String delName=(String)cc.cw.dtm_room.getValueAt(i, 0);
						if(delName.equals(nickName)){
							cc.cw.dtm_room.removeRow(i);
						}
					}
					
				}break;
				}////////////////end switch
			}catch(Exception e){	
			 	
			}
		}
		}
}
