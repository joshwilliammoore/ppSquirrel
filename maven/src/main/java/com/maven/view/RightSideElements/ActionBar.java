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
import com.maven.Controller.ActionButtonController;

import com.maven.view.UIElements.ActionBarButton;
import com.maven.view.UIElements.FormCombo;

import com.maven.Controller.Filters;
/**
 *
 * @author Regory Gregory
 */
public class ActionBar extends HorizontalBar{
    
    private int pHeight = SquirrelConstants.getActionBarHeight();
    private String hexaColor = SquirrelConstants.getActionBarBackground();
    
    private static ActionBar instance = null;
    private JTextField searchField;
    private FormCombo searchOption;
    
    
    public ActionBar()
    {
        super();
        this.setDim(new Dimension(700, 100));
        this.setPreferredSize(this.getDim());
        this.setBackground(SquirrelConstants.getActionBarColour());
        this.searchField = new JTextField();
        
        String[] searchOptions = {"TITLE", "ASSIGNEE", "PRIORITY", "DUE_DATE", "DESCRIPTION"};
        
        this.searchOption = new FormCombo(searchOptions);
        
    }
    public static ActionBar getInstance()
    {
    if(instance == null) instance = new ActionBar();
    return instance;
    }
    
    public static  void SearchResultsBar(String source, ActionButtonController listener, int parentID)
    {
        instance.removeAll();
        instance.getGbc().fill = GridBagConstraints.HORIZONTAL;

        instance.getGbc().gridx=0;
        instance.getGbc().gridy=0;
        instance.getGbc().gridwidth=2;
        instance.getGbc().gridheight=1;
        
        ActionBarButton jb = new ActionBarButton("Back");

                        jb.setActionCommand("CANCEL:"+source+":"+parentID);
                        
        jb.addActionListener(listener);
              
        instance.add(jb, instance.getGbc());
        
        instance.revalidate();
        instance.repaint();
        
    
    }
    
    public static  void DefaultBar(String source, ActionButtonController listener, int parentID)
    {
        instance.removeAll();
        instance.getGbc().fill = GridBagConstraints.BOTH;

        instance.getGbc().gridx=0;
        instance.getGbc().gridy=0;
        instance.getGbc().gridheight=1;
        instance.getGbc().ipadx=25;
        
        //this is just testing it. This whole section is basically hardcoded, so it will have to be rewritten.
       
        JTextField jtf = instance.getSearchField();
                   jtf.setText("Type your search query here..."); 
        jtf.setSize(new Dimension(300, 50));
        jtf.setPreferredSize(new Dimension(300, 50));

        instance.getGbc().gridx = 0;
        instance.getGbc().gridwidth = 3;
        instance.add(jtf, instance.getGbc());        
        
        instance.getGbc().gridx=4;
        instance.getGbc().gridwidth = 2;
        instance.add(instance.getSearchOption(), instance.getGbc());
        
         ActionBarButton jb2 = new ActionBarButton("Search");
                         
         
        jb2.setActionCommand("SEARCH:"+source+":"+parentID);
        jb2.addActionListener(listener);
                        
        instance.getGbc().gridx=6;
        instance.add(jb2, instance.getGbc());
        
        
        ActionBarButton jb = new ActionBarButton("Add new "+Filters.returnRelative(source, true));

                        jb.setActionCommand("NEW:"+Filters.returnRelative(source, true)+":"+parentID);
                        
                        jb.addActionListener(listener);
                        jb.setBackground(SquirrelConstants.getColorDanger());
       instance.getGbc().gridx = 9;

        instance.add(jb, instance.getGbc());
   
        
        if(!source.equals("TASKLISTS"))
        {
                    //JOptionPane.showMessageDialog(null, "ejj: "+source);

        instance.getGbc().gridx = 11;
        instance.getGbc().gridwidth = 2;  
        
        ActionBarButton jCancel = new ActionBarButton("Go back");
        jCancel.addActionListener(listener);
        jCancel.setActionCommand("CANCEL:"+Filters.returnRelative(source, false)+":"+parentID);
        instance.add(jCancel, instance.getGbc());
        }
        instance.revalidate();
        instance.repaint();
        
    
    }
  
    public static void  addNewBar(String source, 
            ActionButtonController listener, int parentID)
    {
        //type = TASKLIST/TASK/SUBTASK
        instance.removeAll();
   
        instance.getGbc().fill = GridBagConstraints.HORIZONTAL;
        instance.getGbc().gridx=0;
        instance.getGbc().gridy=0;
        instance.getGbc().gridwidth=2;
        instance.getGbc().gridheight=1;
        instance.getGbc().ipadx=25;
        //this is just testing it. This whole section is basically hardcoded, so it will have to be rewritten.
        ActionBarButton jSave = new ActionBarButton("Save "+source);
        jSave.setActionCommand("SAVE:"+source+":"+parentID);
        jSave.addActionListener(listener);
           
        ActionBarButton jCancel = new ActionBarButton("Cancel");
        jCancel.addActionListener(listener);

        jCancel.setActionCommand("CANCEL:"+Filters.returnRelative(source, false)+":"+parentID);
//        JOptionPane.showMessageDialog(null, source);
        instance.add(jSave, instance.getGbc());
        
       
        instance.getGbc().gridx=2;
        instance.add(jCancel, instance.getGbc());
        
        instance.revalidate();
        instance.repaint();
    
    
    }
    
    
    public static void editBar(String source, 
    ActionButtonController listener, int parentID)
    {
            instance.removeAll();
   
        instance.getGbc().fill = GridBagConstraints.HORIZONTAL;
        instance.getGbc().gridx=0;
        instance.getGbc().gridy=0;
        instance.getGbc().gridwidth=2;
        instance.getGbc().gridheight=1;
        //this is just testing it. This whole section is basically hardcoded, so it will have to be rewritten.
        ActionBarButton jSave = new ActionBarButton("Save changes for "+source);
        jSave.setActionCommand("UPDATE:"+source+":"+parentID);
        jSave.addActionListener(listener);
           
        ActionBarButton jCancel = new ActionBarButton("Cancel");
        jCancel.addActionListener(listener);

        jCancel.setActionCommand("CANCEL:"+Filters.returnRelative(source, false)+":"+parentID);
//        JOptionPane.showMessageDialog(null, source);
        instance.add(jSave, instance.getGbc());
        
       
        instance.getGbc().gridx=2;
        instance.add(jCancel, instance.getGbc());
        
        instance.revalidate();
        instance.repaint();

        
    }

    public JTextField getSearchField() {
        return searchField;
    }

    public void setSearchField(JTextField searchField) {
        this.searchField = searchField;
    }

    public FormCombo getSearchOption() {
        return searchOption;
    }

    public void setSearchOption(FormCombo searchOption) {
        this.searchOption = searchOption;
    }
    
    
    
}
