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
	//��ü ���Թ����� �ΰ����� �ִ�.
	//������ ��ü ���Թ��� setter��ü ���Թ�
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
		//���������� URL->/WEB-INF/jsp/di/getInsaList.jsp
		mav.setViewName("di/getInsaList");
		mav.addObject("insaBean",insaBean);
		req.setAttribute("insaBean",insaBean);
		return mav;
	}

}
