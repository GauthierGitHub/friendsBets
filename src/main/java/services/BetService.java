package services;

import java.util.List;

import dao.FriendsBetsBetDao;
import models.FriendsBetsBet;

public class BetService {
	private FriendsBetsBetDao bDao = new FriendsBetsBetDao();	
	
	public void createBet(FriendsBetsBet b) throws Exception {
		bDao.save(b);
	}
	
	public void deleteBet(FriendsBetsBet b) throws Exception {
		bDao.delete(b);
	}
	
	public void updateBet(FriendsBetsBet b) throws Exception {
		bDao.update(b);
	}
	
	public List<FriendsBetsBet> findAllBets() {
		return bDao.findAll();
	}
}
