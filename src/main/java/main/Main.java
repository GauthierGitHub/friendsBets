package main;

import java.util.List;

import exceptions.MyException;
import models.Group;
import models.User;
import services.GroupService;
import services.UserService;

public class Main {

	public static void main(String[] args) {

		// Initialization DATABASE
		UserService userServ = new UserService();
		GroupService groupServ = new GroupService();
		for (int i = 0; i < 3 ; i++) {
			User u = new User("nickname" + i, "email" + i, "password" +i);
			userServ.newUser(u);
			groupServ.createGroup(u); // 5 groups with nickname + i as admin
		}
		
		// Add users in a group
		Group group0 = groupServ.getgDao()
				.findBy(x -> x.getId()==1)
				.get(0);
		List<User> users = userServ.getuDao()
				.findBy(x -> x.getNickname().contains("nickname"));
		try {
			groupServ.addUserInGroup(group0, users);
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Diplay
//		userServ.getuDao().findAll().stream()
//			.forEach(System.out::println);
		groupServ.getgDao().findAll().stream()
			.forEach(System.out::println);
		
	}

}
