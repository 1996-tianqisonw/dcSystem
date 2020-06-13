<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="common/common.jspf"%>
<html>
<body>
<form id="fm" action="UsersController/selectPassword.mvc" method="post">
    <div>
        <label for="userName">账号</label>
        <input id="userName" class="easyui-validatebox" type="text" name="userName" />
    </div>
    <div>
        <label for="userPassword">账号</label>
        <input id="userPassword" class="easyui-validatebox" type="text" name="userPassword" />
    </div>
    <input type="submit" value="提交"/>
</form>
</body>
</html>