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
		//����ȸ|�Է�|����|����
		//String jmi_label = null;
		
		String jmi_label = e.getActionCommand();//����ȸ|�Է�|����|����
		System.out.println("actionPerformed ȣ�� ����===>"+jmi_label+",�ֹ�:"+e.getSource());
		//����ȸ�� Ŭ���ߴ�?
		//if("����ȸ".equals(jmi_label)){
	
		if(aBook2.jmi_specific==e.getSource()){	
		//if(jmi_label.equals("����ȸ")){	
			System.out.println("����ȸ~~~~");
			aBook2.apopup.setTitle(jmi_label);
			aBook2.apopup.initDisplay2();
		}
		//�Է��� Ŭ���ߴ�?
		else if(aBook2.jmi_input==e.getSource()){	
		//if(jmi_label.equals("����ȸ")){	
			System.out.println("�Է�~~~~");
			aBook2.apopup.setTitle(jmi_label);
			aBook2.apopup.initDisplay2();
		}		
		//������ Ŭ���ߴ�?
		
		//������ Ŭ���ߴ�?
		//�� ����޴��������� Ŭ���ߴ�?
		else if(e.getSource()==aBook2){
			System.exit(0);//����ӽ��ϰ� ����� �����.
		}
	}
	
	
	
	

}
