<%--
  Created by IntelliJ IDEA.
  User: 86173
  Date: 2020/5/29
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../common/common.jspf"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table id="Tree" style="width:800px;height:300px;"></table>
<a id="bt" href="#" onclick="show()"  class="easyui-linkbutton" data-options="iconCls:'icon-ok'">保存</a>
</body>
<script type="text/javascript">
    var win;
    var arr;
    $(function () {
        win = parent.$("iframe[title='角色管理']").get(0).contentWindow;
        arr =win.$("#dg").datagrid("getSelections");
        $('#Tree').treegrid({
            url: '${proPath}/RoleController/selectRoleMenu.mvc',
            queryParams:{roleId:arr[0].roleId},
            animate:true,
            singleSelect:false,
            idField: 'menuId',            //定义关键字段来标识树节点。也就是数据的id
            treeField: 'menuName',      //定义树形显示字段
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
        });
    });
    function show() {
        var array = $("#Tree").treegrid("getSelections");
        if (array.length > 0) {
            var ids = new Array();
            for (i = 0; i < array.length; i++) {
                ids[i] = array[i].menuId;
            }
            $.ajax({
                url: "${proPath}/RoleController/insertRoleMenu.mvc",
                type:"POST",
                //设置为传统方式传送参数
                traditional:true,
                data:{pks:ids,roleId:arr[0].roleId},
                dataType:'json',
                success: function(msg){
                    if(msg>0){
                        alert("恭喜您，操作成功，共保存了"+msg+"条记录！");
                    }else{
                        alert("对不起，操作失败！");
                    }
                    //请除所有勾选的行
                    win.$("#dg").datagrid("clearSelections");
                    win.$('#win').dialog('close');
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    $.messager.alert('保存错误','请联系管理员！','error');
                },
            });
        }
    }
</script>
</html>
