<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/5/28
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../dcsystem/dcsystem.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table id="dg"></table>
<div id="win"></div>
<script type="text/javascript">
    $('#dg').datagrid({
        url:'${proPath}/tableController/table.mvc',
        columns:[[
            {field:'ck',checkbox:true},
            {field:'dcId',title:'餐桌编号',width:100},
            {field:'dcName',title:'餐桌名字',width:100},
            {field:'dcSpecificationsText',title:'餐桌的规格',width:100},
            {field:'dcShop',title:'餐桌的店铺',width:100},
            {field:'dcUsestatusText',title:'使用状态',width:100},
            {field:'dcUpdatereason',title:'修改原因',width:100},
            {field:'dcCreatetime',title:'创建时间',width:100},
            {field:'dcUpdatetime',title:'更新时间',width:100},
            {field:'dcFormText',title:'就餐形式',width:100},
            {field:'dcCompanies',title:'餐桌的公司',width:100},
            {field:'dcQrcode',title:'餐桌的二维码',width:100}
        ]],
        fitColumns:true,
        singleSelect:true,
        toolbar:[{
            text:'新增',
            iconCls:'icon-add',
            handler:function(){
                alert('新增按钮');
                $('#win').window({
                    title:"添加用户",
                    width:600,
                    height:400,
                    href:'/BaseController/path/table/tableInsert.mvc?ID=0',
                    model:true
                });
            }
        },'-',{
            text:'修改',
            iconCls:'icon-edit',
            handler:function () {
                alert('修改按钮');
                if($('#dg').datagrid('getSelected').dcId != null) {
                    $('#win').window({
                        title: "修改用户",
                        width: 600,
                        height: 400,
                        href: '/BaseController/path/table/tableUpdate.mvc?ID=' + $('#dg').datagrid('getSelected').dcId,
                        model: true
                    });
                }
            }
        },'-',{
            text:'删除',
            iconCls:'icon-remove',
            handler:function () {
                alert('删除按钮');
                $('#dg').datagrid({
                    href:'/tableController/deleteTable.mvc?ID=' + $('#dg').datagrid('getSelected').dcId,
                });
            }
        }],
        pageSize:5,
        pageList:[3,5,8,10,15],
        pagination:true,
        rownumbers:true,
        striped:true
    });
</script>
</body>
</html>
