package com.maven.model;
import java.util.ArrayList;
import java.util.Date;
import java.io.Serializable;

public class Task extends SubTask implements Serializable
{
    private ArrayList<SubTask> children;

    public Task(Date dueDate, int priority, String title, String description)
    {
        super(dueDate, priority, title, description);
        this.children = new ArrayList<>();
    
    }

 
    public void addSubTask(SubTask st){
        this.children.add(st);
    }
    
      public void delSubtask(int index){
        this.children.remove(index);
    }
    
    public SubTask getSubtask(int Position){
        return this.children.get(Position);
    }
    
    public ArrayList<SubTask> getSubtasks(){
        return this.children;
    }
  
    

   
}