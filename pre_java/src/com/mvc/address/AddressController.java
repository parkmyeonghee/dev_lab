package com.mvc.address;

import java.util.List;

import com.vo.AddressVO;

public class AddressController {
	private static final String _DEL = "delete";//����
	private static final String _INS = "insert";//�Է�
	private static final String _UPD = "update";//����
	private static final String _SEL = "select";//����ȸ
	private static final String _ALL = "selectall";//��ü��ȸ
	//send , sendALL
	public AddressVO send(AddressVO pVO){
		AddressVO rVO = null;
		//�� �Է��ߴ�?
		if(_INS.equals(pVO.getCommand())){
			System.out.println("AddressController �Է�ȣ�� ����");
			AddressInsLogic aiLogic 
						= new AddressInsLogic();
			rVO = aiLogic.addrIns(pVO);//rVO.getResult()=>1
		}
		//�� ������ ����?
		else if(_UPD.equals(pVO.getCommand())){
			AddressUpdLogic auLogic
						= new AddressUpdLogic();
			rVO=auLogic.addrUpd(pVO);
		}
		//�� ������ ����?
		else if(_DEL.equals(pVO.getCommand())){
			System.out.println("delete");
			AddressDelLogic adLogic
						= new AddressDelLogic();	
			rVO = adLogic.addrDel(pVO);
		}		
		//�� ��ģ�� �������� ����;�?
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









