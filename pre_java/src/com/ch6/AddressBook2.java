package com.ch6;
/**********************************************
 * �̺�Ʈ ó�� ����
 * 1.�̺�Ʈ �ҽ�(����ȸ)�� �̺�Ʈ �߻���
 * ������ ��  �ִ� �������̽� ���� 
 * :�̺�Ʈ�� �Ͼ �̺�Ʈ �ҽ��� JVM�� ����
 * 2.�̺�Ʈ �߻��ÿ� ó���� ������
 *   �ݹ�޼ҵ��� actionPerformed�޼ҵ忡 ������
 *   �Ѵ�.
 * 3.�̺�Ʈ �ҽ�(����ȸ)�� �̺�Ʈ ó���� ����ϴ�
 *   Ŭ������ �����Ѵ�.  
 *********************************************/
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

public class AddressBook2 {
	AddressBookEvent aEvent=new AddressBookEvent(this);
	
	JFrame jf_book = new JFrame(); //ȭ�����
	AddressPopup2 apopup = new AddressPopup2(this);
	JMenuBar jmb = new JMenuBar();
	
	JMenu jm_file = new JMenu("����");
	JMenuItem jmi_specific = new JMenuItem("����ȸ");
	JMenuItem jmi_input = new JMenuItem("�Է�");
	JMenuItem jmi_modify = new JMenuItem("����");
	JMenuItem jmi_delete = new JMenuItem("����");
	JSeparator js_file = new JSeparator();
	JMenuItem jmi_exit = new JMenuItem("����");
	
	JTextArea jta_display = new JTextArea("�׽�Ʈ");
	/********************************************************************************
	 * AddressPopup���� Ȯ�� ��ư�� Ŭ������ �� ȣ�� �� �޼ҵ� ����
	 * AddressPopupŬ������ AddressBook2��ü�� ���� �ּҹ����� �ʿ��մϴ�.
	 *******************************************************************************/
	public void refresh(){
		jta_display.setText("���� ���ΰ�ħ �Ǿ���.");
	}
	
	public void initDisplay(){
		java.lang.System.out.println("initDisplay ȣ�⼺��");
		//this�� �̺�Ʈ ó���� ����ϴ� �̺�Ʈ �ڵ鷯 Ŭ�����̴�.
		//���⼭�� ���� actionPerformed�޼ҵ带 �����Ͽ����Ƿ�
		//�� �ڽ��� �̺�Ʈ ó���� ����ϴ� Ŭ������ �˴ϴ�.
		jmi_specific.addActionListener(aEvent);
		jmi_input.addActionListener(aEvent);
		jmi_exit.addActionListener(aEvent);
		//�޴� �߰� - 2)ȭ�鿡 �ٿ��ֱ�
		jm_file.add(jmi_specific);
		jm_file.add(jmi_input);
		jm_file.add(jmi_modify);
		jm_file.add(jmi_delete);	
		jm_file.add(js_file);
		jm_file.add(jmi_exit);
		jmb.add(jm_file);
		jf_book.setJMenuBar(jmb);//����ȭ�鿡 �޴��� ������
		jf_book.add("Center",jta_display);
		String title = "�ּҷ�2";
		jf_book.setTitle(title);		
		jf_book.setSize(500,300);//�޼ҵ� �ۿ��� ������ ȭ�鿡 ũ��ο�	
		jf_book.setVisible(true);//���̰� �ض�?
		//��ȣ �ȿ��� boolean�� �־�� �Ѵٰ� �����Ǿ� ����.
		

		
		
		
					
		//3)
		//�̺�Ʈ �ҽ��� �̺�Ʈ ó���� ����ϴ� �ڵ鷯 Ŭ������ ����
//		jmi_specific.addActionListener(this);//�̺�Ʈ�ҽ���.�ڵ鷯Ŭ����(�ּҹ���);		
	
		}

	public static void main(String[] args) {
		AddressBook2 aEvent = new AddressBook2();
		aEvent.initDisplay();
	}

	

}












