package rest;

import java.time.Duration;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import exceptions.AuthenticationException;
import exceptions.FriendsBetsException;
import models.FbsUser;
import services.UserService;


@Path("FriendsBetsUser")
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class AuthenticationResource {

	private UserService ms = new UserService();
	
	@POST
	@Path("login")
	public Response signin(@QueryParam("email") String email, @QueryParam("password") String password) {
		try {
//			FriendsBetsUser m = ms.findByEmailAndPassword(email, password);
//			FriendsBetsUser m = ms.signIn(email, password);
			FbsUser m;
				m = ms.findByUserMailAndPassword(email, password);
			return Response
					.ok()
					.entity(m)
					.build();
		} catch (FriendsBetsException e) { //Authentication exception ?
			return Response.status(403).entity(e.getMessage()).build();
		}
	}

	@POST
	@Path("byToken")
	public Response bytoken(@QueryParam("token") String token) {
		try {
			FbsUser m = ms.findByToken(token, Duration.ofMinutes(30), true);
			return Response.ok().entity(m).build();
		} catch (AuthenticationException e) {
			return Response.status(401).entity(e.getMessage()).build();
		}
	}
}
