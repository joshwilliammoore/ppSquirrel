package com.maven.model;    

import java.util.ArrayList;
import java.util.Date;
import com.maven.model.User;
import java.io.Serializable;
import java.text.SimpleDateFormat;

public class TaskList extends SubTask implements Serializable, HasChildren 
{

    private ArrayList<Task> subtasks;
    
    public TaskList()
    {
     this.subtasks = new ArrayList<Task>();
     this.setID();
     this.setCreatedDate();
     this.setModifiedDateDefault();
     this.setCompleted(false);
    }
    
    //Setters and getters for task attribute.
    public void addChild(SubTask st){
       Task casting = (Task) st;
        this.subtasks.add(casting);
    }
    public void setChildren(ArrayList<Task> children)
    {
    this.subtasks = children;
    }
    @Override
    public ArrayList<Task> getSubtasks(){
        return this.subtasks;
    }

    //Add task to array of subtasks. Position of task will need to be selected.
    public void addChild(Task task, int Position) {
        this.subtasks.add(Position, task);
    }

    public boolean removeChild(SubTask Child){
        return this.getSubtasks().remove(Child);
    }
    public void delChild(int pos){
        this.subtasks.remove(pos);
    }

    //Delete all subtasks.
    public void delChildren(boolean d){
       //It is a bit complicated as every user's subtasks should be deleted as well... 
       
    }
    
}