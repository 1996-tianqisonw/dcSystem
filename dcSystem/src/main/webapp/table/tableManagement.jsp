<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/5/31
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../dcsystem/dcsystem.jsp"%>
<% session.setAttribute("sdfs",request.getContextPath());%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form id="ff" method="post">
    <div>
        <label for="dcId">餐桌编号：</label>
        <input class="easyui-validatebox" type="text" name="dcId">
    </div>
    <div>
        <label for="dcName">餐桌名字：</label>
        <input class="easyui-validatebox" type="text" name="dcName">
    </div>
    <div>
        <label for="dcForm">餐桌类型:</label>
        <select name="dcForm" class="easyui-combobox">
            <option value="0">请选择</option>
            <option value="1">整桌</option>
            <option value="2">拼桌</option>
        </select>
    </div>
    <div>
        <label for="dcUsestatus">餐桌使用状态:</label>
        <select name="dcUsestatus" class="easyui-combobox">
            <option value="0">请选择</option>
            <option value="1">就餐中</option>
            <option value="2">可使用</option>
            <option value="3">清洁中</option>
            <option value="4">维修中</option>
        </select>
    </div>
    <input class="easyui-validatebox" type="button" onclick="queryTable()" value="查询">
</form>
<table id="dg"></table>
<div id="win"></div>
<script type="text/javascript">
    function queryTable(){
        $('#dg').datagrid('load',{
            dcUsestatus:$("[name=dcUsestatus]").val(),
            dcName:$("[name=dcName]").val(),
            dcForm:$("[name=dcForm]").val(),
            dcId:$("[name=dcId]").val()
        });
    }
    $('#dg').datagrid({
        url:'/tableController/table.mvc',
        columns:[[
            {id:'ck',checkbox:true},
            {field:'dcId',title:'餐桌编号',width:100,editor:{type:'validatebox',options:{ required : true}}},
            {field:'dcQrcode',title:'餐桌二维码',width:100, formatter: function (value, row, index) {
                return '<img src=/erweima/'+row.dcId+'.gif />';
            }},
            {field:'dcName',title:'餐桌名字',width:100,editor:{type:'validatebox',options:{ required : true}}},
            {field:'dcSpecificationsText',title:'餐桌的规格',width:100,editor:{type:'combobox',options:{
                required : true,
                data:
                    [
                        {'id':'1','text':'大桌'},
                        {'id':'2','text':'中桌'},
                        {'id':'3','text':'小桌'}
                    ],
                valueField:'id',
                textField:'text'}}},
            {field:'dcShop',title:'餐桌的店铺',width:100,editor:{type:'validatebox',options:{ required : true}}},
            {field:'dcUsestatusText',title:'使用状态',width:100,editor:{type:'combobox',options:{required : true,
                data:
                    [
                        {'id':'1','text':'就餐中'},
                        {'id':'2','text':'可使用'},
                        {'id':'3','text':'维修中'},
                        {'id':'4','text':'清洁中'}
                    ],
                valueField:'id',
                textField:'text'}}},
            {field:'dcUpdatereason',title:'修改原因',width:100},
            {field:'dcCreatetime',title:'创建时间',width:100},
            {field:'dcUpdatetime',title:'更新时间',width:100},
            {field:'dcFormText',title:'就餐形式',width:100,editor:{type:'combobox',options:{ required : true,
                data:
                    [
                        {'id':'1','text':'整桌'},
                        {'id':'2','text':'拼桌'}
                    ],
                valueField:'id',
                textField:'text'}}},
            {field:'dcCompanies',title:'餐桌的公司',width:100,editor:{type:'combobox',options:{ required : true,
                data:[
                    {'id':'上海分公司','text':'上海分公司'},
                    {'id':'北京分公司','text':'北京分公司'},
                    {'id':'广州分公司','text':'广州分公司'},
                    {'id':'深圳分公司','text':'深圳分公司'}
                ],
                valueField:'id',
                textField:'text'
            }}}
        ]],
        fitColumns:true,
        singleSelect:true,
        toolbar:[{
            text:'新增',
            iconCls:'icon-add',
            handler:function() {
                alert('新增按钮');
                $('#redo,#save').show();
                //这是为了防止添加多条
                if (!this.editRow){
                    //这是添加一行的方法
                    $('#dg').datagrid('insertRow', {
                        index:0,
                        row:{
                            dcName: '餐桌几号',
                            dcShop: 'xx店'
                        },
                    });
                   /*
                   1.总的完整的流程为：打开编辑，编辑校验，如校验通过，关闭编辑。触发编辑完成事件，把参数传给后台，如校验不通过，等待编辑通过为止。
                   2.打开编辑，打开哪一行的编辑呢？关闭哪一行的编辑呢？通过什么来确认呢？打开与关闭的编辑行数是否要一致？不一致会带来什么？
                   3.新增为编辑第一行，关闭也为第一行，通过一个入参 0 来确认，修改和删除则无法确认具体的行数，因为其可以是任意行数 通过 index来确认，
                   要一致，否则无法保证程序执行。
                   4.带来不一致的原因是什么？ 因为采用的是复选框，新增是不选择选项的，或可以选择任意一个选项，这就会造成打开与关闭的行数的入参不一致的问题，
                   而删除和修改是先选择后进行相关操作，又因采用单选，所以不存在上述问题。由此要解决的问题就是如何保证添加时，入参一致的问题。
                   5.怎么解决?在保存的选项进行判断，如何进行的操作是添加就入参为0，如果是修改和删除就index ， 二就是复选框的绑定问题。
                   */
                    //这是要打开编辑的方法 beginEdit 有一个参数：即要打开的行数。
                    $('#dg').datagrid('beginEdit',0);
                    this.editRow = true;
                }
            }
        },'-',{
            text:'修改',
            iconCls:'icon-edit',
            handler:function () {
                alert('修改按钮');
                <!--这是修改一行-->
                alert($('#dg').datagrid('getSelected'))
                if($('#dg').datagrid('getSelected')!=null){
                    if (!this.editRow) {
                        $('#redo,#save').show();
                        $('#dg').datagrid('updateRow', {
                            index: $('#dg').datagrid("getRowIndex", $('#dg').datagrid('getSelected')),
                        });
                        $('#dg').datagrid('beginEdit',$('#dg').datagrid("getRowIndex",$('#dg').datagrid('getSelected')));
                    }
                    this.editRow = true;
                }else{
                    $.messager.show({
                        title: '提示',
                        hideDelay:600,
                        msg:"请选择一个选项！"
                    });
                }
            }
        },'-',{
            text:'删除',
            iconCls:'icon-remove',
            handler:function () {
                alert('删除按钮');
                if(($('#dg').datagrid("getRowIndex",$('#dg').datagrid('getSelected')))==0) {
                    $.ajax({
                        method: 'post',
                        url: '/tableController/delete.mvc',
                        data: {
                            dcId: $('#dg').datagrid('getSelected').dcId,
                        },
                        beforeSend: function () {
                            $('#dg').datagrid('loading');
                        },
                        success: function (data) {
                            if (data) {
                                $('#dg').datagrid('loaded');
                                $('#dg').datagrid('load');
                                $('#dg').datagrid('unselectAll');
                                $.messager.show({
                                    title: '提示',
                                    msg: data + "个用户删除成功！"
                                });
                            }
                        }
                    });
                }else {
                    $.messager.show({
                        title: '提示',
                        hideDelay:600,
                        msg:"请选择一个选项！"
                    });
                }
            }
        },'-',{
            id:'save',
            text:'保存',
            iconCls:'icon-save',
            handler:function () {
                //结束第一行的编辑
                //用这个$('#dg').datagrid('getSelected')==null进行判断是不严整的，因为新增的初始是不选中，但操作过程可以选中，也就会造成有值
                if($('#dg').datagrid('getSelected')==null){
                    //这是关闭编辑的方法 endEdit，有一个参数：即要关闭的行数。
                    $('#dg').datagrid('endEdit',0)
                }else {
                    $('#dg').datagrid('endEdit', ($('#dg').datagrid("getRowIndex", $('#dg').datagrid('getSelected'))));
                }
            }
        },'-',{
            id:'redo',
            text:'取消编辑',
            iconCls:'icon-redo',
            handler:function () {
                $('#dg').datagrid().editRow = false;
                $('#redo,#save').hide();
                $('#dg').datagrid('rejectChanges');
            }
        }],
        pageSize:5,
        pageList:[3,5,8,10,15],
        pagination:true,
        rownumbers:true,
        striped:true,
        onAfterEdit:function (rowIndex, rowData, changes) {
            $('#dg').datagrid().editRow = false;
            $('#redo,#save').hide();
            var insertTble = $('#dg').datagrid('getChanges', 'inserted');
            var updated = $('#dg').datagrid('getChanges', 'updated');
            /*  alert(insertTble.length)
             alert(updated.length)*/
            if (updated.length > 0) {
                $.ajax({
                    method: 'post',
                    url: '/tableController/update.mvc',
                    data: {
                        dcId: rowData.dcId,
                        dcName: rowData.dcName,
                        dcFormText: rowData.dcFormText,
                        dcShop: rowData.dcShop,
                        dcUsestatusText: rowData.dcUsestatusText,
                        dcSpecificationsText: rowData.dcSpecificationsText,
                        dcCompanies: rowData.dcCompanies
                    },
                    beforeSend: function () {
                        $('#dg').datagrid('loading');
                    },
                    success: function (data) {
                        if (data) {
                            $('#dg').datagrid('loaded');
                            $('#dg').datagrid('load');
                            $('#dg').datagrid('unselectAll');
                            $.messager.show({
                                title: '提示',
                                msg: data + "个用户修改成功！"
                            });
                        }
                    }
                });
            }
                if (insertTble.length > 0) {
                    $.ajax({
                        method: 'post',
                        url: '/tableController/insert.mvc',
                        data: {
                            dcId: rowData.dcId,
                            dcName: rowData.dcName,
                            dcFormText: rowData.dcFormText,
                            dcShop: rowData.dcShop,
                            dcUsestatusText: rowData.dcUsestatusText,
                            dcSpecificationsText: rowData.dcSpecificationsText,
                            dcCompanies: rowData.dcCompanies
                        },
                        beforeSend: function () {
                            $('#dg').datagrid('loading');
                        },
                        success: function (data) {
                            if (data) {
                                $('#dg').datagrid('loaded');
                                $('#dg').datagrid('load');
                                $('#dg').datagrid('unselectAll');
                                $.messager.show({
                                    title: '提示',
                                    msg: data + "个用户添加成功！"
                                });
                            }
                        }
                    });
                }
            }
    });
    $('#redo,#save').hide();
</script>
</body>
</html>