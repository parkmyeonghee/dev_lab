package com.mvc;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.dao.DataAccessException;

import com.vo.BoardMasterVO;
import com.vo.BoardSubVO;

public class BoardDao {
	Logger logger =Logger.getLogger(BoardDao.class);
	public SqlSessionTemplate sqlSessionTemplate =null;
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	public int getBgroup(BoardMasterVO pbmVO){
		int b_group=0;
		b_group=sqlSessionTemplate.selectOne("getBgroup",pbmVO);
		return b_group;
	}
	public int bStepUpdate(BoardMasterVO pbmVO){
		int result=0;
		result=sqlSessionTemplate.update("bStepUpdate",pbmVO);
		return result;
	}
	public int boardMasterInsert(BoardMasterVO pbmVO) throws DataAccessException{
		logger.info("MboardInsert");
		int result=0;
		sqlSessionTemplate.insert("boardMasterInsert",pbmVO);
		return result;
	}
	public int boardSubInsert(BoardSubVO pbsVO) throws DataAccessException{
		logger.info("SsboardInsert"); 
		int result=0;
		sqlSessionTemplate.insert("boardSubInsert",pbsVO);
		return result;
	}
	public List<Map<String, Object>> getboardList(BoardMasterVO pbmVO) {
		List<Map<String, Object>> boardList=null;
		boardList =sqlSessionTemplate.selectList("getBoardList",pbmVO); 
		return boardList;
	}
	public int boardMasterUpdate(BoardMasterVO pbmVO) {
		int result=0;
		sqlSessionTemplate.update("boardMasterUpdate",pbmVO);
		return result;
	}
	public int boardSubUpdate(BoardSubVO pbsVO) {
		int result=0;
		sqlSessionTemplate.update("boardSubUpdate",pbsVO);
		return result;
	}
	public int boardMasterDelete(BoardMasterVO pbmVO) {
		int result=0;
		result=sqlSessionTemplate.delete("boardMasterDelete",pbmVO);
		return result;
	}
	public int boardSubDelete(BoardSubVO pbsVO) {
		int result=0;
		result=sqlSessionTemplate.delete("boardSubDelete",pbsVO);
		return result;
	}
	public int totalRecord() {
		int total=0;
		
		sqlSessionTemplate.selectOne("btotalRecord");
		return total;
	}
}
