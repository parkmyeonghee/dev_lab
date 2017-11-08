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
		//�Ķ���ͷ� �Ѿ�� chattingserver�� �ٸ� �޼ҵ忡���� ����ϱ�����
		//������� ���� �� �ʱ�ȭ���մϴ�.
		this.cs=cs;
		try {
			oos = new ObjectOutputStream(cs.client.getOutputStream());
			ois = new ObjectInputStream(cs.client.getInputStream());
			
			String message = (String)ois.readObject();
			cs.jta_display.append(message+"\n");
			
			//�޽����� �߰� �ɶ����� ȭ�� �̵�ó���ϱ�!
			cs.jta_display.setCaretPosition(cs.jta_display.getDocument().getLength());
			
			StringTokenizer st = new StringTokenizer(message, "|");
			st.nextToken();
			chatName = st.nextToken();
			//�ʰ� ���� ����� �� ��� ��ȭ�� �˾ƾ���.
			for(ChattingServerThread cst:cs.chatList){
				String currentName = cst.chatName;
				String currentState = cst.state;
				this.send(Protocol.LOG_IN+"|"+currentName+"|"+currentState);
			}
			for(ChattingServerThread cst:cs.chatList){
				String roomName = cst.roomName;
				this.send(Protocol.LOG_IN_ROOMCHECK+"|"+roomName);
			}
			//����� �߰��ϱ�
			cs.chatList.add(this);
			this.broadCasting(message);
		} catch (Exception e) {
			cs.jta_display.append("Exception : "+e.toString()+"\n");
		}
	}
	//��ȭ�濡 ������ ��� ģ���鿡��	 �޽��� ����ϱ�
	public void broadCasting(String msg){
		synchronized(this){
			for(ChattingServerThread cst:cs.chatList){ //chatList�� Ŭ���̾�Ʈ �������
				cst.send(msg);
			}
		}
	}
/********************************************************************************************
 * 	������ ����
 * for([1]:[2]){}
 * �ڷᱸ���� �迭�� �ִ� ��� ������ ����ϰ� ������ ���
 * [1]:�ڷᱸ���϶��� ���׸� Ÿ��, �迭�϶��� �迭 Ÿ�� �ۼ�
 * [2]:�ڷᱸ�� Ȥ�� �迭Ÿ�� �ۼ�
 ********************************************************************************************/
/*	for(int i=0; i<cs.chatList.size();i++){
		ChattingServerThread cst = cs.chatList.get(i);
	}*/
	
	//Ŭ���̾�Ʈ�� ���� �о�� �޽��� ����Ѵ�.
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
	public void run(){ //run �޼ҵ��� �ð��� ���� ����, ��ٸ��� ������ �� ����, �켱 ����
		boolean isStop = false;
		try{
			run_start:
				while(!isStop){
					//300|����|������| ���ϰ� ���������� �ٲ����ϴ�.
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
						//Vector���� �� ��� ����
						//ChattingServerThread���� this�� ���� ������ ������� ������ ������ �ְ�
						//cst�� ���� ������ ������ �ִ� ����� �ϳ��ϳ��� ���� �� �� �ֵ�.
						cs.chatList.remove(this);
						
						String nickName = st.nextToken();
						String msg = "�� ���� ����!";
						broadCasting(Protocol.CLOSE+"|"+nickName+"|"+msg);
						break run_start;
					}
					case Protocol.CHANGE:{
						String nickName = st.nextToken();
						String afterName = st.nextToken();
						String msg = nickName+"���� ��ȭ���� "+afterName+"�� ����Ǿ����ϴ�.\n";
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
				/*		System.out.println("�г�:"+nickName);
						System.out.println("�Ӹ����:"+whisperName);
						System.out.println("�޼���"+msg);*/
					for (ChattingServerThread cst : cs.chatList) {
						if (cst.chatName.equals(whisperName)) {
							//���濡��
							cst.send(Protocol.WHISPER + "|" + nickName + "|" + whisperName + "|" + msg);
							//������
							//this.send(Protocol.WHISPER + "|" + nickName + "|" + whisperName + "|" + msg);
							break;
						}
					}
					
					}break;
					case Protocol.ROOM_MAKE:{
						// ��������|�г���|������ ����
						String nickName = st.nextToken(); //�г��� �ޱ�
						roomName = st.nextToken(); //������ �ޱ�
						broadCasting(Protocol.ROOM_MAKE+"|"+nickName+"|"+roomName);
						
					}break;
					case Protocol.ROOM_IN:{
						// ��������|�г���|������ ����
						String nickName = st.nextToken(); //�г��� �ޱ�
						roomName = st.nextToken(); //������ �ޱ�
						
						broadCasting(Protocol.ROOM_IN+"|"+nickName+"|"+roomName);
						
					}break;
					}
			}
		}catch(Exception e){
			
		}
		
	}
	
}
