///////// EVENTS LISTENNERS ////////
$( document ).ready(function() {
    $('html').on("click", animatedLogin);
});

///////// DOM CHANGING /////////
$('nav').css("visibility", "hidden");
$('.signup').css("visibility", "hidden");
/*
$('.signup *').toggle(0);
$('.signup *').hide();
$('.signup *').css("visibility", "hidden");
$('.signup *').css("display", "none");
$('.signup').toggle(0);
$('.signup').hide();
$('.signup').css("visibility", "hidden");
$('.signup').css("display", "none");
*/

///////// FUNCTION /////////////
function animatedLogin() {
    $('h1').animate({
        opacity: '0.5',
        height: '1000npx'
    }, 1000);
    $('h1').css('color', 'green');
    $('h1').html("logged!");
}