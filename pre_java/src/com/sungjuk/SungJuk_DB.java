package com.sungjuk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.vo.DeptVo;

public class SungJuk_DB {
	public class SunJuck{
		public String sname =""; 
		public int oracle=0; 
		public int sjava=0; 
		public int html=0; 
	}

	public static void main(String[] args) {
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
			SunJuck suns[]=null;
			SunJuck sun=null;
			Vector v= new Vector();
			
			while(rs.next()){
				suns=new SunJuck();
				String sname= rs.getString("sname");
				int oracle=rs.getInt("oracle");
				int sjava=rs.getInt("sjava");
				int html=rs.getInt("oracle");
				sun.sname=sname;
				sun.oracle=oracle;
				sun.sjava=sjava;
				sun.html=html;
				v.add(sun);
			}
			suns = new SunJuck[v.size()];
			for(int i=0;i<suns.length;i++){
				SunJuck dbsun=suns[i];
				System.out.println(dbsun.sname+","+dbsun.oracle+","+dbsun.sjava+","+dbsun.html);
			}
			rs.close();
			stmt.close();
			con.close();
			}
		catch(Exception e){
			e.printStackTrace();
			System.out.println(e.toString());
		}
		
	}
		

	}
