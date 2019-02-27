/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.UIElements;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout ;
import javax.swing.JPanel;
import view.ReFreshable;
import model.TaskList;

import view.RightSideElements.HorizontalBar;
/**
 *
 * @author Regory Gregory
 */
public class TaskListView extends JPanel{
        
    private static JScrollPane instance = null;
    private TaskListView()
    {
    //    this.setSize(new Dimension(700, 400));
    //    this.setPreferredSize(new Dimension(700, 400));
    }
    public static JScrollPane getInstance()
    {
    if(instance == null){
        instance = new JScrollPane();
        instance.setLayout(new ScrollPaneLayout());
        instance.setSize(new Dimension(700,380));
        instance.setPreferredSize(new Dimension(700,380));
        instance.setMinimumSize(new Dimension(700,380));
    }
    
    return instance;
    }
    public static void reFresh(TaskList[] taskLists)
    {
    getInstance();
    //instance.removeAll();
    JPanel viewport = new JPanel();
           viewport.setLayout(new GridLayout(0,1)); 
//           viewport.setSize(new Dimension(700,1000));
//         viewport.setPreferredSize(new Dimension(700,1000));
//             viewport.setMinimumSize(new Dimension(700,1000));
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
