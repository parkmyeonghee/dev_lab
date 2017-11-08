<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
Cookie cookies[] =request.getCookies();
if(cookies !=null && cookies.length>0){
	for(int i=0;i<cookies.length;i++){
		Cookie cookie = new Cookie(cookies[i].getName(),"");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	}
}
%>
<script type="text/javascript">
</script>