package com.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Scanner;

public class PLSqlSimulation {
	public PLSqlSimulation(){
		getProcSalUpdate();
	}
	void getProcSalUpdate(){
		//getConnection ȣ���ϱ�
		DBConnectionMgr dbMgr= new DBConnectionMgr();
		try {
			Connection con = dbMgr.getConnection();
			System.out.println("�����ȣ�� �Է��ϼ���");
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();
			System.out.println("����� ���� �Է��� �����ȣ===>"+input+10);
			CallableStatement cstmt = con.prepareCall("{call proc_salupdate(?,?)}");
			cstmt.setInt(1,Integer.parseInt(input));
			cstmt.registerOutParameter(2,java.sql.Types.VARCHAR);
			cstmt.executeUpdate();
			System.out.println(cstmt.getString(2));//
			//System.out.println(con.toString());
			
		} catch (Exception e) {
		}
	}

	public static void main(String[] args) {
		PLSqlSimulation ps= new PLSqlSimulation();
		
	}

}
