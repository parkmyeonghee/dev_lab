package com.mvc.address;

import java.util.List;

import com.vo.AddressVO;
 
public class AddressSelLogic {

	public List<AddressVO> getAddrList(AddressVO pVO) {
		List<AddressVO> addrList = null;
		AddressDao aDao = new AddressDao();
		addrList = aDao.getAddrList(pVO);
		return addrList;
	}

}
