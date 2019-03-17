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
import java.awt.BorderLayout;

import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import javax.swing.JButton;
/**
 *
 * @author Regory Gregory
 */
public class ListEntry extends HorizontalBar{


    public ListEntry (SubTask tal){
    
    super();
    String type = (tal instanceof TaskList)? "TASKLIST": (tal instanceof Task)?"TASK": "SUBTASK";
    //if(type.equals("SUBTASK")) javax.swing.JOptionPane.showMessageDialog(null, tal.getID());
    this.setSize(new Dimension(700, 100));
    this.setPreferredSize(new Dimension(700, 100));
    
    
    JLabel title = new JLabel(tal.getTitle());
    JLabel space = new JLabel("               ");
    JLabel space1 = new JLabel("               ");
    JLabel space2 = new JLabel("               ");
//    JLabel userName = new JLabel(tal.getTaskManager().getSurname());
    JLabel userName = new JLabel(tal.getAssignee().getUserName());

//    JLabel priorirty = new JLabel(Integer.toString(tal.getPriority()));#
    JLabel priorirty = new JLabel(Integer.toString(tal.getPriority()));

    JLabel date = new JLabel(tal.getStringDate("dueDate"));
    
    ActionAreaButton view = new ActionAreaButton("view");
                        view.setActionCommand("VIEW:"+type+":"+tal.getID());
    ActionAreaButton edit = new ActionAreaButton("edit");
                     edit.setActionCommand("EDIT:"+type+":"+tal.getID());
    ActionAreaButton delete = new ActionAreaButton("delete");
                     delete.setActionCommand("DELETE:"+type+":"+tal.getID());
    ActionAreaCheckbox done = new ActionAreaCheckbox();
                     done.setSelected(tal.isCompleted());   
                     done.setActionCommand("DONE:"+type+":"+tal.getID());                    
   
    this.getGbc().fill=GridBagConstraints.HORIZONTAL;
    this.getGbc().gridx=0;
    this.getGbc().gridy=0;
    this.getGbc().gridwidth=1;
    this.getGbc().gridheight=1;
    this.add(title, this.getGbc());
    
    this.getGbc().gridx=0;
    this.getGbc().gridy=1;
    this.getGbc().gridwidth=1;
    this.add(userName, this.getGbc());
    
    this.getGbc().gridx=1;
    this.getGbc().gridy=1;
    this.getGbc().gridwidth=1;
    this.add(space1, this.getGbc());
    
    this.getGbc().gridx=2;
    this.getGbc().gridy=1;
    this.getGbc().gridwidth=1;
    this.add(priorirty, this.getGbc());
    
    this.getGbc().gridx=3;
    this.getGbc().gridy=1;
    this.getGbc().gridwidth=1;
    this.add(space2, this.getGbc());
    
    this.getGbc().gridx=4;
    this.getGbc().gridy=1;
    this.getGbc().gridwidth=1;
    this.add(date, this.getGbc());
    
    this.getGbc().gridx=5;
    this.getGbc().gridy=1;
    this.getGbc().gridwidth=1;
    this.add(space, this.getGbc());
    
    this.getGbc().gridx=6;
    this.getGbc().gridy=0;
    this.getGbc().gridwidth=1;
    this.getGbc().gridheight=2;

    this.add(view, this.getGbc());
    
    this.getGbc().gridx=7;
    this.getGbc().gridy=0;
    this.getGbc().gridwidth=1;
    this.getGbc().gridheight=2;

    this.add(edit, this.getGbc());
    
     
    this.getGbc().gridx=8;
    this.getGbc().gridy=0;
    this.getGbc().gridwidth=1;
    this.getGbc().gridheight=2;

    this.add(delete, this.getGbc());
    this.getGbc().gridx=9;
    this.add(done, this.getGbc());
    
    
    } 
    
}
