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
			if(menu=='spring_dept'){//�μ����� �޴� �������� ��
				$.ajax({
					type:"get"
				  , url:"./deptIntro.jsp"
				  , success:function(result){
					$('#content').html(result);
				  }
				});//end of ajax
			}
			else if(menu=='spring_book'){//�������� �޴� �������� ��
				$.ajax({
					type:"get"
				  , url:"./bookIntro.jsp"
				  , success:function(result){
					$('#content').html(result);
				  }
				});//end of ajax			
			}
			else if(menu=='spring_member'){//ȸ������ �޴� �������� ��
				$.ajax({
					type:"get"
				  , url:"./memberIntro.jsp"
				  , success:function(result){
					$('#content').html(result);
				  }
				});//end of ajax
			}
			else if(menu=='spring_board'){//�Խ��� �޴� �������� ��
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
		<div region="west" split="true" title="�޴�" style="width:200px;">
<!-- Ʈ�� ������Ʈ ���� -->		
			<ul class="easyui-tree">
	        <li>
	            <span>MVC���Ͻǽ�</span>
	            <ul>
<!-- POJO MVC ���� -->	            
	                <li>
	                    <span>POJO MVC</span>
	                    <ul>
	                        <li><span><a href="javascript:showContent('pojo_dept')">�μ�����</a></span></li>
	                        <li><span><a href="javascript:showContent('pojo_book')">��������</a></span></li>
	                        <li><span><a href="javascript:showContent('pojo_member)">ȸ������</a></span></li>
	                        <li><span><a href="javascript:showContent('pojo_board)">�Խ���</a></span></li>
	                    </ul>
	                </li>
<!-- POJO MVC ��   -->
<!-- SPRING MVC ���� -->	            
	                <li>
	                    <span>SPRING MVC</span>
	                    <ul>
              				 <li><span><a href="javascript:showContent('spring_dept')">�μ�����</a></span></li>
	                        <li><span><a href="javascript:showContent('spring_book')">��������</a></span></li>
	                        <li>
	                        <span>ȸ������</span>
					           <ul>
					                <li>
					                    <span>ȸ����������</span>
					                    <ul>
					                        <li><span>ȸ�����</span></li>
					                        <li><span>ȸ��Ż��</span></li>
					                    </ul>
					                </li>
					                <li>
					                    <span>��������</span>
					                    <ul>
					                        <li><span>����������</span></li>
					                        <li><span>����������</span></li>
					                    </ul>					                
					                </li>
					            </ul>	                        
	                        </li>
	                        <li><span><a href="javascript:showContent('spring_board')">�Խ���</a></span></li>
	                    </ul>
	                </li>
<!-- SPRING MVC ��   -->		                
	           </ul>
	           </li> 
	    	</ul>
<!-- Ʈ�� ������Ʈ �� -->	    	
			</div>
		<div id="content" region="center" title="MVC���� �ǽ�" style="padding:5px;">
		</div>
	</div>
</body>
</html>