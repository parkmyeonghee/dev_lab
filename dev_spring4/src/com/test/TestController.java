package com.test;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;

public class TestController {
	Logger logger = Logger.getLogger(TestController.class);
	@RequestMapping(value="/test/methodA.kosmo")
	public String methodA(){
		logger.info("methodA호출 성공");
		//페이지 요청 URL->/WEB-INF/jsp/testMethodA.jsp
		return "test/testMethodA";
	}
}
