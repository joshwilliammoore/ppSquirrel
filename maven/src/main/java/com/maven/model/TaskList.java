package com.maven.model;    

import java.util.ArrayList;
import java.util.Date;
import com.maven.model.User;
import java.io.Serializable;
import java.text.SimpleDateFormat;

public class TaskList extends SubTask implements Serializable 
{

    private ArrayList<Task> tasks;
    
    public TaskList()
    {
     this.tasks = new ArrayList<Task>();
     this.setID();
     this.setCreatedDate();
     this.setModifiedDateDefault();
     this.setCompleted(false);
    }
    public void setID() {
        this.ID = SquirrelConstants.getTasklistCounter();
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

      //Delete certain task.
    public void delTask(int pos){
        this.tasks.remove(pos);
    }

    //Delete all tasks.
    public void delAll(boolean d){
       //It is a bit complicated as every user's tasks should be deleted as well... 
       
    }
}