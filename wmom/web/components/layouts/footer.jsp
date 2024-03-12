<%--
  Created by IntelliJ IDEA.
  User: 星时代曹波涛
  Date: 2020/10/13
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <img src="${pageContext.request.contextPath}/static/img/sanbao.png" class="img-fluid">
</div>
<footer class="mt-2 container-fluid">
    <div class="container text-center text-muted">
        <div class="mb-2">
            <a href="javascript:void(0);" class="text-muted"  data-toggle="modal" data-target="#myModal">联系客服</a>
            <a href="${pageContext.request.contextPath}/regist.jsp" class="text-muted">注册账号</a>
            <a href="${pageContext.request.contextPath}/" class="text-muted">网站首页</a>
            <a href="${pageContext.request.contextPath}/managerlogin.jsp" class="text-muted">后台登录</a>
        </div>
        <div>
            <p class="mb-2">总部热线电话：010-58789789 &emsp;010-445789415</p>
            <p class="mb-2">沃尔玛总部地址：四川省广安市广安区滨江东路98号</p>
            <p class="mb-2">版权所有，翻版必究（本网站仅供个人学习交流！如有不妥，请联系删除！）</p>
        </div>
        <div>
            <p class="text-center my-3">Copyright © 2013-2020 沃尔玛 wolmart.com All Rights Reserved.
            备案号：备2004546807号-4561</p>
        </div>
    </div>
</footer>