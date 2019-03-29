/*
General panel that was inteded to be the parent of all UI panels
However, during the development several of the children have been updated
and specilised
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
