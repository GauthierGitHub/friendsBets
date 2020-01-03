package main;

import org.hibernate.Session;

import dao.FriendsBetsUserDao;
import exceptions.ParseException;
import utils.HibernateUtils;
import models.AllNextMatchs;
import models.FriendsBetsGroup;
import models.FriendsBetsUser;

public class Main {

	public static void main(String[] args) {

//		System.out.println("hellog word");
//		try {
//			AllNextMatchs allNextMatch = new AllNextMatchs();
//		} catch (org.json.simple.parser.ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("yo");
		try(Session session = HibernateUtils.getSessionfactory().openSession()){
			System.out.println("Session is running");
			FriendsBetsUserDao friendsBetsUserDao = new FriendsBetsUserDao();
			FriendsBetsUser friendsBetsUser = new FriendsBetsUser("Jean-paul", "jeanpaul@gmail.com", "password");
			
//			// create one member and save it
//			member1 = new Member("Paulo", "password1", "email1"); // alias is an unique contraint
//			membreDao.save(member1);

//			member1 = membreDao.findByEmailAndPassword("email1", "password1");
//			System.out.println(member1);
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("Session closed");
	}
}
