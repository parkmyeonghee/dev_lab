package com.ch15;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyEditorDialog extends JDialog implements ActionListener {
	JLabel jlb_msg= new JLabel("�����Ͻðڽ��ϱ�?");
	JPanel jp_south= new JPanel();
	JButton jbtn_yes= new JButton("��");
	JButton jbtn_no = new JButton("�ƴϿ�");
	MyEditor myEditor= null;
	
	public MyEditorDialog(){}
	
	public MyEditorDialog(MyEditor myEditor){
		this.myEditor = myEditor;
	}
	public void initDisplay(){
		jbtn_yes.addActionListener(this);
		jbtn_no.addActionListener(this);
		this.setLayout(new BorderLayout());
		jp_south.add(jbtn_yes);
		jp_south.add(jbtn_no);
		this.add("Center",jlb_msg);
		this.add("South",jp_south);
		this.add(jlb_msg);
		this.setSize(200,90);
		this.setVisible(true);
	}
	public static void main(String args[]){
		MyEditorDialog md = new MyEditorDialog();
		md.initDisplay();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==jbtn_yes){
			//����ó�� �޼ҵ� ȣ���ϱ�
			myEditor.save();
			myEditor.jta_display.setText("");
			dispose();
		}
		else if(obj==jbtn_no){
			dispose(); //�ڱ� �ڽ��� ���� ��
			//System.exit(0); ���õ� ȭ�� ��� ���� ��
		}
	}
}
