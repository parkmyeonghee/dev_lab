package com.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Scanner;

public class PLSqlSimulation {
	public PLSqlSimulation(){
		getProcSalUpdate();
	}
	void getProcSalUpdate(){
		//getConnection 호출하기
		DBConnectionMgr dbMgr= new DBConnectionMgr();
		try {
			Connection con = dbMgr.getConnection();
			System.out.println("사원번호를 입력하세요");
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();
			System.out.println("사원이 직접 입력한 사원번호===>"+input+10);
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
