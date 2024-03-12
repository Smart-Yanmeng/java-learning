<%--
  Created by IntelliJ IDEA.
  User: 星时代曹波涛
  Date: 2020/10/30
  Time: 0:40
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
            <a href="${pageContext.request.contextPath}/user/mywalmart.jsp">全部功能</a>
            <a href="${pageContext.request.contextPath}/cart/mycart">我的购物车</a>
            <a href="${pageContext.request.contextPath}/order/getOrdersByUserId">我的订单</a>
            <a href="${pageContext.request.contextPath}/order/getOrdersByUserId" class="active">评价管理</a>
            <a href="">退款维权</a>
            <a href="./setup.jsp">账户设置</a>
        </div>
        <div class="col-6 center">
            <div class="w-100 title">
                <i class="fa fa-user-o" aria-hidden="true"></i>
                <span>商品评论</span>
            </div>
            <div class="container-fluid mb-3 zlxg">
                <div class="row">
                    <div class="col-12">
                        <form>
                            <input type="hidden" id="productid" value="${param.productid}">
                            <div class="form-group">
                                <label for="comment"></label>
                                <textarea class="form-control" rows="5" id="comment"></textarea>
                            </div>
                        </form>
                    </div>
                </div>

                <div class="row">
                    <div class="col-12">
                        <button class="btn btn-success btn-block" onclick="pl()">提交</button>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="/components/layouts/userright.jsp" %>
    </div>
</div>
<%@include file="/components/layouts/footer.jsp" %>
<script>
    function pl() {
        let productid = $("#productid").val();
        let text = $("#comment").val();
        if (text.length == 0 || text.length > 200) {
            return false;
        } else {
            //发送异步
            $.post("/client/add", {
                productid,
                text
            }, function (d) {
                if (d.status === 200) {
                    layer.msg("评论成功！")
                } else {
                    layer.msg("评论成功！")
                }
            })


        }
    }
</script>
</body>
</html>