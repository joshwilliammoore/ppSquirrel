/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author joshw
 */
import java.util.ArrayList;
import java.util.Date;
public class TaskUtils {
    public static ArrayList<Task> searchFor(TaskList tl, User searchPhrase)
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
    
    public static ArrayList<Task> searchFor(TaskList tl, Date searchPhrase)
    {
        ArrayList<Task> results = new ArrayList<>();
        
       for(Task t : tl.getTasks())
       {
         //comparision logic goes here
       }
      
        
        return results;
    }
    
    
        public static ArrayList<Task> searchFor(TaskList tl, int searchPhrase)
    {
        ArrayList<Task> results = new ArrayList<>();
        
       for(Task t : tl.getTasks())
       {
         //comparision logic goes here
       }
      
        
        return results;
    }
    
}
