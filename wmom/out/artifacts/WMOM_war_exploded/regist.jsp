<%--
  Created by IntelliJ IDEA.
  User: 文盛
  Date: 2020/10/12
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>沃尔玛注册页面</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/static/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.4.1.js" type="text/javascript"
            charset="utf-8"></script>
    <script src="/static/layer/layer.js"></script>
    <style type="text/css">
        a, address, b, big, blockquote, body, center, cite, code, dd, del, div, dl, dt, em, fieldset, font, form, h1, h2, h3, h4, h5, h6, html, i, iframe, img, ins, label, legend, li, ol, p, pre, small, span, strong, u, ul, var {
            margin: 0;
            padding: 0;
        }

        a {
            text-decoration: none;
        }

        #all {
            width: 100%;
        }

        /*all*/
        #logo {
            width: 100%;
            height: 150px;
            background-color: white;
            position: relative;
        }

        .first {
            text-align: center;
            width: 100%;
            height: 50px;
            /*line-height: 50px;*/
        }

        #background {
            width: 100%;
            height: 450px;
            position: relative;
            background: url(/static/img/background2.PNG);

        }

        .end {
            width: 100%;
            height: 50px;
            background-color: white;
        }

        /*logo150*/
        #dog {
            position: absolute;
            top: 20px;
            left: 70px;
        }

        #firstDog {

            display: inline;

        }

        #jingdong {
            font-family: '楷体';
            color: red;
            font-size: 50px;
            display: inline;
        }


        /*warn*/
        .i {
            width: 15px;
            height: 15px;
            border: 1px solid;
            border-radius: 100px;
            border-color: darkgray;
            display: inline-block;
            color: darkgray;
        }

        .warnword {
            padding: 17px;
        }


        /*background*/
        #login {
            /*margin: 0 auto;*/
            width: 350px;
            height: 420px;
            position: absolute;
            top: 15px;
            right: 400px;
            background-color: white;
        }

        .login-tab div {
            margin: 0 auto;
            padding-left: 50px;
            width: 175px;
            height: 60px;
            line-height: 60px;
            color: gray;
            font-size: 20px;
            font-family: "微软雅黑";
        }

        #loginFoot {
            width: 350px;
            height: 325px;
        }

        .login-tab-l {
            display: inline;
            /*margin: 0 auto;*/
        }


        .div-input {
            width: 325px;
            height: 250px;
            margin: 0 auto;
        }

        #tubiao {
            height: 125px;
            width: 350px;

        }

        .line {
            margin-left: 15px;
        }


        .item {
            position: relative;
            margin-top: 15px;
        }

        .loginDiv2 b {
            position: absolute;
            top: 10%;
            left: 10px;
            width: 16px;
            height: 16px;
            background: url(/static/img/all.png) -104px -49px no-repeat;
        }


        #tripe {
            text-decoration: none;
            width: 320px;
            height: 40px;
            background-color: red;
            color: white;
            font-size: 20px;
            display: block;
            line-height: 40px;
            border: 1px solid white;
            text-align: center;
            margin-top: 15px;
        }


        #biao {
            list-style-type: none;

        }

        #biao > li {
            float: left;
        }

        /*biao*/

        #biao {
            position: relative;

            left: 10px;
        }

        .regist-link {
            position: relative;
            left: 95px;
            top: 8px;
        }

        .regist-link b {
            display: inline-block;
            width: 16px;
            height: 16px;
            overflow: hidden;
            background: url(/static/img/all.png) -104px -75px no-repeat;
            vertical-align: middle;
            margin-right: 5px;
            margin-top: -3px;

        }

        /*end*/
        #footer-2013 {
            text-align: center;
        }

        .links {
            margin: 15px 0px 0px 0px;
            color: black;
        }

        .copyright {
            margin: 15px 0px 0px 0px;
        }

        /*效果*/
        a {
            color: black;
        }

        div a:hover {
            font-weight: 900;
            color: red;
        }

        div[class*="warn"] {
            background-color: #fff8f0;
            color: #666;
            font-size: 12px;
        }

        img {
            position: relative;
            top: 0px;
        }


        .loginDivError b {
            display: inline-block;
            width: 16px;
            height: 17px;
            overflow: hidden;
            vertical-align: middle;
            background: url(/static/img/all.png) no-repeat -104px -50px;
            position: relative;
            bottom: 1px;
            margin: 0px;
            margin-right: 13px;
        }

        .loginDivError {
            /*visibility:hidden;*/
            width: 310px;
            height: 20px;
            line-height: 20px;
            font-size: 12px;
            padding-left: 10px;
            border: solid 1px lightpink;
            background-color: papayawhip;
            position: relative;
            color: red;
        }

        h3 {
            display: inline;
            margin: 0 auto;
            font-size: 20px;
        }

        input[type=text], input[type=password] {
            border: 1px solid darkgray;
            outline: none;
        }
    </style>

</head>
<div id="all">
    <div id="logo">
        <div id="dog">
            <div id="firstDog"><img src="${pageContext.request.contextPath}/static/img/logo.png" width="280px" height="120px"></div>
        </div>
    </div>

    <div id="background">
        <div id="login">
            <div class="login-tab login-tab-l">
                <div id="user-regist">用户注册</div>
            </div>


            <div id="loginFoot">

                <%--用户注册部分--%>
                <div id="input" class="div-input">
                    <div id="prompt" class="msg-error">


                    </div>

                    <form id="loginForm" action=${pageContext.request.contextPath}/login/loginServlet method="post"
                          target="_top">
                        <input type="hidden" name="action" value="login"/>
                        <div class="item loginDiv3Fisrt">
                            <div>
                                <input id="name" class="input" type="text" name="name" style="width: 320px;height: 40px"
                                       placeholder="请输入你的昵称···">
                            </div>
                        </div>
                        <div class="item loginDiv3Fisrt">
                            <div>
                                <input id="username" class="input" type="text" name="username"
                                       style="width: 320px;height: 40px" placeholder="请输入你的登录名···">
                            </div>
                        </div>
                        <div class="item loginDiv3Fisrt">
                            <div>
                                <input id="password" class="input" type="password" name="password"
                                       style="width: 320px;height: 40px" placeholder="请输入密码···">
                            </div>
                        </div>
                        <p style="padding: 20px 0 5px;">&nbsp;<input type="checkbox" name="ty" checked> <a href=""
                                                                                                           style="font-size: 12px;color: darkgray;">
                            我已阅读并同意相关服务条款和隐私政策 </a></p>

                        <input onclick="regist()" class="btn btn btn-primary" type="button"
                               style="height: 40px; width: 320px;" value="注&nbsp;&nbsp;&nbsp;&nbsp;册">
                    </form>
                </div>


                <div id="tubiao">
                    <ul id="biao" style="list-style-type: none;vertical-align:middle;">
                        <b></b>
                        <li>
                            <img id="qq" src=${pageContext.request.contextPath}/static/img/qq.PNG>
                            <a href="#"
                               class="pdl">
                                <b class="QQ-icon"></b><span style="font-size: 12px;">QQ</span>
                            </a>
                            <span class="line">|</span>
                        </li>
                        <li>
                            <img id="weixin" src=${pageContext.request.contextPath}/static/img/weixin.PNG>
                            <a href="#"
                               class="pd">
                                <b class="weixin-icon"></b><span style="font-size: 12px;">微信</span>
                            </a>
                        </li>

                        <li class="extra-r">
                            <div class="regist-link">
                                <a href="${pageContext.request.contextPath}/userlogin.jsp"><b></b>立即登录</a>
                            </div>
                        </li>

                    </ul>
                </div>
            </div>
        </div>
    </div>

    <div class="end">
        <div id="footer-2013">
            <div class="links" style="font-size: 12px;">
                <a rel="nofollow" target="_blank" href="http://www.wal-martchina.com/walmart/index.htm">
                    关于我们
                </a>
                |
                <a rel="nofollow" target="_blank" href="http://www.wal-martchina.com/promotion/promotion.htm">
                    促销活动
                </a>
                |
                <a rel="nofollow" target="_blank" href="http://www.wal-martchina.com/news/news.htm">
                    新闻动态
                </a>
                |
                <a rel="nofollow" target="_blank" href="http://www.wal-martchina.com/service/service.htm">
                    顾客服务
                </a>
                |
                <a rel="nofollow" target="_blank" href="http://www.wal-martchina.com/supplier/supplier.htm">
                    供应商服务
                </a>
                |
                <a rel="nofollow" target="_blank" href="http://www.wal-martchina.com/community/community.htm">
                    企业社会责任
                </a>
                |
                <a target="_blank" href="http://www.wal-martchina.com/career/career.htm">
                    招聘信息
                </a>
                |
                <a target="_blank" href="http://www.wal-martchina.com/contact/contactus.htm">
                    联系我们
                </a>
                |
                <a href="http://www.vesns.cn/" target="_blank">
                    兄弟网站
                </a>

            </div>
            <div class="copyright" style="font-size: 12px;">
                Copyright&nbsp;&copy;&nbsp;2000-2020&nbsp;&nbsp;沃尔玛vesns.cn&nbsp;版权所有&nbsp;&nbsp;&nbsp;蜀ICP备20005193号
            </div>
        </div>
    </div>

    <script>
        /*轮播图*/
        let background;
        const imgs = ["${pageContext.request.contextPath}/static/img/background2.PNG", "${pageContext.request.contextPath}/static/img/background3.PNG"
            , "${pageContext.request.contextPath}/static/img/background3.PNG"];
        let i = 0;
        let img;
        window.onload = function () {
            background = document.getElementById("background");
            img = window.setInterval(change, 3000);
        }

        function change() {
            i++;

            // 超过2则取余数，保证循环在0、1、2之间
            i = i % 3;
            background.style.background = "url(" + imgs[i] + ")";
        }

        $(function () {
            $("#background").hover(function () {

                window.clearInterval(img);
            }, function () {
                img = window.setInterval(change, 5000);
            })
        });


        function regist() {
            if (!$("[name=ty]").prop("checked")) {
                return false;
            }

            let name = $("[name=name]").val();
            let username = $("[name=username]").val();
            let password = $("[name=password]").val();
            if (name === "" || username === "" || password === "") {
                layer.msg("任何一项不能为空！", {icon: 5});
                return false;
            }
            let index = layer.load(1, {
                shade: [0.1, '#fff'] //0.1透明度的白色背景
            });
            $.post("/login/regist", {
                name,
                username,
                password,
            }, function (data) {
                layer.close(index);
                console.log(data);
                if (data.status === 200) {
                    layer.alert("注册成功！")
                } else {
                    layer.msg(data.msg);
                }
            });
        }
    </script>
</div>
</body>
</html>