/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.view;
import com.maven.view.RightSideElements.HorizontalBar;
import com.maven.view.RightSideElements.ActionArea;
import com.maven.view.RightSideElements.TitleBar;
import com.maven.view.RightSideElements.ActionBar;
import com.maven.view.RightSideElements.MessageBar;

import com.maven.model.SquirrelConstants;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import javax.swing.JOptionPane;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
/**
 *
 * @author Regory Gregory
 */
public class RightSide extends GeneralPanel{
    private static RightSide instance = null;
   
    
    public RightSide()
    {
        super(SquirrelConstants.getRightSideWidth(), SquirrelConstants.getInnerPaneHeight());
      
        this.setLayout(new BorderLayout());
        this.setBackground(Color.YELLOW);
        this.setBackground(SquirrelConstants.getRightSideBg());
       
        
        this.getGbc().fill = GridBagConstraints.HORIZONTAL;
        this.getGbc().gridx=0;
        this.getGbc().gridy=0;
        this.getGbc().gridwidth=1;
        this.getGbc().gridheight = 5;
        
        this.add (TitleBar.getInstance(),BorderLayout.NORTH);
        
        this.add (MessageBar.getInstance(), BorderLayout.CENTER);

        this.add (ActionBar.getInstance(), BorderLayout.SOUTH);
//        this.getGbc().gridx=0;
//        this.getGbc().gridy=30;
//        this.getGbc().gridheight =30;
////        //JOptionPane.showMessageDialog(null, this.getGbc().gridheight);
//        this.add (ActionArea.getInstance(), BorderLayout.CENTER);
//       // ActionArea.getInstance().add(AddTaskForm.getInstance());
////        for(int i =0; i<this.bars.length; i++ )
////        {
////        HorizontalBar temp = this.bars[i];
////        this.gbc.gridx=0;
////        
////        this.gbc.gridy= offset;
////        
////        this.gbc.gridheight=temp.getpHeight()/10;
////        
////        
////        this.add(temp, this.gbc);
////        
////        offset+=temp.getpHeight()/10;
////        }
       
        
     
    }
    
        //making it a singleton class

    public static  RightSide getInstance()
    {
    if(instance==null)
    {
        instance = new RightSide();
    }

        return instance;
    }
   
}
