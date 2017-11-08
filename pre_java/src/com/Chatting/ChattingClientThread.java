package com.Chatting;

import java.awt.Color;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JScrollBar;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class ChattingClientThread extends Thread {
	ChattingClient cc =null;
	public ChattingClientThread(ChattingClient cc){
		this.cc=cc;
	}
	//run메소드는 서버에서 말한 내용을 듣기만 하는 곳 입니다.
	//클라이언트의 말하기는 이벤트(chattingClient)에서 처리 합니다.
	public void run(){
		//message =100
		String message ="";
		boolean isStop = false;
		while(!isStop){
			try {
				message= (String)cc.ois.readObject(); //메세지를 받아오는 문장
				StringTokenizer st =null;
				int protocol=0;
				if(message !=null){
					st=new StringTokenizer(message,"|");
					protocol=Integer.parseInt(st.nextToken());//100
				}
				switch(protocol){
				case Protocol.ROON_IN:{
				//대화명 가져오기
					String nickName = st.nextToken();
					String fontColor =st.nextToken();
					String style[] = new String[3];
					style[0]=fontColor;
					Vector<String>v_name= new Vector<String>();
					v_name.add(nickName);
					cc.dtm_room.addRow(v_name);
					cc.jsp_room.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
						public void adjustmentValueChanged(AdjustmentEvent e) {
							JScrollBar src=(JScrollBar) e.getSource();
							src.setValue(src.getMaximum());
						}
					});
				//화면에 ㅇㅇ님이 입장하였습니다. 출력하기
					cc.jta_display.append("######"+nickName+"님이 입장하였습니다.#####\n");
					cc.jta_display.setCaretPosition(cc.jta_display.getDocument().getLength());
				}break;
				case Protocol.MESSAGE:{//일반대화- 다자간 대화
				String nickName = st.nextToken();
				String msg = st.nextToken();
				
				cc.jta_display.append("["+nickName+"]"+msg+"\n");
				cc.jta_display.setCaretPosition(cc.jta_display.getDocument().getLength());
				}break;
				case Protocol.WHISPER:{//귓속말-1:1대화
					String nickName = st.nextToken();
					String otherName=st.nextToken();
					String msg1 = st.nextToken();
					//사용자의 화면에 귓속말 출력하기
					cc.jta_display.append(nickName+"님이"+otherName+"님에게"+msg1+"\n");
					cc.jta_display.setCaretPosition(cc.jta_display.getDocument().getLength());
				}break;
				case Protocol.CHANGE:{//대화명 변경
					//이전 대화명 가져오기
					String nickName =st.nextToken();
					//변경 대화명 가져오기
					String afterName =st.nextToken();
					//테이블에 대화명 변경하기
					for(int i =0;i<cc.dtm_room.getRowCount();i++){
						//대화명 변경전에 현재 테이블에서 가져온 대화명을 받는다.
						String cname = (String)cc.dtm_room.getValueAt(i, 0);
						if(nickName.equals(cname)){
							//변경할 대화명으로 테이블내에 대화명을 변경한다.
							cc.dtm_room.setValueAt(afterName, i, 0);
							break;
						}
					}
					//메시지 출력하기
					cc.jta_display.append(nickName+"님의 대화명이"+afterName+"으로변경");
					//st.nextToken()을 넣어주어도 된다.
					//채팅 팝업창의 타이틀 바에도 대화명을 변경한다.
					if(nickName.equals(cc.nickName)){
						cc.setTitle(afterName+"님의 대화창");
						cc.nickName=afterName;
					}
				}break;
				case Protocol.ROON_OUT:{//방나가기
				//서버에서 넘어온 메시지 - 500|ㅇㅇ
				//대화명을 받아온다
					String name= st.nextToken();
				//퇴장 사실을 화면에 출력해 준다.
					cc.jta_display.append(name+"님이 퇴장하였습니다");
				//테이블에서 퇴장한 사용자의 이름을 삭제해 준다.
					for(int i=0;i<cc.dtm_room.getRowCount();i++){
						String n1 = (String)cc.dtm_room.getValueAt(i,0);
						if(name.equals(n1)){ //퇴장한 사람과 같은 사람을 찾아라
							cc.dtm_room.removeRow(i);
						}
					}
				}break;
				case Protocol.CLOSE:{//종료버튼 눌렀을 떄
					//서버에서 넘어온 메시지 - 500|ㅇㅇ
					String name = st.nextToken();
					String msg = st.nextToken();
					cc.jta_display.append(msg+"종료");
					cc.jta_display.setCaretPosition(cc.jta_display.getDocument().getLength());
				}break;
				}////////////////end of switch
			} catch (Exception e) {
			}{
				
			}
		}
	}
}
