function msTime(s) {
    return setInterval(function () {
        $("#ms-time").text(s--);
    }, 1000)
}

function tab() {
    $(".left-nav ul li").mouseenter(function () {
        console.log($(this).index());
        $("#c-one").hide();
        $(".nac").eq($(this).index()).addClass("c-active").siblings().removeClass("c-active");
    });

    $(".fs").mouseleave(lv);
    $(".right-self").mouseenter(lv);

    function lv() {
        $("#c-one").show();
        $(".nac").removeClass("c-active");
    }

}

$(function () {
    msTime(500);
    tab();
})