<%--
  Created by IntelliJ IDEA.
  User: 星时代曹波涛
  Date: 2020/10/20
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html class="x-admin-sm">

<head>
    <meta charset="UTF-8">
    <title>订单列表</title>
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
</head>

<body>
<div class="x-nav">
            <span class="layui-breadcrumb">
                <a href="">首页</a>
                <a href="">演示</a>
                <a>
                    <cite>导航元素</cite></a>
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
                <div class="layui-card-body ">
                    <form class="layui-form layui-col-space5">
                        <div class="layui-input-inline layui-show-xs-block">
                            <select name="contrller">
                                <option value="">订单状态</option>
                                <option value="0">待发货</option>
                                <option value="1">运送中</option>
                                <option value="2">已收货</option>
                            </select>
                        </div>
                    </form>
                </div>
                <div class="layui-card-header">
                    <button class="layui-btn layui-btn-danger" onclick="delAll()">
                        <i class="layui-icon"></i>批量删除
                    </button>
                    <button class="layui-btn" onclick="xadmin.open('添加用户','./order-add.html',800,600)">
                        <i class="layui-icon"></i>添加
                    </button>
                </div>
                <div class="layui-card-body ">
                    <table class="layui-table layui-form" id="myTable">
                        <thead>
                        <tr>
                        <tr>
                            <th>排序</th>
                            <th>订单号</th>
                            <th>数量</th>
                            <th>订单状态</th>
                            <th>物流状态</th>
                            <th>收货地址</th>
                            <th style="text-align: center;">操作</th>
                        </tr>

                        </tr>
                        </thead>
                        <tbody>

                        <c:forEach items="${requestScope.orders}" var="order" varStatus="obj">
                            <tr>
                                <td>${obj.index+1}</td>
                                <td>${order.id}</td>
                                <td>${order.number}</td>
                                <td style="text-align: center;">
                                <c:if test="${not empty order.deleted}">
                                    订单已失效
                                </c:if>
                                </td>
                                <td style="text-align: center;">
                                    <c:if test="${order.status==0}">
                                        <span style="color: red">待发货</span>
                                    </c:if>
                                    <c:if test="${order.status==1}">
                                        运送中
                                    </c:if>
                                    <c:if test="${order.status==2}">
                                        <span style="color: #ffba3b">订单已完成</span>
                                    </c:if>
                                </td>

                                <td>${order.addr}</td>
                                <td class="td-manage" style="text-align: center;">
                                    <a title="查看" onclick="xadmin.open('发票','/admin/order/getOrderById?id=${order.id}')"
                                       href="javascript:;">详情 |</a>
                                    <c:if test="${order.status==0}">
                                        <a title="发货"
                                           onclick="fahuo('${order.id}')"
                                           href="javascript:;">
                                            发货
                                        </a>
                                    </c:if>
                                    <c:if test="${order.status==1 or order.status==2}">
                                        <a title="售后"
                                           onclick="xadmin.open('售后','/')"
                                           href="javascript:;">
                                            售后
                                        </a>
                                    </c:if>
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

    /*用户-停用*/
    function member_stop(obj, id) {
        layer.confirm('确认要停用吗？',
            function (index) {

                if ($(obj).attr('title') == '启用') {

                    //发异步把用户状态进行更改
                    $(obj).attr('title', '停用');
                    $(obj).find('i').html('&#xe62f;');

                    $(obj).parents("tr").find(".td-status").find('span').addClass('layui-btn-disabled').html('已停用');
                    layer.msg('已停用!', {
                        icon: 5,
                        time: 1000
                    });

                } else {
                    $(obj).attr('title', '启用');
                    $(obj).find('i').html('&#xe601;');

                    $(obj).parents("tr").find(".td-status").find('span').removeClass('layui-btn-disabled').html('已启用');
                    layer.msg('已启用!', {
                        icon: 5,
                        time: 1000
                    });
                }

            });
    }

    /*用户-删除*/
    function member_del(obj, id) {
        layer.confirm('确认要删除吗？',
            function (index) {
                //发异步删除数据
                $(obj).parents("tr").remove();
                layer.msg('已删除!', {
                    icon: 1,
                    time: 1000
                });
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

    function fahuo(id) {
        $.get("/admin/order/send", {id}, function (d) {
            if (d.status === 200) {
                layer.msg("发货成功！");
            } else {
                layer.msg("发货失败！");
            }
            setTimeout(function () {
                location.reload();
            }, 2000);

        })
    }
</script>

</html>