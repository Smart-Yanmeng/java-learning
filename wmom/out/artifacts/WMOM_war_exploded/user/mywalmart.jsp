<%--
  Created by IntelliJ IDEA.
  User: 星时代曹波涛
  Date: 2020/10/17
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>个人资料</title>
    <%--引入公共样式--%>
    <%@include file="/components/codesnippet/basecssandscript.jsp" %>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/mywalmart.css">
</head>
<body>
<%--顶部信息--%>
<%@include file="/components/layouts/top.jsp" %>
<div class="container-fluid" style="background-color:#ff4401;">
    <div class="container">
        <div class="row">
            <div class="col-5">
                <span style="user-select:none; color: white; font-family: 华文新魏;font-size: 30px;display: block; padding: 15px 0;">我的沃尔玛</span>
            </div>
            <div class="col-7"></div>
        </div>
    </div>
</div>

<div class="container mt-3 wrap">
    <div class="row">
        <div class="col-2 border-right-0 left">
            <a href="" class="active">全部功能</a>
            <a href="${pageContext.request.contextPath}/cart/mycart">我的购物车</a>
            <a href="${pageContext.request.contextPath}/order/getOrdersByUserId">我的订单</a>
            <a href="${pageContext.request.contextPath}/order/getOrdersByUserId">评价管理</a>
            <a href="">退款维权</a>
            <a href="./setup.jsp">账户设置</a>
        </div>
        <div class="col-6 center">

            <div class="grzl my-2">
                <table class="w-100 text-light table-bordered">
                    <tr class="text-muted" style="font-size: 12px;">
                        <td colspan="4" class="clearfix">
                            <div class="head float-left">
                                <img src="${sessionScope.user.head}" alt="">
                            </div>
                            <div class="float-left">
                                <h6 class="mt-2 ml-3">${sessionScope.user.name}</h6>
                            </div>
                            <div class="float-right mt-3">
                                <a href="" style="vertical-align: center;" class="text-decoration-none text-muted">我的收货地址</a>
                            </div>
                        </td>
                    </tr>
                    <tr class="text-muted f" style="font-size: 12px;">
                        <td>待收货</td>
                        <td>待发货</td>
                        <td>待付款</td>
                        <td>待评价</td>
                    </tr>
                </table>
            </div>

            <div class="w-100 title">
                <i class="fa fa-user-o" aria-hidden="true"></i>
                <span>个人资料</span>
            </div>

            <div class="grzl clearfix">
                <a href="/user/setup.jsp" style="font-size: 12px;float: right;">修改个人信息</a>
                <table class="table text-muted text-center" style="font-size: 12px;">
                    <tr>
                        <td>登录名</td>
                        <td>${sessionScope.user.username}</td>
                        <td>昵称</td>
                        <td>${sessionScope.user.name}</td>
                    </tr>

                    <tr>
                        <td>手机号</td>
                        <td>
                            <c:if test="${sessionScope.user.phone==0}">
                                暂未设置
                            </c:if>
                            <c:if test="${sessionScope.user.phone!=0}">
                                ${sessionScope.user.phone}
                            </c:if>
                        </td>
                        <td>状态</td>
                        <td>
                            <c:if test="${sessionScope.user.status==1}">
                                启用
                            </c:if>
                            <c:if test="${sessionScope.user.status==0}">
                                禁用
                            </c:if>
                        </td>
                    </tr>
                    <tr>
                        <td>收货地址</td>
                        <td colspan="3">${sessionScope.user.addr}</td>
                    </tr>
                </table>
            </div>
            <div class="w-100 mb-3 title">
                <i class="fa fa-truck" aria-hidden="true"></i>
                <span>我的物流</span>
            </div>

            <div class="w-100 title">
                <i class="fa fa-user-o" aria-hidden="true"></i>
                <span>其他设置</span>
            </div>

        </div>
        <%@include file="/components/layouts/userright.jsp" %>
    </div>
</div>
<%@include file="/components/layouts/footer.jsp" %>

</body>
</html>