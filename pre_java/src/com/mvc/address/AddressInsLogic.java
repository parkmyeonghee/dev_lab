package com.mvc.address;

import com.vo.AddressVO;

public class AddressInsLogic {

	public AddressVO addrIns(AddressVO pVO) {
		System.out.println("AddressInsLogic addrInsȣ�� ����");
		AddressVO rVO = new AddressVO();
		AddressDao aDao = new AddressDao();
		int result = aDao.addrIns(pVO);
		rVO.setResult(result);
		return rVO;
	}

}
