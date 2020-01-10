package services;

import java.util.List;

import org.hibernate.HibernateException;

import dao.FriendsBetsBetDao;
import exceptions.SqlNotFoundException;
import exceptions.SqlUniqueContraintException;
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
	
	public void createBet(FriendsBetsBet b) throws SqlUniqueContraintException {
		try {
			bDao.save(b);
		} catch (Exception e) {
			throw new SqlUniqueContraintException(e, b);
		}
	}
	
	public void deleteBet(FriendsBetsBet b) throws SqlNotFoundException {
		try {
			bDao.delete(b);
		} catch (Exception e) {
			throw new SqlNotFoundException(e, b);
		}
	}
	
	public void updateBet(FriendsBetsBet b) throws SqlNotFoundException {
		try {
			bDao.update(b);
		} catch (Exception e) {
			throw new SqlNotFoundException(e, b);
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
