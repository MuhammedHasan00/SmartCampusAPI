<<<<<<< HEAD
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
=======
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
public class LinkedResourceNotFoundExceptionMapper implements ExceptionMapper<LinkedResourceNotFoundException>{
    
    @Override
    public Response toResponse(LinkedResourceNotFoundException ex){
        Map<String, Object> error = new LinkedHashMap<String, Object>();
        
        error.put("error", "LinkedResourceNotFound");
        error.put("message", ex.getMessage());
        error.put("status", 422);
        
        return Response.status(422)
                .entity(error)
                .build();
    }
    
}
>>>>>>> 0c4005a855cb12bdeb6593c3aefe851296445a08
