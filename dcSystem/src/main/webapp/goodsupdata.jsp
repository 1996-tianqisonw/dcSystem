<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="head.jsp" %>
<!DOCTYPE html>
<head>
    <title>Title</title>
</head>
<script type="javascript">
    /*        var win;
            win = window.parent;
            var arr = win.$('#dg1').datagrid('getSelections');
           $(function () {
                win = window.parent;
                var arr = win.$('#dg1').datagrid('getSelections');
            });*/
    function aqa() {
        alert($('#goodsName').val());
    }
</script>
<body>

<div data-options="region:'center',title:'center title'" style="padding:5px;background:#eee;">
    <form name="ff1" id="ff1" method="post">
    <div id="tt2" class="easyui-tabs" style="width:800px;height:500px;">
        <div title="商品信息" style="padding:20px;">
            <input name="goodsId" id="goodsId" style="display: none">
            商品名字：
            <input id="goodsName"name="goodsName" style="margin: 20px" class="easyui-validatebox"/>
            商品标题：
            <input id="goodsTitle"  name="goodsTitle" style="margin: 20px" class="easyui-validatebox"/><br>
            商品编号：
            <input id="goodsNo" name="goodsNo" style="margin: 20px" class="easyui-validatebox"/>
            商品价格：
            <input value="" id="goodsPrice" name="goodsPrice" style="margin: 20px" class="easyui-validatebox"/><br>
            图片上传：<input id="vv6" style="margin: 20px" type="file"/>
            <img style="width: 100px; height: 100px" id="goodsImg" name="goodsImg" src=""><br>
            商品状态：
            <select id="cc" name="" class="easyui-combobox" name="dept" style="width:100px;">
                <option value="0">上架</option>
                <option value="1">下架</option>
            </select>

        </div>
        <div title="商品描述" style="padding:20px;">商品描述：
            <iframe frameborder="0" height="100%" width="100%" src="KindEditor.jsp"></iframe>
        </div>
        <div title="规格样式" style="padding:20px;">
        </div>
    </div>

    </form>
</div>
<button onclick="aqa()">提交</button>
</body>
</html>