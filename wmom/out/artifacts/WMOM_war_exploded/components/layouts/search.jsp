<%--
  Created by IntelliJ IDEA.
  User: 星时代曹波涛
  Date: 2020/10/12
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-fluid search">
    <div class="container">
        <div class="row">
            <div class="col-3 logo border-info overflow-hidden">
                <img src="${pageContext.request.contextPath}/static/img/logo.jpg" class="img-fluid"
                     style="height: 140px;transform: scale(1.3);" alt="">
            </div>
            <div class="col-6 in border-danger">
                <div class="input-group mt-5 mb-3">
                    <input type="text" id="searchvalue" class="form-control" placeholder="辣条"
                           aria-describedby="basic-addon2" value="${param.keywords}">
                    <div class="input-group-append">
                        <span style="user-select: none;cursor: pointer;background-color:#ff6b31;color: white;"
                              onclick="found()"
                              class="input-group-text" id="basic-addon2">
                            <i class="fa fa-search" aria-hidden="true"></i>&nbsp;查找商品</span>
                    </div>
                </div>
                <style>
                    .s>a {
                        color: darkgray;
                    }
                </style>
                <span class="text-muted my-3 s" style="font-size: 12px;"><span>热搜：</span>
                    <a href="/open/search/?keywords=辣条">辣条</a>
                    <a href="/open/search/?keywords=手机">手机</a>
                    <a href="/open/search/?keywords=电脑">电脑</a>
                    <a href="/open/search/?keywords=裙">裙</a>
                    <a href="/open/search/?keywords=小米">小米</a>
                    <a href="/open/search/?keywords=衣">衣</a>
                    <a href="/open/search/?keywords=小吃">小吃</a>
                    <a href="/open/search/?keywords=品牌">品牌</a>
                </span>
            </div>
            <div class="col-3 tp border-info"></div>
        </div>
    </div>
</div>

<script>
    function found() {
        let index = layer.load(1, {
            shade: [0.3,'#fff'] //0.1透明度的白色背景
        });
        let v =$("#searchvalue").val();
        v=v.trim();
        if(v===""){
            layer.close(index);
            layer.msg("请输入！");
            return false;
        }
        location.href="/open/search/?keywords="+v;
    }
</script>