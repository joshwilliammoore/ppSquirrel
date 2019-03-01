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
        Date today = new Date();
        long epochToday = today.getTime()/1000/60/60/60/24;
        try{
            Date checkIt = format.parse(dateToCheck);
            long checkItInt = checkIt.getTime()/1000/60/60/24;
            if(checkItInt>epochToday)
            {
                return "later";
            }
            return "notlater";
        } catch(ParseException pex)
        {
            System.out.println(pex.getMessage());
        }
         return "badformat";

    }
    
    public static boolean isFieldEmpty(String checkIt)
    {
        return checkIt.length()>0;
    }
   
}
