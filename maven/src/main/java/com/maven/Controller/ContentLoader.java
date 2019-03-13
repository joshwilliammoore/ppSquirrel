/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.Controller;

import java.util.ArrayList;

import com.maven.model.SubTask;
import com.maven.model.Task;
import com.maven.model.TaskList;
import com.maven.model.HasChildren;

import com.maven.view.RightSideElements.ActionArea;
import com.maven.view.RightSideElements.ActionBar;
import com.maven.view.RightSideElements.MessageBar;
import com.maven.view.UIElements.ListView;
import com.maven.view.UIElements.AddForm;
import com.maven.view.UIElements.EditForm;
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
                
                //the content loader has to be parameterised!!!
                case "LISTVIEW":
                    if(subCommands[1].equals("EXIT"))
                    {
                     DataHandler.updateTaskLists();
                     System.exit(0);
                    }
                   
                    //logical error here, mate!!!!
                    if(subCommands[1].equals("TASKLISTS"))
                    {
                        MessageBar.getInstance().customMessage("Here you can see the"+subCommands[1]);
                        ActionBar.DefaultBar(subCommands[1], new ActionButtonController(), Integer.parseInt(subCommands[2]));
                        //DataHandler.loadTasklists(subCommands[1],Integer.parseInt(subCommands[2]));
                        ArrayList<SubTask> ar = DataHandler.getTaskLists();
                        SubTask[] taskLists = new SubTask[ar.size()];
                        taskLists= ar.toArray(taskLists);
                        if(taskLists.length == 0)
                        {
                          ListView.reFresh(null);  
                        }else 
                        {
                            ListView.reFresh(taskLists);
                        }
                        ActionArea.reFresh(ListView.getInstance());
                    } else 
                    {
                        javax.swing.JOptionPane.showMessageDialog(null, text);

                        SubTask t = DataHandler.getEntry(subCommands[1], Integer.parseInt(subCommands[2]));
                        MessageBar.getInstance().detailedView(t);
                        ActionBar.DefaultBar(subCommands[1], new ActionButtonController(), Integer.parseInt(subCommands[2]));

                        if(t instanceof HasChildren)
                        {
                        HasChildren x = (HasChildren) t;   
                        ArrayList<SubTask> children =  x.getChildren();
                        SubTask[] childrenList = new SubTask[children.size()];
                        childrenList= children.toArray(childrenList);
                            if(childrenList.length == 0)
                            {
                              ListView.reFresh(null);  
                            }else 
                            {
                                ListView.reFresh(childrenList);
                            }

                        } else 
                        {
                            ListView.reFresh(null);  
                        }

                        ActionArea.reFresh(ListView.getInstance());
                    }
 
                break;
                case "ADDVIEW": 
                        MessageBar.getInstance().customMessage("Here you can add a new "+subCommands[1]);

                        ActionBar.addNewBar(subCommands[1], new ActionButtonController(), Integer.parseInt(subCommands[2]));
                        AddForm.getInstance().reFresh(null, subCommands[1]);
                        ActionArea.getInstance().reFresh(AddForm.getInstance());
                break;
                case "EDITVIEW":
                        SubTask t = DataHandler.getEntry(subCommands[1], Integer.parseInt(subCommands[2]));
                        MessageBar.getInstance().customMessage("Here you can edit a "+subCommands[1]);

                        ActionBar.editBar(subCommands[1], new ActionButtonController(), Integer.parseInt(subCommands[2]));
                        EditForm.getInstance().reFresh(t);
                        ActionArea.getInstance().reFresh(EditForm.getInstance());
                    
                    
                    break;
           
                case "EXIT": System.exit(0);
                break;    
                default: break;
            
            }
    
    
    
    
    
    }
}
