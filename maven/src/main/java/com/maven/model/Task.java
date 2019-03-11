package com.maven.model;
import java.util.ArrayList;
import java.util.Date;

public class Task extends SubTask implements HasChildren
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
    
    public SubTask getSubtask(int Position){
        return this.children.get(Position);
    }
    @Override
    public ArrayList<SubTask> getChildren(){
        return this.children;
    }
    

   
}