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
public class RoomNotEmptyExceptionMapper implements ExceptionMapper<RoomNotEmptyException> {

    @Override
    public Response toResponse(RoomNotEmptyException ex) {

        ErrorMessage errorMessage = new ErrorMessage(
                ex.getMessage(),
                409,
                "https://myuniversity.edu/api/docs/errors"
        );

        return Response.status(409)
                .entity(errorMessage)
                .build();

    }

}
