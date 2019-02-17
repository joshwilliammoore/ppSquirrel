/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.RightSideElements;
import model.SquirrelConstants;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Component;
/**
 *
 * @author Regory Gregory
 */
public class HorizontalBar extends JPanel{
    private int pWidth = SquirrelConstants.getRightSideWidth();
    private int pHeight;
    private Dimension dim;
    private GridBagConstraints gbc; 
    private static HorizontalBar instance = null;
    protected HorizontalBar()
    {
        super();
   
        this.setLayout(new GridBagLayout());
        this.gbc = new GridBagConstraints();
    }

    public int getpWidth() {
        return pWidth;
    }

    public void setpWidth(int pWidth) {
        this.pWidth = pWidth;
    }

    public int getpHeight() {
        return pHeight;
    }

    public void setpHeight(int pHeight) {
        this.pHeight = pHeight;
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
    instance.add(c);    
    instance.revalidate();
    instance.repaint();
    }
    
    
}
