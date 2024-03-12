<%--
  Created by IntelliJ IDEA.
  User: 星时代曹波涛
  Date: 2020/10/12
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
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
<%--按钮--%>
<div class="input-group count-wrap">
    <div class="input-group-prepend">
        <div class="input-group-text a">-</div>
    </div>
    <input type="text" class="form-control count-value" value="1" disabled aria-describedby="b">
    <div class="input-group-prepend">
        <div class="input-group-text c">+</div>
    </div>
</div>
<script>
    //委托注册
    $(".count-wrap").click(function (e) {
        let ra = /a$/;
        let rc = /c$/;
        let re = /e$/;
        if(re.test(e.target.className)){
            return false;
        }
        console.log(ra.test(e.target.className))
        let va = $(this).find(".count-value");
        if (ra.test(e.target.className)) {
            if (va.val() <= 1) {
                return false;
            }
            let num = va.val();
            num--;
            va.val(num);
        }
        if (!ra.test(e.target.className)) {
            let num = va.val();
            num++;
            va.val(num);
        }
    })
</script>
