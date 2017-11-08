package com.sungjuk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class View {
	Logic sLogic =new Logic(this);
	Event sEvent = new Event(this,sLogic);
	int inwonn;
	String contents[][]= new String[inwonn][8];
	
	
	JTable jt_sungjuk = new JTable();
	
	JFrame jf_sungjuk = new JFrame();
	JPanel jp_north = new JPanel();
	JPanel jp_center = new JPanel();
	JPanel jp_south = new JPanel();
	JLabel jlb_inwon = new JLabel("인원수"); //import!!!
	JTextField jtf_inwon = new JTextField(5);
	JButton jbtn_create = new JButton("만들기");
	JButton jbtn_process = new JButton("처리");
	JButton jbtn_exit = new JButton("종료");
	
	String db_contents[][]=new String[5][8];

public void initDisplay(){

		jf_sungjuk.setTitle("성적 처리");
		jf_sungjuk.setSize(500,300);
		jf_sungjuk.setVisible(true);	
		
		jf_sungjuk.add("North", jp_north);
		jf_sungjuk.add("Center", jp_center);
		jf_sungjuk.add("South", jp_south);
		   
		jp_north.add(jlb_inwon);
		jp_north.add(jtf_inwon);
		jp_north.add(jbtn_create);
		
		jp_south.add(jbtn_process);
		jp_south.add(jbtn_exit);
		
		jbtn_create.addActionListener(sEvent);
		jbtn_exit.addActionListener(sEvent);	
		jbtn_process.addActionListener(sEvent);
	}	
public void getDB(){
		final String _URL="jdbc:oracle:thin:@192.168.0.43:1521:orcl11";
		final String _DRIVER="oracle.jdbc.driver.OracleDriver";
		final String _USER="SCOTT";
		final String _PW="tiger";
		String sql="select sname,oracle,sjava,html from SungJuk";
		try{
			Class.forName(_DRIVER);
			Connection con =DriverManager.getConnection(_URL, _USER, _PW);
			Statement stmt=con.createStatement();
			ResultSet rs= stmt.executeQuery(sql);
		
			int i=0;
		
			for(i=0;rs.next();i++){
				db_contents[i][0]=rs.getString("sname");
				db_contents[i][1]=rs.getString("oracle");
				db_contents[i][2]=rs.getString("sjava");
				db_contents[i][3]=rs.getString("html");
	
			}
			rs.close();
			stmt.close();
			con.close();
			}
		catch(Exception e){
			e.printStackTrace();
//			System.out.println(e.toString());
		}
		}
	
public void getTable(){
	inwonn = Integer.parseInt(jtf_inwon.getText());
	if(inwonn>db_contents.length){
		JOptionPane.showMessageDialog(jf_sungjuk, "총인원은 "+db_contents.length+ " 명입니다. "+db_contents.length+" 이하의 숫자를 입력하세요."
					                    , "INFO", JOptionPane.INFORMATION_MESSAGE);
			return;
		}	
	contents = new String[inwonn][8]; 
	String header[] = {"이름","오라클","자바","HTML","총점","평균","학점","석차"};
	DefaultTableModel dtm1 = new DefaultTableModel(contents, header);
	jt_sungjuk = new JTable(dtm1);
	JScrollPane jsp1 = new JScrollPane(jt_sungjuk);
	jp_center.add(jsp1);
	jf_sungjuk.validate();

	
	int j =0;
	for(j=0;j<inwonn;j++){
	jt_sungjuk.setValueAt(db_contents[j][0],j,0);
	jt_sungjuk.setValueAt(db_contents[j][1],j,1);
	jt_sungjuk.setValueAt(db_contents[j][2],j,2);
	jt_sungjuk.setValueAt(db_contents[j][3],j,3);
	}
}

	public static void main(String[] args) {
		View sView = new View();
		sView.initDisplay();
		sView.getDB();
		
		
	}

}
