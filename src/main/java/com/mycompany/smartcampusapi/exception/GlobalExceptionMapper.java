<<<<<<< HEAD
package com.mycompany.smartcampusapi.exception;

import com.mycompany.smartcampusapi.model.ErrorMessage;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Home
 */
@Provider
public class GlobalExceptionMapper implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable ex) {

        ErrorMessage errorMessage = new ErrorMessage(
                ex.getMessage(),
                500,
                "https://myuniversity.edu/api/docs/errors"
        );

        return Response.status(500)
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
public class GlobalExceptionMapper implements ExceptionMapper<Throwable>{
    
    @Override
    public Response toResponse(Throwable ex){
        Map<String, Object> error = new LinkedHashMap<String, Object>();
       
        error.put("error", "InternalServerError");
        error.put("message", "An unexpected error has occured!");
        error.put("status", 500);
        
        System.err.println("Error: " + ex.getMessage());
        
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(error)
                .build();
    }
    
}
>>>>>>> 0c4005a855cb12bdeb6593c3aefe851296445a08
