package rest;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

@ApplicationPath("")
public class RestApplication extends ResourceConfig {
	
	public RestApplication() {
		System.out.println("RestApplication is running");
		packages("rest");
	    register(ObjectMapperContextResolver.class);
	    register(DebugMapper.class);
	    register(AngularCorsFilter.class);
	    register(JacksonJaxbJsonProvider.class);
	}

}
