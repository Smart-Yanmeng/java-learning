<%--
  Created by IntelliJ IDEA.
  User: 星时代曹波涛
  Date: 2020/10/18
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html class="x-admin-sm">

<head>
    <meta charset="UTF-8">
    <title>商品添加</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/admin/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/admin/css/xadmin.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/admin/lib/layui/layui.js"
            charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/admin/js/xadmin.js"></script>
    <script src="${pageContext.request.contextPath}/static/layer/layer.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row">
        <form class="layui-form">
            <div class="layui-form-item">
                <label for="name" class="layui-form-label">
                    <span class="x-red">*</span>商品名称</label>
                <div class="layui-input-inline">
                    <input type="text" id="name" autocomplete="off" class="layui-input"
                           value="${requestScope.product.name}"></div>
                <div class="layui-form-mid layui-word-aux">
                    <span class="x-red"></span></div>
            </div>
            <div class="layui-form-item">
                <label for="desc" class="layui-form-label">
                    <span class="x-red">*</span>商品描述</label>
                <div class="layui-input-inline">
                    <input type="text" id="desc" autocomplete="off" class="layui-input"
                           value="${requestScope.product.desc}"></div>
            </div>
            <div class="layui-form-item">
                <label for="price" class="layui-form-label">
                    <span class="x-red">*</span>商品价格</label>
                <div class="layui-input-inline">
                    <input type="text" id="price" autocomplete="off" class="layui-input"
                           value="${requestScope.product.price}"></div>
            </div>
            <div class="layui-form-item">
                <label for="stock" class="layui-form-label">
                    <span class="x-red">*</span>商品库存</label>
                <div class="layui-input-inline">
                    <input type="text" id="stock" autocomplete="off" class="layui-input"
                           value="${requestScope.product.stock}"></div>
            </div>

            <div class="layui-form-item">
                <label for="image" class="layui-form-label">
                    <span class="x-red">*</span>商品图片</label>
                <div class="layui-input-inline">
                    <input type="file" id="image" name="image" onchange="imageUpload()" autocomplete="off">
                    <input type="hidden" id="imagedir" value="${requestScope.product.img}">
                    <div id="upimg"
                         style="border: 1px solid darkgray;margin-top: 15px; text-align: center;padding: 15px;">
                        <img src="/upload/${requestScope.product.img}" alt="待上传！" style="width: 150px;height: 150px;">
                    </div>
                </div>
            </div>

        </form>
        <div style="margin-left: 115px;">
            <button class="layui-btn" id="add" name="add" onclick="update()">修改</button>
        </div>
    </div>
</div>
<script>
    function imageUpload() {
        let formData = new FormData();
        formData.append("img", document.getElementById("image").files[0]);
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
                console.log("图路径:" + $("#imagedir").val());
                let path = "/upload/" + ($("#imagedir").val());
                $("#upimg").children("img").attr("src", path)
            },
            error: data => {

            }
        });
    }

    function update() {
        let index = layer.load(1, {
            shade: [0.3, '#fff'] //0.1透明度的白色背景
        });
        let name = $("#name").val();
        let desc = $("#desc").val();
        let price = $("#price").val();
        let stock = $("#stock").val();
        let img = $("#imagedir").val();
        if (name === "" || desc === "") {
            layer.msg("请输入！");
            return false;
        }
        let isNum = /^[0-9]*$ /;

        if (isNum.test(price) || isNum.test(stock) || stock < 0 || price < 0) {
            layer.msg("价格或者库存有误！！");
            return false;
        }
        $.post("/admin/product/update", {
            id: "${requestScope.product.id}",
            name,
            desc,
            price,
            stock,
            img,
        }, data => {
            layer.close(index);
            console.log(data.status)
            if (data.status === 200) {
                layer.msg("商品修改成功！");
                location.reload();
            } else {
                layer.msg("商品修改失败！");
            }
        })
    }
</script>
</body>
</html>