/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
