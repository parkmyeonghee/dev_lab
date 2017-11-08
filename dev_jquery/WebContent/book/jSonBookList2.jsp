<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import="com.google.gson.Gson" %>
    <%@page import="java.util.List,com.vo.BookVO" %>
<%
//서버에서 조회된 결과를 가져오기
List<BookVO> bookList = (List<BookVO>)request.getAttribute("bookList");
//List ->json포맷변환(출력)
	Gson g = new Gson();
	String jsonBook =g.toJson(bookList);
	out.print(jsonBook); //클라이언트 측 다운로드(브라우저에서 읽을 수 있다.-easyUI/datagrid)
	
%>