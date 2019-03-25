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
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;

import com.maven.view.UIElements.GetUIContent;
import com.maven.view.UIElements.AddForm;
import com.maven.view.UIElements.EditForm;
import com.maven.view.UIElements.ListView;
import com.maven.view.UIElements.FilterBar;

import com.maven.model.TaskList;
import com.maven.model.Task;
import com.maven.model.SubTask;
import com.maven.model.SquirrelConstants;
import com.maven.model.User;
import com.maven.Controller.FormatChecker;
import com.maven.view.RightSideElements.ActionBar;
import com.maven.view.RightSideElements.HorizontalBar;

public class ActionButtonController implements ActionListener{
    
    private static SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    
    public  void actionPerformed(ActionEvent e)
    {
        
        String command = e.getActionCommand();
        String[] subCommands = command.split(":");
        JOptionPane.showMessageDialog(null, command);
        
        
        switch(subCommands[0])
        {
            
            case "FILTER":
                
                Comparator<SubTask> comp = Filters.FILTER_BY_PRIORITY;
                
                if(subCommands[1].equals("TITLE"))
                {
                comp = Filters.FILTER_BY_TITLE;
                } else if(subCommands[1].equals("DONE"))
                {
                comp = Filters.FILTER_BY_COMPLETION; 
                }else if(subCommands[1].equals("DATE"))
                {
                comp = Filters.FILTER_BY_DATE;
                } else if(subCommands[1].equals("ASSIGNEE"))
                {
                comp = Filters.FILTER_BY_ASSIGNEE;
                } 
                Arrays.sort(ListView.getTaskLists(), comp);
                ListView.reFresh(ListView.getTaskLists());
                
            break;   
            
            case "DONE":
            SubTask completed = DataHandler.getEntry(subCommands[1],
                    Integer.parseInt(subCommands[2]));
            boolean switchCompleted = (completed.isCompleted())?false:true;
            completed.setCompleted(switchCompleted);
       
            break;
            
            case "NEW":
                   ContentLoader.loadContent("ADDVIEW:"
                           +subCommands[1]+":"+subCommands[2], 0);
                break;
                
            case "UPDATE":
                
                SubTask updatable = DataHandler.getEntry(subCommands[1],Integer.parseInt(subCommands[2]));
                
                EditForm dataForm = EditForm.getInstance();
                                        //element.reFresh(null, true, "TaskList");    
                boolean formatError = processFormElements(updatable, dataForm);
                
                if(!formatError)
                {
                ContentLoader.loadContent("LISTVIEW:"+subCommands[1]+":"+subCommands[2], 0);
                }
            
                break;
                
            case "SAVE":
                
                SubTask newList=null;
                SubTask parent = null;
                if(subCommands[1].equals("TASKLIST"))
                {
                    newList = new TaskList(); 
                } else if(subCommands[1].equals("TASK"))
                {
                    newList = new Task(); 
                    parent = DataHandler.getTaskListByID(Integer.parseInt(subCommands[2]));
                } else 
                {
                  newList = new SubTask(); 
                  parent = DataHandler.getTasktByID(Integer.parseInt(subCommands[2])).get(0);
                }

                                AddForm element = AddForm.getInstance();
                                        //element.reFresh(null, true, "TaskList");    
                                Component[] elements = element.getComponents();


                                formatError = processFormElements(newList, element);
                                //saving content and refreshing ui
                                  if(!formatError)
                                    {
                                      //this is where it is saved!!! 
                                      if(parent!=null)
                                      {
                                          
                                      parent.addChild(newList);
                                   
                                      } else 
                                      {
                                       //if it is null, then it is a new tasklist!!!   
                                       DataHandler.saveTaskList(newList);

                                      } 
                                      //this reloads the parent container!!!
                                      DataHandler.saveCounter();
                                      ContentLoader.loadContent("LISTVIEW:"+Filters.returnRelative(subCommands[1], false)+":"+subCommands[2], null);    
                                    }
                
                //JOptionPane.showMessageDialog(null, DataHandler.getIDCounter().getCounter());
                
               //JOptionPane.showMessageDialog(null, DataHandler.getIDCounter().getCounter());
        
                       
            break;
            case "EDIT":
                
                  ContentLoader.loadContent("EDITVIEW:"+subCommands[1]+":"+subCommands[2], 0);
                         
            break;
            
            case "SEARCH":
                
                   String searchPhrase =  ActionBar.getInstance().getSearchField().getText();
                   String type = ActionBar.getInstance().getSearchOption().getContent();
                   SubTask[] searchAble = ListView.getTaskLists();
                   ArrayList<SubTask> returnable = new ArrayList<>();
                   if(!FormatChecker.isFieldEmpty(searchPhrase)) {
                   JOptionPane.showMessageDialog(null, "The search field is empty! Please enter an appropriate search phrase!"); 
                   break;
                   }
                   else if(type.equals("TITLE"))
                   {
                    returnable =  Filters.SEARCH_BY_TITLE.search(searchAble, searchPhrase);
                   } 
                   else if(type.equals("ASSIGNEE"))
                   {
                    returnable = Filters.SEARCH_BY_ASSIGNEE.search(searchAble, searchPhrase);
                   }
                   else if(type.equals("PRIORITY"))
                   {
                   returnable = Filters.SEARCH_BY_PRIORITY.search(searchAble, searchPhrase);
                   } 
                    else if(type.equals("DESCRIPTION"))
                   {
                   returnable = Filters.SEARCH_BY_DESCRIPTION.search(searchAble, searchPhrase);
                   }
                   else if (type.equals("DUE_DATE"))
                   {
                        if(FormatChecker.dateFormatChecker(searchPhrase).equals("badformat")) {
                        JOptionPane.showMessageDialog(null, "The search phrase is not properly formatted! The proper format is dd/mm/yyyy."); 

                        } 
                        else{
                        try {
                           Date d = format.parse(searchPhrase); 
                           returnable = Filters.SEARCH_BY_DUEDATE.search(searchAble, d);
                        } catch(Exception p)
                        {
                            JOptionPane.showMessageDialog(null, "The search phrase is not properly formatted! The proper format is dd/mm/yyyy."); 
                        }
                        }
                   }
                   else 
                   {
                     JOptionPane.showMessageDialog(null, "Fatal error. The search type requested does not exist:"+command); 

                   }
                   
                   if(returnable.size()>0)
                   {
                    
                      SubTask[] convertToArray = new SubTask[returnable.size()]; 
                      convertToArray = returnable.toArray(convertToArray);
                      ListView.reFresh(convertToArray);
                      ActionBar.SearchResultsBar(subCommands[1],new ActionButtonController(),Integer.parseInt(subCommands[2]));
                      //here, you have to give the user to clear the search and see
                      //the full list again.
                   } else 
                   {
                    JOptionPane.showMessageDialog(null, "There is no match for the selected searchphrase. Try a different one!"); 
   
                   }
            
            break;
            
            case "VIEW":
                
                   ContentLoader.loadContent("LISTVIEW:"+subCommands[1]+":"+subCommands[2], 0);//[2] may not always exist

            break;
            case "DELETE":
                
               int parentID = Integer.parseInt(subCommands[2]);
               
               if(parentID<1)
               {
               JOptionPane.showMessageDialog(null, "The request could not be completed. Wrong id parameter:"+ subCommands[2]);
               return;
               }
               DataHandler.getEntry(subCommands[1], parentID).setDeleted(true);
               
               ContentLoader.loadContent("LISTVIEW:"+Filters.returnRelative(subCommands[1], false)+":"+parentID, 0);
                        
            break;    
            case "CANCEL":
                if(!subCommands[1].equals("TASKLISTS") 
                   && !subCommands[1].equals("TASKLIST") 
                   && !subCommands[1].equals("TASK") 
                   && !subCommands[1].equals("SUBTASK"))
                {
                  JOptionPane.showMessageDialog(null, "Wrong parameter @ subCommands[1]:"+subCommands[1]);
                  break;
                }
                         ArrayList<SubTask> nav = new ArrayList<>();
                        String source = Filters.returnRelative(subCommands[1], true);
                        int id = Integer.parseInt(subCommands[2]);
                        
                        if(source.equals("TASK"))
                        {
                            nav = DataHandler.getTasktByID(id);
                            if(nav.size()>0)
                            {
                                id = nav.get(1).getID();
                            }
                        }
                         if(source.equals("SUBTASK"))
                        {
                            nav = DataHandler.getSubTasktByID(id);
                             if(nav.size()>0)
                            {
                                id = nav.get(1).getID();
                            } else {
                                 JOptionPane.showMessageDialog(null, "Can't find Subtask's parent...");
                             }
                        }
//                       DataHandler.getEntry(); 
                
                
                
                ContentLoader.loadContent("LISTVIEW:"+subCommands[1]+":"+id, null);
                
           break;
        
        }
    }
    
    public static boolean processFormElements(SubTask newList, HorizontalBar form )
    {
                                HorizontalBar element = form.getInstance();
                                        //element.reFresh(null, true, "TaskList");    
                                Component[] elements = element.getComponents();

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
                                                break;
                                                };
                                                newList.setTitle(value);
                                                break;
                                            case "description":
                                                if(!FormatChecker.isFieldEmpty(value)) {
                                                JOptionPane.showMessageDialog(null, "The description field is empty. Please fill it!"+value); 
                                                formatError = true;
                                                break;
                                                };
                                                newList.setDescription(value);
                                                break;
                                            case "creator":
                                                newList.setCreator(new User());
                                                break;
                                            
                                            case "staff":
                                                User assignee = DataHandler.getUserByUserName(value);
                                                if(assignee==null)
                                                {
                                                    JOptionPane.showMessageDialog(null, "User name does not exist:"+value);
                                                    break;
                                                }
                                                   newList.setUser(assignee);

                                                break;
                                            case "priority":
                                                if(!FormatChecker.isFieldEmpty(value)) {
                                                JOptionPane.showMessageDialog(null, "The priority field is empty. Please fill it!"); 
                                                formatError = true;
                                                break;
                                                };
                                                newList.setPriorityOrder(Integer.parseInt(value));
                                                break;
                                            case "dateDue":
                                                if(!FormatChecker.isFieldEmpty(value)) {
                                                JOptionPane.showMessageDialog(null, "The due date field is empty. Please fill it!"); 
                                                formatError = true;
                                                break;
                                                };
                                                 if(FormatChecker.dateFormatChecker(value).equals("badformat")) {
                                                JOptionPane.showMessageDialog(null, "The due date field is not properly formatted. The proper format is dd/mm/yyyy."); 
                                                formatError = true;
                                                break;
                                                };
                                                if (FormatChecker.dateFormatChecker(value).equals("notlater"))
                                                 {
                                                  //it will have to be improved to compare time!!!   
                                                  JOptionPane.showMessageDialog(null, "The given due date is not later than the current date. Please make it a later date."); 
                                                  formatError = true;
                                                  break;
                                                  };
                                                  
                                                try{
                                                    
                                                newList.setDueDate(format.parse(value));
                                                
                                                }catch(Exception ex)
                                                {
                                                    ex.printStackTrace();
                                                }
                                                
                                                break;
                                        }

                                    }
                                }
    
    
    return formatError;
    }

}
