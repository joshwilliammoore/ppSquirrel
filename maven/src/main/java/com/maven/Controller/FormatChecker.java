/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.Controller;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
/**
 *
 * @author Regory Gregory
 */
public class FormatChecker {
    public static String dateFormatChecker(String dateToCheck)
    {
        SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatWithTime = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        
        Date today = new Date();
        long epochToday = today.getTime()/1000/60/60/60/24;
        String feedback="nolater";
        
        long checkItInt=0;
        Date checkIt = new Date();
        
        try
        {
            checkIt = formatWithTime.parse(dateToCheck);
            checkItInt = checkIt.getTime()/1000/60/60/24;
        } 
        catch(ParseException pex)
        {
            
            feedback="badformat";
            try
            {
                
            checkIt = format.parse(dateToCheck);
            checkItInt = checkIt.getTime()/1000/60/60/24;
            
            }
            catch(ParseException pex2)
            {
            System.out.println(pex.getMessage());
            System.out.println(pex2.getMessage());
            return feedback;
            
            }
     
        }
 
            if(checkItInt>epochToday)
            {
                feedback = "later";
            }
            return feedback;
         
         

    }
    
    public static boolean isFieldEmpty(String checkIt)
    {
        return checkIt.length()>0;
    }
   
}
