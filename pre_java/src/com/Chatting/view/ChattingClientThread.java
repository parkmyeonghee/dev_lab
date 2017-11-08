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
		//run�޼ҵ�� �������� ���ϴ°��� ��´�.
		//Ŭ���̾�Ʈ�� ���ϱ�� �̺�Ʈ(ChattingClient)���� ó��
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
					//��ȭ�� ��������
					System.out.println("�α��� �������� �ޱ�");
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
					//��ȭ�� ��������
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
					//��ȭ�� ��������
					System.out.println("�游���:Ŭ���̾�Ʈ");
					String nickName = st.nextToken();
					String roomName = st.nextToken();
					//String state = st.nextToken();
					//nickName="test";
					Vector<String> v_name=new Vector<String>();
					Vector<String> v_room=new Vector<String>();
					v_name.add(nickName);
					v_room.add(roomName);
					//ä�ù� ��������Ʈ
					//this.cr=cw.cc.cr;
					cc.cr.dtm_userList.addRow(v_name);
					//���ǿ� ���߰�
					cc.cw.dtm_room.addRow(v_room);
					cc.cw.jsp_room.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
						
						@Override
						public void adjustmentValueChanged(AdjustmentEvent e) {
							JScrollBar src = (JScrollBar) e.getSource();
							src.setValue(src.getMaximum());
						}
					});
					//ä�ù� ��������Ʈ
					cc.cr.jsp_userList.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
						
						@Override
						public void adjustmentValueChanged(AdjustmentEvent e) {
							JScrollBar src = (JScrollBar) e.getSource();
							src.setValue(src.getMaximum());
						}
					});
					
				}break;
				case Protocol.ROOM_IN :{
					//��ȭ�� ��������
					
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
					//ȭ�鿡 ���ϴ��� �����Ͽ����ϴ�. ����ϱ�
					cc.cr.jta_display.append("******"+nickName+"���� ���� �ϼ̽��ϴ�."+"******\n");
				}break;
				case Protocol.MESSAGE:{//�Ϲݴ�ȭ
					String nickName = st.nextToken();
					String msg = st.nextToken();
					cc.cr.jta_display.append("["+nickName+"] "+msg+"\n");
					cc.cr.jta_display.setCaretPosition(cc.cr.jta_display.getDocument().getLength());
				}break;
				case Protocol.WHISPER:{//�Ӹ�
					String nickName = st.nextToken();
					String whisperName = st.nextToken();
					String msg = st.nextToken();
					//cc.cr.jta_display.append("[�ӼӸ�] "+"["+nickName+"] "+msg+"\n");
					JOptionPane.showMessageDialog(cc, msg, nickName+"���� ���� �� �޼���", JOptionPane.INFORMATION_MESSAGE);
					cc.cr.jta_display.setCaretPosition(cc.cr.jta_display.getDocument().getLength());
				}break;
				case Protocol.CHANGE:{//��ȭ����
					//���� ��ȭ�� ��������
					String beforeName = st.nextToken();  //nickName
					//���� ��ȭ�� ��������
					String afterName = st.nextToken();    //afterName
					//���̺� ��ȭ�� �����ϱ�
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
					//�޽��� ����ϱ�
					cc.cr.jta_display.append(st.nextToken());
					//ä�� �˾�â Ÿ��Ʋ�� ��ȭ�� ����
					if(beforeName.equals(cc.cw.nickName)){
						///cw.setTitle(afterName+"���� ��ȭâ");
						cc.cw.nickName=afterName;
						
					}
				}break;
				case Protocol.STATE_CHANGE:{//��ȭ����
					String nickName = st.nextToken();
					String afterState = st.nextToken();    //afterName
					//���̺� ��ȭ�� �����ϱ�
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
					//�޽��� ����ϱ�
					cc.cr.jta_display.append(st.nextToken());
					//ä�� �˾�â Ÿ��Ʋ�� ��ȭ�� ����
					}break;
				case Protocol.CLOSE:{//����
					String nickName = st.nextToken();
					String msg = st.nextToken();
					cc.cr.jta_display.append("["+nickName+"] "+msg+"\n");
					cc.cr.jta_display.setCaretPosition(cc.cr.jta_display.getDocument().getLength());
					//���̺��� ������ ����� �̸��� �������ش�.
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
