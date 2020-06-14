<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>layout!</title>
    <script src="easyui/locale/easyui-lang-zh_CN.js"></script>
</head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ include file="/common/common.jspf"%>

<script type="text/javascript">
    $(function () {

    });


</script>
<body>

<table id="dg"></table>
<div id="win"></div>
<script type="text/javascript">
    $(function () {
        $('#dg').datagrid({
            //url:'datagrid_data.json',//访问控制器datagrid_data.json
            url:'${proPath}/sysParam/selectPage.mvc',
            columns:[[
                {checkbox:true},
                {field:'sysParamId',title:'编号',width:100},
                {field:'sysParamField',title:'字段名称',width:100},
                {field:'sysParamValue',title:'参数值',width:100},
                {field:'sysParamText',title:'参数显示内容',width:100,align:'right'}
            ]],
            fitColumns:true,
            toolbar: [{
                iconCls: 'icon-add',
                text:'添加',
                handler: function(){
                    alert('添加按钮');
                    /*
                     1。弹出一个窗口，可以用来添加用户信息
                     */
                    $('#win').window({
                        width:600,
                        height:400,
                        modal:true,
                        minimizable:true,
                        maximizable:true,
                        title:'添加',
                        href:'user-add.html'
                    });
                }
            },'-',{
                iconCls: 'icon-edit',
                text:'修改',
                handler: function(){
                    alert('修改');
                }
            },'-',{
                iconCls: 'icon-remove',
                text:'删除',
                handler: function(){
                    alert('删除按钮');
                }
            }],
            striped:true,
            pagination:true,
            rownumbers:true,
            pageSize:15,
            pageList:[5,10,15,20,25],
            /* queryParams: {
             userStatus: 'P'
             }*/


        });

    });

    //定义搜索方法
    function search() {
        alert($('#sysParamId').val());
        $('#dg').datagrid('load',{
            sysParamId:$('#sysParamId').val(),
            sysParamField:$('#sysParamField').val()
        });


    }
</script>
</body>
</html>
