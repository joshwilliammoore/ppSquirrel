package model;
import java.util.ArrayList;
import java.util.Date;

public class Task extends SubTask
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
    
    public ArrayList<SubTask> getSubtasks(){
        return this.children;
    }
    

   
}