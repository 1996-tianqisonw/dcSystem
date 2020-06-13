<%--
  Created by IntelliJ IDEA.
  User: 86173
  Date: 2020/6/12
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script type="text/javascript">
    $(function () {
        var mg;
        $.ajax({
            type: "post",
            url:"${proPath}/pageController/permis.mvc",
            traditional:true,
            data: {permissions:permissions},
            dataType:'json',
            success:function (msg) {
                if (msg){
                    mg = msg;
                }else {
                    $.messager.show({
                        title : '操作提示',
                        msg : '权限不够。',
                        timeout : 4000,
                        showType : 'slide'
                    });
                }
            }
        });
    })
</script>
<body>

</body>
</html>
