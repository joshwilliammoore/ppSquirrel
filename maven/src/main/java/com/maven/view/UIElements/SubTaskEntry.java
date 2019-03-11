/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.view.UIElements;

import com.maven.model.SubTask;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import com.maven.model.Task;
import com.maven.view.RightSideElements.HorizontalBar;

/**
 *
 * @author joshw
 */
public class SubTaskEntry extends HorizontalBar {
    public SubTaskEntry(SubTask tal){
        super();
        this.setSize(new Dimension(700, 100));
        this.setPreferredSize(new Dimension(700, 100));
        
        JLabel title = new JLabel(tal.getTitle());
        JLabel description = new JLabel(tal.getDescription());
        //JLabel priority = new JLabel(tal.getPriority());
        JLabel dueDate = new JLabel(tal.getDateDueString());
        
        ActionAreaButton edit = new ActionAreaButton("edit");
        edit.setActionCommand("EDIT:TASK:"+tal.getID());
        ActionAreaButton delete = new ActionAreaButton("delete");
        delete.setActionCommand("DELETE:TASK:"+tal.getID());
        
        this.getGbc().fill=GridBagConstraints.HORIZONTAL;
        this.getGbc().gridx=0;
        this.getGbc().gridy=0;
        this.getGbc().gridwidth=3;
        this.getGbc().gridheight=1;
        this.add(title, this.getGbc());
    
        /*this.getGbc().gridx=1;
        this.getGbc().gridy=1;
        this.getGbc().gridwidth=1;
        this.add(priorirty, this.getGbc());*/
    
        this.getGbc().gridx=2;
        this.getGbc().gridy=1;
        this.getGbc().gridwidth=1;
        this.add(dueDate, this.getGbc());
    
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
