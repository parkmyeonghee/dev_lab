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
</head>
<body>
���ͷ�Ʈ ��û��ȣ �÷���(Flag)�� ���ʷ� �˻��Ͽ� ���ͷ�Ʈ�� ������ �Ǻ��ϴ� �����?
<br>
<input type="checkbox" name="ckbox"  value="1">1.����κ� ���
<br>
<input type="checkbox" name="ckbox"  value="2">2.������ ü�ι��
<br>
<input type="checkbox" name="ckbox"  value="3">3.�������
<br>
<input type="checkbox" name="ckbox"  value="4">4.�ϵ������
<br>
����:3
<br>
<input type="button" id="btn_go" value="���������"> &nbsp 
<input type="button" id="btn_return" value="��������">
</body>
</html>