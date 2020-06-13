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
    <title>角色管理</title>
</head>
<body>
<table id="dg"></table>
<div id="win"></div>
<script type="text/javascript">
    $('#dg').datagrid({
        url:'${proPath}/RoleController/selectRole.mvc',
        columns:[[
            {checkbox:true},
            {field:'roleId',title:'编号',width:20},
            {field:'roleName',title:'名字',width:20},
            {field:'state',title:'状态',width:20},
            {field:'time',title:'时间',width:20,align:'right'}
        ]] ,
        fitColumns:true,
        toolbar: [{
            iconCls : 'icon-add',
            text : '新增',
            handler : function() {
                alert('添加按钮');
                parent.$('#win').window({
                    title: '新增页面',
                    width: 600,
                    height: 400,
                    modal: true,
                    content: "<iframe src='${proPath}/pageController/goURL/fwc/roleinsert.mvc' height='100%' width='100%' frameborder='0px' ></iframe>"
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
                            content:"<iframe src='${proPath}/pageController/goURL/fwc/roleupdate.mvc' height='100%' width='100%' frameborder='0px' ></iframe>"
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
            iconCls : 'icon-save',
            text : '设置权限',
            handler : function() {
                var array = $("#dg").datagrid("getSelections");
                if (array.length==1){
                    if (array[0].state=='可用'){
                        parent.$('#win').window({
                            title:'添加权限',
                            width:600,
                            height:400,
                            content:"<iframe src='${proPath}/pageController/goURL/fwc/rolemenu.mvc' height='100%' width='100%' frameborder='0px' ></iframe>"
                        });
                    }else {
                        $.messager.show({
                            title : '操作提示',
                            msg : '当前角色不可用',
                            timeout : 4000,
                            showType : 'slide'
                        });
                    }
                }else {
                    $.messager.show({
                        title : '操作提示',
                        msg : '请只选择一条需要修改的记录。',
                        timeout : 4000,
                        showType : 'slide'
                    });
                }
            }
        },'-',{
            iconCls : 'icon-add',
            text : '设置员工',
            handler : function() {
                var array = $("#dg").datagrid("getSelections");
                if (array.length==1){
                    if (array[0].state=='可用'){
                        parent.$('#win').window({
                            title:'添加员工',
                            width:600,
                            height:400,
                            content:"<iframe src='${proPath}/pageController/goURL/fwc/roleusers.mvc' height='100%' width='100%' frameborder='0px' ></iframe>"
                        });
                    }else {
                        $.messager.show({
                            title : '操作提示',
                            msg : '当前角色不可用',
                            timeout : 4000,
                            showType : 'slide'
                        });
                    }
                }else {
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
                        ids[i] = array[i].roleId;
                    }
                    parent.$.messager.confirm('删除对话框', '您确认要删除吗？', function(r) {
                        if (r) {
                            $.ajax({
                                url: "${proPath}/RoleController/deleteRole.mvc",
                                type:"POST",
                                //设置为传统方式传送参数
                                traditional:true,
                                data:{pks:ids},
                                dataType:'json',
                                success: function(msg){
                                    if(msg>0){
                                        alert("恭喜您，删除成功，共删除了"+msg+"条记录！");
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
                                dataType:'json'
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
</script>
</body>
</html>
