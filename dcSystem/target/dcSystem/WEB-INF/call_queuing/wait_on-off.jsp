<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../dcsystem/dcsystem.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<style type="text/css">
    .easyui-combobox {
        width: 160px;
    }

    .easyui-linkbutton {
        position: relative;
        top: -5px;
    }

    .y_float {
        float: left;
        padding-left: 30px;//相对左元素的距离
    }
</style>
<%--<script type="text/javascript" src="${proPath}/res/js/dataFormat.js"/>--%>
<form id="ff" method="post" style="position: relative;top: 10px;">
    <div class="y_float">
        <label for="">总公司:</label>
        <select class="easyui-combobox">
            <option>888</option>
        </select>
    </div>
    <div class="y_float">
        <label for="">店铺名称:</label>
        <select class="easyui-combobox"> dfd</select>
    </div>

    <a id="btn1" href="#" onclick="query()" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">查询</a>
</form>
<table id="wait_on"></table>
<div id="paidui_win"></div>
<script type="text/javascript">
    $('#wait_on').datagrid({
        url: '${proPath}/wait_on/list.mvc',    //获取json字符串
        columns: [[
            {checkbox: true},
            {field: 'onOffId', title: '门店名称', width: 100},
            {field: 'dpId', title: '门店名称', width: 100},
            {field: 'stateName', title: '是否启用排队', width: 100},
            {field: 'createTime', title: '创建时间', width: 100, formatter: formatDatebox},
            {field: 'updateTime', title: '修改时间', width: 100, formatter: formatDatebox}
        ]],
        fitColumns: true,
        toolbar: [{
            iconCls: 'icon-edit',
            text: '启用',
            handler: function () {
                updateWait_of(1)
            }
        }, '-', {
            iconCls: 'icon-edit',
            text: '停用',
            handler: function () {
                updateWait_of(0)
            }
        }],
        striped: true,
        pagination: true,
        rownumbers: true
    });

    function query() {
        //获取填写的值
        var czName = $("#czName").val();
        var czId = $("#czId").val();
        //调用 datagrid方法根据查询参数重新加载表格数据
        $('#wait_on').datagrid('reload', {
            czName: czName,
            czId: czId
        });
    }
    $("#wait_on").datagrid("hideColumn", "onOffId");
    //修改启用状态
    function updateWait_of(state) {
        var q = confirm("确认要修改吗？");
        if (q) {
            var rows = $('#wait_on').datagrid("getSelections");
            if (rows.length == 1 && rows[0].onOffState != state) {
                $.ajax({//进行ajax请求
                    type: "post",
                    url: "${proPath}/wait_on/update_on.mvc",
                    data: {
                        "state": state,
                        "on_id": rows[0].onOffId
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
                        $('#wait_on').datagrid("load");
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        //alert(typeof(errorThrown));
                    }
                });
            } else {
                $.messager.show({
                    title: '我的消息',
                    msg: '请选择一行，且只能选择一行(并确认状态)！！！',
                    timeout: 5000,
                    showType: 'slide'
                });
            }
        }
    }
</script>
</body>
</html>
