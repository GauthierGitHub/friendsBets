package rest;

import java.security.Principal;

import javax.ws.rs.core.SecurityContext;

import models.FbsUser;


public class CustomSecurityContext implements SecurityContext {
	   private final FbsUser m;
	   private final boolean secure;

	   public CustomSecurityContext(FbsUser m, boolean secure) {
	       this.m = m;
	       this.secure = secure;
	   }

	   @Override
	   public Principal getUserPrincipal() {
	       return new Principal() {
	           @Override
	           public String getName() {
	                return m.getEmail();
	           }
	       };
	   }

	   @Override
	   public String getAuthenticationScheme() {
	       return SecurityContext.DIGEST_AUTH;
	   }

	   @Override
	   public boolean isSecure() { return secure; }

	   @Override
	   public boolean isUserInRole(String role) {
//	       return m.hasRole(role);
	       // TODO: ???
	       return true;
	   }
	}