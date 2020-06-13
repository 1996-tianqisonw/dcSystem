<%--
  Created by IntelliJ IDEA.
  User: 86173
  Date: 2020/5/29
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../dcsystem/dcsystem.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form id="fm" method="post">
    <div>
        <label for="roleName">名字</label>
        <input id="roleName" class="easyui-validatebox" type="text" name="roleName" />
    </div>
    <div>
        <select id="state"	class="easyui-combobox" name="state" style="width:200px;">
            <option>可用</option>
            <option>禁用</option>
        </select>
    </div>
    <a id="btn" href="#" onclick="show()"  class="easyui-linkbutton" data-options="iconCls:'icon-ok'">查询</a>
</form>
</body>
<script type="text/javascript">
    function show(){
        var win = parent.$("iframe[title='角色管理']").get(0).contentWindow;
        $("[name='roleName']").validatebox({
            required : true,
            missingMessage : '1111'
        });
        $("[name='state']").validatebox({
            required : true,
            missingMessage : '2222'
        });
        $('#fm').form('submit',{
            url:'${proPath}/RoleController/insertRole.mvc',
            success:function (msg) {
                if (msg>0){
                    if (msg==2){
                        $.messager.show({
                            title: '操作提示',
                            msg: '角色名已存在',
                            timeout: 2000,
                            showType: 'slide'
                        });
                    }else {
                        win.$('#dg').datagrid('reload');
                        win.$('#win').dialog('close');
                    }
                }else {
                    $.messager.show({
                        title: '操作提示',
                        msg: '操作失败',
                        timeout: 2000,
                        showType: 'slide'
                    });
                }
            }
        })
    }
</script>
</html>
