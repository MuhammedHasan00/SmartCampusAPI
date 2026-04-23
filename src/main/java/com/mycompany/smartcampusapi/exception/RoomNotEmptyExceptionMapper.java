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
public class RoomNotEmptyExceptionMapper implements ExceptionMapper<RoomNotEmptyException>{
    
    @Override
    public Response toResponse(RoomNotEmptyException ex){
        Map<String, Object> error = new LinkedHashMap<String, Object>();
        
        error.put("error", "RoomNotEmpty");
        error.put("message", ex.getMessage());
        error.put("status", 409);
        
        return Response.status(Response.Status.CONFLICT)
                .entity(error)
                .build();
    }
    
    
}
