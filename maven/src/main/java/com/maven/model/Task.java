package com.maven.model;
import java.util.ArrayList;
import java.util.Date;

public class Task extends SubTask implements HasChildren
{
    private ArrayList<SubTask> children;
    
    public Task(String description, String completionDate, int priorityOrder){
       super(description,completionDate,priorityOrder);
        
    }
    
    public Task()
    {
      this.children = new ArrayList<SubTask>();
     this.setID();
     this.setCreatedDate();
     this.setModifiedDateDefault();
     this.setCompleted(false);
    
    }
    public Task(Date dueDate, int priority, String title, String description)
    {
        super(dueDate, priority, title, description);
        this.children = new ArrayList<>();
    
    }

    public void addChild(SubTask st){
        this.children.add(st);
    }
   
   
    public SubTask getChild(int Position){
        return this.children.get(Position);
    }
    @Override
    public ArrayList<SubTask> getChildren(){
        return this.children;
    }
    
    public boolean removeChild(SubTask Child){
        return this.getChildren().remove(Child);
    }
    

    

   
}