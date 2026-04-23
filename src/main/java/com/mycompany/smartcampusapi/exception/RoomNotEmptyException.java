package com.mycompany.smartcampusapi.exception;

/**
 *
 * @author Home
 */
public class RoomNotEmptyException extends RuntimeException{
    
    public RoomNotEmptyException(String message){
        //sends message to parent
        super(message);
    
    }
    
}
