console.log("login.js loaded");
console.log(typeof ('$'))
$('html').on("click", maFonction);
function maFonction() {
    $('h1').animate({
        opacity: '0.5',
        height: '1000npx'
    }, 1000);
    $('h1').css('color', 'green');
    $('h1').html("logged!");
}

/*

    $('h1').toggle("loged").animate({
        opacity: '0.5',
        color: 'red'
      },1000);
*/