package com.ch5;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JButtonArray {


	public static void main(String[] args) {
		JFrame jf= new JFrame();
		jf.setLayout(new GridLayout(1,3));
		JButton jbtns[]= new JButton[3];
		String jbtn_label[]={"1","2","3"};
		for(int i=0;i<jbtns.length;i++){
			jbtns[i]=new JButton(jbtn_label[i]);
			jf.add(jbtns[i]);
		}
		jf.setSize(300, 200);
		jf.setVisible(true);

	}

}
