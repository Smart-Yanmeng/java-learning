<%--
  Created by IntelliJ IDEA.
  User: 星时代曹波涛
  Date: 2020/10/15
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html class="x-admin-sm">

<head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.2</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/admin/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/admin/css/xadmin.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/admin/css/datatables.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.4.1.js"></script>
    <script src="${pageContext.request.contextPath}/static/admin/js/datatables.js"></script>
    <script src="${pageContext.request.contextPath}/static/admin/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/admin/js/xadmin.js"></script>
    <style>
        .layui-table td, .layui-table th {
            min-width: 10px;
            max-width: 200px;
        }
    </style>
</head>

<body>
<div class="x-nav">
            <span class="layui-breadcrumb">
                <a href="">首页</a>
                <a>
                    <cite>商品列表</cite></a>
            </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       onclick="location.reload()" title="刷新">
        <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i>
    </a>
</div>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">

                <div class="layui-card-header">
                    <button class="layui-btn" onclick="xadmin.open('商品添加','/admin/product-add.jsp',800,600)">
                        <i class="layui-icon"></i>添加
                    </button>
                </div>
                <div class="layui-card-body">
                    <table class="layui-table layui-form" id="myTable">
                        <thead>
                        <tr>
                            <th>商品图片</th>
                            <th>商品名称</th>
                            <th>商品描述</th>
                            <th>商品价格</th>
                            <th>商品库存</th>
                            <th>上架时间</th>
                            <th>商品状态</th>
                            <th>下架时间</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${requestScope.data.data}" var="p" varStatus="v">
                            <tr>
                                <td style="text-align: center;"><img src="/upload/${p.img}" alt="无"
                                                                     style="width: 50px;height: 50px;"></td>
                                <td>${p.name}</td>
                                <td>${p.desc}</td>
                                <td style="text-align: right;">${p.price}元</td>
                                <td style="text-align: center;">${p.stock}</td>
                                <td>${p.created}</td>
                                <c:if test="${empty p.deleted}">
                                    <td style="text-align: center;">正常售卖</td>
                                </c:if>
                                <c:if test="${!empty p.deleted}">
                                    <td style="color: red;text-align: center;">已经下架</td>
                                </c:if>
                                <td style="text-align: center;">${p.deleted}</td>
                                <td class="td-manage" style="text-align: center;">
                                    <a title="查看" onclick="xadmin.open('商品编辑','/admin/product/editpage?id=${p.id}',800,600)" href="javascript:;">
                                        <i class="layui-icon">&#xe63c;</i></a>
                                    <a title="删除" onclick="del(this,'${p.id}')" href="javascript:;">
                                        <i class="layui-icon">&#xe640;</i></a>
                                </td>
                            </tr>
                        </c:forEach>


                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    layui.use(['laydate', 'form'],
        function () {
            var laydate = layui.laydate;

            //执行一个laydate实例
            laydate.render({
                elem: '#start' //指定元素
            });

            //执行一个laydate实例
            laydate.render({
                elem: '#end' //指定元素
            });
        });

    /*删除*/
    function del(obj, id) {
        layer.confirm('确认要下架该商品吗？<br/>商品ID:' + id,
            function (index) {
                let l = layer.load(1, {
                    shade: [0.3, '#fff'] //0.1透明度的白色背景
                });
                $.post("/admin/product/del", {id: id}, data=> {
                    layer.close(l);
                    if (data.status === 200) {
                        layer.msg(data.msg)
                        console.log(data)
                        location.reload();
                    } else {
                        layer.msg(data.msg)
                    }
                })
            });
    }

    function delAll(argument) {

        var data = tableCheck.getData();

        layer.confirm('确认要删除吗？' + data,
            function (index) {
                //捉到所有被选中的，发异步进行删除
                layer.msg('删除成功', {
                    icon: 1
                });
                $(".layui-form-checked").not('.header').parents('tr').remove();
            });
    }

    $(document).ready(function () {

        $('#myTable').DataTable({
            language: {
                "sProcessing": "处理中...",
                "sLengthMenu": "显示 _MENU_ 项结果",
                "sZeroRecords": "没有匹配结果",
                "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                "sInfoPostFix": "",
                "sSearch": "搜索:",
                "sUrl": "",
                "sEmptyTable": "表中数据为空",
                "sLoadingRecords": "载入中...",
                "sInfoThousands": ",",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "上页",
                    "sNext": "下页",
                    "sLast": "末页"
                },
                "oAria": {
                    "sSortAscending": ": 以升序排列此列",
                    "sSortDescending": ": 以降序排列此列"
                }
            }
        });
    });
</script>

</html>