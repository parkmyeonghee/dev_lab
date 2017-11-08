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
	Connection con=null;//연결통로
	PreparedStatement pstmt=null;//SQL문 전달
	ResultSet rs=null;
	DBConnectionMgr dbMgr= new DBConnectionMgr();
	//회원가입 구현하기
	//개선코드 -vo패턴 적용
	public int memberInsert(String mem_id
										,String mem_pw
										,String mem_name
										,String mem_tel){
		int result=0;
		con=dbMgr.getConnection();//DBConnectionMgr의 getConnection()호출
		StringBuilder sql=new StringBuilder();
		sql.append("insert into scott.member(no,mem_id,mem_pw,mem_name,mem_tel)");
		sql.append("values(seq_member_no.nextval,?,?,?,?");
		try {
			pstmt=con.prepareStatement(sql.toString());//db서버 sql전달
			int i=1;
			pstmt.setString(i++,mem_id);
			pstmt.setString(i++,mem_pw);
			pstmt.setString(i++,mem_name);
			pstmt.setString(i++,mem_tel);
			result =pstmt.executeUpdate();
			if(result==1)System.out.println("삽입성공");
			
		} catch (SQLException se) {//sql관해서 예외처리
			System.out.println("[[query]]"+sql);
		}finally{
			DBConnectionMgr.freeConnection(con, pstmt);
			//사용한 자원 명시적으로 반납하기.
		}
		return result;
	}
	/***************************************************************************
	 * 회원목록 조회하기
	 * @return List<MemberVo>
	 * 작성자:
	 * 설	 명: 회원 가입된 회원들의 명단을 가져 옵니다. 
	 ***************************************************************************/
	public List<MemberVo> getMemberList(){
		List<MemberVo> memList = new ArrayList<MemberVo>();
		con=dbMgr.getConnection();
		StringBuilder sql= new StringBuilder();
		//ORM솔루션-xml문서에 관리한다. 왜? 버전관리 쉽다. 유지보수 용이,sql문만 따로 관리
		sql.append("select no,mem_id,mem_pw,mem_name,mem_tel from member");
		try {
			//preparedStatement pstmt= new preparedStatement();
			pstmt=con.prepareStatement(sql.toString());
			//ReuseltSet rs= new ResultSet();
			//ReuseltSet으로 커서를 조작할 수 있다.
			//인터페이스는 추상메소드를 가지고 있다.
			//rs.next():boolean-커서를 다음으로 이동하세요
			//rs.previous(),rs.isFirst():boolean,rs.absolution(3);,rs.isLst(),,,,
			//커서를 조작하여 메모리에 올려진 로우정보들을 저장소(자료구조:List,Map)에 담는다.
			rs=pstmt.executeQuery();
			MemberVo mvo=null;//Vo안에는 변수가 선언되어 있다.
			//한번에 한건만 담을 수 있다.
			/************자료 구조에 담는 구간 시작*************/
			while(rs.next()){
			mvo= new MemberVo();	
			mvo.setNo(rs.getInt("no"));
			mvo.setMem_id(rs.getString("mem_id"));
			mvo.setMem_pw(rs.getString("mem_pw"));
			mvo.setMem_name(rs.getString("mem_name"));
			mvo.setMem_tel(rs.getString("mem_tel"));
			
			}
			/*************자료구조에 담는 구간 끝*************/
			System.out.println("로우 수:"+memList.size());
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
	//커서 조작하기
	public int memberSize(){
		int rowcount =0;
		con=dbMgr.getConnection();
		StringBuilder sql= new StringBuilder();
		//ORM솔루션-xml문서에 관리한다. 왜? 버전관리 쉽다. 유지보수 용이,sql문만 따로 관리
		sql.append("select no,mem_id,mem_pw,mem_name,mem_tel from member");
		try {
			//CONCUR_UPDATABLE-update문을 사용하지 않고 직접 값을 수정할 수 있다.
			pstmt=con.prepareStatement(sql.toString(),
					ResultSet.TYPE_SCROLL_SENSITIVE //순차적으로(커서를)
					,ResultSet.CONCUR_UPDATABLE); //비순차적으로
			rs=pstmt.executeQuery();//커서의 위치는 테이블에 top에 위치한다
			rs.last();//커서의 위치를 한개로우씩 이동하여 맨 끝까지 간다
			rowcount = rs.getRow();
			rs.beforeFirst();//커서의 위치를 원래 대로 이동시킴
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
			/*console에 출력하기
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
		//mCRUD.memberInsert("haha", "123", "강감찬", "02-456-7852");
		//mCRUD.getMemberList();
		System.out.println("로우의수"+mCRUD.memberSize());
	}

}
