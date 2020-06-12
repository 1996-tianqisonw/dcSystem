<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/dcsystem/dcsystem.jsp" %>
<html>
<head>
    <script type="text/javascript">
        function show(t,url){

            if($("#tt").tabs('exists',t))
            {
                $("#tt").tabs('select',t);

            }else{
                $("#tt").tabs('add',{
                    title:t,
                    href:url,
                    closable:true,
                    selected:true
                })
            }
        }

    </script>
</head>
<body>
<div id="cc" class="easyui-layout" data-options="fit:true" style="width:600px;height:400px;">
    <div data-options="region:'north',title:'订单管理界面',split:true" style="height:100px;"></div>
    <div data-options="region:'south',title:'版权声明',split:true" style="height:100px;"></div>
    <div data-options="region:'east',iconCls:'icon-reload',title:'新闻公告',split:true" style="width:180px;"></div>
    <div data-options="region:'west',title:'导航菜单',split:true" style="width:180px;">
        <div id="aa" class="easyui-accordion" data-options="fit:true" style="width:300px;height:200px;">
            <div title="购物车管理" data-options="iconCls:'icon-save'" style="overflow:auto;padding:10px;">
                <a id="btn1" onclick="show('购物车','${proPath}/BaseController/goURL/order/cart.mvc')" class="easyui-linkbutton" data-options="iconCls:'icon-search'">购物车</a>
                <a id="btn4" onclick="show('查询购物车','${proPath}/BaseController/goURL/order/selectCart.mvc')" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询购物车</a>

            </div>
            <div title="消费管理" data-options="iconCls:'icon-reload'" style="padding:10px;">
                <a id="btn2" onclick="show('订单管理','${proPath}/BaseController/goURL/order/order.mvc')" class="easyui-linkbutton" data-options="iconCls:'icon-search'">下订单</a>
                <a id="btn3" onclick="show('退单管理','${proPath}/BaseController/goURL/order/refund.mvc')" class="easyui-linkbutton" data-options="iconCls:'icon-search'">退订单</a>
            </div>
            <div title="其他需求" data-options="iconCls:'icon-reload'">
                content3
            </div>
        </div>
    </div>
    <div data-options="region:'center',title:'主要内容'" style="padding:5px;">
        <div id="tt" class="easyui-tabs" data-options="fit:true" style="width:500px;height:250px;">
            <div title="介绍" style="padding:20px;">
                说明:
            </div>
        </div>
    </div>
</div>
</body>
</html>
