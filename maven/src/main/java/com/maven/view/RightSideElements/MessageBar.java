/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.view.RightSideElements;



import com.maven.Controller.DataHandler;
import com.maven.view.RightSideElements.HorizontalBar;
import com.maven.model.SubTask;
import com.maven.model.Task;
import com.maven.model.TaskList;
import com.maven.model.SquirrelConstants;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
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
        this.setDim(new Dimension(900, 300));
        this.setPreferredSize(this.getDim());
        this.setBackground(SquirrelConstants.getMessageBarColour());
        this.setLayout(new GridLayout(0, 2));
        this.setBorder(SquirrelConstants.getMessageBarMargin());

    }
    
    
    public static MessageBar getInstance()
    {
    if(instance == null) {
        instance = new MessageBar();
        instance.customMessage("Welcome to SquirrelTasker ");
    }
    
    return instance;
    }
    

    public void customMessage(String message)
    {
            instance.removeAll();
            this.setLayout(new FlowLayout());
            JLabel h1 = new Header(message);
            instance.add(h1);
            instance.revalidate();
            instance.repaint();

    }
    public void detailedView(SubTask t)
    {
        instance.removeAll();

        SubHeader mainTitle = new SubHeader("Details:");
        this.setLayout(new BorderLayout());
        
        JPanel grids = new JPanel(new GridLayout(0,4));
        grids.setBackground(SquirrelConstants.getColorLight());

        JLabel titleLabel = new DetailEntryLabel("Title: ");
        JLabel title = new DetailEntry("<html>"+t.getTitle()+"</html>");
        
        grids.add(titleLabel);
        grids.add(title);
        
        JLabel descriptionLabel = new DetailEntryLabel("Description: ");
        JLabel description = new DetailEntry("<html>"+t.getDescription()+"</html>");
        
        grids.add(descriptionLabel);
        grids.add(description);
                
        
        JLabel dueDateLabel = new DetailEntryLabel("Due date: ");
        JLabel dueDate = new DetailEntry(t.getDateDueString());
        
        grids.add(dueDateLabel);
        grids.add(dueDate);

        JLabel createdDateLabel = new DetailEntryLabel("Created: " );
        JLabel createdDate = new DetailEntry( t.getStringDate("dateCreated") );
        
        grids.add(createdDateLabel);
        grids.add(createdDate);
        
        JLabel modifiedDateLabel = new DetailEntryLabel( "Modified: ");
        JLabel modifiedDate = new DetailEntry( t.getStringDate("dateModified"));
        
        grids.add(modifiedDateLabel);
        grids.add(modifiedDate);
        
        
        JLabel priorityLabel = new DetailEntryLabel("Priority: ");
        JLabel priority = new DetailEntry(Integer.toString(t.getPriorityOrder()));
        
        grids.add(priorityLabel);
        grids.add(priority);
        
        
        JLabel assigneeLabel = new DetailEntryLabel("Assignee: ");
        JLabel assignee = new DetailEntry(t.getUser().getUserName());
        
        grids.add(assigneeLabel);
        grids.add(assignee);
        
        
        JLabel isCompletedLabel = new DetailEntryLabel("Completed: ");
        String isCompleted = (t.isCompleted())? "Yes" : "No";
        JLabel completed = new DetailEntry(isCompleted);
        
        
        grids.add(isCompletedLabel);
        grids.add(completed);
       // JLabel assignee = new JLabel(t.getAssignee().getUserName());
        
        
        instance.add(mainTitle, BorderLayout.NORTH);
        instance.add(grids, BorderLayout.CENTER);
        //instance.add(assignee);
        instance.revalidate();
        instance.repaint();

        
     if(t instanceof SubTask)
     {
         //instance.add(new JLabel(t.getParentID()));
     }
     
    }
    
    private static class Header extends JLabel
    {
        private Header(String label)
        {
            super(label);
            this.setHorizontalTextPosition(JLabel.CENTER);
            this.setVerticalAlignment(JLabel.BOTTOM);
            this.setVerticalTextPosition(JLabel.BOTTOM);
            this.setFont(SquirrelConstants.getHeaderFont());
            this.setBorder(SquirrelConstants.getHeaderPadding());
        }
    
    }
     private static class SubHeader extends JLabel
    {
        private SubHeader(String label)
        {
            super(label);
            this.setHorizontalTextPosition(JLabel.CENTER);
            this.setHorizontalAlignment(JLabel.CENTER);
            this.setVerticalAlignment(JLabel.BOTTOM);
            this.setVerticalTextPosition(JLabel.BOTTOM);
            this.setFont(SquirrelConstants.getSubHeaderFont());
            //this.setBorder(SquirrelConstants.getHeaderPadding());
        }
    
    }
       private static class DetailEntry extends JLabel
    {
        private DetailEntry(String label)
        {
            super(label);
            this.setHorizontalAlignment(JLabel.CENTER);
            this.setHorizontalTextPosition(JLabel.CENTER);
            this.setVerticalAlignment(JLabel.BOTTOM);
            this.setVerticalTextPosition(JLabel.BOTTOM);
            this.setFont(SquirrelConstants.getDetailEntryFont());
            this.setForeground(SquirrelConstants.getColorPrimary());
            this.setBackground(SquirrelConstants.getColorLight());
        }
    
    }
       private static class DetailEntryLabel extends JLabel
    {
        private DetailEntryLabel(String label)
        {
            super(label);
            this.setHorizontalAlignment(JLabel.CENTER);
            this.setHorizontalTextPosition(JLabel.CENTER);
            this.setVerticalAlignment(JLabel.BOTTOM);
            this.setVerticalTextPosition(JLabel.BOTTOM);
            this.setFont(SquirrelConstants.getDetailEntryFont());
            this.setForeground(SquirrelConstants.getColorPrimary());
            this.setBackground(SquirrelConstants.getColorLight());

            

          
        }
      
    
    }
      
}
