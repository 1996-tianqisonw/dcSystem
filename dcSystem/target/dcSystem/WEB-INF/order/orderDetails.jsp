<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/dcsystem/dcsystem.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<table id="dg2"></table>
<body>
    <script>
        $('#dg2').datagrid({
            url:'/busOrderDetails/selectBusOrderDetails.mvc',
            columns:[[
                {field:'goodsId',title:'商品编号',width:100},
                {field:'goodsTitle',title:'商品名称',width:100},
                {field:'goodsCount',title:'下单数量',width:100,},
                {field:'goodsProcess',title:'做菜情况',width:100,},
                {field:'goodsPrice',title:'商品单价(元)',width:100},
                {field:'goodsTotal',title:'总价(元)',width:100},
                {field:'goodsImgAddress',title:'图片',width:100,
                    formatter: function (value, rec) {//使用formatter格式化刷子
                        return '<img src=' + value + '>';
                    }},
            ]],
            fitColumns:true,
            singleSelect:true,
            striped:true,
            pagination:true,
            pageList:[5,10,15,20],
            pageSize:5,

        });

    </script>
</body>
</html>
