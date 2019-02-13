/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.Task;
import model.TaskList;
import model.SubTask;
import model.User;
import java.util.Comparator;
import java.util.Collections;

/**
 *
 * @author Regory Gregory
 */
public class Filters implements Comparator<SubTask>
{

  
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
            boolean after =o1.getDueDate().after(o2.getDueDate());
            boolean before =o1.getDueDate().before(o2.getDueDate());
            
           verdict = (after) ?  1 : (before) ? -1 :0;
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
}
