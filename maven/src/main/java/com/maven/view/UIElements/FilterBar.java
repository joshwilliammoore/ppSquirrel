/*
 *This class is a component part of a JSCrollPane used to show the list of
Tasklists, tasks and subtasks.
Clicking on one element sorts the tasklist according to the clicked button
 */
package com.maven.view.UIElements;

import javax.swing.JPanel;
import java.awt.GridLayout;
import com.maven.model.SquirrelConstants;
/**
 *
 * @author Regory Gregory
 */
public class FilterBar extends JPanel{

    public FilterBar()
    {
    super();
    this.setLayout(new GridLayout(1,0));
    
    
   
    ActionAreaButton byDone = new FilterBarButton("Done");  
                     byDone.setActionCommand("FILTER:DONE");
                     
    ActionAreaButton byName = new FilterBarButton("Title");  
                     byName.setActionCommand("FILTER:TITLE");  
                     
    ActionAreaButton byDate = new FilterBarButton("Date");
                     byDate.setActionCommand("FILTER:DATE"); 
                     
    ActionAreaButton byPerson = new FilterBarButton("Assignee");
                     byPerson.setActionCommand("FILTER:ASSIGNEE");
                     
    ActionAreaButton byPriority = new FilterBarButton("Priority Order");
                     byPriority.setActionCommand("FILTER:PRIORITY");
                     
    ActionAreaButton actions = new FilterBarButton("Actions");
                     actions.setActionCommand("DISABLED:DISABLED");
    
                     
    this.add(byDone);          
    this.add(byName);  
    this.add(byDate); 
    this.add(byPerson); 
    this.add(byPriority);
    this.add(actions);
 
    
    }
    
    private class FilterBarButton extends ActionAreaButton
    {
        public FilterBarButton(String label)
        {
            super(label);
            this.setMargin(SquirrelConstants.getFilterBarButton());
        }
        
        
    }
   

    
    
}
