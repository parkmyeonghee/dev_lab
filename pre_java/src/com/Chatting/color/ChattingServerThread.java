package com.Chatting.color;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class ChattingServerThread extends Thread {
		ChattingServer cs = null;
		ObjectInputStream ois = null;
		ObjectOutputStream oos =null;
		String chatName =null;
		String fontColor ="0";
		
		public ChattingServerThread(ChattingServer cs) {
			//파라미터로 넘어온 ChattingServer를 다른 메소드에서도 사용하려면
			//맴버변수 선언 후 초기화를 합니다.
			this.cs=cs;
			try {
				oos=new ObjectOutputStream(cs.Client.getOutputStream());
				ois= new ObjectInputStream(cs.Client.getInputStream());
				String message =(String)ois.readObject();	
				cs.jta_display.append(message+"\n");
				//메시지가 추가 될때 마다 화면 이동처리하기
				cs.jta_display.setCaretPosition(cs.jta_display.getDocument().getLength());
				//100|dd|색상정보
				StringTokenizer st = new StringTokenizer(message,"|");
				st.nextToken();//100
				chatName=st.nextToken(); //이름 넣어준거
				fontColor =st.nextToken();//색상정보-상수
				//늦게 들어온 사람도 앞 사람 대화명 알아야함
				/*
				 * 개선 for문: 자료구조나 배열에 있는 정보 모두를 사용하고 싶을때 사용.
				 * for([1]:[2]){
				 * [1]:자료 구조일때는 제네릭 타입을 작성
				 * 	:배열일때는 배열 타입을 작성
				 * [2]: 자료구조 혹은 배열안에 저장된 타입을 작성
				 * }
				 */
/*				for(int i =0;i<cs.chatList.size();i++){
					ChattingServerThread cst = cs.chatList.get(i);
				}
*/				for(ChattingServerThread cst:cs.chatList){
					String currentName=cst.chatName;
					this.send(Protocol.ROON_IN+"|"+currentName+"|"+fontColor);
				//최초 한 사람이 접속했을 경우에는 for문이 돌지 않는다			
				}
				//사용자 추가하기
				cs.chatList.add(this);
				this.broadCasting(message); //처음 이름
			} catch (Exception e) {
				cs.jta_display.append("Exception:"+e.toString()+"\n");//예외처리
				}
		}
		//대화방에 참여한 모든 친구들에게 메시지 출력하기
		public void broadCasting(String message){
			for(ChattingServerThread cst :cs.chatList){
				cst.send(message); //다른 사람 일 수 있다.
			}
		}
		//클라이언트로 부터 읽어온 메시지를 출력한다.
		public void send(String message){
			try {
				oos.writeObject(message);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(cs
						,"send log","Error"
						,JOptionPane.ERROR_MESSAGE);
			}
		}
		public void run(){ //지연,기다림,우선순위
			boolean isStop = false;
			try {
				run_start:
				while(!isStop){
					//300 이름이 원래것에서 바꾼걸로 바뀐다.
					String message =(String)ois.readObject();
					cs.jta_display.append(message+"\n");
					cs.jta_display.setCaretPosition(cs.jta_display.getDocument().getLength());
					StringTokenizer st =null;
					int protocol=0;
					if(message!=null){
						st = new StringTokenizer(message,"|");
						protocol=Integer.parseInt(st.nextToken());
					}
					switch(protocol){
					case Protocol.MESSAGE:{
						String nickName =st.nextToken();
						String msg=st.nextToken();
						String fontColor =st.nextToken();
						broadCasting(Protocol.MESSAGE+"|"+
													nickName+"|"+
														msg+"|"+fontColor);
					}break;
					case Protocol.WHISPER:{
						String nickName= st.nextToken(); //보내는 이
						//받는 사람
						String otherName = st.nextToken();
						//귓속말로 보내진 매시지
						String fontColor =st.nextToken();
						String msg1 = st.nextToken();
						//chatList에서 상대 이름과 cst의 chatName을 비교하여 같으면 
						//그 에게만 메시지를 전송합니다.
						for(ChattingServerThread cst:cs.chatList){
							if(otherName.equals(cst.chatName)){
								//상대에게 가는 메시지
								cst.send(Protocol.WHISPER+"|"+
										nickName+"|"+
										otherName+"|"+
											msg1+"|"+fontColor);
								//나한테 오는 메시지
								this.send(Protocol.WHISPER+"|"+
										nickName+"|"+
										otherName+"|"+
											msg1+"|"+fontColor);
								
							}break;
						}
					}
					
					case Protocol.CHANGE:{
						String nickName =st.nextToken();
						String afterName=st.nextToken();
						String fontColor =st.nextToken();
						String msg =nickName+"님의 대화명이"+afterName+"으로변경";
						chatName=afterName;
						broadCasting(Protocol.CHANGE+"|"+
													afterName+"|"+
														msg+"|"+fontColor); //모두에게 뿌릴때 쓰는 것
					
					}break;
					case Protocol.ROON_OUT:{//500|oo
						String name=st.nextToken();
						String fontColor =st.nextToken();
						//vector에서 그 사람을 삭제한다.
						//ChattingServerThread에서 this는 현재 접속한 사용자에 대한 정보를
						//가지고 있고 cst는 현재 서버에 접속해 있는 사용자 하나하나를 구분할
						//수 있다.
						cs.chatList.remove(this);
						//다른 사람에게도 알린다.
						this.broadCasting(Protocol.ROON_OUT+"|"+name+"|"+fontColor);
						//더 이상 서버스레드의 관리 대상이 아니므로 while문 블럭을 탈출시킨다.
						break run_start;
						}/////////end of 나가기 혹은 종료
					}/////////end of switch
				}/////////////end of while
			} catch (Exception e) {
			}
			
		}
}
