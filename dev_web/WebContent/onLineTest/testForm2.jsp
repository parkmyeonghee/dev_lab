<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript" src="/dev_web/js/jquery-1.11.1.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function() {
    $('input[type="checkbox"][name="ckbox"]').click(function(){
        if ($(this).prop('checked')) {
            $('input[type="checkbox"][name="ckbox"]').prop('checked', false);
            $(this).prop('checked', true);
        }
    });
});
</script>
<title>Insert title here</title>
</head>
<body>
������ ��Ʈ��ũ ������ ���� ���谣 ó��(Peer-To-Peer) ��Ŀ� ���� �������� ���� ��������?
<br>
<input type="checkbox" name="ckbox"  value="1">
1.��ǻ�Ϳ� ��ǻ�Ͱ� �����ϰ� ����Ǵ� ����̴�.
<br>
<input type="checkbox" name="ckbox"  value="2">
2.������ ��ǻ�ʹ� Ŭ���̾�Ʈ�� ���ÿ� ������ �� �� �ִ�.
<br>
<input type="checkbox" name="ckbox"  value="3">
3.��ũ�����̼��̳� PC�� �ܸ���� ����ϴ� ���� �Ը��� ��Ʈ��ũ�� ���� ���ȴ�.
<br>
<input type="checkbox" name="ckbox"  value="4">
4.���������� ���� �������� ������ ����ϸ� �ַ� ������ ���� ���� �� ����Ѵ�.
<br>
����:4��
<br>
<input type="button" id="next" value="��������"> &nbsp 
<input type="button" id="return" value="��������">
</body>
</html>