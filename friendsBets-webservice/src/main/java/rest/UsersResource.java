package rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import models.FbsUser;
import services.UserService;

/**
 * @apiNote
	xml format
		<FriendsBetsUser>
		  <alias>testREes2t2</alias>
		  <email>testRestE2a@qsdf</email>
		  <password>tesEtR2est</password>
		</FriendsBetsUser>

	json format
		<FriendsBetsUser>
		  <alias>testREes2t2</alias>
		  <email>testRestE2a@qsdf</email>
		  <password>tesEtR2est</password>
		</FriendsBetsUser>
 * @author gauthier
 *
 */
@Path("user")
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class UsersResource {
	
	private UserService ms = new UserService();

	@GET
	public Response findAll() {
		System.out.println("find all get ws ok");
		return Response
			.ok()
			.entity(new GenericEntity<List<FbsUser>>(ms.findAll()) {})
			.build();
	}

	@GET
	@Path("{id}")
	public Response findById(@PathParam("id") int id) {
		return Response
			.ok()
			.entity(ms.findById(id))
			.build();
	}
	
//	@GET
//	@Path("search/{pattern}")
//	public Response findByAliasOrEmailLike(@PathParam("pattern") String pattern) {
//		return Response
//				.ok()
//				.entity(ms.findByAliasOrEmailLike(pattern))
//				.build();
//	}

	@POST
	public Response save(FbsUser m) {
		ms.newUser(m);
		return Response.ok().build();
	}
	
	@PUT
	@Path("{id}")
	public Response update(@PathParam("id") int id, FbsUser m) {
		m.setId(id);
		ms.updateUser(m);
		return Response.ok().build();
	}

	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") int id) {
		FbsUser m = new FbsUser();
		m.setId(id);
		ms.deleteUser(m);
		return Response.ok().build();
	}
}
