package com.mvc.address;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

import com.vo.AddressVO;

public class AddressBook extends JFrame implements ActionListener {
	//�����
	static AddressBook  abook = null;
	ModifyDialog 	md 			= new ModifyDialog();
	JToolBar        jt_btn		= new JToolBar();
	JButton 		jbtn_ins 	= new JButton("�Է�");
	JButton 		jbtn_upd 	= new JButton("����");
	JButton 		jbtn_del 	= new JButton("����");
	JButton 		jbtn_sel 	= new JButton("����ȸ");
	JButton 		jbtn_all 	= new JButton("��ü��ȸ");
	AddressVO		raVO		= new AddressVO();
	//�̹��� ��θ� ���� ���� ����
	String path = "src//com//images//";
	//���̺� ��� �ʱ�ȭ�ϱ�
	String cols[] = {"���̵�","�̸�","��ȭ��ȣ","�ּ�"};
	String data[][] = new String[0][4];
	//���̺� �߰��ϱ�
	DefaultTableModel dtm_abook = new DefaultTableModel(data,cols);
	JTable 			jtb_abook   = new JTable(dtm_abook);
	JScrollPane		jsp_abook   = new JScrollPane(jtb_abook);
	//������
	public AddressBook(){
	//�����ڿ��� �޼ҵ带 ȣ���� ��� �� �޼ҵ� ���̿��� ������ ������ ���� ��
	//�ִ�.(ä��������Ʈ)	
		//initDisplay();
		//refreshData();
	}
	//���� ��ư Ŭ���� �۾� 
	public void addrDel(){
	//����ڰ� ȭ�鿡�� ������ �ο��� �ε��� ���
		int index[] = jtb_abook.getSelectedRows();
/*		for(int i=0;i<index.length;i++){
			System.out.println(index[i]);
		}*/
		if(index.length == 0){//�� ������ �ο츦 �������� �ʾҾ�
			JOptionPane.showMessageDialog(this
					, "������ �����͸� �����ϼ���."
					, "Error"
					, JOptionPane.ERROR_MESSAGE);
			return;//addrDel�޼ҵ� Ż��
		}
		else{//������ �ο츦 ���������� �������ٲ�
			AddressVO paVO = new AddressVO();
			AddressVO raVO = new AddressVO();
			AddressController aCtrl = new AddressController();
			for(int i=0;i<dtm_abook.getRowCount();i++){
				if(jtb_abook.isRowSelected(i)){
					Integer id = Integer.parseInt(dtm_abook.getValueAt(i, 0).toString());
					paVO.setId(id);
					paVO.setCommand("delete");
					raVO = aCtrl.send(paVO);
				}
			}//////////// end of for
			refreshData();
		}//////////////// end of else
	}//////////////////// end of addrDel
	
	//���ΰ�ħ �����ϱ�
	public void refreshData(){
		System.out.println("refreshData ȣ�� ����");
		//������ ��ȸ�� ������ �ʱ�ȭ�ϱ�
		while(dtm_abook.getRowCount() > 0){
			dtm_abook.removeRow(0);
		}
		//insert here - MVC���� �ǽ�
		AddressController aCtrl = new AddressController();
		AddressVO paVO = new AddressVO();
		List<AddressVO> addrList = aCtrl.sendALL(paVO);
		Iterator<AddressVO> iter = addrList.iterator();
		//��ȸ�� �����Ͱ� ����?
		if((addrList == null) || (addrList.size() < 1)){
			JOptionPane.showMessageDialog(this
					                    , "��ȸ�� �����Ͱ� �����ϴ�."
					                    , "Info"
					                    , JOptionPane.INFORMATION_MESSAGE); 
		}
		//��ȸ�� �����Ͱ� ������?
		else{
			for(int i=0;i<addrList.size();i++){
				AddressVO aVO = addrList.get(i);
				Vector oneRow = new Vector();
				oneRow.add(aVO.getId());
				oneRow.add(aVO.getName());
				oneRow.add(aVO.getHp());
				oneRow.add(aVO.getAddress());
				dtm_abook.addRow(oneRow);
			}
		}
		//System.out.println(addrList.size());
	}
	//ȭ��ó����
	public void initDisplay(){
		jbtn_ins.addActionListener(this);
		jbtn_upd.addActionListener(this);
		jbtn_del.addActionListener(this);
		jbtn_sel.addActionListener(this);
		jbtn_all.addActionListener(this);
		//������ ������ ����
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent ae){
				System.out.println("������ ����");
				System.exit(0);
			}
		});
		jbtn_ins.setIcon(new ImageIcon(path+"new.gif"));
		jbtn_upd.setIcon(new ImageIcon(path+"update.gif"));
		jbtn_del.setIcon(new ImageIcon(path+"delete.gif"));
		jbtn_sel.setIcon(new ImageIcon(path+"detail.gif"));
		jt_btn.add(jbtn_ins);
		jt_btn.add(jbtn_upd);
		jt_btn.add(jbtn_del);
		jt_btn.add(jbtn_sel);
		jt_btn.add(jbtn_all);
		this.add("North",jt_btn);
		this.add("Center", jsp_abook);
		this.setTitle("MVC������ ������ �ּҷ� 1.0");
		this.setSize(500, 400);
		this.setVisible(true);
		refreshData();
	}
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		abook = new AddressBook();
		abook.initDisplay();
		//md.addrIns();//�Է¹�ư�� Ŭ������ ��
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//�� �Է¹�ư Ŭ���ߴ�? ��
		if(jbtn_ins == e.getSource()){//��
			md.set("�Է�",null,abook,true);
			md.setVisible(true);
		}
		//�� ������ư Ŭ���ߴ�?
		else if(jbtn_upd == e.getSource()){//��
			int index[] = jtb_abook.getSelectedRows();
			if(index.length == 0){//�� ������ �ο츦 �������� �ʾҾ�
				JOptionPane.showMessageDialog(this
						, "������ �����͸� �����ϼ���."
						, "Error"
						, JOptionPane.ERROR_MESSAGE);
				return;//addrDel�޼ҵ� Ż��
			}
			else if(index.length == 1){
				AddressController aCtrl = new AddressController();
				AddressVO pVO = new AddressVO();
				AddressVO raVO = null;
				//����ڰ� ������ �ο��� id��(?)�� ���� �޼ҵ� ȣ��
				if(jtb_abook.isRowSelected(index[0])){
					Integer id = 
					Integer.parseInt(dtm_abook.getValueAt(index[0], 0).toString());
					pVO.setCommand("select");
					pVO.setId(id);
					raVO = aCtrl.send(pVO);
					System.out.println("��ȸ�� �̸�:"+raVO.getName());
				}
				md.set("����",raVO,abook,true);
				md.setVisible(true);
			}
			else{//���� ���� �� �� �� ���� �����ض�~~~~
				JOptionPane.showMessageDialog(this
						, "�Ѱ��� �����ϼ���."
						, "Error"
						, JOptionPane.ERROR_MESSAGE);
				return;//addrDel�޼ҵ� Ż��				
			}
		}
		//�� ����ȸ��ư�� Ŭ���ߴ�?
		else if(jbtn_sel == e.getSource()){//��
			md.set("����ȸ",raVO,null,false);
			md.setVisible(true);
		}	
		//�� ������ư�� Ŭ���ߴ�?
		else if(jbtn_del == e.getSource()){//��
			addrDel();
		}	
		//�� ��ü��ȸ Ŭ���ߴ�?
		else if(jbtn_all == e.getSource()){
			refreshData();
		}
	}

}
