package main;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import models.FbsBet;
import models.FbsGroup;
import models.FbsMatch;
import models.FbsMessage;
import models.FbsUser;
import models.FbsBet.BetType;
import services.BetService;
import services.GroupService;
import services.MatchService;
import services.MessageService;
import services.UserService;
import utils.HibernateUtils;

public class Main {

	/**
	 * // TODO all cascade type (jpa&hibernate-persistence.pdf p.78)
	 * // TODO configure logs
	 * 	private transient static final Logger logger = Logger.getLogger(Menu.class); // Menu is graze main method ...
	 * import org.jboss.logging.Logger;
	 * @param args
	 */
	public static void main(String[] args) {

		/////////////////////////// API DOWNLOAD & //////////////////////////////
		/////////////////////////////// PARS/////////////////////////////////////
//		try {
//			AllNextMatchs allNextMatch = new AllNextMatchs();
//		} catch (org.json.simple.parser.ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		try (Session session = HibernateUtils.getSessionFactory().openSession()) { }

		/////////////////////////// HIBERNATE /////////////////////////////////////
		try (Session session = HibernateUtils.getSessionFactory().openSession()) { // why lazzy initialion ?
			System.out.println("Session is running");

			//// SERVICES
			UserService userService = new UserService();
			GroupService groupService = new GroupService();
			BetService betService = new BetService();
			MatchService matchService = new MatchService();

			//// FILLING DATABASE (step by step for flushing entity before writte another entity what need the first)
			
			/////////// part1 ///////////
//			FbsUser gillou = new FbsUser("gillou", "gillou@gmail.com", "gilloupassword");
//			FbsUser jeanPaul = new FbsUser("Jean-paul", "jeanpaul@gmail.com", "password");
//			FbsUser dede = new FbsUser("dédé", "dédé@gmail.com", "dédépassword");
//			userService.newUser(jeanPaul);  // => DONE
//			userService.newUser(gillou);  // => DONE
//			userService.newUser(dede);  // => DONE

			/////////// common part ///////////
			FbsUser gillou = userService.findByUserMailAndPassword("gillou@gmail.com", "gilloupassword");
			FbsUser jeanPaul = userService.findByUserMailAndPassword("jeanpaul@gmail.com", "password");
			FbsUser dede = userService.findByUserMailAndPassword("dédé@gmail.com", "dédépassword");
			
			/////////// part2 ///////////
//			FbsGroup jeanPaulGroup = new FbsGroup(jeanPaul);
//			groupService.createGroup(jeanPaulGroup); // => DONE
//			groupService.addUserToGroup(jeanPaulGroup, gillou); // => DONE
//			groupService.addUserToGroup(jeanPaulGroup, dede); // => DONE	
//			
			/////////// part3 ///////////
//			FbsGroup jeanPaulGroup = groupService.findById(userService.findAllGroupForOneUser(jeanPaul)
//										.stream()
//										.findFirst()
//										.get()
//										.getId());  // not working
			FbsGroup jeanPaulGroup = groupService.findById(4);
//			MessageService messageService = new MessageService();
//			FbsMessage messageDeJeanPaul = new FbsMessage(jeanPaul, jeanPaulGroup, new Date(),
//					"Trop bien cette app XD mdr lol !!!");
//			messageService.createMessage(messageDeJeanPaul); // => DONE
			
			
			//// SOME ERROR
			
//			groupService.findAllGroups().stream().forEach(x -> System.out.println(x)); // id = 3 -> hibernate have only
																						// one auto increment for all
																						// table
			FbsMatch omAuxerre2 = new FbsMatch();
			matchService.createMatch(omAuxerre2);
			FbsBet jeanPaulBet = new FbsBet(omAuxerre2, gillou, jeanPaulGroup, null, null, BetType.DRAW); // can't be executed cause fetch.lazy don't fetch bets
															// (noservice)
			betService.createBet(jeanPaulBet);
			



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
