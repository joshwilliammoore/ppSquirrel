/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;

import javax.swing.JOptionPane;
import model.SquirrelConstants;

/**
 *
 * @author Regory Gregory
 */
public class  MainContainerPane extends JPanel{
    private int width = SquirrelConstants.getMainContainerWidth();
    private int height = SquirrelConstants.getMainContainerHeight(); 
    
    private int leftSideWidth = SquirrelConstants.getLeftSideWidth();
    
    private int rightSideWidth = SquirrelConstants.getRightSideWidth();
    
    private int innerPanelHeight = SquirrelConstants.getInnerPaneHeight();
    
    private static  MainContainerPane instance;
    //private int innerElementHeight = SquirrelConstants.
    private  MainContainerPane()
    {
        
        super();
        Dimension size = new Dimension (this.width, this.height);
     
        
         this.setLayout(new GridBagLayout());

         this.setSize(size);
   
        GridBagConstraints  gbc = new GridBagConstraints();
        
        LeftSide leftSide = LeftSide.getInstance();

        gbc.gridx = 0;
        gbc.gridy = 0;
        //this should be made constant later on so the ui will be totally configurable by editing one file
        gbc.gridwidth=1;
        gbc.gridheight =1;
        
        gbc.fill = GridBagConstraints.BOTH;
        //adding left panel
        this.add(leftSide, gbc);
        
        //configuring right panel
        RightSide rightSide = RightSide.getInstance();
        //This doesn't work. WHYYYY?
        gbc.gridx =1;
        gbc.gridy = 0;
        gbc.gridwidth=1;
        gbc.gridheight =1;
       
        this.add(rightSide, gbc);
        //JOptionPane.showMessageDialog(null, rightSide.getWidth());
        
        
       
    }
    public static MainContainerPane getInstance()
    {
        if(instance==null) {
            instance = new  MainContainerPane();
        }
        return instance;
    }
}