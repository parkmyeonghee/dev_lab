package com.ch6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddressBookEvent implements ActionListener{
	AddressBook2 aBook2=null;
	
	public AddressBookEvent(AddressBook2 aBook2){
		this.aBook2=aBook2;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//상세조회|입력|수정|삭제
		//String jmi_label = null;
		
		String jmi_label = e.getActionCommand();//상세조회|입력|수정|삭제
		System.out.println("actionPerformed 호출 성공===>"+jmi_label+",주번:"+e.getSource());
		//상세조회를 클릭했니?
		//if("상세조회".equals(jmi_label)){
	
		if(aBook2.jmi_specific==e.getSource()){	
		//if(jmi_label.equals("상세조회")){	
			System.out.println("상세조회~~~~");
			aBook2.apopup.setTitle(jmi_label);
			aBook2.apopup.initDisplay2();
		}
		//입력을 클릭했니?
		else if(aBook2.jmi_input==e.getSource()){	
		//if(jmi_label.equals("상세조회")){	
			System.out.println("입력~~~~");
			aBook2.apopup.setTitle(jmi_label);
			aBook2.apopup.initDisplay2();
		}		
		//수정을 클릭했니?
		
		//삭제를 클릭했니?
		//너 종료메뉴아이템을 클릭했니?
		else if(e.getSource()==aBook2){
			System.exit(0);//가상머신하고 연결고리 끊긴다.
		}
	}
	
	
	
	

}
