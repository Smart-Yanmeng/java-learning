<%--
  Created by IntelliJ IDEA.
  User: 星时代曹波涛
  Date: 2020/10/20
  Time: 23:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>详细订单</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.css">
</head>
<body>
<div class="container">
<p class="mb-0 ml-4"><span class="text-danger">NO:</span>${requestScope.order.id}</p>
<h3 class="mt-3 text-muted text-center">沃尔玛增值税发票</h3>
<div class="text-center m-auto mb-1" style="position: relative;top: -55px;z-index: -1;">
    <img src="/static/img/fp.png" style="width: 110px;height: 65px;">
</div>
</div>
<div class="container" style="margin-top: -37px;">
    <div class="row">
        <div class="col-12">
            <table class="table table-bordered">
                <tbody>
                <tr>
                    <td>商品名称: ${requestScope.product.name}</td>
                    <td>下单时间: ${requestScope.order.created}</td>
                </tr>
                <tr>
                    <td>订单号: ${requestScope.order.id}</td>
                    <td>客户名: ${requestScope.user.name}</td>
                </tr>
                <tr>
                    <td>商品编号: ${requestScope.product.id}</td>
                    <td>服务商: 沃尔玛责任股份有限公司</td>
                </tr>
                <tr>
                    <td>商品单价: ${requestScope.product.price}</td>
                    <td>数量: ${requestScope.order.number}</td>
                </tr>
                <tr>
                    <td>联系电话: ${requestScope.user.phone}</td>
                    <td>收货地址: ${requestScope.order.addr}</td>
                </tr>
                <tr>
                    <td>商品图片: <img src="/upload/${requestScope.product.img}" style="width: 50px;height: 50px;" alt=""></td>
                    <td> 状态:
                        <c:if test="${requestScope.order.status==0}">
                            待发货
                        </c:if>
                        <c:if test="${requestScope.order.status==1}">
                            运送中
                        </c:if>
                        <c:if test="${requestScope.order.status==2}">
                            订单已完成
                        </c:if></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>