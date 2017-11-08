package com.jdbc;
import java.util.*;

import com.util.DBConnectionMgr;
import com.vo.DeptVo;

//import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class OracleDBTest {
	/*
	 * ����Ŭ ������ �ڹ��ڵ带 Ȱ���Ͽ� ������ ����
	 * 1.����̹� Ŭ������ �ε��Ѵ�.
	 * 2.���������� ������ �ִ� ������ ������θ� Ȯ��
	 * ip�ּ�,port,sid
	 * 3.�������� ������ ����Ŭ ������ �� ���ɰ�ü�� �����Ѵ�.
	 * 4.����Ŭ �������� ó�� ��û�Ѵ�.
	 * 5.����Ŭ �������� ó���� ����� ���
	 */

	public static void main(String[] args) {
		//��������
		final String _URL="jdbc:oracle:thin:@192.168.0.43:1521:orcl11";
		final String _DRIVER="oracle.jdbc.driver.OracleDriver";
		final String _USER="SCOTT";
		final String _PW="tiger";
		String sql="select deptno,dname,loc from dept";
		Connection con =null;
		Statement stmt=null;
		ResultSet rs =null;
		try{
			//����̹�Ŭ������ �޸𸮿� �ø���
			Class.forName(_DRIVER);
			//������� Ȯ���ϱ�
			 con =DriverManager.getConnection(_URL, _USER, _PW);
			//���ɰ�ü �޸𸮿� �ε��ϱ�
			stmt=con.createStatement();
			//select�� ó�� ��û �޼ҵ�
			//resultset�� ����Ŭ�� Ŀ���� �����ϴµ� �ʿ��� �޼ҵ带 ����
			rs= stmt.executeQuery(sql);
			//rs.next();//�޼ҵ� ȣ��-����Ÿ��:boolean
			//System.out.println("====>"+rs.getString(2));
			DeptVo dvos[]=null;//�������� �ο츦 ���� �� �ִ�.
			DeptVo dvo=null;//�� �� �ο츦 ��� ��ü
			Vector v= new Vector();
			while(rs.next()){
				dvo=new DeptVo();
				int deptno = rs.getInt("deptno");
				String dname=rs.getString("dname");
				String loc=rs.getString("loc");
				dvo.setDeptno(deptno);//��¾� ����� ����
				dvo.setDname(dname);
				dvo.setLoc(loc);
				//System.out.println(deptno+","+dname+","+loc);
				v.add(dvo);
			}
			dvos = new DeptVo[v.size()];
			v.copyInto(dvos);
			for(int i=0;i<dvos.length;i++){
				DeptVo dbvo=dvos[i];
				System.out.println(dbvo.getDeptno()+","+dbvo.getDname()+","+dbvo.getLoc());
			}
		}catch (SQLException se){
			System.out.println("[query]="+sql);
			System.out.println(se.toString());
		}
		catch(Exception e){
			e.printStackTrace();//�����̷��� ������ ���¾���
			System.out.println(e.toString());
		}finally{
			try {
				DBConnectionMgr.freeConnection(con, stmt,rs);
			} catch (Exception e2) {
			}
		}
		
	}

}
