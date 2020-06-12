<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<%--<img src="imges/1.jpg">--%>
<form id="ff" method="post" >
    <div>
        <label  for="productid">总 公 司 :</label>
        <input id="productid1" class="easyui-validatebox" type="text" name="bookname" data-options="validType:['length[6,10]']" />

        <label for="productid">店铺名称:</label>
        <input id="productid2" class="easyui-validatebox" type="text" name="bookname" data-options="validType:['length[6,10]']" />

        <label for="productid">商品分类:</label>
        <input id="productid3" class="easyui-validatebox" type="text" name="bookname" data-options="validType:['length[6,10]']" />
        <br>
        <label for="productid">商品名称:</label>
        <input id="productid" class="easyui-validatebox" type="text" name="bookname" data-options="validType:['length[6,10]']" />

        <label for="productname">商品编号:</label>
        <input id="productname" class="easyui-validatebox" type="text" name="bookprice" data-options="validType:['length[6,10]']" />

        <label for="productid">商品状态:</label>
        <select id="cc" class="easyui-combobox" name="dept" style="width:100px;">
            <option value="aa">上架</option>
            <option>下架</option>
        </select>
        <a id="btnq" href="#" onclick="query()"  class="easyui-linkbutton" data-options="iconCls:'icon-ok'">查询</a>
    </div>

</form>
<table id="dg1"></table>
<div id="win"></div>

<script type="text/javascript">
    $('#dg1').datagrid({
        url:'Goods/selectGoods.mvc',
        columns:[[
            {checkbox:true},

            {field:'cCompany',title:'公司',width:100},
            {field:'cStore',title:'店铺',width:100},
            {field:'cName',title:'所属菜单',width:100},
            {field:'goodsId',title:'id',width:100,hidden:true},
            {field:'goodsName',title:'商品名称',width:100},
            {field:'goodsTitle',title:'商品标题',width:100},
            {field:'goodsNo',title:'编号',width:100},
            {field:'goodsImg',title:'图片',width:100,formatter:function (value, row, index) {
                if(value.length>0){
                    return "<img src='imges/"+value+"' style='height: 40px ;width: 40px;'>";}
                else {
                    return "";
                }
                }},
            {field:'goodsDescriptive;',title:'描述',width:100,hidden: true},
            {field:'specification;',title:'规格',width:100,hidden: true},
            {field:'goodsPrice',title:'价格',width:100},
            {field:'goodsStatus',title:'状态',width:100},
            {field:'addTime',title:'添加时间',width:100},
        ]] ,
        fitColumns:true,
        toolbar: [{
            iconCls: 'icon-add',
            text:'新增',
            handler: function(){
                //alert('新增按钮')
                $('#win').window({
                    title:'添加商品',
                    width:1000,
                    height:600,
                    modal:true,
                    collapsible:false,
                    //content:
                    href:'goodsadd.jsp'
                });
            }
        },'-',{
            iconCls: 'icon-edit',
            text:'编辑',
            handler: function(){
                /*
                判断用户是否只选中一行
                1。获取选中的行
                2。判断是否是一行，不是的话进行提示
                */
                var rows = $('#dg1').datagrid("getSelections");
                if(rows.length==1) {
                    //alert()
                    parent.$('#win').window({
                        title: '编辑用户',
                        width: 800,
                        height: 600,
                        modal: true,
                        collapsible: false,
                        content: "<iframe src='goodsupdata.jsp' height='100%' width='100%' frameborder='0px' ></iframe>"
                    });
                }else {
                    $.messager.show({
                        title:'提示信息',
                        msg:'只能选择一行',
                        timeout:2000,
                        showType:'slide'
                    });
                }
            }
        },'-',{
            iconCls: 'icon-remove',
            text:'删除',
            handler: function(){
                alert('删除按钮')
            }
        }],
        striped:true,
        pagination:true,
        rownumbers:true,
        pageList:[5,10,15,20],
        pageSize:5

    });

/*    function query(){
        alert("ddd");
        //获取填写的值
        var productid=  $("#productid").val();
        var productname=  $("#productname").val();

        //调用 datagrid方法根据查询参数重新加载表格数据
        $('#dg').datagrid('load',{
            productid:productid,
            productname: productname
        });

    }*/
</script>
</div>
</body>
</html>