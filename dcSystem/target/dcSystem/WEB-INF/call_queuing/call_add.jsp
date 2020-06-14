<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../dcsystem/dcsystem.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<link rel="stylesheet" href="${pageContext.request.contextPath}/res/common/form.css" />
<form id="call_form" class="elegant-aero" method="post" style="position: relative;top: 10%;">

    <div>
        <label for="czId">餐桌编号:</label>
        <input id="czId" class="easyui-validatebox" type="text" name="czId"/>
    </div>
    <div>
        <label for="czName">餐桌名称:</label>
        <input id="czName" class="easyui-validatebox" type="text" name="czName"/>
    </div>
    <div>
        <label for="callText">服务内容:</label>
        <input id="callText" class="easyui-validatebox" type="text" name="callText"/>
    </div>
    <input name="dealPepleId" type="text" style="display:none" value="${dealPepleId}3"/>
    <a onclick="callSave()" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">提交</a>
</form>
<script type="text/javascript">
    function callSave() {
        $("#call_form").form('submit', {
            url: "${proPath}/cus_call/add.mvc",
            onSubmit: function () {
               // var bool = $("#call_form").from("validate");
              //  console.info(bool);//浏览器输出校验信息
                return true;
            },
            success: function (msg) {
                var obj = eval("(" + msg + ")");//将JSON的字符串解析成JSON数据格式
                if ("1" == obj.result) {
                    parent.$("#call_add").window("close");//关闭当前添加窗口
                    parent.$('#cus_call').datagrid("load");//更新呼叫服务列表
                } else {
                    alert("添加失败");
                }
            }
        });
    }
</script>
</body>
</html>
