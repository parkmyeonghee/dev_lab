<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%
    //만일 hidden속성을 이용해서 앞페이지에 값들을 유지하려면
    //1번 문항에 대한 답안을 참조하려면 히든값마다 다 선언해야되서 힘들어짐
 /*    String hn_test1=request.getParameter();
    String hn_test2=request.getParameter();
    String hn_test3=request.getParameter();
    String hn_test4=request.getParameter(); */
    
    %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript" src="/js/jquery-1.11.1.js"></script>
<title>시험문제1</title>
</head>
<body>
<script type="text/javascript">
   var count=0;
   $(document).ready(function (){
      $("#btn_next").click(function (){
         //alert("시작");
         //$('input:checkbox[id="checkbox_id"]').is(":checked") == true

         if($("#testForm1").is(":checked")==true){
            $("#h_test1").val(1);
            count++;
            //alert("1번:"+$("#h_test1").val());
         }
         else if($("#testForm2").is(":checked")==true){
            $("#h_test1").val(2);
            count++;
         }
         else if($("#testForm3").is(":checked")==true){
            $("#h_test1").val(3);
            count++;
         }
         else if($("#testForm4").is(":checked")==true){
            $("#h_test1").val(4);
            count++;
         }
         if(count==1){
            $("#if_test1").attr("method","get");
            $("#if_test1").attr("action","./testForm2.jsp");
            $("#if_test1").submit();
         }
         else{
            alert("답을 선택하세요");
            return;
         }
      });
   });
</script>
<form id="if_test1">
<input type="hidden" id="h_test1" name="hn_test1">
한릴레이션 기본키를 구성하는 어떠한 속성 값도 널(NULL)값이나 중복 값을 가질 수 없음을 의미하는 것은?
<br>
<input type="checkbox" id="testForm1">
1.개체 무결성 제약 조건<br>
<input type="checkbox" id="testForm2">
2.참조 무결성 제약 조건<br>
<input type="checkbox" id="testForm3">
3.도메인 무결성 제약 조건<br>
<input type="checkbox" id="testForm4">
4.키 무결성 제약 조건<br>
<input type="button" id="btn_next" value="다음">
</form>
</body>
</html>