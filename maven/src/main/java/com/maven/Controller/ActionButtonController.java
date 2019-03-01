/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.Controller;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.Component;
import javax.swing.JComponent;
import java.lang.reflect.Field;
import java.util.Date;
import java.text.SimpleDateFormat;

import com.maven.view.RightSideElements.WorkingArea;
import com.maven.view.UIElements.GetUIContent;
import com.maven.view.UIElements.AddForm;
import com.maven.model.TaskList;
import com.maven.model.SubTask;
import com.maven.model.SquirrelConstants;
import com.maven.model.User;
import com.maven.Controller.FormatChecker;


public class ActionButtonController implements ActionListener{
    public  void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        String[] subCommands = command.split(":");
        
        switch(subCommands[0])
        {
            case "NEW":

                   ContentLoader.loadContent(command, null);
                break;
            case "UPDATE":
                
                break;
            case "SAVE":

                        switch(subCommands[1])
                        {
                            case "TASKLIST":

                                AddForm element = AddForm.getInstance();
                                        //element.setSpecs(null, true, "TaskList");    
                                Component[] elements = element.getComponents();

                                TaskList newList = new TaskList(); 
                                boolean formatError = false;
                                
                                for(Component c : elements){
                                    if(formatError)
                                    {
                                    break;
                                    }

                                    if(c instanceof GetUIContent)
                                    {
                                        GetUIContent content = (GetUIContent) c;
                                        String label = content.getLabel();
                                     
                                        String value = content.getContent();
  
                                        switch(label){
                                            case "title":
                                                if(!FormatChecker.isFieldEmpty(value)) {
                                                JOptionPane.showMessageDialog(null, "The title field is empty. Please fill it!");
                                                formatError = true;
                                                continue;
                                                };
                                                newList.setTitle(value);
                                                break;
                                            case "description":
                                                if(!FormatChecker.isFieldEmpty(value)) {
                                                JOptionPane.showMessageDialog(null, "The description field is empty. Please fill it!"+value); 
                                                formatError = true;
                                                continue;
                                                };
                                                newList.setDescription(value);
                                                break;
                                            case "creator":
                                                newList.setCreator(new User());
                                                break;
                                            
                                            case "assignee":
                                                   newList.setAssignee(new User());

                                                break;
                                            case "priority":
                                                if(!FormatChecker.isFieldEmpty(value)) {
                                                JOptionPane.showMessageDialog(null, "The priority field is empty. Please fill it!"); 
                                                formatError = true;
                                                continue;
                                                };
                                                newList.setPriority(Integer.parseInt(value));
                                                break;
                                            case "dateDue":
                                                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                                                if(!FormatChecker.isFieldEmpty(value)) {
                                                JOptionPane.showMessageDialog(null, "The due date field is empty. Please fill it!"); 
                                                formatError = true;
                                                continue;
                                                };
                                                 if(FormatChecker.dateFormatChecker(value).equals("badformat")) {
                                                JOptionPane.showMessageDialog(null, "The due date field is not properly formatted. The proper format is dd/mm/yyyy."); 
                                                formatError = true;
                                                continue;
                                                };
                                                if (FormatChecker.dateFormatChecker(value).equals("notlater"))
                                                 {
                                                  //it will have to be improved to compare time!!!   
                                                  JOptionPane.showMessageDialog(null, "The given due date is not later than the current date. Please make it a later date."); 
                                                  formatError = true;
                                                  continue;
                                                  };
                                                  
                                                try{
                                                newList.setDateDue(format.parse(value));
                                                }catch(Exception ex)
                                                {
                                                    ex.printStackTrace();
                                                }
                                                break;
                                        }

                                        
                                        
                                    }
                                }
                                //saving content and refreshing ui
                                  if(!formatError)
                                    {
                                      DataHandler.saveTaskList(newList);   
                                      ContentLoader.loadContent("TASKLISTS", null);    
                                    }
        
                                break;
                            case "TASK":
                                break;
                            case "SUBTASK":
                                break;
                        
                        
                        
                        }
                break;
            case "EDIT":
                
                
                
                
                SubTask editable= new SubTask();    
                ContentLoader.loadContent(command, editable);
                         
                break;
            case "SEARCH":
                break;
            case "VIEW":
                 switch(subCommands[1])
                      {
                        case "TASKLIST":
                             ContentLoader.loadContent("TASKLISTS", null);
                            break;
                       case "TASK":
                            break;

                       case "SUBTASK":
                            break; 
                       default:
                           JOptionPane.showMessageDialog(null, "Wrong parameter @ subCommands[1]:"+subCommands[1]);

                         }
                break;
            case "DELETE":

                 switch(subCommands[1])
                      {
                        case "TASKLIST":

                             if(!DataHandler.deleteTaskList(subCommands[2]))JOptionPane.showMessageDialog(null, "Wrong parameter @ subCommands[1]:"+command);

                             ContentLoader.loadContent("TASKLISTS", null);
                            break;
                       case "TASK":
                            break;

                       case "SUBTASK":
                            break; 
                       default:
                           JOptionPane.showMessageDialog(null, "Wrong parameter @ subCommands[1]:"+subCommands[1]);

                         }
                break;    
            case "CANCEL":
                 switch(subCommands[1])
                {
                     case "TASKLIST":
                          ContentLoader.loadContent("TASKLISTS", null);
                         break;
                    case "TASK":
                         break;
                         
                    case "SUBTASK":
                         break; 
                    default:
                        JOptionPane.showMessageDialog(null, "Wrong parameter @ subCommands[1]:"+subCommands[1]);

                }

                break;
        
        
        
        }
        
    }
}
