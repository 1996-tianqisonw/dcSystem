<%--
  Created by IntelliJ IDEA.
  User: 86173
  Date: 2020/5/29
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../common/common.jspf"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div><table id="dg" style="width:300px;height:200px;"></table></div>
<div>
    <a href="#" onclick="show()"  class="easyui-linkbutton" data-options="iconCls:'icon-ok'">保存</a></br>
    <a href="#" onclick="show1()"  class="easyui-linkbutton" data-options="iconCls:'icon-ok'">删除</a>
</div>
<div><table id="dlg" style="width:300px;height:200px;"></table></div>
</body>
<script type="text/javascript">
    var win;
    var arr;
    $(function () {
        win = parent.$("iframe[title='角色管理']").get(0).contentWindow;;
        arr =win.$("#dg").datagrid("getSelections");
        $("#dg").treegrid({
            url: '${proPath}/RoleController/selectusers.mvc',
            animate:true,
            singleSelect:false,
            idField: 'userId',            //定义关键字段来标识树节点。也就是数据的id
            treeField: 'userName',        //定义树形显示字段
            columns: [[                //定义表格头名称
                {
                    title: '员工列表',
                    field: 'userName',
                    width: 180,
                }
            ]]
        });
        $("#dlg").treegrid({
            url: '${proPath}/RoleController/selectRoleusers.mvc',
            queryParams:{roleId: arr[0].roleId},
            animate:true,
            singleSelect:false,
            idField: 'userId',            //定义关键字段来标识树节点。也就是数据的id
            treeField: 'userName',        //定义树形显示字段
            columns: [[                //定义表格头名称
                {
                    title: '员工列表',
                    field: 'userName',
                    width: 180,
                }
            ]]
        })
    });

    /*$(function () {
    });*/

    function show() {
        var array =$("#dg").treegrid("getSelections");
        if (array.length > 0) {
            var ids = new Array();
            for (i = 0; i < array.length; i++) {
                ids[i] = array[i].userId;
            }
            $.ajax({
                type: "post",
                url:"${proPath}/RoleController/insertRoleusers.mvc",
                traditional:true,
                data: {pks:ids,roleId:arr[0].roleId},
                dataType:'json',
                success:function (msg) {
                    if (msg>0) {
                        $('#dlg').treegrid('reload');
                        /*win.$('#dg').datagrid('reload');*/
                    } else {
                        $.messager.show({
                            title: '操作提示',
                            msg: '操作失败',
                            timeout: 2000,
                            showType: 'slide'
                        });
                    }
                }
            });
        }else {
            $.messager.show({
            title: '操作提示',
            msg: '请至少选择一条。',
            timeout: 2000,
            showType: 'slide'
        });
        }
    }
    function show1() {
        var array =$("#dlg").treegrid("getSelections");
        if (array.length > 0) {
            var ids = new Array();
            for (i = 0; i < array.length; i++) {
                ids[i] = array[i].userId;
            }
            $.ajax({
                type: "post",
                url:"${proPath}/RoleController/deleteRoleusers.mvc",
                traditional:true,
                data: {roleId: arr[0].roleId,pks: ids},
                dataType:'json',
                success:function (msg) {
                    if (msg>0) {
                        alert(msg);
                        $("#dlg").treegrid("clearSelections");
                        /*$('#dlg').treegrid('reload');*/
                    } else {
                        $.messager.show({
                            title: '操作提示',
                            msg: '操作失败',
                            timeout: 2000,
                            showType: 'slide'
                        });
                    }
                }
            });
        }else {
            $.messager.show({
                title: '操作提示',
                msg: '请至少选择一条。',
                timeout: 4000,
                showType: 'slide'
            });
        }
    }
</script>
</html>
