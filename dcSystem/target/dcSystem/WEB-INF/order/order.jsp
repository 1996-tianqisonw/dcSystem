<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/dcsystem/dcsystem.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form id="ff" method="post">
        <label for="currentDiningId">餐桌编号:</label>
        <input class="easyui-validatebox" type="text" name="currentDiningId"   />


        <label for="currentDiningName">餐桌名称:</label>
        <input class="easyui-validatebox" type="text" name="currentDiningName"   /></br>


        <label for="orderId">订单号:</label>
        <input class="easyui-validatebox" type="text" name="orderId"   />


        <label for="whetherPay">是否付款:</label>
        <select name="whetherPay" class="easyui-combobox" name="whetherPay" style="width:200px;">
                <option value="已付款">
                        已付款
                </option>
                <option value="未付款">
                        未付款
                </option>
                 <option value="">
                        不选择
                 </option>
        </select>
    <input type="button" onclick="queryUser()" value="查询">
</form>

<div id="div2" style="display: none">
    <form id="fff" method="post"  >
        <label for="refundStatus">退款状态:</label>
        <select id="refundStatus1" class="easyui-combobox" name="refundStatus" style="width:200px;">
            <c:forEach items="${applicationScope.sysParam.refund_status}" var="t">
                <option value="${t.value}">
                        ${t.value}
                </option>
            </c:forEach>
        </select></br>
        <label for="auditStatus">审核状态:</label>
        <select id="auditStatus1" class="easyui-combobox" name="auditStatus" style="width:200px;">
            <c:forEach items="${applicationScope.sysParam.audit_status}" var="w">
                <option value="${w.value}">
                        ${w.value}
                </option>
            </c:forEach>
        </select></br>
        <input type="button" id="bt5" value="提交"/>
    </form>
</div>

<table id="dg1"></table>
<div id="div1"></div>

<script type="text/javascript">

    function queryUser() {
        if($("[name=currentDiningId]").val()!="")
        {
            $("#dg1").datagrid("load",{
                currentDiningId:$("[name=currentDiningId]").val(),

            });
        }else if ($("[name=currentDiningId]").val()==""){
            $("#dg1").datagrid("load",{
                currentDiningId:$("[name=currentDiningId]").val(),

            })
        }

        if($("[name=currentDiningName]").val()!="")
        {
            $("#dg1").datagrid("load",{
                currentDiningName:$("[name=currentDiningName]").val(),
            });
        }else if ($("[name=currentDiningName]").val()==""){
            $("#dg1").datagrid("load",{
                currentDiningId:$("[name=currentDiningName]").val(),

            })
        }

        if($("[name=orderId]").val()!="")
        {
            $("#dg1").datagrid("load",{
                orderId:$("[name=orderId]").val(),

            });
        }
        if($("[name=whetherPay]").val()!="")
        {
            $("#dg1").datagrid("load",{
                whetherPay:$("[name=whetherPay]").val(),
            });
        }
    }

    $('#dg1').datagrid({
        url:'/busOrder/selectOrderPage.mvc',
        columns:[[
            {checkbox:true},
            {field:'currentDiningId',title:'餐桌编号',width:100},
            {field:'currentDiningName',title:'餐桌名称',width:100},
            {field:'orderId',title:'订单编号',width:100,},
            {field:'orderTotal',title:'订单金额',width:100},
            {field:'payMoney',title:'应付金额',width:100},
            {field:'whetherPay',title:'是否付款',width:100},
            {field:'payWay',title:'付款方式',width:100,},
            //{field:'orderType',title:'订单类型',width:100,},
            {field:'orderStatus',title:'订单状态',width:100},
            {field:'creationTime',title:'下单时间',width:100,
                formatter: function (value) {
                    return formatDateTime(value);
                }},
            {field: 'endTime', title: '支付时间', width: 100,
                formatter: function (value) {
                    return formatDateTime(value);
                }},
        ]],
        fitColumns:true,
        singleSelect:true,
        striped:true,
        pagination:true,
        pageList:[5,10,15,20],
        pageSize:5,

        toolbar: [{
            iconCls: 'icon-add',
            text:'订单明细',
            handler: function()
            {
                //alert('订单明细');
                getOrderId();
                window1();
            }
        }, '-', {
            iconCls: 'icon-remove',
            text: '申请退款',
            handler: function () {
                //alert('申请退款')
                //getRefundOrderId();

                $("#div2").show();

                $('#div2').window({
                    title:"申请退款",
                    width:500,
                    height:500,
                    modal:true,
                    minimizable:false,
                    maximizable:false,
                    closable:true,
                    draggable:false,
                    resizable:true,
                });

                $("#bt5").click(
                    function(){
                        var refundStatusVal = $("[name=refundStatus]").val();
                        var auditStatusVal = $("[name=auditStatus]").val();
                        var data = $('#dg1').datagrid('getSelected');

                        if(data.length == 0){
                            $.messager.alert('信息提示','请选择要申请的记录!');
                        }

                        var orderIdValue = data.orderId;
                        $('#dg1').datagrid('clearSelections');

                        $.post(
                            "/busRefund/addRefund.mvc",
                            {"refundStatus":refundStatusVal,"auditStatus":auditStatusVal,"orderId":orderIdValue},
                            function(json){
                                alert(json.msg);
                            },
                            "json"
                        );
                    }
                );
            }
        }],
    });

    function window1() {
        $("#div1").window({
            title: "订单明细",
            width: 800,
            height: 500,
            modal: true,
            minimizable: false,
            maximizable: false,
            closable: true,
            draggable: false,
            resizable: true,

            content:"<iframe src='/BaseController/goURL/order/orderDetails.mvc' height='100%' width='100%' frameborder='0px'></iframe>",
        })
        $("#div1").window('open');
        $("#div1").window('refresh');
    };
    
    function getOrderId() {
        var data = $('#dg1').datagrid('getSelected');
        var orderIdValue = data.orderId;
        //alert("orderIdValue = "+orderIdValue);
        $('#dg1').datagrid('clearSelections');

        $.post(
            "/busOrderDetails/orderId.mvc",{orderIdValue1:orderIdValue}
        )
    }

    //转换日期格式
     function formatDateTime(timeStamp) {
        if(timeStamp==null){
            return '';
        }
        var date = new Date(timeStamp);
        var y = date.getFullYear();
        var m = date.getMonth() + 1;
        m = m < 10 ? ('0' + m) : m;
        var d = date.getDate();
        d = d < 10 ? ('0' + d) : d;
        var h = date.getHours();
        h = h < 10 ? ('0' + h) : h;
        var minute = date.getMinutes();
        var second = date.getSeconds();
        minute = minute < 10 ? ('0' + minute) : minute;
        second = second < 10 ? ('0' + second) : second;
        return y + '-' + m + '-' + d+' '+h+':'+minute+':'+second;
    };


</script>
</body>
</html>
