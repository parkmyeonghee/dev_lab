package com.mvc.address;

import com.vo.AddressVO;


public class AddressUpdLogic {

	public AddressVO addrUpd(AddressVO pVO) {
		AddressVO rVO= new AddressVO();
		AddressDao aDao= new AddressDao();
		int result = aDao.addrUpd(pVO);
		rVO.setResult(result);
		return rVO;
	}
	

}
