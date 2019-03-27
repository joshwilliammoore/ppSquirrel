/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.view.RightSideElements;
import javax.swing.JPanel;


import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Component;
/**
 *
 * @author Regory Gregory
 */
public class HorizontalBar extends JPanel{
    
    private Dimension dim;
    private GridBagConstraints gbc; 
    private static HorizontalBar instance = null;

    protected HorizontalBar()
    {
        super();
   
        this.setLayout(new GridBagLayout());
        this.gbc = new GridBagConstraints();
    }

    
    public Dimension getDim() {
        return dim;
    }

    public void setDim(Dimension dim) {
        this.dim = dim;
    }

    public GridBagConstraints getGbc() {
        return gbc;
    }

    public void setGbc(GridBagConstraints gbc) {
        this.gbc = gbc;
    }
    public static HorizontalBar getInstance()
    {
    if(instance == null) instance = new HorizontalBar();    
    return instance;
    }
  
    public static void reFresh(Component c)
    {
    instance.removeAll();
    instance.add(c);    
    instance.revalidate();
    instance.repaint();
    }
    
    
}
