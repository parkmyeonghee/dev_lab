package ChattingProject;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



public class ClientRoom extends JPanel implements ActionListener{
			//�����
			//��ȭ�� ���� ����
			String nickName = null; 
			String roomName = null;
			ChattingClient cc= null;
			
			
			//ȭ���ġ ����//
			JPanel jp_first = new JPanel();
			JTextArea jta_display = new JTextArea();
			JScrollPane jsp_display = new JScrollPane(jta_display
																  ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
																  ,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			
			JPanel jp_first_south = new JPanel();
			JTextField jtf_msg = new JTextField();
			JButton jbtn_send = new JButton("����");
			
			JPanel jp_second = new JPanel();
			String userCols[]={"��ȭ��","���主"};
			String userData[][]= new String[0][2];
			DefaultTableModel dtm_userList = new DefaultTableModel(userData,userCols);
			JTable jt_userList = new JTable(dtm_userList);
			JScrollPane jsp_userList = new JScrollPane(jt_userList
					,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
					,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			
			JPanel jp_second_south = new JPanel();
			JButton jbtn_whisper = new JButton("���� ������");
			JButton jbtn_change = new JButton("��ȭ����");
			JButton jbtn_roomout = new JButton("������");
			JButton jbtn_close = new JButton("����");
			
			//ȭ���ġ ��//
			
			//������
			//1)ȭ��ó��
			//2)�������� ����
			//3)Ŭ���̾�Ʈ ���������� �޾ƿ´�
			//4)������ �����ϰ� start() ȣ��
			public ClientRoom(){}
			public ClientRoom(ChattingClient cc){
				   	//�游����Ҷ� ���̸���������
					this.cc=cc;
					this.nickName=cc.nickName;
					//nickName= JOptionPane.showInputDialog("��ȭ���� �Է��ϼ���");
					
					//jta_display.setLineWrap(true); //�ڵ��ٹٲ�?
					jbtn_send.addActionListener(this);
					jbtn_roomout.addActionListener(this);
					jbtn_change.addActionListener(this);
					jbtn_whisper.addActionListener(this);
					jbtn_close.addActionListener(this);
					jtf_msg.addActionListener(this); //�̺�Ʈ ����(JVM) -  �ݹ��Լ��� actionPerformed ȣ��
					
					this.setLayout(new GridLayout(1, 2));
					jp_first.setLayout(new BorderLayout());  //�������� ��ġ ���ؼ�, ����Ʈ�� �÷ο췹�̾ƿ���
					
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
				Object obj = e.getSource(); //�̺�Ʈ ������ ������Ʈ �ּҹ���
				String msg = jtf_msg.getText();
				if(obj==jtf_msg || obj==jbtn_send){
					try {
						cc.oos.writeObject(Protocol.MESSAGE+"|"+nickName+"|"+msg);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					jtf_msg.setText("");
				}//end �޼��� ����
				//��ȭ�� �����ư Ŭ������ ��
				else if(obj==jbtn_change){
					//������ ��ȭ�� �Է¹ޱ�
					String afterName=JOptionPane.showInputDialog("������ ��ȭ�� �Է����ּ���!");
					//��ȭ���� ���̰ų� ���ڿ��� ���̰� 1���� ������ ó������ �ٽ�
					if(afterName==null||afterName.trim().length()<1){
						JOptionPane.showMessageDialog(this
								, "��ĭ �ȵſ�~"
								,"INFO"
								,JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					//�޽��� ����
					try {
						//300|����|������| ���ϰ� ���������� �ٲ����ϴ�. �� ������ ����
						cc.oos.writeObject(Protocol.CHANGE+"|"+nickName+"|"+afterName+"|"+nickName+"�� ��ȭ����"
								+afterName+"�� ����\n");
						
						this.nickName=afterName;
//						nickName=afterName;
						
					} catch (Exception e2) {
					}
				}
				else if(obj==jbtn_whisper){
					//�ӼӸ��� ��� ��������
					int row=jt_userList.getSelectedRow();
				
					if(row == -1){
						JOptionPane.showMessageDialog(this, "�ӼӸ� ��븦 �����ϼ���",
								"INFO",JOptionPane.INFORMATION_MESSAGE);
						return;
					}else{
						String wisperName=(String)jt_userList.getValueAt(jt_userList.getSelectedRow(), 0);
						if(wisperName.equals(nickName)){
							JOptionPane.showMessageDialog(this, "������ �ٸ����",
									"INFO",JOptionPane.INFORMATION_MESSAGE);
							return;
						}
						msg= JOptionPane.showInputDialog("�Ҹ� ����");
						try {
							cc.oos.writeObject(Protocol.WHISPER+"|"+nickName+"|"+wisperName+"|"+msg);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
					
					//��ȭ���� ���̰ų� ���ڿ��� ���̰� 1���� ������ ó������ �ٽ�

					//�޽��� ����
				
				} //�ӼӸ� ��
				else if(obj==jbtn_roomout){
					try {
						cc.oos.writeObject(Protocol.ROOM_OUT+"|"+nickName);
						cc.cw.jbtn_makeRoom.setEnabled(true);
						cc.jp.setSelectedIndex(0);
					} catch (Exception e2) {
					}
				} //�泪���� ��
				else if(obj==jbtn_close){
					exitChat();
					System.exit(0);
				}
			}


}
