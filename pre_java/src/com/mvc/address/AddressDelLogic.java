package com.mvc.address;

import com.vo.AddressVO;

public class AddressDelLogic {

	public AddressVO addrDel(AddressVO pVO) {
		System.out.println("AddressDelLogic»£√‚");
		AddressVO rVO = new AddressVO();
		AddressDao aDao = new AddressDao();
		int result = aDao.addrDel(pVO);
		rVO.setResult(result);
		return rVO;
	}

}
