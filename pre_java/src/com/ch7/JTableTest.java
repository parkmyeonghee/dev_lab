package com.ch7;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableTest extends JFrame implements ActionListener {
	String cols[]={"��ȭ��","����"};
	String datas[][]=new String[0][2];
	//JTable�� �����Ͽ� ���
	//JTable �����ͼ��� �����ϴ� Ŭ�����̴�.
	//DefaultTableModel�� ���̺� ������ ���´�.
	//:�ο�� �÷����� �����Ǿ� �ִ�.
	DefaultTableModel dtm_room=new DefaultTableModel(datas,cols);
	JTable jt_room=new JTable(dtm_room);//�����̴�,���̴�,ȭ�鸸
	JScrollPane jsp_room=
			new JScrollPane(jt_room
					,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
					,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JButton jbtn_ok=new JButton("Ȯ��");
	public JTableTest(){
		jbtn_ok.addActionListener(this);
		Vector<String>v_room=new Vector<String>();
		v_room.add("����");
		v_room.add("23");
		dtm_room.addRow(v_room);
		v_room=new Vector<String>();
			v_room.add("þ");
			v_room.add("25");
		dtm_room.addRow(v_room);
		v_room=new Vector<String>();
		v_room.add("ȫ��");
		v_room.add("24");
		dtm_room.addRow(v_room);
		System.out.println(dtm_room.getRowCount());//3
		this.add("Center",jsp_room);
		this.add("South",jbtn_ok);
		this.add("Center",jsp_room);
		this.setSize(300,200);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new  JTableTest();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jbtn_ok){
			for(int i=0;i<dtm_room.getRowCount();i++){
				if(jt_room.isRowSelected(i))
				{
					String name=(String)dtm_room.getValueAt(i, 0);
					String age=(String)dtm_room.getValueAt(i, 1);
					int i_age=
							Integer.parseInt(
							dtm_room.getValueAt(i, 1).toString());
					System.out.println(name);
					System.out.println(i_age);
				}
			}
			
		}
		
	}

}
