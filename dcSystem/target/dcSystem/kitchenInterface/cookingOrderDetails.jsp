<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/5/25
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../dcsystem/dcsystem.jsp"%>
<% String ui = (String) request.getSession().getAttribute("Id");%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table id="xqs"></table>
<div id="win"></div>
<script type="text/javascript">
    $('#xqs').datagrid({
        url:'/cooking/orderDetails.mvc?ID='+'<%=ui%>',
        columns:[[
            {filed:'ck',checkbox:true},
            {field:'dsId',title:'菜品编号',width:100,hidden:true},
            {field:'kcOrdernumber',title:'订单号',width:100},
            {field:'dsName',title:'菜品名称',width:100},
            {field:'dsPictures',title:'菜品的图片',width:100},
            {field:'dsPrice',title:'菜品的价格',width:100},
            {field:'dsDegreeechilliText',title:'菜品的辣度',width:100},
            {field:'dsStatusText',title:'做菜的状态',width:100},
            {field:'dsComponentText',title:'菜品的份量',width:100}
        ]],
        fitColumns:true,
        singleSelect:true,
        toolbar:[{
            text:'做菜完成',
            iconCls:'icon-add',
            handler:function(){
                alert('做菜完成')
                if($('#xqs').datagrid('getSelected')!=null){
                    cookDetail("/cooking/cookingFinished.mvc","Finished")
                }else{
                    $.messager.show({
                        tetle:'提示',
                        msg:'请选择一个选项!'
                    })
                }
              /*  $('#xqs').datagrid({
                        title:'做菜完成',
                        href:'/cooking/cookingFinished.mvc?Name=1&
                    })*/
            }
        },'-',{
            text:'做菜中',
            iconCls:'icon-add',
            handler:function () {
                alert('做菜中')
                if($('#xqs').datagrid('getSelected')!=null){
                    cookDetail("/cooking/cookingProgress.mvc","Progress")
                }else{
                    $.messager.show({
                        tetle:'提示',
                        msg:'请选择一个选项!'
                    })
                }
                /*$('#xqs').datagrid({
                        href:'/cooking/cookingProgress.mvc?Name=2&ID='+'<%=ui%>',
                    })*/
            }
        }],
        PageSize:5,
        pageList:[3,5,8,10,15],
        pagination:true,
        rownumbers:true,
        striped:true
    })

    //该方法为统一的数据链接传送和回调controller的返回值，又二个参数，
    // url表示要请求的地址，key表示标记哪个操作，已处理回来的数据展示。
    function cookDetail(url,key) {
        $.ajax({
            method:'post',
            url:url,
            data:{
                dsName:$('#xqs').datagrid('getSelected').dsName,
                kcOrdernumber:$('#xqs').datagrid('getSelected').kcOrdernumber,
                dsId:$('#xqs').datagrid('getSelected').dsId
            },
            beforeSend: function () {
                $('#xqs').datagrid('loading');
            },
            success: function (data) {
                if (data) {
                    $('#xqs').datagrid('loaded');
                    $('#xqs').datagrid('load');
                    $('#xqs').datagrid('unselectAll');
                    if(key=="Finished") {
                        $.messager.show({
                            title: '提示',
                            msg: data + "个菜品已完成！"
                        });
                    }else if(key=="Progress"){
                        $.messager.show({
                            title: '提示',
                            msg: data + "个菜品做菜中！"
                        });
                    }
                }
            }
         })
    }
</script>
</body>
</html>
