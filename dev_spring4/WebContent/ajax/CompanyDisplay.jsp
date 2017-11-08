<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-1.11.1.js"></script>
</head>
<body>
<script type="text/javascript">
   $(document).ready(function(){
      $("#btn_xml").click(function(){
         
         $.ajax({
            
            method:"get"
            ,dataType:"xml"
            ,url:"./Company.xml"
            ,success:function(data){
               var temp="<table border='1'><tr>";
               $(data).find("Company").each(function(){
               var $entry = $(this); //현재 레코드셋
               temp+="<td>"+$entry.find("CompanyName").text()+"</td>";
               temp+="<td>"+$entry.find("CompanyNumber").text()+"</td>";
               temp+="<td>"+$entry.find("CompanyAddress").text()+"</td>";
              });
               temp+="</tr></table>";
               $("#d_company").html(temp);
            }
            
         });
      });
   });
</script>
<input type="button" id="btn_xml" value="xml읽기">
<div id="d_company"></div>
</body>
</html>