package services;

import java.util.List;

import org.hibernate.HibernateException;

import dao.BetDao;
import exceptions.SqlNotFoundException;
import exceptions.SqlUniqueContraintException;
import models.FbsBet;

/**
 * TODO Exceptions
 * 
 * All methods what return Bets
 * or update bet database
 * @author gauthier
 *
 */
public class BetService {
	private BetDao bDao = new BetDao();	
	
	public void createBet(FbsBet b) throws SqlUniqueContraintException {
		try {
			bDao.save(b);
		} catch (Exception e) {
			throw new SqlUniqueContraintException(e, b);
		}
	}
	
	public void deleteBet(FbsBet b) throws SqlNotFoundException {
		try {
			bDao.delete(b);
		} catch (Exception e) {
			throw new SqlNotFoundException(e, b);
		}
	}
	
	public void updateBet(FbsBet b) throws SqlNotFoundException {
		try {
			bDao.update(b);
		} catch (Exception e) {
			throw new SqlNotFoundException(e, b);
		}
	}	
	
	public List<FbsBet> findAllBets() {
		try {
			return bDao.findAll();
		} catch (HibernateException e) {
			throw e; // TODO explain this exception
		}
	}
}
