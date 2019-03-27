/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.view.UIElements;
import com.maven.view.RightSideElements.HorizontalBar;
import com.maven.model.SubTask;
import com.maven.model.TaskList;
import com.maven.model.Task;
import com.maven.model.User;
import com.maven.model.SquirrelConstants;
import com.maven.Controller.DataHandler;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.BorderLayout;

/**
 *
 * @author Regory Gregory
 */
public class ListEntry extends HorizontalBar{
    public ListEntry (SubTask tal){
    
    super();
    String type = (tal instanceof TaskList)? "TASKLIST": (tal instanceof Task)?"TASK": "SUBTASK";
    //this.setLayout(new GridLayout(1,0));
    //if(type.equals("SUBTASK")) javax.swing.JOptionPane.showMessageDialog(null, tal.getID());
    //this.setSize(new Dimension(700, 100));
    //this.setPreferredSize(new Dimension(700, 100));
    
    //this.setLayout(new GridLayout(1,0));
    this.setPreferredSize(new Dimension(900, 100));
    this.setLayout(new GridLayout(1,0));
    JLabel title = new ListEntryLabel("<html>"+tal.getTitle()+"</html>");

    JLabel userName = new ListEntryLabel("<html>"+tal.getUser().getUserName()+"</html>");

    JLabel priorirty = new ListEntryLabel(Integer.toString(tal.getPriorityOrder()));
    JLabel date = new ListEntryLabel(tal.getDateDueString());
    
    ActionAreaCheckbox done = new ActionAreaCheckbox();
           done.setSelected(tal.isCompleted());   
           done.setActionCommand("DONE:"+type+":"+tal.getID());
           done.setHorizontalAlignment(JLabel.CENTER);

      this.add(done);  
      this.add(title);
      this.add(date);
      this.add(userName);
      this.add(priorirty);
      this.add(new ActionButtonContainer(tal, type));
      this.setBorder(SquirrelConstants.getListEntryButtonBorder());

    }
    
    private class ActionButtonContainer extends JPanel
    {
        private ActionButtonContainer(SubTask tal, String type)
        {
        super();
        this.setLayout(new GridLayout(0,1));
        ActionAreaButton view = new ListEntryButton("view");
                        view.setActionCommand("VIEW:"+type+":"+tal.getID());
                        this.add(view);
        if(DataHandler.getLoggedIn().getUserLevel() != 0)
        {
            ActionAreaButton edit = new ListEntryButton("edit");
                     edit.setActionCommand("EDIT:"+type+":"+tal.getID());
                     this.add(edit);
        }
        if(DataHandler.getLoggedIn().getUserLevel() == 2){
            ActionAreaButton delete = new ListEntryButton("delete");
                     delete.setActionCommand("DELETE:"+type+":"+tal.getID());
                     this.add(delete);
        }
        

        }
    }  
    
       private class ListEntryButton extends ActionAreaButton
    {
        public ListEntryButton(String label)
        {
            super(label);
            this.setMargin(SquirrelConstants.getFilterBarButton());
            this.setBackground(SquirrelConstants.getColorDanger());
        }
        
        
    }
    private class ListEntryLabel extends JLabel
    {
        public ListEntryLabel(String label)
        {
        super(label);
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setHorizontalTextPosition(JLabel.CENTER);
        this.setVerticalTextPosition(JLabel.BOTTOM);
        this.setBorder(SquirrelConstants.getListEntryLabelBorder());
        }
    
    }   
    
}