package com.mvc.address;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.vo.AddressVO;

public class ModifyDialog extends JDialog implements ActionListener {
	//�����
	static AddressBook abook =null;
	// �Է�, ����, ��ȸ ȭ�鿡 ����� ������Ʈ�� �����մϴ�.
	private JLabel labelName;
	private JTextField txtName;
	private JLabel labelAddr;
	private JTextField txtAddress;
	private JLabel labelTel;
	private JTextField txtTel;
	private JLabel labelRel;
	private JTextField txtRelationShip;
	private JLabel labelGender;
	private JComboBox comboGender;
	private JLabel labelBirth;
	private JTextField txtBirthDay;
	private JLabel labelComment;
	private JTextArea txtComment;
	private JLabel labelRegDate;
	private JTextField txtRegDate;
	private JScrollPane scrollPane;
	private JScrollPane scrollComment;
	private JPanel panel;
	private JPanel panelBtn;
	private Font font;	
	JButton jbtn_ok = new JButton("Ȯ��");
	JButton jbtn_cancel = new JButton("���");
	//AddressBook���� �Է�, ����, ����ȸ �̺�Ʈ�� �߻����� �� set�޼ҵ��� �ι�°
	//�Ķ���ͷ� �Ѿ�� �ּҹ����� ���� ���� ����
	AddressVO raVO = null;
/*	public void addrIns(){
		System.out.println("ModifyDialog addrIns() ȣ�⼺��");
		AddressVO avo = new AddressVO();
		avo.setCommand("insert");
		AddressController ac= new AddressController();
		ac.send(avo);
	}*/
	//������
	public ModifyDialog(){
		initDisplay();
	}
	//ȭ��ó��
	public void initDisplay(){
		// ������ Į������ ������ ���̺��� �����մϴ�.
		labelName = new JLabel("�̸�(�ʼ��Է�) ");
		labelAddr = new JLabel("�ּ� ");
		labelTel = new JLabel("��ȭ��ȣ ");
		labelRel = new JLabel("���� ");
		labelGender = new JLabel("���� ");
		labelBirth = new JLabel("����(YYYYMMDD) ");
		labelComment = new JLabel("��� ");
		labelRegDate = new JLabel("������ ");

		labelName.setFont(font);
		labelAddr.setFont(font);
		labelTel.setFont(font);
		labelRel.setFont(font);
		labelGender.setFont(font);
		labelBirth.setFont(font);
		labelComment.setFont(font);
		labelRegDate.setFont(font);

		// �����͸� ������ �ؽ�Ʈ �ʵ���� �����մϴ�.
		txtName = new JTextField(20);
		//txtName.setEditable(false);
		txtAddress = new JTextField(20);
		txtTel = new JTextField(20);
		txtRelationShip = new JTextField(20);
		txtBirthDay = new JTextField(20);
		txtComment = new JTextArea(3, 20);
		scrollComment = new JScrollPane(txtComment);
		txtRegDate = new JTextField(20);

		String [] genderList= {"����", "����"};
		comboGender = new JComboBox(genderList);	
		
		panel = new JPanel();
		// Layout manager�� ������� �ʰ� ���� ������Ʈ���� ��ġ�� �����ݴϴ�.
		panel.setLayout(null);

		labelName.setBounds(20,20, 100,20);
		txtName.setBounds(120,20, 150,20);

		labelAddr.setBounds(20, 45, 100,20);
		txtAddress.setBounds(120,45, 150,20);

		labelTel.setBounds(20,70, 100,20);
		txtTel.setBounds(120,70, 150, 20);

		labelRel.setBounds(20,95, 100,20);
		txtRelationShip.setBounds(120,95, 150,20);

		labelGender.setBounds(20,120, 100,20);
		comboGender.setBounds(120, 120, 150,20);
  		comboGender.setFont(new java.awt.Font("����", 0, 12));

		labelBirth.setBounds(20,145, 100,20);
		txtBirthDay.setBounds(120,145, 150,20);

		labelComment.setBounds(20, 170, 100,20);
		scrollComment.setBounds(120,170, 250,60);

		labelRegDate.setBounds(20, 235, 100,20);
		txtRegDate.setBounds(120,235, 150,20);
		txtRegDate.setEditable(false);

		// ������Ʈ���� �гο� ���Դϴ�.
		panel.add(labelName);
		panel.add(txtName);
		panel.add(labelAddr);
		panel.add(txtAddress);
		panel.add(labelTel);
		panel.add(txtTel);
		panel.add(labelRel);
		panel.add(txtRelationShip);
		panel.add(labelGender);
		panel.add(comboGender);
		panel.add(labelBirth);
		panel.add(txtBirthDay);
		panel.add(labelComment);
		panel.add(scrollComment);
		panel.add(labelRegDate);
		panel.add(txtRegDate);		
		jbtn_ok.addActionListener(this);
		panelBtn= new JPanel();
		panelBtn.add(jbtn_ok);
		panelBtn.add(jbtn_cancel);
		scrollPane = new JScrollPane(panel);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		getContentPane().add(panelBtn, BorderLayout.SOUTH);		
		this.setSize(400, 400);
		//this.setVisible(true);
	}
	public static void main(String[] args) {
		//new ModifyDialog();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(jbtn_ok == e.getSource()){
			//insert here - AddressController �� send()ȣ���ϱ�
			AddressVO avo = new AddressVO();
			AddressController ac= new AddressController();
			AddressVO rVO = null;
			if(raVO == null){//�� �Է��̴�
				System.out.println("�Է� ȣ��");
				avo.setCommand("insert");
				avo.setName(getName());//avo.setName(txtName.getText());
				avo.setAddress(getAddress());
				avo.setBirthday(getBirth());
				avo.setComments(getComment());
				avo.setGender(getGender());
				avo.setHp(getHp());
				avo.setRelationship(getRelation());
				avo.setRegisterdate(getRegDate());
				rVO = ac.send(avo);
			}
			else{//�� �����̴�
				System.out.println("���� ȣ��");
				avo.setCommand("update");
				//AddressVO rVO = ac.send(avo);
				avo.setId(raVO.getId());
				avo.setName(getName());
				avo.setAddress(getAddress());
				avo.setBirthday(getBirth());
				avo.setComments(getComment());
				avo.setGender(getGender());
				avo.setHp(getHp());
				avo.setRelationship(getRelation());
				avo.setRegisterdate(getRegDate());
				rVO = ac.send(avo); //���ÿ� �� �ɸ��� �����ϳ��� �ɸ��⶧����
				
				
			}
			if(rVO.getResult()==1){
				JOptionPane.showMessageDialog(this
						                    , "��������"
						                    , "INFO", JOptionPane.INFORMATION_MESSAGE);
				//�θ�â ���ΰ�ħ ó���ϱ�
				abook.refreshData();
				//�ڽ�â �ݱ�
				this.dispose();
			}
			else{
				JOptionPane.showMessageDialog(this
	                    , "��������"
	                    , "Error", JOptionPane.ERROR_MESSAGE);				
			}
		}
	}
	
	public void setValue(AddressVO raVO){
		//�Է��� ���� ������ ���� - ��� ���� ""�� �����մϴ�.
		if(raVO == null){
			//�Է°� �ʱ�ȭ ó��
			setName("");
			setAddress("");
			setHp("");
			setBirth("");
			setRelation("");
			setComment("");		
	
		}
		//����ȸ, �����ô� raVO���� ���� ������ �����մϴ�.
		else{
			//DB���� ������ �� �ʱ�ȭ ó��
			setName(raVO.getName());
			setAddress(raVO.getAddress());
			setHp(raVO.getHp());
			setBirth(raVO.getBirthday());
			setRelation(raVO.getRelationship());
			setComment(raVO.getComments());
			setRegDate(raVO.getRegisterdate());
			setGender(raVO.getGender());
		}
	}
	
	/***********************************************************************************
	 * 
	 * @param title �ڽ�â�� ����
	 * @param raVO  �Է��϶��� null, ������ ���� �ּҹ���
	 * @param abook �θ�â�� �ּҹ���
	 * @param isEditable �ڽ�â�� ������Ʈ�鿡 ���� Ȱ��ȭ ����
	 ***********************************************************************************/
	public void set(String title
			      , AddressVO raVO
			      , AddressBook abook
			      , boolean isEditable) {
		//���������� ����� raVO�� �Ķ���ͷ� �Ѿ�� raVO�� �ּҹ����� ����ϴ�.
		this.raVO = raVO;
		this.setEditable(isEditable);
		this.setTitle(title);
		this.abook = abook;
		this.setValue(raVO);
	}
	//�� �ؽ�Ʈ �ʵ忡 ������ �����ϰų� �о���� getter/setter
	//�޼ҵ带 ������ ������.
	//�Է��̰ų� ������ ���� get�޼ҵ带 ȣ���մϴ�.
	//����ȸ�϶��� set�޼ҵ带 ȣ���մϴ�.
	//�����϶� ������ �Է��� ������ �Ѹ� ���� set�޼ҵ� ȣ���Ѵ�.
	public String getName(){ return txtName.getText();};
	public void setName(String strName) { txtName.setText(strName);};
	public String getAddress(){ return txtAddress.getText();};
	public void setAddress(String strAddress) { txtAddress.setText(strAddress);};
	public String getHp(){ return txtTel.getText();};
	public void setHp(String strHp) { txtTel.setText(strHp);};	
	public String getRelation(){ return txtRelationShip.getText();};
	public void setRelation(String strRelation) { txtRelationShip.setText(strRelation);};		
	public String getGender(){ 
		if(comboGender.getSelectedItem().equals("����")){
			return "1";
		}else{
			return "0";
		}
	};
	public void setGender(String strGender) { 
		if("1".equals(strGender)) comboGender.setSelectedItem("����");
		else comboGender.setSelectedItem("����");
	};
	public String getBirth(){ return txtBirthDay.getText();};
	public void setBirth(String strBirth) { txtBirthDay.setText(strBirth);};
	public String getComment(){ return txtComment.getText();};
	public void setComment(String strComment) { txtComment.setText(strComment);};
	public String getRegDate(){ return txtRegDate.getText();};
	public void setRegDate(String strRegDate) { txtRegDate.setText(strRegDate);};
	//TextField�� ���ؼ� Ȱ��ȭ Ȥ�� ��Ȱ�� ó��
	//�Է�, �����ô� �÷����� ���� �����ϵ���
	//����ȸ�ô� �÷����� ���� �Ұ����ϵ��� ó��
	public void setEditable(boolean isFlag){
		txtName.setEditable(isFlag);
		txtAddress.setEditable(isFlag);
		txtTel.setEditable(isFlag);
		txtRelationShip.setEditable(isFlag);
		txtBirthDay.setEditable(isFlag);
		txtComment.setEditable(isFlag);
		comboGender.setEnabled(isFlag);
	}
}













