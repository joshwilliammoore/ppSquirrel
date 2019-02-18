package model;    

import java.util.ArrayList;
import java.util.Date;
import model.User;
import java.io.Serializable;

public class TaskList implements Serializable
{
    private int ID;

    private String title;
    private String description;
    private User creator;
    private User taskManager;
    private User staff;
    private int priority;

    private Date dateCreated;
    private Date dateDue;
    private Date dateModified;
    private boolean completed;

    private ArrayList<Task> tasks;
    
    public TaskList()
    {
     this.tasks = new ArrayList<Task>();
     this.setID();
     this.setDateCreated();
     this.setDateModified();
     this.setCompleted(false);
    }

    public int getID() {
        return ID;
    }

    public void setID() {
        this.ID = SquirrelConstants.getTasklistCounter();
    }

    public Date getDateDue() {
        return dateDue;
    }

    public void setDateDue(Date dateDue) {
        this.dateDue = dateDue;
    }
    
    
    
    public void setStaff (User staff)
    {
        this.staff = staff;
    }
        
    
   
    //Setters and getters for task attribute.
    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public ArrayList<Task> getTasks(){
        return this.tasks;
    }

    //Add task to array of tasks. Position of task will need to be selected.
    public void addTask(Task task, int Position) {
        this.tasks.add(Position, task);
    }


   

    //Boolean logic to state whether task is complete or not.
    public boolean isCompleted(){
        return this.completed;
    }
    
    public void setCompleted(boolean complete)
    {
        this.completed = complete;
    }

 
      //Delete certain task.
    public void delTask(int pos){
        this.tasks.remove(pos);
    }

    //Delete all tasks.
    public void delAll(boolean d){
       //It is a bit complicated as every user's tasks should be deleted as well... 
       
    }

    public void setDueDate(Date d) {
        
        this.dateDue = d;
    }

    public Date getDueDate() {
        return this.dateDue;
    }

    public void setPriority(int p) {
        this.priority = p;
    }

    public int getPriority() {
        return priority;
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

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public User getTaskManager() {
        return taskManager;
    }

    public void setTaskManager(User taskManager) {
        this.taskManager = taskManager;
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
    public void setDateModified() {
        this.dateModified = this.getDateCreated();
    }
}