<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import="java.net.URLDecoder,com.vo.ExamineeVO" %>
    <%
    Cookie cookies[] = request.getCookies();
    ExamineeVO eVO = new ExamineeVO();
    String exam_cd =null;
    if(cookies != null && cookies.length>0){
    	for(int i =0;i<cookies.length;i++){
    	/* 	out.print(cookies[i].getName());
    		out.print("<br>");
    		out.print(URLDecoder.decode(cookies[i].getValue(),"utf-8")); */
    		if("cexamcd".equals(cookies[i].getName())){
    			exam_cd=cookies[i].getValue();
    		}
    		else if("cname".equals(cookies[i].getName())){
    		eVO.setT_name(URLDecoder.decode(cookies[i].getValue(),"utf-8"));
    		}
    		else if("ctestno".equals(cookies[i].getName())){
    			eVO.setTest_no(cookies[i].getValue());
    		}
    		else if("cscore".equals(cookies[i].getName())){
    			eVO.setScore(Integer.parseInt(cookies[i].getValue()));
    		}
    		else if("cdecision".equals(cookies[i].getName())){
    			eVO.setDecision(URLDecoder.decode(cookies[i].getValue(),"utf-8"));
    		}
    	}
    }
    %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>성적표(testResult.jsp)</title>
<script type="text/javascript">
 function confirm(){
	 location.href="testResultAction.jsp";
 }
</script>
</head>
<body>
<table border ="1" align="center" width="250" height="150">
<tr>
<td colspan="2" width="250"><%=eVO.getT_name()%>님의 성적표</td>
</tr>
<tr>
<td width="120">문제코드</td>
<td width="130"><%=exam_cd%></td>
</tr>
<tr>
<td width="120">수험번호</td>
<td width="130"><%=eVO.getTest_no()%></td>
</tr>
<tr>
<td width="120">성명</td>
<td width="130"><%=eVO.getT_name()%></td>
</tr>
<tr>
<td width="120">점수</td>
<td width="130"><%=eVO.getScore()%></td>
</tr>
<tr>
<td width="120">판정여부</td>
<td width="130"><%=eVO.getDecision()%></td>
</tr>
</table>
<table border ="0" align="center" width="250" height="150">
<tr>
<td width="250">
<input type="button" id="btn_ok" value="확인" onClick=>
</td>
</tr>
</table>
</body>
</html>