/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import model.SquirrelConstants;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
/**
 *
 * @author Regory Gregory
 */
public class HorizontalBar extends JPanel{
    private int width = SquirrelConstants.getRightSideWidth();
    private int height;
    private Dimension dim;
    private GridBagConstraints gbc; 
    private static HorizontalBar instance=null;
    protected HorizontalBar()
    {
        super();
   
        this.setLayout(new GridBagLayout());
        this.gbc = new GridBagConstraints();
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
        if(instance == null)
        {
            instance = new HorizontalBar();
        }
        return instance;
    
    }
    
    
    
}
