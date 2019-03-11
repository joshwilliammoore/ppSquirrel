/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.view.RightSideElements;

import java.awt.Color;
import java.awt.Dimension;
import com.maven.model.SquirrelConstants;
import javax.swing.JOptionPane;

/**
 *
 * @author Regory Gregory
 */
public class TitleBar extends HorizontalBar{
    private int pHeight = SquirrelConstants.getTitleBarHeight();

    private static TitleBar instance = null;
    
    public TitleBar()
    {
        
    super();
    this.setDim(new Dimension(700, 50));
    //this.setMinimumSize(this.getDim());
//    //this.setSize(this.getDim());
    this.setPreferredSize(this.getDim());
    this.setBackground(Color.BLUE);
    }

   
    public static TitleBar getInstance()
    {
    if(instance == null) instance = new TitleBar();
    return instance;
    
    }

    
}
