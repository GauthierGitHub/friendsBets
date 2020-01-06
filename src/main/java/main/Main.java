package main;

import org.hibernate.Session;

import exceptions.GroupNotFoudException;
import exceptions.UserNotFoudException;
import models.FriendsBetsGroup;
import models.FriendsBetsUser;
import services.GroupService;
import services.UserService;
import utils.HibernateUtils;

public class Main {

	// TODO all cascade type (jpa&hibernate-persistence.pdf p.78)
	// TODO configure logs
	public static void main(String[] args) {

		/////////////////////////// API DOWNLOAD AND PARSINT
		/////////////////////////// /////////////////////////////////////
//		try {
//			AllNextMatchs allNextMatch = new AllNextMatchs();
//		} catch (org.json.simple.parser.ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		/////////////////////////// SESSION /////////////////////////////////////
		try (Session session = HibernateUtils.getSessionfactory().openSession()) {
			System.out.println("Session is running");

			//// create one member and save it

			UserService userService = new UserService();
//			FriendsBetsUser gillou = new FriendsBetsUser("gillou", "gillou@gmail.com", "gilloupassword");
//			FriendsBetsUser jeanPaul = new FriendsBetsUser("Jean-paul", "jeanpaul@gmail.com", "password");
//			userService.newUser(jeanPaul);  // => DONE
//			userService.newUser(gillou);  // => DONE

			//// Find user in Database

			// FriendsBetsUser jeanPaulFromDB = userService.getuDao().findById(1);
			FriendsBetsUser jeanPaulFromDB = userService.findByUserMailAndPassword("jeanpaul@gmail.com", "password");
			FriendsBetsUser gilouFromDB = userService.findByUserMailAndPassword("gillou@gmail.com", "gilloupassword");
//			System.out.println(jeanPaulFromDB);
//			System.out.println(gilouFromDB);

			//// create group, add user and save it. Then display all group

			GroupService groupService = new GroupService();
//			FriendsBetsGroup jeanPaulGroup = new FriendsBetsGroup(jeanPaulFromDB);
//			groupService.createGroup(jeanPaulGroup);
//			groupService.addUserToGroup(jeanPaulGroup, gilouFromDB);
			groupService.findAllGroups().stream().forEach(x -> System.out.println(x)); // id = 3 -> hibernate have only
																						// one auto increment for all
																						// table

			//// create match
			//// create bet

		} catch (UserNotFoudException e) {
			// TODO: handle exception
			System.out.println("User not found : " + e);
//		} catch (GroupNotFoudException e) {
//			// TODO: handle exception
//			System.out.println("User not found : " + e);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error : " + e);
		}
		System.out.println("Session closed");
	}
}
