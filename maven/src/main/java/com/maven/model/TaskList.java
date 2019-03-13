package com.maven.model;    

import java.util.ArrayList;
import java.util.Date;
import com.maven.model.User;
import java.io.Serializable;
import java.text.SimpleDateFormat;

public class TaskList extends SubTask implements Serializable, HasChildren 
{

    private ArrayList<Task> children;
    
    public TaskList()
    {
     this.children = new ArrayList<Task>();
     this.setID();
     this.setCreatedDate();
     this.setModifiedDateDefault();
     this.setCompleted(false);
    }
    
    //Setters and getters for task attribute.
    public void addChild(SubTask st){
       Task casting = (Task) st;
        this.children.add(casting);
    }
   
    @Override
    public ArrayList<Task> getChildren(){
        return this.children;
    }

    //Add task to array of children. Position of task will need to be selected.
    public void addChild(Task task, int Position) {
        this.children.add(Position, task);
    }

    public boolean removeChild(SubTask Child){
        return this.getChildren().remove(Child);
    }
    public void delChild(int pos){
        this.children.remove(pos);
    }

    //Delete all children.
    public void delChildren(boolean d){
       //It is a bit complicated as every user's children should be deleted as well... 
       
    }
}