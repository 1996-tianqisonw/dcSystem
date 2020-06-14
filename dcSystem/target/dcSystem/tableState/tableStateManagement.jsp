<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/5/24
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../dcsystem/dcsystem.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script type="text/javascript" src="${proPath}/res/js/dataFormat.js"/>
<form  method="post">
    <div>
        <label for="dtId">餐桌编号：</label>
        <input class="easyui-validatebox" name="dtId" type="text" id="dtId">
    </div>
    <div>
        <label for="dtEnvironment">就餐环境:</label>
        <select class="easyui-combobox" name="dtEnvironment" id="dtEnvironment">
            <option value="0">请选择</option>
            <option value="1">堂厅</option>
            <option value="2">包厢</option>
        </select>
    </div>
    <div>
        <label for="dtUsername">使用者:</label>
        <input class="easyui-valiudatebox" type="text" name="dtUsername" id="dtUsername">
    </div>
    <input class="easyui-validatebox" onclick="queryTableState()" type="button" value="查询">
</form>
<table id="state"></table>
<div id="win"></div>
<script type="text/javascript">
    function queryTableState(){
        $('#state').datagrid('load',{
            dtId:$("[name=dtId]").val(),
            dtEnvironment:$("[name=dtEnvironment]").val(),
            dtUsername:$("[name=dtUsername]").val()
        });
    }
    $('#state').datagrid({
        url:"${proPath}/tableState/stateSelect.mvc",
        columns:[[
            {field:'ck',checkbox:true},
            {field:'dtId',title:'餐桌编号',width:100},
            {field:'dtEnvironmentText',title:'就餐环境',width:100,editor:{type:'combobox',options:{ required : true,
                data:[
                    {'id':'1','text':'堂厅'},
                    {'id':'2','text':'包厢'}
                ],
                valueField:'id',
                textField:'text'}}},
            {field:'dtUsername',title:'使用者',width:100,editor:{type:'validatebox',options:{ required : true}}},
            {field:'dtMobilephonenumber',title:'预约手机号',width:100,editor:{type:'validatebox',options:{ required : true}}},
            {field:'dtStarttime',title:'预约开始时间',width:100,formatter: formatDatebox},
            {field:'dtEndtime',title:'预约结束时间',width:100,formatter: formatDatebox},
            {field:'dtNote',title:'备注',width:100,editor:{type:'validatebox',options:{}}},
            {field:'dtCreatetime',title:'创建时间',width:100,formatter: formatDatebox},
            {field:'dtNewtime',title:'更新时间',width:100,formatter: formatDatebox},
            {field:'dtUpdatereason',title:'更新的原因',width:100,editor:{type:'validatebox',options:{}}}
        ]],
        fitColumns:true,
        singleSelect:true,
        toolbar:[{
            text:'修改',
            iconCls:'icon-add',
            handler:function(){
                alert('修改按钮');
                alert($('#state').datagrid('getSelected'))
                if($('#state').datagrid('getSelected')!=null) {
                    $('#save,#redo').show()
                    alert(!this.editRow)
                    if (!this.editRow) {
                        $('#state').datagrid('updateRow', {
                            index: $('#state').datagrid('getRowIndex', $('#state').datagrid('getSelected')),
                        });
                        $('#state').datagrid('beginEdit', $('#state').datagrid('getRowIndex', $('#state').datagrid('getSelected')));
                    }
                    this.editRow = true;
                }else{
                    $.messager.show({
                        title:'提示',
                        hideDelay:600,
                        msg:'请选择一个选项!'
                    })
                }
                /*$('#win').window({
                    title:"修改餐桌状态",
                    width:600,
                    height:400,
                    href:'/BaseController/path/tableState/tableStateUpdate.mvc?ID='+$('#state').datagrid('getSelected').dtId,
                    model:true
                });*/
            }
        },'-', {
            text: '已使用完',
            iconCls: 'icon-edit',
            handler: function () {
                alert('已使用完');
                alert($('#state').datagrid('getSelected'))
                if($('#state').datagrid('getSelected')!=null) {
                    $.ajax({
                        method:'post',
                        url:'/tableState/stateUsedUp.mvc',
                        data:{
                            dtId:$('#state').datagrid('getSelected').dtId
                        },
                        beforeSend: function () {
                            $('#state').datagrid('loading');
                        },
                        success: function (data) {
                            if (data) {
                                $('#state').datagrid('loaded');
                                $('#state').datagrid('load');
                                $('#state').datagrid('unselectAll');
                                $.messager.show({
                                    title: '提示',
                                    msg: data + "个餐桌使用完！"
                                });
                            }
                        }
                    })
                }else{
                    $.messager.show({
                        title:'提示',
                        hideDelay:600,
                        msg:'请选择一个选项!'
                    })
                }
                /*$('#state').datagrid({
                    href: '/tableState/stateUsedUp.mvc?ID='+$('#state').datagrid('getSelected').dtId,
                })*/
            }
        },'-', {
            id:'save',
            text: '保存',
            iconCls: 'icon-save',
            handler: function () {
                $('#state').datagrid('endEdit', $('#state').datagrid('getRowIndex', $('#state').datagrid('getSelected')));
            }
        },'-', {
            id:'redo',
            text: '取消编辑',
            iconCls: 'icon-redo',
            handler: function () {
                $('#state').datagrid().editRow = false;
                $('#redo,#save').hide();
                $('#state').datagrid('rejectChanges');
            }
        }],
        PageSize:5,
        pageList:[3,5,8,10,15],
        pagination:true,
        rownumbers:true,
        striped:true,
        onAfterEdit:function (rowIndex, rowData, changes) {
            $('#state').datagrid().editRow = false;
            $('#save,#redo').hide()
            var update = $('#state').datagrid('getChanges','updated');
          /*  alert(update)
            alert(update.length)*/
            if(update.length>0){
                $.ajax({
                    method:'post',
                    url:'/tableState/stateUpdate.mvc',
                    data: {
                        dtId : rowData.dtId,
                        dtEnvironmentText : rowData.dtEnvironmentText,
                        dtUsername : rowData.dtUsername,
                        dtMobilephonenumber : rowData.dtMobilephonenumber,
                        dtNote : rowData.dtNote,
                        dtUpdatereason : rowData.dtUpdatereason,
                    },
                    beforeSend: function () {
                        $('#state').datagrid('loading');
                    },
                    success: function (data) {
                        if (data) {
                            $('#state').datagrid('loaded');
                            $('#state').datagrid('load');
                            $('#state').datagrid('unselectAll');
                            $.messager.show({
                                title: '提示',
                                msg: data + "个餐桌信息修改成功！"
                            });
                        }
                    }
                })
            }
        }
    })
    $('#save,#redo').hide()
</script>
</body>
</html>
