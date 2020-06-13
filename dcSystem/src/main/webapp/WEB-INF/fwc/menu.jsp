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
    <title>Title</title>
</head>
<body>
<table id="box" style="width:1200px;height:550px;"></table>
<div id="win"></div>
</body>
<script type="text/javascript">
    $(function () {
        $('#box').treegrid({
            url: '${proPath}/MenuController/selectMenu.mvc',
            animate:true,
            idField: 'menuId',            //定义关键字段来标识树节点。也就是数据的id
            treeField: 'menuName',        //定义树形显示字段
            columns: [[                //定义表格头名称
                {checkbox:true},
                {
                    title: '菜单名称',
                    field: 'menuName',
                    width: 180,
                },
                {
                    title: 'url',
                    field: 'url',
                    width: 180,
                },
                {
                    title: '权限编码',
                    field: 'permissions',
                    width: 180,
                },
                {
                    title: '父类',
                    field: 'orgId',
                    width: 180,
                },
                {
                    title: '类型',
                    field: 'type',
                    width: 180,
                },
                {
                    title: '状态',
                    field: 'staste',
                    width: 180,
                },
                {
                    title: '排序',
                    field: 'sorting',
                    width: 180,
                }
            ]],
            toolbar: [{
                iconCls : 'icon-add',
                text : '新增',
                handler : function() {
                    parent.$('#win').window({
                        width:600,
                        height:400,
                        modal:true,
                        content: "<iframe src='${proPath}/pageController/goURL/fwc/menuinsert.mvc' height='100%' width='100%' frameborder='0px' ></iframe>"
                    });
                }
                },'-', {
                    iconCls : 'icon-add',
                    text : '新增子菜单子按钮',
                    handler : function() {
                        var array = $("#box").datagrid("getSelections");
                        if(array.length==1){
                        parent.$('#win').window({
                            width:600,
                            height:400,
                            modal:true,
                            content: "<iframe src='${proPath}/pageController/goURL/fwc/menuinserts.mvc' height='100%' width='100%' frameborder='0px' ></iframe>"
                        });
                    }else{
                            $.messager.show({
                                title : '操作提示',
                                msg : '请只选择一条菜单。',
                                timeout : 4000,
                                showType : 'slide'
                            });

                        }

                    }
                },'-',{
                iconCls : 'icon-edit',
                text : '修改',
                handler : function() {
                    var array = $("#box").datagrid("getSelections");
                    if(array.length==1){
                        parent.$('#win').window({
                            title:'修改页面',
                            width:600,
                            height:400,
                            modal:true,
                            content: "<iframe src='${proPath}/pageController/goURL/fwc/menuupdate.mvc' height='100%' width='100%' frameborder='0px' ></iframe>"
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
                    var array = $("#box").treegrid("getSelections");
                    if (array.length > 0) {
                        var pks = new Array();
                        for (i = 0; i < array.length; i++) {
                            pks[i] = array[i].menuId;
                        }
                        parent.$.messager.confirm('删除对话框', '您确认要删除吗？', function(r) {
                            if (r) {
                                $.ajax({
                                    url: "${proPath}/MenuController/deleteMenu.mvc",
                                    type:"POST",
                                    //设置为传统方式传送参数
                                    traditional:true,
                                    data:{pks:pks},
                                    dataType:'json',
                                    success: function(msg){
                                        if(msg>0){
                                            alert("恭喜您，删除成功，共删除了"+msg+"条记录！");
                                            $("#box").treegrid("reload");
                                        }else{
                                            alert("对不起，删除失败！");
                                        }
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
        });
    });
</script>
</html>
