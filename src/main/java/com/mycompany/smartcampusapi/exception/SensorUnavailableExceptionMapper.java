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
public class SensorUnavailableExceptionMapper implements ExceptionMapper<SensorUnavailableException> {

    @Override
    public Response toResponse(SensorUnavailableException ex) {

        ErrorMessage errorMessage = new ErrorMessage(
                ex.getMessage(),
                403,
                "https://myuniversity.edu/api/docs/errors"
        );

        return Response.status(403)
                .entity(errorMessage)
                .build();

    }

}
