package main;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import exceptions.UserNotFoundException;
import models.FriendsBetsBet;
import models.FriendsBetsGroup;
import models.FriendsBetsMatch;
import models.FriendsBetsMessage;
import models.FriendsBetsUser;
import services.BetService;
import services.GroupService;
import services.MatchService;
import services.MessageService;
import services.UserService;
import utils.HibernateUtils;

public class Main {

	// TODO all cascade type (jpa&hibernate-persistence.pdf p.78)
	// TODO configure logs
	public static void main(String[] args) {

		/////////////////////////// API DOWNLOAD & //////////////////////////////
		/////////////////////////////// PARSINT/////////////////////////////////////
//		try {
//			AllNextMatchs allNextMatch = new AllNextMatchs();
//		} catch (org.json.simple.parser.ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		/////////////////////////// HIBERNATE /////////////////////////////////////
		try (Session session = HibernateUtils.getSessionfactory().openSession()) { // why lazzy initialion ?
			System.out.println("Session is running");

			//// SERVICES
			UserService userService = new UserService();
			GroupService groupService = new GroupService();
			MatchService matchService = new MatchService();
			BetService betService = new BetService();

			//// FILLING DATABASE
//			FriendsBetsUser gillou = new FriendsBetsUser("gillou", "gillou@gmail.com", "gilloupassword");
//			FriendsBetsUser jeanPaul = new FriendsBetsUser("Jean-paul", "jeanpaul@gmail.com", "password");
//			FriendsBetsUser dede = new FriendsBetsUser("dédé", "dédé@gmail.com", "dédépassword");
//			userService.newUser(jeanPaul);  // => DONE
//			userService.newUser(gillou);  // => DONE
//			userService.newUser(dede);  // => DONE
			FriendsBetsUser jeanPaulFromDB = userService.findByUserMailAndPassword("jeanpaul@gmail.com", "password");
			FriendsBetsUser gilouFromDB = userService.findByUserMailAndPassword("gillou@gmail.com", "gilloupassword");
			FriendsBetsUser dedeFromDB = userService.findByUserMailAndPassword("dédé@gmail.com", "dédépassword");
			FriendsBetsGroup jeanPaulGroup = new FriendsBetsGroup(jeanPaulFromDB);
//			groupService.createGroup(jeanPaulGroup); // => DONE
//			groupService.addUserToGroup(jeanPaulGroup, gilouFromDB); // => DONE
//			groupService.addUserToGroup(jeanPaulGroup, dedeFromDB); // => DONE
			List<FriendsBetsGroup> jeanPaulGroupList = jeanPaulFromDB.getGrpList();
			jeanPaulGroup = jeanPaulGroupList.stream().findFirst().orElseThrow();
			MessageService messageService = new MessageService();
			FriendsBetsMessage messageDeJeanPaul = new FriendsBetsMessage(jeanPaulFromDB, jeanPaulGroup, new Date(),
					"Trop bien cette app XD mdr lol !!!");
//			messageService.createMessage(messageDeJeanPaul); // => DONE
			
			//// SOME ERROR
			/* 
			groupService.findAllGroups().stream().forEach(x -> System.out.println(x)); // id = 3 -> hibernate have only
																						// one auto increment for all
																						// table
			jeanPaulGroup.getBetList().add(betOmAuxerre); // can't be executed cause fetch.lazy don't fetch bets
															// (noservice)
			 */



//		} catch (UserNotFoundException e) {
//			// TODO: handle exception
//			System.out.println("User not found : " + e);
//		} catch (GroupNotFoudException e) {
//			// TODO: handle exception
//			System.out.println("Group not found : " + e);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error : " + e);
		}
		System.out.println("Session closed");
	}
}
