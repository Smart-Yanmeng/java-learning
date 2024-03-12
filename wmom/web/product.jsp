<%--
  Created by IntelliJ IDEA.
  User: 星时代曹波涛
  Date: 2020/10/12
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>沃尔玛在线商城</title>
    <%--引入公共样式--%>
    <%@include file="./components/codesnippet/basecssandscript.jsp" %>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/product.css">
</head>
<body>

<%--顶部信息--%>
<%@include file="/components/layouts/top.jsp" %>
<%--logo和搜索框--%>
<%@include file="/components/layouts/search.jsp" %>


<div class="container comm-main">
    <div class="row">
        <div class="col-5">
            <div class="comm-img">
                <img src="/upload/${requestScope.product.img}"
                     class="img-fluid img-thumbnail" alt="">
            </div>
        </div>
        <div class="col-5 comm-center p-3 border-left">
            <h6 class="mb-4">${requestScope.product.name}</h6>
            <table>
                <tr class="text-muted text-center border-top border-bottom" style="font-size: 12px;">
                    <td class="border-right my-1" style="width: 100px;">销 量: ${requestScope.num1}</td>
                    <td class="border-right my-1" style="width: 180px;">评 价:  ${requestScope.num2}</td>
                    <td class="my-1" style="width: 100px;">积 分: 50</td>
                </tr>
                <tr>
                    <td>价 格:</td>
                    <td style="font-size: 24px;">￥ &nbsp; <span
                            class="text-danger p-0 m-0">${requestScope.product.price}</span></td>
                    <td></td>
                </tr>
                <tr>
                    <td>数 量:</td>
                    <td>
                        <%@include file="/components/count.jsp" %>
                    </td>
                    <td>
                        <span class="text-muted" style="font-size: 12px;">库存 ${requestScope.product.stock} 件</span>
                    </td>
                </tr>

            </table>
            <div class="mt-5" style="user-select: none;">
                <button onclick="buy('${requestScope.product.id}')"
                        class="" id="buy"
                        style="border: none;outline: none;"
                >立即购买
                </button>
                <button id="join" style="border: none;outline: none;" onclick="join('${requestScope.product.id}')">
                    <img src="${pageContext.request.contextPath}/static/img/gwc.png">
                    加入购物车
                </button>
            </div>
        </div>
        <div class="col-2 border-left right-banner">
            <img src="/static/img/pb1.jpg" alt=""
                 class="ww img-thumbnail">
        </div>
    </div>
</div>

<div class="container pl">
    <div class="row border-bottom">
        <h4 class="text-muted my-3 ml-5">商品评论</h4>
    </div>
    <div class="row mt-2">
        <div class="col-12">
            <ul class="list-group w-100">
                <c:forEach items="${requestScope.comments}" var="comment">
                    <li class="list-group-item">
                        <div class="text-muted">
                                <span class="text-danger">${comment.username}</span>&nbsp;评论说:${comment.text}
                        </div>
                        <p class="text-right mb-0"> ${comment.created}</p>
                    </li>
                </c:forEach>
            </ul>
        </div>

    </div>
</div>
<%@include file="./components/layouts/footer.jsp" %>
<script>

    function buy(productid) {
        let number = $(".count-value").val();
        if ("${sessionScope.user}" === "") {
            layer.msg("请先登录！")
            return false;
        }
        let index = layer.load(1, {
            shade: [0.3, '#fff'] //0.1透明度的白色背景
        });
        $.post("/order/addone", {
            productid,
            number
        }, data => {
            layer.close(index)
            if (data.status === 200) {
                layer.msg("购买成功！")
                location.href = "/order/getOrdersByUserId"
            } else {
                layer.msg("购买失败！")
            }
        })
    }


    function join(id) {
        if ("${sessionScope.user}" === "") {
            layer.msg("请先登录！")
            return false;
        }
        let index = layer.load(1, {
            shade: [0.3, '#fff'] //0.1透明度的白色背景
        });
        $.post("/cart/add", {
            id
        }, data => {
            layer.close(index)
            if (data.status === 200) {
                layer.msg("加入成功！")
            } else {
                layer.msg("加入失败！")
            }
        })
    }

    $(function () {
        let i = [
            "/static/img/pb1.jpg",
            "/static/img/pb2.jpg",
            "/static/img/pb3.jpg",
            "/static/img/pb4.jpg",
        ];
        let m = Math.floor(Math.random() * 4);
        $(".right-banner").children("img").attr("src", i[m])
    })
</script>
</body>
</html>