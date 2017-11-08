<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.*"%>
    <%-- "java.util.List,java.util.ArrayList" --%>
    <%
    /*
    sonata.jsp는 WAS에 jsp컨테이너에 의해 sonata_jsp.java코드로 변경
    sonata_jsp.java는 servlet컨테이너에 의해 sonata_jsp.class로 컴파일 됩니다.
    sonata_jsp.class에서 출력문에 들어있는 코드들이 클라이언트로 다운로드 된다.
    다운로드된 코드들은 브라우저에 의해 인터프리터 되어 화면에 출력.
    컨테이너 마다 XXX.jsp를 자바 코드로변경하는 명명 규칙이 다를 수 있다
    이 클래스 이름을 확인할 수 있지만
    이 객체에 대한 라이프 사이클에 대한 관리는 WAS에 의해 이루ㅇ어짐
    우리(개발자)가 임의로 인스턴스화 하더라도 그 안전성을 보장받을 수 없을것
    결론
    jsp페이지 안에서 구현된 메소드는 재사용성이 떨어짐
    결합도도높아서 단위테스트 하거나 활용하는데도 불편하다.
    */
    //스크립틀릿 - 자바영역
    speedUp();
    List<String> nameList = new ArrayList<String>();
    nameList.add("홍길동");
    nameList.add("김유신");
    nameList.add("강감찬");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!-- html영역 입니다.  -->
<!--body 태그 안에있는게 실제 화면에 출력 됌.  -->
<%!
//디클러레이션-젼역변수
//초기화 생략가능합니다.
String carName="2017년형 소나타";
int speed=0;
int wheelNum=0; //서비스 메소드 밖에 선언된다.
public void speedUp(){
	speed+=1;
}
public void speedDown(){
	speed -=1;
}
%>
<%
//스크립틀릿에 사용할 수 있는 코드는
//제어문,제어변수,인스턴스화,메소드 호출,변수선언,try..catch
//김유신 출력(브라우저)해 보기
//스크립틀릿-out.print(nameList.get(1));
out.print(nameList.get(0));
out.print("<br>");
out.print(nameList.get(1));
out.print("<br>");
out.print(nameList.get(2));
out.print("<hr>");
for(int i=0;i<nameList.size();i++){ //nameList: 지역변수
	out.print(nameList.get(i)+"<br>");
	//out.print("<br>");
}
%>
<%="현재 소나타의 속도:"+speed %>
</body>
</html>