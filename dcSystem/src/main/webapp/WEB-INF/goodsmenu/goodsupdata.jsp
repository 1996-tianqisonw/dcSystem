<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="../../common/common.jspf"%>
<!DOCTYPE html>
<head>
    <title>Title</title>
</head>
<script>
    win =  parent.$("iframe[title='商品信息管理']").get(0).contentWindow;
    $(function () {
        var arr = win.$('#dg-goods').datagrid('getSelections');
        $('#ff1').form('load', arr[0]);
        $("img").attr("src", "/imges/" + arr[0].goodsImg);
        $("#goodsg").text(arr[0].specification);
        $.ajax({
            type: 'post',
            url: '${proPath}/Specification/selectSpe.mvc',
            traditional: true,
            data: {cId: arr[0].cId},
            dataType: 'JSON',
            cache: false,
            success: function (data) {
                var select = $('#ggys');
                select.empty();
                for (var i = 0; i < data.length; i++) {
                    for (var j in data[i]) {
                        if (j.valueOf() == "sName") {
                            var s1 = data[i][j];
                        } else if (j.valueOf() == "sStyle") {
                            var str = data[i][j];
                            var strs = new Array(); //定义一数组
                            strs = str.split("/"); //字符分割
                            var s2 = "";
                            for (var n = 0; n < strs.length; n++) {
                                var s3 = "<input style='margin-left: 5px' type='radio' name='radio" + i + "' value='" + s1 + "-" + strs[n] + "'/><span>" + strs[n] + "</span>";
                                s2 = s2 + s3;
                            }
                        }
                    }
                    select.append('<div>' + s1 + "：" + s2 + '<div>');
                }
            }

        })

    });

    function updatagoods() {
        var fuwenben = window.frames["goodsDescriptive"].document.getElementById("content1").value;
        var goodsId = $('#goodsId').val();
        var goodsName = $('#goodsName').val();
        var goodsTitle = $('#goodsTitle').val();
        var goodsPrice = $('#goodsPrice').val();
        var goodsStatus = $('#goodsStatus').combobox("getValue");
        if (goodsStatus == '上架') {
            goodsStatus = 0;
        }
        if (goodsStatus == '下架') {
            goodsStatus = 1;
        }
        var goodsNo = $('#goodsNo').val();
        var childs = $('#ggys').children("div").length;
        var ys = '';
        for (var i = 0; i < childs; i++) {
            var q = $("input[name='radio" + i + "']:checked").val();
            if (q != null) {
                ys = ys + q + '/';
            }
        }
        alert(goodsStatus);
        $.ajax({
            type: 'post',
            url: '${proPath}/Goods/updataGoods.mvc',
            traditional: true,
            data: {
                goodsId: goodsId,
                goodsName: goodsName,
                goodsTitle: goodsTitle,
                goodsPrice: goodsPrice,
                goodsStatus: goodsStatus,
                goodsNo: goodsNo,
                pecification: ys,
                goodsDescriptive: fuwenben
            },
            dataType: 'JSON',
            cache: false,
            success: function (data) {
                if (data > 0) {
                    alert("操作成功");
                    parent.$("iframe[title='商品信息管理']").get(0).contentWindow.$('#dg-goods').datagrid('reload');
                } else {
                    alert("操作失败")
                }

            }
        })
    }
</script>
<body>
<form name="ff1" id="ff1" method="post">
    <div id="tt2" class="easyui-tabs" style="width:800px;height:400px;">
        <div title="商品信息" style="padding:20px;">
            <input name="goodsId" id="goodsId" style="display: none">
            商品名字：
            <input id="goodsName" name="goodsName" style="margin: 20px" class="easyui-validatebox"/>
            商品标题：
            <input id="goodsTitle" name="goodsTitle" style="margin: 20px" class="easyui-validatebox"/><br>
            商品编号：
            <input id="goodsNo" name="goodsNo" style="margin: 20px" class="easyui-validatebox"/>
            商品价格：
            <input id="goodsPrice" name="goodsPrice" style="margin: 20px" class="easyui-validatebox"/><br>
            图片<%--上传：<input id="vv6" style="margin: 20px" type="file"/>--%>
            <img style="width: 100px; height: 100px; margin-right: 20px" name="goodsImg">
            商品状态：
            <select id="goodsStatus" name="goodsStatus" class="easyui-combobox" style="width:100px;">
                <option value="0">上架</option>
                <option value="1">下架</option>
            </select>

        </div>
        <div title="商品描述" style="padding:20px;">商品描述：
            <iframe id="goodsDescriptive" name="goodsDescriptive" frameborder="0" height="100%" width="100%"
                    src="${proPath}/BaseController/goURL/goodsmenu/KindEditor.mvc"></iframe>
        </div>
        <div title="规格样式" style="padding:20px;">
            已选择：<p id="goodsg"></p>
            <div id="ggys" name="ggys">
            </div>
        </div>
    </div>

</form>
<button onclick="updatagoods()">提交</button>
</body>
</html>