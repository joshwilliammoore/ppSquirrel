/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.RightSideElements;

import java.awt.Color;
import view.RightSideElements.HorizontalBar;
import java.awt.Dimension;

/**
 *
 * @author Regory Gregory
 */
public class MessageBar extends HorizontalBar{
    private static MessageBar instance = null;
    
    protected MessageBar()
    {
        super();
          this.setDim(new Dimension(700, 150));
        this.setSize(this.getDim());
        this.setPreferredSize(this.getDim());
        this.setBackground(Color.ORANGE);

    
    }
    
    public static MessageBar getInstance()
    {
    if(instance == null) instance = new MessageBar();
    
    return instance;
    }
}
