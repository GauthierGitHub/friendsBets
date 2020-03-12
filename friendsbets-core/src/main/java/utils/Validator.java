package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class Validator<T> {
	
	
	private class Rule {
		private String name;
		private String message;
		private Predicate<T> test;
		Rule(String name, String message, Predicate<T> test) {
			this.name = name;
			this.message = message;
			this.test = test;
		}
	}
	
	private List<Rule> rules = new ArrayList<Rule>();
	

	public Validator() {
		super();
	}
	
	public Validator(List<Validator<T>.Rule> rules) {
		super();
		this.rules = rules;
	}


	public Validator<T> addRule(String name, String message, Predicate<T> test) {
		rules.add(new Rule(name, message, test));
		return this;
	}

	
	public Map<String, List<String>> validate(T t) {
		Map<String, List<String>> errors = new HashMap<String, List<String>>();
		for (Rule rule : rules) {
			if (!rule.test.test(t)) {
				if (errors.containsKey(rule.name)) {
					errors.get(rule.name).add(rule.message);
				} else {
					errors.put(rule.name, new ArrayList<String>(Arrays.asList(rule.message)));
				}
			}
		}
		return errors;
	}
	
	
}
