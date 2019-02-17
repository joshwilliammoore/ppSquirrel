/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.UIElements;
import view.RightSideElements.HorizontalBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.ScrollPaneLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;


/**
 *
 * @author Regory Gregory
 */
public class AddTaskForm extends HorizontalBar{
    private String tag = "task";
    
    private static AddTaskForm instance;
    
    protected AddTaskForm()
    {
        super();
        //will have to parameterize!!!
        this.setDim( new Dimension(350, 380));
        this.setLayout(new GridLayout(0,2));
        this.setSize(this.getDim());
        this.setPreferredSize(this.getDim());
        this.setBackground(Color.GREEN);
        
        
        //Title
        JLabel labelTitle = new JLabel("Title of the "+tag);
        
        this.add(labelTitle);
        
        FormField titleInput = new FormField();
        
        titleInput.setLabel("title");
        
        this.add(titleInput);
        
       //Description

        JLabel labelDescription = new JLabel("Description of the "+tag);
        
        this.add(labelDescription);
        
        FormArea descriptionInput = new FormArea();
        descriptionInput.setLabel("description");
        this.add(descriptionInput);
        
        //Priority

        
        JLabel labelPriority = new JLabel("Priority of the "+tag);
        
        this.add(labelPriority);
        
        Integer[] priority = {1,2,3,4,5};
        FormCombo priorityDropdown = new FormCombo(priority);
                  priorityDropdown.setLabel("priority");  
        this.add(priorityDropdown);
        
        
        //Assignee

        JLabel labelAssignee = new JLabel("Assignee for the "+tag);
        
        this.add(labelAssignee);

        
        String[] assignees = {"John", "Fred", "Sally", "Paul", "Josh"};
        FormCombo assigneeDropdown = new FormCombo(assignees);
                    assigneeDropdown.setLabel("staff");
         this.add(assigneeDropdown);
         
         //Due date 
         JLabel labelDueDate = new JLabel("DueDate of "+tag);
        
        this.add(labelDueDate);
        
        FormField dueDateInput = new FormField();
                  dueDateInput.setLabel("dateDue");  
        this.add(dueDateInput);
        
        
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
    public static AddTaskForm getInstance()
    {
        if(instance == null ) instance = new AddTaskForm();
        return instance;
    }
    
}
