package com.cookie;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.util.Action;
import com.util.ActionForward;
import com.vo.ExamineeVO;
import com.vo.TakeVO;

public class OnLineTestAction implements Action {
	Logger logger = Logger.getLogger(OnLineTestAction.class);
	/************************************************************************************
	 * 시험 응시 기능 구현
	 * 설명
	 * 답안지 작성을 마친 후 제출 버튼을 클릭하면 /take.test를 호출한다.
	 * ->OnLineTestAction클래스의 execute메소드 호출
	 * ->OnLineTestLogic 클래스의 marking메소드 호출
	 * ->OnLineTestDao클래스의 takeInsert메소드 호출-INSERT
	 * ->1)OnLineTestDao클래스의 getRightAnswer메소드 호출 -SELECT
	 * ->2)OnLineTestDao클래스의 getTake메소드 호출-SELEC
	 * ->위1,2번 값 비교 - 채점하고 평가 점수 산출
	 * ->OnLineTestDao클래스의 examineeUpdate메소드 호출-UPDATE
	 * ->OnLineTestDao클래스의 getExamineeDetail메소드 호출=SELECT
	 * 
	 ************************************************************************************/
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		logger.info("execute 메소드 호출 성공");//OnLineTestFrontController
		//->OnLineTestAction
		//->OnLineTestLogic
		//->OnLineTestDao
		Cookie cTest[] = req.getCookies();
		ExamineeVO peVO = new ExamineeVO();
		TakeVO ptVO = new TakeVO();
		for(int i=0;i<cTest.length;i++){
			if("test1".equals(cTest[i].getName())){
				logger.info("1번답안"+cTest[i].getValue());
				ptVO.setTake1(Integer.parseInt(cTest[i].getValue()));
			}
			else if("test2".equals(cTest[i].getName())){
				logger.info("2번답안"+cTest[i].getValue());
				ptVO.setTake2(Integer.parseInt(cTest[i].getValue()));
			}
			else if("test3".equals(cTest[i].getName())){
				logger.info("3번답안"+cTest[i].getValue());
				ptVO.setTake3(Integer.parseInt(cTest[i].getValue()));
			}
			else if("test4".equals(cTest[i].getName())){
				logger.info("4번답안"+cTest[i].getValue());
				ptVO.setTake4(Integer.parseInt(cTest[i].getValue()));
			}
			/*******************************************[누가,무엇을]**************************************************/
			else if("cname".equals(cTest[i].getName())){
				logger.info("이름"+
								URLDecoder.decode(cTest[i].getValue(),"utf-8"));
				peVO.setT_name(URLDecoder.decode(cTest[i].getValue(),"utf-8"));
			}
			else if("ctestno".equals(cTest[i].getName())){
				logger.info("수험번호"+
								cTest[i].getValue());
				//쿠키에 담겨있는 수험번호를 TakeVO와 ExamineeVO에 담기
				//TakeVO에 담긴 값은 답안지 테이블에 insert할 때 사용할 값
				ptVO.setTest_no(cTest[i].getValue());
				//ExamineeVO에 담긴 값은 수험생 테이블에 update할 때 사용할 값
				peVO.setTest_no(cTest[i].getValue());
			}
			else if("cexamcd".equals(cTest[i].getName())){
				logger.info("문제코드"+
								cTest[i].getValue());
				ptVO.setExam_cd(cTest[i].getValue());
			}
			/***********************************************************************************************/
			//5번 문항에 대한 답안지는 쿠키에 담겨 있지 않습니다.
			//따라서 test5이름은 존재하지 않음
		/*	else if("test5".equals(cTest[i].getName())){
				logger.info("5번답안"+cTest[i].getValue());
			}*/
		}
		String test5 =req.getParameter("hn_test5");
		ptVO.setTake5(Integer.parseInt(test5));
		logger.info("5번답안:"+test5);
		//다음으로 할 일은 사용자가 입력한 답안지 정보를 TakeVO에 담아야 합니다
		//작성한 답안지 정보 출력해 보기 시작
		logger.info("take1:"+ptVO.getTake1());
		logger.info("take2:"+ptVO.getTake2());
		logger.info("take3:"+ptVO.getTake3());
		logger.info("take4:"+ptVO.getTake4());
		logger.info("take5:"+ptVO.getTake5());
		//현제 인증과정이 처리가 안되어 있어 수험번호가 담겨(쿠키에) 있지 않습니다.
		//작성한 답안지 정보 출력해 보기 끝
		ActionForward forward = new ActionForward();
		OnLineTestLogic testLogic = new OnLineTestLogic();
		/*
		 * @param peVO(쿠키에 담겨 있는 이름)
		 * @param ptVO(쿠키에 담겨 있는 수험 번호,문제코드,작성된 답안지)
		 */
		ExamineeVO reVO=testLogic.marking(peVO,ptVO);
		Cookie c1 = new Cookie("cexamcd",ptVO.getExam_cd());
		Cookie c2 = new Cookie("ctestno",reVO.getTest_no());
		Cookie c3 = new Cookie("ctname",URLEncoder.encode(reVO.getT_name(),"utf-8"));
		Cookie c4 = new Cookie("cscore",String.valueOf(reVO.getScore()));
		Cookie c5 = new Cookie("cdecision",URLEncoder.encode(reVO.getDecision(),"utf-8"));
		c1.setMaxAge(60*20);
		c2.setMaxAge(60*20);
		c3.setMaxAge(60*20);
		c4.setMaxAge(60*20);
		c5.setMaxAge(60*20);
		res.addCookie(c1);
		res.addCookie(c2);
		res.addCookie(c3);
		res.addCookie(c4);
		res.addCookie(c5);
		forward.setRedirect(false);
		forward.setPath("./testResult.jsp");
		return forward;
	}

}
