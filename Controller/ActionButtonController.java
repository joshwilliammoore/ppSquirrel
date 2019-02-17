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

import java.util.Date;
import java.text.SimpleDateFormat;

import model.TaskList;
import model.SquirrelConstants;

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
                                Component[] elements = WorkingArea.getInstance().getComponents();
                                TaskList tl = new TaskList();
                                Class tlClass = tl.getClass();
                                for(Component c : elements){
                                    if(c instanceof GetUIContent)
                                    {
                                        
                                        GetUIContent content = (GetUIContent) c;
                                        String label = content.getLabel();
                                        String value = content.getContent();
                                      
                                        try
                                        {
                                              if(label.equals("dateDue"))
                                        {
                                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                                        Date dueDate = dateFormat.parse(value);
                                        Field f = tlClass.getField(label);
                                        f.set(tl, dueDate);
                                        } else {
                                        Field f = tlClass.getField(label);
                                        f.set(tl, value);
                                              
                                              }
                                            
                                            
                                       
                                        }catch(Exception ex)
                                        {
                                            ex.printStackTrace();
                                        }
                                        tl.setID(SquirrelConstants.getTasklistCounter());
                                        tl.setComplete(false);
                                        tl.setDateCreated(new Date());
                                        tl.setDateModified(new Date());
                                        
                                        
                                        DataHandler.saveTaskList(tl);    
                                    
                                    }
                                }
                                break;
                            case "TASK":
                                break;
                            case "SUBTASK":
                                break;
                        
                        
                        
                        }
                break;
            case "EDIT":
                break;
            case "SEARCH":
                break;
            case "VIEW":
                break;
            case "CANCEL":
                break;
        
        
        
        }
        
    }
}
