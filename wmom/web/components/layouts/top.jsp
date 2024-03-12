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
            <li>
                <c:if test="${empty sessionScope.user}">
                    <a href="${pageContext.request.contextPath}/userlogin.jsp" style="color: red!important;">欢迎你：请登录</a>
                    &nbsp;
                    <i class="fa fa-ravelry" aria-hidden="true"></i>
                    <a href="${pageContext.request.contextPath}/regist.jsp" target="_blank">立即注册</a>
                </c:if>
                <c:if test="${not empty sessionScope.user}"><a href="javascript:void(0);">欢迎你：</a>
                    <a href="javascript:void(0);"
                       style="color: #ff6b31!important;margin: 0!important;">${sessionScope.user.name}</a>
                    &nbsp;
                    <a href="javascript:void(0);" onclick="exit()" style="margin: 0!important;">退出登录</a>
                    &emsp;
                </c:if>
            </li>
            &nbsp;&nbsp;
            <li>
                <i class="fa fa-user-o" aria-hidden="true"></i>
                <a href="${pageContext.request.contextPath}/user/mywalmart.jsp">我的沃尔玛</a>
            </li>
            &nbsp;&nbsp;
            <li>
                <i class="fa fa-list-ul" aria-hidden="true"></i>
                <a href="${pageContext.request.contextPath}/order/getOrdersByUserId">我的订单</a>
            </li>
            &nbsp; &nbsp;
            <li>
                <i class="fa fa-shopping-cart" style="color: red" aria-hidden="true"></i>
                <a href="${pageContext.request.contextPath}/cart/mycart">我的购物车</a>
            </li>
            &nbsp;&nbsp;
            <li>
                <i class="fa fa-comments-o" aria-hidden="true" style="color: green"></i>
                <a href="javascript：void(0);" data-toggle="modal" data-target="#myModal">联系客服</a>
            </li>
            &nbsp;&nbsp;
            <li>
                <i class="fa fa-navicon" aria-hidden="true"></i>
                <a href="${pageContext.request.contextPath}/">网站导航</a>
            </li>
        </ul>
    </div>
</div>

<!-- 模态框 -->
<div class="modal fade" id="myModal">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- 模态框头部 -->
            <div class="modal-header">
                <h4 class="modal-title">联系客服</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>

            <!-- 模态框主体 -->
            <div class="modal-body">
               TEL:150-826-73710
            </div>

            <!-- 模态框底部 -->
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
            </div>

        </div>
    </div>
</div>
<script>
    function exit() {
        layer.confirm('你确定要退出嘛？', {
            btn: ['确定', '点错了'] //按钮
        }, function () {
            location.href = "${pageContext.request.contextPath}/logout";
        }, function () {
            layer.msg("别乱点哦！")
        });
    }
</script>