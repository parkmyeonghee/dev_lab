package com.sungjuk;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class SungjukView {
	String path = this.getClass().getResource("").getPath();
	
	SungjukLogic sl = new SungjukLogic(this);
	SungjukEvent se = new SungjukEvent(this);
		
	JTable jt_sungjuk = new JTable();
	JFrame jf_sungjuk = new JFrame();
	JPanel jp_north = new JPanel();
	JPanel jp_center = new JPanel();
	JPanel jp_south = new JPanel();
	JLabel jlb_inwon = new JLabel("인원수"); //import!!!
	JTextField jtf_inwon = new JTextField(5);
	JButton jbtn_create = new JButton("만들기");
	JButton jbtn_sum= new JButton("총점");
	JButton jbtn_avg= new JButton("평균");
	JButton jbtn_hak= new JButton("학점");
	JButton jbtn_rank= new JButton("석차");
	JButton jbtn_process = new JButton("처리");
	JButton jbtn_exit = new JButton("종료");
	 Font f =new Font("HY견고딕",Font.BOLD,14);
	
public void initDisplay(){

		jf_sungjuk.setTitle("성적 처리");
		jf_sungjuk.setSize(500,300);
		jf_sungjuk.setVisible(true);	
		jf_sungjuk.add("North", jp_north);
		jf_sungjuk.add("Center", jp_center);
		jf_sungjuk.add("South", jp_south);
		jp_north.add(jlb_inwon);
		jp_north.add(jtf_inwon);
		jp_north.add(jbtn_create);
		jp_south.add(jbtn_process);
		jp_south.add(jbtn_sum);
		jp_south.add(jbtn_avg);
		jp_south.add(jbtn_hak);
		jp_south.add(jbtn_rank);
		jp_south.add(jbtn_exit);
		
		
		jbtn_sum.setBackground(new Color(255,167,167));
		jbtn_avg.setBackground(new Color(255,167,167));
		jbtn_hak.setBackground(new Color(255,167,167));
		jbtn_rank.setBackground(new Color(255,167,167));
		jbtn_create.setBackground(new Color(144,225,225));
		jbtn_process.setBackground(new Color(219,165,229));
		jbtn_exit.setBackground(new Color(88,229,92));
		
		jbtn_create.addActionListener(se);
		jbtn_exit.addActionListener(se);	
		jbtn_process.addActionListener(se);
		jbtn_sum.addActionListener(se);
		jbtn_avg.addActionListener(se);
		jbtn_hak.addActionListener(se);
		jbtn_rank.addActionListener(se);
		
		Image img= new ImageIcon(path+"cbx.jpg").getImage();
		 jf_sungjuk.setIconImage(img);
		
	}	


	
public static void main(String[] args) {
		SungjukView sv = new SungjukView();
		sv.initDisplay();
	}



}
