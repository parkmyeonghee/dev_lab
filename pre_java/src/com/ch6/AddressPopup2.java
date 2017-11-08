package com.ch6;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class AddressPopup2 implements ActionListener{

	JFrame jf_popup = new JFrame();
	JButton jbt_confirm = new JButton("Ȯ��");
	String title = null;
	AddressBook2 aBook = null;
	public AddressPopup2(AddressBook2 aBook) {
		this.aBook = aBook;
	}
	//jbt_confirm.addActionListener(this);
	/**********************************************************
	 * �ڽ�â�� Ÿ��Ʋ ���� �����ϱ�
	 * @param title AddressBook.java���� �޾� �ɴϴ�.
	 **********************************************************/
	public void setTitle(String title){
		this.title=title;
	}
	public void initDisplay2(){
		System.out.println("initDisplay2");
		jbt_confirm.addActionListener(this);
		jf_popup.setTitle(title);
		jf_popup.setSize(500,300);	
		jf_popup.setVisible(true);
		//String title = "����ȸ";
		
		jf_popup.add("South",jbt_confirm);
	}
	//annotation
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jbt_confirm){
			aBook.refresh();
			jf_popup.dispose();
		}
	}
}
