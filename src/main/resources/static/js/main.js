$(document).ready(function(){
    $('.sidenav').sidenav();
    $('.parallax').parallax();
    $('.fixed-action-btn').floatingActionButton();
    $('.materialboxed').materialbox();
    $(window).scroll(function(){
        if($(window).scrollTop()>70){
            $('nav').removeClass('black').addClass('transparent')
        } else{
            $('nav').removeClass('transparent').addClass('black')
        }
        if($(window).scrollTop()>500){
            $('nav').removeClass('transparent').addClass('black')
        }
    })
});
