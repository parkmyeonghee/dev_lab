package com.ch6;
/*************************************************************
 * �̺�Ʈ ó�� ����
 * 1.�̺�Ʈ �ҽ�(����ȸ)�� �̺�Ʈ �߻��� ������ �� �ִ� �������̽� ���� 
 * :�̺�Ʈ�� �Ͼ �̺�Ʈ �ҽ��� JVM�� ����
 * 2.�̺�Ʈ �߻��ÿ� ó���� ������ �ݹ�޼ҵ���
 * actionPerformed�޼ҵ忡 ������ �Ѵ�.
 * 3.�̺�Ʈ �ҽ�(����ȸ)�� �̺�Ʈ ó���� ����ϴ� Ŭ������ �����Ѵ�.
 *************************************************************/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

import com.ch5.BaseBallGame;


public class AddressBook implements ActionListener {//�̺�Ʈ �߻��� ������ �� �ִ� �������̽�
	static AddressBook adrbook=null;
	JFrame jf_book=new JFrame();
	AddressPopup apopup = new AddressPopup();
	JMenuBar jmb=new JMenuBar();
	JMenu jm_edit=new JMenu("����");
	JMenuItem jmi_search=new JMenuItem ("����ȸ");
	JMenuItem jmi_in=new JMenuItem ("�Է�");
	JMenuItem jmi_change=new JMenuItem ("����");
	JMenuItem jmi_delete=new JMenuItem ("����");
	JSeparator js_file =new JSeparator();
	JMenuItem jmi_exit=new JMenuItem ("����");
	JTextArea jta_display = new JTextArea("�١�þ��á١�");
	/**************************************************************
	 * AddressPopup���� Ȯ�� ��ư�� Ŭ������ �� ȣ�� �� �޼ҵ� ����
	 * AddressPopupŬ������ AddressBook��ü�� ���� �ּҹ����� �ʿ��ϴ�.
	 **************************************************************/

	public void initDisplay(){
		
		jmi_search.addActionListener(this);
		//this�� �̺�Ʈ ó���� ����ϴ� �̺�Ʈ �ڵ鷯 Ŭ�����̴�.
		//���⼭�� ���� actionPerformed�޼ҵ带 �����Ͽ����Ƿ� 
		//�� �ڽ��� �̺�Ʈ ó���� ����ϴ� Ŭ������ �ȴ�.

		jmi_in.addActionListener(this);
		jmi_change.addActionListener(this);
		jmi_delete.addActionListener(this);
		jmi_exit.addActionListener(this);
		jm_edit.add(jmi_search);
		jm_edit.add(jmi_in);
		jm_edit.add(jmi_change);
		jm_edit.add(jmi_delete);
		jm_edit.add(js_file);
		jm_edit.add(jmi_exit);
		jmb.add(jm_edit);
		jf_book.setJMenuBar(jmb);
		jf_book.add("Center",jta_display);
		String title="�̷� ���Ѱ��� ������ �ּҷ���";
		jf_book.setTitle(title);//������ �����ؼ� ���ش�.
		jf_book.setSize(500,550);//width,height
		jf_book.setVisible(true);
		
		
	}

	public void refresh(){
		jta_display.setText("���� ����ʹ�.");
		
	}
	public static void main(String[] args) {
		/*AddressBook abook= new AddressBook();
		abook.initDisplay();*/
		adrbook= new AddressBook();
		adrbook.initDisplay();
		
	

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//����ȸ|�Է�|����|����
		String jmi_label = e.getActionCommand();
		System.out.println("actionPerformed ȣ�� ����"+jmi_label+",�ֹ�:"+e.getSource());
		//����ȸ�� Ŭ���ߴ�?
		//if("����ȸ".equals(jmi_label))�� ������
		if(jmi_search==e.getSource()){
		//if("����ȸ".equals(jmi_label)){
			apopup.setTitle(jmi_label);
			apopup.initDisplay2(this);
		}
		else if(jmi_in==e.getSource()){
			apopup.setTitle(jmi_label);
			apopup.initDisplay2(this);
		}
		else if(jmi_change==e.getSource()){
			apopup.setTitle(jmi_label);
			apopup.initDisplay2(this);
		}
		else if(jmi_delete==e.getSource()){
			apopup.setTitle(jmi_label);
			apopup.initDisplay2(this);
		}
		else if(e.getSource()==jmi_exit){
			System.exit(0);
		}
		apopup.click();
	
	}

}
