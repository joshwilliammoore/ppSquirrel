/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
/**
 *
 * @author Regory Gregory
 */
public class GeneralPanel extends JPanel{

   
   

    private  int width;
    private  int height;
    private Dimension dim;
    protected GridBagConstraints gbc;
   
    public GeneralPanel(int width, int height)
    {
        super();
        this.setLayout(new GridBagLayout());
        this.setGbc(new GridBagConstraints());
        setWidth(width);
        setHeight(height);
        Dimension d = new Dimension(getWidth(), getHeight()); 
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
  
     
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public GridBagConstraints getGbc() {
        return gbc;
    }

    public void setGbc(GridBagConstraints gbc) {
        this.gbc = gbc;
    }
    
    
}
