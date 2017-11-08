package com.sungjuk;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;


public class Sungjuk_Table implements ActionListener {
	
	JFrame j_table = new JFrame("성적처리");
	JButton jbt_new=new JButton("만들기");
	JButton jbt_hand=new JButton("처리");
	JButton jbt_exit=new JButton("종료");
	JTextArea jta_display=new JTextArea();
	JScrollPane jsp_display = new JScrollPane(jta_display);
	 JPanel jp_center = new JPanel();
	 JPanel jp_north = new JPanel();
	JTable jj_table = new JTable();
	String name[] ={"이름","오라클","자바","HTML","총점","평균","학점","석차"};
	Object data[]=new Object[7];
	
	
	public void initDisplay2(){
		
		j_table.setSize(500,550);
		j_table.setVisible(true);
		jp_center.add("Center",jsp_display);
		jp_north.add(jbt_new);
		jp_north.add(jbt_hand);
		jp_north.add(jbt_exit);
		
	}
	public static void main(String[] args) {
		Sungjuk_Table stable= new Sungjuk_Table();
		stable.initDisplay2();

}
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
