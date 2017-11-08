package com.ch5;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.util.DBConnectionMgr;
import com.vo.MemberVo;

public class TwoArrayTable extends JFrame implements ActionListener {
	JPanel jp_north = new JPanel();
	String data[][] = new String[0][0];
	String cols[] = new String[]{"ID","대화명","성별"};
	DefaultTableModel dtm = new DefaultTableModel(data,cols);
	JTable jt = new JTable(dtm);
	JScrollPane jsp = new JScrollPane(jt);
	JButton jbtns[] = new JButton[4];
	String jbtn_label[] = new String[]{"배열","백터","DB","지우기"};
	String datas[][]={
			{"aa","aa","dd"}
			,{"ff","ff","ff"}
			,{"dd","dd","ff"}		
	};
	String datas2[][]={
			{"cc","cc","dd"}
			,{"gg","gg","ff"}
			,{"rr","dd","ff"}			
	};
	public void clear(){
		while(dtm.getRowCount()>0){ //data가 존재하니?
			dtm.removeRow(0);
	}
		}
	
	public void initDisplay(){
		jp_north.setLayout(new GridLayout(1, 4));
		for(int i=0;i<jbtns.length;i++){
			jbtns[i] = new JButton(jbtn_label[i]);
			jp_north.add(jbtns[i]);
			jbtns[i].addActionListener(this);
			}
		jt.getTableHeader().setReorderingAllowed(false);
		jt.getColumnModel().getColumn(0).setPreferredWidth(130);
		jt.getColumnModel().getColumn(1).setPreferredWidth(150);
		jt.getColumnModel().getColumn(2).setPreferredWidth(70);
		this.add("North",jp_north);
		this.add("Center",jsp );
		this.setSize(350, 200);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		TwoArrayTable tab=new TwoArrayTable();
		tab.initDisplay();
	}
	public Vector<MemberVo> getMemberList(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		DBConnectionMgr dbMgr = new DBConnectionMgr();
		Vector<MemberVo> memList =new Vector<MemberVo>();
		StringBuilder sql = new StringBuilder();
		sql.append("Select mem_id,mem_name,gender");
		sql.append(" From member");
	try {
		con = dbMgr. getConnection();
		pstmt=con.prepareStatement(sql.toString());
		rs= pstmt.executeQuery();
		MemberVo mvo = null;
		while(rs.next()){
			mvo= new MemberVo();
			mvo.setMem_id(rs.getString("mem_id"));
			mvo.setMem_name(rs.getString("mem_name"));
			mvo.setGender(rs.getString("gender"));
			memList.add(mvo);
		}
	} catch (SQLException se) {
		System.out.println("[[query]]"+sql.toString());
	} catch (Exception e){
		e.printStackTrace();
	}finally{
		DBConnectionMgr.freeConnection(con, pstmt);
	}
	return memList;
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj =e.getSource();
		String label =e.getActionCommand(); //배열,벡터,지우기
		if("배열".equals(label)){
			clear();
			for(int i=0;i<datas.length;i++){
				dtm.addRow(datas[i]);
			}
		}
		else if("백터".equals(label)){
			clear();
			for(int i =0;i<datas2.length;i++){
				Vector<String>v_temp = new Vector<String>();
				v_temp.add(datas2[i][0]);
				v_temp.add(datas2[i][1]);
				v_temp.add(datas2[i][2]);
				dtm.addRow(v_temp);
			}
		}
		else if("DB".equals(label)){
			Vector<MemberVo> memList = getMemberList();
			//System.out.println("size:"+memList.size());
			for(int i=0;i<memList.size();i++){
				MemberVo mvo = memList.get(i);
				Vector<String>imsi = new Vector<String>();
				imsi.add(mvo.getMem_id());
				imsi.add(mvo.getMem_name());
				imsi.add(mvo.getGender());
				dtm.addRow(imsi);
			}
		}
		else if("지우기".equals(label)){
			clear();
			}

	}

}
