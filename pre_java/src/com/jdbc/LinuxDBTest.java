package com.jdbc;
/*****************************************************
 * �ν��Ͻ�ȭ
 * A a = new A();
 * A a=�޼ҵ� �̸�();
 * A �޼ҵ� �̸�(){}
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
			
			Connection con=dbMgr.getConnection();//getConnection�� ����Ÿ���� Connection�̴�
			Statement stmt=con.createStatement();//�������� ������ �� ���� ����.
			//ResultSet�� Ŀ���� �����ϴµ� �ʿ��� �޼ҵ带 �����ϰ� �ֽ��ϴ�.
			//next(),previous(),isFirst:boolean,isLast():boolean,absolute(3)
			ResultSet rs =stmt.executeQuery(sql);//select���� ó���� �ִ� ����
			while(rs.next()){//Ŀ���� �������� �����ּ���
				System.out.println(rs.getInt("employee_id")+","+rs.getString("first_name")+"."+rs.getString("last_name"));
			}
		} catch (Exception e) {
			System.out.println("Exception:"+e.toString());
		}
		
}
}
