package com.sungjuk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SungjukEvent implements ActionListener {

	SungjukView sv;
public SungjukEvent(SungjukView sv){
	this.sv = sv;
}
   
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj==sv.jbtn_create){
			sv.sl.getDB();
			sv.sl.getTable();
     		
		}	
		if(obj==sv.jbtn_process){
		    sv.sl.chongJum();
		    sv.sl.avg();
		    sv.sl.hakJum();
		    sv.sl.sukCha();
		
		}
		if(obj==sv.jbtn_sum){
			sv.sl.chongJum();
		}
		if(obj==sv.jbtn_avg){
			sv.sl.avg();
		}
		if(obj==sv.jbtn_hak){
			sv.sl.hakJum();
		}
		if(obj==sv.jbtn_rank){
			sv.sl.sukCha();
		}
		else if(obj==sv.jbtn_exit){
			System.exit(0);
		}
		
			
		
	}
}
