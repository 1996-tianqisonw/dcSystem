<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="../../common/common.jspf"%>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>

<body>
<div id="ccc" class="easyui-layout" style="width:100%;height:100%;">
    <div data-options="region:'west',title:'West',split:true" style="width:200px;">
        <%--树--%>
        <ul id="tt1"></ul>
    </div>
    <div data-options="region:'center',title:'center title'" style="padding:5px;background:#eee;">
        所选菜单：<input id="vv" disabled="disabled" class="easyui-validatebox"/>
        <%--放菜单id 隐藏--%>
        <input id="c_id" style="display: none" disabled="disabled" class="easyui-validatebox"/><br>
        <form name="" method="post" enctype="multipart/form-data">
            <%--easyui-tabs组件--%>
            <div id="" class="easyui-tabs" style="width:800px;height:400px;">
                <div title="商品信息" style="padding:20px;">
                    商品名字：
                    <input id="goodsName" style="margin: 20px" data-options="required:true" class="easyui-validatebox"/>
                    商品标题：
                    <input id="goodsTitle" style="margin: 20px" data-options="required:true"
                           class="easyui-validatebox"/><br>
                    商品编号：
                    <input id="goodsNo" style="margin: 20px" class="easyui-validatebox"/>
                    商品价格：
                    <input id="goodsPrice" style="margin: 20px" data-options="required:true"
                           class="easyui-validatebox"/><br>
                    图片上传：<input id="goodsImg" style="margin: 20px" type="file"/>
                    商品状态：
                    <select id="goodsStatus" class="easyui-combobox" style="width:100px;">
                        <option value="0">上架</option>
                        <option value="1">下架</option>
                    </select>
                </div>
                <div title="商品描述" style="padding:20px;">
                    <%--富文本编辑器--%>
                    商品描述：
                    <iframe id="myiframe" name="myiframe" frameborder="0" height="100%" width="100%"
                            src="${proPath}/BaseController/goURL/goodsmenu/KindEditor.mvc"></iframe>
                </div>
                <div title="规格样式" name="" style="padding:20px;">
                    <div id="ggys" name="ggys">
                    </div>
                </div>
            </div>
        </form>
        <button onclick="ff()">提交</button>
    </div>
</div>
<script type="text/javascript">
    function ff() {
        var childs = $('#ggys').children("div").length;
        var ys = '';
        for (var i = 0; i < childs; i++) {
            var q = $("input[name='radio" + i + "']:checked").val();
            if (q != null) {
                ys = ys + q + '/';
            }
        }
        var fuwenben = window.frames["myiframe"].document.getElementById("content1").value;
        var myform = new FormData();
        var goodsname = $('#goodsName').val();
        var goodstitle = $('#goodsTitle').val();
        var goodsno = $('#goodsNo').val();
        var goodsstatus = $('#goodsStatus').combobox("getValue");
        var goodsprice = $('#goodsPrice').val();
        var goodsc = $('#c_id').val();
        /* $("#goodsImg")[0].files[0]*/
        myform.append("goodsName", goodsname);
        myform.append('file', $("#goodsImg")[0].files[0]);
        myform.append("goodsTitle", goodstitle);
        myform.append("goodsNo", goodsno);
        myform.append("goodsStatus", goodsstatus);
        myform.append("goodsPrice", goodsprice);
        myform.append("cId", goodsc);
        myform.append("goodsDescriptive", fuwenben);
        myform.append("specification", ys);
        if (goodsc != '') {
            if (goodsname != '' && goodstitle != '' && goodsprice != '') {
                $.ajax({
                    type: 'post',
                    url: '${proPath}/Goods/insetGoods.mvc',
                    traditional: true,
                    data: myform,
                    dataType: 'JSON',
                    cache: false,
                    contentType: false,
                    processData: false,
                    success: function (data) {
                        if (data > 0) {
                            alert("操作成功");
                            window.parent.$('#dg-goods').datagrid('reload');
                        } else {
                            alert("操作失败")
                        }

                    }
                })
            } else {
                alert("请输入必填项");
            }
        } else {
            alert("请选择菜单");
        }
    };
    $('#tt1').tree({
        url: '${proPath}/Categories/selectCategories.mvc',
        animate: true,
        onClick: function (node) {
            if ($('#tt2').tree('isLeaf', node.target)) {
                $('#vv').val(node.text);
                $('#c_id').val(node.id);
                $.ajax({
                    type: 'post',
                    url: '${proPath}/Specification/selectSpe.mvc',
                    traditional: true,
                    data: {cId: node.id},
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
            }
        },
    })
</script>
</body>
</html>
