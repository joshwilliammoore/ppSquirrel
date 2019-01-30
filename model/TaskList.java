package model;    

import java.util.ArrayList;
import java.util.Date;
import model.User;
public class TaskList
{
    private String title;
    private String Description;
    private boolean completed;
    private User creator;
    private User taskManager;
    private Date dateCreated;
    private Date dateDue;
    private Date dateModified;
    
    private boolean complete;
    private ArrayList<Task> tasks;
    private int priority;

    
    public TaskList()
    {
        this.tasks = new ArrayList<Task>();
    }
    public boolean isCompleted()
    {
        //this function should return true if all the subtasks are completed or if there are no subtasks, then the main task is completed
        return true;
    
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
    public boolean isComplete(){
        return this.complete;
    }
    
    public void setComplete(boolean complete)
    {
        this.complete = complete;
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
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
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

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }
}