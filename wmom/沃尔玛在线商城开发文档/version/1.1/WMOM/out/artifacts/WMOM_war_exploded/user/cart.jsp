<%--
  Created by IntelliJ IDEA.
  User: 星时代曹波涛
  Date: 2020/10/12
  Time: 21:00
  To change this template use File | Settings | File Templates.
  购物车页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>购物车</title>
    <%--引入公共样式--%>
    <%@include file="/components/codesnippet/basecssandscript.jsp" %>
    <style>
        body {
            background-color: #ffffff;
        }

        .count-wrap {
            width: 110px;
        }

        .count-wrap .count-value {
            text-align: center;
            background-color: #ffffff !important;
        }

        .count-wrap .a, .count-wrap .count-value, .count-wrap .c {
            height: 30px;
            user-select: none;
            cursor: pointer;
        }

        .js {
            height: 50px;
            line-height: 50px;
            background-color: #c3c3c3;
            user-select: none;
        }
    </style>
</head>
<body>
<%--顶部信息--%>
<%@include file="/components/layouts/top.jsp" %>
<div class="container">
    <div class="row border">
        <div class="col-5">
            <img src="${pageContext.request.contextPath}/static/img/logo.jpg" class="img-fluid"
                 style="height: 100px;" alt="">
            <span class="text-danger" style="font-family: 华文新魏;font-size: 30px;vertical-align: center">购物车</span>
        </div>
        <div class="col-7"></div>
    </div>
</div>

<div class="container mt-2">
    <div class="row text-muted my-2" style="font-size: 12px;">
        <div class="col-7">
            <span>商品信息</span>
        </div>
        <div class="col-1">
            <span>单价</span>
        </div>
        <div class="col-2 text-center">
            <span>数量</span>
        </div>
        <div class="col-1">
            <span>金额</span>
        </div>
        <div class="col-1">
            <span>操作</span>
        </div>
    </div>

    <div class="row border py-3 my-3 omy">
        <div class="col-7" style="font-size: 12px;">
            <p><input type="checkbox"><span class="text-muted">御叶林茶叶铁观音2020新茶兰花香铁观音特级浓香型茶叶礼盒装500g</span></p>
        </div>
        <div class="col-1 dj">115</div>
        <div class="col-2">
            <%--按钮--%>
            <div class="input-group count-wrap m-auto">
                <div class="input-group-prepend">
                    <div class="input-group-text a">-</div>
                </div>
                <input type="text" class="form-control count-value" value="1" disabled aria-describedby="b">
                <div class="input-group-prepend">
                    <div class="input-group-text c">+</div>
                </div>
            </div>
        </div>
        <div class="col-1 total">115</div>
        <div class="col-1">
            <a href="" style="font-size: 12px;">删除</a>
        </div>
    </div>
    <div class="row border py-3 my-3 omy">
        <div class="col-7" style="font-size: 12px;">
            <p><input type="checkbox"><span class="text-muted">御叶林茶叶铁观音2020新茶兰花香铁观音特级浓香型茶叶礼盒装500g</span></p>
        </div>
        <div class="col-1 dj">115</div>
        <div class="col-2">
            <%--按钮--%>
            <div class="input-group count-wrap m-auto">
                <div class="input-group-prepend">
                    <div class="input-group-text a">-</div>
                </div>
                <input type="text" class="form-control count-value" value="1" disabled aria-describedby="b">
                <div class="input-group-prepend">
                    <div class="input-group-text c">+</div>
                </div>
            </div>
        </div>
        <div class="col-1 total">115</div>
        <div class="col-1">
            <a href="" style="font-size: 12px;">删除</a>
        </div>
    </div>
    <div class="row border py-3 my-3 omy">
        <div class="col-7" style="font-size: 12px;">
            <p><input type="checkbox"><span class="text-muted">御叶林茶叶铁观音2020新茶兰花香铁观音特级浓香型茶叶礼盒装500g</span></p>
        </div>
        <div class="col-1 dj">115</div>
        <div class="col-2">
            <%--按钮--%>
            <div class="input-group count-wrap m-auto">
                <div class="input-group-prepend">
                    <div class="input-group-text a">-</div>
                </div>
                <input type="text" class="form-control count-value" value="1" disabled aria-describedby="b">
                <div class="input-group-prepend">
                    <div class="input-group-text c">+</div>
                </div>
            </div>
        </div>
        <div class="col-1 total">115</div>
        <div class="col-1">
            <a href="" style="font-size: 12px;">删除</a>
        </div>
    </div>
    <div class="row border py-3 my-3 omy">
        <div class="col-7" style="font-size: 12px;">
            <p><input type="checkbox"><span class="text-muted">御叶林茶叶铁观音2020新茶兰花香铁观音特级浓香型茶叶礼盒装500g</span></p>
        </div>
        <div class="col-1 dj">115</div>
        <div class="col-2">
            <%--按钮--%>
            <div class="input-group count-wrap m-auto">
                <div class="input-group-prepend">
                    <div class="input-group-text a">-</div>
                </div>
                <input type="text" class="form-control count-value" value="1" disabled aria-describedby="b">
                <div class="input-group-prepend">
                    <div class="input-group-text c">+</div>
                </div>
            </div>
        </div>
        <div class="col-1 total">115</div>
        <div class="col-1">
            <a href="" style="font-size: 12px;">删除</a>
        </div>
    </div>
    <div class="row border py-3 my-3 omy">
        <div class="col-7" style="font-size: 12px;">
            <p><input type="checkbox"><span class="text-muted">御叶林茶叶铁观音2020新茶兰花香铁观音特级浓香型茶叶礼盒装500g</span></p>
        </div>
        <div class="col-1 dj">115</div>
        <div class="col-2">
            <%--按钮--%>
            <div class="input-group count-wrap m-auto">
                <div class="input-group-prepend">
                    <div class="input-group-text a">-</div>
                </div>
                <input type="text" class="form-control count-value" value="1" disabled aria-describedby="b">
                <div class="input-group-prepend">
                    <div class="input-group-text c">+</div>
                </div>
            </div>
        </div>
        <div class="col-1 total">115</div>
        <div class="col-1">
            <a href="" style="font-size: 12px;">删除</a>
        </div>
    </div>

    <div class="row js">
        <div class="col-5">
            <input type="checkbox" id="quanxuan"><span id="qx">全选</span>
        </div>

        <div class="col-5 clearfix">
            <span class="float-right">已选 <span id="much">0</span> 件商品 &nbsp;&nbsp;&nbsp;共计 <span style="color: red;"
                                                                                                 id="all">0</span> 元</span>
        </div>

        <div class="col-2 text-center bg-danger text-white" onclick="send()">
            结算
        </div>
    </div>
</div>
<script>
    //微微一难
    // 10-13 0:26 打卡
    function all(a, b) {
        return a * b;
    }

    function m(e) {
        let ra = /a$/;
        let rc = /c$/;
        let re = /e$/;
        let $dj = $(this).parent().parent().find(".dj");
        let $va = $(this).find(".count-value");
        let $total = $(this).parent().parent().find(".total");
        // 获取单价
        let dj = $dj.text();
        //获取数量
        let va = $va.val();

        //总总价
        let tt = 0;

        if (re.test(e.target.className)) {
            return false;
        }
        if (ra.test(e.target.className)) {
            if ($va.val() <= 1) {
                layer.msg("商品购买数量不能低于0！")
                return false;
            }
            let num = $va.val();
            num--;
            $va.val(num);
            va--
            $total.text(all(dj, va))
        }
        if (!ra.test(e.target.className)) {
            if ($va.val() >= 20) {
                layer.msg("商品限购20！")
                return false;
            }
            let num = va;
            num++;
            $va.val(num);
            va++
            $total.text(all(dj, va))
        }
        let ai = 0;
        $(".omy").each(function (i, o) {
            if ($(o).find("input").prop("checked")) {
                tt += parseInt(($(o).find(".total").text()));
                ai++
            }

        })
        $("#much").text(ai)
        $("#all").text(tt);
    }

    //委托注册
    $(".count-wrap").click(m)
    $("input").not("#quanxuan").click(m)
    //全选
    $("#quanxuan").click(function () {
        let checked = $("input").prop("checked");
        if (checked) {
            layer.msg("全不选成功！！！")
        } else {
            layer.msg("全选成功！！！")
        }

        $("input").prop("checked", !checked);
        let tt = 0;
        let ai = 0
        $(".omy").each(function (i, o) {
            if ($(o).find("input").prop("checked")) {
                tt += parseInt(($(o).find(".total").text()));
                ai++
            }
        })
        $("#much").text(ai)
        $("#all").text(tt);
    })

    //结算按钮
    function send() {
        let money = parseInt($("#all").text());
        if(money===0){
            layer.msg("你还没有勾选商品哟！！！")
            return false;
        }
        layer.alert('你共消费：'+money+"元，请理性消费！", {
            skin: 'layui-layer-molv' //样式类名
            ,closeBtn: 0
        }, function(){
            // 这发请求





            layer.closeAll()
        });
    }
</script>

</body>
</html>