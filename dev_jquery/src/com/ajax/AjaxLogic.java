package com.ajax;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.vo.PictureVO;
import com.vo.WordVO;


public class AjaxLogic {
	Logger logger = Logger.getLogger(AjaxLogic.class);
	public List<WordVO> getWordList(Map<String, Object> pMap,HttpServletRequest req) {
		logger.info("getWordListȣ�⼺��");
		List<WordVO> wordList=null;
		AjaxDao aDao = new AjaxDao();
		wordList=aDao.getWordList(pMap);
		return wordList;
	}
	public List<PictureVO> getPictureList(String pnum) {
		logger.info("getPictureListȣ�� ����");
		List<PictureVO>picList=null;
		AjaxDao aDao = new AjaxDao();
		picList=aDao.getPictureList(pnum);
		return picList;
	}
	public List<PictureVO> getPictureDetail(String pnum) {
		logger.info("getPictureDetailtȣ�� ����");
		List<PictureVO>picDetail=null;
		AjaxDao aDao = new AjaxDao();
		picDetail=aDao.getPictureDetail(pnum);
		return picDetail;
	}
}
