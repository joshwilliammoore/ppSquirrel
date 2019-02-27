/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.Controller;

import java.util.ArrayList;

import com.maven.model.TaskList;
import com.maven.view.RightSideElements.ActionArea;
import com.maven.view.RightSideElements.ActionBar;
import com.maven.view.UIElements.AddTaskListForm;
import com.maven.view.UIElements.TaskListView;
/**
 *
 * @author Regory Gregory
 */
public class ContentLoader {
    
    public static void loadContent(String text, Object param)
    {

        String[] subCommands = text.split(":");
      
            switch (subCommands[0])
                {
            case "HOME":
                break;
            case "TASKLISTS" :
                //here, you should load tasklists or if there is no available, 
                //then it should say "There are no added tasks yet. Click "add" to create your first TaskList
                ActionBar.TaskListBar();
                //temporary solution to clear the content!!!
               ArrayList<TaskList> ar = DataHandler.loadTaskLists();
               
                TaskList[] taskLists = new TaskList[ar.size()];
                taskLists= ar.toArray(taskLists);
                TaskListView.reFresh(taskLists);
                ActionArea.reFresh(TaskListView.getInstance());
                //here you will have to refresh the WorkingArea so that itcom.maven.views tasks!
                break;
            case "TASK" :
                break;    
            case "SETTINGS":
            break;
            case "NEW":

                ActionBar.addNewBar(subCommands[1]);
                ActionArea.getInstance().reFresh(AddTaskListForm.getInstance());
                          
                
                break;
            case "EXIT": System.exit(0);
                break;
            default: break;

                }
        
    }
    
    
    
    
    
}
