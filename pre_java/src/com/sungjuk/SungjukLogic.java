package com.sungjuk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SungjukLogic {
	int inwonn;
	String db_contents[][]=new String[5][8];
	String contents[][]= new String[inwonn][8];	

SungjukView sv;
public SungjukLogic(SungjukView sv){
	this.sv = sv;
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
//단위 테스트
//System.out.println(""+db_contents[i][0]+""+db_contents[i][1]+""+db_contents[i][2]+""+db_contents[i][3]);

		}
		rs.close();
		stmt.close();
		con.close();
		}
	catch(Exception e){
		e.printStackTrace();
//		System.out.println(e.toString());
	}
	}

public void getTable(){
inwonn = Integer.parseInt(sv.jtf_inwon.getText());
if(inwonn>db_contents.length){
	JOptionPane.showMessageDialog(sv.jf_sungjuk, "총인원은 "+db_contents.length+ " 명입니다. "+db_contents.length+" 이하의 숫자를 입력하세요."
				                    , "INFO", JOptionPane.INFORMATION_MESSAGE);
		return;
	}	
contents = new String[inwonn][8]; 
String header[] = {"이름","오라클","자바","HTML","총점","평균","학점","석차"};
DefaultTableModel dtm1 = new DefaultTableModel(contents, header);
sv.jt_sungjuk = new JTable(dtm1);
JScrollPane jsp1 = new JScrollPane(sv.jt_sungjuk);
sv.jp_center.add(jsp1);
sv.jf_sungjuk.validate();

/*	쌤이 가르쳐준 방식
Vector<String> v_room = new Vector<String>();
v_room.add("하하");
v_room.add("남");
dtm1.addRow(v_room); */

int j =0;
for(j=0;j<inwonn;j++){
	sv.jt_sungjuk.setValueAt(db_contents[j][0],j,0);
	sv.jt_sungjuk.setValueAt(db_contents[j][1],j,1);
	sv.jt_sungjuk.setValueAt(db_contents[j][2],j,2);
	sv.jt_sungjuk.setValueAt(db_contents[j][3],j,3);
}
}



	int i =0;
	
//총점
public void chongJum(){
	for(i=0;i<inwonn;i++){
	contents[i][4]=String.valueOf(Integer.parseInt(db_contents[i][1]) 
			+Integer.parseInt(db_contents[i][2])
			+Integer.parseInt(db_contents[i][3]));
	sv.jt_sungjuk.setValueAt(contents[i][4],i,4);
	}
}

//평균
public void avg(){
	for(i=0;i<inwonn;i++){
	contents[i][5]=String.valueOf(
					Integer.parseInt(contents[i][4])/3);
	sv.jt_sungjuk.setValueAt(contents[i][5],i,5);
}
}
//학점
public void hakJum(){
	for(i=0;i<inwonn;i++){
	if(Integer.parseInt(contents[i][4])/3 >=90){
		contents[i][6] = "A";
	}else if(Integer.parseInt(contents[i][4])/3 >=80 &
			 Integer.parseInt(contents[i][4])/3< 90){
		contents[i][6] = "B";
	}else if(Integer.parseInt(contents[i][4])/3 >=70 &
			 Integer.parseInt(contents[i][4])/3< 80){
		contents[i][6] = "C";
	}else if(Integer.parseInt(contents[i][4])/3 >=60 &
			 Integer.parseInt(contents[i][4])/3 < 70){
		contents[i][6] = "D";
	}else{
		contents[i][6] = "F";
	}
	sv.jt_sungjuk.setValueAt(contents[i][6],i,6);
	}
}	

//석차

public void sukCha(){
	int rank[] = new int[inwonn];
	int tot [] = new int [inwonn];
 for(i=0;i<inwonn;i++){   
   rank[i] = 1;// 일단 모든 랭크 값을 1로 초기화  
   tot[i] = Integer.parseInt(contents[i][4]);
 }
 for(i=0;i<inwonn;i++){
   for (int j = 0; j < inwonn; j++) {
    	 if(tot[i]<tot[j]) {
            	rank[i]++;    
            }
   } 
 contents[i][7] = String.valueOf(rank[i]); 
 
 sv.jt_sungjuk.setValueAt(contents[i][7],i,7);
 }//석차 for문 끝
}
}
