package exceptions;

import models.FriendsBetsMessage;

public class FriendsBetsException extends Exception {


	public FriendsBetsException() {
		System.out.println("General Error");
	}
	
	public FriendsBetsException(FriendsBetsMessage m) {
		System.out.println("Message not sent : "+ m.getContent());
	}

}
