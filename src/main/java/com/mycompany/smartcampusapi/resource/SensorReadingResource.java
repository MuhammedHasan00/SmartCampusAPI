<<<<<<< HEAD
package com.mycompany.smartcampusapi.resource;

import com.mycompany.smartcampusapi.dao.MockDatabase;
import com.mycompany.smartcampusapi.exception.SensorUnavailableException;
import com.mycompany.smartcampusapi.model.Sensor;
import com.mycompany.smartcampusapi.model.SensorReading;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
/**
 *
 * @author Home
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SensorReadingResource {
    
    //store sensor id from SensorResource
    private String sensorId;
    
    //constructor recieves id and saves it
    public SensorReadingResource(String sensorId){
        this.sensorId = sensorId;
    }
    
    @GET
    public List<SensorReading> getReadings(){
        //looks up the list of readings for sensor
        List<SensorReading> readings = MockDatabase.readings.get(sensorId);
        
        //error handling, if no readings returns empty list
        if(readings == null){
            return new ArrayList<SensorReading>();
        }
        
        return readings;
    }
    
    
    @POST
    public Response addReading(SensorReading reading, @Context UriInfo uriInfo){ //gives uri details to build the location
        Sensor sensor = MockDatabase.sensors.get(sensorId);
        
        //error handling, if sensor doesnt exist returns HTTP 404 Not Found
        if(sensor == null){
        
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Sensor was not found!")
                    .build();
        }
        
        //handling sensor being in maintenance
        if("MAINTENANCE".equalsIgnoreCase(sensor.getStatus())){
        
            throw new SensorUnavailableException("Sensor " + sensorId + " is in MAINTENANCE mode and can't accept new readings. Please try again later.");
        
        }
        
        //look up list of readings for the sensor provided
        List<SensorReading> sensorReadings = MockDatabase.readings.get(sensorId);
        
        //error handling if list doesnt exist
        if(sensorReadings == null){
            sensorReadings = new ArrayList<SensorReading>();
            MockDatabase.readings.put(sensorId, sensorReadings);
        }
        
        //appends reading to sensor history
        sensorReadings.add(reading);
        
        //updates parents sensor currentValue field
        sensor.setCurrentValue(reading.getValue());
        
        URI uri = uriInfo.getAbsolutePathBuilder().path(reading.getId()).build();
        
        return Response.created(uri).entity(reading).build();
    }
}


=======
package com.mycompany.smartcampusapi.resource;

import com.mycompany.smartcampusapi.dao.MockDatabase;
import com.mycompany.smartcampusapi.exception.SensorUnavailableException;
import com.mycompany.smartcampusapi.model.Sensor;
import com.mycompany.smartcampusapi.model.SensorReading;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
/**
 *
 * @author Home
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SensorReadingResource {
    
    //store sensor id from SensorResource
    private String sensorId;
    
    //constructor recieves id and saves it
    public SensorReadingResource(String sensorId){
        this.sensorId = sensorId;
    }
    
    @GET
    public List<SensorReading> getReadings(){
        //looks up the list of readings for sensor
        List<SensorReading> readings = MockDatabase.readings.get(sensorId);
        
        //error handling, if no readings returns empty list
        if(readings == null){
            return new ArrayList<SensorReading>();
        }
        
        return readings;
    }
    
    
    @POST
    public Response addReading(SensorReading reading, @Context UriInfo uriInfo){ //gives uri details to build the location
        Sensor sensor = MockDatabase.sensors.get(sensorId);
        
        //error handling, if sensor doesnt exist returns HTTP 404 Not Found
        if(sensor == null){
        
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Sensor was not found!")
                    .build();
        }
        
        //handling sensor being in maintenance
        if("MAINTENANCE".equalsIgnoreCase(sensor.getStatus())){
        
            throw new SensorUnavailableException("Sensor " + sensorId + " is in MAINTENANCE mode and can't accept new readings. Please try again later.");
        
        }
        
        //look up list of readings for the sensor provided
        List<SensorReading> sensorReadings = MockDatabase.readings.get(sensorId);
        
        //error handling if list doesnt exist
        if(sensorReadings == null){
            sensorReadings = new ArrayList<SensorReading>();
            MockDatabase.readings.put(sensorId, sensorReadings);
        }
        
        //appends reading to sensor history
        sensorReadings.add(reading);
        
        //updates parents sensor currentValue field
        sensor.setCurrentValue(reading.getValue());
        
        URI uri = uriInfo.getAbsolutePathBuilder().path(reading.getId()).build();
        
        return Response.created(uri).entity(reading).build();
    }
}


>>>>>>> 0c4005a855cb12bdeb6593c3aefe851296445a08
