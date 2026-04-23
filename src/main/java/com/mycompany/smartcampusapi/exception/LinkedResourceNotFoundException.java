package com.mycompany.smartcampusapi.exception;

/**
 *
 * @author Home
 */
public class LinkedResourceNotFoundException extends RuntimeException{
    
    public LinkedResourceNotFoundException(String message){
        //sends message to parent
        super(message);
    
    }
    
}
