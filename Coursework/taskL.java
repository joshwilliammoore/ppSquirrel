    public class taskList
{
    private String task;
    private boolean complete;
    private String[] tasks;
    private String dueDate;
    private int priority;

    //Setters and getters for task attribute.
    public void setTask(String task) {
        this.task = task;
    }

    public String getTask(){
        return this.task;
    }

    //Add task to array of tasks. Position of task will need to be selected.
    public void addTask(String task,int pos){
        ArrayList<String> taskList = new ArrayList<String>(Arrays.asList(tasks));
        taskList.add(pos,task);
        this.tasks = taskList.toArray(new String[taskList.size()]);
    }

    //Get array of tasks.
    public String[] getTasks(){
        return this.tasks;
    }

    //Boolean logic to state whether task is complete or not.
    public void isComplete(boolean task){
        this.complete = task;
    }

    //Return whether task is complete.
    public boolean getComplete(){
        return complete;
    }

    //Delete certain task.
    public void delTask(int pos){
        ArrayList<String> taskList = new ArrayList<String>(Arrays.asList(tasks));
        taskList.remove(pos);
        this.tasks = taskList.toArray(new String[taskList.size()]);
    }

    //Delete all tasks.
    public void delAll(boolean d){
        ArrayList<String> taskList = new ArrayList<String>(Arrays.asList(tasks));
        for(int i=0;i<taskList.size();i++){
            taskList.remove(i);
        }
        this.tasks = taskList.toArray(new String[taskList.size()]);
    }

    public void setDueDate(String d) {
        this.dueDate = d;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setPriority(int p) {
        this.priority = p;
    }

    public int getPriority() {
        return priority;
    }
}