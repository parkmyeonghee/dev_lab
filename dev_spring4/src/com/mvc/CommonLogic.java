package com.mvc;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vo.ZipCodeVO;

@Service
public class CommonLogic {
	Logger logger = Logger.getLogger(CommonLogic.class);
	@Autowired
	public SqlMapCommonDao sqlMapCommonDao = null;
	
	public List<Map<String, Object>> getZipCodeList(ZipCodeVO zVO) {
		logger.info("getZipCodeList 호출 성공");
		List<Map<String,Object>> zipList=null;
		zipList=sqlMapCommonDao.getZipCodeList(zVO);
		return zipList;
	}
	
	
}
