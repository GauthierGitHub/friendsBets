package dao;

import java.util.List;

import org.hibernate.Session;

import exceptions.FriendsBetsException;
import models.FbsGroup;
import models.FbsUser;
import utils.HibernateUtils;

public class GroupDao extends GenericDao<FbsGroup>{
	
	public GroupDao() {
		super(FbsGroup.class);
	}
	
}
