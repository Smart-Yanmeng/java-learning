<%--
  Created by IntelliJ IDEA.
  User: 星时代曹波涛
  Date: 2020/10/13
  Time: 16:58
  To change this template use File | Settings | File Templates.
  购买页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>沃尔玛购买</title>
    <%@include file="../components/codesnippet/basecssandscript.jsp" %>
    <script src="${pageContext.request.contextPath}/static/js/distpicker.js" charset="UTF-8"></script>
</head>
<body>
<%--顶部信息--%>
<%@include file="/components/layouts/top.jsp" %>

<div class="container-fluid" style="background-color:#ff4401;">
    <div class="container">
        <div class="row">
            <div class="col-5">
                <span style="user-select:none; color: white; font-family: 华文新魏;font-size: 30px;display: block; padding: 15px 0;">订单列表</span>
            </div>
            <div class="col-7"></div>
        </div>
    </div>
</div>
<div class="container mt-3">
    <table class="table table-bordered" style="font-size: 14px;">
        <thead>
        <tr>
            <th>订单号</th>
            <th>数量</th>
            <th>物流状态</th>
            <th>下单时间</th>
            <th>收货地址</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${empty requestScope.orders}">
            <tr>
                <td colspan="4">
                    <h3 class="text-center text-muted m-5 p-5">订单还没有东西哦！</h3>
                </td>
            </tr>
        </c:if>
        <c:forEach items="${requestScope.orders}" var="order">
            <tr>
                <td>${order.id}</td>
                <td>${order.number}</td>

                <c:if test="${order.status==0}">
                <td class="text-danger">
                    待发货
                    </c:if>
                </td>
                <c:if test="${order.status==1}">
                    <td class="text-warning">
                        运送中
                    </td>
                </c:if>
                <c:if test="${order.status==2}">
                    <td class="text-success">
                        已收货
                    </td>
                </c:if>

                <td>${order.created}</td>
                <td>${order.addr}</td>
                <td>
                    <a class="btn btn-sm btn-outline-info" href="${pageContext.request.contextPath}/order/getfp?id=${order.id}" target="_blank">查看</a>
                    <c:if test="${order.status==0}">
                        <a class="btn btn-sm btn-outline-dark" onclick="ccfh()" href="javascript:void(0);">催促发货</a>
                        <a class="btn btn-sm btn-outline-danger" onclick="deleted('${order.id}')"
                           href="javascript:void(0);">取消订单</a>
                    </c:if>
                    <c:if test="${order.status==1}">
                        <a class="btn btn-sm btn-outline-warning" href="${pageContext.request.contextPath}/order/getfp?id=${order.id}">查看物流</a>
                        <a class="btn btn-sm btn-outline-success" onclick="shouhuo('${order.id}')">确认收货</a>
                    </c:if>
                    <c:if test="${order.status==2}">
                        <a class="btn btn-sm btn-outline-danger" href="">售后服务</a>
                        <a class="btn btn-sm btn-outline-info" href="${pageContext.request.contextPath}/user/comment.jsp?productid=${order.productid}">商品评价</a>
                    </c:if>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
    <div class="row">
        <div class="col-6 offset-6 border" style="height: 100px;">
            <p>货到付款，不满意，直接拒收！</p>
        </div>
    </div>
</div>
<%@include file="/components/layouts/footer.jsp" %>

<script>
    function shouhuo(id) {
        $.get("/order/getProduct", {id}, function (d) {
            if (d.status == 200) {
                layer.msg("收货成功！")
            } else {
                layer.msg("请稍后再试试！");
            }
            location.reload();
        })
    }

    function ccfh() {
        layer.msg("催促成功，请耐心等待！")
    }

    function deleted(id) {
        layer.confirm('你确定要取消订单吗？', {
            btn: ['确定', '取消'] //按钮
        }, function () {

            $.post("/order/deleted", {id}, function (data) {
                if (data.status === 200) {
                    layer.msg("取消订单成功！")
                } else {
                    layer.msg("取消订单失败！")
                }
                setTimeout(function () {
                    location.reload();
                },2000)
            })
        }, function () {
            layer.msg("取消！")
        });


    }
</script>
</body>
</html>