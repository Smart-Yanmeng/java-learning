<%--
  Created by IntelliJ IDEA.
  User: 星时代曹波涛
  Date: 2020/10/12
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>沃尔玛在线商城</title>
    <%--引入公共样式--%>
    <%@include file="./components/codesnippet/basecssandscript.jsp" %>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/product.css">
    <link type="text/css" href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet" />
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.4.1.js"></script>
</head>
<body>

<%--顶部信息--%>
<%@include file="/components/layouts/top.jsp" %>
<%--logo和搜索框--%>
<%@include file="/components/layouts/search.jsp" %>


<div class="container comm-main">
    <div class="row">
        <div class="col-5">
            <div class="comm-img">
                <img src="/upload/${requestScope.product.img}"
                     class="img-fluid img-thumbnail" alt="">
            </div>
        </div>
        <div class="col-5 comm-center p-3 border-left">
            <h6 class="mb-4">${requestScope.product.name}</h6>
            <table>
                <tr class="text-muted text-center border-top border-bottom" style="font-size: 12px;">
                    <td class="border-right my-1" style="width: 100px;">销 量: 0</td>
                    <td class="border-right my-1" style="width: 100px;">评 价: 0</td>
                    <td class="my-1" style="width: 100px;">积 分: 0</td>
                </tr>
                <tr>
                    <td>价 格:</td>
                    <td style="font-size: 24px;">￥ &nbsp; <span class="text-danger p-0 m-0" >${product.price}</span></td>
                    <td></td>
                </tr>
                <tr>
                    <td>数 量:</td>
                    <td>
                        <%@include file="/components/count.jsp" %>
                    </td>
                    <td>
                        <span class="text-muted" style="font-size: 12px;">库存 ${product.stock} 件</span>
                    </td>
                </tr>

            </table>
            <div class="mt-5">
                <a href="${pageContext.request.contextPath}/user/purchase.jsp?id=" target="_blank" class="btn btn-outline-danger">立即购买</a>
                <button class="btn btn-outline-danger">加入购物车</button>
            </div>
        </div>
        <div class="col-2 border-left">

        </div>
    </div>
</div>

<div class="container pl">
    <div class="row border-bottom">
        <h4 class="text-muted my-3 ml-5">商品评论</h4>
    </div>
    <div class="row mt-2">
        <div class="col-12">
            <ul class="list-group w-100">
                <li class="list-group-item">不好吃，大家不要买</li>
                <li class="list-group-item">非常好吃</li>
                <li class="list-group-item">好吃</li>
                <li class="list-group-item">默认好评</li>
                <li class="list-group-item">Vestibulum at eros</li><li class="list-group-item">Cras justo odio</li>
                <li class="list-group-item">Dapibus ac facilisis in</li>
                <li class="list-group-item">Morbi leo risus</li>
                <li class="list-group-item">Porta ac consectetur ac</li>
                <li class="list-group-item">Vestibulum at eros</li><li class="list-group-item">Cras justo odio</li>
                <li class="list-group-item">Dapibus ac facilisis in</li>
                <li class="list-group-item">Morbi leo risus</li>
                <li class="list-group-item">Porta ac consectetur ac</li>
                <li class="list-group-item">Vestibulum at eros</li><li class="list-group-item">Cras justo odio</li>
                <li class="list-group-item">Dapibus ac facilisis in</li>
                <li class="list-group-item">Morbi leo risus</li>
                <li class="list-group-item">Porta ac consectetur ac</li>
                <li class="list-group-item">Vestibulum at eros</li>
            </ul>
        </div>

    </div>
</div>




<script>
    $(function () {
        var sdBoxW = $('.moveBox').css('width');
        sdBoxW = parseInt(sdBoxW);//移动层的宽度
        var magBoxW = $('.magBox').css('width');
        magBoxW = parseInt(magBoxW);//图片放大层的宽度
        var normalBoxW = $('.normalBox').css('width');
        normalBoxW = parseInt(normalBoxW);//事件绑定层的宽度
        var num = 0;//存放下标
        //找出放大图片的比例(核心)
        var scale = magBoxW/sdBoxW;
        //移入normalBox盒子
        $('.normalBox').hover(function () {
            $('.moveBox').css('display','block');
            $('.magBox').css('display','block');
        },function () {
            $('.moveBox').css('display','none');
            $('.magBox').css('display','none');
        });
        //3、移入leftBox层
        $('.leftBox').mouseover(function () {
            //给放大的图片和图片层设置宽度；
            $('.magBox ul li img').css('width',scale*normalBoxW+'px');
            $('.magBox ul li').css({'width':scale*normalBoxW+'px','height':scale*normalBoxW+'px'})
        });
        //4、设置放大倍数
        var n = 1;
        function sty() {
            $('.moveBox').css({'width':200/n+'px','height':200/n+'px'});
            $('.multiple').html(n);
            scale = magBoxW/(sdBoxW/n);
        }
        $('.btn1').click(function () {
            n ++;
            sty()
        });
        $('.btn2').click(function () {
            if (n==1){
                return;
            } else {
                n --;
                sty()
            }
        }) ;
        //1、移入缩小图关联
        $('.botBox ul li').attr('index',function (i,e) {
            return i;
        });
        $('.botBox ul li').mouseover(function () {
            if ($(this).attr('class')=='bord'){
                return;//跳过第一个
            }else{
                $(this).attr('class','bord').siblings().removeAttr('class');
                var index = $(this).attr('index');
                //联动normal和magBox中的图片
                $('.normalBox .w').eq(index).attr('id','n').siblings().removeAttr('id');
                $('.magBox ul li').eq(index).attr('class','m').siblings().removeAttr('class');
                num = index;
            }
        });
        //2、鼠标在移动层移动
        $('.normalBox').mousemove(function (e) {
            var offset = $(this).offset();
            var X = e.pageX-offset.left-$('.moveBox').width()/2;
            var Y = e.pageY-offset.top-$('.moveBox').height()/2;
            if (X<=0){
                X=0;
            }else if(X>$(this).width()-$('.moveBox').width()){
                X = $(this).width()-$('.moveBox').width();
            }
            if (Y<=0){
                Y=0;
            }else if(Y>$(this).height()-$('.moveBox').height()){
                Y = $(this).height()-$('.moveBox').height();
            }
            $('.moveBox').css('left',X+'px');
            $('.moveBox').css('top',Y+'px');
            $('.magBox ul li').eq(num).css('left',-X*scale+'px');
            $('.magBox ul li').eq(num).css('top',-Y*scale+'px');
        });
    })
</script>
</body>
</html>