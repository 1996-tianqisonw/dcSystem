<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ include file="/common/common.jspf" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="tt" class="easyui-tabs" style="">
    <div title="餐营模式"  href="${proPath}/BaseController/goURL/manage/cyMode.mvc"></div>
    <div title="支付流程"  href="${proPath}/BaseController/goURL/manage/payFlow.mvc"></div>

</div>

</body>
</html>
