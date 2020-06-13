<%--
  Created by IntelliJ IDEA.
  User: 86173
  Date: 2020/5/29
  Time: 22:16
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
    <div style="display: none">
        <label for="departmentId">编号</label>
        <input id="departmentId" class="easyui-validatebox" type="text" name="departmentId"/>
    </div>
    <div>
        <label for="departmentName">部门</label>
        <select id="departmentName" name="departmentName" style="width:200px;">
            <option>总部</option>
            <option>分部</option>
        </select>
    </div>
    <div>
        <label for="company">公司</label>
        <input id="company" class="easyui-validatebox" type="text" name="company"/>
    </div>
    <div>
        <label for="store">店铺</label>
        <input id="store" class="easyui-validatebox" type="text" name="store" />
    </div>
    <div>
        <label for="position">职位</label>
        <input id="position" class="easyui-validatebox" type="text" name="position" />
    </div>
    <div>
        <label for="departmentAdd">地址</label>
        <input id="departmentAdd" class="easyui-validatebox" type="text" name="departmentAdd" />
    </div>
    <a id="btn" href="#" onclick="show()"  class="easyui-linkbutton" data-options="iconCls:'icon-ok'">查询</a>
</form>
</body>
<script type="text/javascript">
    var win;
    $(function () {
        win = parent.$("iframe[title='职务管理']").get(0).contentWindow;
        var array =win.$("#dg").datagrid("getSelections");
        $("#fm").form('load',{
            departmentId : array[0].departmentId,
            departmentName : array[0].departmentName,
            company : array[0].company,
            store : array[0].store,
            position : array[0].position,
            departmentAdd : array[0].departmentAdd
        });
    });
    $('#fm').form('load',array[0]);
    function show(){
        $("[name='departmentName']").validatebox({
            required : true,
            missingMessage : '1111'
        });
        $("[name='company']").validatebox({
            required : true,
            missingMessage : '2222'
        });
        $('#fm').form('submit',{
            url:'${proPath}/DepartmentController/updatedept.mvc',
            success:function (msg) {
                if (msg>0){
                    if (msg==2){
                        $.messager.show({
                            title: '操作提示',
                            msg: '该部门已存在',
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