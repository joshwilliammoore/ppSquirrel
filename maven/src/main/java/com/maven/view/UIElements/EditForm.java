/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.view.UIElements;

import com.maven.view.RightSideElements.HorizontalBar;
import com.maven.model.SubTask;
import com.maven.model.Task;
import com.maven.model.TaskList;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;

/**
 *
 * @author Regory Gregory
 */
public class EditForm extends HorizontalBar{
    private static EditForm instance=null;
    //This is something I haven't finished yet. Has to be parameterized!!!
   public static EditForm getInstance()
   {
   if(instance==null)instance =  new EditForm();
   return instance;
   }
   
   
    protected EditForm()
    {
        super();
        //will have to parameterize!!!
        this.setDim( new Dimension(350, 380));
        this.setLayout(new GridLayout(0,2));
        this.setSize(this.getDim());
        this.setPreferredSize(this.getDim());
        this.setBackground(Color.PINK);
    }
    
    public void reFresh(SubTask editable)
    {
        String type = (editable instanceof TaskList)? "TASKLIST": (editable instanceof Task)?"TASK": "SUBTASK";

         //removing previous elements if there are!
       instance.removeAll();    
        //Title
        JLabel labelTitle = new JLabel("Title of the "+type);
        instance.add(labelTitle);
        
        FormField titleInput = new FormField();
                  titleInput.setText(editable.getTitle());  
        titleInput.setLabel("title");
        
        instance.add(titleInput);
       //Description

        JLabel labelDescription = new JLabel("Description of the "+type);
        
        instance.add(labelDescription);
        
        FormArea descriptionInput = new FormArea();
        descriptionInput.setLabel("description");
        descriptionInput.setText(editable.getDescription());
        instance.add(descriptionInput);

        //Priority

        
        JLabel labelPriority = new JLabel("Priority of the "+type);
        
        instance.add(labelPriority);
        
        Integer[] priority = {1,2,3,4,5};
        FormCombo priorityDropdown = new FormCombo(priority);
                  priorityDropdown.setLabel("priority");  
        instance.add(priorityDropdown);

        //Assignee

        JLabel labelAssignee = new JLabel("Assignee for the "+type);
        
        instance.add(labelAssignee);

        String[] assignees = {"John", "Fred", "Sally", "Paul", "Josh"};
        FormCombo assigneeDropdown = new FormCombo(assignees);
                    assigneeDropdown.setLabel("staff");
        instance.add(assigneeDropdown);

         //Due date 
         JLabel labelDueDate = new JLabel("DueDate of the "+type);
        
        instance.add(labelDueDate);
        
        FormField dueDateInput = new FormField();
                  dueDateInput.setLabel("dateDue"); 
                  dueDateInput.setText(editable.getDateDueString());

        instance.add(dueDateInput);

         instance.revalidate();
         instance.repaint();
        
    }
}
