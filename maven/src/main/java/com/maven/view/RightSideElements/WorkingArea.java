/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.view.RightSideElements;

import com.maven.view.RightSideElements.HorizontalBar;
import java.awt.Dimension;
import com.maven.model.SquirrelConstants;
import java.awt.Color;
/**
 *
 * @author Regory Gregory
 */
public class WorkingArea extends HorizontalBar{
    
    private static WorkingArea instance=null;
    
    private WorkingArea()
    {
        super();
        this.setDim(new Dimension(700, 380));
        this.setSize(this.getDim());
        this.setPreferredSize(this.getDim());
        this.setBackground(Color.BLACK);
    }

      
    public static WorkingArea getInstance()
    {
        if(instance == null) instance = new WorkingArea();
        return instance;
    
    }
    
}
