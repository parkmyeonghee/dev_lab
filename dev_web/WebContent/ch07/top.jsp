<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%    /* 
    index.jsp에 include되는 페이지들은 모두 별도의 자바코드로 생성 되므로 변수를 공유할 수 없다.
    만일 꼭 유지하고 싶은 정보가 있을 때는 어떡하지?
    */
    //out.print(menu); 앙댐
	String name=(String)request.getAttribute("mem_name");
	String mem_id=(String)request.getAttribute("mem_id");
	String mem_pw=(String)request.getAttribute("mem_pw");
    out.print(name);
	
	mem_id=(String)request.getParameter("mem_pw");
	mem_pw=(String)request.getParameter("mem_pw");
	String mem_name=request.getParameter("mem_name");
	out.print(mem_id+","+mem_pw+","+mem_name); //시오밍
    %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table width="100%" height="100%" border="1" bordercolor="pink">
<tr>
<td align="center" >
<table width="100%" height="100"> 
<!--제목출력  -->
<tr>
<td align="center" >페이지의 모듈화와 요청 흐름제어</td>
</tr>
<!--메뉴출력  -->
<tr>
<td align="center" valign="bottom">
<a href="./index.jsp?menu=loginForm"> 로그인</a>
|
<a href="./index.jsp?menu=memberForm"> 회원가입</a>
|
<a href="./index.jsp?menu=boardList">게시판</a>
|
<a href="./index.jsp?menu=info"> 회사소개</a>
|
<a href="./index.jsp?menu=location"> 찾아오시는길</a>
</td>
</tr>
</table>
</tr>
</table>
</body>
</html>