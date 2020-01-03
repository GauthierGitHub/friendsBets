package main;

import exceptions.ParseException;
import models.AllNextMatchs;

public class Main {

	public static void main(String[] args) {

		System.out.println("hellog word");
		try {
			AllNextMatchs allNextMatch = new AllNextMatchs();
		} catch (org.json.simple.parser.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("yo");
	}

}
