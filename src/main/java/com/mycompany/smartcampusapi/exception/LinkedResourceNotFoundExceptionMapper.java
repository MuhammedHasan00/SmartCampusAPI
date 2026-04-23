package com.mycompany.smartcampusapi.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import com.mycompany.smartcampusapi.model.ErrorMessage;

/**
 *
 * @author Home
 */
@Provider
public class LinkedResourceNotFoundExceptionMapper implements ExceptionMapper<LinkedResourceNotFoundException>{
    
    @Override
    public Response toResponse(LinkedResourceNotFoundException ex){
        
        ErrorMessage errorMessage = new ErrorMessage(
            ex.getMessage(), 
            422, 
            "https://myuniversity.edu/api/docs/errors"
        );
        
        return Response.status(422)
                       .entity(errorMessage)
                       .build();

    }
    
}
