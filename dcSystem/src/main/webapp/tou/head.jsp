<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="proPath" value="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="${proPath}/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${proPath}/easyui/themes/icon.css">
    <script type="text/javascript" src="${proPath}/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${proPath}/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${proPath}/easyui/locale/easyui-lang-zh_CN.js"></script>
    <link rel="stylesheet" href="${proPath}/kindeditor/themes/default/default.css"/>
    <link rel="stylesheet" href="${proPath}/kindeditor/plugins/code/prettify.css"/>
    <script charset="utf-8" src="${proPath}/kindeditor/kindeditor-all.js"></script>
    <script charset="utf-8" src="${proPath}/kindeditor/lang/zh-CN.js"></script>
    <script charset="utf-8" src="${proPath}/kindeditor/plugins/code/prettify.js"></script>
</head>
</html>