package dao;

import models.FbsMessage;

public class MessageDao extends GenericDao<FbsMessage>{

	public MessageDao() {
		super(FbsMessage.class);
	}
}
