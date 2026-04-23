<<<<<<< HEAD
package com.mycompany.smartcampusapi.model;

/**
 *
 * @author Home
 */
public class SensorReading {
    
    private String id;
    private long timestamp;
    private double value;
    
    public SensorReading(){
    }
    
    public SensorReading(String id, long timestamp, double value){
        this.id = id;
        this.timestamp = timestamp;
        this.value = value;
    }
    
    //Getters
    public String getId(){
        return id;
    }
    
    public long getTimestamp(){
        return timestamp;
    }
    
    public double getValue(){
        return value;
    }
    
    
    //Setters
    public void setId(String id){
        this.id = id;
    }
    
    public void setTimestamp(long timestamp){
        this.timestamp = timestamp;
    }
    
    public void setValue(double value){
        this.value = value;
    }
}
=======
package com.mycompany.smartcampusapi.model;

/**
 *
 * @author Home
 */
public class SensorReading {
    
    private String id;
    private long timestamp;
    private double value;
    
    public SensorReading(){
    }
    
    public SensorReading(String id, long timestamp, double value){
        this.id = id;
        this.timestamp = timestamp;
        this.value = value;
    }
    
    //Getters
    public String getId(){
        return id;
    }
    
    public long getTimestamp(){
        return timestamp;
    }
    
    public double getValue(){
        return value;
    }
    
    
    //Setters
    public void setId(String id){
        this.id = id;
    }
    
    public void setTimestamp(long timestamp){
        this.timestamp = timestamp;
    }
    
    public void setValue(double value){
        this.value = value;
    }
}
>>>>>>> 0c4005a855cb12bdeb6593c3aefe851296445a08
