/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.Controller;

import com.maven.model.SquirrelConstants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Comparator;
import java.util.Collections;

import com.maven.model.Task;
import com.maven.model.TaskList;
import com.maven.model.SubTask;
import com.maven.model.User;
import java.util.Arrays;
import javax.swing.JOptionPane;
/**
 *
 * @author Regory Gregory
 */
public class Filters
        
{
    public static final byName FILTER_BY_TITLE = new byName();
    public static final byPriority FILTER_BY_PRIORITY = new byPriority();
    public static final byDate FILTER_BY_DATE = new byDate();
    public static final byPerson FILTER_BY_ASSIGNEE = new byPerson();
    public static final byCompletion FILTER_BY_COMPLETION = new byCompletion();
    public static final SearchInTitle SEARCH_BY_TITLE = new SearchInTitle();
    public static final SearchForPriority SEARCH_BY_PRIORITY = new SearchForPriority();
    public static final SearchInDescription SEARCH_BY_DESCRIPTION = new SearchInDescription();
    public static final SearchForDueDate SEARCH_BY_DUEDATE = new SearchForDueDate();
    public static final SearchForAssignee SEARCH_BY_ASSIGNEE = new SearchForAssignee();

    
    private String type;
    private boolean desc;
    private Filters instance;

  
  //so that it cannot be instantiated
  private Filters()
  {}
  public Filters getInstance()
  {
      if(this.instance==null)
      {
          this.instance = new Filters();
      }
  return this.instance;
  }
  
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isDesc() {
        return desc;
    }

    public void setDesc(boolean desc) {
        this.desc = desc;
    }

    
     public static String returnRelative(String instance, boolean up)
    {
            String[] checkArray = SquirrelConstants.getListMap();
            int index = Arrays.asList(checkArray).indexOf(instance);
            if(index>0 && up==false)
            {
                index-=1;
            } else if (index<checkArray.length-1 && up==true)
            {
                index+=1;
            }
    return Arrays.asList(checkArray).get(index);
    }
     
    public static class SearchInTitle
    {
          public ArrayList<SubTask> search(SubTask[] source, String phrase)
        {
            ArrayList<SubTask> results = new ArrayList<>();
            String regex = ".*"+phrase+".*";    
            for(SubTask st : source)
               {
                 if(st.getTitle().matches(regex)) results.add(st);  
               }
            return results;
        }
        
    } 
    
    public static class SearchForPriority
    {
         public ArrayList<SubTask> search(SubTask[] source, String priority)
        {
            ArrayList<SubTask> results = new ArrayList<>();
                for(SubTask st : source)
                {
                    if(st.getPriorityOrder()==Integer.parseInt(priority))
                    {
                        results.add(st);
                    }
                }
            return results;
        }
        
    } 
    
    
    
    public static class SearchInDescription
    {
         public ArrayList<SubTask> search(SubTask[] source, String phrase)
        {
            ArrayList<SubTask> results = new ArrayList<>();
            String regex = ".*"+phrase+".*";    
            for(SubTask st : source)
               {
                 if(st.getDescription().matches(regex)) results.add(st);  
               }
            return results;
        }
        
    } 
    
    public static class SearchForDueDate
    {
         public ArrayList<SubTask> search(SubTask[] source, Date date)
        {
            JOptionPane.showMessageDialog(null, date.getTime());
            ArrayList<SubTask> results = new ArrayList<>();
             for(SubTask st : source)
            {
                if(st.getDueDate().getTime()==date.getTime())
                {
                    results.add(st);
                }
            }
            return results;
        }
    
    }
    
      public static class SearchForAssignee
    {
         public ArrayList<SubTask> search(SubTask[] source, String userName)
        {
            ArrayList<SubTask> results = new ArrayList<>();
             for(SubTask st : source)
            {
                if(st.getUser().getUserName().equals(userName))
                {
                    results.add(st);
                }
            }
            return results;
        }
    
    }
    
    
      private static class byCompletion implements Comparator<SubTask>{
        public int compare(SubTask s1, SubTask s2){
        int result = (s1.isCompleted()==s2.isCompleted())? 0 : (s1.isCompleted()) ? 1:-1;    
        return result;
        }
    }
    private static class byDate implements Comparator<SubTask>{
        public int compare(SubTask s1, SubTask s2){
        int result = (s1.getDueDate().getTime()==s2.getDueDate().getTime())? 0 : (s1.getDueDate().getTime()>s2.getDueDate().getTime()) ? 1:-1;    
        return result;
        }
    }
    private static class byName implements Comparator<SubTask>{
        public int compare(SubTask s1, SubTask s2){
        return s1.getTitle().compareTo(s2.getTitle());
        }

    }
     private static class byPriority implements Comparator<SubTask>{
        public int compare(SubTask s1, SubTask s2){
        return s1.getPriorityOrder()-s2.getPriorityOrder();
        }

    }
      private static class byPerson implements Comparator<SubTask>{
        public int compare(SubTask s1, SubTask s2){
        return s1.getUser().getUserName().compareTo(s2.getUser().getUserName());
        }

    }
}
