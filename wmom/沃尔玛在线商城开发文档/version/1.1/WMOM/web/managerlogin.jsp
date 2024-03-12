<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>智慧运营管理中心</title>
    <link rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/static/css/login.css">
    <link href="${pageContext.request.contextPath}/static/img/favicon.ico" mce_href="/favicon.ico" rel="icon"
          type="image/x-icon"/>
    <script src="/static/js/jquery-3.4.1.js"></script>
    <script src="static/layer/layer.js"></script>
</head>
<body>
<!-- particles.js container -->
<div id="particles-js" style="display: flex;align-items: center;justify-content: center">
    <canvas class="particles-js-canvas-el" style="width: 100%; height: 100%;" width="472" height="625"></canvas>
</div>
<div class="apTitle">沃尔玛智慧运营管理中心</div>
<div class="logcon"><input id="username" value="admin" type="text" placeholder="账号">
    <input type="password" id="password" value="123456" placeholder="密码">
    <button type="button" onclick="login()">登录</button>
</div>


<!-- scripts -->
<script src="${pageContext.request.contextPath}/static/js/login.js"></script>
<script src="${pageContext.request.contextPath}/static/js/loginApp.js"></script>
<script>
    function changeImg() {
        let pic = document.getElementById('picture');
        console.log(pic.src);
        if (pic.getAttribute("src", 2) == "/static/img/check.png") {
            pic.src = "/static/img/checked.png"
        } else {
            pic.src = "/static/img/check.png"
        }
    }

    function login() {
        //登录逻辑
        let index = layer.load(1, {
            shade: [0.3,'#fff'] //0.1透明度的白色背景
        });
        let username = $("#username").val();
        let password = $("#password").val();
        $.post("/login/managerlogin", {
                username,
                password,
            },
            function (data) {
            layer.close(index)
                console.log(data)
                if (data.status === 200) {
                    location.href = "./admin/";
                } else {
                    layer.alert(data.msg);
                }
            }
        );
    }
</script>

</body>
</html>
