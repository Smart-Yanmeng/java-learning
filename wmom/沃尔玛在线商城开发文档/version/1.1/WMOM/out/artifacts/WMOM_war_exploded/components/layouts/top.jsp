<%--
  Created by IntelliJ IDEA.
  User: 星时代曹波涛
  Date: 2020/10/12
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<div class="container-fluid top">
    <div class="container">
        <ul class="list-unstyled d-flex justify-content-end">
            <li><a href="${pageContext.request.contextPath}/managerlogin.jsp">立即登录</a></li>
            <li><a href="javascript:void(0);">我的订单</a></li>
            <li><a href="${pageContext.request.contextPath}/user/cart.jsp">我的购物车</a></li>
            <li><a href="${pageContext.request.contextPath}/">网站首页</a></li>
            <li><a href="${pageContext.request.contextPath}/managerlogin.jsp">后台登录</a></li>
        </ul>
    </div>
</div>