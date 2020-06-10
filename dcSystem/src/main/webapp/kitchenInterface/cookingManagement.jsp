<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/5/25
  Time: 6:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../dcsystem/dcsystem.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form id="ff" method="post">
    <div>
    <label for="kcOrdernumber">订单号:</label>
    <input type="text" class="easyui-validatebox" name="kcOrdernumber">
    </div>
    <div>
    <label for="kcCooking">订单状态:</label>
    <select class="easyui-combobox" name="kcCooking">
        <option value="0">请选择</option>
        <option value="1">未处理</option>
        <option value="2">处理中</option>
        <option value="3">已处理</option>
    </select>
    </div>
    <input class="easyui-validatebox" onclick="queryCooking()" type="button" value="查询">
</form>
<table id="cooking"></table>
<div id="win"></div>
<script type="text/javascript">
    function queryCooking() {
        $('#cooking').datagrid('load',{
            kcOrdernumber:$("[name=kcOrdernumber]").val(),
            kcCooking:$("[name=kcCooking]").val()
        })
    }
    $("#cooking").datagrid({
        url:"/cooking/selectCooking.mvc",
        columns:[[
            {field:'ck',checkbox:true},
            {field:'kcOrdernumber',title:'订单号',width:200},
            {field:'kcPlaceorder',title:'做菜的数量',width:200},
            {field:'kcBacksingular',title:'退菜的数量',width:200},
            {field:'kcRmeountshould',title:'应做的数量',width:200},
            {field:'kcCookingText',title:'订单的状态',width:200},
            {field:'kcOrdertime',title:'创建时间',width:200},
            {field:'kcOperation',title:'备注',width:200}
        ]],
        fitColumns:true,
        singleSelect:true,
        toolbar:[{
            text:'订单完成',
            iconCls:'icon-add',
            handler:function(){
                alert('订单完成')
                    cooking("/cooking/cookingDone.mvc","Done")
                    /*$('#cooking').datagrid({
                    href:'/cooking/cookingDone.mvc?ID='+$('#cooking').datagrid('getSelected').kcOrdernumber,
                    },'load');*/
            }
        },'-',{
            text:'订单取消',
            iconCls:'icon-add',
            handler:function () {
                cooking("/cooking/orderCancellations.mvc","Cancellations")
            }
        },'-',{
            text:'订单处理',
            iconCls:'icon-add',
            handler:function () {
                cooking("/cooking/orderProcessing.mvc","Processing")
                /*alert('订单处理'),
                    $('#cooking').datagrid({
                         href: '/cooking/orderProcessing.mvc?ID=' + $('#cooking').datagrid('getSelected').kcOrdernumber,
                    });*/
            }
        },'-',{
            text:'订单详情',
            iconCls:'icon-add',
            handler:function () {
                alert('订单详情')

                if ($('#cooking').datagrid('getSelected') != null) {
                    $('#win').window({
                        text: '订单详情',
                        width: 900,
                        height: 600,
                        href: '/BaseController/path/kitchenInterface/cookingOrderDetails.mvc?ID=' + $('#cooking').datagrid('getSelected').kcOrdernumber,
                        async: false,
                        modal: true
                    });
                }else{
                    $.messager.show({
                        tetle:'提示',
                        msg:'请选择一个选项!'
                    });
                }
            }
        }],
        PageSize:5,
        pageList:[3,5,8,10,15],
        pagination:true,
        rownumbers:true,
        striped:true
    })
    function cooking(url,key) {
        if($('#cooking').datagrid('getSelected')!=null) {
            $.ajax({
                method: 'post',
                url:url,
                data: {
                    kcOrdernumber: $('#cooking').datagrid('getSelected').kcOrdernumber
                },
                beforeSend: function () {
                    $('#cooking').datagrid('loading');
                },
                success: function (data) {
                    if (data) {
                        $('#cooking').datagrid('loaded');
                        $('#cooking').datagrid('load');
                        $('#cooking').datagrid('unselectAll');
                        if(key=="Done") {
                            $.messager.show({
                                title: '提示',
                                msg: data+"条订单已完成!"
                            });
                        }else if(key=="Cancellations"){
                            $.messager.show({
                                title: '提示',
                                msg: data+"条订单已取消!"
                            });
                        }else if(key=="Processing"){
                            $.messager.show({
                                title: '提示',
                                msg: data+"条订单已处理!"
                            });
                        }
                    }
                }
            });
        }else {
            $.messager.show({
                title:'提示',
                msg:'请选择一个选项'
            })
        }
    }
</script>
</body>
</html>
