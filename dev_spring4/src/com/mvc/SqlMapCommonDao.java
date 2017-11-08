package com.mvc;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

import com.vo.ZipCodeVO;

public class SqlMapCommonDao {
	Logger logger = Logger.getLogger(SqlMapCommonDao.class);
	public SqlSessionTemplate sqlSessionTemplate=null;
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	public List<Map<String, Object>> getZipCodeList(ZipCodeVO zVO) {
		logger.info("getZipCodeList 호출 성공");
		List<Map<String,Object>> zipList= null;
		zipList=sqlSessionTemplate.selectList("getZipCodeList",zVO);
		return zipList;
	}

	
}
