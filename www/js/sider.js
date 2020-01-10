/**
 * https://bootsnipp.com/snippets/3X2mq
 */
$(".heading-compose").click(function () {
  $(".side-two").css({
    "left": "0"
  });
});

$(".newMessage-back").click(function () {
  $(".side-two").css({
    "left": "-100%"
  });
});

/**
 * https://bootsnipp.com/snippets/nNg98
 */
$(document).ready(function () {
  $('#action_menu_btn').click(function () {
    $('.action_menu').toggle();
  });
});