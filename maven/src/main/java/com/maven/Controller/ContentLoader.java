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
import com.maven.view.UIElements.TaskListView;
import com.maven.view.UIElements.AddForm;
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
                
              
                
                ActionBar.DefaultBar("TASKLIST", new ActionButtonController());
                //temporary solution to clear the content!!!
                
                ArrayList<TaskList> ar = DataHandler.loadTaskLists();
               
                TaskList[] taskLists = new TaskList[ar.size()];
                taskLists= ar.toArray(taskLists);
                if(taskLists.length == 0)
                {
                  TaskListView.reFresh(null);  
                }else 
                {
                    TaskListView.reFresh(taskLists);
                }
                
                ActionArea.reFresh(TaskListView.getInstance());
                break;
            case "TASK" :
                break;    
            case "SETTINGS":
            break;
            case "NEW":

                ActionBar.addNewBar(subCommands[1], new ActionButtonController());
                AddForm.getInstance().setSpecs(null, true, subCommands[1]);
                ActionArea.getInstance().reFresh(AddForm.getInstance());
                break;
                
            case "VIEW":

               ActionBar.addNewBar(subCommands[1], new ActionButtonController());
               TaskList tlView = DataHandler.getTaskListByID(Integer.parseInt(subCommands[2]));
//               AddForm.getInstance().setSpecs(tlView, true, subCommands[1]);
//               ActionArea.getInstance().reFresh(AddForm.getInstance());         
                
                break;    
            case "EDIT":
                ///editing things...    
                ActionBar.addNewBar(subCommands[1], new ActionButtonController());
                TaskList tlEdit = DataHandler.getTaskListByID(Integer.parseInt(subCommands[2]));
//                AddForm.getInstance().setSpecs(tlEdit, true, subCommands[1]);
                ActionArea.getInstance().reFresh(AddForm.getInstance());
                          
                
                break;    
            case "EXIT": System.exit(0);
                break;
            default: break;

                }
        
    }
    
    
    
    
    
}
