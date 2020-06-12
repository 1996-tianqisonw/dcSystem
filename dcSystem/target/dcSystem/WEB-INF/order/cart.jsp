<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/dcsystem/dcsystem.jsp" %>
<html>
<head>
    <title>Title</title>
</head>

<body>

<table id="dg"></table>
<div id="win"></div>

<script type="text/javascript">

    $('#dg').datagrid({
        url:'/goods/selectGoodsPage.mvc',
        columns:[[
            {checkbox:true},
            {field:'goodsTitle',title:'名称',width:100},
            {field:'goodsPrice',title:'价格',width:100},
            {field:'goodsImg',title:'图片',width:100,
                formatter:function(value, rec) {//使用formatter格式化刷子
                    return '<img src=' + value + '>';
                } },
            //{field:'goodsPrice',title:'价格',width:100},
        ]],
        fitColumns:true,

        toolbar: [{
            iconCls: 'icon-add',
            text:'添加商品',
            handler: function()
            {
                addGoods();
                //alert('添加商品')
            }
        }],

        striped:true,
        pagination:true,
        pageList:[5,10,15,20],
        pageSize:5,
    });

    //添加商品
    function addGoods() {

        var selRows = $("#dg").datagrid('getChecked');

        if(selRows.length==0)
        {
            alert("请选择要添加的商品");
        }

        var nameArr = new Array();

        $.each(selRows,function (index,item) {
            nameArr.push(item);
        });

        $.ajax({
            type:"post",
            url: "/busShopCart/addGoods.mvc",
            dataType:"json",
            data:{"params":JSON.stringify(nameArr)},
            success:function(data){
                //alert(data.msg);
                $.messager.alert("消息",data.msg);
                // console.log(data);
            }
        });
    }
    


</script>
</body>
</html>
