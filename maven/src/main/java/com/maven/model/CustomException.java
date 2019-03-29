/*******************************************************************************
Custom exception for exceptions that don't fall into any JAVA specified category
 ******************************************************************************/ 
package com.maven.model;

/**
 *
 * @author Regory Gregory
 */
public class CustomException extends Exception{
    public CustomException()
    {
    super();
    }
    
     public CustomException(String message)
    {
    super(message);
    }
}
