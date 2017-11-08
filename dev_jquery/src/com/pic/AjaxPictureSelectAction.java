package com.pic;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.util.Action;
import com.util.ActionForward;
import com.vo.PictureVO;
import com.vo.WordVO;

public class AjaxPictureSelectAction implements Action {
	Logger logger = Logger.getLogger(AjaxPictureSelectAction.class);
	@Override
	public ActionForward execute(HttpServletRequest req
			                   , HttpServletResponse res) throws ServletException, IOException {
		AjaxLogic ajLogic = new AjaxLogic();//���յ��� ����, �����׽�Ʈ ��ƴ�, ��������  ����
		String pnum = req.getParameter("num");//a or ab or abc
		List<PictureVO> picList = ajLogic.getPictureList(pnum);
		req.setAttribute("picList", picList);
		//������ �̵� - ���������� ȣ��
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);//true:sendRedirect(�����ȵȴ�), false:forward(����)
		forward.setPath("./pictureContentView.jsp");
		return forward;
	}

}
