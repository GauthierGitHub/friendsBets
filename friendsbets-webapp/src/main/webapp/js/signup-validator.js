"use strict";


/**
 * Rule class: a single rule constituted by a triplet (name, message, test). 
 * 
 * The name is the name of the input on which the rule will be applied, the message is the error message printed should the rule be broken and the test is a method taking the input value as parameter and return true or false.
 */
class Rule {
	constructor(name, message, test) {
		this.name = name;
		this.message = message;
		this.test = test;
	}
}


/**
 * Validator class: a set of rules with methods for adding new rules and checking the rules validity.
 */
class Validator {
	constructor() {
		// the set of rules
		this.rules = [];

		/**
		 * Method adding a new rule to the validator.
		 * @param name a string corresponding to an input name
		 * @param message the error message should the rule not enforced
		 * @param test a function taking as parameter the value of the input to be checked and returning true or false depending on whether the rule is respected 
		 */
		this.addRule = function (name, message, test) {
			this.rules.push(new Rule(name, message, test));
		}
		
		/**
		 * Method validating a form. Will call the rules one by one, setting the valid/invalid classes and error messages when appropriate.
		 * @return true if all the rules are enforced, false otherwise
		 */
		this.validate = function () {
			// initilisating elements
			var elements = {};
			for (let r of this.rules) {
				// if the input is not already initialized
				if (!(r.name in elements)) {
					// store both the input and the placeholder for the error message
					elements[r.name] = {
						elem : $("form").find("input[name='" + r.name + "']"),
						err : $("form").find("input[name='" + r.name + "']").nextAll("p.invalid-feedback")
					};
					// initialize valid/invalid classes and clear the error message
					elements[r.name].elem.removeClass("is-invalid");
					elements[r.name].elem.addClass("is-valid");
					elements[r.name].err.html("");
				}
			}
			// applying rules
			var valid = true;
			for (let r of this.rules) {
				// if a rule is broken
				if (!r.test(elements[r.name].elem.val())) {
					// update validation status, input class and error message
					valid = false;
					elements[r.name].elem.addClass("is-invalid");
					elements[r.name].err.append(" " + r.message);
				}
			}
			return valid;
		}
		
	}
	
}
		
	
$(document).ready(function() {

	$("form").on("submit", function (evt) {
		var v = new Validator();
		v.addRule("alias", "Alias \"Evan\" is not allowed !", e => e != "evan");
		/*
		v.addRule("alias", "Alias must be at least 6; characters long", e => e.length >= 6);
		v.addRule("email", "Invalid email format", e => e.includes("@"));
		v.addRule("password", "Password must be at least 8 characters long", e => e.length >= 8);
		*/
		if (!v.validate())
			evt.preventDefault();
	});

});