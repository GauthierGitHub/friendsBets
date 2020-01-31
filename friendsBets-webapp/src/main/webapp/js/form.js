
function updateSubmitButton(form) {
	// est-ce que tous les champs required sont remplis ??
	var activate = true;
	$(form).find("[required]").each(function() {
		activate = activate && ($(this).val() != "");
	})
	// on (des)active le boutton
	if (activate)
		$(form).find("[type='submit']").attr("disabled", false);
	else
		$(form).find("[type='submit']").attr("disabled", true);
}



$(document).ready(function() {

	$(".error-message").each(function() {
		if ($(this).html() == "")
			$(this).hide();
		else
			$(this).show();
	})
	
	// on met à jour les bouttons de soumissions de tous les formulaires
	$("form").each(function () { updateSubmitButton($(this)); });
	
	// on ecoute les changement sur les champs de formulaire
	$("form *").on("input", function(evt) {
		updateSubmitButton($(this).parents("form"));
	})


});