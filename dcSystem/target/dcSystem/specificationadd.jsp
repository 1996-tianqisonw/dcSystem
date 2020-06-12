
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="head.jsp" %>
<!DOCTYPE html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        var win = window.parent;
        var cid = win.$('#cid').val();
        function save() {
            var sname = $('#sName').val();
            var sstyle = $('#sStyle').val();
            $.ajax({
                type:'post',
                url:'Specification/insertSpecification.mvc',
                traditional:true,
                data:{sName:sname,sStyle:sstyle,cId:cid},
                dataType:'JSON',
                cache:false,
                success:function (data) {
                    if (data>0){
                        alert("操作成功");
                        win.$('#dg').datagrid('reload');
                        win.$('#win_s').dialog('close');
                    }else {
                        alert("操作失败")
                    }

                }
            })
        }

    </script>
</head>
<body>
        规格名称：
        <input class="easyui-validatebox" id="sName" type="text" name="sName" data-options="required:true"/><br>
         规格样式：
        <input class="easyui-validatebox" id="sStyle" type="text" name="sStyle" data-options="required:true"/><br>
        <input id="btn" type="button" value="提交" onclick="save()" />
        <p style="float: right">规格样式用“/”隔开</p>
    </div>
</body>
</html>
