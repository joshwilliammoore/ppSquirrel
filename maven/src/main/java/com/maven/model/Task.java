package com.maven.model;
import java.util.ArrayList;
import java.util.Date;

public class Task extends SubTask implements HasChildren
{
    private ArrayList<SubTask> subtasks;
    
//    public Task(String description, String completionDate, int priorityOrder){
//       super(description,completionDate,priorityOrder);
//        
//    }
    
    public Task()
    {
     super();
     this.subtasks = new ArrayList<SubTask>();
     
    
    }
    public Task(Date dueDate, int priority, String title, String description)
    {
        super(dueDate, priority, title, description);
        this.subtasks = new ArrayList<>();
    
    }

    public void addChild(SubTask st){
        this.subtasks.add(st);
    }
   
   
    public SubTask getChild(int Position){
        return this.subtasks.get(Position);
    }
    @Override
    public ArrayList<SubTask> getSubtasks(){
        return this.subtasks;
    }
    
    public boolean removeChild(SubTask Child){
        return this.getSubtasks().remove(Child);
    }
    
    
    

    

   
}