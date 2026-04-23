package com.mycompany.smartcampusapi.exception;

/**
 *
 * @author Home
 */
public class SensorUnavailableException extends RuntimeException{
    
    public SensorUnavailableException(String message) {
        //sends message to parent
        super(message);
    }
}
