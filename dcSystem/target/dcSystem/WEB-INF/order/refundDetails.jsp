<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/dcsystem/dcsystem.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table id="dg8"></table>
<script>
    $('#dg8').datagrid({
        url:'/busRefundDetails/selectBusRefundDetails.mvc',
        columns:[[
            {field:'goodsName',title:'商品名称',width:100},
            {field:'goodsCount',title:'商品数量',width:100},
            {field:'refundMoney',title:'商品价格',width:100},
            {field:'goodsImgAddress',title:'商品图片',width:100,
                formatter: function (value, rec) {//使用formatter格式化刷子
                    return '<img src=' + value + '>';
                },
            },
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
