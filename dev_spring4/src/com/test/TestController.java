package com.test;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;

public class TestController {
	Logger logger = Logger.getLogger(TestController.class);
	@RequestMapping(value="/test/methodA.kosmo")
	public String methodA(){
		logger.info("methodAȣ�� ����");
		//������ ��û URL->/WEB-INF/jsp/testMethodA.jsp
		return "test/testMethodA";
	}
}
