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
/**
 *
 * @author Regory Gregory
 */
public class Filters implements Comparator<SubTask>
{
    public static final byName BY_TITLE = new byName();
    public static final byPriority BY_PRIORITY = new byPriority();
    public static final byDate BY_DATE = new byDate();
    public static final byPerson BY_ASSIGNEE = new byPerson();
  
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
    public int compare(SubTask o1, SubTask o2)
    {
        int verdict =0;
    switch(type)
    {
        case "PERSON":
            User u1 = o1.getAssignee();
            User u2 = o2.getAssignee();
            verdict = u1.getSurname().compareTo(u2.getSurname());
            break;
        case "PRIORITY":
            verdict = o1.getPriority()-o2.getPriority();
            break;
        case "DUEDATE":
//            boolean after =o1.getDateDue().after(o2.getDateDue());
//            boolean before =o1.getDateDue().before(o2.getDateDue());
            
//           verdict = (after) ?  1 : (before) ? -1 :0;
            break;
        default:
            //maybe throw error message
            break;
    }
    return (desc)? -verdict : verdict;
    }
    
    public void sort(ArrayList<SubTask> sortable)
    {
       Collections.sort(sortable, this.getInstance());
    
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
        return s1.getPriority()-s2.getPriority();
        }

    }
      private static class byPerson implements Comparator<SubTask>{
        public int compare(SubTask s1, SubTask s2){
        return s1.getAssignee().getSurname().compareTo(s2.getAssignee().getSurname());
        }

    }
}
