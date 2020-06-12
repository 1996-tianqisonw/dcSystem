<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/dcsystem/dcsystem.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table id="dg7"></table>
<div id="div7"></div>

<script type="text/javascript">
    $('#dg7').datagrid({
        url:'/busRefund/selectRefundPage.mvc',
        columns:[[
            {checkbox:true},
            {field:'currentDiningId',title:'餐桌编号',width:100},
            {field:'currentDiningName',title:'餐桌名称',width:100},
            {field:'originalOrderId',title:'原订单号',width:100,},
            {field:'refundOrderId',title:'退款单号',width:100},
            {field:'refundStatus',title:'退款状态',width:100},
            {field:'refundMoney',title:'退款金额',width:100},
            {field:'payWay',title:'付款方式',width:100,},
            {field:'refundTime',title:'退款时间',width:100,
                formatter: function (value) {
                    return formatDateTime(value);
                }},
            {field:'auditStatus',title:'审核状态',width:100},
        ]],
        fitColumns:true,
        singleSelect:true,
        striped:true,
        pagination:true,
        pageList:[5,10,15,20],
        pageSize:5,

        toolbar: [{
            iconCls: 'icon-remove',
            text: '查看和审核',
            handler: function () {
                getRefundId();
                window3();
            }
        }],
    });

    function window3() {
        $("#div7").window({
            title: "订单明细",
            width: 800,
            height: 500,
            modal: true,
            minimizable: false,
            maximizable: false,
            closable: true,
            draggable: false,
            resizable: true,

            content:"<iframe src='/BaseController/goURL/order/refundDetails.mvc' height='100%' width='100%' frameborder='0px'></iframe>",
        })
        $("#div7").window('open');
        $("#div7").window('refresh');
    };

    function getRefundId() {
        var data = $('#dg7').datagrid('getSelected');
        var refundIdValue1 = data.originalOrderId;
        //alert("orderIdValue = "+refundIdValue1);
        $('#dg7').datagrid('clearSelections');

        $.post(
            "/busRefundDetails/refundId.mvc",{refundIdValue1:refundIdValue1}
        )
    }

</script>
</body>
</html>
