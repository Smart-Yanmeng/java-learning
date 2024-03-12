let goTop;
goTop = {
    top: 0,
    exe: (time = 10) => {
        goTop.makeButton('rgba(0,0,0,.1)');
        goTop.getTop();
        $('#gotop').click(() => {
            goTop.run(time);
        })
    },
    makeButton: bgc => {
        let $btn = $('<div></div>');
        $btn.attr('id', 'gotop')
            .text('^')
            .css({
                display:'none',
                width: 50,
                height: 50,
                backgroundColor: bgc,
                textAlign: 'center',
                fontSize: 40,
                color:"#ffffff",
                userSelect: 'none',
                cursor: 'pointer',
                position: 'fixed',
                bottom: 100,
                right: 100,
                borderRadius: "50%"
            }).appendTo('body');
    },
    getTop: () => {
        let t=0;
        $(window).scroll(() => {
           if(goTop.top > 10){
               $('#gotop').fadeIn('slow');
           }else {
               $('#gotop').fadeOut('slow');
           }
            goTop.top = $(window).scrollTop();
            //console.log(goTop.top);
        })
    },
    run: time => {
        let timer = setInterval(() => {
            if (goTop.top <= 0) {
                goTop.top=0;
                clearInterval(timer);
                $('#gotop').fadeOut('slow');
                return false;
            }
            goTop.top -= 50;
            $(window).scrollTop(goTop.top);
        }, time);
    }
};

$(() => {
    goTop.exe();
})