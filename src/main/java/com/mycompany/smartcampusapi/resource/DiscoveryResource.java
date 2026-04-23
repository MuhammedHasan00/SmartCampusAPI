<<<<<<< HEAD
package com.mycompany.smartcampusapi.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Home
 */

@Path("/")
public class DiscoveryResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getApiInfo() {
        return "{"
                + "\"api\":\"Smart Campus Sensor and Room Management API\","
                + "\"version\":\"v1\","
                + "\"contact\":\"adminSmartCampus@gmail.com\","
                + "\"resources\":{"
                + "\"rooms\":\"/api/v1/rooms\","
                + "\"sensors\":\"/api/v1/sensors\""
                + "}"
                + "}";
    }
=======
package com.mycompany.smartcampusapi.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Home
 */

@Path("/")
public class DiscoveryResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getApiInfo() {
        return "{"
                + "\"api\":\"Smart Campus Sensor and Room Management API\","
                + "\"version\":\"v1\","
                + "\"contact\":\"adminSmartCampus@gmail.com\","
                + "\"resources\":{"
                + "\"rooms\":\"/api/v1/rooms\","
                + "\"sensors\":\"/api/v1/sensors\""
                + "}"
                + "}";
    }
>>>>>>> 0c4005a855cb12bdeb6593c3aefe851296445a08
}