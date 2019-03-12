package com.maven.model;

import java.util.ArrayList;
import java.util.Date;
import java.io.Serializable;
import java.text.SimpleDateFormat;


public class SubTask implements Serializable
{

    protected int ID;
    protected String parentID;

    protected String title;
    protected String description;
    protected Date dueDate;
    protected Date createdDate;
    protected Date modifiedDate;
    protected int priority;
    protected boolean completed;

   
    protected User creator;

    
    protected User assignee;
    public SubTask(){}
    public SubTask(Date dueDate, int priority, String title, String description)
    {
        this.setID(SquirrelConstants.getTaskID());
        //incrementing the constant's value so that upon next creating it will have a new and incremented id.
        SquirrelConstants.setTaskID(SquirrelConstants.getTaskID()+1);
        this.setCreatedDate();
        this.setModifiedDateDefault();
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

    public Date getDueDate() {
        return dueDate;
    }

    
     public String getDateDueString() {
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        return f.format(this.dueDate);
     }
    
     public boolean setDateDueString(String date) {
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
       try{
        this.dueDate = f.parse(date);
        return true;
       } catch(Exception ex)
       {
         return false;   
       }
       
     } 
    public void setDateDue(Date dateDue) {
       
        
        //there is an error, you will have to debug it later on...
        Date currentDate = new Date();
        
        if(!currentDate.before(dateDue)){
                this.dueDate = dateDue;

        } else {
            
            //error handling should come here!!!
            System.out.println("Error!!!!");
        }
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate() {
        this.createdDate = new Date();
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date d) {
        this.modifiedDate = d;
    }
     public void setModifiedDateDefault() {
        this.modifiedDate = new Date();
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
            stringDate = f.format(this.getCreatedDate());
        } else if(which.equals("dateModified"))
        {
            stringDate = f.format(this.getCreatedDate());

        } else
        {
             stringDate = f.format(this.getCreatedDate());
        }

        return stringDate;
    }

    public String getParentID() {
        return parentID;
    }

    public void setParentID(String parentID) {
        this.parentID = parentID;
    }

    
    
}
