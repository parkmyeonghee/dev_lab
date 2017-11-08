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
	//선언부
	static AddressBook abook =null;
	// 입력, 수정, 조회 화면에 사용할 컴포넌트를 선언합니다.
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
	JButton jbtn_ok = new JButton("확인");
	JButton jbtn_cancel = new JButton("취소");
	//AddressBook에서 입력, 수정, 상세조회 이벤트가 발생했을 때 set메소드의 두번째
	//파라미터로 넘어온 주소번지를 담을 변수 선언
	AddressVO raVO = null;
/*	public void addrIns(){
		System.out.println("ModifyDialog addrIns() 호출성공");
		AddressVO avo = new AddressVO();
		avo.setCommand("insert");
		AddressController ac= new AddressController();
		ac.send(avo);
	}*/
	//생성자
	public ModifyDialog(){
		initDisplay();
	}
	//화면처리
	public void initDisplay(){
		// 데이터 칼럼명을 보여줄 레이블을 정의합니다.
		labelName = new JLabel("이름(필수입력) ");
		labelAddr = new JLabel("주소 ");
		labelTel = new JLabel("전화번호 ");
		labelRel = new JLabel("관계 ");
		labelGender = new JLabel("성별 ");
		labelBirth = new JLabel("생일(YYYYMMDD) ");
		labelComment = new JLabel("비고 ");
		labelRegDate = new JLabel("수정일 ");

		labelName.setFont(font);
		labelAddr.setFont(font);
		labelTel.setFont(font);
		labelRel.setFont(font);
		labelGender.setFont(font);
		labelBirth.setFont(font);
		labelComment.setFont(font);
		labelRegDate.setFont(font);

		// 데이터를 보여줄 텍스트 필드등을 정의합니다.
		txtName = new JTextField(20);
		//txtName.setEditable(false);
		txtAddress = new JTextField(20);
		txtTel = new JTextField(20);
		txtRelationShip = new JTextField(20);
		txtBirthDay = new JTextField(20);
		txtComment = new JTextArea(3, 20);
		scrollComment = new JScrollPane(txtComment);
		txtRegDate = new JTextField(20);

		String [] genderList= {"남자", "여자"};
		comboGender = new JComboBox(genderList);	
		
		panel = new JPanel();
		// Layout manager를 사용하지 않고 직접 컴포넌트들의 위치를 정해줍니다.
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
  		comboGender.setFont(new java.awt.Font("굴림", 0, 12));

		labelBirth.setBounds(20,145, 100,20);
		txtBirthDay.setBounds(120,145, 150,20);

		labelComment.setBounds(20, 170, 100,20);
		scrollComment.setBounds(120,170, 250,60);

		labelRegDate.setBounds(20, 235, 100,20);
		txtRegDate.setBounds(120,235, 150,20);
		txtRegDate.setEditable(false);

		// 컴포넌트들을 패널에 붙입니다.
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
			//insert here - AddressController 의 send()호출하기
			AddressVO avo = new AddressVO();
			AddressController ac= new AddressController();
			AddressVO rVO = null;
			if(raVO == null){//너 입력이니
				System.out.println("입력 호출");
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
			else{//너 수정이니
				System.out.println("수정 호출");
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
				rVO = ac.send(avo); //동시에 안 걸리고 둘중하나만 걸리기때문에
				
				
			}
			if(rVO.getResult()==1){
				JOptionPane.showMessageDialog(this
						                    , "수정성공"
						                    , "INFO", JOptionPane.INFORMATION_MESSAGE);
				//부모창 새로고침 처리하기
				abook.refreshData();
				//자식창 닫기
				this.dispose();
			}
			else{
				JOptionPane.showMessageDialog(this
	                    , "수정실패"
	                    , "Error", JOptionPane.ERROR_MESSAGE);				
			}
		}
	}
	
	public void setValue(AddressVO raVO){
		//입력을 위한 윈도우 설정 - 모든 값을 ""로 셋팅합니다.
		if(raVO == null){
			//입력값 초기화 처리
			setName("");
			setAddress("");
			setHp("");
			setBirth("");
			setRelation("");
			setComment("");		
	
		}
		//상세조회, 수정시는 raVO에서 받은 값으로 셋팅합니다.
		else{
			//DB에서 가져온 값 초기화 처리
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
	 * @param title 자식창의 제목
	 * @param raVO  입력일때는 null, 수정일 때는 주소번지
	 * @param abook 부모창의 주소번지
	 * @param isEditable 자식창의 컴포넌트들에 대한 활성화 유무
	 ***********************************************************************************/
	public void set(String title
			      , AddressVO raVO
			      , AddressBook abook
			      , boolean isEditable) {
		//전역변수로 선언된 raVO에 파라미터로 넘어온 raVO의 주소번지를 담습니다.
		this.raVO = raVO;
		this.setEditable(isEditable);
		this.setTitle(title);
		this.abook = abook;
		this.setValue(raVO);
	}
	//각 텍스트 필드에 값들을 설정하거나 읽어오는 getter/setter
	//메소드를 정의해 보세요.
	//입력이거나 수정일 때는 get메소드를 호출합니다.
	//상세조회일때는 set메소드를 호출합니다.
	//수정일때 기존에 입력한 정보를 뿌릴 때도 set메소드 호출한다.
	public String getName(){ return txtName.getText();};
	public void setName(String strName) { txtName.setText(strName);};
	public String getAddress(){ return txtAddress.getText();};
	public void setAddress(String strAddress) { txtAddress.setText(strAddress);};
	public String getHp(){ return txtTel.getText();};
	public void setHp(String strHp) { txtTel.setText(strHp);};	
	public String getRelation(){ return txtRelationShip.getText();};
	public void setRelation(String strRelation) { txtRelationShip.setText(strRelation);};		
	public String getGender(){ 
		if(comboGender.getSelectedItem().equals("남자")){
			return "1";
		}else{
			return "0";
		}
	};
	public void setGender(String strGender) { 
		if("1".equals(strGender)) comboGender.setSelectedItem("남자");
		else comboGender.setSelectedItem("여자");
	};
	public String getBirth(){ return txtBirthDay.getText();};
	public void setBirth(String strBirth) { txtBirthDay.setText(strBirth);};
	public String getComment(){ return txtComment.getText();};
	public void setComment(String strComment) { txtComment.setText(strComment);};
	public String getRegDate(){ return txtRegDate.getText();};
	public void setRegDate(String strRegDate) { txtRegDate.setText(strRegDate);};
	//TextField에 대해서 활성화 혹은 비활성 처리
	//입력, 수정시는 컬럼값을 수정 가능하도록
	//상세조회시는 컬럼값을 수정 불가능하도록 처리
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













