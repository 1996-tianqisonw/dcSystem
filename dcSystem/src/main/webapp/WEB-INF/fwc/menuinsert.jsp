<%--
  Created by IntelliJ IDEA.
  User: 86173
  Date: 2020/5/31
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../common/common.jspf"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form id="fm" method="post">
    <div>
        <label for="menuName">菜单名字</label>
        <input id="menuName" class="easyui-validatebox" type="text" name="menuName" />
    </div>
    <div>
        <label for="url">url</label>
        <input id="url" class="easyui-validatebox" type="text" name="url"/>
    </div>
    <div>
        <label for="permissions">权限编码</label>
        <input id="permissions" class="easyui-validatebox" type="text" name="permissions"/>
    </div>
    <div style="display: none">
        <label for="orgId">父类</label>
        <input id="orgId" class="easyui-validatebox" type="text" name="orgId" value="0"/>
    </div>
    <div>
        <label for="type">类型</label>
        <input id="type" class="easyui-validatebox" type="text" name="type" value="菜单"/>
    </div>
    <div>
        <select id="state"	class="easyui-combobox" name="state" style="width:200px;">
            <option>可用</option>
            <option>禁用</option>
        </select>
    </div>
    <div>
        <label for="sorting">排序</label>
        <input id="sorting" class="easyui-validatebox" type="text" name="sorting"/>
    </div>
    <a id="btn" href="#" onclick="show()"  class="easyui-linkbutton" data-options="iconCls:'icon-ok'">查询</a>
</form>
</body>
<script type="text/javascript">
    function show(){
        var win = parent.$("iframe[title='菜单管理']").get(0).contentWindow;
        $("[name='menuName']").validatebox({
            required : true,
            missingMessage : '1111'
        });
        $("[name='url']").validatebox({
            required : true,
            missingMessage : '2222'
        });
        $("[name='permissions']").validatebox({
            required : true,
            missingMessage : '2222'
        });
        $("[name='type']").validatebox({
            required : true,
            missingMessage : '2222'
        });
        $('#fm').form('submit',{
            url:'${proPath}/MenuController/insertMenu.mvc',
            success:function (msg) {
                if (msg>0){
                    win.$('#box').treegrid('reload');
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
