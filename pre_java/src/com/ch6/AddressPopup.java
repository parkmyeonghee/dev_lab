package com.ch6;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AddressPopup implements ActionListener{
	
	JFrame jf_popup=new JFrame();
	JButton jbt_new=new JButton("확인ㅇㅅㅇ");
	Font f =new Font("HY견고딕",Font.BOLD,14);
	String title=null;
	AddressBook abook=null;//전역변수 설정
	
	/**************************************************************
	  *자식창에 타이틀 문자 설정하기
	  *title AddressBook.java에서 받아온다.
	  **************************************************************/
	public void setTitle(String title){
		this.title=title;
		
	}
public void initDisplay2(AddressBook CBX ){
	abook=CBX;
	jbt_new.addActionListener(this);
	jf_popup.add("South",jbt_new);//jframe은 동서남북중앙에 배치가 가능함.
	jf_popup.setTitle(title);//변수를 선언해서 해준다.
	jf_popup.setSize(500,550);//width,height
	jf_popup.setVisible(true);
	jbt_new.setFont(f);
	jbt_new.setForeground(new Color(3,0,102));
	jf_popup.setTitle(title);
	
		
	
	
}
public void click(){
	jbt_new.addActionListener(this);
}
//annotation 이라고 부른다. 
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