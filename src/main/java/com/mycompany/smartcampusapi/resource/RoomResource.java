<<<<<<< HEAD
package com.mycompany.smartcampusapi.resource;

import com.mycompany.smartcampusapi.dao.MockDatabase;
import com.mycompany.smartcampusapi.model.Room;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import com.mycompany.smartcampusapi.exception.RoomNotEmptyException;
import javax.ws.rs.DELETE;

/**
 *
 * @author Home
 */
@Path("/rooms")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RoomResource {

    @GET
    public List<Room> getAllRooms() {
        //get all the rooms
        return new ArrayList<Room>(MockDatabase.rooms.values());
    }

    @POST
    public Response createRoom(Room room, @Context UriInfo uriInfo) {
        //error handling (esnure sensorIds is not null)
        if (room.getSensorIds() == null) {
            room.setSensorIds(new ArrayList<String>()); //empty list 
        }
        //saves room into the map
        MockDatabase.rooms.put(room.getId(), room);
        //creates URL of newly created room
        URI uri = uriInfo.getAbsolutePathBuilder().path(room.getId()).build();

        //HTTP status 201 created, room created, location header pointing to new room
        return Response.created(uri).entity(room).build();
    }

    @GET
    @Path("/{roomId}")
    public Response getRoomById(@PathParam("roomId") String roomId) {
        //searches for room in map by id
        Room room = MockDatabase.rooms.get(roomId);

        //error handling (room not found) HTTP 404 Not Found
        if (room == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Room not found")
                    .build();
        }
        
        //if room exists return HTTP 202 OK and room as JSON
        return Response.ok(room).build();

    }
    
    @DELETE
    @Path("/{roomId}")
    public Response deleteRoom(@PathParam("roomId") String roomId){
        
        //searches for room in map
        Room room = MockDatabase.rooms.get(roomId);
        
        //if room doesnt exist
        if(room == null){
            //return HTTP 404
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Room was not found!")
                    .build();
        }
        
        //handles if room has sensors requirement
        if(room.getSensorIds() != null && !room.getSensorIds().isEmpty()){
        
            throw new RoomNotEmptyException("Room " + roomId + " cannto be deleted as it contains sensors.");
        }
        
        //if room exist + no sensors then removes room
        MockDatabase.rooms.remove(roomId);
        
        return Response.ok()
                .entity("Room " + roomId + " deleted successfully!")
                .build();
    }
}
=======
package com.mycompany.smartcampusapi.resource;

import com.mycompany.smartcampusapi.dao.MockDatabase;
import com.mycompany.smartcampusapi.model.Room;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import com.mycompany.smartcampusapi.exception.RoomNotEmptyException;
import javax.ws.rs.DELETE;

/**
 *
 * @author Home
 */
@Path("/rooms")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RoomResource {

    @GET
    public List<Room> getAllRooms() {
        //get all the rooms
        return new ArrayList<Room>(MockDatabase.rooms.values());
    }

    @POST
    public Response createRoom(Room room, @Context UriInfo uriInfo) {
        //error handling (esnure sensorIds is not null)
        if (room.getSensorIds() == null) {
            room.setSensorIds(new ArrayList<String>()); //empty list 
        }
        //saves room into the map
        MockDatabase.rooms.put(room.getId(), room);
        //creates URL of newly created room
        URI uri = uriInfo.getAbsolutePathBuilder().path(room.getId()).build();

        //HTTP status 201 created, room created, location header pointing to new room
        return Response.created(uri).entity(room).build();
    }

    @GET
    @Path("/{roomId}")
    public Response getRoomById(@PathParam("roomId") String roomId) {
        //searches for room in map by id
        Room room = MockDatabase.rooms.get(roomId);

        //error handling (room not found) HTTP 404 Not Found
        if (room == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Room not found")
                    .build();
        }
        
        //if room exists return HTTP 202 OK and room as JSON
        return Response.ok(room).build();

    }
    
    @DELETE
    @Path("/{roomId}")
    public Response deleteRoom(@PathParam("roomId") String roomId){
        
        //searches for room in map
        Room room = MockDatabase.rooms.get(roomId);
        
        //if room doesnt exist
        if(room == null){
            //return HTTP 404
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Room was not found!")
                    .build();
        }
        
        //handles if room has sensors requirement
        if(room.getSensorIds() != null && !room.getSensorIds().isEmpty()){
        
            throw new RoomNotEmptyException("Room " + roomId + " cannto be deleted as it contains sensors.");
        }
        
        //if room exist + no sensors then removes room
        MockDatabase.rooms.remove(roomId);
        
        return Response.ok()
                .entity("Room " + roomId + " deleted successfully!")
                .build();
    }
}
>>>>>>> 0c4005a855cb12bdeb6593c3aefe851296445a08
