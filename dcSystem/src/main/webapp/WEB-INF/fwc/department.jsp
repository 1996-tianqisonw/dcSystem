<%--
  Created by IntelliJ IDEA.
  User: 86173
  Date: 2020/5/27
  Time: 14:58
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
    <a id="btn" href="#" onclick="query()"  class="easyui-linkbutton" data-options="iconCls:'icon-ok'">查询</a>
</form>
<table id="dg"></table>
<div id="win"></div>


<script type="text/javascript">
    $('#dg').datagrid({
        url:'${proPath}/DepartmentController/selectdept.mvc',
        columns:[[
            {checkbox:true},
            {field:'departmentId',title:'编号',width:50},
            {field:'departmentName',title:'部门',width:50},
            {field:'company',title:'公司',width:50},
            {field:'store',title:'店铺',width:50},
            {field:'position',title:'职位',width:50},
            {field:'departmentAdd',title:'职位',width:50,align:'right'}
        ]] ,
        fitColumns:true,
        toolbar: [{
            iconCls : 'icon-add',
            text : '新增',
            handler : function() {
                alert('添加按钮');
                parent.$('#win').window({
                    width:600,
                    height:400,
                    modal:true,
                    content: "<iframe src='${proPath}/pageController/goURL/fwc/deptinsert.mvc' height='100%' width='100%' frameborder='0px' ></iframe>"
                });
            }
        },'-',{
            iconCls : 'icon-edit',
            text : '修改',
            handler : function() {
                alert('修改按钮');
                var array = $("#dg").datagrid("getSelections");
                if(array.length==1){
                    parent.$('#win').window({
                        title:'修改页面',
                        width:600,
                        height:400,
                        modal:true,
                        content: "<iframe src='${proPath}/pageController/goURL/fwc/deptupdate.mvc' height='100%' width='100%' frameborder='0px' ></iframe>"
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
        }],
        striped:true,
        pagination:true,
        rownumbers:true,
        pageList:[5,10,15,20],
        pageSize:5

    });

    function query(){
        var departmentName=  $("#departmentName").val();
        var company=  $("#company").val();
        var store=  $("#store").val();
        var position=  $("#position").val();
        $('#dg').datagrid('load',{
            departmentName: departmentName,
            company:company,
            store: store,
            position:position
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
                            alert(msg[n].store);
                            if (msg[n].store!="null"&&msg[n].store!=null) {
                                $("#store").append("<option value='" + msg[n].store + "'>" + msg[n].store + "</option>");
                            }
                        }
                    }
                    if (a==3){
                        $("#position").empty();
                        for (n = 0;n<msg.length;n++){
                            $("#position").append("<option value='" + msg[n].position + "'>" + msg[n].position + "</option>");
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
