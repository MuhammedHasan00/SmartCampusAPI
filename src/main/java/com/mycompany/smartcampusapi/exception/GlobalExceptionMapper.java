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
