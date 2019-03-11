/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.view;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
/**
 *
 * @author Regory Gregory
 */
public class GeneralPanel extends JPanel{
    private Dimension dim;
    protected GridBagConstraints gbc;
   
    public GeneralPanel(int pwidth, int pheight)
    {
        super();
        this.setLayout(new GridBagLayout());
        this.setGbc(new GridBagConstraints());
        this.gbc.fill=GridBagConstraints.BOTH;

        Dimension d = new Dimension( pwidth, pheight); 
        this.setDim(d);
        this.setSize(this.getDim());
        this.setPreferredSize(this.getDim());
       
        
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
    
    
}
