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
    public static boolean dateFormatChecker(String dateToCheck)
    {
        SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy");
        Date today = new Date();
        long epochToday = today.getTime();
        try{
            Date checkIt = format.parse(dateToCheck);
            long checkItInt = checkIt.getTime();
            if(checkItInt>epochToday)
            {
                return true;
            }
         
        } catch(ParseException pex)
        {
         System.out.println(pex.getMessage());
        }
        return false;

    }
    
}
