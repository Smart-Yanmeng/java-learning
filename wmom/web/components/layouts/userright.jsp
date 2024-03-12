<%--
  Created by IntelliJ IDEA.
  User: 星时代曹波涛
  Date: 2020/10/18
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<div class="col-4 right">
    <div class="calendar border">
        <div class="top">我的日历</div>
        <div class="main text-center">
            <p class="display-2 pt-3 mb-1 show-d">1</p>
            <p class="mb-0 show-w">星期日</p>
            <p class="show-ym">2020-10</p>
        </div>
    </div>
    <div class="server mt-3">
        <table class="table table-bordered text-center">
            <tr>
                <td colspan="4">便民服务</td>
            </tr>
            <tr>
                <td>
                    <i class="fa fa-mobile" aria-hidden="true"></i>
                </td>
                <td>
                    <i class="fa fa-gamepad" aria-hidden="true"></i>
                </td>
                <td>
                    <i class="fa fa-cc-paypal" aria-hidden="true"></i>
                </td>
                <td>
                    <i class="fa fa-ticket" aria-hidden="true"></i>
                </td>
            </tr>
            <tr>
                <td>
                    <i class="fa fa-tint" aria-hidden="true"></i>
                </td>
                <td>
                    <i class="fa fa-window-close" aria-hidden="true"></i>
                </td>
                <td>
                    <i class="fa fa-briefcase" aria-hidden="true"></i>
                </td>
                <td>
                    <i class="fa fa-diamond" aria-hidden="true"></i>
                </td>
            </tr>
            <tr>
                <td><i class="fa fa-train" aria-hidden="true"></i></td>
                <td>
                    <i class="fa fa-car" aria-hidden="true"></i>
                </td>
                <td>
                    <i class="fa fa-motorcycle" aria-hidden="true"></i>
                </td>
                <td>
                    <i class="fa fa-plane" aria-hidden="true"></i>
                </td>
            </tr>
        </table>
    </div>
    <script>
        $(function () {
            let date = new Date();
            let week = [
                "星期日",
                "星期一",
                "星期二",
                "星期三",
                "星期四",
                "星期五",
                "星期六",
            ]
            let fullYear = date.getFullYear();
            let rq = date.getDate();
            $(".show-d").text(date.getDate());
            $(".show-w").text(week[date.getDay()]);
            $(".show-ym").text(fullYear + "." + rq);
        })
    </script>
</div>