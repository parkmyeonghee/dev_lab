package com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.util.DBConnectionMgr;
import com.vo.MemberVo;

public class MemberCRUD {
	Connection con=null;//�������
	PreparedStatement pstmt=null;//SQL�� ����
	ResultSet rs=null;
	DBConnectionMgr dbMgr= new DBConnectionMgr();
	//ȸ������ �����ϱ�
	//�����ڵ� -vo���� ����
	public int memberInsert(String mem_id
										,String mem_pw
										,String mem_name
										,String mem_tel){
		int result=0;
		con=dbMgr.getConnection();//DBConnectionMgr�� getConnection()ȣ��
		StringBuilder sql=new StringBuilder();
		sql.append("insert into scott.member(no,mem_id,mem_pw,mem_name,mem_tel)");
		sql.append("values(seq_member_no.nextval,?,?,?,?");
		try {
			pstmt=con.prepareStatement(sql.toString());//db���� sql����
			int i=1;
			pstmt.setString(i++,mem_id);
			pstmt.setString(i++,mem_pw);
			pstmt.setString(i++,mem_name);
			pstmt.setString(i++,mem_tel);
			result =pstmt.executeUpdate();
			if(result==1)System.out.println("���Լ���");
			
		} catch (SQLException se) {//sql���ؼ� ����ó��
			System.out.println("[[query]]"+sql);
		}finally{
			DBConnectionMgr.freeConnection(con, pstmt);
			//����� �ڿ� ��������� �ݳ��ϱ�.
		}
		return result;
	}
	/***************************************************************************
	 * ȸ����� ��ȸ�ϱ�
	 * @return List<MemberVo>
	 * �ۼ���:
	 * ��	 ��: ȸ�� ���Ե� ȸ������ ����� ���� �ɴϴ�. 
	 ***************************************************************************/
	public List<MemberVo> getMemberList(){
		List<MemberVo> memList = new ArrayList<MemberVo>();
		con=dbMgr.getConnection();
		StringBuilder sql= new StringBuilder();
		//ORM�ַ��-xml������ �����Ѵ�. ��? �������� ����. �������� ����,sql���� ���� ����
		sql.append("select no,mem_id,mem_pw,mem_name,mem_tel from member");
		try {
			//preparedStatement pstmt= new preparedStatement();
			pstmt=con.prepareStatement(sql.toString());
			//ReuseltSet rs= new ResultSet();
			//ReuseltSet���� Ŀ���� ������ �� �ִ�.
			//�������̽��� �߻�޼ҵ带 ������ �ִ�.
			//rs.next():boolean-Ŀ���� �������� �̵��ϼ���
			//rs.previous(),rs.isFirst():boolean,rs.absolution(3);,rs.isLst(),,,,
			//Ŀ���� �����Ͽ� �޸𸮿� �÷��� �ο��������� �����(�ڷᱸ��:List,Map)�� ��´�.
			rs=pstmt.executeQuery();
			MemberVo mvo=null;//Vo�ȿ��� ������ ����Ǿ� �ִ�.
			//�ѹ��� �ѰǸ� ���� �� �ִ�.
			/************�ڷ� ������ ��� ���� ����*************/
			while(rs.next()){
			mvo= new MemberVo();	
			mvo.setNo(rs.getInt("no"));
			mvo.setMem_id(rs.getString("mem_id"));
			mvo.setMem_pw(rs.getString("mem_pw"));
			mvo.setMem_name(rs.getString("mem_name"));
			mvo.setMem_tel(rs.getString("mem_tel"));
			
			}
			/*************�ڷᱸ���� ��� ���� ��*************/
			System.out.println("�ο� ��:"+memList.size());
		} catch (SQLException se) {
			System.out.println("[[query]]"+sql);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBConnectionMgr.freeConnection(con, pstmt,rs);
		}
		printMemberList(memList);
		return memList;
	}
	//Ŀ�� �����ϱ�
	public int memberSize(){
		int rowcount =0;
		con=dbMgr.getConnection();
		StringBuilder sql= new StringBuilder();
		//ORM�ַ��-xml������ �����Ѵ�. ��? �������� ����. �������� ����,sql���� ���� ����
		sql.append("select no,mem_id,mem_pw,mem_name,mem_tel from member");
		try {
			//CONCUR_UPDATABLE-update���� ������� �ʰ� ���� ���� ������ �� �ִ�.
			pstmt=con.prepareStatement(sql.toString(),
					ResultSet.TYPE_SCROLL_SENSITIVE //����������(Ŀ����)
					,ResultSet.CONCUR_UPDATABLE); //�����������
			rs=pstmt.executeQuery();//Ŀ���� ��ġ�� ���̺� top�� ��ġ�Ѵ�
			rs.last();//Ŀ���� ��ġ�� �Ѱ��ο쾿 �̵��Ͽ� �� ������ ����
			rowcount = rs.getRow();
			rs.beforeFirst();//Ŀ���� ��ġ�� ���� ��� �̵���Ŵ
		}catch(Exception e){
			
		}finally{
			DBConnectionMgr.freeConnection(con, pstmt,rs);
		}
		return rowcount;
	}
	//List->MemberVo->mem_id,mem_pw,mem_name.....
	public void printMemberList(List<MemberVo>memList){
		for(int i=0;i<memList.size();i++){//List
			MemberVo mvo = memList.get(i);
			/*console�� ����ϱ�
			 * JTable-DefaultTableModel
			 * MiplatForm-DataSet
			 * Grid
			 * HTML
			 */
			System.out.println(mvo.getMem_id()+","+mvo.getMem_name());
		}
	}
	public static void main(String[] args) {
		MemberCRUD mCRUD = new MemberCRUD();
		//mCRUD.memberInsert("haha", "123", "������", "02-456-7852");
		//mCRUD.getMemberList();
		System.out.println("�ο��Ǽ�"+mCRUD.memberSize());
	}

}
