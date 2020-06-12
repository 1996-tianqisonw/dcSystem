<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="dcsystem/dcsystem.jsp" %>

<html>
<head>
    <title>神兽系统</title>
    <script type="text/javascript">
        function show(dete, url) {
            if ($('#tt').tabs('exists', dete)) {
                $('#tt').tabs('select', dete)
            } else {
                $('#tt').tabs('add', {
                    title: dete,
                    //content:'Tab Body',
                    href: url,
                    closable: true,
                    tools: [{
                        iconCls: 'icon-mini-refresh',
                        handler: function () {
                            alert('refresh');
                        }
                    }]
                });
            }
        }
    </script>
    <style type="text/css">
        li{
            list-style:none;
            margin-left:1px;
            font-size:20px;
        /*#sd{
            font-size: 20px;
            color: red;
            border-color: aqua;
        }*/
        li {
            list-style: none;
            margin-left: 1px;
            font-size: 20px;
        }
    </style>
</head>
<body>
<div id="cc" class="easyui-layout" style="width:100%;height:100%;">
    <div data-options="region:'north',title:'餐厅管理系统',split:true" style="height:100px;">
        <%--<div id="sd">${requestScope.login}</div>--%>
    </div>
    <div data-options="region:'south',title:'软件注释',split:true" style="height:100px;"></div>
    <div data-options="region:'west',title:'导航菜单',split:true" style="width:250px;">
        <div id="aa" class="easyui-accordion" data-options="fit:true">
            <div title="餐桌管理" data-options="iconCls:'icon-save',fit:true,selected:true"
                 style="overflow:auto;padding:10px;">
                <ul>
                    <li><a id="btn1" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
                           onclick="show('餐桌信息管理','/BaseController/path/table/tableManagement.mvc?ID=0')">餐桌信息管理</a>
                    </li>
                    <li><a id="btn2" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
                           onclick="show('餐桌状态管理','/BaseController/path/tableState/tableStateManagement.mvc?ID=0')">餐桌状态管理</a>
                    </li>
                </ul>
            </div>
            <div title="后厨管理" data-options="iconCls:'icon-reload',fit:true" style="padding:10px;">
                <ul>
                    <li><a id="petsAdd" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
                           onclick="show('后厨管理','/BaseController/path/kitchenInterface/cookingManagement.mvc?ID=0')">后厨管理</a>
                    </li>
                </ul>
            </div>
            <div title="商品管理" data-options="iconCls:'icon-reload'" style="padding:10px;">
                <a id="btn11" href="#" onclick="show('商品管理','goods.jsp');" class="easyui-linkbutton">商品信息管理</a>
                <a id="btn12" href="#" onclick="show('商品菜单管理','goodsmenu.jsp');" class="easyui-linkbutton">商品菜单管理</a>
            </div>
            <div title="呼叫与排队" data-options="iconCls:'icon-reload'" style="padding:10px;margin-left:10px;">
                <a id="btn31" href="#" onclick="show('呼叫服务','${proPath}/BaseController/findUrl/call_queuing/cus_call.mvc');" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="margin-top: 10px;">呼叫服务</a>
                <a id="btn32" href="#" onclick="show('店铺排队启用','/BaseController/findUrl/call_queuing/wait_on-off.mvc');" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="margin-top: 10px;">店铺排队启用</a>
                <a id="btn33" href="#" onclick="show('店铺排队列表','/BaseController/findUrl/call_queuing/wait_line.mvc');" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="margin-top: 10px;">店铺排队列表</a>
                <a id="btn34" href="#" onclick="show('消息推送','/reception/login/yonlie.mvc');" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="margin-top: 10px;">测试websocket</a>
                <a id="btn35" href="#" onclick="show('发送消息','/BaseController/findUrl/call_queuing/sendMessage.mvc');" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="margin-top: 10px;">给客户发送消息</a>
            </div>
        </div>
    </div>

    <div data-options="region:'center',title:'内容展示区'" style="padding:5px;background:#eee;">
        <div id="tt" class="easyui-tabs" data-options="fit:true">
            <div title="系统介绍" data-options="iconCls:'icon-save',fit:true,closable:true">
                这是全球战略性餐饮集团旗下的门店管理系统，该系统涉及订单管理、角色管理、权限管理、后厨管理、餐桌管理、报表管理等内容。。。。
            </div>
        </div>
    </div>
    <iframe src="http://www.baidu.com"></iframe>
</div>
</body>
</html>

