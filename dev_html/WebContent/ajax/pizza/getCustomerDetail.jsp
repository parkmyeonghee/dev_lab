<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import="com.pizza.CustomerInfo " %>
    <%@page import="com.vo.CustomerVO" %>
<%
	String u_tel=request.getParameter("tel");
	CustomerInfo cInfo = new CustomerInfo();
	cInfo.init();
	String getAddr="";
	for(int i=0;i<cInfo.cVOs.length;i++){
		if(cInfo.cVOs[i].getTel().equals(u_tel)){//��ȭ��ȣ�� ����?
			getAddr=cInfo.cVOs[i].getAddress();
		
		}
	}
	//������ ����ĳ�ÿ� ���� �ִ� ���� �����ϱ�
	out.clear();
	out.print(getAddr);
	//String u_name=request.getParameter("name");
	//String u_address=request.getParameter("address");
	
%>