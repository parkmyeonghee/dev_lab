package com.jdbc;
/*****************************************************
 * 인스턴스화
 * A a = new A();
 * A a=메소드 이름();
 * A 메소드 이름(){}
 * 
 ******************************************************/
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.util.LinuxDBConnetionMgr;



public class LinuxDBTest {

	public static void main(String[] args) {
		LinuxDBConnetionMgr  dbMgr=new LinuxDBConnetionMgr ();
		//LinuxDBConnetionMgr dbMgr=LinuxDBConnetionMgr getInstance();
		String sql="select employee_id,first_name,last_name from employees";
		try {
			
			Connection con=dbMgr.getConnection();//getConnection의 리턴타입은 Connection이다
			Statement stmt=con.createStatement();//쿼리문을 가지고 갈 전령 생성.
			//ResultSet는 커서를 조작하는데 필요한 메소드를 정의하고 있습니다.
			//next(),previous(),isFirst:boolean,isLast():boolean,absolute(3)
			ResultSet rs =stmt.executeQuery(sql);//select문을 처리해 주는 아이
			while(rs.next()){//커서를 다음으로 보내주세요
				System.out.println(rs.getInt("employee_id")+","+rs.getString("first_name")+"."+rs.getString("last_name"));
			}
		} catch (Exception e) {
			System.out.println("Exception:"+e.toString());
		}
		
}
}
