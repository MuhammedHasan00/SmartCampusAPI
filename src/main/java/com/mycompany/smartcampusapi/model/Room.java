<<<<<<< HEAD
package com.mycompany.smartcampusapi.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Home
 */
public class Room {
    private String id;
    private String name;
    private int capacity;
    private List<String> sensorIds = new ArrayList<String>();
    
    public Room(){
    }
    
    public Room(String id, String name, int capacity){
        this.id = id;
        this.name = name;
        this.capacity = capacity;
    }
    
    //Getters
    public String getId(){
        return id;
    }
    
    public String getName(){
        return name;
    }
    
    public int getCapacity(){
        return capacity;
    }
    
    public List<String> getSensorIds(){
        return sensorIds;
    }
    
    //Setters
    public void setId(String id){
        this.id = id;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }
    
    public void setSensorIds(List<String> sensorIds){
        this.sensorIds = sensorIds;
    }
}
=======
package com.mycompany.smartcampusapi.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Home
 */
public class Room {
    private String id;
    private String name;
    private int capacity;
    private List<String> sensorIds = new ArrayList<String>();
    
    public Room(){
    }
    
    public Room(String id, String name, int capacity){
        this.id = id;
        this.name = name;
        this.capacity = capacity;
    }
    
    //Getters
    public String getId(){
        return id;
    }
    
    public String getName(){
        return name;
    }
    
    public int getCapacity(){
        return capacity;
    }
    
    public List<String> getSensorIds(){
        return sensorIds;
    }
    
    //Setters
    public void setId(String id){
        this.id = id;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }
    
    public void setSensorIds(List<String> sensorIds){
        this.sensorIds = sensorIds;
    }
}
>>>>>>> 0c4005a855cb12bdeb6593c3aefe851296445a08
