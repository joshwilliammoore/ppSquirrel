package model;

import java.util.ArrayList;
import java.util.Date;

public class SubTask
{

    private int id;
    private String title;
    private String description;
    private Date dueDate;
    private Date createdDate;
    private Date modifiedDate;
    private int priority;
    private boolean completed;

   
    private User creator;
    
    public SubTask(Date dueDate, int priority, String title, String description)
    {
        Date currentDate = new Date();
        this.setId(++SquirrelConstants.taskID);
        this.setCreatedDate(currentDate);
        this.setModifiedDate(currentDate);
        this.setDueDate(dueDate);
        this.setPriority(priority);
        this.setTitle(title);
        this.setDescription(description);
        this.setCompleted(false);
    
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setDueDate(Date dueDate) {
        
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
}
