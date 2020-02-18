package dao;

import models.FbsGroup;

public class GroupDao extends GenericDao<FbsGroup>{
	
	public GroupDao() {
		super(FbsGroup.class);
	}
	

	/**
	 * not needed cause eager fetchType in user
	 */
//	public List<FbsGroup> findAllGroupForOneUser(FbsUser u) throws GroupNotFoudException{
//		List<FbsGroup> listGroup = null;
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
//	public List<FbsGroup> findAllGroupForOneUser(Session s, FbsUser u){
//		// Java - 8 JDBC.pdf p.19
//		return s.createQuery( // No SELECT ?
//				"SELECT groups "
//				+ "FROM FbsGroup g"
//				+ "INNER JOIN FbsUser u "
//				+ "WHERE g IN :u ;"  // ????
//				, FbsGroup.class)
//				.setParameter("u", u.getId())
//				.getResultList();
//	}
}
