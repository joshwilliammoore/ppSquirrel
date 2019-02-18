/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.UIElements;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;


import view.ReFreshable;
import model.TaskList;

import view.RightSideElements.HorizontalBar;
/**
 *
 * @author Regory Gregory
 */
public class TaskListView extends HorizontalBar{
        
    private static TaskListView instance = null;
    private TaskListView()
    {
    super();
    this.setLayout(new GridLayout(0, 1));
//    this.setSize(new Dimension(700, 400));
//    this.setPreferredSize(new Dimension(700, 400));
    }
    public static TaskListView getInstance()
    {
    if(instance == null)instance = new TaskListView();
    return instance;
    }
    public void reFresh(TaskList[] taskLists)
    {
    instance.removeAll();
    for(TaskList t : taskLists)
    {
    TaskListEntry temp = new TaskListEntry(t);
    this.add(temp);
    }
    
    
    
//    instance.revalidate();
//    instance.repaint();
    }
  

}
