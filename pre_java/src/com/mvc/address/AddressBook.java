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
	//선언부
	static AddressBook  abook = null;
	ModifyDialog 	md 			= new ModifyDialog();
	JToolBar        jt_btn		= new JToolBar();
	JButton 		jbtn_ins 	= new JButton("입력");
	JButton 		jbtn_upd 	= new JButton("수정");
	JButton 		jbtn_del 	= new JButton("삭제");
	JButton 		jbtn_sel 	= new JButton("상세조회");
	JButton 		jbtn_all 	= new JButton("전체조회");
	AddressVO		raVO		= new AddressVO();
	//이미지 경로를 담을 변수 선언
	String path = "src//com//images//";
	//테이블 헤더 초기화하기
	String cols[] = {"아이디","이름","전화번호","주소"};
	String data[][] = new String[0][4];
	//테이블 추가하기
	DefaultTableModel dtm_abook = new DefaultTableModel(data,cols);
	JTable 			jtb_abook   = new JTable(dtm_abook);
	JScrollPane		jsp_abook   = new JScrollPane(jtb_abook);
	//생성자
	public AddressBook(){
	//생성자에서 메소드를 호출할 경우 두 메소드 사이에서 의존성 문제가 있을 수
	//있다.(채팅프로젝트)	
		//initDisplay();
		//refreshData();
	}
	//삭제 버튼 클릭시 작업 
	public void addrDel(){
	//사용자가 화면에서 선택한 로우의 인덱스 담기
		int index[] = jtb_abook.getSelectedRows();
/*		for(int i=0;i<index.length;i++){
			System.out.println(index[i]);
		}*/
		if(index.length == 0){//너 삭제할 로우를 선택하지 않았어
			JOptionPane.showMessageDialog(this
					, "삭제할 데이터를 선택하세요."
					, "Error"
					, JOptionPane.ERROR_MESSAGE);
			return;//addrDel메소드 탈출
		}
		else{//삭제할 로우를 선택했으니 삭제해줄께
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
	
	//새로고침 구현하기
	public void refreshData(){
		System.out.println("refreshData 호출 성공");
		//기존에 조회된 정보를 초기화하기
		while(dtm_abook.getRowCount() > 0){
			dtm_abook.removeRow(0);
		}
		//insert here - MVC패턴 실습
		AddressController aCtrl = new AddressController();
		AddressVO paVO = new AddressVO();
		List<AddressVO> addrList = aCtrl.sendALL(paVO);
		Iterator<AddressVO> iter = addrList.iterator();
		//조회된 데이터가 없니?
		if((addrList == null) || (addrList.size() < 1)){
			JOptionPane.showMessageDialog(this
					                    , "조회된 데이터가 없습니다."
					                    , "Info"
					                    , JOptionPane.INFORMATION_MESSAGE); 
		}
		//조회된 데이터가 있으면?
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
	//화면처리부
	public void initDisplay(){
		jbtn_ins.addActionListener(this);
		jbtn_upd.addActionListener(this);
		jbtn_del.addActionListener(this);
		jbtn_sel.addActionListener(this);
		jbtn_all.addActionListener(this);
		//윈도우 리스너 구현
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent ae){
				System.out.println("윈도우 종료");
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
		this.setTitle("MVC패턴을 적용한 주소록 1.0");
		this.setSize(500, 400);
		this.setVisible(true);
		refreshData();
	}
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		abook = new AddressBook();
		abook.initDisplay();
		//md.addrIns();//입력버튼을 클릭했을 때
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//너 입력버튼 클릭했니? 응
		if(jbtn_ins == e.getSource()){//응
			md.set("입력",null,abook,true);
			md.setVisible(true);
		}
		//너 수정버튼 클릭했니?
		else if(jbtn_upd == e.getSource()){//응
			int index[] = jtb_abook.getSelectedRows();
			if(index.length == 0){//너 수정할 로우를 선택하지 않았어
				JOptionPane.showMessageDialog(this
						, "수정할 데이터를 선택하세요."
						, "Error"
						, JOptionPane.ERROR_MESSAGE);
				return;//addrDel메소드 탈출
			}
			else if(index.length == 1){
				AddressController aCtrl = new AddressController();
				AddressVO pVO = new AddressVO();
				AddressVO raVO = null;
				//사용자가 선택한 로우의 id값(?)을 담을 메소드 호출
				if(jtb_abook.isRowSelected(index[0])){
					Integer id = 
					Integer.parseInt(dtm_abook.getValueAt(index[0], 0).toString());
					pVO.setCommand("select");
					pVO.setId(id);
					raVO = aCtrl.send(pVO);
					System.out.println("조회된 이름:"+raVO.getName());
				}
				md.set("수정",raVO,abook,true);
				md.setVisible(true);
			}
			else{//좋은 말로 할 때 한 개만 선택해라~~~~
				JOptionPane.showMessageDialog(this
						, "한개만 선택하세요."
						, "Error"
						, JOptionPane.ERROR_MESSAGE);
				return;//addrDel메소드 탈출				
			}
		}
		//너 상세조회버튼을 클릭했니?
		else if(jbtn_sel == e.getSource()){//응
			md.set("상세조회",raVO,null,false);
			md.setVisible(true);
		}	
		//너 삭제버튼을 클릭했니?
		else if(jbtn_del == e.getSource()){//응
			addrDel();
		}	
		//너 전체조회 클릭했니?
		else if(jbtn_all == e.getSource()){
			refreshData();
		}
	}

}
