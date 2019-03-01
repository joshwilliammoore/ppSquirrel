package com.maven.model;

import java.util.ArrayList;
import java.util.Date;
import java.io.Serializable;
import java.text.SimpleDateFormat;


public class SubTask implements Serializable
{

    private int ID;
    private String parentID;

    private String title;
    private String description;
    private Date dateDue;
    private Date dateCreated;
    private Date dateModified;
    private int priority;
    
    private boolean completed;
    private User creator;
    private User assignee;
    public SubTask()
            {
            }
    public SubTask(Date dueDate, int priority, String title, String description)
    {
        Date currentDate = new Date();
        this.setID(SquirrelConstants.getTaskID());
        //incrementing the constant's value so that upon next creating it will have a new and incremented id.
        SquirrelConstants.setTaskID(SquirrelConstants.getTaskID()+1);
        this.setDateCreated();
        this.setDateModified(currentDate);
        this.setDateDue(dueDate);
        this.setPriority(priority);
        this.setTitle(title);
        this.setDescription(description);
        this.setCompleted(false);
    
    }
    
    
    
    public int getID() {
        return ID;
    }

    public void setID(int id) {
        this.ID = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateDue() {
        return dateDue;
    }
    
     public String getDateDueString() {
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        return f.format(dateDue);
     }
    
     public boolean setDateDueString(String date) {
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
       try{
        this.dateDue = f.parse(date);
        return true;
       } catch(Exception ex)
       {
         return false;   
       }
       
     } 
    public void setDateDue(Date dateDue) {
        
    this.dateDue = dateDue;

    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated() {
        this.dateCreated = new Date();
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed; 
   }
   
    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }
    
    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }
    
    public String getStringDate(String which)
    {
       String stringDate = null;
       SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        if(which.equals("dateCreated"))
        {
            stringDate = f.format(this.getDateCreated());
        } else if(which.equals("dateModified"))
        {
            stringDate = f.format(this.getDateModified());

        } else
        {
             stringDate = f.format(this.getDateDue());
        }
    
    
        return stringDate;
    }
}
