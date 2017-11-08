package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class LinuxDBConnetionMgr {
	final String _URL ="jdbc:oracle:thin:@192.168.0.67:1521:xe";
	final String _DRIVER="oracle.jdbc.driver.OracleDriver";
	final String _USER="HR";
	final String _PW="tiger";
	Connection con = null;//���������� ������ �ִ� DB������ ������θ� Ȯ���Ҷ� 
	LinuxDBConnetionMgr dbMgr=null;
	LinuxDBConnetionMgr getInstance(){
		if(dbMgr==null)dbMgr= new LinuxDBConnetionMgr();
		return dbMgr;
	}
	public Connection getConnection(){
		try {
			Class.forName(_DRIVER);
			con=DriverManager.getConnection(_URL, _USER, _PW);
			
		} catch (Exception e) {
			System.out.println(e.toString());
			
		}
		return con;
	}


}
