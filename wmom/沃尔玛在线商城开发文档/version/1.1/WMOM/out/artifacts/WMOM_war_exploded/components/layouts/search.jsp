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
                    <input type="text" class="form-control" placeholder="机械键盘" aria-label="Recipient's username"
                           aria-describedby="basic-addon2">
                    <div class="input-group-append">
                        <span style="user-select: none;cursor: pointer;background-color:#ff6b31;color: white;"
                              class="input-group-text" id="basic-addon2"><i
                                class="fa fa-search" aria-hidden="true"></i>&nbsp;查找商品</span>
                    </div>
                </div>
                <p class="text-muted my-3" style="font-size: 12px;"><span>热搜：</span>机械键盘 手机 电脑 水果 肯德基 耐克 香奈儿</p>
            </div>
            <div class="col-3 tp border-info"></div>
        </div>
    </div>
</div>