<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.util.*" %>
<%
	String p_name = HangulConversion.toKor(request.getParameter("name"));
	String p_size = request.getParameter("size");
	String p_beverage = request.getParameter("beverage");
	String p_coffeemaker = request.getParameter("coffeemaker");
	for(double i=0;i<9000000000.0;i++){
		//커피 만드는 시늉을 한다.
	}
	//이것을 빼면 2번커피포트만 비워진다. 왜냐면 앞에 입력된값이 계속 버퍼에 남아있기때문이다.--삽질짱.	
	out.clear();
	out.print(p_coffeemaker+p_name);
%>