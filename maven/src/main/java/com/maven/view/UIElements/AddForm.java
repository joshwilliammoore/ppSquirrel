/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.maven.view.UIElements;

import com.maven.model.User;

import com.maven.view.RightSideElements.HorizontalBar;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;

import java.util.ArrayList;


import com.maven.model.SubTask;
import java.util.HashSet;
import java.util.List;

public class AddForm extends HorizontalBar{
  
   private static AddForm instance=null;
   private static HashSet<User> users;
   
   
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
    public void reFresh(SubTask typOfSubTask, String tag)
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

      
        String[] arrayUsers = new String[users.size()];
        List<User> temp = new ArrayList<User>(users);
        for(int i =0; i<temp.size(); i++)
        {
        arrayUsers[i]=temp.get(i).getUserName();
        }
        FormCombo assigneeDropdown = new FormCombo(arrayUsers);
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
            descriptionInput.setText(typOfSubTask.getDescription());
            //priorityDropdown.setSelectedItem(typOfSubTask.getPriority());
            //priorityDropdown.setEditable(editable);
            //assigneeDropdown.setSelectedItem(typOfSubTask.getAssignee().getUserName());
            //assigneeDropdown.setEditable(editable);
            dueDateInput.setText(typOfSubTask.getDateDueString());
            
            
            
        }
         instance.revalidate();
         instance.repaint();
        
    }

    public static HashSet<User> getUsers() {
        return users;
    }

    public static void setUsers(HashSet<User> users) {
        AddForm.users = users;
    }
    
}
