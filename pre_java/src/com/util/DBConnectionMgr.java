package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnectionMgr {

		final String _URL ="jdbc:oracle:thin:@192.168.0.84:1521:orcl11";
		final String _DRIVER="oracle.jdbc.driver.OracleDriver";
		final String _USER="SCOTT";
		final String _PW="tiger";
		Connection con = null;//���������� ������ �ִ� DB������ ������θ� Ȯ���Ҷ� 
		public Connection getConnection(){
			try {
				Class.forName(_DRIVER);//ClassNotFondException
				con=DriverManager.getConnection(_URL, _USER, _PW);
				
			} catch (Exception e) {
				System.out.println(e.toString());
				
			}
			return con;
		}
		//����� �ڿ� �ݳ��ϱ�
		//�ڿ� �ݳ��� ���� ������ �������� �ݳ��Ѵ�.
		//Statement(��������),PreparedStatement(��������),CallaleStatement(���ν�����)
		//
		public static void freeConnection(Connection con,PreparedStatement pstmt){
			try {
				if(pstmt !=null) pstmt.close();
				if(con !=null) con.close();
			} catch (Exception e) {
			}
		
		}
		public static void freeConnection(Connection con,Statement stmt, ResultSet rs){
			try {
				if(rs!=null) rs.close();
				if(stmt !=null) stmt.close();
				if(con !=null) con.close();
			} catch (Exception e) {
			}
		
		}
		public static void freeConnection(Connection con,Statement stmt){
			try {
				if(stmt !=null) stmt.close();
				if(con !=null) con.close();
			} catch (Exception e) {
			}
		
		}
	}


