<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�α���</title>
<script type="text/javascript">
	function login(){
		document.getElementById("d_secen1").innerText="";		
		temp = "<div id='d_secen2'><table width='250' height='80' border='1' borderColor='green'>";
		temp+="<tr><td colspan='2'>�α���</td></tr>";
		temp+="<tr><td width='170'>�̼��Ŵ� ȯ���մϴ�.</td><td width='80' align='center'><input type='button' value='�α׾ƿ�' onClick='logout()'></td></tr>";
		temp+="<tr><td colspan='2' align='center'>��������|ȸ��Ż��</td></tr>";
		temp+="</table></div>";
		document.getElementById("d_secen2").innerHTML=temp;
	}
	function logout(){
		document.getElementById("d_secen2").innerText="";		
		temp = "<div id='d_secen1'><table width='200' height='80' border='1' borderColor='orange'>";
		temp+="<tr><td colspan='2'>�α���</td></tr>";
		temp+="<tr><td><input type='text' name='mem_id' id='imem_id' value='���̵�'></td>";					
		temp+="<td rowspan='2'><input type='button' value='�α���' onClick='login()'></td></tr>";
		temp+="<tr><td><input type='password' name='mem_pw' id='imem_pw' value='��й�ȣ'></td></tr>";
		temp+="<tr><td colspan='2' align='center'>ȸ������</td></tr>";
		temp+="</table></div>";
		document.getElementById("d_secen1").innerHTML=temp;		
	}
</script>
</head>
<body>
<script type="text/javascript">
	window.onload = function(){
		//alert('11');
		document.getElementById("d_secen2").innerText="";
	};
</script>
<table border="1" borderColor="pink" width="100%" height="100%">
	<tr>
		<td align="center">
		<!--============ [[ ��� 1 ���� ]] ============-->
		<div id="d_secen1">
			<table width="200" height="80" border="1" borderColor="orange">
				<tr>
					<td colspan="2">�α���</td>
				</tr>
				<tr>
					<td>
					<input type="text" name="mem_id" id="imem_id" value="���̵�">
					</td>
					<td rowspan="2">
						<input type="button" value="�α���" onClick="login()">
					</td>
				</tr>
				<tr>
					<td>
					<input type="password" name="mem_pw" id="imem_pw" value="��й�ȣ">
					</td>				
				</tr>
				<tr>
					<td colspan="2" align="center">ȸ������</td>
				</tr>
			</table>
		</div>
		<!--============ [[ ��� 1  �� ]] ============-->
		<!--============ [[ ��� 2 ���� ]] ============-->
		<div id="d_secen2">
			<table width="250" height="80" border="1" borderColor="green">
				<tr>
					<td colspan="2">�α���</td>
				</tr>
				<tr>
					<td width="170">
					�̼��Ŵ� ȯ���մϴ�.
					</td>
					<td width="80" align="center">
						<input type="button" value="�α׾ƿ�" onClick="logout()">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">��������|ȸ��Ż��</td>
				</tr>
			</table>		
		</div>
		<!--============ [[ ��� 2  �� ]] ============-->
		</td>
	</tr>
</table>
</body>
</html>