<%--
  Created by IntelliJ IDEA.
  User: 86173
  Date: 2020/5/29
  Time: 22:12
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
    function show(){
        var win = parent.$("iframe[title='职务管理']").get(0).contentWindow;
        $("[name='departmentName']").validatebox({
            required : true,
            missingMessage : '1111'
        });
        $("[name='company']").validatebox({
            required : true,
            missingMessage : '2222'
        });
        $('#fm').form('submit',{
            url:'${proPath}/DepartmentController/insertdept.mvc',
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
</html>
