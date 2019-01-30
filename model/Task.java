package model;
import java.util.ArrayList;
import java.util.Date;
public class Task extends SubTask
{
    private ArrayList<Task> subTasks;

    public Task(Date dueDate, int priority, String title, String description)
    {
        super(dueDate, priority, title, description);
        this.subTasks = new ArrayList<>();
    
    }

 
    public void addSubTask(Task st){
        this.subTasks.add(st);
    }
    
    public Task getSubtask(int Position){
        return this.subTasks.get(Position);
    }
    
    public ArrayList<Task> getSubtasks(){
        return this.subTasks;
    }
    

   
}