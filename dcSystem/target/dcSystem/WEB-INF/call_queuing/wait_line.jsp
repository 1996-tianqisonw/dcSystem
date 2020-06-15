<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../dcsystem/dcsystem.jsp"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<style type="text/css">
    .easyui-combobox {
        width: 140px;
        margin-left: 10px;
        overflow: hidden;
    }

    .easyui-linkbutton {
        position: relative;
        top: -5px;
    }
</style>
<script type="text/javascript" src="${proPath}/res/js/dataFormat.js"/>
<form id="ff" method="post" style="position: relative;top: 10px;">
    <div style="float:left;">
        <label for="">总公司:</label>
        <select class="easyui-combobox"><option>888</option></select>
    </div>
    <div style="float:left">
        <label for="">店铺名称:</label>
        <select class="easyui-combobox"> dfd</select>
    </div>
    <div style="float:left">
        <label for="czId">排队序号:</label>
        <input id="czId" class="easyui-validatebox" type="text" name="czId"  />
    </div>
    <div style="float:left">
        <label for="czName">用餐人数:</label>
        <input id="czName" class="easyui-validatebox" type="text" name="czName"  />
    </div>
    <div style="float:left">
        <label for="">排队状态:</label>
        <select class="easyui-combobox"> dfd</select>
    </div>
    <a id="btn1" href="#" onclick="query()"  class="easyui-linkbutton" data-options="iconCls:'icon-ok'">查询</a>
</form>
<table id="wait_line"></table>
<div id="win_line"></div>
<script type="text/javascript">
    $('#wait_line').datagrid({
        url:'${proPath}/wait_line/list.mvc',    //获取json字符串
        columns:[[
            {checkbox:true},
            {field:'lineId',title:'主键',width:100},
            {field:'dpId',title:'店铺名称',width:100},
            {field:'lineXh',title:'排队序号',width:100},
            {field:'custName',title:'排队顾客',width:100},
            {field:'custTel',title:'手机号',width:100},
            {field:'pepleNum',title:'用餐人数',width:100},
            {field:'stateName',title:'排队情况',width:100},
            {field:'beginTime',title:'开始时间',width:100,formatter: formatDatebox},
            {field:'dealTime',title:'处理时间',width:100,formatter: formatDatebox}
        ]] ,
        fitColumns:true,
        toolbar: [{
            iconCls: 'icon-add',
            text:'新增',
            handler: function(){$('#win_line').window({
                title: '添加排队信息',
                width: 400,
                height: 500,
                modal: true,
                href: '${proPath}/BaseController/findUrl/call_queuing/wait_line_add.mvc'
            })}
        },'-',{
            iconCls: 'icon-edit',
            text:'安排就餐',
            handler: function(){updateLine_state(1)}
        },'-',{
            iconCls: 'icon-edit',
            text:'客人取消排队',
            handler: function(){updateLine_state(2)}
        },'-',{
        iconCls: 'icon-edit',
        text:'过号处理',
        handler: function(){updateLine_state(3)}
    },'-',{
            iconCls: 'icon-edit',
            text:'重置排号',
            handler: function(){
                var q = confirm("确认要重新排号吗？");
                if (q) {
                        $.ajax({//进行ajax请求
                            type: "post",
                            url: "${proPath}/wait_line/reloadxh.mvc",
                            cache: true,
                            async: true,
                            success: function (data, textStatus, jqXHR) {
                                if (data.code == 200) {
                                    $.messager.show({
                                        title: '我的消息',
                                        msg: data.message,
                                        timeout: 5000,
                                        showType: 'slide'
                                    });
                                } else {
                                    alert(data.message);
                                }
                                $('#wait_line').datagrid("load");
                            },
                            error: function (XMLHttpRequest, textStatus, errorThrown) {
                                //alert(typeof(errorThrown));
                            }
                        });
                    }
                    }
        }],
        striped:true,
        pagination:true,
        rownumbers:true
    });

$("#wait_line").datagrid("hideColumn","lineId");

    function query(){
        //获取填写的值
        var czName=  $("#czName").val();
        var czId=  $("#czId").val();
        //调用 datagrid方法根据查询参数重新加载表格数据
        $('#wait_line').datagrid('reload',{
            czName:czName,
            czId: czId
        });
    }

    function updateLine_state(state) {
        var q = confirm("确认要修改吗？");
        if (q) {
            var rows = $('#wait_line').datagrid("getSelections");
            if (rows.length == 1 && rows[0].dealState != state) {
                $.ajax({//进行ajax请求
                    type: "post",
                    url: "${proPath}/wait_line/update_state.mvc",
                    data: {
                        "state": state,
                        "on_id":rows[0].lineId
                    },
                    cache: true,
                    async: true,
                    success: function (data, textStatus, jqXHR) {
                        if (data.code == 200) {
                            $.messager.show({
                                title: '我的消息',
                                msg: data.message,
                                timeout: 5000,
                                showType: 'slide'
                            });
                        } else {
                            alert(data.message);
                        }
                       $('#wait_line').datagrid("load");
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        //alert(typeof(errorThrown));
                    }
                });
            } else {
                $.messager.show({
                    title: '我的消息',
                    msg: '请选择一行，且只能选择一行(确认状态)！！！',
                    timeout: 5000,
                    showType: 'slide'
                });
            }
        }
    }
</script>
</body>
</html>
