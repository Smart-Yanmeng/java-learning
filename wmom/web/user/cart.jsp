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
<div class="container-fluid" style="background-color:#ff4401;">
    <div class="container">
        <div class="row">
            <div class="col-5">
                <span style="user-select:none; color: white; font-family: 华文新魏;font-size: 30px;display: block; padding: 15px 0;">我的购物车</span>
            </div>
            <div class="col-7"></div>
        </div>
    </div>
</div>

<div class="container my-2">
    <div class="row text-muted my-2" style="font-size: 12px;">
        <div class="col-7">
            <span>商品信息</span>
        </div>
        <div class="col-1 text-r">
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

    <c:if test="${empty requestScope.products}">
        <div class="container m-5 p-5">
            <h3 class="text-center text-muted">购物车还没有东西哦！</h3>
        </div>
    </c:if>

    <c:forEach items="${requestScope.products}" var="product">
        <div class="row border pt-4 my-3 omy m-1">
            <div class="col-7" style="font-size: 12px;">
                <p class="pb-0 mb-0" style="position: relative;top: -10px;"><input type="checkbox" name="c">
                    &nbsp;
                    <img src="/upload/${product.img}" class="img-thumbnail"
                         style="width: 50px;height: 50px;" alt="">
                    &nbsp;
                    <a href="${pageContext.request.contextPath}/open/product/getproductbyid?id=${product.id}">
                        <c:if test="${product.name.length()<50}">
                            ${product.name}
                        </c:if>
                        <c:if test="${product.name.length()>=50}">
                            ${product.name.substring(0,50)}
                        </c:if>
                    </a>
                </p>
            </div>
            <div class="col-1 dj">${product.price}</div>
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
            <div class="col-1 total">${product.price}</div>
            <div class="col-1">
                <a href="javascript:void(0);" onclick="del('${product.id}')" style="font-size: 12px;">移出购物车</a>
            </div>
            <div class="d-none id">${product.id}</div>
        </div>
    </c:forEach>


    <c:if test="${not empty requestScope.products}">
        <br>
        <br>
        <br>
        <br>
        <div class="row js mt-5">
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
    </c:if>
</div>
<%@ include file="/components/layouts/footer.jsp" %>
<script>
    let itemList = [];


    //微微一难
    // 10-13 0:26 打卡
    function all(a, b) {
        return (a * b).toFixed(2);
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
                ai++;
                lgmsg($(o));
            }

        })
        $("#much").text(ai)
        $("#all").text(tt);
    }

    //委托注册
    $(".count-wrap").click(m)
    $("input[name=c]").not("#quanxuan").click(m)
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
                ai++;
                lgmsg($(o));
            }
        })
        $("#much").text(ai)
        $("#all").text(tt);
    })


    function lgmsg($obj) {
        let id = $obj.find(".id").text();
        let count = $obj.find(".count-value").val()
        console.log("id")
        console.log(id)
        console.log("数量")
        console.log(count)
        itemList.push({"id": id, "count": count});
    }

    //结算按钮
    function send() {
        let money = parseInt($("#all").text());
        if (money === 0) {
            layer.msg("你还没有勾选商品哟！！！")
            return false;
        }
        layer.alert('你共消费：' + money + "元！", {
            skin: 'layui-layer-molv' //样式类名
            , closeBtn: 0
        }, function () {
            console.log(itemList)
            itemList.forEach(k => {
                let id = k.id;
                $.post("/cart/delete", {id}, function (data) {
                })
            })
            let s = JSON.stringify(itemList);
            $.post("/order/add", {
                list: s,
                money
            }, function (data) {
                console.log(data);
                location.reload();
                location.href = "/order/getOrdersByUserId"
            })
            layer.closeAll()
        });
    }

    function del(id) {
        let index = layer.load(1, {
            shade: [0.1, '#fff']
        });
        $.post("/cart/delete", {id}, data => {
            layer.close(index)
            if (data.status === 200) {
                layer.msg("移出成功");
                location.reload();
            } else {
                layer.msg("移出失败");
            }
        })
    }
</script>
</body>
</html>