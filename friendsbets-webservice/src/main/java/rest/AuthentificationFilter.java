package rest;

import java.io.IOException;
import java.time.Duration;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;

import models.FbsUser;
import services.UserService;

@Provider
@Priority(Priorities.AUTHENTICATION)
class AuthenticationFilter implements ContainerRequestFilter {
	private UserService ms = new UserService();

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		System.out.println("authentication filter");
		String token = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
		if (token != null) {
			System.out.println("\ttoken found : " + token);
			FbsUser m = ms.findByToken(token, Duration.ofMinutes(30), true);
			if (m != null) {
				System.out.println("\tmember found : " + m);
				requestContext.setSecurityContext(new CustomSecurityContext(m, requestContext.getSecurityContext().isSecure()));
			}
		}
	}
}