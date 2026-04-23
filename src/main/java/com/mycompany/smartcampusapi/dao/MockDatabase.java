package com.mycompany.smartcampusapi.dao;

import com.mycompany.smartcampusapi.model.Room;
import com.mycompany.smartcampusapi.model.Sensor;
import com.mycompany.smartcampusapi.model.SensorReading;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *
 * @author Home
 */
public class MockDatabase {
    
    public static Map<String, Room> rooms = new HashMap<String, Room>();
    public static Map<String, Sensor> sensors = new HashMap<String, Sensor>();
    public static Map<String, List<SensorReading>> readings = new HashMap<String, List<SensorReading>>();
    
    static{
        Room room1 = new Room("LIB", "Library", 80);
        Room room2 = new Room("LAB-67","Computer Lab 67", 40);
        
        rooms.put(room1.getId(), room1);
        rooms.put(room2.getId(), room2);
        
        Sensor sensor1 = new Sensor("TEMP-001","TEMPERATURE","ACTIVE",22.3,"LIB");
        Sensor sensor2 = new Sensor("CO2-002","CO2","ACTIVE",420.0,"LAB-67");
        
        sensors.put(sensor1.getId(), sensor1);
        sensors.put(sensor2.getId(), sensor2);
        
        room1.getSensorIds().add(sensor1.getId());
        room2.getSensorIds().add(sensor2.getId());
        
        readings.put(sensor1.getId(), new ArrayList<SensorReading>());
        readings.put(sensor2.getId(), new ArrayList<SensorReading>());
        
     
    }
    private MockDatabase(){
        }
}
