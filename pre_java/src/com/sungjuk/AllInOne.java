package com.sungjuk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AllInOne implements ActionListener {
	int inwonn;
	String contents[][]= new String[inwonn][8];
	
	
	JTable jt_sungjuk = new JTable();
	
	JFrame jf_sungjuk = new JFrame();
	JPanel jp_north = new JPanel();
	JPanel jp_center = new JPanel();
	JPanel jp_south = new JPanel();
	JLabel jlb_inwon = new JLabel("�ο���"); //import!!!
	JTextField jtf_inwon = new JTextField(5);
	JButton jbtn_create = new JButton("�����");
	JButton jbtn_process = new JButton("ó��");
	JButton jbtn_exit = new JButton("����");
	
	String db_contents[][]=new String[5][8];

public void initDisplay(){

		jf_sungjuk.setTitle("���� ó��");
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
		
		jbtn_create.addActionListener(this);
		jbtn_exit.addActionListener(this);	
		jbtn_process.addActionListener(this);
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
System.out.println(""+db_contents[i][0]+""+db_contents[i][1]+""+db_contents[i][2]+""+db_contents[i][3]);
	
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
		JOptionPane.showMessageDialog(jf_sungjuk, "���ο��� "+db_contents.length+ " ���Դϴ�. "+db_contents.length+" ������ ���ڸ� �Է��ϼ���."
					                    , "INFO", JOptionPane.INFORMATION_MESSAGE);
			return;
		}	
	contents = new String[inwonn][8]; 
	String header[] = {"�̸�","����Ŭ","�ڹ�","HTML","����","���","����","����"};
	DefaultTableModel dtm1 = new DefaultTableModel(contents, header);
	jt_sungjuk = new JTable(dtm1);
	JScrollPane jsp1 = new JScrollPane(jt_sungjuk);
	jp_center.add(jsp1);
	jf_sungjuk.validate();
	
/*	���� �������� ���
    Vector<String> v_room = new Vector<String>();
	v_room.add("����");
	v_room.add("��");
	dtm1.addRow(v_room); */
	
	int j =0;
	for(j=0;j<inwonn;j++){
	jt_sungjuk.setValueAt(db_contents[j][0],j,0);
	jt_sungjuk.setValueAt(db_contents[j][1],j,1);
	jt_sungjuk.setValueAt(db_contents[j][2],j,2);
	jt_sungjuk.setValueAt(db_contents[j][3],j,3);
	}
}
	
public void doProcess(){
	int i =0;
	int rank[] = new int[inwonn];
	int tot [] = new int [inwonn];	
	
for(i=0;i<inwonn;i++){
	//����
	contents[i][4]=String.valueOf(Integer.parseInt(db_contents[i][1]) 
			+Integer.parseInt(db_contents[i][2])
			+Integer.parseInt(db_contents[i][3]));
	//���
	contents[i][5]=String.valueOf(
					Integer.parseInt(contents[i][4])/3);	
	//����
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
	
	jt_sungjuk.setValueAt(contents[i][4],i,4);
	 jt_sungjuk.setValueAt(contents[i][5],i,5);
	 jt_sungjuk.setValueAt(contents[i][6],i,6);
}//����, ���, ���� ���� �� 

//����
 for(i=0;i<inwonn;i++){   
   rank[i] = 1;// �ϴ� ��� ��ũ ���� 1�� �ʱ�ȭ  
   tot[i] = Integer.parseInt(contents[i][4]);
 }
 for(i=0;i<inwonn;i++){
   for (int j = 0; j < inwonn; j++) {
    	 if(tot[i]<tot[j]) {
            	rank[i]++;    
            }
   } 
 
 contents[i][7] = String.valueOf(rank[i]); 
 
 jt_sungjuk.setValueAt(contents[i][7],i,7);
} //���� for�� ��
}//doProcess �޼ҵ� ��

public static void main(String[] args) {
		AllInOne aio = new AllInOne();//����Ʈ�����ڸ� Ž
		aio.initDisplay();
		aio.getDB();
	}

@Override
public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj==jbtn_create){
			
		getTable();
     		
		}	
		if(obj==jbtn_process){
		doProcess();
		
		}else if(obj==jbtn_exit){
			System.exit(0);
		}
		
			
		
	}

}
