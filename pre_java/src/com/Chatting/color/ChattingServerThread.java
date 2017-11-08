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
			//�Ķ���ͷ� �Ѿ�� ChattingServer�� �ٸ� �޼ҵ忡���� ����Ϸ���
			//�ɹ����� ���� �� �ʱ�ȭ�� �մϴ�.
			this.cs=cs;
			try {
				oos=new ObjectOutputStream(cs.Client.getOutputStream());
				ois= new ObjectInputStream(cs.Client.getInputStream());
				String message =(String)ois.readObject();	
				cs.jta_display.append(message+"\n");
				//�޽����� �߰� �ɶ� ���� ȭ�� �̵�ó���ϱ�
				cs.jta_display.setCaretPosition(cs.jta_display.getDocument().getLength());
				//100|dd|��������
				StringTokenizer st = new StringTokenizer(message,"|");
				st.nextToken();//100
				chatName=st.nextToken(); //�̸� �־��ذ�
				fontColor =st.nextToken();//��������-���
				//�ʰ� ���� ����� �� ��� ��ȭ�� �˾ƾ���
				/*
				 * ���� for��: �ڷᱸ���� �迭�� �ִ� ���� ��θ� ����ϰ� ������ ���.
				 * for([1]:[2]){
				 * [1]:�ڷ� �����϶��� ���׸� Ÿ���� �ۼ�
				 * 	:�迭�϶��� �迭 Ÿ���� �ۼ�
				 * [2]: �ڷᱸ�� Ȥ�� �迭�ȿ� ����� Ÿ���� �ۼ�
				 * }
				 */
/*				for(int i =0;i<cs.chatList.size();i++){
					ChattingServerThread cst = cs.chatList.get(i);
				}
*/				for(ChattingServerThread cst:cs.chatList){
					String currentName=cst.chatName;
					this.send(Protocol.ROON_IN+"|"+currentName+"|"+fontColor);
				//���� �� ����� �������� ��쿡�� for���� ���� �ʴ´�			
				}
				//����� �߰��ϱ�
				cs.chatList.add(this);
				this.broadCasting(message); //ó�� �̸�
			} catch (Exception e) {
				cs.jta_display.append("Exception:"+e.toString()+"\n");//����ó��
				}
		}
		//��ȭ�濡 ������ ��� ģ���鿡�� �޽��� ����ϱ�
		public void broadCasting(String message){
			for(ChattingServerThread cst :cs.chatList){
				cst.send(message); //�ٸ� ��� �� �� �ִ�.
			}
		}
		//Ŭ���̾�Ʈ�� ���� �о�� �޽����� ����Ѵ�.
		public void send(String message){
			try {
				oos.writeObject(message);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(cs
						,"send log","Error"
						,JOptionPane.ERROR_MESSAGE);
			}
		}
		public void run(){ //����,��ٸ�,�켱����
			boolean isStop = false;
			try {
				run_start:
				while(!isStop){
					//300 �̸��� �����Ϳ��� �ٲ۰ɷ� �ٲ��.
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
						String nickName= st.nextToken(); //������ ��
						//�޴� ���
						String otherName = st.nextToken();
						//�ӼӸ��� ������ �Ž���
						String fontColor =st.nextToken();
						String msg1 = st.nextToken();
						//chatList���� ��� �̸��� cst�� chatName�� ���Ͽ� ������ 
						//�� ���Ը� �޽����� �����մϴ�.
						for(ChattingServerThread cst:cs.chatList){
							if(otherName.equals(cst.chatName)){
								//��뿡�� ���� �޽���
								cst.send(Protocol.WHISPER+"|"+
										nickName+"|"+
										otherName+"|"+
											msg1+"|"+fontColor);
								//������ ���� �޽���
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
						String msg =nickName+"���� ��ȭ����"+afterName+"���κ���";
						chatName=afterName;
						broadCasting(Protocol.CHANGE+"|"+
													afterName+"|"+
														msg+"|"+fontColor); //��ο��� �Ѹ��� ���� ��
					
					}break;
					case Protocol.ROON_OUT:{//500|oo
						String name=st.nextToken();
						String fontColor =st.nextToken();
						//vector���� �� ����� �����Ѵ�.
						//ChattingServerThread���� this�� ���� ������ ����ڿ� ���� ������
						//������ �ְ� cst�� ���� ������ ������ �ִ� ����� �ϳ��ϳ��� ������
						//�� �ִ�.
						cs.chatList.remove(this);
						//�ٸ� ������Ե� �˸���.
						this.broadCasting(Protocol.ROON_OUT+"|"+name+"|"+fontColor);
						//�� �̻� ������������ ���� ����� �ƴϹǷ� while�� ���� Ż���Ų��.
						break run_start;
						}/////////end of ������ Ȥ�� ����
					}/////////end of switch
				}/////////////end of while
			} catch (Exception e) {
			}
			
		}
}
