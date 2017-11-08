<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	int result = -1;
	if(request.getParameter("result")!=null){
		result = Integer.parseInt(request.getParameter("result"));
	}
	int total=0;
	if(session.getAttribute("total")!=null){
			total=Integer.parseInt(session.getAttribute("total").toString());
		
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>부서목록</title>
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/color.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.min.js"></script>
<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/dev_spring4/js/commons.js"></script>
<script type="text/javascript">
	var vresult = <%=result%>
	//페이지 이동처리
	function pageMove(pageNumber,pageSize){
		$("#tb_deptList").datagrid({
			idField:'itemid',
			url:"./getDeptList.kosmo?page="+pageNumber
					+"&pageSize="+pageSize
		});
	}
	//부서번호 조건 검색
	function deptnoSearch(){
		//사용자가 입력한 부서번호 가져오기
		var vdeptno = $("#deptno").val();
		console.log("사용자가 입력한 부서번호 : "+vdeptno);
		$('#tb_deptList').datagrid({
			url: "./getDeptList.kosmo?deptno="+vdeptno
		});
	}
	//부서명 조건 검색
	function dnameSearch(){
		var vdname = $("#dname").val();
		console.log("사용자가 입력한 부서명 : "+vdname);
		$('#tb_deptList').datagrid({
			url: "./getDeptList.kosmo?dname="+vdname
		});		
	}
	//지역 조건 검색
	function locSearch(){
		var vloc = $("#loc").val();
		console.log("사용자가 입력한 지역 : "+vloc);
		$('#tb_deptList').datagrid({
			url: "./getDeptList.kosmo?loc="+vloc
		});		
	}	
	//전체 조건 검색
	function searchALL(){
		$('#tb_deptList').datagrid({
			url: "./getDeptList.kosmo"
		});		
	}
	//부서등록
	function deptInsert(){
		$("#dlg_deptIns").dialog('open').dialog('setTitle','부서등록');
	}
	//부서정보 테이블에 삽입하기
	function insertAction()
	{
		$("#f_deptIns").attr("method","get");
		$("#f_deptIns").attr("action","./deptInsert.kosmo");
		$("#f_deptIns").submit();
	}
	//부서삭제 - 화면에서 값을 서버 전송(ajax, form, 쿼리스트링)
	function deptDelete(){
		var row = $("#tb_deptList").datagrid('getSelected');//Object
		//alert("row:"+row);
 		if(row==null){
			alert("삭제할 로우를 선택하세요.");
			return;
		} 
/* 		alert(row.DEPTNO);
		if(row){
			alert($("#tb_deptList").datagrid('getRowIndex',row));
		} */
/* 		$("#f_deptDel").attr("method","get");
		$("#f_deptDel").attr("action","./deptDelete.kosmo?deptno="+row.DEPTNO);
		$("#f_deptDel").submit();	 */
		location.href="./deptDelete.kosmo?deptno="+row.DEPTNO;
	}
	//부서 정보 수정
	function deptUpdForm(){
		var row = $("#tb_deptList").datagrid('getSelected');//Object
 		if(row==null){
			alert("수정할 로우를 선택하세요.");
			return;
 		}
		var url="./getDeptRead.kosmo?deptno="+row.DEPTNO;
 		 cmm_window_popup(url,'650','320','deptUpdForm');
	}
</script>
</head>
<body>
<script type="text/javascript">
	$(document).ready(function (){
		if(vresult==1)
		$("#dlg_deptInsSuccess").dialog('open');
		else if(vresult==0)
		$("#dlg_deptInsFail").dialog('open');	
		/* 페이지 네비게이션 초기화 시작 */
		$("#pg_dept").pageination({
			total:<%=total%>
		,pageSize:10
		,onSelectPage:function(pageNumber,pageSize){
			pageMove(pageNumber,pageSize);
		}
		})
		/* 페이지 네비게이션 초기화 끝 */
	});////////////////////////////end of ready
</script>
<!-- 삭제 처리를 위한 폼 추가하기  끝    -->
<!-- 툴바 추가하기 시작 -->
<!-- 테이블내에 툴바 추가해 보기 도서등록버튼 -->
<div id="tbar_deptList">
<!-- 검색 조건 추가 화면 입니다.  -->
<form id="f_search">
	<table>
		<tr>
			<td width="140px">
			<label width="80px">부서번호</label>
			<!-- 
<input class="easyui-searchbox" data-options="prompt:'Please Input Value',searcher:doSearch" style="width:100%">			
			 -->
			<input id="deptno" name="deptno" class="easyui-searchbox" data-options="prompt:'부서번호', searcher:deptnoSearch" style="width:60px">
			</td>
			<td width="180px">
			<label width="70px">부서명</label>
			<input id="dname" name="dname" class="easyui-searchbox" data-options="prompt:'부서명', searcher:dnameSearch" style="width:110px">
			</td>
			<td width="180px">
			<label width="70px">지역</label>
			<input id="loc" name="loc" class="easyui-searchbox" data-options="prompt:'지역', searcher:locSearch" style="width:110px">
			</td>
		</tr>
		<tr>
			<td colspan="4">
		    <a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="searchALL()">부서조회</a>
		    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onClick="deptUpdForm()">부서수정</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onClick="deptInsert()">부서등록</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onClick="deptDelete()">부서삭제</a>			
			</td>
		</tr>		
	</table>
</form>	
<!-- 검색 조건 추가 화면 입니다.  -->	
</div>
<!-- 툴바 추가하기  끝   -->
<table id="tb_deptList" toolbar="#tbar_deptList" fitColumns="true" data-options="url:'./getDeptList.kosmo'" title="부서목록" singleSelect="true" rownumbers="true" class="easyui-datagrid" style="width:500px;height:400px">
	<thead>
		<tr>
			<th data-options="field:'DEPTNO', width:100, align:'center'">부서번호</th>
			<th data-options="field:'DNAME', width:150, align:'center'">부서명</th>
			<th data-options="field:'LOC', width:150, align:'center'">부서지역</th>
		</tr>
	</thead>
</table>	
<!-- 페이지 네비게이션 시작  -->
<div id="pg_dept" class="easyui-pagination" style="border:1px solid #ccc;width:500px;">
</div>
<!-- 페이지 네비게이션 끝  -->
<!-- 팝업창에서 제공될 화면 입니다. 시작 -->
<div id="dlg_deptIns" buttons="#dlg_buttons" class="easyui-dialog" closed="true" style="width:600px">
<!-- 서버로 사용자가 입력한 정보를 전송합니다.(form전송으로 처리하기) -->
	<form id="f_deptIns" style="margin:0;padding:20px 50px"> 	
 	<div style="margin-bottom:10px">
 	<input id="cb_deptno" name="deptno" label="부서번호" style="width:100%" class="easyui-combobox" data-options="
        valueField: 'DEPTNO',
        textField: 'DNAME',
        url: 'getDeptnoList.kosmo',
        onSelect: function(rec){
       <!--  alert(rec.DEPTNO); -->
        }">
 	</div>
 	<div style="margin-bottom:10px">
 	<input name="dname" class="easyui-textbox" label="부서명 : " style="width:100%">
 	</div>
 	<div style="margin-bottom:10px">
 	<input name="loc" class="easyui-textbox" label="지역 : " style="width:100%">
 	</div>
 	</form>	
 </div>
 <div id="dlg_buttons">
	<a href="#" class="easyui-linkbutton c1" iconCls="icon-ok" plain="true" onClick="insertAction()" style="width:90px">저장</a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onClick="javascript:$('#dlg_deptIns').dialog('close')" style="width:90px">취소</a>
</div>

<!-- 등록 성공시 제공될 화면 입니다.  시작  -->
<div id="dlg_deptInsSuccess" buttons="#dlg_buttons2" class="easyui-dialog" closed="true" style="width:300px">
	<label>등록성공하였습니다.</label>
</div>
 <div id="dlg_buttons2">
	<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onClick="javascript:$('#dlg_deptInsSuccess').dialog('close')" style="width:90px">닫기</a>
</div>
<!-- 등록 실패시 제공될 화면 입니다.  시작  -->
<div id="dlg_deptInsFail" buttons="#dlg_buttons3" class="easyui-dialog" closed="true" style="width:300px">
	<label>등록실패하였습니다.</label>
</div>
 <div id="dlg_buttons3">
	<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onClick="javascript:$('#dlg_deptInsFail').dialog('close')" style="width:90px">닫기</a>
</div>
</body>
</html>












