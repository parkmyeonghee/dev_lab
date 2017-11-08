<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.List, com.vo.BoardMasterVO" %> 
<%@ page import="com.google.gson.Gson" %>   
<%
   List<BoardMasterVO> boardList = 
   (List<BoardMasterVO>)request.getAttribute("boardList");
   Gson g = new Gson();
   String gsonBoard = g.toJson(boardList);
   out.print(gsonBoard);
%>