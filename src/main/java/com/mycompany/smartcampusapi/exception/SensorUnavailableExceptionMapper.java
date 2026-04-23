package com.mycompany.smartcampusapi.exception;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Home
 */
@Provider
public class SensorUnavailableExceptionMapper implements ExceptionMapper<SensorUnavailableException>{
    
    @Override
    public Response toResponse(SensorUnavailableException ex){
        Map<String, Object> error = new LinkedHashMap<String, Object>();
        
        error.put("error", "SensorUnavailable");
        error.put("message", ex.getMessage());
        error.put("status", 403);
        
        return Response.status(Response.Status.FORBIDDEN)
                .entity(error)
                .build();
    }
    
}