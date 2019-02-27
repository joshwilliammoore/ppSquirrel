/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.Component;
import javax.swing.JComponent;
import java.lang.reflect.Field;

import view.RightSideElements.WorkingArea;
import view.UIElements.GetUIContent;
import view.UIElements.AddTaskListForm;
import javax.swing.JOptionPane;

import java.util.Date;
import java.text.SimpleDateFormat;

import model.TaskList;
import model.SquirrelConstants;
import model.User;

/**
 *
 * @author Regory Gregory
 */
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
            case "SAVE":

                        switch(subCommands[1])
                        {
                            case "TASKLIST":

                                AddTaskListForm element = AddTaskListForm.getInstance();
                                
                                Component[] elements = element.getComponents();

                                TaskList tl = new TaskList();
                                Class tlClass = tl.getClass();
                                TaskList newList = new TaskList();    
                                for(Component c : elements){


                                    if(c instanceof GetUIContent)
                                    {
                                        GetUIContent content = (GetUIContent) c;
                                        String label = content.getLabel();
                                     
                                        String value = content.getContent();
                                        
                                        
                                        
                                        switch(label){
                                            case "title":
                                                newList.setTitle(value);
                                                break;
                                            case "description":
                                                newList.setDescription(value);
                                                break;
                                            case "creator":
                                                newList.setCreator(new User());
                                                break;
                                            case "taskManager":
                                                  newList.setTaskManager(new User());

                                                break;
                                            case "staff":
                                                   newList.setStaff(new User());

                                                break;
                                            case "priority":
                                                newList.setPriority(Integer.parseInt(value));
                                                break;
                                            case "dateDue":
                                                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                                                
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
                                DataHandler.saveTaskList(newList);   
                                ContentLoader.loadContent("TASKLISTS", null);
                                break;
                            case "TASK":
                                break;
                            case "SUBTASK":
                                break;
                        
                        
                        
                        }
                break;
            case "EDIT":
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
