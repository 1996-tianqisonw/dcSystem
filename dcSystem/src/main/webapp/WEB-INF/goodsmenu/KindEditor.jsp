<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--<%
    request.setCharacterEncoding("UTF-8");
    String htmlData = request.getParameter("content1") != null ? request.getParameter("content1") : "";
%>--%>
<%@include file="/tou/head.jsp" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8" />
    <script>
        var editor
        KindEditor.ready(function(K) {
            editor = K.create('textarea[name="content1"]', {
                cssPath : '../../../kindeditor/plugins/code/prettify.css',
                uploadJson : '../../../kindeditor/jsp/upload_json.jsp',
                fileManagerJson : '../../../kindeditor/jsp/file_manager_json.jsp',
                allowFileManager : true,
                /*afterCreate : function() {
                    var self = this;
                    K.ctrl(document, 13, function() {
                        self.sync();
                        document.forms['example'].submit();
                    });
                    K.ctrl(self.edit.doc, 13, function() {
                        self.sync();
                        document.forms['example'].submit();
                    });
                },*/

                afterBlur: function () { this.sync(); }
            });
            prettyPrint();
        });
<%--        function te() {
            //editor.sync();
            html=document.getElementById('content1').value;
            alert(html);

        }--%>
    </script>

</head>
<body>
    <textarea id="content1" name="content1" cols="100" rows="8" style="width:700px;height:200px;visibility:hidden;">
</textarea>
</body>

</html>