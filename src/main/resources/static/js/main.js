$(document).ready(function(){
    $('.modal').modal();
    AOS.init();
    M.AutoInit();
    var prevScrollpos = window.pageYOffset;
    $(window).scroll(function(){
        if($(window).scrollTop()>100){
            $('nav').removeClass('black').removeClass('white-text').addClass('transparent').addClass('black-text');
        } else{
            $('nav').removeClass('transparent').addClass('black').removeClass('black-text').addClass('white-text');
        }
        if($(window).scrollTop()>550){
            var currentScrollPos = window.pageYOffset;
            if (prevScrollpos > currentScrollPos) {
                document.getElementById("navbar").style.top = "0";
            } else {
                document.getElementById("navbar").style.top = "-70px";
            }
            prevScrollpos = currentScrollPos;
        }
    });
    $('#purple').on('click', function(){
        $('.toggle').toggleClass('purpletext').removeClass('lightblue').removeClass('lightpurple');
        $('a').toggleClass('purpletext').removeClass('lightblue').removeClass('lightpurple');
    });

    $('#lightpurple').on('click', function(){
        $('.toggle').toggleClass('lightpurple').removeClass('lightblue').removeClass('purpletext');
        $('a').toggleClass('lightpurple').removeClass('lightblue').removeClass('purpletext')
    });

    $('#blue').on('click', function(){
        $('.toggle').toggleClass('lightblue').removeClass('lightpurple').removeClass('purpletext');
        $('a').toggleClass('lightblue').removeClass('lightpurple').removeClass('purpletext');
    });
});


