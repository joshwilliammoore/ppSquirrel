/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.view.RightSideElements;
import javax.swing.JButton;
import javax.swing.JTextField;
import com.maven.model.SquirrelConstants;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.GridBagConstraints;
import com.maven.view.UIElements.ActionBarButton;
import com.maven.Controller.ActionButtonController;
import java.awt.event.ActionListener;
/**
 *
 * @author Regory Gregory
 */
public class ActionBar extends HorizontalBar{
    
    private int pHeight = SquirrelConstants.getActionBarHeight();
    private String hexaColor = SquirrelConstants.getActionBarBackground();
    private static ActionBar instance = null;
    
    public ActionBar()
    {
        super();
        this.setDim(new Dimension(700, 100));
        this.setPreferredSize(this.getDim());
        this.setBackground(Color.RED);
        
    }
    public static ActionBar getInstance()
    {
    if(instance == null) instance = new ActionBar();
    return instance;
    }
    
    public static  void DefaultBar(String type, ActionButtonController listener, int id)
    {
        instance.removeAll();
        instance.getGbc().fill = GridBagConstraints.HORIZONTAL;

        instance.getGbc().gridx=0;
        instance.getGbc().gridy=0;
        instance.getGbc().gridwidth=2;
        instance.getGbc().gridheight=1;
        
        //this is just testing it. This whole section is basically hardcoded, so it will have to be rewritten.
        ActionBarButton jb = new ActionBarButton("Add new");

                        jb.setActionCommand("NEW:"+type+":"+id);
                        
        jb.addActionListener(listener);
              
        instance.add(jb, instance.getGbc());
        
        ActionBarButton jb2 = new ActionBarButton("Search");
   
        jb2.setActionCommand("SEARCH:"+type+":TYPE:PHRASE");
        jb2.addActionListener(listener);
                        
        instance.getGbc().gridx=2;
        instance.add(jb2, instance.getGbc());
        
        
        JTextField jtf = new JTextField();
        jtf.setSize(new Dimension(300, 50));
        jtf.setPreferredSize(new Dimension(300, 50));

        instance.getGbc().gridx = 4;
        instance.getGbc().gridwidth = 5;
        instance.add(jtf, instance.getGbc());
        
        instance.revalidate();
        instance.repaint();
    
    
    }
    
    public static void  addNewBar(String type, 
            ActionButtonController listener, int id)
    {
        //type = TASKLIST/TASK/SUBTASK
        instance.removeAll();
   
        instance.getGbc().fill = GridBagConstraints.HORIZONTAL;
        instance.getGbc().gridx=0;
        instance.getGbc().gridy=0;
        instance.getGbc().gridwidth=2;
        instance.getGbc().gridheight=1;
        //this is just testing it. This whole section is basically hardcoded, so it will have to be rewritten.
        ActionBarButton jSave = new ActionBarButton("Save "+type);
                  
        jSave.setActionCommand("SAVE:"+type+":"+id);
        jSave.addActionListener(listener);
           
        ActionBarButton jCancel = new ActionBarButton("Cancel");
        jCancel.addActionListener(listener);
        jCancel.setActionCommand("CANCEL:"+type+":"+id);
        JOptionPane.showMessageDialog(null, type);
        instance.add(jSave, instance.getGbc());
        
       
        instance.getGbc().gridx=2;
        instance.add(jCancel, instance.getGbc());
        
        instance.revalidate();
        instance.repaint();
    
    
    }
}
