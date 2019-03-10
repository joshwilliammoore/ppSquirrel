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
    private Date dueDate;
    private Date createdDate;
    private Date modifiedDate;
    private int priority;
    private boolean completed;

   
    private User creator;

    
    private User assignee;
    
    public SubTask(Date dueDate, int priority, String title, String description)
    {
        Date currentDate = new Date();
        this.setID(SquirrelConstants.getTaskID());
        //incrementing the constant's value so that upon next creating it will have a new and incremented id.
        SquirrelConstants.setTaskID(SquirrelConstants.getTaskID()+1);
        this.setCreatedDate(currentDate);
        this.setModifiedDate(currentDate);
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

        Date currentDate = new Date();
        if(currentDate.before(dueDate)){
                this.dueDate = dueDate;

        } else {
            
            //error handling should come here!!!
            System.out.println("Error!!!!");
        }
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
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
}
