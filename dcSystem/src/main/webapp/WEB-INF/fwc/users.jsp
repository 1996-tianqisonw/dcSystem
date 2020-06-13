<%--
  Created by IntelliJ IDEA.
  User: 86173
  Date: 2020/5/22
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../common/common.jspf"%>
<html>
<head>
    <title>员工管理</title>
</head>
<body>
<form id="fm" method="post">
    <div>
        <label for="userName">账号</label>
        <input id="userName" class="easyui-validatebox" type="text" name="userName" />
    </div>
    <div>
        <label for="name">名字</label>
        <input id="name" class="easyui-validatebox" type="text" name="name"/>
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
        <label for="state">状态</label>
        <select id="state" name="state" style="width:200px;">
            <option>可用</option>
            <option>禁用</option>
        </select>
    </div>
    <a id="btn" href="#" onclick="query()"  class="easyui-linkbutton" data-options="iconCls:'icon-ok'">查询</a>
</form>
<table id="dg"></table>
<div id="win"></div>


<script type="text/javascript">
    var a;
    $('#dg').datagrid({
        url:'${proPath}/UsersController/selectUsers.mvc',
        columns:[[
            {checkbox:true},
            {field:'userId',title:'编号',width:50},
            {field:'userName',title:'账号',width:50},
            {field:'name',title:'名字',width:50},
            {field:'departmentName',title:'部门',width:50},
            {field:'company',title:'公司',width:50},
            {field:'store',title:'店铺',width:50},
            {field:'position',title:'职位',width:50},
            {field:'work',title:'工作',width:50},
            {field:'onjob',title:'入职时间',width:50},
            {field:'departure',title:'离职时间',width:50},
            {field:'state',title:'状态',width:50,align:'right'}
        ]] ,
        fitColumns:true,
        toolbar: [{
                iconCls : 'icon-add',
                text : '新增',
                handler : function() {
                    parent.$('#win').window({
                        width:600,
                        height:400,
                        modal:true,
                        content: "<iframe src='${proPath}/pageController/goURL/fwc/usersinsert.mvc' height='100%' width='100%' frameborder='0px' ></iframe>"
                    });
            }
        },'-',{
            iconCls : 'icon-edit',
            text : '修改',
            handler : function() {
                var array = $("#dg").datagrid("getSelections");
                if(array.length==1){
                    parent.$('#win').window({
                        title:'修改页面',
                        width:600,
                        height:400,
                        modal:true,
                        content: "<iframe src='${proPath}/pageController/goURL/fwc/usersupdate.mvc' height='100%' width='100%' frameborder='0px' ></iframe>"
                    });
                }else{
                    $.messager.show({
                        title : '操作提示',
                        msg : '请只选择一条需要修改的记录。',
                        timeout : 4000,
                        showType : 'slide'
                    });

                }

            }
        },'-',{
            iconCls : 'icon-remove',
            text : '删除',
            handler : function() {
                var array = $("#dg").datagrid("getSelections");
                if (array.length > 0) {
                    var ids = new Array();
                    for (i = 0; i < array.length; i++) {
                        ids[i] = array[i].userId;
                    }
                    parent.$.messager.confirm('删除对话框', '您确认要删除吗？', function(r) {
                        if (r) {
                            $.ajax({
                                url: "${proPath}/UsersController/deleteUsers.mvc",
                                type:"POST",
                                //设置为传统方式传送参数
                                traditional:true,
                                data:{pks:ids},
                                dataType:'json',
                                success: function(html){
                                    if(html>0){
                                        alert("恭喜您，删除成功，共删除了"+html+"条记录！");
                                    }else{
                                        alert("对不起，删除失败！");
                                    }
                                    //重新刷新页面
                                    $("#dg").datagrid("reload");
                                    //请除所有勾选的行
                                    $("#dg").datagrid("clearSelections");
                                },
                                error: function (XMLHttpRequest, textStatus, errorThrown) {
                                    $.messager.alert('删除错误','请联系管理员！','error');
                                },
                            });

                        }
                    });
                } else {
                    $.messager.show({
                        title : '操作提示',
                        msg : '请先选择要删除的记录。',
                        timeout : 4000,
                        showType : 'slide'
                    });

                }

            }
        }],
        striped:true,
        pagination:true,
        rownumbers:true,
        pageList:[5,10,15,20],
        pageSize:5

    });

    function query(){
        var userName=  $("#userName").val();
        var name=  $("#name").val();
        var departmentName=  $("#departmentName").val();
        var company=  $("#company").val();
        var store=  $("#store").val();
        var position=  $("#position").val();
        var state=  $("#state").val();
        $('#dg').datagrid('load',{
            userName: userName,
            name: name,
            departmentName:departmentName,
            company: company,
            store:store,
            position:position,
            state: state
        });
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
</body>
</html>
