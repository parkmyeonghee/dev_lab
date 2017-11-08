package com.ajax.member;

import java.util.List;

import org.apache.log4j.Logger;

import com.vo.MemberVO;

public class MemberLogic {
	Logger logger = Logger.getLogger(MemberLogic.class);
	public List<MemberVO> getMemberList(){
		logger.info("getMemberList 호출 성공");
		List<MemberVO> memList=null;
		MemberDao memDao = new MemberDao();
		memList= memDao.getMemberList();
		return memList;
	}
	public MemberVO login(MemberVO pmVO){
		logger.info("getMemberList 호출 성공");
		MemberVO rmVO=null;
		MemberDao memDao = new MemberDao();
		rmVO= memDao.login(pmVO);
		return rmVO;
	}
}
