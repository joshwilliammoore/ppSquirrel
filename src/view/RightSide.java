/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import view.RightSideElements.HorizontalBar;
import view.RightSideElements.ActionArea;
import view.RightSideElements.TitleBar;
import view.RightSideElements.ActionBar;
import view.RightSideElements.MessageBar;

import model.SquirrelConstants;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import javax.swing.JOptionPane;
/**
 *
 * @author Regory Gregory
 */
public class RightSide extends GeneralPanel{
    private static RightSide instance = null;
    private static HorizontalBar[] bars= new HorizontalBar[3];
    private static HorizontalBar actionBar;
    private static HorizontalBar workingArea;
    public RightSide()
    {
        super(SquirrelConstants.getRightSideWidth(), SquirrelConstants.getInnerPaneHeight());
      
        
        this.setBackground(Color.YELLOW);
        //this.setBackground(SquirrelConstants.getRightSideBg());
       
        
        this.getGbc().fill = GridBagConstraints.HORIZONTAL;
        this.getGbc().gridx=0;
        this.getGbc().gridy=0;
        this.getGbc().gridwidth=1;
        this.getGbc().gridheight = 5;
        
        this.add (TitleBar.getInstance(), this.getGbc());
        
        this.getGbc().gridx=0;
        this.getGbc().gridy=5;
        this.getGbc().gridheight = 15;
                

        this.add (MessageBar.getInstance(), this.getGbc());
        
        this.getGbc().gridx=0;
        this.getGbc().gridy=20;
        this.getGbc().gridheight =10;
        //JOptionPane.showMessageDialog(null, this.getGbc().gridheight);
        this.add (ActionBar.getInstance(), this.getGbc());
        
        
        this.getGbc().gridx=0;
        this.getGbc().gridy=30;
        this.getGbc().gridheight =30;
        //JOptionPane.showMessageDialog(null, this.getGbc().gridheight);
        this.add (ActionArea.getInstance(), this.getGbc());
       // ActionArea.getInstance().add(AddTaskForm.getInstance());
//        for(int i =0; i<this.bars.length; i++ )
//        {
//        HorizontalBar temp = this.bars[i];
//        this.gbc.gridx=0;
//        
//        this.gbc.gridy= offset;
//        
//        this.gbc.gridheight=temp.getpHeight()/10;
//        
//        
//        this.add(temp, this.gbc);
//        
//        offset+=temp.getpHeight()/10;
//        }
       
        
     
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
