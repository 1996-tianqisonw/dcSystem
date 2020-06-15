<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ include file="/common/common.jspf" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>
            选择开始日期：
        </td>
        <br/>
        <td>
            <input id="startDate1" type="text" />
        </td>
        <td>
            <a id="searchDate1"  class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="searchSta1()"></a>
        </td>
    </tr>
    <tr>
        <td>
            <a id="searchDate2"  class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="searchSta1()">查询日志</a>
        </td>
        <td>
            <a id="searchDate3"  class="easyui-linkbutton" data-options="iconCls:'icon-reload'" onclick="searchSta1()">指定日期更新</a>
        </td>
    </tr>
</table>
<table id="statementCount1"></table>

<script type="text/javascript">
    $(function(){
        $("#startDate1").datebox({"required":true});
        var myDate = new Date();
        //昨天
        myDate.setDate(myDate.getDate()-2);
        $('#startDate1').datebox('setValue',myformatter(myDate));
        alert($('#startDate1').datebox('getValue'));

        $('#dg1').datagrid({	queryParams: {		name: 'easyui',		subject: 'datagrid'	}});
        $('#statementCount1').datagrid({
            url:"${proPath}/sysLog/logData.mvc",
            queryParams: {
                startDate:$('#startDate1').datebox('getValue'),
            },
            fitColumns:true,
            columns:[[
                {field:'logContent',title:'抽取状况',width:100},
                {field:'countDate',title:'抽取日期',width:100},
                {field:'operTime',title:'抽取时间',width:100},
                {field:'dateTime',title:'所属日期',width:100},
                {field:'operStatus',title:'操作条数',width:100},
            ]],
         /*   toolbar: [{
                iconCls: 'icon-search',
                text: '查询日志',
                handler: showLog
            }, {
                iconCls: 'icon-reload',
                text: '指定日期更新',
                handler: sh

            }],*/
            striped:true,
            pagination:true,
            rownumbers:true,
        });
    })
    function myformatter(date){
        var y = date.getFullYear();
        var m = date.getMonth()+1;
        var d = date.getDate();
        return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
    };

    function myparser(s){
        if (!s) return new Date();
        var ss = (s.split('-'));
        var y = parseInt(ss[0],10);
        var m = parseInt(ss[1],10);
        var d = parseInt(ss[2],10);
        if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
            return new Date(y,m-1,d);
        } else {
            return new Date();
        }
    };

    function searchSta1() {
        $('#statementCount1').datagrid('load',{
            startDate:$('#startDate1').datebox('getValue'),
        });
    }
</script>

</body>
</html>
