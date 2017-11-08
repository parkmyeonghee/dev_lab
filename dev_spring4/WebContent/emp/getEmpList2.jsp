<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>사원목록</title>
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/color.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.min.js"></script>
<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript">
//점 조건으로 조회하기 -IN구문 실습
function searchALL(){
	//사용자가 선택한 부서번호를 담을 변수 선언
	var vdeptno="";
	var vdeptnos=[];
	var rows=$("#grid_emp").datagrid('getSelections');
	alert(rows);//Object,Object,Object
	//사용자가 선택한 부서번호를 배열에 담기
	for(var i=0;i<rows.length;i++){
		vdeptnos.push(rows[i].deptno);
	} 
	//배열에 담긴 정보 출력해보기
	for(var i=0;i<rows.length;i++){
		//10,30...값뒤에 콤마를 붙이다가 맨 마지막에는 붙이지 않습니다.
		if(i==(rows.length-1)){
			vdeptno +=vdeptnos[i];
		}
		//뒤에 값이 더 있을 경우에는 콤마를 붙여준다.
		else{
			vdeptno +=vdeptnos[i]+",";
		}
	}
	//10,30,40
	alert("vdeptno:"+vdeptno);
	location.href="./getEmpList2.kosmo?deptno="+vdeptno;
}
//사원등록버튼 클릭했을때
function empInsert(){
	$('#deptno').combobox({
		url:'./dept/getDeptnoList.kosmo'
		,valueField:'DEPTNO'
		,textField:'DEPTNO'
	});
	$('#dlg_empIns').dialog('open');
}
function empnoSearch(){
	
}
function enameSearch(){
	
}
function jobSearch(){
	
}
function cancelrow(){
	$("#grid_emp").datagrid('cancelEdit',getRowIndex(target));
}
</script>
</head>
<body>
<script type="text/javascript">
$(document).ready(function(){
	/*데이터 그리드 초기화 시작  */
	$("#grid_emp").datagrid({
	//url:"./empList.json"
	url:"./getEmpList.kosmo"
		,columns:[[
			{field:'empno',title:'사원번호',width:80,align:'center',editor:'text'}
			,{field:'ename',title:'사원명',width:100,align:'center',editor:'text'}
			,{field:'job',title:'JOB',width:120,align:'center',editor:'text'}
			,{field:'hiredate',title:'입사일자',width:120,align:'center',editor:'text'}
			,{field:'deptno',title:'부서번호',width:80,align:'center',	
				formatter:function(value,row){
				return row.deptno||value;
			},
			editor:{
				type:'combobox'
			,options:{
				valueField:'DEPTNO',//실제 서버에 넘어가는 필드
				textField:'DEPTNO',//화면에 출력되는 필드
				url:'../dept/getDeptnoList.kosmo',
				required:true
			}////////////////////end of options
			}/////////////////////////end of editor
				}
			,{field:'dname',title:'부서명',width:100,align:'center',editor:'text'}
			,{field:'action',title:'Action',width:100,align:'center',
			formatter:function(value,row,index){
		      if(row.editing){
		       var s ='<a href="#" onClick="saverow(this)">Save</a>&nbsp';
		       var c ='<a href="#" onClick="cancelrow(this)">Cancel</a>';
		        return s+c;
		       }
		      else{
		          var e='<a href="#" onClick="editrow(this)">Edit</a>&nbsp';
		           var d='<a href="#" onClick="deleterow(this)">Delete</a>';
		           return e+d;
		          }
		}//////////////////end of formatter
	}/////////////////////end of action
			]],
			onEndEdit:function(index,row){
				var ed = $(this).datagrid('getEditor', {
					index: index,
					field: 'DNAME'
				});
				row.DNAME = $(ed.target).combobox('getText');
			},
			onBeforeEdit:function(index,row){
				row.editing = true;
				$(this).datagrid('refreshRow', index);
			},
			onAfterEdit:function(index,row){
				row.editing = false;
				$(this).datagrid('refreshRow', index);
			},
			onCancelEdit:function(index,row){
				row.editing = false;
				$(this).datagrid('refreshRow', index);
			}	
	/* ,data: [
		{empno:'6000', ename:'이순신',job:'영업',hiredate:'2009-10-25',deptno:40,dname:'해외영업'}
		,{empno:'7000', ename:'김유신',job:'영업',hiredate:'2009-10-25',deptno:40,dname:'해외영업'}
		] */
	});

	/*데이터 그리드 초기화 끝  */
});///////////////////////////////////end of ready
function getRowIndex(target){
	var tr=$(target).closest('tr.datagrid-row');
	return parseInt(tr.attr('datagrid-row-index'));
}
function editrow(target){
	$("#grid_emp").datagrid('beginEdit',getRowIndex(target));
}
function deleterow(target){
	$.messager.confirm('Confirm','정말 삭제하시겠습니까?',function(r){
		if(r){
			var vempnos="";
			var empnoArr=[];
			var rows =$("#grid_emp").datagrid('getSelections');//로우에 대한 Object
			//사용자가 선택한 로우에 대한 Object를 이용하면 field에 접근할 수 있다.
			if(rows==null){
				alert("삭제할 사원을 선택하세요");
				return;
			}
			for(var i=0;i<rows.length;i++){
				empnoArr.push(rows[i].empno);
			}
			for(var i=0;i<rows.length;i++){
				if(i==(rows.length-1)){
					vempnos +=empnoArr[i];
				}
				else{
					vempnos +=empnoArr[i]+",";
				}
			}
			alert("사용자가 선택한 사원번호:"+vempnos);
			location.href="./empDelete.kosmo?empnos="+vempnos;//서버에 요청(전송방식:get)
			//화면상에서만 삭제 된다.-삭제후 새로 select처리 할 것이므로 의미가 없다.
		//	$("#grid_emp").datagrid('deleteRow',getRowIndex(target));
		}
	});
}
</script>
<!--툴바 추가하기 시작-->
<!-- 테이블내에 툴바 추가해 보기 도서등록버튼 -->
<div id="tbar_empList">
<!-- 검색 조건 추가 화면 입니다.  -->
<form id="f_search">
	<table>
		<tr>
			<td width="140px">
			<label width="80px">사원번호</label>

			<input id="empno" name="empno" class="easyui-searchbox" data-options="prompt:'사원번호', searcher:empnoSearch" style="width:60px">
			</td>
			<td width="180px">
			<label width="70px">사원명</label>
			<input id="ename" name="ename" class="easyui-searchbox" data-options="prompt:'사원명', searcher:enameSearch" style="width:110px">
			</td>
			<td width="180px">
			<label width="70px">JOB</label>
			<input id="job" name="job" class="easyui-searchbox" data-options="prompt:'JOB', searcher:jobSearch" style="width:110px">
			</td>
		</tr>
		<tr>
			<td colspan="4">
		    <a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="searchALL()">사원조회</a>
		    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onClick="empUpdForm()">사원수정</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onClick="empInsert()">사원등록</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onClick="deleterow()">사원삭제</a>			
			</td>
		</tr>		
	</table>
</form>	
<!-- 검색 조건 추가 화면 입니다.  -->	
</div>
<!--툴바 추가하기 끝-->
<!-- 테이블 그리기 -->
<table id="grid_emp" toolbar="tbar_empList"class="easyui-datagrid"title="사원목록"style="width:1000px;height:400px">
</table>
<!--사원 등록 다이얼로그창 추가 시작  -->
<div id="dlog_empIns" buttons="#linkbtn_empIns" class="easyui-dialog" title="사원등록" style="width:400px;height:200px;" closed="true"
     data-options="iconCls:'icon-man',resizable:true,modal:true">
     <form id="f_empIns">
     <!--사원번호시작  -->
     <label>사원 번호</label>
     <input id="empno" name="empno" class="easyui-textbox" required="true">
     <!--사원번호끝 -->
      <!--사원이름 시작  -->
     <label>사원 이름</label>
     <input id="ename" name="ename" class="easyui-textbox"required="true">
     <!--사원이름 끝 -->
      <!--JOB 시작  -->
     <label>job</label>
     <input id="job" name="job" class="easyui-textbox"required="true">
     <!--JOB 끝 -->
      <!--그룹코드 시작 -->
     <label>mgr</label>
     <input id="mgr" name="mgr" class="easyui-textbox"required="true">
     <!--그룹코드 끝 -->
      <!--입사일자시작 -->
     <label>입사일자:</label>
       <input id="hiredate" name="hiredate" class="easyui-datebox" required="required">
     <!--입사일자 끝 -->
      <!--급여시작 -->
     <label>급여:</label>
       <input id="sal" name="sal" class="easyui-textbox"required="true">
     <!--급여 끝 -->
      <!--인센티브시작 -->
     <label>인센티브:</label>
       <input id="comm" name="comm" class="easyui-textbox"required="true">
     <!--인센티브 끝 -->
      <!--부서번호시작 -->
     <label>부서번호:</label>
       <input id="deptno" name="deptno" class="easyui-combobox">
     <!--부서번호 끝 -->
     </form>
</div>
<!--사원 등록 다이얼로그창 추가 끝  -->
<!--사원등록 다이얼로그 창에 버튼 추가 시작  -->
<div>
	<a href="javascriptvoid(0)" class="easyui-linkbutton" onclick="$('dlog_empIns').dialog('open')">저장</a>
	<a href="javascriptvoid(0)" class="easyui-linkbutton" onclick="$('dlog_empIns').dialog('close')">닫기</a>
</div>
<!--사원등록 다이얼로그 창에 버튼 추가 끝  -->
</body>
</html>