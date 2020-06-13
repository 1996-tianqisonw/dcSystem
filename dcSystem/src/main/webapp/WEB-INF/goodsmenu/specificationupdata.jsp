<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/tou/head.jsp" %>
<!DOCTYPE html>
<head>
    <title>Title</title>
    <title>Title</title>
    <script type="text/javascript">
        var win;
        $(function () {
            win = window.parent;
            var arr = win.$('#dg').datagrid('getSelections');
            $('#ff').form('load',arr[0])
        });
        function yz() {
            $("[name = 'sNmae']").validatebox({
                required:true,
                missingMessage:"不为空"
            });
            $("[name = 'sStyle']").validatebox({
                required:true,
                missingMessage:"不为空"
            });
            $('#ff').form('submit',{
                url:'${proPath}/Specification/updataSpecification.mvc',
                success:function (data) {
                    win.$('#dg').datagrid('reload');


                }
            })



        }



    </script>
</head>
<body>
<form id="ff" method="post">
    <input style="display: none" class="easyui-validatebox" id="sId" type="text" name="sId"/><br>
    规格名称：
    <input class="easyui-validatebox" id="sName" type="text" name="sName" data-options="required:true"/><br>
    规格样式：
    <input class="easyui-validatebox" id="sStyle" type="text" name="sStyle" data-options="required:true"/><br>
    <input id="btn" type="submit" value="提交" onclick="yz()"/>
    <p style="float: right">规格样式用“/”隔开</p>
</form>
</div>
</body>
</html>
