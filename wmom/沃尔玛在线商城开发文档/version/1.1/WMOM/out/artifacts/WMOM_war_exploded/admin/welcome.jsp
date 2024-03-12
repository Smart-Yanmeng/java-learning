<%--
  Created by IntelliJ IDEA.
  User: 星时代曹波涛
  Date: 2020/10/12
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.2</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <link rel="stylesheet" href="../static/admin/css/font.css">
    <link rel="stylesheet" href="../static/admin/css/xadmin.css">
    <script src="../static/admin/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="../static/admin/js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-body ">
                    <blockquote class="layui-elem-quote">欢迎管理员：
                        <span class="x-red">${sessionScope.manager.name}</span>！当前时间: <span id="stime"></span>
                    </blockquote>
                </div>
            </div>
        </div>
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">数据统计</div>
                <div class="layui-card-body ">
                    <ul class="layui-row layui-col-space10 layui-this x-admin-carousel x-admin-backlog">
                        <li class="layui-col-md2 layui-col-xs6">
                            <a href="javascript:;" class="x-admin-backlog-body">
                                <h3>订单总量</h3>
                                <p>
                                    <cite>100</cite></p>
                            </a>
                        </li>
                        <li class="layui-col-md2 layui-col-xs6">
                            <a href="javascript:;" class="x-admin-backlog-body">
                                <h3>商品种类</h3>
                                <p>
                                    <cite>15</cite></p>
                            </a>
                        </li>
                        <li class="layui-col-md2 layui-col-xs6">
                            <a href="javascript:;" class="x-admin-backlog-body">
                                <h3>会员人数</h3>
                                <p>
                                    <cite>99</cite></p>
                            </a>
                        </li>
                        <li class="layui-col-md2 layui-col-xs6">
                            <a href="javascript:;" class="x-admin-backlog-body">
                                <h3>评价数量</h3>
                                <p>
                                    <cite>67</cite></p>
                            </a>
                        </li>
                        <li class="layui-col-md2 layui-col-xs6">
                            <a href="javascript:;" class="x-admin-backlog-body">
                                <h3>当前在线</h3>
                                <p>
                                    <cite>67</cite></p>
                            </a>
                        </li>
                        <li class="layui-col-md2 layui-col-xs6 ">
                            <a href="javascript:;" class="x-admin-backlog-body">
                                <h3>总访问量</h3>
                                <p>
                                    <cite>56766</cite></p>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>

        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">系统信息</div>
                <div class="layui-card-body ">
                    <table class="layui-table">
                        <tbody>
                        <tr>
                            <th>版本</th>
                            <td>1.0.00001</td>
                        </tr>
                        <tr>
                            <th>服务器地址</th>
                            <td>${pageContext.request.serverName}</td>
                        </tr>
                        <tr>
                            <th>操作系统</th>
                            <td>Linux</td>
                        </tr>
                        <tr>
                            <th>运行环境</th>
                            <td>Tomcat+Mysql</td>
                        </tr>
                        <tr>
                            <th>Java版本</th>
                            <td>1.8</td>
                        </tr>
                        <tr>
                            <th>MYSQL版本</th>
                            <td>8.0</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <style id="welcome_style"></style>
    </div>
</div>
</div>
<script>
    function dateForMart() {
        let date = new Date();
        let fullYear = date.getFullYear();
        let month = date.getMonth() + 1;
        let date1 = date.getDate();
        let hours = date.getHours();
        let minutes = date.getMinutes();
        let seconds = date.getSeconds();
        return fullYear + "年" + month + "月" + date1 + "日" + hours + ":" + minutes + ":" + seconds;
    }

    window.onload = function () {
        let t = document.getElementById("stime");
        t.innerText=dateForMart();
        setInterval(function () {
            t.innerText = dateForMart();
        }, 1000)
    }
</script>
</body>
</html>