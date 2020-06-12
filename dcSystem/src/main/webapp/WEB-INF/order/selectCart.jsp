<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/dcsystem/dcsystem.jsp" %>
<html>
<head>
    <title>Title</title>
</head>

<body>
<table id="selectGoods"></table>

<div id="div1" style="display: none">
<form id="ff" method="post"  >
    <label for="whetherPay">是否付款:</label>
    <select id="whetherPay1" class="easyui-combobox" name="whetherPay" style="width:200px;">
        <c:forEach items="${applicationScope.sysParam.whether_pay}" var="t">
            <option value="${t.value}">
                    ${t.value}
            </option>
        </c:forEach>
    </select></br>
    <label for="payWay">选择付款方式:</label>
    <select id="payWay1" class="easyui-combobox" name="payWay" style="width:200px;">
        <c:forEach items="${applicationScope.sysParam.pay_way}" var="w">
            <option value="${w.value}">
                    ${w.value}
            </option>
        </c:forEach>
    </select></br>
    <label for="goodsProcess">做菜情况:</label>
    <select id="goodsProcess1" class="easyui-combobox" name="goodsProcess" style="width:200px;">
        <c:forEach items="${applicationScope.sysParam.goods_process}" var="o">
            <option value="${o.value}">
                    ${o.value}
            </option>
        </c:forEach>
    </select></br>
    <label for="orderStatus">订单状态:</label>
    <select id="orderStatus1" class="easyui-combobox" name="orderStatus" style="width:200px;">
        <c:forEach items="${applicationScope.sysParam.order_status}" var="o1">
            <option value="${o1.value}">
                    ${o1.value}
            </option>
        </c:forEach>
    </select></br>
    <label for="dcId">餐桌号:</label>
    <select id="dcId1" class="easyui-combobox" name="currentDiningId" style="width:200px;">
        <c:forEach items="${applicationScope.sysParam.current_dining_id}" var="d">
            <option value="${d.value}">
                    ${d.value}
            </option>
        </c:forEach>
    </select></br>
    <input type="button" id="bt3" value="提交"/>
</form>
</div>
<script type="text/javascript">

        $('#selectGoods').datagrid({

            url: '/busShopCart/selectGoods.mvc',
            columns: [[

                {field:'goodsNo',title:'选择',width:200,checkbox:true},
                {field: 'goodsTitle', title: '名称', width: 100},
                {field: 'goodsPrice', title: '价格', width: 100},
                {
                    field: 'goodsImg', title: '图片', width: 100,
                    formatter: function (value, rec) {//使用formatter格式化刷子
                        return '<img src=' + value + '>';
                    }
                },
            ]],

            fitColumns: true,
            striped: true,
            pagination: true,
            pageList: [5, 10, 15, 20],
            pageSize: 5,

            toolbar: [{
                iconCls: 'icon-edit',
                text: '刷新商品',
                handler: function () {
                    shuaxin();
                    //alert('刷新商品')
                }
            }, '-', {
                iconCls: 'icon-remove',
                text: '删除商品',
                handler: function () {
                    removeTask();
                    //alert('删除商品')
                }
            }, '-', {
                iconCls: 'icon-remove',
                text: '提交订单',
                handler: function () {
                    //alert('提交订单');

                    $("#div1").show();

                       $('#div1').window({
                            title:"提交订单窗口",
                            width:500,
                            height:500,
                            modal:true,
                            minimizable:false,
                            maximizable:false,
                            closable:true,
                            draggable:false,
                            resizable:true,
                        });

                    $("#bt3").click(
                        function(){
                            //alert(123321)
                            var whetherPayVal = $("[name=whetherPay]").val();
                            var payWayVal = $("[name=payWay]").val();
                            var goodsProcessVal = $("[name=goodsProcess]").val();
                            var orderStatusVa1 = $("[name=orderStatus]").val();
                            var currentDiningIdVa1 = $("[name=currentDiningId]").val();

                            $.post(
                                "/busOrder/insertOrder.mvc",
                                {"whetherPay":whetherPayVal,"payWay":payWayVal,"orderType":goodsProcessVal,"orderStatus":orderStatusVa1,"currentDiningId":currentDiningIdVa1},
                                function(json){
                                    alert(json.msg);
                                    if(json.msg!=null)
                                    {
                                        window.location.reload();

                                    }
                                },
                               "json"
                            );
                        }
                    );

                }

            }],
        });


    /**删除商品*/
    function removeTask(){
        var ids = "";
        var datas = $('#selectGoods').datagrid('getSelections');

        if(datas.length == 0){
            $.messager.alert('信息提示','请选择要删除的记录!');
        }else{

            for(var i =0;i<datas.length;i++) {
                var data = datas[i];
                ids += data.goodsNo+ ",";
                var index = $('#selectGoods').datagrid('getRowIndex',data);
                $('#selectGoods').datagrid('deleteRow', index);

            }
           // $('#selectGoods').datagrid('reload');
            $('#selectGoods').datagrid('clearSelections');
            //alert("ids 12312 = "+ids)
           // $.messager.confirm('删除提示', '您确定要删除选中的记录吗?', function(r){
               // if (r){
            $.post(
                "/busShopCart/deleteGoods.mvc",{ids:ids}

            )
                        .success(
                            function() {
                                $.messager.show({title:'操作提示',msg:'删除成功！',showType:'show'});
                               // $('#selectGoods').datagrid('reload');
                                $('#selectGoods').datagrid('clearSelections');
                            }
                        ).error(
                        function() {
                            $.messager.show({title:'操作提示',msg:'删除失败！',showType:'show'});
                            //$('#selectGoods').datagrid('reload');
                            $('#selectGoods').datagrid('clearSelections');
                        }
                    );
        }
    }

    /*刷新商品*/
    function shuaxin() {
        $('#selectGoods').datagrid('reload');
        $('#selectGoods').datagrid('clearSelections'); // 一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
    }

</script>

</body>
</html>
