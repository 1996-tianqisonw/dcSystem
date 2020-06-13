<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="../../common/common.jspf"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<form>

</form>
<div id="ccc" class="easyui-layout" style="width:100%;height:100%;">
    <div data-options="region:'west',split:true" style="width:200px;">
        <ul id="tt2"></ul>
        <div id="mm1" class="easyui-menu" style="   width:120px;">
            <div onclick="append()" data-options="iconCls:'icon-add'">添加</div>
            <div onclick="remove()" data-options="iconCls:'icon-remove'">移除</div>
        </div>
        <div id="mm2" class="easyui-menu" style="width:120px;">
            <div onclick="remove()" data-options="iconCls:'icon-remove'">移除</div>
            <div onclick="rename()" data-options="iconCls:'icon-edit'">重命名</div>
        </div>
    </div>
    <div data-options="region:'center'" style="padding:5px;background:#eee;">
        所选菜单：<input id="vv1" disabled="disabled" class="easyui-validatebox"/>
        <input id="cid" style="display:none" class="easyui-validatebox"/><br>
        <table id="dg"></table>
    </div>
</div>
<div id="win_s"></div>

<script type="text/javascript">
    $('#tt2').tree({
        url: '${proPath}/Categories/selectCategories.mvc',
        animate: true,
        onContextMenu: function (e, node) {
            e.preventDefault();
            if (!$('#tt2').tree('isLeaf', node.target)) {
                $('#mm1').menu('show', {
                    left: e.pageX,
                    top: e.pageY
                });
            } else {
                $('#mm2').menu('show', {
                    left: e.pageX,
                    top: e.pageY
                });
            }
        },
        onClick: function s(node) {
            if ($('#tt2').tree('isLeaf', node.target)) {
                $('#vv1').val(node.text);
                $('#cid').val(node.id);
                /*查询对应菜单规格样式*/
                $('#dg').datagrid({
                    url: '${proPath}/Specification/selectSpecification.mvc',
                    queryParams: {cId: node.id},
                    columns: [[
                        {checkbox: true},
                        {field: 'sId', title: 'id', width: 100, hidden: true},
                        {field: 'sName', title: '规格参数', width: 50},
                        {field: 'sStyle', title: '样式选择', width: 50}
                    ]],
                    fitColumns: true,
                    toolbar: [{
                        iconCls: 'icon-add',
                        text: '新增',
                        handler: function () {
                            parent.$('#win_s').window({
                                title: '添加规格',
                                width: 400,
                                height: 200,
                                modal: true,
                                collapsible: false,
                                content: "<iframe src='${proPath}/BaseController/goURL/goodsmenu/specificationadd.mvc' height='100%' width='100%' frameborder='0px' ></iframe>"
                            });

                        }
                    }, '-', {
                        iconCls: 'icon-edit',
                        text: '修改',
                        handler: function () {
                            var array = $('#dg').datagrid('getSelections');
                            if (array.length == 1) {
                                parent.$('#win_s').window({
                                    title: '修改规格',
                                    width: 400,
                                    height: 200,
                                    modal: true,
                                    collapsible: false,
                                    content: "<iframe src='${proPath}/BaseController/goURL/goodsmenu/specificationupdata.mvc' height='100%' width='100%' frameborder='0px' ></iframe>"
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
                    }, '-', {
                        iconCls: 'icon-remove',
                        text: '删除',
                        handler: function () {
                            var arr = $('#dg').datagrid('getSelections');
                            if (arr.length > 0) {
                                var ids = new Array();
                                for (i = 0; i < arr.length; i++) {
                                    ids[i] = arr[i].sId;
                                }
                                parent.$.messager.confirm('删除对话框', '您确认要删除吗？', function (r) {
                                    if (r) {
                                        $.ajax({
                                            url: "${proPath}/Specification/delSpecification.mvc",
                                            type: "POST",
                                            traditional: true,
                                            data: {ids: ids},
                                            success: function (data) {
                                                $('#dg').datagrid("reload");
                                                //请除所有勾选的行
                                                $('#dg').datagrid("clearSelections");
                                            },
                                            error: function (XMLHttpRequest, textStatus, errorThrown) {
                                                $.messager.alert('删除错误', '请联系管理员！', 'error');
                                            },
                                            dataType: 'json'
                                        });
                                    }
                                })
                            }
                        }
                    }],
                    striped: true,
                    pagination: true,
                    rownumbers: true,
                    pageList: [5, 10, 15, 20],
                    pageSize: 5,

                });
            }
        },
        onAfterEdit: function (node) {
            if (node.id == 0) {
                /*新增*/
                $.post("${proPath}/Categories/insertCategories.mvc", {cName: node.text}, function (data) {
                    if (data == 1) {
                        $.messager.show({
                            title: '提示信息',
                            msg: '添加成功。',
                            timeout: 2000,
                            showType: 'slide'
                        });
                        //重新载人树
                        $.post("${proPath}/Categories/selectCategories.mvc", function (data) {
                            $('#tt2').tree('loadData', data);
                        })
                    } else {
                        $.messager.show({
                            title: '提示信息',
                            msg: '添加失败。',
                            timeout: 2000,
                            showType: 'slide'
                        });
                    }
                })
            } else {
                /* 修改*/
                $.post("${proPath}/Categories/updataCategories.mvc", {cId: node.id, cName: node.text}, function (data) {
                    if (data == 1) {
                        $.messager.show({
                            title: '提示信息',
                            msg: '操作成功。',
                            timeout: 2000,
                            showType: 'slide'
                        });
                        $.post("${proPath}/Categories/selectCategories.mvc", function (data) {
                            $('#tt2').tree('loadData', data);
                        })
                    } else {
                        $.messager.show({
                            title: '提示信息',
                            msg: '操作失败。',
                            timeout: 2000,
                            showType: 'slide'
                        });
                    }
                })
            }
        }
    })

    function append() {
        var selected = $('#tt2').tree('getSelected');
        if (selected)
            $('#tt2').tree('append', {
                parent: selected.target,
                data: [{
                    id: 0,
                    text: 'new',
                }],
            });

    }

    function rename() {
        var selected = $('#tt2').tree('getSelected');
        if ($('#tt2').tree('isLeaf', selected.target)) {
            $('#tt2').tree('beginEdit', selected.target);
        }
    }

    function remove() {
        var selected = $('#tt2').tree('getSelected');
        $.post("${proPath}/Categories/delCategories.mvc", {cId: selected.id}, function (data) {
            if (data == 1) {
                $('#tt2').tree("remove", selected.target);
            }
        });
    }

    $('#dg').datagrid({
        url: '',
        columns: [[
            {checkbox: true},
            {field: 'sName', title: '规格参数', width: 60},
            {field: 'sStyle', title: '样式选择', width: 60}
        ]],
        fitColumns: true,
        toolbar: [{
            iconCls: 'icon-add',
            text: '新增',
            handler: function () {
                alert("请选择菜单");
            }
        }, '-', {
            iconCls: 'icon-edit',
            text: '保存',
            handler: function () {
                alert('请选择菜单')

            }
        }, '-', {
            iconCls: 'icon-remove',
            text: '删除',
            handler: function () {
                alert('请选择菜单');
            }
        }],
        striped: true,
        pagination: true,
        rownumbers: true,
        pageList: [5, 10, 15, 20],
        pageSize: 5,

    });

</script>
</body>
</html>