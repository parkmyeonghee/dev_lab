package com.ajax.memo;

import java.util.List;

import org.apache.log4j.Logger;

import com.vo.MemoVO;

public class MemoLogic {
	Logger logger = Logger.getLogger(MemoLogic.class);
/*************************************************************************************************
 * 
 * @param moVO -����ڰ� �Է��� ����
 * @return miResult - 1:�Է¼��� 0:�Է½���
 ***********************************************************************************************/
	public int memoInsert(MemoVO moVO) {
		logger.info("memoInsertȣ�� ����");
		int miResult=0;
		MemoDao moDao = new MemoDao();
		miResult =moDao.memoInsert(moVO);
		return miResult;
	}
	/******************************************************************************************
	 * ���� ������ ��� ����
	 * @param moVO -���ǿ� ��� ���̵�
	 * @return List<MemoVO>
	***************************************************************************************** */
	public List<MemoVO> getReceiveMemoList(MemoVO moVO){
		logger.info("getReceiveMemoList ȣ�⼺��");
		List<MemoVO> memoList=null;
		MemoDao moDao = new MemoDao();
		memoList =moDao.getReceiveMemoList(moVO);
		return memoList;
	}
	public List<MemoVO> getSendMemoList(MemoVO moVO){
		logger.info("getReceiveMemoList ȣ�⼺��");
		List<MemoVO> memoList=null;
		MemoDao moDao = new MemoDao();
		memoList =moDao.SendMemoList(moVO);
		return memoList;
	}
	public int memoDelete(MemoVO moVO) {
		logger.info("memoDeleteȣ�� ����");
		int mdResult=0;
		MemoDao moDao = new MemoDao();
		mdResult =moDao.memoDelete(moVO);
		return mdResult;
	}
	public int memoUpdate(MemoVO moVO) {
		logger.info("memoUpdateȣ�� ����");
		int muResult=0;
		MemoDao moDao = new MemoDao();
		muResult =moDao.memoUpdate(moVO);
		return muResult;
	}
	
}
