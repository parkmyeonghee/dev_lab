<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%
 	String sid = (String)session.getAttribute("sid");
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/color.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.min.js"></script>
<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>

<title>Insert title here</title>
<script type="text/javascript">
function memoInsertForm(to_id){
	alert(to_id);
	$("#dlg_memoIns").dialog('open').dialog('setTitle','쪽지쓰기');
	$("#f_memoIns").form('clear');
}
function memoInsert(){
	$("#f_memoIns").attr("method","post");
	$("#f_memoIns").attr("action","./memoInsert.mem");
	$("#f_memoIns").submit();
}
</script>
</head>
<body>
<script type="text/javascript">

</script>
<div class="easyui-panel" title="쪽지등록" style="width:400px;padding:10px">
	<form id="f_memoIns" style="margin:0;padding:20px 50px">
      <div style="margin-bottom:20px;font-size:14px;border-bottom:1px solid #CCCCCC">
         쪽지등록
      </div>
      <div style="margin-bottom:10px">
      <label style="width:200">받는사람 &nbsp;:</label>
      <input name="to_id" class="f1 easyui-textbox" readonly="true" value="<%=request.getParameter("to_id") %>" style=width:100%">
      </div>
      <div style="margin-bottom:10px">
      <label style="width:200">보내는사람 :</label>
      <input name="from_id" class="f1 easyui-textbox" readonly="true" value="<%=sid %>"style="width:100%">
      </div>   
      <div style="margin-bottom:10px">
      <label style="width:200">내       용 :</label>
      <input name="memo_content" class="easyui-textbox" multiline="true" style="width:100%;height:100px">
      </div>         
      <div style="margin-bottom:10px">
      <label style="width:200">비       번 :</label>
      <input name="password" class="easyui-textbox" multiline="true" style="width:100%;height:30px">
      </div>
      <div id="#dlg_buttons" align="center">
      <a class="easyui-linkbutton c5" iconCls="icon-ok" plain="true" onClick="memoInsert()" style="width:90px">저장</a>   
      <a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onClick="javascriptwindow.close();"style="width:90px">취소</a>
      </div>   
   </form>
</div>
</body>
</html>