package model;
import java.util.ArrayList;
import java.util.Date;
public class Task extends SubTask
{
    private ArrayList<SubTask> subTasks;

    public Task(Date dueDate, int priority, String title, String description)
    {
        super(dueDate, priority, title, description);
        this.subTasks = new ArrayList<>();
    
    }

 
    public void addSubTask(SubTask st){
        this.subTasks.add(st);
    }
    
    public SubTask getSubtask(int Position){
        return this.subTasks.get(Position);
    }
    
    public ArrayList<SubTask> getSubtasks(){
        return this.subTasks;
    }
    

   
}