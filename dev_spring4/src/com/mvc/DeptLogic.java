package com.mvc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vo.DeptVO;
import com.vo.EmpVO;

@Service
public class DeptLogic {
	Logger logger = Logger.getLogger(DeptLogic.class);
	@Autowired
	public SqlMapDeptDao sqlMapDeptDao = null;
	
	@Autowired
	public SqlMapEmpDao sqlMapEmpDao = null;
/******************************************************************************
 * 트랜잭션 처리 테스트 처리하기
 * 1)부서 테이블에 새로운 부서 정보 등록하기
 * deptno=80,dname="자동차",loc="평택"
 * 2)사원 테이블에 신입직원 등록하기
 * empno=8001,ename=김유신,deptno=80
 * 테스트 시나리오
 * 1번은 정상적으로 처리되도록 하고
 * 2번에서는 컬럼명을 잘못 작성하여 부적합한 식별자 오류가 발생하도록 처리
 * 1번과2번 모두가 정상적으로 처리되었을 때 커밋하고
 * 둘 중 하나라도 실패하였을 때는 rollback처리
 * 주의 사항
 * 부서관리와 사원관리에 대한 Logic클래스가 서로 다르므로 SqlMapEmDao도
 * 객체 주입을 받을 수 있도록 코드를 추가
 * 사용자로 부터 입력받을 값을 상수로 추가하여 테스트
 * @param pMap
 * @param req
 * @return
 *******************************************************************************/
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={DataAccessException.class})
	@Pointcut(value="exrcution(*com.mvc.*Logic.*(..))")
	public void trTest(){
		int dResult=0;
		int eResult=0;
		Map<String,Object>pMap= new HashMap<String,Object>();
		pMap.put("deptno",80);
		pMap.put("dname", "자동차");
		pMap.put("loc", "평택");
		pMap.put("empno", 8001);
		pMap.put("ename", "김유신");
		EmpVO peVO = new EmpVO();
		peVO.setEmpno(8001);
		peVO.setEname("김유신");
		peVO.setDeptno(80);
		//아래 코드에서 SQLException이 발생할 수 있으므로 예외처리를 활용하여
		//커밋과 롤백을 적용해 봅시다.
		//예외가 발생하면 rollback()메소드를 호출하고 문제가 없을 땐 commit()함/
		try {
		dResult =sqlMapDeptDao.getDeptInsert(pMap);
		eResult=sqlMapEmpDao.empInsert(peVO);
		} catch (DataAccessException de) {
			throw de;
		}
	}
	public List<HashMap> getDeptList(Map<String, Object> pMap,HttpServletRequest req) {
		logger.info("getDeptList 호출성공");
		List<HashMap>deptList=null;
		//페이징 처리 로직 추가 -start 와 end 변수를 추가
		int total=0; //전체 레코드 갯수
		total=sqlMapDeptDao.totalRecord();
		//total값을 json파일에 담으면 datagrid에 추가
		//total값은 datagrid에 추가될 값이 아니므로 세션을 사용하여 담습니다.
		if(req !=null){
		HttpSession session = req.getSession();
		session.setAttribute("total", total);
		}
		//화면(currentPage:pMap)에서 받아오는 값
		int page=0;//현재 사용자가 바라보는 페이지 번호(1,2,...)
		//한 페이지에 처리 되는 로우(화면:pMap)
		int pageSize=0;
		if(pMap.get("page")!=null)
			page=Integer.parseInt(pMap.get("page").toString());
		if(pMap.get("pageSize")!=null)
			pageSize=Integer.parseInt(pMap.get("pageSize").toString());
		int start=0;//페이지의 시작번호
		int end=0;//페이지의 끝 번호
		if(page<0){
			start=((page-1)*pageSize)+1;
			end=page*pageSize;
			pMap.put("start", start);
			//total이 end보다 작으면 end대신 total값을 담아 주세여
			//그렇지 않으면 end를 담아 주세요 
			pMap.put("end", end);
		if(total<end){
			pMap.put("end", total);
		}
		else{
			pMap.put("end", end);
		}
		}
		logger.info("start:"+start+"end"+end);
		deptList=sqlMapDeptDao.getDeptList(pMap);
		return deptList;
	}//////////////////////////////end of getDeptList
	//JSON코드 변환 관련 실습
	public List<DeptVO> getDeptList2(Map<String, Object> pMap,HttpServletRequest req) {
		logger.info("getDeptList2 호출성공");
		List<DeptVO>deptList=null;
		//페이징 처리 로직 추가 -start 와 end 변수를 추가
		int total=0; //전체 레코드 갯수
		total=sqlMapDeptDao.totalRecord();
		//total값을 json파일에 담으면 datagrid에 추가
		//total값은 datagrid에 추가될 값이 아니므로 세션을 사용하여 담습니다.
		if(req !=null){
		HttpSession session = req.getSession();
		session.setAttribute("total", total);
		}
		//화면(currentPage:pMap)에서 받아오는 값
		int page=0;//현재 사용자가 바라보는 페이지 번호(1,2,...)
		//한 페이지에 처리 되는 로우(화면:pMap)
		int pageSize=0;
		if(pMap.get("page")!=null)
			page=Integer.parseInt(pMap.get("page").toString());
		if(pMap.get("pageSize")!=null)
			pageSize=Integer.parseInt(pMap.get("pageSize").toString());
		int start=0;//페이지의 시작번호
		int end=0;//페이지의 끝 번호
		if(page<0){
			start=((page-1)*pageSize)+1;
			end=page*pageSize;
			pMap.put("start", start);
			//total이 end보다 작으면 end대신 total값을 담아 주세여
			//그렇지 않으면 end를 담아 주세요 
			pMap.put("end", end);
		if(total<end){
			pMap.put("total", total);
		}
		else{
			pMap.put("end", end);
		}
		}
		logger.info("start:"+start+"end"+end);
		deptList=sqlMapDeptDao.getDeptList2(pMap);
		return deptList;
	}
	
	public int deptInsert(Map<String, Object> pMap) {
		logger.info("getDeptInsert 호출성공");
		int result=0;
		result=sqlMapDeptDao.getDeptInsert(pMap);
		return result;
	}

	public int deptDelete(Map<String, Object> pMap) {
		logger.info("getDeptDelete 호출성공");
		int result=0;
		result=sqlMapDeptDao.getDeptDelete(pMap);
		return result;
	}

	public List<HashMap> getDeptnoList(Map<String, Object> pMap) {
		logger.info("getDeptnoList 호출성공");
		List<HashMap>deptList=null;
		deptList=sqlMapDeptDao.getDeptnoList(pMap);
		return deptList;
	}

	public int deptUpdate(Map<String, Object> pMap) {
		logger.info("DeptUpdate 호출성공");
		int result=0;
		result=sqlMapDeptDao.DeptUpdate(pMap);
		return result;
	}

}
