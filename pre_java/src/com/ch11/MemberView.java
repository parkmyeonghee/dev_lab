package com.ch11;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.jdbc.MemberCRUD;
import com.vo.MemberVo;

public class MemberView extends JFrame implements ActionListener {
	JTable jtb_member =null;
	JScrollPane jsp_member= null;
	DefaultTableModel dtm_member=null;
	String header[] ={"번호","아이디","비번","이름","전화번호"};
	String datas[][] = new String[0][0];
	JPanel jp_north=null;
	JButton jbtn_sel=null;
	public MemberView(){
		initDisplay();
	}
	//전체 데이터를 조회하기
	public void refreshData(){
		//getMemberList
		MemberCRUD mCRUD= new MemberCRUD();
		List<MemberVo>memList=mCRUD.getMemberList();
		//List<MemberVo>memList=null;
		//조회결과가 없습니까?
		if(memList.size()==0 ||memList==null ){
			JOptionPane.showMessageDialog(this
					,"조회결과가 없습니다."
					, "INFO"
					, JOptionPane.INFORMATION_MESSAGE);
			return;//fefreshData메소드 탈출
		}
		else{ 
			for(int i=0;i<memList.size();i++){
				Vector oneRow = new Vector();
				oneRow.add(memList.get(i).getNo());
				oneRow.add(memList.get(i).getMem_id());
				oneRow.add(memList.get(i).getMem_pw());
				oneRow.add(memList.get(i).getMem_name());
				oneRow.add(memList.get(i).getMem_tel());
				dtm_member.addRow(oneRow);
			}
		}
	}
	
	public void initDisplay(){
		dtm_member = new DefaultTableModel(datas,header);
		jtb_member=new JTable(dtm_member);
		jsp_member=new JScrollPane(jtb_member);
		jp_north=new JPanel();//flowlayout
		jbtn_sel = new JButton("조회");
		jbtn_sel.addActionListener(this);
		jp_north.add(jbtn_sel);
		this.add("Center",jsp_member);//지역을 정해주어서 add순서 상관ㄴㄴ
		this.add("North",jp_north);
		this.setSize(700, 350);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new MemberView();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		//너 조회버튼 클릭했니?
		if(ae.getSource()==jbtn_sel){
			System.out.println("조회버튼 클릭성공");
			refreshData();
		}
	}

}
