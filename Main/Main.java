/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import other.experimenting_with_java_ui.Experiment;
import model.Task;
import model.SubTask;
import model.TaskList;
import java.util.Date;
/**
 *
 * @author Gregory
 */
public class Main {
    public static void main(String[] args) {
//		
        //Experiment e = new Experiment();
        //parameters for creating a task
        //Date dueDate, int priority, String title, String description
            Date dd = new Date(System.currentTimeMillis()+1000*3600*24);
         Task task1 = new Task(dd, 2, "First demo task", "You should do it asap");       
         Date dd2 = new Date(task1.getDueDate().getTime()-1000*3600);
         SubTask subTask1 = new SubTask(dd2, 3, "First subtask", "You should do it a bit sooner");      
         TaskList tl = new TaskList();
         tl.addTask(task1);
         task1.addSubTask(subTask1);
	}
    
}
