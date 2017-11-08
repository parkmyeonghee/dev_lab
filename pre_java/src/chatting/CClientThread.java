package ChattingProject;

import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;



public class CClientThread extends Thread{

//CC_Chatting �޴� ������	
	ChattingClient cc = null;
	CC_Login ccl=null;
	int oisState=0;    //0�� CC, 1�� CCL 
	
	public CClientThread(ChattingClient cc){
		this.cc=cc;
		oisState=0;
	}
	
	public CClientThread(CC_Login ccl){
		this.ccl=ccl;
		oisState=1;
	}
//cct�� run() - client�� ��⸸ ó�� 
public void run(){
	String note = null;
	boolean isStop = false;
	while(!isStop){
		try {
			if(oisState==0){
			note = (String)cc.ois.readObject();	
			System.out.println("cc ������");
			}else{
			note = (String)ccl.ois.readObject();
			System.out.println("ccl ������");
			}
			StringTokenizer st=null;
			int protocol =0;
			
			if(note !=null){
				st= new StringTokenizer(note,"|");
				protocol=Integer.parseInt(st.nextToken());
				//ccl.jta_test.append("cct�� �Ѿ�� note: "+note);
			} 
				switch (protocol) {
				case Protocol.LOG_IN_ROOMCHECK: {
					// ��ȭ�� ��������
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
					// ��ȭ�� ��������
					System.out.println("�α��� �������� �ޱ�");
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
					// ��ȭ�� ��������
					System.out.println("�游���:Ŭ���̾�Ʈ");
					String nickName = st.nextToken();
					String roomName = st.nextToken();
					// String state = st.nextToken();
					// nickName="test";
					Vector<String> v_name = new Vector<String>();
					Vector<String> v_room = new Vector<String>();
					v_name.add(nickName);
					v_room.add(roomName);
					// ä�ù� ��������Ʈ
					// this.cr=cw.cc.cr;
					ccl.cc.cr.dtm_userList.addRow(v_name);
					// ���ǿ� ���߰�
					ccl.cc.cw.dtm_room.addRow(v_room);
					ccl.cc.cw.jsp_room.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {

						@Override
						public void adjustmentValueChanged(AdjustmentEvent e) {
							JScrollBar src = (JScrollBar) e.getSource();
							src.setValue(src.getMaximum());
						}
					});
					// ä�ù� ��������Ʈ
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
					// ��ȭ�� ��������

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
					// ȭ�鿡 ���ϴ��� �����Ͽ����ϴ�. ����ϱ�
					ccl.cc.cr.jta_display.append("******" + nickName + "���� ���� �ϼ̽��ϴ�." + "******\n");
				}
					break;
				case Protocol.MESSAGE: {// �Ϲݴ�ȭ
					String nickName = st.nextToken();
					String msg = st.nextToken();
					ccl.cc.cr.jta_display.append("[" + nickName + "] " + msg + "\n");
					ccl.cc.cr.jta_display.setCaretPosition(ccl.cc.cr.jta_display.getDocument().getLength());
				}
					break;
				case Protocol.WHISPER: {// �Ӹ�
					String nickName = st.nextToken();
					String whisperName = st.nextToken();
					String msg = st.nextToken();
					// cc.cr.jta_display.append("[�ӼӸ�] "+"["+nickName+"]
					// "+msg+"\n");
					JOptionPane.showMessageDialog(cc, msg, nickName + "���� ���� �� �޼���", JOptionPane.INFORMATION_MESSAGE);
					ccl.cc.cr.jta_display.setCaretPosition(ccl.cc.cr.jta_display.getDocument().getLength());
				}
					break;
				case Protocol.CHANGE: {// ��ȭ����
					// ���� ��ȭ�� ��������
					String beforeName = st.nextToken(); // nickName
					// ���� ��ȭ�� ��������
					String afterName = st.nextToken(); // afterName
					// ���̺� ��ȭ�� �����ϱ�
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
					// �޽��� ����ϱ�
					ccl.cc.cr.jta_display.append(st.nextToken());
					// ä�� �˾�â Ÿ��Ʋ�� ��ȭ�� ����
					if (beforeName.equals(ccl.cc.cw.nickName)) {
						/// cw.setTitle(afterName+"���� ��ȭâ");
						ccl.cc.cw.nickName = afterName;

					}
				}
					break;
				case Protocol.STATE_CHANGE: {// ��ȭ����
					String nickName = st.nextToken();
					String afterState = st.nextToken(); // afterName
					// ���̺� ��ȭ�� �����ϱ�
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
					// �޽��� ����ϱ�
					ccl.cc.cr.jta_display.append(st.nextToken());
					// ä�� �˾�â Ÿ��Ʋ�� ��ȭ�� ����
				}
					break;
				case Protocol.CLOSE: {// ����
					String nickName = st.nextToken();
					String msg = st.nextToken();
					ccl.cc.cr.jta_display.append("[" + nickName + "] " + msg + "\n");
					ccl.cc.cr.jta_display.setCaretPosition(ccl.cc.cr.jta_display.getDocument().getLength());
					// ���̺��� ������ ����� �̸��� �������ش�.
					for (int i = 0; i < ccl.cc.cw.jt_room.getRowCount(); i++) {
						String delName = (String) ccl.cc.cw.dtm_room.getValueAt(i, 0);
						if (delName.equals(nickName)) {
							ccl.cc.cw.dtm_room.removeRow(i);
						}
					}

				}
					break;
				// �ߺ��˻� ���
				case Protocol.DUP: {
					String tf = st.nextToken();
					// �ߺ�ID ���� ���
					if (tf.equals("false")) {
						ccl.ccm.jf_duplication.dispose();
						JOptionPane.showMessageDialog(ccl.ccm, "��� ������ ID�Դϴ�.", "INFO",
								JOptionPane.INFORMATION_MESSAGE);
						ccl.ccm.jtf_signup_id.setText(ccl.ccm.dup_id);
					}
					// �ߺ�ID�� �̹� �����ϴ� ���
					else if (tf.equals("true")) {
						JOptionPane.showMessageDialog(ccl.ccm, "���� ID�� �̹� �����մϴ�.", "INFO",
								JOptionPane.INFORMATION_MESSAGE);
					}
				} // �ߺ��˻� ��� ��

				// ȸ������ ���
				case Protocol.JOIN: {
					String success = null;
					success = st.nextToken();
					if (success.equals("success")) {
						ccl.ccm.dispose();
						JOptionPane.showMessageDialog(ccl.ccm, "ȸ������ ����! ȯ���մϴ�!", "INFO",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}

				// �α��� ���
				case Protocol.LOGIN: {
					String tf = st.nextToken();
					if (tf.equals("false")) {
						ccl.l_fail();
					} else if (tf.equals("true")) {
						ccl.l_success();
					}
				} // �α��� ��� ��
				}// switch�� ��
			} catch (Exception e) {
			}
		}
	}
}
