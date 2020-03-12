package rest;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Provider
public class ObjectMapperContextResolver implements ContextResolver<ObjectMapper> {

	private final ObjectMapper mapper;

	public ObjectMapperContextResolver() {
		mapper = new ObjectMapper();
	    mapper.registerModule(new JavaTimeModule());
	}

	@Override
	public ObjectMapper getContext(Class<?> type) {
		return mapper;
	}

}