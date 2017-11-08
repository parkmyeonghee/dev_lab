package com.mvc.address;

import java.io.Reader;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.vo.AddressVO;

public class AddressDao {

	public int addrIns(AddressVO pVO) {
		System.out.println("AddressDao addrIns호출 성공");
		SqlMapClient sqlMap = null;
		String resource = "com/iBatis/SqlMapConfig.xml";
		Reader reader = null;
		int result = 0;//입력이 성공했을 때 1, 실패했을 때 0
		try {
			reader = Resources.getResourceAsReader(resource);
			sqlMap = 
			SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
/*			pVO = new AddressVO(); 데모버전
			pVO.setId(0);
			pVO.setName("홍길동");
			pVO.setAddress("서울시 구로구 독산동");
			pVO.setBirthday("1990-10-15");
			pVO.setComments("개발자");
			pVO.setGender("1");
			pVO.setHp("010-458-7856");
			pVO.setRegisterdate("2016-11-29");
			pVO.setRelationship("고교동창");*/
			result=sqlMap.update("addrIns",pVO);//쿼리문 호출
			if(result == 1){
				System.out.println("입력 성공");
			}
			else{
				System.out.println("입력 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//result = pstmt.executeUpdate();
		return result;
	}

	public List<AddressVO> getAddrList(AddressVO pVO) {
		List<AddressVO> addrList = null;
		SqlMapClient sqlMap = null;
		String resource = "com/iBatis/SqlMapConfig.xml";
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(resource);
			sqlMap = 
			SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
			addrList = sqlMap.queryForList("getAddrList", pVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return addrList;
	}

	public int addrDel(AddressVO pVO) {
		System.out.println("addrDel호출");
		SqlMapClient sqlMap = null;
		String resource = "com/iBatis/SqlMapConfig.xml";
		Reader reader = null;
		int result = 0;//입력이 성공했을 때 1, 실패했을 때 0
		try {
			reader = Resources.getResourceAsReader(resource);
			sqlMap = 
			SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
			result=sqlMap.delete("addrDel",pVO);//쿼리문 호출
			if(result == 1){
				System.out.println("삭제 성공");
			}
			else{
				System.out.println("삭제 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return result;
	}

	public int addrUpd(AddressVO pVO) {
		SqlMapClient sqlMap = null;
		String resource = "com/iBatis/SqlMapConfig.xml";
		Reader reader = null;
		int result = 0;//입력이 성공했을 때 1, 실패했을 때 0
		try {
			reader = Resources.getResourceAsReader(resource);
			sqlMap = 
			SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
			result=sqlMap.update("addrUpd",pVO);//쿼리문 호출
			if(result == 1){
				System.out.println("수정 성공");
			}
			else{
				System.out.println("수정 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result ;
	}

}






