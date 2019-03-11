/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.view.UIElements;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout ;
import javax.swing.JPanel;
import com.maven.view.ReFreshable;
import com.maven.model.TaskList;

import com.maven.view.RightSideElements.HorizontalBar;
import javax.swing.JOptionPane;
/**
 *
 * @author Regory Gregory
 */
public class TaskListsView{
    private static JPanel viewport;    
    private static JScrollPane instance = null;
    
    private TaskListsView()
    {
    
    }
    
    public static JScrollPane getInstance()
    {
        if(instance == null){
            instance = new JScrollPane();
            instance.setLayout(new ScrollPaneLayout());

            instance.setMinimumSize(new Dimension(700,380));
        }
    
        return instance;
    }
    
      public static void resetInstance()
    {
      
            instance = new JScrollPane();
            instance.setLayout(new ScrollPaneLayout());

            instance.setMinimumSize(new Dimension(700,380));
  
    }
    
    public static JPanel getViewport()
    {
        if(viewport == null){
            viewport = new JPanel();
            viewport.setLayout(new GridLayout(0,1)); 
            viewport.setMinimumSize(new Dimension(700,380));
                        //viewport.setMinimumSize(new Dimension(700,1000));

        }
        return viewport;
    }
    
    public static void reFresh(TaskList[] taskLists)
    {
    getInstance();
    resetInstance();
    //instance.removeAll();
    if(taskLists !=null)
    {
        
        getViewport().removeAll();
        
    for(TaskList t : taskLists)
    {
    TaskListEntry temp = new TaskListEntry(t);
    viewport.add(temp);
    }
    
    instance.setViewportView(viewport);
    instance.revalidate();
    instance.repaint();
    
    }    

    }
  

}
