<%@ page import="com.botao.service.impl.ProductServiceImpl" %>
<%@ page import="com.botao.service.ProductService" %>
<%@ page import="com.botao.pojo.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.SQLException" %>
<%--
  Created by IntelliJ IDEA.
  User: 星时代曹波涛
  Date: 2020/10/18
  Time: 2:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>沃尔玛在线商城</title>
    <%--引入公共样式--%>
    <%@include file="./components/codesnippet/basecssandscript.jsp" %>
    <script src="${pageContext.request.contextPath}/static/js/index.js" charset="GBK"></script>
</head>
<body>

<div class="container-fluid m-0 p-0"><img src="${pageContext.request.contextPath}/static/img/bannertop.png"
                                          class="img-fluid" alt="?"></div>
<%--顶部信息--%>
<%@include file="./components/layouts/top.jsp" %>
<%--logo和搜索框--%>
<%@include file="./components/layouts/search.jsp" %>
<%--商品列表--%>
<c:if test="${empty requestScope.products}">
    <div class="container-fluid">
        <div class="row">
            <div class="col-12 bg-light py-5">
                <h4 class="text-center m-auto">没用搜索到该商品！</h4>
            </div>
        </div>
    </div>
</c:if>
<div class="container commodity mt-3 p-0">
    <c:forEach items="${requestScope.products}" var="product">
        <div class="item"
             onclick="window.open('${pageContext.request.contextPath}/open/product/getproductbyid?id=${product.id}','_blank')">
            <div class="top-img border-bottom">
                <img src="/upload/${product.img}" class="img-fluid" style="width: 100%;height: 100%;">
            </div>
            <div class="bottom">
                <h3 class="text-danger pb-0 mb-0">￥${product.price}</h3>
                <div style="height: 78px;overflow: hidden;">
                    <p class="text-muted py-0 desc">${product.name}</p>
                    <p class="text-muted text-right py-0">沃尔玛官方自营店</p>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
<%@include file="/components/layouts/footer.jsp" %>
</body>
</html>