/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.model;

/**
 *
 * @author joshw
 */
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TaskUtils {
    public static ArrayList<Task> filter(TaskList tl, User searchPhrase)
    {
        ArrayList<Task> results = new ArrayList<>();
        
       for(Task t : tl.getTasks())
       {
           if (t.getCreator().getUserName().equals( searchPhrase.getUserName())){
               results.add(t);
           }
       
       }
      
        
        return results;
    }
    //logic here pass the data and the interval (hour, day, month, year) in the type parameter and it will create
    //an ArrayList with the matching entries;
    public static ArrayList<Task> filter(TaskList tl, Date searchPhrase, String type)
    {
        ArrayList<Task> results = new ArrayList<>();

        String searchFor;
        switch (type){
            case "HOUR":
                searchFor = "yyyy-DDD-HH";
                break;
            case "DAY":
                searchFor = "yyyy-DDD";
                break;
            case "WEEK":
                searchFor = "yyyy-ww";
                break;
            case "MONTH":
                searchFor = "yyyy-MM";
                break;
            case "YEAR":
                searchFor = "yyyy";
                break;  
            default: searchFor = "yyyy-DDD";
                break;
        }
        
        SimpleDateFormat sdf1 = new SimpleDateFormat(searchFor);
       String searchString = sdf1.format(searchPhrase);
        
       for(Task t : tl.getTasks())
       {
        
         String matchString = sdf1.format( t.getCreatedDate());
         if(searchString.equals(matchString)) results.add(t);
       }
      
        
        return results;
    }
    
    
        public static ArrayList<Task> filter(TaskList tl, int searchPhrase)
    {
        ArrayList<Task> results = new ArrayList<>();
        
       for(Task t : tl.getTasks())
       {
         //comparision logic goes here
       }
      
        
        return results;
    }
    
}
