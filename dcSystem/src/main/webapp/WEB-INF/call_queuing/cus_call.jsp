<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/dcsystem/dcsystem.jsp" %>

<html>
<head>
    <title>Title</title>
</head>

<body>
<script type="text/javascript" src="${proPath}/res/js/dataFormat.js"/>
<style type="text/css">
    .easyui-combobox {
        width: 160px;
        margin-left: 10px;
        overflow: hidden;
    }

    .easyui-linkbutton {
        position: relative;
        top: -5px;
    }
</style>
<form id="ff" method="post" style="position: relative;top: 10px;">
    <div style="float:left">
        <label for="">总公司:</label>
        <select class="easyui-combobox">
            <option>888</option>
        </select>
    </div>
    <div style="float:left">
        <label for="">店铺名称:</label>
        <select class="easyui-combobox">
            <option>test</option>
        </select>
    </div>
    <div style="float:left">
        <label for="czId">餐桌编号:</label>
        <input id="czId" class="easyui-validatebox" type="text" name="czId"/>
    </div>
    <div style="float:left">
        <label for="czName">餐桌名称:</label>
        <input id="czName" class="easyui-validatebox" type="text" name="czName"/>
    </div>
    <a id="btn1" href="#" onclick="query()" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">查询</a>
</form>
<table id="cus_call"></table>
<div id="call_add"></div>
<script type="text/javascript">
    $('#cus_call').datagrid({
        url: '${proPath}/cus_call/list.mvc',    //获取json字符串
        columns: [[
            {checkbox: true},
            {field: 'czId', title: '餐桌编号', width: 100},
            {field: 'czName', title: '餐桌名称', width: 100},
            {field: 'callText', title: '服务内容', width: 100},
            {field: 'stateName', title: '处理状态', width: 100},
            {field: 'beginTime', title: '开始时间', width: 100, formatter: formatDatebox},
            {field: 'dealTime', title: '处理时间', width: 100, formatter: formatDatebox}
        ]],
        fitColumns: true,
        toolbar: [{
            iconCls: 'icon-add',
            text: '新增',
            handler: function () {
                $('#call_add').window({
                    title: '添加呼叫服务',
                    width: 400,
                    height: 500,
                    modal: true,
                    href: '${proPath}/BaseController/findUrl/call_queuing/call_add.mvc'
                })
            }
        }, '-', {
            iconCls: 'icon-edit',
            text: '处理呼叫服务',
            handler: function () {
                var q = confirm("确认要修改吗？");
                if (q) {
                    var rows = $('#cus_call').datagrid("getSelections");
                    var callIds = new Array;//数组-呼叫记录
                    var custIds = new Array;//数组-客户编号
                    var checkState = true;
                    for (var i = 0; i < rows.length; i++) {
                        callIds[i] = rows[i].callId;
                        custIds[i] = rows[i].custId;
                    }
                    for (var i = 0; i < rows.length; i++) {
                        if (rows[i].dealState != 0) {
                            checkState = false;
                            break;
                        }
                    }
                    //单行操作 if (rows.length == 1 && rows[0].dealState == 0) {
                    //多行
                    if (rows.length >= 1 && checkState) {
                        $.ajax({//进行ajax请求
                            type: "post",
                            url: "${proPath}/cus_call/dealCall.mvc",
                            traditional: true,
                            data: {
                                //"pno": rows[0].callId,
                                //"custId": rows[0].custId//客人标志

                                callId: callIds,
                                custId: custIds
                            },
                            cache: true,
                            async: true,
                            success: function (data) {
                                $.messager.show({
                                    title: '我的消息',
                                    msg: "成功处理" + data.result + "条记录",
                                    timeout: 5000,
                                    showType: 'slide'
                                });
                                $('#cus_call').datagrid("reload");
                            },
                            error: function (XMLHttpRequest, textStatus, errorThrown) {
                                alert(typeof(errorThrown));
                            }
                        });
                    } else {
                        $.messager.show({
                            title: '我的消息',
                            msg: '只能选择未处理的服务！！！',
                            timeout: 5000,
                            showType: 'slide'
                        });
                    }
                }
            }
        }],
        striped: true,
        pagination: true,
        rownumbers: true,
        pageList: [5, 10, 15, 20, 25],
        pageSize: 10
    });

    function query() {
        //获取填写的值
        var czName = $("#czName").val();
        var czId = $("#czId").val();
        //调用 datagrid方法根据查询参数重新加载表格数据
        $('#cus_call').datagrid('reload', {
            czName: czName,
            czId: czId
        });
    }
    // 更新选择的面板的新标题和内容
    function update_tab(title, url) {
        var tab = $('#tt').tabs('getSelected');  // 获取选择的面板
        $('#tt').tabs('update', {
            tab: tab,
            options: {
                title: title,
                href: url  // 新内容的URL
            }
        });
    }

    function update_tab1(url) {
        var tab = $('#tt').tabs('getSelected');  // 获取选择的面板
        tab.panel('refresh', url);
    }

</script>
</body>
</html>
