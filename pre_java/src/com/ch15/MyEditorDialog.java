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
	JLabel jlb_msg= new JLabel("저장하시겠습니까?");
	JPanel jp_south= new JPanel();
	JButton jbtn_yes= new JButton("예");
	JButton jbtn_no = new JButton("아니오");
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
			//저장처리 메소드 호출하기
			myEditor.save();
			myEditor.jta_display.setText("");
			dispose();
		}
		else if(obj==jbtn_no){
			dispose(); //자기 자신을 닫을 떄
			//System.exit(0); 관련된 화면 모두 닫을 떄
		}
	}
}
