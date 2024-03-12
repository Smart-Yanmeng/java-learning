<%--
  Created by IntelliJ IDEA.
  User: 星时代曹波涛
  Date: 2020/10/13
  Time: 16:58
  To change this template use File | Settings | File Templates.
  购买页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>沃尔玛购买</title>
    <%@include file="../components/codesnippet/basecssandscript.jsp"%>
</head>
<body>
<%--顶部信息--%>
<%@include file="/components/layouts/top.jsp" %>
<div class="container">
    <div class="row mb-5">
        <div class="col-5">
            <img src="${pageContext.request.contextPath}/static/img/logo.jpg" class="img-fluid"
                 style="height: 100px;" alt="">
            <span class="text-danger" style="font-family: 华文新魏;font-size: 30px;vertical-align: center">提交订单</span>
        </div>
        <div class="col-7"></div>
    </div>

    <div class="row border-bottom">
        <span>填写收货地址</span>
    </div>
    <br>
    <br>
    <br>
    <div class="row border-bottom mt-2">
        <span>确认订单信息</span>
    </div>
    <div class="row">
        <div class="col-6 offset-6 border" style="height: 200px;">
                -
        </div>
    </div>
    <div class="row">
        <div class="col-6 offset-6 mt-21`    text-right">
            <button class="btn btn-danger">提交订单</button>
        </div>
    </div>

</div>

</body>
</html>