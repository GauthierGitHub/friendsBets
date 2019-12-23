package main;

public class Main {

	public static void main(String[] args) {

		System.out.println("hellog word");
		/*
		////////////// Initialization DATABASE ///////////
		UserService userServ = new UserService();
		GroupService groupServ = new GroupService();
		for (int i = 0; i < 5 ; i++) {
			User u = new User("nickname" + i, "email" + i, "password" +i);
			userServ.newUser(u);
			groupServ.createGroup(u); // 5 groups with nickname + i as admin
		}
		
		// Add users in a group1
		Group group1 = groupServ.getgDao()
				.findBy(x -> x.getId()==1)
				.get(0);
		List<User> users = userServ.getuDao()
				.findBy(x -> x.getNickname().contains("nickname"));
		
		////////// ADD
		try {
			groupServ.addUserInGroup(group1, users); // add all users except admin who already is into
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Delete one user in a group 1 (not an admin) OK
		users = userServ.getuDao()
				.findBy(x -> x.getEmail().contains("2"));
		
		////////// DELETE
		try {
			groupServ.deleteUserInGroup(group1, users, group1.getAdminGroup());
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Diplay
//		userServ.getuDao().findAll().stream()
//			.forEach(System.out::println);
		groupServ.getgDao().findAll().stream()
			.forEach(System.out::println);
		*/
	}

}
