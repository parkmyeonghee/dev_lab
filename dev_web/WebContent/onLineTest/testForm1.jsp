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
$(document).ready(function(){
	$("#")
})
</script>
</head>
<body>
<form id="f_test1">
�Ѹ����̼� �⺻Ű�� �����ϴ� ��� �Ӽ� ���� ��(NULL)���̳� �ߺ� ���� ���� �� ������ �ǹ��ϴ� ����?
<br>
<input type="checkbox" name="ckbox"  value="1">1.��ü ���Ἲ ���� ����
<br>
<input type="checkbox" name="ckbox"  value="2">2.���� ���Ἲ ���� ����
<br>
<input type="checkbox" name="ckbox"  value="3">3.������ ���Ἲ ���� ����
<br>
<input type="checkbox" name="ckbox"  value="4">4.Ű ���Ἲ ���� ����
<br>
����:1
<br>
<input type="button" id="btn_next" value="��������">
</form>
</body>
</html>