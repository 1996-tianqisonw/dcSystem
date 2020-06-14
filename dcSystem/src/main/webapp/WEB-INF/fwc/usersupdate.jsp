<%--
  Created by IntelliJ IDEA.
  User: 86173
  Date: 2020/5/29
  Time: 23:06
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
        <label for="userId">编号</label>
        <input id="userId" class="easyui-validatebox" type="text" name="userId"/>
    </div>
    <div>
        <label for="userPassword">密码</label>
        <input id="userPassword" class="easyui-validatebox" type="password" name="userPassword" value="111111" />
    </div>
    <div>
        <label for="name">名字</label>
        <input id="name" class="easyui-validatebox" type="text" name="name" />
    </div>
    <div onclick="show2(1)">
        <label for="departmentName">部门</label>
        <select id="departmentName" name="departmentName" style="width:200px;">
            <option>总部</option>
            <option>分部</option>
        </select>
    </div>
    <div onclick="show2(2)">
        <label for="company">公司</label>
        <select id="company" name="company" style="width:200px;">
        </select>
    </div>
    <div onclick="show2(3)">
        <label for="store">店铺</label>
        <select id="store" name="store" style="width:200px;">
        </select>
    </div>
    <div>
        <label for="position">职位</label>
        <select id="position" name="position" style="width:200px;">
        </select>
    </div>
    <div>
        <select id="state"	class="easyui-combobox" name="state" style="width:200px;">
            <option>可用</option>
            <option>禁用</option>
        </select>
    </div>
    <div>
        <label for="work">状态</label>
        <select id="work" name="work" style="width:200px;">
            <option>在职</option>
            <option>离职</option>
        </select>
    </div>
    <div>
        <label for="departure">离职时间</label>
        <input id="departure" type="text" name="departure" class="easyui-datebox"/>
    </div>
    <a id="btn" href="#" onclick="show()"  class="easyui-linkbutton" data-options="iconCls:'icon-ok'">查询</a>
</form>
</body>
<script type="text/javascript">
    var win;
    var array;
    $(function () {
        window.parent;
        win = parent.$("iframe[title='员工管理']").get(0).contentWindow;
        array =win.$("#dg").datagrid("getSelections");
        alert(array[0].userId);
        $("#fm").form('load',{
            userId : array[0].userId,
            userPassword : array[0].userPassword,
            name : array[0].name,
            departmentName : array[0].departmentName,
            company:array[0].company,
            store : array[0].store,
            position : array[0].position,
            departure : array[0].departure,
            state : array[0].state
        });
    });
    function show(){
        $("[name='name']").validatebox({
            required : true,
            missingMessage : '2222'
        });
        $("[name='department.departmentName']").validatebox({
            required : true,
            missingMessage : '3333'
        });
        $("[name='department.company']").validatebox({
            required : true,
            missingMessage : '4444'
        });
        $('#fm').form('submit',{
            url:"${proPath}/UsersController/updateUsers.mvc",
            success:function (msg) {
                if (msg>0){
                    win.$('#dg').datagrid('reload');
                    win.$('#win').dialog('close');
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

    function show2(a) {
        var str;
        var str1;
        var str2;
        if (a==1){
            str=$("#departmentName").val();
        }
        if (a==2){
            str=$("#departmentName").val();
            str1=$("#company").val();
        }
        if (a==3){
            str=$("#departmentName").val();
            str1=$("#company").val();
            str2=$("#store").val();
        }
        $.ajax({
            type: "POST",
            url:"${proPath}/DepartmentController/selectdepartment.mvc",
            traditional:true,
            data: {departmentName: str,company: str1,store: str2},
            dataType:'json',
            cache:false,
            success:function (msg) {
                if (msg.length>0) {
                    if (a==1){
                        $("#company").empty();
                        for (n = 0;n<msg.length;n++){
                            $("#company").append("<option value='"+msg[n].company+"'>"+msg[n].company+"</option>");
                        }
                    }
                    if (a==2){
                        $("#store").empty();
                        for (n = 0;n<msg.length;n++){
                            if (msg[n].store!="null"&&msg[n].store!=null) {
                                $("#store").append("<option value='" + msg[n].store + "'>" + msg[n].store + "</option>");
                            }
                        }
                    }
                    if (a==3){
                        $("#position").empty();
                        for (n = 0;n<msg.length;n++){
                            $("#position").append("<option value='"+msg[n].position+"'>"+msg[n].position+"</option>");
                        }
                    }
                } else {
                    $.messager.show({
                        title: '操作提示',
                        msg: '没有下一级别',
                        timeout: 2000,
                        showType: 'slide'
                    });
                }
            },
            async:false
        });
    }
</script>
</html>
