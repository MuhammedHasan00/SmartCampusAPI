<<<<<<< HEAD
package com.mycompany.smartcampusapi.config;

import com.mycompany.smartcampusapi.exception.GlobalExceptionMapper;
import com.mycompany.smartcampusapi.exception.LinkedResourceNotFoundExceptionMapper;
import com.mycompany.smartcampusapi.exception.RoomNotEmptyExceptionMapper;
import com.mycompany.smartcampusapi.exception.SensorUnavailableExceptionMapper;
import com.mycompany.smartcampusapi.filter.LoggingFilter;
import com.mycompany.smartcampusapi.resource.DiscoveryResource;
import com.mycompany.smartcampusapi.resource.RoomResource;
import com.mycompany.smartcampusapi.resource.SensorResource;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import org.glassfish.jersey.jackson.JacksonFeature;

@ApplicationPath("/api/v1") //API starts at path "/api/v1"
public class AppConfig extends Application{
    
    @Override
    public Set<Class<?>> getClasses(){
        //Create an empty set to hold classes
        Set<Class<?>> classes = new HashSet<Class<?>>();
       
       //Endpoint classes
       classes.add(DiscoveryResource.class);
       classes.add(RoomResource.class);
       classes.add(SensorResource.class);
       
       //Exception Mappers
       classes.add(RoomNotEmptyExceptionMapper.class);
       classes.add(LinkedResourceNotFoundExceptionMapper.class);
       classes.add(SensorUnavailableExceptionMapper.class);
       classes.add(GlobalExceptionMapper.class);
       
       //request/response filter
       classes.add(LoggingFilter.class);

       classes.add(JacksonFeature.class);
       return classes;
    }

=======
package com.mycompany.smartcampusapi.config;

import com.mycompany.smartcampusapi.exception.GlobalExceptionMapper;
import com.mycompany.smartcampusapi.exception.LinkedResourceNotFoundExceptionMapper;
import com.mycompany.smartcampusapi.exception.RoomNotEmptyExceptionMapper;
import com.mycompany.smartcampusapi.exception.SensorUnavailableExceptionMapper;
import com.mycompany.smartcampusapi.filter.LoggingFilter;
import com.mycompany.smartcampusapi.resource.DiscoveryResource;
import com.mycompany.smartcampusapi.resource.RoomResource;
import com.mycompany.smartcampusapi.resource.SensorResource;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api/v1") //API starts at path "/api/v1"
public class AppConfig extends Application{
    
    @Override
    public Set<Class<?>> getClasses(){
        //Create an empty set to hold classes
        Set<Class<?>> classes = new HashSet<Class<?>>();
       
       //Endpoint classes
       classes.add(DiscoveryResource.class);
       classes.add(RoomResource.class);
       classes.add(SensorResource.class);
       
       //Exception Mappers
       classes.add(RoomNotEmptyExceptionMapper.class);
       classes.add(LinkedResourceNotFoundExceptionMapper.class);
       classes.add(SensorUnavailableExceptionMapper.class);
       classes.add(GlobalExceptionMapper.class);
       
       //request/response filter
       classes.add(LoggingFilter.class);

       return classes;
    }

>>>>>>> 0c4005a855cb12bdeb6593c3aefe851296445a08
}