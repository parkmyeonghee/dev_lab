package com.ch03;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.omg.CORBA.Request;

import com.util.HashMapBinder;

public class FormServlet extends HttpServlet {
	Logger logger = Logger.getLogger(FormServlet.class);
	public void doGet(HttpServletRequest req
							,HttpServletResponse res)
	throws ServletException,IOException{
		logger.info("doGet호출성공");
		HashMapBinder hmb =new HashMapBinder(req);
		Map<String,Object> pMap=
				new HashMap<String,Object>();
		hmb.binder(pMap);
		//서버로 전송된 정보 출력해 보기
		Object keys[]=pMap.keySet().toArray();
		for(int i=0;i<keys.length;i++){
			String key= (String)keys[i];
			logger.info(key);
			logger.info(pMap.get(key));
		}
		//요청 객체에 주소번지 담기
		req.setAttribute("pMap", pMap);
		//sendRedirect
		//응답페이지에서 값 출력해야 하므로 forward로 보내자
		RequestDispatcher view = req.getRequestDispatcher("./FormResult.jsp");
		view.forward(req,res); //예외처리 해 주어야 하므로 IO예외 처리해줌
	}
}
