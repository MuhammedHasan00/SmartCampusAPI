<<<<<<< HEAD
package com.mycompany.smartcampusapi.filter;

import java.io.IOException;
import java.util.logging.Logger;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;


/**
 *
 * @author Home
 */
@Provider
public class LoggingFilter implements ContainerRequestFilter, ContainerResponseFilter{
    
    private static final Logger LOGGER = Logger.getLogger(LoggingFilter.class.getName());
    
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException{
    
        LOGGER.info("--- Incoming Request ---");
        LOGGER.info("Method: " + requestContext.getMethod());
        LOGGER.info("URI: " + requestContext.getUriInfo().getAbsolutePath());
    }
    
    @Override
    public void filter(ContainerRequestContext requestContext,
                        ContainerResponseContext responseContext)throws IOException{
        
        //logs final status code 
        LOGGER.info("--- Outgoing Response ---");
        LOGGER.info("Status: " + responseContext.getStatus());
    
    }
    
    
}
=======
package com.mycompany.smartcampusapi.filter;

import java.io.IOException;
import java.util.logging.Logger;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;


/**
 *
 * @author Home
 */
@Provider
public class LoggingFilter implements ContainerRequestFilter, ContainerResponseFilter{
    
    private static final Logger LOGGER = Logger.getLogger(LoggingFilter.class.getName());
    
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException{
    
        LOGGER.info("--- Incoming Request ---");
        LOGGER.info("Method: " + requestContext.getMethod());
        LOGGER.info("URI: " + requestContext.getUriInfo().getAbsolutePath());
    }
    
    @Override
    public void filter(ContainerRequestContext requestContext,
                        ContainerResponseContext responseContext)throws IOException{
        
        //logs final status code 
        LOGGER.info("--- Outgoing Response ---");
        LOGGER.info("Status: " + responseContext.getStatus());
    
    }
    
    
}
>>>>>>> 0c4005a855cb12bdeb6593c3aefe851296445a08
