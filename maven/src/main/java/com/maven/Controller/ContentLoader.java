/*******************************************************************************
This class is responsible for updating the UI.
Apart from the login screen, everything is handled here.
It uses the same action command parameters as the action button controller.
 ******************************************************************************/    
package com.maven.Controller;

import java.util.ArrayList;
import com.maven.model.SubTask;
import com.maven.model.HasChildren;
import com.maven.view.RightSideElements.ActionArea;
import com.maven.view.RightSideElements.ActionBar;
import com.maven.view.RightSideElements.MessageBar;
import com.maven.view.UIElements.ListView;
import com.maven.view.UIElements.AddForm;
import com.maven.view.UIElements.EditForm;


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
                   
                    if(subCommands[1].equals("HOME"))
                    {
                        String displayName = DataHandler.getLoggedIn().getName();
                        SubTask[] userTasks = DataHandler.getCurrentUserTasks();
                        javax.swing.JOptionPane.showMessageDialog(null, userTasks.length);
                        String welcomeMessage = "<html>Home<br>Welcome "+displayName.substring(0,1).toUpperCase()+displayName.substring(1)+"!<br>";
                        welcomeMessage+="See your assigned tasks below:</html>";
                        MessageBar.getInstance().customMessage(welcomeMessage);
                        ListView.reFresh(userTasks);
                        ActionArea.reFresh(ListView.getInstance());
                        
                        
                    } else  if(subCommands[1].equals("TASKLISTS"))
                    {
                       // MessageBar.getInstance().setSize(new Dimension(MessageBar.getInstance().getWidth(), 300));
                        MessageBar.getInstance().customMessage(subCommands[1].substring(0,1)+subCommands[1].substring(1).toLowerCase());
                        ActionBar.DefaultBar(subCommands[1], new ActionButtonController(), Integer.parseInt(subCommands[2]));
                        //DataHandler.loadTasklists(subCommands[1],Integer.parseInt(subCommands[2]));
                        ArrayList<SubTask> ar = DataHandler.getChildren();
                        SubTask[] taskLists = new SubTask[ar.size()];
                        taskLists= ar.toArray(taskLists);
                        if(taskLists.length == 0)
                        {
                          ListView.reFresh(null);  
                        }else 
                        {
                            ListView.reFresh(taskLists);
                        }
                        ActionArea.getInstance().reFresh(ListView.getInstance());
                    } else 
                    {
                        //vjavax.swing.JOptionPane.showMessageDialog(null, text);

                        SubTask t = DataHandler.getEntryFromAllEntriesByID(Integer.parseInt(subCommands[2]));
                        MessageBar.getInstance().detailedView(t);
                        ActionBar.DefaultBar(subCommands[1], new ActionButtonController(), Integer.parseInt(subCommands[2]));

                        if(t instanceof HasChildren)
                        {
                        HasChildren x = (HasChildren) t;   
                        ArrayList<SubTask> children =  x.getSubtasks();
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
                        MessageBar.getInstance().customMessage("Add a new "+subCommands[1].substring(0,1)+subCommands[1].substring(1).toLowerCase());

                        ActionBar.addNewBar(subCommands[1], new ActionButtonController(), Integer.parseInt(subCommands[2]));
                        AddForm.getInstance().reFresh(null, subCommands[1]);
                        ActionArea.getInstance().reFresh(AddForm.getInstance());
                break;
                case "EDITVIEW":
                        SubTask t = DataHandler.getEntryFromAllEntriesByID( Integer.parseInt(subCommands[2]));
                        MessageBar.getInstance().customMessage("Edit a"+subCommands[1].substring(0,1)+subCommands[1].substring(1).toLowerCase());

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
