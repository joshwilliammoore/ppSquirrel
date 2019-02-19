/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.UIElements;

import view.RightSideElements.HorizontalBar;

import model.TaskList;
import model.User;

import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
/**
 *
 * @author Regory Gregory
 */
public class TaskListEntry extends HorizontalBar{
    public TaskListEntry (TaskList tal){
    super();
    this.setSize(new Dimension(700, 100));
    this.setPreferredSize(new Dimension(700, 100));
    
    
    JLabel title = new JLabel(tal.getTitle());
//    JLabel userName = new JLabel(tal.getTaskManager().getSurname());
    JLabel userName = new JLabel("HardCoded John");

//    JLabel priorirty = new JLabel(Integer.toString(tal.getPriority()));#
    JLabel priorirty = new JLabel("Hardcoded Priority");

    JLabel date = new JLabel(tal.getStringDate("dueDate"));
    
    ActionAreaButton view = new ActionAreaButton("view");
                     view.setActionCommand("VIEW:TASKLIST:"+tal.getID());
    ActionAreaButton edit = new ActionAreaButton("edit");
                      view.setActionCommand("EDIT:TASKLIST:"+tal.getID());
    ActionAreaButton delete = new ActionAreaButton("delete");
                     delete.setActionCommand("DELETE:TASKLIST:"+tal.getID());   
    this.getGbc().fill=GridBagConstraints.HORIZONTAL;
    this.getGbc().gridx=0;
    this.getGbc().gridy=0;
    this.getGbc().gridwidth=3;
    this.getGbc().gridheight=1;
    this.add(title, this.getGbc());
    
    this.getGbc().gridx=0;
    this.getGbc().gridy=1;
    this.getGbc().gridwidth=1;
    this.add(userName, this.getGbc());
    
     this.getGbc().gridx=1;
    this.getGbc().gridy=1;
    this.getGbc().gridwidth=1;
    this.add(priorirty, this.getGbc());
    
    this.getGbc().gridx=2;
    this.getGbc().gridy=1;
    this.getGbc().gridwidth=1;
    this.add(date, this.getGbc());
    
    this.getGbc().gridx=3;
    this.getGbc().gridy=0;
    this.getGbc().gridwidth=1;
    this.getGbc().gridheight=2;

    this.add(view, this.getGbc());
    
    this.getGbc().gridx=4;
    this.getGbc().gridy=0;
    this.getGbc().gridwidth=1;
    this.getGbc().gridheight=2;

    this.add(edit, this.getGbc());
    
     
    this.getGbc().gridx=5;
    this.getGbc().gridy=0;
    this.getGbc().gridwidth=1;
    this.getGbc().gridheight=2;

    this.add(delete, this.getGbc());
    
    } 
}
