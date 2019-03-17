package com.maven.model;

import static com.maven.model.SquirrelConstants.incrementSubtaskCounter;
import java.util.ArrayList;
import java.util.Date;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import static java.time.Instant.now;
import java.util.Comparator;
import java.text.ParseException;

public class SubTask implements Serializable 
{

    protected int ID;

    protected String title;
    
    protected String description;
    
    protected String completionDate;
    
    protected Date dueDate;
    
    protected Date createdDate;
    
    protected Date modifiedDate;
    
    protected int priorityOrder;
    
    protected boolean completed;
    
    protected boolean deleted;

    protected User creator;

    protected User user;
    
    protected String parentID;
    
//    public SubTask(String description, String completionDate, int priorityOrder){
//        setID();
//        setTitle(description);
//        setDescription(description);
//        setDateDueString(completionDate);
//        setCreatedDate();
//        setPriorityOrder(priorityOrder);
//        setCompleted(false);
//        setDeleted(false);
//        
//        
//    }
    
    public SubTask(){
        this.setID();
        this.setDeleted(false);
        this.setCreatedDate();
        this.setModifiedDateDefault();
        this.setCompleted(false);
    
    }
    public SubTask(Date dueDate, int priority, String title, String description)
    {
        this.setID();
        //incrementing the constant's value so that upon next creating it will have a new and incremented id.
        SquirrelConstants.setTaskID(SquirrelConstants.getTaskID()+1);
        this.setCreatedDate();
        this.setModifiedDateDefault();
        this.setDueDate(dueDate);
        this.setPriorityOrder(priority);
        this.setTitle(title);
        this.setDescription(description);
        this.setCompleted(false);
    
    }
    public void JSONCorrection()
    {
     this.setTitle(this.getDescription());
     SimpleDateFormat smf = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss aa");
     try{
        this.setDueDate(smf.parse(this.getCompletionDate()));
 
     } catch (ParseException e)
     {  
         System.out.println("Parse error when converting completion date:"+this.getCompletionDate());
         e.getStackTrace();
     }catch (Exception e)
     {  
         System.out.println("Parse error when converting completion date:"+this.getCompletionDate());
         e.getStackTrace();
     }
    }
    
  
    //this is here for inheritance reasons
    public void addChild(SubTask c){}
    
    
    
    public int getID() {
        return ID;
    }

    public void setID() {
        this.ID = SquirrelConstants.getSubtaskCounter();
    }

    public String getTitle() {
        if(this.title.equals(null))
        {
        return this.description;
        }
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
    public void setDueDate(Date dateDue) {
       
        
        //there is an error, you will have to debug it later on...
        Date currentDate = new Date();
        
//        if(!currentDate.before(dateDue)){
                this.dueDate = dateDue;

//        } else {
//            
//            //error handling should come here!!!
//            System.out.println("Error!!!!");
//        }
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
    public int getPriorityOrder() {
        return priorityOrder;
    }

    public void setPriorityOrder(int priorityOrder) {
        this.priorityOrder = priorityOrder;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed; 
   }
    
    public boolean isDeleted(){
        return deleted;
    }
    
    public void setDeleted(boolean deleted){
        this.deleted = deleted;
    }
   
    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
            stringDate = f.format(this.getModifiedDate());

        } else
        {
             stringDate = f.format(this.getDueDate());
        }

        return stringDate;
    }
    
     public void setStringDueDate(String date)
    {
       Date newDueDate = null;
       SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
       
       try
       {
           newDueDate = f.parse(date);

       }catch (Exception e)
       {
       e.printStackTrace();
       
       }
        this.setDueDate(newDueDate);
    }

    public String getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(String completionDate) {
        this.completionDate = completionDate;
    }

    public String getParentID() {
        return parentID;
    }

    public void setParentID(String parentID) {
        this.parentID = parentID;
    }
    
    
   
    


}
