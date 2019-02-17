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
        
        JLabel labelTitle = new JLabel("Title of the "+tag);
        
        this.add(labelTitle);
        
        JTextField titleInput = new JTextField();
        
        this.add(titleInput);
        
        JLabel labelDescription = new JLabel("Description of the "+tag);
        
        this.add(labelDescription);
        
        JTextArea descriptionInput = new JTextArea();
        
        this.add(descriptionInput);
        
        JLabel labelPriority = new JLabel("Priority of the "+tag);
        
        this.add(labelPriority);
        
        Integer[] priority = {1,2,3,4,5};
        JComboBox priorityDropdown = new JComboBox(priority);
        
        this.add(priorityDropdown);
        
        JLabel labelAssignee = new JLabel("Assignee for the "+tag);
        
        this.add(labelAssignee);

        
        String[] assignees = {"John", "Fred", "Sally", "Paul", "Josh"};
        JComboBox assigneeDropdown = new JComboBox(assignees);
        
         this.add(assigneeDropdown);
         
         JLabel labelDueDate = new JLabel("DueDate of "+tag);
        
        this.add(labelDueDate);
        
        JTextField dueDateInput = new JTextField();
        
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
