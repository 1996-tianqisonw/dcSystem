<%--
  Created by IntelliJ IDEA.
  User: 86173
  Date: 2020/5/22
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../dcsystem/dcsystem.jsp"%>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function show(str,url){
            if($('#tt').tabs('exists',str)){
                $('#tt').tabs('select',str)
            }else{
                $('#tt').tabs('add',{
                    title:str,
                    content:"<iframe src='"+url+"' title='"+str+"' height='100%' width='100%' frameborder='0px'/>",
                    //href:url,
                    closable:true,
                    selected:true
                });
            }
        }
    </script>
</head>
<body>
<div id="cc" data-options="fit:true" class="easyui-layout" style="width:600px;height:400px;">
    <div data-options="region:'north',title:'North Title',split:true" style="height:100px;">
    </div>
    <div data-options="region:'west',title:'West'" style="width:180px;">
        <div id="aa" data-options="fit:true" class="easyui-accordion" style="width:300px;height:200px;">
            <c:forEach items="${sessionScope.users.roles.menus}" var="menu">
                    <c:if test="${menu.orgId==0}">
            <div title=${menu.menuName} data-options="iconCls:'icon-save'" style="overflow:auto;padding:10px;">
                <c:forEach items="${sessionScope.users.roles.menus}" var="menus">
                        <c:if test="${menus.orgId==menu.menuId}">
                <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="show('${menus.menuName}','${menus.url}')">${menus.menuName}</a><br>
                        </c:if>
                </c:forEach>
            </div>
                </c:if>
            </c:forEach>
        </div>
    </div>
    <div data-options="region:'center',title:'center title'" style="padding:5px;background:#eee;">
        <div id="tt" data-options="fit:true" class="easyui-tabs" style="width:500px;height:250px;">
            <div title="Tab1" style="padding:20px;display:none;">
                tab1
            </div>
        </div>
    </div>
</div>
<div id="win"></div>
</body>
</html>

