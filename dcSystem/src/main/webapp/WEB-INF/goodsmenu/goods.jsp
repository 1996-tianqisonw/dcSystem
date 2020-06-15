<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="../../common/common.jspf"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>

</head>
<body>
<form id="ff" method="post">
    <div>
        <label for="cCompany">总 公 司 :</label>
        <input id="cCompany" class="easyui-validatebox" type="text" name="bookname"
               data-options=""/>

        <label for="cStore">店铺名称:</label>
        <input id="cStore" class="easyui-validatebox" type="text" name="bookname"
               data-options=""/>

        <label for="cName">商品分类:</label>
        <input id="cName" class="easyui-validatebox" type="text" name="bookname"
               data-options=""/>
        <br>
        <label for="goodsName">商品名称:</label>
        <input id="goodsName" class="easyui-validatebox" type="text" name="bookname"
               data-options=""/>

        <label for="goodsNo">商品编号:</label>
        <input id="goodsNo" class="easyui-validatebox" type="text" name="bookprice"
               data-options=""/>

        <label for="goodsStatus">商品状态:</label>
        <select id="goodsStatus" class="easyui-combobox" style="width:100px;">
            <option value="0">上架</option>
            <option value="1">下架</option>
        </select>
        <a id="btnq" href="#" onclick="query()" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">查询</a>
    </div>

</form>
<table id="dg-goods"></table>
<div id="win"></div>


<script type="text/javascript">
    $('#dg-goods').datagrid({
        url: '${proPath}/Goods/selectGoods.mvc',
        columns: [[
            {checkbox: true},
            {field: 'cCompany', title: '公司', width: 100},
            {field: 'cId', title: '菜单ID', hidden: true, width: 100},
            {field: 'cStore', title: '店铺', width: 100},
            {field: 'cName', title: '所属菜单', width: 100},
            {field: 'goodsId', title: 'id', width: 100, hidden: true},
            {field: 'goodsName', title: '商品名称', width: 100},
            {field: 'goodsTitle', title: '商品标题', width: 100},
            {field: 'goodsNo', title: '编号', width: 100},
            {
                field: 'goodsImg', title: '图片', width: 100, formatter: function (value, row, index) {
                    if (value!=null&&value!="") {
                        return "<img src='/imges/" + value + "' style='height: 40px ;width: 40px;'>";
                    } else {
                        return "";
                    }
                }
            },
            {field: 'goodsDescriptive;', title: '描述', width: 100, hidden: true},
            {field: 'specification;', title: '规格', width: 100, hidden: true},
            {field: 'goodsPrice', title: '价格', width: 100},
            {field: 'goodsStatus', title: '状态', width: 100},
            {field: 'addTime', title: '添加时间', width: 100},
        ]],
        fitColumns: true,
        toolbar: [{
            iconCls: 'icon-add',
            text: '新增',
            handler: function () {
                $('#win').window({
                    title: '添加商品',
                    width: 1000,
                    height: 600,
                    modal: true,
                    collapsible: false,
                    href: '${proPath}/BaseController/goURL/goodsmenu/goodsadd.mvc'
                    /*  content: "<iframe src='' height='100%' width='100%' frameborder='0px' ></iframe>"*/
                });
            }
        }, '-', {
            iconCls: 'icon-edit',
            text: '编辑',
            handler: function () {
                /*
                判断用户是否只选中一行
                1。获取选中的行
                2。判断是否是一行，不是的话进行提示
                */
                var rows = $('#dg-goods').datagrid("getSelections");
                if (rows.length == 1) {
                    parent.$('#win').window({
                        title: '编辑用户',
                        width: 850,
                        height: 500,
                        modal: true,
                        collapsible: false,
                        content: "<iframe src='${proPath}/BaseController/goURL/goodsmenu/goodsupdata.mvc' height='100%' width='100%' frameborder='0px' ></iframe>"
                    });
                } else {
                    $.messager.show({
                        title: '提示信息',
                        msg: '只能选择一行',
                        timeout: 2000,
                        showType: 'slide'
                    });
                }
            }
        }],
        striped: true,
        pagination: true,
        rownumbers: true,
        pageList: [5, 10, 15, 20],
        pageSize: 5

    });

    function query() {
        //获取填写的值
        var goodsname = $("#goodsName").val();
        var goodsno = $("#goodsNo").val();
        var cName = $("#cName").val();
        var goodsstatus = $("#goodsStatus").combobox('getValue');
        var cCompany = $("#cCompany").val();
        var cStore = $("#cStore").val();
        //调用 datagrid方法根据查询参数重新加载表格数据
        $('#dg-goods').datagrid('load', {
            cStore: cStore,
            cName: cName,
            cCompany: cCompany,
            goodsName: goodsname,
            goodsNo: goodsno,
            goodsStatus: goodsstatus
        });

    }
</script>
</div>
</body>
</html>