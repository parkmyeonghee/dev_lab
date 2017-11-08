<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
//화면단에서 입력한 값을 서버페이지에서 호출할 때는 반드시 name속성을 사용
String u_id=request.getParameter("mem_id");
String h_val=request.getParameter("h_val");
//outprint는 콘솔이 아니라 브라우저에 쓴다.
out.print("사용자가 입력한 아이디:"+u_id);
out.print("<br>");
out.print("숨겨진 값 출력하기:"+h_val);
 
%>