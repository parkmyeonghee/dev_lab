<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import="com.mvc.DeptController" %>
<%
//직접 인스턴스화를 한 경우(DI적용 안된 경우)
//문제점
//DeptController 라이프 사이클 관리 책임이 개발자에게 있다.
//개발자의 실력차에 따라서 객체 관리가 잘 안될 수 있다.
//스프링 프레임 워크에서는 객체관리를 대신 해준다..
	//DeptController deptCtrl = new DeptController();
	//deptCtrl.test();
%>
testResult.jsp페이지입니다.