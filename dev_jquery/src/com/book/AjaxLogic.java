package com.book;

import java.util.List;

import org.apache.log4j.Logger;

import com.vo.PictureVO;
import com.vo.WordVO;

public class AjaxLogic {
	Logger logger = Logger.getLogger(AjaxLogic.class);
	public List<WordVO> getWordList(String pwword) {
		AjaxDao aDao = new AjaxDao();
		List<WordVO> wordList = aDao.getWordList(pwword);
		return wordList;
	}
	public List<PictureVO> getPictureList(String pnum) {
		AjaxDao aDao = new AjaxDao();
		List<PictureVO> picList = aDao.getPictureList(pnum);
		return picList;
	}

}
