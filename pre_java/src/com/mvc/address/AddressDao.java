package com.mvc.address;

import java.io.Reader;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.vo.AddressVO;

public class AddressDao {

	public int addrIns(AddressVO pVO) {
		System.out.println("AddressDao addrInsȣ�� ����");
		SqlMapClient sqlMap = null;
		String resource = "com/iBatis/SqlMapConfig.xml";
		Reader reader = null;
		int result = 0;//�Է��� �������� �� 1, �������� �� 0
		try {
			reader = Resources.getResourceAsReader(resource);
			sqlMap = 
			SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
/*			pVO = new AddressVO(); �������
			pVO.setId(0);
			pVO.setName("ȫ�浿");
			pVO.setAddress("����� ���α� ���굿");
			pVO.setBirthday("1990-10-15");
			pVO.setComments("������");
			pVO.setGender("1");
			pVO.setHp("010-458-7856");
			pVO.setRegisterdate("2016-11-29");
			pVO.setRelationship("����â");*/
			result=sqlMap.update("addrIns",pVO);//������ ȣ��
			if(result == 1){
				System.out.println("�Է� ����");
			}
			else{
				System.out.println("�Է� ����");
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
		System.out.println("addrDelȣ��");
		SqlMapClient sqlMap = null;
		String resource = "com/iBatis/SqlMapConfig.xml";
		Reader reader = null;
		int result = 0;//�Է��� �������� �� 1, �������� �� 0
		try {
			reader = Resources.getResourceAsReader(resource);
			sqlMap = 
			SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
			result=sqlMap.delete("addrDel",pVO);//������ ȣ��
			if(result == 1){
				System.out.println("���� ����");
			}
			else{
				System.out.println("���� ����");
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
		int result = 0;//�Է��� �������� �� 1, �������� �� 0
		try {
			reader = Resources.getResourceAsReader(resource);
			sqlMap = 
			SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
			result=sqlMap.update("addrUpd",pVO);//������ ȣ��
			if(result == 1){
				System.out.println("���� ����");
			}
			else{
				System.out.println("���� ����");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result ;
	}

}






