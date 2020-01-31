// member removal with ajax
$(document).ready(function() {
	console.log("testAjax ready");
	$('.signup').on("click", function(event){
		console.log(this);
		console.log($('.signup'));
		$.ajax({
			type: "GET",
			url: "signup",
			success: function () {
				document.fadeOut(200, function() { $(this).remove() });
			}
		});
		
	})
});

/*
//member removal with ajax
$(document).ready(function() {

	console.log("testAjax ready");
	$('.member-rm').on("click", function(event){
		console.log(this);
		console.log($('.member-rm'));
		var member = $(this).parents('.member');
		console.log(member);
		var id = member.data("id");
		console.log(id);
		$.ajax({
			type: "GET",
			url: "members/rm",
			data: {id: id},
			dataType: "dataType",
			success: function () {
				member.fadeOut(200, function() { $(this).remove() });
			}
		});
		
	})

});
*/