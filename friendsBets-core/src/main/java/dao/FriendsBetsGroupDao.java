package dao;

import models.FriendsBetsGroup;

public class FriendsBetsGroupDao extends GenericDao<FriendsBetsGroup>{
	
	public FriendsBetsGroupDao() {
		super(FriendsBetsGroup.class);
	}
	

	/**
	 * not needed cause eager fetchType in user
	 */
//	public List<FriendsBetsGroup> findAllGroupForOneUser(FriendsBetsUser u) throws GroupNotFoudException{
//		List<FriendsBetsGroup> listGroup = null;
//		// use try() close session automatically
//		try (Session s = HibernateUtils.getSessionfactory().openSession()) {
//			listGroup = findAllGroupForOneUser(s, u);
//		}catch (Exception e) {
//			throw new GroupNotFoudException();
//		}
//		return listGroup;
//	}
//
//	/**
//	 * JUST KEEP JAVA SYNTHAX WITHOUT JOIN
//	 * @param s
//	 * @param u
//	 * @return
//	 */
//	public List<FriendsBetsGroup> findAllGroupForOneUser(Session s, FriendsBetsUser u){
//		// Java - 8 JDBC.pdf p.19
//		return s.createQuery( // No SELECT ?
//				"SELECT groups "
//				+ "FROM FriendsBetsGroup g"
//				+ "INNER JOIN FriendsBetsUser u "
//				+ "WHERE g IN :u ;"  // ????
//				, FriendsBetsGroup.class)
//				.setParameter("u", u.getId())
//				.getResultList();
//	}
}
