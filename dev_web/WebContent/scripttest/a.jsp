<%
   String name="홍길동";
   //변수 i가 자바스크립트 변수라고 했을 때
   //가능한가?
   //int x = i;
   //자바스크립트에서 가지고 있는 값을 쿠키에 담을 수 없다. 
   //변수 i는 자바스크립트 변수라고 가정했을 때 
   //Cookie cookie = new Cookie("dap1",i);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>자바 대 자바스크립트</title>
<script type="text/javascript">
   function send(){
      $("#f_test").attr("method","get");
      $("#f_test").attr("action","./b.jsp");//a.jsp페이지에서 결정된 값을 받아서 쿠키에 담아보세요.
      $("#f_test").submit();
      
   }
</script>
</head>
<body>
<script type="text/javascript">
   var i =10;
   var j =<%=20%> //브라우저에 출력문자라 오류가 안남(익스프레션은 출력) 
   //var j(클라이언트측에서 처리) = 20;(서버측에서 처리된 결과가 반영);
   console.log("변수 j:"+j);//크롬브라우저에서 제공하는 별도의 api 
   //alert("변수 j:"+j);//다이얼로그창 
   //document.write("변수 j:"+j);
   var age = document.getElementById("i_age").value;
   //var age=$("i_age").val();
</script>
<form id="f_test">
   <input type="hidden" id="h_age" name="nh_age" value="40"><!--노출 안됨  -->
   <input type="text" id="i_age" name="age" value="<%=30%>"> <!--화면 노출  -->
   <input type="button" name="age" value="전송" onClick="send()">
</form>
</body>
</html>