/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.maven.view.UIElements;

import com.maven.model.TaskList;
import com.maven.view.RightSideElements.HorizontalBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.ScrollPaneLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComponent;
import java.util.ArrayList;



import com.maven.model.SubTask;

public class AddForm extends HorizontalBar{
  
   private static AddForm instance=null;
    //This is something I haven't finished yet. Has to be parameterized!!!
   public static AddForm getInstance()
   {
   if(instance==null)instance =  new AddForm();
   return instance;
   }
    protected AddForm()
    {
        super();
        //will have to parameterize!!!
        this.setDim( new Dimension(350, 380));
        this.setLayout(new GridLayout(0,2));
        this.setSize(this.getDim());
        this.setPreferredSize(this.getDim());
        this.setBackground(Color.PINK);
    }
    public <T extends SubTask> void setSpecs(T typOfSubTask, boolean editable, String tag)
    {
     
        //removing previous elements if there are!
       instance.removeAll();    
        //Title
        JLabel labelTitle = new JLabel("Title of the "+tag);
        instance.add(labelTitle);
        
        FormField titleInput = new FormField();
  
        titleInput.setLabel("title");
        
        instance.add(titleInput);
       //Description

        JLabel labelDescription = new JLabel("Description of the "+tag);
        
        instance.add(labelDescription);
        
        FormArea descriptionInput = new FormArea();
        descriptionInput.setLabel("description");
        instance.add(descriptionInput);

        //Priority

        
        JLabel labelPriority = new JLabel("Priority of the "+tag);
        
        instance.add(labelPriority);
        
        Integer[] priority = {1,2,3,4,5};
        FormCombo priorityDropdown = new FormCombo(priority);
                  priorityDropdown.setLabel("priority");  
        instance.add(priorityDropdown);

        
        //Assignee

        JLabel labelAssignee = new JLabel("Assignee for the "+tag);
        
        instance.add(labelAssignee);

        
        String[] assignees = {"John", "Fred", "Sally", "Paul", "Josh"};
        FormCombo assigneeDropdown = new FormCombo(assignees);
                    assigneeDropdown.setLabel("staff");
        instance.add(assigneeDropdown);
        

         //Due date 
         JLabel labelDueDate = new JLabel("DueDate of the "+tag);
        
        instance.add(labelDueDate);
        
        FormField dueDateInput = new FormField();
                  dueDateInput.setLabel("dateDue");  
        instance.add(dueDateInput);
        

         if(typOfSubTask!=null)
        {
            titleInput.setText(typOfSubTask.getTitle());
            titleInput.setEditable(editable);
            descriptionInput.setText(typOfSubTask.getDescription());
            descriptionInput.setEditable(editable);
            //priorityDropdown.setSelectedItem(typOfSubTask.getPriority());
            //priorityDropdown.setEditable(editable);
            //assigneeDropdown.setSelectedItem(typOfSubTask.getAssignee().getUserName());
            //assigneeDropdown.setEditable(editable);
            dueDateInput.setText(typOfSubTask.getDateDueString());
            dueDateInput.setEditable(editable);
            
            
            
        }
         instance.revalidate();
         instance.repaint();
        
    }
    
}
