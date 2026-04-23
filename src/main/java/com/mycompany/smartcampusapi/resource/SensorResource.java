<<<<<<< HEAD
package com.mycompany.smartcampusapi.resource;

import com.mycompany.smartcampusapi.dao.MockDatabase;
import com.mycompany.smartcampusapi.exception.LinkedResourceNotFoundException;
import com.mycompany.smartcampusapi.model.Room;
import com.mycompany.smartcampusapi.model.Sensor;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Home
 */
@Path("/sensors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SensorResource {

    @GET
    public List<Sensor> getAllSensors(@QueryParam("type") String type) {

        //list to store matching sensors
        List<Sensor> result = new ArrayList<Sensor>();

        //loop through all sensors in the map
        for (Map.Entry<String, Sensor> entry : MockDatabase.sensors.entrySet()) {

            //gets sensor object from map
            Sensor sensor = entry.getValue();

            //if no type add every sensor to the list
            if (type == null || type.trim().isEmpty()) {

                result.add(sensor);
                //if type provided only add the sensor if type matches
            } else if (sensor.getType() != null && sensor.getType().equalsIgnoreCase(type)) {

                result.add(sensor);
            }
        }

        return result;
    }

    //post requests
    @POST
    public Response createSensor(Sensor sensor, @Context UriInfo uriInfo) { //JSON converted to Sensor object

        //look up room from posted sensor
        Room room = MockDatabase.rooms.get(sensor.getRoomId());

        //if room does exist throw
        if (room == null) {
            throw new LinkedResourceNotFoundException("Sensor not created because roomId " + sensor.getRoomId() + " doesn't exist.");
        }

        //stores new sensor in map
        MockDatabase.sensors.put(sensor.getId(), sensor);

        //ensure the room has a sensor id list
        if (room.getSensorIds() == null) {
            room.setSensorIds(new ArrayList<String>());
        }

        //adds new sensor to sensor list
        room.getSensorIds().add(sensor.getId());

        //creates empty reading list for sensor
        if (!MockDatabase.readings.containsKey(sensor.getId())) {
            MockDatabase.readings.put(sensor.getId(), new ArrayList<com.mycompany.smartcampusapi.model.SensorReading>());
        }

        //builds location of new sensor resource
        URI uri = uriInfo.getAbsolutePathBuilder().path(sensor.getId()).build();

        //status 201 created
        return Response.created(uri).entity(sensor).build();
    }

    @Path("/{sensorId}/readings")
    public SensorReadingResource getSensorReadingResource(@PathParam("sensorId") String sensorId) {
        return new SensorReadingResource(sensorId);
    }
}
=======
package com.mycompany.smartcampusapi.resource;

import com.mycompany.smartcampusapi.dao.MockDatabase;
import com.mycompany.smartcampusapi.exception.LinkedResourceNotFoundException;
import com.mycompany.smartcampusapi.model.Room;
import com.mycompany.smartcampusapi.model.Sensor;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Home
 */
@Path("/sensors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SensorResource {

    @GET
    public List<Sensor> getAllSensors(@QueryParam("type") String type) {

        //list to store matching sensors
        List<Sensor> result = new ArrayList<Sensor>();

        //loop through all sensors in the map
        for (Map.Entry<String, Sensor> entry : MockDatabase.sensors.entrySet()) {

            //gets sensor object from map
            Sensor sensor = entry.getValue();

            //if no type add every sensor to the list
            if (type == null || type.trim().isEmpty()) {

                result.add(sensor);
                //if type provided only add the sensor if type matches
            } else if (sensor.getType() != null && sensor.getType().equalsIgnoreCase(type)) {

                result.add(sensor);
            }
        }

        return result;
    }

    //post requests
    @POST
    public Response createSensor(Sensor sensor, @Context UriInfo uriInfo) { //JSON converted to Sensor object

        //look up room from posted sensor
        Room room = MockDatabase.rooms.get(sensor.getRoomId());

        //if room does exist throw
        if (room == null) {
            throw new LinkedResourceNotFoundException("Sensor not created because roomId " + sensor.getRoomId() + " doesn't exist.");
        }

        //stores new sensor in map
        MockDatabase.sensors.put(sensor.getId(), sensor);

        //ensure the room has a sensor id list
        if (room.getSensorIds() == null) {
            room.setSensorIds(new ArrayList<String>());
        }

        //adds new sensor to sensor list
        room.getSensorIds().add(sensor.getId());

        //creates empty reading list for sensor
        if (!MockDatabase.readings.containsKey(sensor.getId())) {
            MockDatabase.readings.put(sensor.getId(), new ArrayList<com.mycompany.smartcampusapi.model.SensorReading>());
        }

        //builds location of new sensor resource
        URI uri = uriInfo.getAbsolutePathBuilder().path(sensor.getId()).build();

        //status 201 created
        return Response.created(uri).entity(sensor).build();
    }

    @Path("/{sensorId}/readings")
    public SensorReadingResource getSensorReadingResource(@PathParam("sensorId") String sensorId) {
        return new SensorReadingResource(sensorId);
    }
}
>>>>>>> 0c4005a855cb12bdeb6593c3aefe851296445a08
