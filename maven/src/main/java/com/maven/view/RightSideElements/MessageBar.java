/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.view.RightSideElements;



import com.maven.view.RightSideElements.HorizontalBar;
import com.maven.model.SubTask;
import com.maven.model.Task;
import com.maven.model.TaskList;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;

/**
 *
 * @author Regory Gregory
 */
public class MessageBar extends HorizontalBar{
    private static MessageBar instance = null;
    
    protected MessageBar()
    {
        super();
        this.setDim(new Dimension(700, 150));
        this.setPreferredSize(this.getDim());
        this.setBackground(Color.ORANGE);
        this.setLayout(new GridLayout(0, 2));

    
    }
    
    
    public static MessageBar getInstance()
    {
    if(instance == null) {
        instance = new MessageBar();
        instance.customMessage("Welcome to SquirrelTasker!");
    }
    
    return instance;
    }
    

    public void customMessage(String message)
    {
            instance.removeAll();
            instance.add(new JLabel(message));

    }
    public void detailedView(SubTask t)
    {
        instance.removeAll();

        
        
        JLabel title = new JLabel(t.getTitle());
        JLabel description = new JLabel(t.getDescription());
        JLabel dueDate = new JLabel(t.getStringDate("dueDate"));

        JLabel createdDate = new JLabel( t.getStringDate("dateCreated") );
        JLabel modifiedDate = new JLabel( t.getStringDate("dateModified"));
        JLabel priority = new JLabel(Integer.toString(t.getPriorityOrder()));
        String isCompleted = (t.isCompleted())? "Yes" : "No";
        
        JLabel completed = new JLabel(isCompleted);
        
       // JLabel assignee = new JLabel(t.getAssignee().getUserName());
        
        
        instance.add(title);
        instance.add(description);
        instance.add(createdDate);
        instance.add(modifiedDate);
        instance.add(priority);
        instance.add(completed);
        //instance.add(assignee);
   

        
     if(t instanceof SubTask)
     {
         instance.add(new JLabel(t.getParentID()));
     }
     
    }
}
