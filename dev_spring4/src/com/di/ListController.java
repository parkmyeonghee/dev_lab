package com.di;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class ListController extends AbstractController {
	Logger logger = Logger.getLogger(ListController.class);
	List<String>insaBean=null;
	//객체 주입법에는 두가지가 있다.
	//생성자 객체 주입법과 setter객체 주입법
	public void setInsaBean(List<String> insaBean) {
		this.insaBean = insaBean;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {
		for(int i=0;i<insaBean.size();i++){
			logger.info("insaBean.get(i)");
		}
		ModelAndView mav = new ModelAndView();
		//응답페이지 URL->/WEB-INF/jsp/di/getInsaList.jsp
		mav.setViewName("di/getInsaList");
		mav.addObject("insaBean",insaBean);
		req.setAttribute("insaBean",insaBean);
		return mav;
	}

}
