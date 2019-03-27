/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.view;
import com.maven.view.RightSideElements.ActionArea;
import com.maven.view.RightSideElements.ActionBar;
import com.maven.view.RightSideElements.MessageBar;

import com.maven.model.SquirrelConstants;
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
        this.setBackground(SquirrelConstants.getRightSideBg());
       
        
        
        
        this.add (MessageBar.getInstance(), BorderLayout.NORTH);
        this.add(ActionArea.getInstance(), BorderLayout.CENTER);
        this.add (ActionBar.getInstance(), BorderLayout.SOUTH);
 
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
