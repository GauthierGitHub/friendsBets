package main;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import exceptions.UserNotFoudException;
import models.FriendsBetsBet;
import models.FriendsBetsGroup;
import models.FriendsBetsMatch;
import models.FriendsBetsUser;
import services.BetService;
import services.GroupService;
import services.MatchService;
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
//			FriendsBetsUser dede = new FriendsBetsUser("dédé", "dédé@gmail.com", "dédépassword");
//			userService.newUser(jeanPaul);  // => DONE
//			userService.newUser(gillou);  // => DONE
//			userService.newUser(dede);  // => DONE

			//// Find user in Database

			// FriendsBetsUser jeanPaulFromDB = userService.getuDao().findById(1);
			FriendsBetsUser jeanPaulFromDB = userService.findByUserMailAndPassword("jeanpaul@gmail.com", "password");
			System.out.println(jeanPaulFromDB);
			FriendsBetsUser gilouFromDB = userService.findByUserMailAndPassword("gillou@gmail.com", "gilloupassword");
			FriendsBetsUser dedeFromDB = userService.findByUserMailAndPassword("dédé@gmail.com", "dédépassword");

			//// create group, add user and save it. Then display all group

			GroupService groupService = new GroupService();
//			FriendsBetsGroup jeanPaulGroup = new FriendsBetsGroup(jeanPaulFromDB);
//			groupService.createGroup(jeanPaulGroup); // => DONE
//			groupService.addUserToGroup(jeanPaulGroup, gilouFromDB); // => DONE
//			groupService.addUserToGroup(jeanPaulGroup, dedeFromDB); // => DONE
			List<FriendsBetsGroup> jeanPaulGroupList = jeanPaulFromDB.getGrpList();
			FriendsBetsGroup jeanPaulGroup = jeanPaulGroupList.stream().findFirst().orElseThrow();
//			groupService.findAllGroups().stream().forEach(x -> System.out.println(x)); // id = 3 -> hibernate have only
//																						// one auto increment for all
//																						// table

			//// create match & bet
			MatchService matchService = new MatchService();
			BetService betService = new BetService();
			FriendsBetsMatch omAuxerre = new FriendsBetsMatch();
			Set<FriendsBetsUser> followers = new HashSet<FriendsBetsUser>();
			followers.add(jeanPaulFromDB);
			FriendsBetsBet betOmAuxerre = new FriendsBetsBet(omAuxerre, dedeFromDB, jeanPaulGroup, followers,
					"Un resto", FriendsBetsBet.BetType.WINNER);
			System.out.println(betOmAuxerre);
			matchService.createMatch(omAuxerre);
			betService.createBet(betOmAuxerre);
			//jeanPaulGroup.getBetList().add(betOmAuxerre);

		} catch (UserNotFoudException e) {
			// TODO: handle exception
			System.out.println("User not found : " + e);
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
