<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/common/common.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
</head>

<body>
<table>
    <tr>
        <%--<td>
            总公司：
        </td>
        <td>
            <select id="parentFactory" class="easyui-combobox" name="dept" style="width:160px;">
                <option value="aa">达润集团</option>
                <option value="bb">后梁集团</option>
            </select>
        </td>
        <td>
            店铺：
        </td>
        <td>
            <select id="sonFactory" class="easyui-combobox" name="dept" style="width:160px;">
                <option value="cc">达润测试公司</option>
                <option value="cc">后梁</option>
            </select>
        </td>--%>
        <td>
            选择开始日期：
        </td>
        <td>
            <input id="startDate" type="text" />
        </td>

        <td>
            选择结束日期：
        </td>
        <td>
            <input id="endDate" type="text"/>
        </td>
        <td>
           <%-- 链接按钮--%>
            <a id="searchDate"  class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="searchSta1()"></a>
        </td>
    </tr>
</table>
<table id="statementCount"></table>

<script type="text/javascript">
    $(function(){
        /*生成日历控件*/
        $("#startDate").datebox({"required":true});
        $("#endDate").datebox({"required":true});

        var myDate = new Date();
        var myDate2 =new Date();
        //昨天
        myDate.setDate(myDate.getDate()-2);
        myDate2.setDate(myDate2.getDate() - 1);
        //初始化时间
        $('#startDate').datebox('setValue',myformatter(myDate));
        $('#endDate').datebox('setValue',myformatter(myDate2));
        //获取当前时间
        alert($('#startDate').datebox('getValue'));
        alert($('#endDate').datebox('getValue'));

        /* var date1 = $('#startDate').datebox('getValue');
         var date2 = $('#endDate').datebox('getValue');*/
        //开始带参加载数据
        $('#dg').datagrid({	queryParams: {		name: 'easyui',		subject: 'datagrid'	}});
        $('#statementCount').datagrid({
            url:"/statement/data.mvc",
            queryParams: {
                /*shopId:"s001",*/
                startDate:$('#startDate').datebox('getValue'),
                endDate:$('#endDate').datebox('getValue')
            },
            fitColumns:true,/*使列自动展开/收缩列的宽度以适应网格的宽度，防止水平滚动*/
            columns:[[
                {field:'goodsName',title:'商品',width:100},
                {field:'totalMoney',title:'销售额（元）',width:100},
                {field:'returnMoney',title:'销售退款（元）',width:100},
                {field:'realMoney',title:'实际销售（元）',width:100},
                {field:'totalNum',title:'销售量',width:100},
                {field:'returnNum',title:'销售退货量',width:100},
                {field:'realNum',title:'实际销售量',width:100},
                {field:'countDate',title:'统计日期',width:100},
            ]],
            striped:true,/*隔行变色*/
            pagination:true,
            rownumbers:true,
        });
    })
    /*Jquery获取当前系统时间*/
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
        $('#statementCount').datagrid('load',{
            startDate:$('#startDate').datebox('getValue'),
            endDate:$('#endDate').datebox('getValue'),
            /*shopId:"s001",*/
        });
    }
</script>

</body>
</html>
