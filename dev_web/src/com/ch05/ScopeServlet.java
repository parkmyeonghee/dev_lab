package com.ch05;

import java.io.IOException;
/************************************************************************************************
 * 객체를 유지하는 방법을 알 수 있다.
 * 세번쩨 유형: servlet - Servlet
 * 예)게시판 수정하기(SELECT-UPDATE-SELECT) 혹은 게시판 글 등록(INSERT-SELECT)하기
 * 입력|수정|삭제|조회
 * 서블릿에서 위 4가지 업무를 어떻게 분기하지?
 * 
 * 서블릿 내에서 다른 메소드를 정의 할 수 있나?
 * ===> 할 수 있다.
 * 서블릿 내에서 개발자가 정의한 메소드를 호출할 수 있나?
 * =====>개발자가 메소드를 호출 할 수 없다.
 * ===>이유는? 
 * 서블릿을 직접 인스턴스화: 했다|아니다
 * 서블릿에 대한 객체 관리는 Was에서 담당한다.
 * :서블릿의 라이프 사이클 -Was
 * 
 * 
 *************************************************************************************/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class ScopeServlet extends HttpServlet {
	Logger logger =Logger.getLogger(ScopeServlet.class);
	public void doGet(HttpServletRequest req
							, HttpServletResponse res)
	throws ServletException,IOException
	{
		logger.info("doget 호출 성공");
		//INS|UPD|DEL|SELECT
		String command =req.getParameter("command");
		if("INS".equals(command)){//등록이니?
			logger.info("등록이니?");
			//0이면 등록 실패
			//1이면 등록 성공
			int result =1;
			//result = boardInsert();
			if(result==0){//등록 실패
				res.sendRedirect("./boardInsertFail.jsp");
			}
			else if(result==1){//등록 성공
				res.sendRedirect("./boardInsertOK.jsp");
			}
		}
		else if("UPD".equals(command)){//수정이니?
			logger.info("수정이니?");
		}
		else if("DEL".equals(command)){//삭제니?
			logger.info("삭제니?");
		}
		else if("SEL".equals(command)){//상세조회니?
			logger.info("전체조회니?");
			//자료 구조의 제네릭 사용시
			//주소번지를 두 번 접근해야 값을 출력 가능
			List<HashMap<String,Object>> list 
			=new ArrayList<HashMap<String,Object>>();
			HashMap<String,Object> pMap
			= new HashMap<String,Object>();
			pMap.put("mem_id","test");
			pMap.put("mem_pw","123");
			pMap.put("mem_name", "시오밍");
			req.setAttribute("list",list);
			RequestDispatcher view =
					req.getRequestDispatcher("list.jsp");
			view.forward(req, res);
			
		}
/*		String mem_id = req.getParameter("mem_id");
		String mem_pw = req.getParameter("mem_pw");
		req.setAttribute("mem_id", mem_id);
		req.setAttribute("mem_pw", mem_pw);
		RequestDispatcher view =
				req.getRequestDispatcher("end2.jsp");
		view.forward(req, res);*/
	}
}
