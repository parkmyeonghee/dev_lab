<%-- <%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <script type="text/javascript" src="../js/jquery-1.11.1.js"></script>    
<table border="1" borderColor="pink" width="100%" height="100%">
	<tr>
		<td align="center">
		<div id="d_news">
<script type="text/javascript">
$(document).ready(function(){
   
   var watch;
   function start(){
      watch = setInterval(autoReload,1000);
   }
   
   function stop(){
      setTimeout(function (){
         clearInterval(watch);
      },10000);
   }
   
   
   function autoReload(){
   /*    alert("autoReload호출 성공"); */
      
      
      $.ajax({
         type:"get"
         ,url:"../ajax/getNewsList.do"   
         ,success:function(result){
         /*    alert("succes"); */
            $("#d_news").html(result);
         }
         ,error:function(e){
            $("#d_news").text(e.responseText);
         }
         
      });
      
   }
   
   start();
   stop();
   
});


</script>
		
		</script>
		</div>
		</td>
	</tr>
</table> --%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<table border="1" borderColor="pink" width="100%" height="100%">
	<tr>
		<td align="center">디폴트페이지
			<table>
				<tr>
					<td><img id="img_java" width="200" heigth="100" src="../images/green.jpg"></td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<div id="d_news"></div>