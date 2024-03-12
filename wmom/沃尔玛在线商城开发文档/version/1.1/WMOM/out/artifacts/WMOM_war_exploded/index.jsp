<%@ page import="com.botao.service.impl.ProductServiceImpl" %>
<%@ page import="com.botao.service.ProductService" %>
<%@ page import="com.botao.pojo.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: 星时代曹波涛
  Date: 2020/10/11
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>沃尔玛在线商城</title>
    <%--引入公共样式--%>
    <%@include file="./components/codesnippet/basecssandscript.jsp" %>
    <script src="${pageContext.request.contextPath}/static/js/index.js" charset="UTF-8"></script>
</head>
<body>

<div class="container-fluid m-0 p-0"><img src="${pageContext.request.contextPath}/static/img/bannertop.png"
                                          class="img-fluid" alt="?"></div>
<%--顶部信息--%>
<%@include file="./components/layouts/top.jsp" %>
<%--logo和搜索框--%>
<%@include file="./components/layouts/search.jsp" %>
<%--轮播和导航--%>
<div class="container mt-3 fs">
    <div class="row">
        <div class="col-2 m-0 p-0 left-nav">
            <ul class="list-unstyled">
                <li>女装/女包</li>
                <li>手机/电脑/数码</li>
                <li>腕表/项链/耳环</li>
                <li>图书/报刊/文学</li>
                <li>快餐/中餐/西餐</li>
                <li>零食/小吃/美食</li>
                <li>家具/家装/厨具</li>
                <li>饮料/红酒/白酒</li>
                <li>医药/卫生</li>
                <li>文具/铅笔/钢笔</li>
                <li>情侣/套餐/主题</li>
                <li>特产/代购</li>
                <li>拼兮兮</li>
                <li>机票/酒店</li>
                <li>生鲜水果</li>
                <li>鲜花/绿植</li>
            </ul>
        </div>
        <%--中间轮播--%>
        <div class="col-7 in">
            <div id="c-one" class="carousel slide c-one" data-ride="carousel">
                <!-- 指示符 -->
                <ul class="carousel-indicators">
                    <li data-target="#c-one" data-slide-to="0" class="active"></li>
                    <li data-target="#c-one" data-slide-to="1"></li>
                    <li data-target="#c-one" data-slide-to="2"></li>
                </ul>

                <!-- 轮播图片 -->
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="${pageContext.request.contextPath}/static/img/c1.jpg">
                    </div>
                    <div class="carousel-item">
                        <img src="${pageContext.request.contextPath}/static/img/c2.jpg">

                    </div>
                    <div class="carousel-item">
                        <img src="${pageContext.request.contextPath}/static/img/c3.jpg">

                    </div>
                </div>

                <!-- 左右切换按钮 -->
                <a class="carousel-control-prev" href="#c-one" data-slide="prev">
                    <span class="carousel-control-prev-icon"></span>
                </a>
                <a class="carousel-control-next" href="#c-one" data-slide="next">
                    <span class="carousel-control-next-icon"></span>
                </a>

            </div>
            <%@include file="/components/codesnippet/navitem.jsp" %>
        </div>
        <div class="col-3 right-self p-0">
            <div class="top border">
                <div class="touxiang border"><img src="/static/img/user.jpg" class="ww" alt=""></div>
                <p class="text-center">Hi! 客户！</p>
                <table class="w-100 text-light text-center">
                    <tr class="text-danger">
                        <td>0</td>
                        <td>0</td>
                        <td>0</td>
                        <td>0</td>
                    </tr>
                    <tr class="text-muted" style="font-size: 12px;">
                        <td>待收货</td>
                        <td>待发货</td>
                        <td>待付款</td>
                        <td>待评价</td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</div>


<%--秒杀和小轮播--%>
<div class="container mt-5 ms">
    <div class="row tp-1">
        <div class="col-2" onclick="window.open('managerlogin.jsp','_blank')">
            <p class="mt-2 mb-0 pb-0">拍卖</p>
            <p class="text-muted my-0" style="font-size: 12px;">1元起拍捡漏</p>
            <div class="img-show">
                <img src="${pageContext.request.contextPath}/static/img/watch.png" class="ww" alt="">
            </div>
        </div>
        <div class="col-2" onclick="window.open('managerlogin.jsp','_blank')">
            <p class="mt-2 mb-0 pb-0">淘小铺</p>
            <p class="text-muted my-0" style="font-size: 12px;">每月多赚1000元</p>
            <div class="img-show">
                <img src="${pageContext.request.contextPath}/static/img/normal1.jpg" class="ww" alt="">
            </div>
        </div>
        <div class="col-2" onclick="window.open('managerlogin.jsp','_blank')">
            <p class="mt-2 mb-0 pb-0">造点新货</p>
            <p class="text-muted my-0" style="font-size: 12px;">全球创意众筹平台</p>
            <div class="img-show">
                <img src="${pageContext.request.contextPath}/static/img/dpc.png" class="ww" alt="">
            </div>
        </div>
        <div class="col-2" onclick="window.open('managerlogin.jsp','_blank')">
            <p class="mt-2 mb-0 pb-0">淘宝心选</p>
            <p class="text-muted my-0" style="font-size: 12px;">美好而有用</p>
            <div class="img-show">
                <img src="${pageContext.request.contextPath}/static/img/xiangzi.png" class="ww" alt="">
            </div>
        </div>
        <div class="col-4">
            <img style="width: 100%;height: 195px;display: block;margin: 0 auto;"
                 src="${pageContext.request.contextPath}/static/img/xpfb.jpg" alt="">
        </div>
    </div>
    <div class="row mt-2 tp-2">
        <div class="col-4 ms-left">
            <h4 class="text-center py-3" style="color:yellow;">秒 杀</h4>
            <p class="text-center py-3" style="font-size: 26px;" id="ms-time"></p>
        </div>
        <div class="col-6 ms-c">
            <img src="${pageContext.request.contextPath}/static/img/bushui.png" style="width: 100%;height: 200px;" alt="">
        </div>
        <div class="col-2" style="background-color:#ffffff;">
            <img src="${pageContext.request.contextPath}/static/img/bed.png" class="img-fluid img-thumbnail" style="width: 100%;height: 200px;" alt="">
        </div>
    </div>
    <div class="row mt-2 ms-bottom" style="background-color:#ffffff;">
        <div class="col-4" onclick="window.open('managerlogin.jsp','_blank')">
            <img src="${pageContext.request.contextPath}/static/img/ms1.jpg" alt="">
        </div>
        <div class="col-4" onclick="window.open('managerlogin.jsp','_blank')">
            <img src="${pageContext.request.contextPath}/static/img/ms2.jpg" alt="">
        </div>
        <div class="col-4" onclick="window.open('managerlogin.jsp','_blank')">
            <img src="${pageContext.request.contextPath}/static/img/ms3.jpg" alt="">
        </div>

    </div>
</div>
<div class="container mt-3">
    <div class="row">
        <div class="col-12 p-0 m-0">
            <img src="${pageContext.request.contextPath}/static/img/bannercenter.jpg" class="ww" alt="">
        </div>
    </div>
</div>
<%--商品列表--%>
<div class="container commodity mt-3 p-0">
    <%
        ProductService productService = new ProductServiceImpl();
        List<Product> allProducts = null;
        try {
            allProducts = productService.getAllProductsExceptDeleted();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        pageContext.setAttribute("products", allProducts);
    %>
        <c:forEach items="${pageScope.products}" var="product">
            <div class="item" onclick="window.open('${pageContext.request.contextPath}/open/product/getproductbyid?id=${product.id}','_blank')">
                <div class="top-img border-bottom">
                    <img src="/upload/${product.img}" class="img-fluid">
                </div>
                <div class="bottom">
                    <h3 class="text-danger pb-0 mb-0">￥${product.price}</h3>
                    <div style="height: 78px;overflow: hidden;">
                        <p class="text-muted py-0 desc">${product.desc}</p>
                        <p class="text-muted text-right py-0">月销:18 | 评价:366</p>
                    </div>
                    <a href="${pageContext.request.contextPath}/open/product/getproductbyid?id=${product.id}"
                       class="btn btn-sm btn-outline-warning mr-4"
                       target="_blank">商品详情</a>
                    <a href="./user/cart.jsp?id=${product.id}" class="btn btn-sm btn-outline-danger">加入购物车</a>
                </div>
            </div>
        </c:forEach>
</div>
<div class="container">
    <img src="${pageContext.request.contextPath}/static/img/sanbao.png" class="img-fluid">
</div>
<%@include file="./components/layouts/footer.jsp" %>
</body>
</html>