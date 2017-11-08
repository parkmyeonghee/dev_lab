package com.ch6;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AddressPopup implements ActionListener{
	
	JFrame jf_popup=new JFrame();
	JButton jbt_new=new JButton("Ȯ�Τ�����");
	Font f =new Font("HY�߰��",Font.BOLD,14);
	String title=null;
	AddressBook abook=null;//�������� ����
	
	/**************************************************************
	  *�ڽ�â�� Ÿ��Ʋ ���� �����ϱ�
	  *title AddressBook.java���� �޾ƿ´�.
	  **************************************************************/
	public void setTitle(String title){
		this.title=title;
		
	}
public void initDisplay2(AddressBook CBX ){
	abook=CBX;
	jbt_new.addActionListener(this);
	jf_popup.add("South",jbt_new);//jframe�� ���������߾ӿ� ��ġ�� ������.
	jf_popup.setTitle(title);//������ �����ؼ� ���ش�.
	jf_popup.setSize(500,550);//width,height
	jf_popup.setVisible(true);
	jbt_new.setFont(f);
	jbt_new.setForeground(new Color(3,0,102));
	jf_popup.setTitle(title);
	
		
	
	
}
public void click(){
	jbt_new.addActionListener(this);
}
//annotation �̶�� �θ���. 
@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==jbt_new){
		abook.refresh();
		jf_popup.dispose();
}

}
	
/*
	public static void main(String[] args) {
		
		AddressPopup ap= new AddressPopup();
		ap.initDisplay();

	}
*/
}