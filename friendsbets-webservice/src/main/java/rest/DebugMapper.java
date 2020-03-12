package rest;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class DebugMapper implements ExceptionMapper<Throwable> {
    public Response toResponse(Throwable t) { //superclasse de exception
        t.printStackTrace();
        return Response.serverError()
            .entity(t.getMessage())
            .build();
    }
}