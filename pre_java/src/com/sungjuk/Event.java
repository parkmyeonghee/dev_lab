package com.sungjuk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Event implements ActionListener {
	View sView =null;
	Logic sLogic =null;
public Event(View sView){
	this.sView=sView;
}
public Event(View sView,Logic sLogic){
	this.sView=sView;
	this.sLogic=sLogic;
}
	@Override
	public void actionPerformed(ActionEvent e) {
Object obj = e.getSource();
		
		if(obj==sView.jbtn_create){
			
		sView.getTable();
     		
		}	
		if(obj==sView.jbtn_process){
		sLogic.doProcess();
		
		}else if(obj==sView.jbtn_exit){
			System.exit(0);
		}
		
			
		
	}

		
	}

