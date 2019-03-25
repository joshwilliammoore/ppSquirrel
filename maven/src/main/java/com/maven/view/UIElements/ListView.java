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
import java.util.Arrays;
/**
 *
 * @author Regory Gregory
 */
public class ListView {
    private static JPanel viewport = null;    
    private static JScrollPane instance = null;
    private  static FilterBar columnHeader = null;
    private  static SubTask[] taskLists;
    
    
    private ListView()
    {
 
    
    }
    
    public static JScrollPane getInstance()
    {
        if(instance == null){
            instance = new JScrollPane();
            instance.setLayout(new ScrollPaneLayout());
            ListView.setColumnHeader(new FilterBar());
        }

        return instance;
    }

    public static JPanel getViewport()
    {
        if(viewport == null){
            viewport = new JPanel();
            viewport.setLayout(new GridLayout(0,1)); 
            //viewport.setMinimumSize(new Dimension(680,380));
        }
        return viewport;
    }
    

    
    public static void reFresh(SubTask[] taskLists)
    {
    getInstance();
    getViewport().removeAll();
    ListView.setTaskLists(taskLists);
    //instance.removeAll();
    if(ListView.getTaskLists() !=null)
    {
        for(SubTask t : ListView.getTaskLists())
        {
            if(t.isDeleted()==false)
            {
            ListEntry temp = new ListEntry(t);
            viewport.add(temp);
            }
        
        }
    
    }   
    //instance.setColumnHeaderView(refreshColumnHeader(taskLists));
    instance.setViewportView(viewport);
    instance.setColumnHeaderView(columnHeader);
    instance.revalidate();
    instance.repaint();

    }
    
    public static FilterBar getColumnHeader() {
        return columnHeader;
    }

    public static void setColumnHeader(FilterBar columnHeader) {
        ListView.columnHeader = columnHeader;
    }

    public static SubTask[] getTaskLists() {
        return taskLists;
    }

    public static void setTaskLists(SubTask[] taskLists) {
        ListView.taskLists = taskLists;
    }
    

    
}
