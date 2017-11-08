<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="keywords" content="jquery,ui,easy,easyui,web">
	<meta name="description" content="easyui help you build your web page easily!">
	<title>Build border layout for web pages - jQuery EasyUI Demo</title>
	<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
	<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript">
		function showContent(menu){
			if(menu=='spring_dept'){//부서관리 메뉴 선택했을 때
				$.ajax({
					type:"get"
				  , url:"./deptIntro.jsp"
				  , success:function(result){
					$('#content').html(result);
				  }
				});//end of ajax
			}
			else if(menu=='spring_book'){//도서관리 메뉴 선택했을 때
				$.ajax({
					type:"get"
				  , url:"./bookIntro.jsp"
				  , success:function(result){
					$('#content').html(result);
				  }
				});//end of ajax			
			}
			else if(menu=='spring_member'){//회원관리 메뉴 선택했을 때
				$.ajax({
					type:"get"
				  , url:"./memberIntro.jsp"
				  , success:function(result){
					$('#content').html(result);
				  }
				});//end of ajax
			}
			else if(menu=='spring_board'){//게시판 메뉴 선택했을 때
				$.ajax({
					type:"get"
				  , url:"./boardList.jsp"
				  , success:function(result){
					$('#content').html(result);
				  }
				});//end of ajax
			}			
		}
		$(function(){
			showContent('java');
		});
	</script>
</head>
<body>
	<div class="easyui-layout" style="width:1200px;height:600px;">
		<div region="west" split="true" title="메뉴" style="width:200px;">
<!-- 트리 컴포넌트 시작 -->		
			<ul class="easyui-tree">
	        <li>
	            <span>MVC패턴실습</span>
	            <ul>
<!-- POJO MVC 시작 -->	            
	                <li>
	                    <span>POJO MVC</span>
	                    <ul>
	                        <li><span><a href="javascript:showContent('pojo_dept')">부서관리</a></span></li>
	                        <li><span><a href="javascript:showContent('pojo_book')">도서관리</a></span></li>
	                        <li><span><a href="javascript:showContent('pojo_member)">회원관리</a></span></li>
	                        <li><span><a href="javascript:showContent('pojo_board)">게시판</a></span></li>
	                    </ul>
	                </li>
<!-- POJO MVC 끝   -->
<!-- SPRING MVC 시작 -->	            
	                <li>
	                    <span>SPRING MVC</span>
	                    <ul>
              				 <li><span><a href="javascript:showContent('spring_dept')">부서관리</a></span></li>
	                        <li><span><a href="javascript:showContent('spring_book')">도서관리</a></span></li>
	                        <li>
	                        <span>회원관리</span>
					           <ul>
					                <li>
					                    <span>회원정보관리</span>
					                    <ul>
					                        <li><span>회원목록</span></li>
					                        <li><span>회원탈퇴</span></li>
					                    </ul>
					                </li>
					                <li>
					                    <span>쪽지관리</span>
					                    <ul>
					                        <li><span>받은쪽지함</span></li>
					                        <li><span>보낸쪽지함</span></li>
					                    </ul>					                
					                </li>
					            </ul>	                        
	                        </li>
	                        <li><span><a href="javascript:showContent('spring_board')">게시판</a></span></li>
	                    </ul>
	                </li>
<!-- SPRING MVC 끝   -->		                
	           </ul>
	           </li> 
	    	</ul>
<!-- 트리 컴포넌트 끝 -->	    	
			</div>
		<div id="content" region="center" title="MVC패턴 실습" style="padding:5px;">
		</div>
	</div>
</body>
</html>