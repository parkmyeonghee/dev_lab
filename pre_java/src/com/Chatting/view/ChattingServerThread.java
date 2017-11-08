package com.Chatting.view;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.ChattingProject.Protocol;


public class ChattingServerThread extends Thread{
	ChattingServer cs = null;
	ObjectInputStream ois = null;
	ObjectOutputStream oos = null;
	String chatName="";
	String state="";
	String roomName=null;
	public ChattingServerThread(ChattingServer cs){
		//파라미터로 넘어온 chattingserver를 다른 메소드에서도 사용하기위해
		//멤버변수 선언 후 초기화를합니다.
		this.cs=cs;
		try {
			oos = new ObjectOutputStream(cs.client.getOutputStream());
			ois = new ObjectInputStream(cs.client.getInputStream());
			
			String message = (String)ois.readObject();
			cs.jta_display.append(message+"\n");
			
			//메시지가 추가 될때마다 화면 이동처리하기!
			cs.jta_display.setCaretPosition(cs.jta_display.getDocument().getLength());
			
			StringTokenizer st = new StringTokenizer(message, "|");
			st.nextToken();
			chatName = st.nextToken();
			//늦게 들어온 사람도 앞 사람 대화명 알아야함.
			for(ChattingServerThread cst:cs.chatList){
				String currentName = cst.chatName;
				String currentState = cst.state;
				this.send(Protocol.LOG_IN+"|"+currentName+"|"+currentState);
			}
			for(ChattingServerThread cst:cs.chatList){
				String roomName = cst.roomName;
				this.send(Protocol.LOG_IN_ROOMCHECK+"|"+roomName);
			}
			//사용자 추가하기
			cs.chatList.add(this);
			this.broadCasting(message);
		} catch (Exception e) {
			cs.jta_display.append("Exception : "+e.toString()+"\n");
		}
	}
	//대화방에 참여한 모든 친구들에게	 메시지 출력하기
	public void broadCasting(String msg){
		synchronized(this){
			for(ChattingServerThread cst:cs.chatList){ //chatList에 클라이언트 들어있음
				cst.send(msg);
			}
		}
	}
/********************************************************************************************
 * 	개선된 포문
 * for([1]:[2]){}
 * 자료구조나 배열에 있는 모든 정보를 사용하고 싶을때 사용
 * [1]:자료구조일때는 제네릭 타입, 배열일때는 배열 타입 작성
 * [2]:자료구조 혹은 배열타입 작성
 ********************************************************************************************/
/*	for(int i=0; i<cs.chatList.size();i++){
		ChattingServerThread cst = cs.chatList.get(i);
	}*/
	
	//클라이언트로 부터 읽어온 메시지 출력한다.
	public void send(String msg){
		try {
			oos.writeObject(msg);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(cs
														, "send log","Error"
														,JOptionPane.ERROR_MESSAGE);
		}
	}
	@Override
	public void run(){ //run 메소드의 시간에 대한 지연, 기다림을 적용할 수 있음, 우선 순위
		boolean isStop = false;
		try{
			run_start:
				while(!isStop){
					//300|하하|나신입| 하하가 나신입으로 바꼈습니다.
					String message = (String)ois.readObject();
					cs.jta_display.append(message+"\n");
					cs.jta_display.setCaretPosition(cs.jta_display.getDocument().getLength());
					StringTokenizer st = null;
					int protocol=0;
					if(message!=null){
						st = new StringTokenizer(message, "|");
						protocol = Integer.parseInt(st.nextToken());
				}
					switch(protocol){
					case Protocol.MESSAGE:{
						String nickName = st.nextToken();
						//String roomName = st.nextToken();
						String msg = st.nextToken();
						if(roomName!=null){
							for (ChattingServerThread cst : cs.chatList) {
							if (cst.roomName.equals(roomName)) {
								cst.send(Protocol.MESSAGE+"|"+nickName+"|"+msg);
							}else{
								return;
							}
						}
					}
					}break;
					case Protocol.CLOSE:{
						//Vector에서 그 사람 삭제
						//ChattingServerThread에서 this는 현재 접속한 사용자의 정보를 가지고 있고
						//cst는 현재 서버에 접속해 있는 사용자 하나하나를 구분 할 수 있따.
						cs.chatList.remove(this);
						
						String nickName = st.nextToken();
						String msg = "님 접속 종료!";
						broadCasting(Protocol.CLOSE+"|"+nickName+"|"+msg);
						break run_start;
					}
					case Protocol.CHANGE:{
						String nickName = st.nextToken();
						String afterName = st.nextToken();
						String msg = nickName+"님의 대화명이 "+afterName+"로 변경되었습니다.\n";
						chatName=afterName;
						broadCasting(Protocol.CHANGE+"|"+nickName+"|"+afterName+"|"+msg);
					}break;
					case Protocol.STATE_CHANGE:{
						String nickName = st.nextToken();
						String afterState = st.nextToken();
						state = afterState;
						broadCasting(Protocol.STATE_CHANGE+"|"+nickName+"|"+afterState);
					}break;
					case Protocol.WHISPER:{
						String nickName = st.nextToken(); //nickName
						String whisperName = st.nextToken(); //whisperName
						String msg = st.nextToken();
				/*		System.out.println("닉넴:"+nickName);
						System.out.println("귓말상대:"+whisperName);
						System.out.println("메세지"+msg);*/
					for (ChattingServerThread cst : cs.chatList) {
						if (cst.chatName.equals(whisperName)) {
							//상대방에게
							cst.send(Protocol.WHISPER + "|" + nickName + "|" + whisperName + "|" + msg);
							//나에게
							//this.send(Protocol.WHISPER + "|" + nickName + "|" + whisperName + "|" + msg);
							break;
						}
					}
					
					}break;
					case Protocol.ROOM_MAKE:{
						// 프로토콜|닉네임|방제목 받음
						String nickName = st.nextToken(); //닉네임 받기
						roomName = st.nextToken(); //방제목 받기
						broadCasting(Protocol.ROOM_MAKE+"|"+nickName+"|"+roomName);
						
					}break;
					case Protocol.ROOM_IN:{
						// 프로토콜|닉네임|방제목 받음
						String nickName = st.nextToken(); //닉네임 받기
						roomName = st.nextToken(); //방제목 받기
						
						broadCasting(Protocol.ROOM_IN+"|"+nickName+"|"+roomName);
						
					}break;
					}
			}
		}catch(Exception e){
			
		}
		
	}
	
}
