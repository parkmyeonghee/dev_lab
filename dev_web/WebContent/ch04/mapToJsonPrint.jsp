<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
   <%@page import="org.json.simple.JSONValue"%>
   <%@page import="java.util.Map,java.util.LinkedHashMap" %>
   <%@page import="java.util.List,java.util.ArrayList" %>
   <!--
   학습 목표
   1.외부 라이브러리를 사용할 때 적당한 배포위치를 선택할 수 있다.
   2.XXX.jsp페이지를 이용해서 다양한 형태로 클라이언트측에 
   출력 결과를 내보낼 수 있다.
   :html문서
   :xml문서 -UI솔루션을 사용해서 화면을 내보낼 때
   :json문서-easyui같은 자바스크립트 기반의 UI솔루션을 사용해서 화면을 내보낼 때
   				xml보다 가볍고 별도의 parser가 필요 없다.
    -->
    <%
    List<Map<String,String>> bookList = new ArrayList<Map<String,String>>();
    Map<String,String> map = new LinkedHashMap<String,String>();
    //순서대로 처리 하고 싶을 때 LinkedHashMap을 사용
    map.put("b_title","JAVA의 정석");
    map.put("b_author","남궁성");
    map.put("b_img","pic.png");
    bookList.add(map);
    
	map = new LinkedHashMap<String,String>();
    map.put("b_title","Oracle11g프로그래밍");
    map.put("b_author","성윤정");
    map.put("b_img","pic2.png");
    bookList.add(map);
    
    map = new LinkedHashMap<String,String>();
    map.put("b_title","Jsp2.3웹프로그래밍");
    map.put("b_author","최범균");
    map.put("b_img","pic3.png");
    bookList.add(map);
    String jsonText =JSONValue.toJSONString(bookList);
    out.print(jsonText);
    %>
    
    
    