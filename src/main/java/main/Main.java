package main;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import models.Group;
import models.User;

public class Main {

	public static void main(String[] args) {

		// Initialization DATABASE
		List<User> userDB = new ArrayList<User>(); 
		for (int i = 0; i < 5; i++) {
			userDB.add(new User("nickname"+i));
		}
		
		// Initialize Groups by user with id=1
		List<Group> groupDB = new ArrayList<Group>(); 
		for (int i = 0; i < 5; i++) {
			Function<User, Group> MemberToGroup = x -> x.createGroup();
			groupDB.add(MemberToGroup.apply(userDB.get(1)));
		}
	}

}
