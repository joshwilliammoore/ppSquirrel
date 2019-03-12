/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.view.UIElements;

import com.maven.model.SubTask;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;

/**
 *
 * @author Regory Gregory
 */
public class ListView {
     private static JPanel viewport;    
    private static JScrollPane instance = null;
    
    private ListView()
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
            
            
            
            
        ListEntry temp = new ListEntry(t);
        viewport.add(temp);
        }
    
    }   
    
    instance.setViewportView(viewport);
    instance.revalidate();
    instance.repaint();

    }
}
