<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import="java.util.List,java.util.HashMap" %>
    <%
    List<HashMap>deptList=(List<HashMap>)request.getAttribute("deptList");
    HashMap<String,Object>rMap=null;
    if(deptList!=null){
    	rMap=deptList.get(0);
    }else{
    	rMap=new  HashMap<String,Object>();
    }
    %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/color.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.min.js"></script>
<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/dev_spring4/js/commons.js"></script>
<script type="text/javascript">
function updateAction(){
	$("#f_deptUpd").attr("method","get");
	$("#f_deptUpd").attr("action","./deptUpdate.kosmo");
	$("#f_deptUpd").submit();
}
</script>
</head>
<body>
<div id="dlg_deptUpd" title="부서정보수정" buttons="#dlg_buttons" class="easyui-panel" style="width:600px">
<!-- 서버로 사용자가 입력한 정보를 전송합니다.(form전송으로 처리하기) -->
	<form id="f_deptUpd" style="margin:0;padding:20px 50px"> 	
 	<div style="margin-bottom:10px">
 	<input id="deptno" name="deptno" value="<%=rMap.get("DEPTNO") %>" label="부서번호" style="width:100%" class="easyui-textbox">

 	</div>
 	<div style="margin-bottom:10px">
 	<input name="dname" value="<%=rMap.get("DNAME") %>"class="easyui-textbox" label="부서명 : " style="width:100%">
 	</div>
 	<div style="margin-bottom:10px">
 	<input name="loc" class="easyui-textbox"  value="<%=rMap.get("LOC") %>" label="지역 : " style="width:100%">
 	</div>
 	</form>	
 </div>
 <div id="dlg_buttons">
	<a href="#" class="easyui-linkbutton c1" iconCls="icon-ok" plain="true" onClick="updateAction()" style="width:90px">수정</a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onClick="javascript:window.close()" style="width:90px">취소</a>
</div>

</body>
</html>