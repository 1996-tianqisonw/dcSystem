<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/5/21
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../dcsystem/dcsystem.jsp"%>
<% String ui = (String) request.getSession().getAttribute("Id");%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<script type="text/javascript">
        alert("你好");
      var userId = '<%=ui%>';
      alert(userId);
        $("#dcId").val(userId);
</script>
<form action="/tableController/updateTable.mvc" method="post">
    <div>
        <%--<label for="dcId">餐桌编号:</label>--%>
        <input type="hidden" class="easyui-validatebox" name="dcId" id="dcId">
    </div>
    <div>
        <label for="dcName">餐桌名称:</label>
        <input type="text" class="easyui-validatebox" name="dcName">
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
    <input class="easyui-validatebox" type="submit" value="修改">
</form>
</body>
</html>
