<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/dcsystem/dcsystem.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<link rel="stylesheet" href="${pageContext.request.contextPath}/res/common/form.css" />
<form id="line_add"  class="elegant-aero" >
    <div>
        <label for="dpId">就餐店铺:</label>
        <input id="dpId" class="easyui-validatebox" type="text" name="dpId"  />
    </div>
    <div>
        <label for="custName">客人姓名:</label>
        <input id="custName" class="easyui-validatebox" type="text" name="custName"  />
    </div>
    <div>
        <label for="custTel">联系方式:</label>
        <input id="custTel" class="easyui-validatebox" type="text" name="custTel"  />
    </div>
    <div >
        <label for="pepleNum">用餐人数:</label>
        <input id="pepleNum" class="easyui-validatebox" type="text" name="pepleNum"  />
    </div>
    <div >
        <label for="lineRemarks">备注:</label>
        <input id="lineRemarks" class="easyui-validatebox" type="text" name="lineRemarks"  />
    </div>
    <a onclick="line_add()" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">提交</a>
</form>
<script type="text/javascript">
    function line_add() {
        $("#line_add").form('submit', {
            url: "${proPath}/wait_line/add.mvc",
            onSubmit: function () {
                // var bool = $("#call_form").from("validate");
                //  console.info(bool);//浏览器输出校验信息
                return true;
            },
            success: function (msg) {
                alert(msg)
                // var obj = eval("(" + msg + ")");//将JSON的字符串解析成JSON数据格式
                alert(msg)
                var obj = $.parseJSON(msg);
                alert(obj);
                alert(obj.result);
                if ("1" == obj.result) {
                    parent.$("#win_line").window("close");//关闭当前添加窗口
                    parent.$('#wait_line').datagrid("load");//更新呼叫服务列表
                } if ("0" == obj.result) {
                    alert("未能添加成功，请联系管理员");
                }else {
                    //alert(msg.result);
                    alert(obj.result);
                }
            }
        });
    }
</script>
</body>
</html>
