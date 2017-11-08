package com.Chatting.color;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

import com.sun.glass.events.WindowEvent;

import jdk.nashorn.internal.scripts.JO;

public class ChattingClient extends JFrame implements ActionListener {
	//�����
	Socket socket =null;
	//��ȭ���� ���� ���� ����
	String nickName = null;
	//ȭ�� ��ġ ����
	JPanel jp_first = new JPanel();
	//JTextArea���� �κ� ���� ������ �Ұ� �մϴ�
	// ���� �ؽ�Ʈ�θ� ���
	// �̹����� ó�� �� �� ����.
	//�ؽ�Ʈ�� �׸��� �������� ó���ϴ� Ŭ������ �ʿ�
	//JTextArea jta_display = new JTextArea();
	StyledDocument sd_display = new DefaultStyledDocument(new StyleContext());
	//�۲ð� ��Ʈũ�� ������ ��
	JTextPane jtp_display = new  JTextPane(sd_display);
	//�̹����� ������ �� �ִ� ģ����
	JScrollPane jsp_display= new JScrollPane(jtp_display,
			JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
			,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JPanel jp_frist_south = new JPanel();
	JTextField jtf_msg = new JTextField();
	JButton jbtn_send = new JButton("����");
	JPanel jp_second = new JPanel();
	String cols[] = {"��ȭ��"};
	String data[][] = new String[0][1];
	DefaultTableModel dtm_room = new DefaultTableModel(data,cols);
	JTable jt_room = new JTable(dtm_room);
	JScrollPane jsp_room = new JScrollPane(jt_room,
			JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
			,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JPanel jp_second_south= new JPanel();
	JButton jbtn_whisper = new JButton("�ӼӸ�");
	JButton jbtn_change = new JButton("��ȭ����");
	JButton jbtn_roomout = new JButton("������");
	JButton jbtn_close = new JButton("����");
	JButton jbtn_fontColor= new JButton("���ڻ�");
	JButton jbtn_fontStyle= new JButton("��Ʈ��Ÿ��");
	JFrame jf_fontColor = null;
	//����ڰ� ������ ���� ������ ���� ���� ���� - ������ ������ �� ���������� ����
	String fontColor ="0";//����ڰ� ������ �������� ���
	
	ObjectInputStream ois = null; //���
	ObjectOutputStream oos = null; //���ϱ�
	//ȭ�� ��ġ ��
	
	//������
	//1)ȭ��ó��
	//2)�������ϻ���
	//3)Ŭ���̾�Ʈ ���������� �޾ƿ´�.
	//2)������ �����ϰ� start() ȣ��
	public ChattingClient(){
		//â�ݱ� ��ư�� Ŭ������ ��
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we){
				exitChat();
				System.exit(0);
			}
		});
	nickName = JOptionPane.showInputDialog("��ȭ���� �Է��ϼ���:");
	try {
		socket = new Socket("192.168.0.31",3000);
		oos= new ObjectOutputStream(socket.getOutputStream());
		ois= new ObjectInputStream(socket.getInputStream());
		//������ �޽��� �����ϱ�
		oos.writeObject(Protocol.ROON_IN+"|"+nickName+"|"+fontColor);
		ChattingClientThread cct = new ChattingClientThread(this);
		cct.start();
	} catch (Exception e) {
		e.printStackTrace();
		}
	}
	public void exitChat(){
		try {
			oos.writeObject(Protocol.ROON_OUT+"|"+this.nickName+"|"+fontColor);
		} catch (Exception e) {
		}
	}
	//ȭ�� ó����
	public void initDisplay(){
		jbtn_change.addActionListener(this);
		jbtn_send.addActionListener(this);
		jbtn_whisper.addActionListener(this);
		jbtn_close.addActionListener(this);
		jbtn_fontColor.addActionListener(this);
		jbtn_fontStyle.addActionListener(this);
		jbtn_roomout.addActionListener(this);
		jtf_msg.addActionListener(this);//�̺�Ʈ ���� (jvm)-actionPerformed
		this.setLayout(new GridLayout(1,2));
		jp_first.setLayout(new BorderLayout());
		
		jp_frist_south.setLayout(new BorderLayout());
		jp_frist_south.add("Center",jtf_msg);
		jp_frist_south.add("East",jbtn_send);
		
		jp_first.add("Center", jsp_display);
		jp_first.add("South", jp_frist_south);
		
		jp_second.setLayout(new BorderLayout());
		jp_second_south.setLayout(new GridLayout(3,2));
		jp_second_south.add(jbtn_fontColor);
		jp_second_south.add(jbtn_fontStyle);
		jp_second_south.add(jbtn_whisper);
		jp_second_south.add(jbtn_change);
		jp_second_south.add(jbtn_roomout);
		jp_second_south.add(jbtn_close);
		jp_second.add("Center", jsp_room);
		jp_second.add("South", jp_second_south);
		
		
		this.add(jp_first);
		this.add(jp_second);
		this.setTitle(nickName+"���� ��ȭâ");
		this.setSize(500,500);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource(); //�̺�Ʈ�� ������ ������Ʈ�� �ּҹ����� ���
		String msg= jtf_msg.getText();//����ڰ� �Է��� �޽����� ��´�.
		if(obj==jtf_msg || obj==jbtn_send){
		try {
			oos.writeObject(Protocol.MESSAGE+"|"+
					nickName+"|"+
					msg+"|"+fontColor);
		} catch (Exception e) {
			}
		jtf_msg.setText(""); //�޽��� ������ �ʱ�ȭ
		}///////////end of �޽��� ����
		else if(obj==jbtn_fontColor){
			jf_fontColor = new JFrame();
			JColorChooser jcc_color= new JColorChooser();
			ColorSelectionModel  model=
					jcc_color.getSelectionModel();
			ChangeListener listener =
					new ChangeListener(){ //�ѹ��� ó���ϱ� ���ؼ�!

						@Override
						public void stateChanged(ChangeEvent e) {
							Color forColor = jcc_color.getColor();
							fontColor=String.valueOf(forColor.getRGB());
							System.out.println("����ڰ� ������ ����"+fontColor);
						}
			};
			model.addChangeListener(listener);
			jf_fontColor.add("Center",jcc_color);
			jf_fontColor.setSize(600,500);
			jf_fontColor.setVisible(true);
		}
		else if(obj==jbtn_fontStyle){
			
		}
	//��ȭ�� �����ư Ŭ��������
	else if(obj==jbtn_change){
		//������ ��ȭ�� �Է¹ޱ�
		String afterName =JOptionPane.showInputDialog("������ ��ȭ���� �Է¼���");
		//��ȭ���� ���̰ų� ���ڿ��� ���̰� 1���� ������ ó������ �ٽ�
		if(afterName==null||afterName.trim().length()<1){
			JOptionPane.showMessageDialog(this
													,"������ ��ȭ���� �Է��ϼ���"
														,"INFO"
														,JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		//�޽��� ����
		try {
			oos.writeObject(Protocol.CHANGE+"|"+
					nickName+"|"+
					afterName+"|"+
					nickName+"���� ��ȭ����"+afterName+"���� ����"+"|"+fontColor);
		} catch (Exception e) {
		}//////end of ��ȭ�� ���� ��
	}else if(obj==jbtn_whisper){
		//�ӼӸ� ��븦 ����(���̺�) �ϱ�
		int row=jt_room.getSelectedRow();
		//��븦 �������� �ʾҴ�? - �ӼӸ� ��븦 �����ϼ��� �޽���
		if(row==-1){
			JOptionPane.showMessageDialog(this
					,"�ӼӸ� ��븦 �����ϼ���"
					,"INFO"
					,JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		//��븦 �����ߴ�? -��
		else{
			//������ �̸�
			//������ ����� �̸��� ���̺��� �о�ͼ� name������ ���
			String name=(String)dtm_room.getValueAt(row, 0);
		
		//���� ������ ��밡 �� �ڽ��̸� �ٸ� ��븦 �����ϼ���
		//�޽��� ó���ϱ�
		if(nickName.equals(name)){
			JOptionPane.showMessageDialog(this
					,"�ٸ� ��븦 �����ϼ���"
					,"INFO"
					,JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		// �ӼӸ� �Է¹ޱ�
		String msg1 =
				JOptionPane.showInputDialog
				(name+"�Կ��� ���� �޽��� �Է��ϼ���");
		//�ӼӸ� �����ϱ�
		try {
			oos.writeObject(Protocol.WHISPER+"|"+
									nickName+"|"+
									name+"|"+
									msg1+"|"+fontColor);
		} catch (Exception e) {
		}
		}////end of else
	}///////end of  �ӼӸ�
	else if(obj==jbtn_close || obj==jbtn_roomout){
		exitChat();
		System.exit(0);
	}///////////////end of �޽��� ����
}/////////end of actionperformed
	public static void main(String[] args) {
		ChattingClient cc =
				new ChattingClient();
		cc.initDisplay();
	}

}
