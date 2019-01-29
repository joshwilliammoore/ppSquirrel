import java.util.LinkedList;
public class Task
{
    private int status;
    private String title;
    private String content;
    private String dueDate;
    private int priority;
    private LinkedList<Task> subTasks;

    public void setTitle(String t){}
    public String getTitle(String t){}
    public void setContent(String t){}
    public String getContent(String t){}
    public void setDueDate(String t){}
    public String getDueDate(String t){}
    public int setPriority(int t){}
    public int getPriority(int t){}

    public void addSubTask(Task st){}
    public LinkedList<Task> getTasks(){}
    public Task getTask(int id){}

    public void setStatus(){}
    public int getStatus(){}
}