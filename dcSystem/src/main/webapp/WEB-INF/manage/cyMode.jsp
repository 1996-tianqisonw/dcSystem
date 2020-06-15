<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ include file="/common/common.jspf" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table id="dg1"></table>
<script type="text/javascript">
    function doOk() {
        //获取表格中的数据
        var row = $('#dg1').datagrid('getSelected');
        if(row==null){
            alert("请选择一项!")
            return false;
        }
        if (row.sysParamType=='是') {
            alert("当前模式已启用");
            return false;
        }
        $.post(
            "${proPath}/sysParam/updateAppo.mvc",
            {sysParamValue:row.sysParamValue,sysParamType:row.sysParamType},
            function(json){
                alert(json.msg);
                $('#dg1').datagrid("reload");
                //清楚表格中数据缓存
                $('#dg1').datagrid("clearSelections");
            },
            "json"
        );
        // commonGrid.getOpenSelectedRow("#dg", '/dc-manager/rest/sysParam/enableByPks');
    }
    $(function () {
        $('#dg1').datagrid({
            url:'${proPath}/sysParam/selectAppo.mvc',
            singleSelect:true,
            columns:[[
                {checkbox:true},
                {field:'sysParamValue',title:'流程编号',width:100},
                {field:'sysParamText',title:'支付流程',width:100},
                {field:'sysParamType',title:'启用',width:100,align:'right'
                    /*formatter: function (value, row, index) {
                     if (value=='是'){
                     return value='是';
                     }else if(value=='否'){
                     return value='否';
                     }else {
                     return value='异常';
                     }
                     }*/
                }
            ]],
            fitColumns:true,
            toolbar:[{
                iconCls: 'icon-ok',
                text: '启用',
                handler: doOk
            }],
            //nowrap:false,
            pagination:true,
            rownumbers:true,
            pageSize:5,
            pageList:[5,10,15,20,25],
            /* queryParams: {
             userName: '1'
             }
             */
            /* rowStyler: function(index,row){
             if (row.unitcost>80){
             return 'background-color:#6293BB;color:#fff;';
             }
             }, */

            striped:true

        });
    })
</script>
</body>
</html>