package com.mvc.address;

import java.util.List;

import com.vo.AddressVO;

public class AddressController {
	private static final String _DEL = "delete";//삭제
	private static final String _INS = "insert";//입력
	private static final String _UPD = "update";//수정
	private static final String _SEL = "select";//상세조회
	private static final String _ALL = "selectall";//전체조회
	//send , sendALL
	public AddressVO send(AddressVO pVO){
		AddressVO rVO = null;
		//너 입력했니?
		if(_INS.equals(pVO.getCommand())){
			System.out.println("AddressController 입력호출 성공");
			AddressInsLogic aiLogic 
						= new AddressInsLogic();
			rVO = aiLogic.addrIns(pVO);//rVO.getResult()=>1
		}
		//너 수정을 원해?
		else if(_UPD.equals(pVO.getCommand())){
			AddressUpdLogic auLogic
						= new AddressUpdLogic();
			rVO=auLogic.addrUpd(pVO);
		}
		//너 삭제를 원해?
		else if(_DEL.equals(pVO.getCommand())){
			System.out.println("delete");
			AddressDelLogic adLogic
						= new AddressDelLogic();	
			rVO = adLogic.addrDel(pVO);
		}		
		//너 한친구 상세정보만 보고싶어?
		else if(_SEL.equals(pVO.getCommand())){
			AddressSelLogic asLogic
						= new AddressSelLogic();
			List<AddressVO> addrList = asLogic.getAddrList(pVO);
			rVO = addrList.get(0);
			System.out.println(rVO+", "+addrList.get(0));
		}
		return rVO;
	}////////////////////// end of send
	public List<AddressVO> sendALL(AddressVO pVO){
		List<AddressVO> addrList = null;
		AddressSelLogic asLogic = new AddressSelLogic();
		addrList = asLogic.getAddrList(pVO);
		return addrList;
	}
	
}









