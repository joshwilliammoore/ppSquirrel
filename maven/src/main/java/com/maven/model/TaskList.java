package com.maven.model;    

import java.util.ArrayList;
import java.util.Date;
import com.maven.model.User;
import java.io.Serializable;
import java.text.SimpleDateFormat;

public class TaskList extends SubTask implements Serializable
{

    private ArrayList<Task> children;
    
    public TaskList()
    {
        
     this.children = new ArrayList<Task>();
     this.setID(SquirrelConstants.getTasklistCounter());
     this.setDateCreated();
     this.setDateModified(this.getDateCreated());
     this.setCompleted(false);
    }

   
   
    //Setters and getters for task attribute.
    public void addTask(Task task) {
        this.children.add(task);
    }

    public ArrayList<Task> getChildren(){
        return this.children;
    }

    //Add task to array of children. Position of task will need to be selected.
    public void addTask(Task task, int Position) {
        this.children.add(Position, task);
    }

    //Boolean logic to state whether task is complete or not.

      //Delete certain task.
    public void delTask(int pos){
        this.children.remove(pos);
    }

    //Delete all children.
    public void delAll(boolean d){
       //It is a bit complicated as every user's children should be deleted as well... 
       //Or is it?
    }
   
    
}