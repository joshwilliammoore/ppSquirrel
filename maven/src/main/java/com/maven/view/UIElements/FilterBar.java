/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.view.UIElements;
import javax.swing.JPanel;
import com.maven.view.RightSideElements.HorizontalBar;
import com.maven.model.SubTask;
import com.maven.model.Task;
import com.maven.model.TaskList;


import java.awt.GridLayout;
/**
 *
 * @author Regory Gregory
 */
public class FilterBar extends JPanel{

    public FilterBar()
    {
    super();
    this.setLayout(new GridLayout(1,0));
    
   
    ActionAreaButton byName = new ActionAreaButton("Title");  
                     byName.setActionCommand("FILTER:TITLE");   
    ActionAreaButton byDate = new ActionAreaButton("Date");
                     byDate.setActionCommand("FILTER:DATE");  
    ActionAreaButton byPerson = new ActionAreaButton("Assignee");
                     byPerson.setActionCommand("FILTER:ASSIGNEE");  
    ActionAreaButton byPriority = new ActionAreaButton("Priority");
                     byPriority.setActionCommand("FILTER:PRIORITY:"); 
                    
    this.add(byName);  
    this.add(byDate); 
    this.add(byPerson); 
    this.add(byPriority); 
    }

    
    
}
