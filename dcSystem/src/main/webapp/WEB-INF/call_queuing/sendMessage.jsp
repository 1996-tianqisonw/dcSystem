<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/11
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script type="text/javascript">
    function sendMessage() {
        var userID = document.getElementById("userId").value;
        var message = document.getElementById("send_message").value;
        $.ajax({//进行ajax请求
            type: "post",
            url: "${proPath}/reception/sendMessage.mvc",
            data: {
                "userId": userID,
                "message": message
            },
            cache: true,
            async: true,
            success: function (data) {
                $.messager.show({
                    title: '我的消息',
                    msg: data.result,
                    timeout: 5000,
                    showType: 'slide'
                });
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                //alert(typeof(errorThrown));
            }
        });
    }
</script>
<div id="sendDiv">
    欢迎您：${sessionScope.sysUser.username}${yonlie}
    <input id="userId" value="${yonlie}"/>
    <input id="send_message"/>
    <a id="btn32" href="#" onclick="sendMessage()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">呼叫</a>
</div>
<style type="text/css">
    #sendDiv {
        margin: 0 auto;
        position: relative;
        top: 20%;
        text-align: center;
        padding: 20px;
    }
</style>
</body>
</html>
