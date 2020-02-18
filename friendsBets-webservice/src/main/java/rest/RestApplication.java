package rest;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("")
public class RestApplication extends ResourceConfig {
	
	public RestApplication() {
		System.out.println("ok");
		packages("rest");
	    register(ObjectMapperContextResolver.class);
	    register(DebugMapper.class);
	    register(AngularCorsFilter.class);
	}

}
