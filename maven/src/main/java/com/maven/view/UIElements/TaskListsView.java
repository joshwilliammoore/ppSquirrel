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
import com.maven.model.SubTask;

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

        }
    
        return instance;
    }

    public static JPanel getViewport()
    {
        if(viewport == null){
            viewport = new JPanel();
            viewport.setLayout(new GridLayout(0,1)); 
            viewport.setMinimumSize(new Dimension(680,380));
        }
        return viewport;
    }
    
    public static void reFresh(SubTask[] taskLists)
    {
    getInstance();
    getViewport().removeAll();

    //instance.removeAll();
    if(taskLists !=null)
    {
        for(SubTask t : taskLists)
        {
        TaskListEntry temp = new TaskListEntry(t);
        viewport.add(temp);
        }
    
    }   
    
    instance.setViewportView(viewport);
    instance.revalidate();
    instance.repaint();

    }
  

}
