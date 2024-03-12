<%--
  Created by IntelliJ IDEA.
  User: 星时代曹波涛
  Date: 2020/10/18
  Time: 17:17
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
            <a href="${pageContext.request.contextPath}/order/getOrdersByUserId">评价管理</a>
            <a href="">退款维权</a>
            <a href="./setup.jsp" class="active">账户设置</a>
        </div>
        <div class="col-6 center">
            <div class="w-100 title">
                <i class="fa fa-user-o" aria-hidden="true"></i>
                <span>账户设置</span>
            </div>
            <div class="mx-3 container-fluid mb-3 zlxg">
                <div class="row">
                    <div class="col-8">
                        <form>
                            <div class="form-inline my-1">
                                <label for="name">昵&emsp;称:</label>
                                <input type="text" class="form-control" id="name" value="${sessionScope.user.name}">
                            </div>
                            <div class="form-inline my-1">
                                <label for="username">用户名:</label>
                                <input type="text" class="form-control" id="username"
                                       value="${sessionScope.user.username}">
                            </div>
                            <div class="form-inline my-1">
                                <label for="password">密&emsp;码:</label>
                                <input type="password" class="form-control" id="password"
                                       value="${sessionScope.user.password}">
                            </div>
                            <div class="form-inline my-1">
                                <label for="phone">手机号:</label>
                                <input type="text" class="form-control" id="phone" value="${sessionScope.user.phone}">
                            </div>

                            <div class="form-inline my-1">
                                <label for="head">头&emsp;像:</label>
                                <input type="file" class="" id="head" onchange="imageUpload()">
                                <input type="hidden" id="imagedir" value="${sessionScope.user.head}">
                            </div>
                            <div class="form-inline">
                                <label for="addr">收货地址:</label>
                                <input type="text" class="form-control w-75" id="addr"
                                       value="${sessionScope.user.addr}">
                            </div>
                        </form>
                    </div>
                    <div class="col-4 tx">
                        <img src="${sessionScope.user.head}" class="img-fluid img-thumbnail" alt="无">
                        <p class="text-center text-muted mt-2">头 像</p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-3 mt-3">
                        <button class="btn btn-outline-dark btn-sm" onclick="update()">确定提交</button>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="/components/layouts/userright.jsp" %>
    </div>
</div>
<%@include file="/components/layouts/footer.jsp" %>
<script>
    //  user/*


    function imageUpload() {
        let formData = new FormData();
        formData.append("img", document.getElementById("head").files[0]);
        $.ajax({
            url: "/upload/img",
            type: "POST",
            data: formData,
            /**
             *必须false才会自动加上正确的Content-Type
             */
            contentType: false,
            /**
             * 必须false才会避开jQuery对 formdata 的默认处理
             * XMLHttpRequest会对 formdata 进行正确的处理
             */
            processData: false,
            success: data => {
                console.log(data)
                $("#imagedir").val(data.path);
                let vv = $("#imagedir").val();
                let path = "";
                path = "/upload/" + vv;

                $(".tx").children("img").attr("src", path)
            },
            error: function (data) {

            }
        });
    }

    function update() {

        let name = $("#name").val();
        let username = $("#username").val();
        let password = $("#password").val();
        let phone = $("#phone").val();
        let addr = $("#addr").val();

        let vd = $("#imagedir").val();
        let ts = /^\//;
        let imagedir = "";
        if (ts.test(vd)) {
            imagedir = vd;
        } else {
            imagedir = "/upload/" + vd;
        }
        if (name === "" || username === "" || password === "" || phone === "" || imagedir === "") {
            layer.msg("任何一项不能为空！", {icon: 5});
            return false;
        }
        let index = layer.load(1, {
            shade: [0.1, '#fff'] //0.1透明度的白色背景
        });
        $.post("/client/update", {
            name,
            username,
            password,
            phone,
            imagedir,
            addr
        }, data => {
            layer.close(index);
            console.log(data);
            if (data.status === 200) {
                layer.confirm(data.msg, {
                    btn: ['好的'] //按钮
                }, function () {
                    location.reload();
                });
            } else {
                layer.msg(data.msg);
            }
        });
    }
</script>
</body>
</html>