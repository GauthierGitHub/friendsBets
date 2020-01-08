package services;

import java.util.List;

import org.hibernate.HibernateException;

import dao.FriendsBetsBetDao;
import exceptions.BetNotFoundException;
import models.FriendsBetsBet;

/**
 * TODO Exceptions
 * 
 * All methods what return Bets
 * or update bet database
 * @author gauthier
 *
 */
public class BetService {
	private FriendsBetsBetDao bDao = new FriendsBetsBetDao();	
	
	public void createBet(FriendsBetsBet b) throws Exception {
		bDao.save(b);
	}
	
	public void deleteBet(FriendsBetsBet b) throws Exception {
		try {
			bDao.delete(b);
		} catch (Exception e) {
			throw new BetNotFoundException();
		}
	}
	
	public void updateBet(FriendsBetsBet b) throws Exception {
		try {
			bDao.update(b);
		} catch (Exception e) {
			throw new BetNotFoundException();
		}
	}	
	
	public List<FriendsBetsBet> findAllBets() {
		try {
			return bDao.findAll();
		} catch (HibernateException e) {
			throw e; // TODO explain this exception
		}
	}
}
