<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/5/21
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/tableController/insertTable.mvc" method="post">
    <div>
        <label for="dcId">餐桌编号:</label>
        <input type="text" class="easyui-validatebox" name="dcId">
    </div>
    <div>
        <label for="dcName">餐桌名称:</label>
        <input type="text" class="easyui-validatebox" name="dcName">
    </div>
    <div>
        <label for="dcForm">就餐方式</label>
        <input type="text" class="easyui-validatebox" name="dcForm">
    </div>
    <div>
        <label for="dcUsestatus">使用状态</label>
        <input type="text" class="easyui-validatebox" name="dcUsestatus">
    </div>
    <div>
        <label for="dcShop">餐桌的店铺</label>
        <input type="text" class="easyui-validatebox" name="dcShop">
    </div>
    <div>
        <label for="dcCompanies">餐桌的公司</label>
        <input type="text" class="easyui-validatebox" name="dcCompanies">
    </div>
    <div>
        <label for="dcSpecifications">餐桌的规格</label>
        <input type="text" class="easyui-validatebox" name="dcSpecifications">
    </div>
    <input class="easyui-validatebox" type="submit" value="添加">
</form>
</body>
</html>
