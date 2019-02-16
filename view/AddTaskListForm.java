/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.awt.Component;
import javax.swing.JComboBox;


import javax.swing.JLabel;
/**
 *
 * @author Regory Gregory
 */
public class AddTaskListForm extends AddTaskForm{
    private static AddTaskListForm instance = null;
    
    protected AddTaskListForm(){
        
        super();
       
        
        JLabel labelManager = new JLabel("Manager for the "+this.getTag());
        
        this.add(labelManager);
        
        
        String[] manager = {"John", "Fred", "Sally", "Paul", "Josh"};
        JComboBox managerDropdown = new JComboBox(manager);
        this.add(managerDropdown);
    }
    
    public static AddTaskListForm getInstance()
    {
        if(instance==null) instance = new AddTaskListForm();
        return instance;
    
    }
    
    
}
