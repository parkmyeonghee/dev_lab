<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>  
<%
    //���ǿ� ��� ������ ȭ�鿡�� ����ϱ�
    String sname = (String)session.getAttribute("sname");   
	//out.print("�����̸�:"+sname);
%>
<table border="1" borderColor="red" width="100%" height="100%">
	<tr>
		<td valign="top">
		<table>
			<tr>
				<td>
				<!-- �α��� ȭ�� ��ġ �� ��  -->
					<!-- ���1 -->
					<%
					    //�ڹٶ�
						//��Ű�� ����� �̸��� �ִ�?
					if(sname == null){
					%>
					<!--================== �α��� �� ȭ�� ���� =====================-->
					<div id="d_login">
					<table width="200" height="80" border="1" borderColor="orange">
						<tr>
							<td colspan="2">�α���</td>
						</tr>
						<tr>
							<td>
							<input type="text" name="mem_id" id="imem_id" value="���̵��Է��ϼ���" onClick="idText()">
							</td>
							<td rowspan="2">
								<input type="button" value="�α���" onClick="login()">
							</td>
						</tr>
						<tr>
							<td>
							<input type="text" name="mem_pw" id="imem_pw" value="��й�ȣ���Է��ϼ���"  onClick="pwText()">
							</td>				
						</tr>
						<tr>
							<td colspan="2" align="center">ȸ������</td>
						</tr>
					</table>
					</div>	
					<!--================== �α��� �� ȭ��  �� =====================-->
<%
					}
					else{
%>					
	<jsp:include page="logout.jsp" flush="false"/>
<%
					}
%>				
				</td>
			</tr>
			<tr>
				<td>
				<!-- �޴� ȭ�� ��ġ ��  �� -->
					<table>
						<tr><td height="15%"><a href="./index.jsp?menu=loginForm">�α���</a></td></tr>
<!-- ���� ó���� �� �Ŀ� �޴��� ���̵��� ������ ����(����)
ȭ���� �����ϴ� ���ø��� top.jsp, menu.jsp, bottom.jsp, main.jsp�� �����Ͽ�
�������� �ۼ��Ͽ���.
�� �� �α��� ȭ�� ó���� menu.jsp�������� �߰��Ͽ��� ����ó�� �κ��� ajax��
�����Ͽ� �κ� ������ ó���� �Ͽ���.
�α��� �� ���� ������ �����ϰ� ������ ���� ������ ȭ�鿡�� ����Ϸ��� �Ͽ�����
�κ��������� �ҽ��� �ݿ��Ǿ� ���������� �ݿ��� ���� �ʾƼ� div�±׸� �̿��Ͽ�
�α��� ���������� �ڵ带 �߰�����.
 -->		
<div id="d_menu">
<%
if(sname != null){
%>
	<tr><td height="15%"><a href="./index.jsp?menu=memo">��������</a></td></tr>
	<tr><td height="15%"><a href="./index.jsp?menu=board">�Խ���</a></td></tr>
<%
	}
%>
</div>						
						<!-- ���� ó���� �� �Ŀ� �޴��� ���̵��� ������ ����(����) -->								
						<tr><td height="15%"><a href="./index.jsp?menu=guest">����</a></td></tr>
						<tr><td height="15%"><a href="javascript:popupView()">�˾�â</a></td></tr>
						<tr><td height="40%">&nbsp;</td></tr>
</table>
				<!-- �޴� ȭ�� ��ġ ��  �� -->				
				</td>
			</tr>			
		</table>
		</td>
	</tr>
</table>