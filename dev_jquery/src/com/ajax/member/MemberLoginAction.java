package com.ajax.member;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.util.Action;
import com.util.ActionForward;
import com.vo.MemberVO;

public class MemberLoginAction implements Action {
	Logger logger = Logger.getLogger(MemberLoginAction.class);
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("execute ȣ�� ����");
		MemberDao mDao = new MemberDao();
		MemberVO mvo = new MemberVO();
		mvo.setMem_id(req.getParameter("mem_id"));
		mvo.setMem_pw(req.getParameter("mem_pw"));
		//name�� ��� �̸��� �ִٴ� ���� �α��ο� �����ߴٴ� �ǹ��Դϴ�.
		String name =mDao.login(mvo);
		HttpSession session =req.getSession();
		//������ ��Ű�� ��Ҵ� ������ ���ǰ�ü�� ���
		session.setAttribute("sname", name);
		Cookie cookie = 
				new Cookie("cname"
						  ,URLEncoder.encode(name,"utf-8"));
		cookie.setMaxAge(60*30);//��Ű �����ð� 30������ ����
		//��Ű�� ����� ���丮 ��θ� ����
		//setPath()����Ͽ� ��Ű�� ��θ� �����ϸ� ��������
		//������ ��� �Ǵ� ���� ��ο� ���ؼ��� ��Ű�� �����Ѵ�.
		//�Ʒ����� ������ �Ʒ� member�� �����Ͽ����Ƿ�
		//�������� cname��Ű�� /member�� �� ���� ��ο��� ����
		//�� �� �ִ�.
		cookie.setPath("/"); // �ٸ� url������ ��Ű ������ ����� �� �ִ�.
		res.addCookie(cookie);
		ActionForward forward = new ActionForward();
		forward.setPath("./logout.jsp"); //index.jsp ������ ���ΰ�ħ�̷���
		//�׷��Ƿ� ���⼱ ajax������ �ٲ���Ѵ�.
		//ajax ����� ������ �� -> �κ��������� ���� �ۼ��ؾ� �Ѵ�.
		//logout �������� ������.	
		forward.setRedirect(true);
		logger.info(forward.getPath());//null, "./index.jsp"
		return forward;
	}

}
